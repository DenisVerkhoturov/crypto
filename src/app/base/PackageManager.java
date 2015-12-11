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

    protected Class type;

    public PackageManager()
    {}

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
    public List<String> getResourceList()
    {
        ArrayList<String> classes = new ArrayList<String>();
        String relativePath = this.workingPath.replace('.', '/');
        URL resource = ClassLoader.getSystemClassLoader().getResource(relativePath);

        if (resource == null)
            throw new RuntimeException("Unexpected problem: No resource for " + relativePath);

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
    private List<String> processDirectory(File directory)
    {

        ArrayList<String> classes = new ArrayList<String>();

        String[] files = directory.list();

        for (String fileName : files) {
            String className = null;

            if (fileName.endsWith(".class"))
                className = this.workingPath + '.' + fileName.substring(0, fileName.length() - 6);

            if (className != null) {

                Class candidate = loadClass(className);

                if (candidate.getGenericSuperclass() == type)
                    classes.add(candidate.getSimpleName());
            }

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
    private List<String> processJarfile(URL resource)
    {
        List<String> classes = new ArrayList<String>();

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

                if (candidate.getGenericSuperclass() == type)
                    classes.add(candidate.getSimpleName());
            }
        }

        return classes;
    }
}
