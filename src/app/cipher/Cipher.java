package app.cipher;

/**
 * Created by Leo.Scream on 29.11.2015.
 */
public abstract class Cipher
{
    private static String packageName = "app.cipher.";

    public abstract String encrypt(String input);

    public abstract String decrypt(String input);

    public abstract String hack(String input);

    public abstract String help();

    public String name(){
        return this.getClass().getSimpleName();
    }

    public static String[] getCiphersName()
    {
        return new String[]{"caesar, vigenere"};
    }
}
