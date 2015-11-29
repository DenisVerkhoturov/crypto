package cipher;

/**
 * Created by Leo.Scream on 29.11.2015.
 */
abstract class Cipher
{
    public String name(){
        return this.getClass().getName();
    }

    public abstract String encrypt(String input);

    public abstract String decrypt(String input);

    public abstract String hack(String input);

    public abstract String help();
}
