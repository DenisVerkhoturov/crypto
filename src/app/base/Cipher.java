package app.base;


import java.io.BufferedReader;
import java.io.BufferedWriter;

/**
 * Абстрактный класс шифровальщик, с наследниками которого работает внешняя среда.
 */
public abstract class Cipher
{
    protected Language currentLanguage;

    public String name(){
        return this.getClass().getSimpleName();
    }

    public abstract void encrypt(BufferedReader reader, BufferedWriter writer);

    public abstract void decrypt(BufferedReader reader, BufferedWriter writer);

    public abstract void hack(BufferedReader reader, BufferedWriter writer);

    public abstract String help();

}
