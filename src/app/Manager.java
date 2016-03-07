package app;

import app.base.Language;
import app.manager.CipherManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;

/**
 * Универсальный класс приложения, предоставляющий универсальные медоты шифрования по имени алгоритма.
 */
public class Manager
{
    private CipherManager cipherManager = new CipherManager();
    private Language language;

    public Manager()
    {
        this.language = Language.EN;
    }

    public CipherManager cipherManager()
    {
        return cipherManager;
    }

    public Language getLanguage()
    {
        return this.language;
    }

    public void encrypt(BufferedReader reader, BufferedWriter writer)
    {
        if (validate()) {
            cipherManager.getCurrent().currentLanguage = this.language;
            cipherManager.getCurrent().encrypt(reader, writer);
        }
    }

    private boolean validate()
    {
        if (cipherManager.getCurrent() == null) {
            System.out.println("Не установлен способ шифрования");
            return false;
        }

        return true;
    }
}
