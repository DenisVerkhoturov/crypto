package app;

import app.base.Ciphers;
import app.base.Languages;

import java.io.BufferedReader;
import java.io.BufferedWriter;

/**
 * Универсальный класс приложения, предоставляющий универсальные медоты шифрования по имени алгоритма.
 */
public class Crypto
{
    private Ciphers cipher;
    private Languages language;

    public Crypto()
    {
        this.language = Languages.EN;
        this.cipher = Ciphers.CAESAR;
    }

    public Ciphers getCipher()
    {
        return this.cipher;
    }

    public Languages getLanguage()
    {
        return this.language;
    }

    public void encrypt(BufferedReader reader, BufferedWriter writer)
    {
        this.cipher.getInstance().alphabet = this.language.alphabet();
        this.cipher.getInstance().encrypt(reader, writer);
    }
}
