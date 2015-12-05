package app;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Класс управляющий алгоритмами шифрования.
 */
public class CipherManager
{
    private String ciphersPath = "app.cipher";

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
     * Сканирует пакет на наличие в нем классов, расширяющих CipherAlgorithm.
     */
    public List<CipherAlgorithm> getCiphersList()
    {
        ArrayList<CipherAlgorithm> classes = new ArrayList<CipherAlgorithm>();
        String relPath = ciphersPath.replace('.', '/');
        URL resource = ClassLoader.getSystemClassLoader().getResource(relPath);

        if (resource == null)
            throw new RuntimeException("Unexpected problem: No resource for " + relPath);
/*

        if (resource.toString().startsWith("jar:"))
            classes.addAll(processJarfile(resource, ciphersPath)); // TODO приведение CipherAlgorithm

        else
            classes.addAll(processDirectory(new File(resource.getPath()), ciphersPath)); // TODO приведение CipherAlgorithm
*/

        return classes;
    }

    /**
     * Ищет классы в директории в файловой системе.
     *
     * @param directory - директория в файловой системе, в которой осуществляем поиск
     * @return Возвращает лист классов
     */
    private List<CipherAlgorithm> processDirectory(File directory)
    {

        ArrayList<CipherAlgorithm> classes = new ArrayList<CipherAlgorithm>();

        String[] files = directory.list();

        for (String fileName : files) {
            String className = null;

            if (fileName.endsWith(".class")) {
                className = ciphersPath + '.' + fileName.substring(0, fileName.length() - 6);
            }

            if (className != null) {
                //classes.add(loadClass(className)); // TODO приведение CipherAlgorithm
            }

            File subdir = new File(directory, fileName);

            if (subdir.isDirectory()) {
                //classes.addAll(processDirectory(subdir, ciphersPath + '.' + fileName)); // TODO приведение CipherAlgorithm
            }
        }

        return classes;
    }

    /**
     * Ищет классы в jar-архиве.
     *
     * @param resource - URL ресурса
     */
    private List<CipherAlgorithm> processJarfile(URL resource)
    {
        List<CipherAlgorithm> classes = new ArrayList<CipherAlgorithm>();

        String relPath = ciphersPath.replace('.', '/');
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
                    && entryName.length() > (relPath.length() + "/".length())) {
                className = entryName.replace('/', '.').replace('\\', '.').replace(".class", "");
            }

            if (className != null) {

                Class candidate = loadClass(className);

                if (candidate.getGenericSuperclass() == CipherAlgorithm.class) {
                    //classes.add((CipherAlgorithm) candidate); // TODO приведение CipherAlgorithm
                }
            }
        }

        return classes;
    }
}
