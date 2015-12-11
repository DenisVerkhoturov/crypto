import app.Application;

import java.io.*;

/**
 * Консольная версия приложения.
 */
public class CryptoConsole
{
    static Application app = new Application();

    public static void main(String[] args) throws IOException
    {
        app.languageManager().setCurrent("russian");
        app.cipherManager().setCurrent("caesar");

        String originalText = "Какой-то входной текст.";
        BufferedReader reader = new BufferedReader(new StringReader(originalText));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        app.encrypt(reader, writer);
    }
}
