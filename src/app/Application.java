package app;

import app.manager.CipherManager;
import app.manager.LanguageManager;

/**
 * Универсальный класс приложения, предоставляющий универсальные медоты шифрования по имени алгоритма.
 */
public class Application
{
    private CipherManager cipherManager = new CipherManager();
    private LanguageManager languageManager = new LanguageManager();

    public CipherManager getCipherManager()
    {
        return cipherManager;
    }

    public LanguageManager getLanguageManager()
    {
        return languageManager;
    }
}
