import app.Application;

/**
 * Main class for console version of cipher application.
 * Created by Leo.Scream on 29.11.2015.
 */
public class CryptoConsole
{
    static Application app = new Application();

    public static void main(String[] args)
    {
        app.getCipherManager().getClassesForPackage();

        System.out.println(app.getCipherManager());
    }
}
