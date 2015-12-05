import app.Application;
import app.base.CipherAlgorithm;

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

        for (CipherAlgorithm item : classes) {
            System.out.println(item.name());
        }

        System.out.println("Используется язык " + app.getlanguageManager().getCurrentLanguage().name());

        if (app.getlanguageManager().setCurrentLanguage("English")) {
            System.out.println("Попытка установить новый язык прошла успешно");
        } else {
            System.out.println("Безуспешная попытка установить язык");
        }

        System.out.println("Используется язык " + app.getlanguageManager().getCurrentLanguage().name());
    }
}
