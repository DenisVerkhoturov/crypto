package app;

import app.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Class for managing cipher classes.
 *
 * Created by Leo.Scream on 29.11.2015.
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
     * Give a package this method returns all classes contained in that package
     */
    public List<Class<?>> getClassesForPackage()
    {
        ArrayList<Class<?>> classes = new ArrayList<Class<?>>();
        String relPath = ciphersPath.replace('.', '/');
        URL resource = ClassLoader.getSystemClassLoader().getResource(relPath);

        if (resource == null)
            throw new RuntimeException("Unexpected problem: No resource for " + relPath);

        if (resource.toString().startsWith("jar:"))
            classes.addAll(processJarfile(resource, ciphersPath));
        else
            classes.addAll(processDirectory(new File(resource.getPath()), ciphersPath));

        return classes;
    }

    /**
     * Given a package name and a directory returns all classes within that directory
     *
     * @param directory
     * @param packName
     * @return Classes within Directory with package name
     */
    private List<Class<?>> processDirectory(File directory, String packName)
    {

        ArrayList<Class<?>> classes = new ArrayList<Class<?>>();

        String[] files = directory.list();

        for (String fileName : files) {
            String className = null;

            if (fileName.endsWith(".class")) {
                className = packName + '.' + fileName.substring(0, fileName.length() - 6);
            }

            if (className != null) {
                classes.add(loadClass(className));
            }

            File subdir = new File(directory, fileName);

            if (subdir.isDirectory()) {
                classes.addAll(processDirectory(subdir, packName + '.' + fileName));
            }
        }

        return classes;
    }

    /**
     * Given a jar file's URL and a package name returns all classes within jar file.
     *
     * @param resource
     * @param packName
     */
    private List<Class<?>> processJarfile(URL resource, String packName)
    {
        List<Class<?>> classes = new ArrayList<Class<?>>();

        String relPath = packName.replace('.', '/');
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

            if (entryName.endsWith(".class") && entryName.startsWith(relPath)
                    && entryName.length() > (relPath.length() + "/".length())) {
                className = entryName.replace('/', '.').replace('\\', '.').replace(".class", "");
            }

            if (className != null) {
                classes.add(loadClass(className));
            }
        }

        return classes;
    }

    public void getCiphersName() throws Exception
    {
        Class cipher = Class.forName(ciphersPath + "." + "Caesar");

        if (!cipher.isAnnotationPresent(CipherAlgorithm.class)) {
            System.err.println("no annotation");
        } else {
            System.out.println("class annotated ; name  -  " + cipher.getAnnotation(CipherAlgorithm.class));
        }

        boolean hasEncryptMethod = false;
        boolean hasDecryptMethod = false;
        boolean hasHelpMethod = false;
        boolean hasHackMethod = false;

        Method[] method = cipher.getMethods();

        for (Method md : method) {
            if (md.isAnnotationPresent(Encrypt.class)) {
                hasEncryptMethod = true;
            }
            if (md.isAnnotationPresent(Decrypt.class)) {
                hasDecryptMethod = true;
            }
            if (md.isAnnotationPresent(Help.class)) {
                hasHelpMethod = true;
            }
            if (md.isAnnotationPresent(Hack.class)) {
                hasHackMethod = true;
            }
            if (hasEncryptMethod && hasDecryptMethod && hasHelpMethod && hasHackMethod) {
                break;
            }
        }

        System.out.println("Класс " + cipher.getSimpleName() + " итоги валидации:" + "\n\tМетод шифровки: " + hasEncryptMethod + "\n\tМетод дешифровки: " + hasDecryptMethod + "\n\tМетод помощи пользователю: " + hasHelpMethod + "\n\tМетод взлома: " + hasHackMethod);
    }
}
