package app;

import app.cipher.Cipher;

/**
 * Created by Leo.Scream on 29.11.2015.
 */
public class Application
{
    private String createCipherClassName(String cipherName)
    {
        String applicationPath = "app.cipher.";
        return applicationPath + cipherName;
    }

    public Cipher getCipher(String cipherName) throws ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        cipherName = createCipherClassName(capitalizeName(cipherName));
        Cipher cipher = (Cipher) Class.forName(cipherName).newInstance();
        return cipher;
    }

    private static String capitalizeName(String name)
    {
        return name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
    }
}
