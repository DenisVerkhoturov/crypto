package app;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leo.Scream on 29.11.2015.
 */
public class Application
{
    private String applicationPath = "app";
    private String cipherPath = "app.cipher";
    private Cipher cipher;

    public void setCipher(String cipherName) throws ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        cipherName = createCipherClassName(capitalizeName(cipherName));
        cipher = (Cipher) Class.forName(cipherName).newInstance();
    }

    public Cipher getCurrentCipher()
    {
        return cipher;
    }

    public List<String> getCiphersName()throws Exception
    {
        ClassLoader classLoader = Cipher.class.getClassLoader();
        String packageDir = cipherPath.replaceAll("[.]", "/");
        List<String> classes = new ArrayList<String>();
        URL classLoaderResource = classLoader.getResource(packageDir);
        InputStream in = (InputStream) classLoaderResource.getContent();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line = null;
        while ((line = br.readLine()) != null) {
            if(line.endsWith(".class"))
                classes.add(line.substring(0, line.lastIndexOf('.')));
        }
        return classes;
    }

    private String createCipherClassName(String cipherName)
    {
        return cipherPath + "." + cipherName;
    }

    private static String capitalizeName(String name)
    {
        return name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
    }
}
