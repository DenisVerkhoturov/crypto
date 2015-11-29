package app;

import app.cipher.Cipher;
import org.jetbrains.annotations.Contract;

/**
 * Created by Leo.Scream on 29.11.2015.
 */
public class Application
{
    private Cipher cipher;

    private String createCipherClassName(String cipherName)
    {
        String applicationPath = "app.cipher.";
        return applicationPath + cipherName;
    }

    public void setCipher(String cipherName) throws ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        cipherName = createCipherClassName(capitalizeName(cipherName));
        cipher = (Cipher) Class.forName(cipherName).newInstance();
    }

    public Cipher getCurrentCipher()
    {
        return cipher;
    }

    private static String capitalizeName(String name)
    {
        return name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
    }
}
