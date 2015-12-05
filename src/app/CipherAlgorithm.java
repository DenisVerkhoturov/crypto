package app;

/**
 * Абстрактный класс шифровальщик, с наследниками которого работает внешняя среда.
 */
public abstract class CipherAlgorithm
{
    public String name(){
        return this.getClass().getSimpleName();
    }

    public abstract String encrypt(String input);

    public abstract String decrypt(String input);

    public abstract String hack(String input);

    public abstract String help();

}
