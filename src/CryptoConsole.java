import app.Application;
import app.CipherAlgorithm;

import java.util.List;

/**
 * Консольная версия приложения.
 */
public class CryptoConsole
{
    static Application app = new Application();

    public static void main(String[] args)
    {
        List<CipherAlgorithm> classes = app.getCipherManager().getCiphersList();

        for(CipherAlgorithm item : classes) {
            System.out.println(item.getClass().getSimpleName());
        }
    }
}
