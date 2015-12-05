package app;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Абстрактный класс шифровальщик, с наследниками которого работает внешняя среда.
 */
public abstract class CipherAlgorithm
{
    public String name(){
        return this.getClass().getSimpleName();
    }

    public abstract OutputStreamWriter encrypt(InputStreamReader input);

    public abstract OutputStreamWriter decrypt(InputStreamReader input);

    public abstract OutputStreamWriter hack(InputStreamReader input);

    public abstract String help();

}
