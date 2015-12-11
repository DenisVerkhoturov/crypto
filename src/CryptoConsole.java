import app.Application;

import java.util.List;

/**
 * Консольная версия приложения.
 */
public class CryptoConsole
{
    static Application app = new Application();

    public static void main(String[] args)
    {
        {
            if (app.getLanguageManager().setCurrent("Russian")) {
                System.out.println("Попытка установить новый язык прошла успешно");
            } else {
                System.out.println("Безуспешная попытка установить язык");
            }

            System.out.println("Используется язык " + app.getLanguageManager().getCurrent().name());
        }

        {
            System.out.println("Запрашиваю все существующие языки");
            List<String> languages = app.getLanguageManager().getResourceList();

            for(String language : languages)
                System.out.println(language);

            System.out.println("Можно использовать любой из этих языков");
        }

        {
            if (app.getCipherManager().setCurrent("Caesar")) {
                System.out.println("Попытка установить новый шифровальщик прошла успешно");
            } else {
                System.out.println("Безуспешная попытка установить шифровальщик");
            }

            System.out.println("Используется шифровальщик " + app.getCipherManager().getCurrent().name());
        }

        {
            System.out.println("Запрашиваю все существующие шифровальщики");
            List<String> ciphers = app.getCipherManager().getResourceList();

            for(String cipher : ciphers)
                System.out.println(cipher);

            System.out.println("Можно использовать любой из этих шифровальщиков");
        }
    }
}
