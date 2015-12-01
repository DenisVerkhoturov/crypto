package app;

/**
 * Application universal class for implementing any version of user interface.
 * Created by Leo.Scream on 29.11.2015.
 */
public class Application
{
    private static CipherManager cipherManager = new CipherManager();

    public CipherManager getCipherManager()
    {
        return cipherManager;
    }
}
