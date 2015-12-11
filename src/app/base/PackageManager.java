package app.base;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Абстрактный класс Manager, предоставляющий интерфейс работы содержимим пакетов.
 */
public abstract class PackageManager
{
    protected String workingPath;

    public PackageManager(){}

    public PackageManager(String packageName)
    {
        this.workingPath = packageName;
    }

    private Class<?> loadClass(String className)
    {
        try {
            return Class.forName(className);
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException("Unexpected ClassNotFoundException loading class '" + className + "'");
        }
    }

    /**
     * Сканирует пакет на наличие в нем классов.
     */
    public List<Class <?>> getResourceList()
    {
        ArrayList<Class <?>> classes = new ArrayList<Class <?>>();
        String relPath = this.workingPath.replace('.', '/');
        URL resource = ClassLoader.getSystemClassLoader().getResource(relPath);

        if (resource == null)
            throw new RuntimeException("Unexpected problem: No resource for " + relPath);

        if (resource.toString().startsWith("jar:"))
            classes.addAll(processJarfile(resource));

        else
            classes.addAll(processDirectory(new File(resource.getPath())));

        return classes;
    }

    /**
     * Ищет классы в директории в файловой системе.
     *
     * @param directory - директория в файловой системе, в которой осуществляем поиск
     * @return Возвращает лист классов
     */
    private List<Class <?>> processDirectory(File directory)
    {

        ArrayList<Class <?>> classes = new ArrayList<Class <?>>();

        String[] files = directory.list();

        for (String fileName : files) {
            String className = null;

            if (fileName.endsWith(".class"))
                className = this.workingPath + '.' + fileName.substring(0, fileName.length() - 6);

            if (className != null)
                classes.add(loadClass(className));

            File subdirectory = new File(directory, fileName);

            if (subdirectory.isDirectory())
                classes.addAll(processDirectory(subdirectory));
        }

        return classes;
    }

    /**
     * Ищет классы в jar-архиве.
     *
     * @param resource - URL ресурса
     */
    private List<Class <?>> processJarfile(URL resource)
    {
        List<Class <?>> classes = new ArrayList<Class <?>>();

        String relPath = this.workingPath.replace('.', '/');
        String resPath = resource.getPath();
        String jarPath = resPath.replaceFirst("[.]jar[!].*", ".jar").replaceFirst("file:", "");

        JarFile jarFile;

        try {
            jarFile = new JarFile(jarPath);
        } catch (IOException e) {
            throw new RuntimeException("Unexpected IOException reading JAR File '" + jarPath + "'", e);
        }

        Enumeration<JarEntry> entries = jarFile.entries();

        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();

            String entryName = entry.getName();
            String className = null;

            if (entryName.endsWith(".class")
                    && entryName.startsWith(relPath)
                    && entryName.length() > (relPath.length() + "/".length()))
                className = entryName.replace('/', '.').replace('\\', '.').replace(".class", "");

            if (className != null) {

                Class candidate = loadClass(className);

                if (candidate.getGenericSuperclass() == Cipher.class)
                    classes.add(candidate);
            }
        }

        return classes;
    }
}
