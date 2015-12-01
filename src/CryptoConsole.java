import app.Application;

import java.util.List;

/**
 * Main class for console version of cipher application.
 * Created by Leo.Scream on 29.11.2015.
 */
public class CryptoConsole
{
    static Application app = new Application();

    public static void main(String[] args)
    {
        List<Class<?>> classes = app.getCipherManager().getClassesForPackage();

        for(Class<?> item : classes) {
            try {
                System.out.println(item.newInstance().getClass().getSimpleName());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
