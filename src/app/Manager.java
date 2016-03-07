package app;

import app.manager.CipherManager;
import app.manager.LanguageManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;

/**
 * Универсальный класс приложения, предоставляющий универсальные медоты шифрования по имени алгоритма.
 */
public class Manager
{
    private CipherManager cipherManager = new CipherManager();
    private LanguageManager languageManager = new LanguageManager();

    public CipherManager cipherManager()
    {
        return cipherManager;
    }

    public LanguageManager languageManager()
    {
        return languageManager;
    }

    public void encrypt(BufferedReader reader, BufferedWriter writer)
    {
        if (validate()) {
            cipherManager.getCurrent().currentLanguage = languageManager.getCurrent();
            cipherManager.getCurrent().encrypt(reader, writer);
        }
    }

    private boolean validate()
    {
        if (cipherManager.getCurrent() == null) {
            System.out.println("Не установлен способ шифрования");
            return false;
        }
        if (languageManager.getCurrent() == null) {
            System.out.println("Не установлен язык текста");
            return false;
        }

        return true;
    }
}
