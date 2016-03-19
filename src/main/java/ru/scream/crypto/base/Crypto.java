package ru.scream.crypto.base;

import java.io.StringReader;
import java.io.StringWriter;

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

    public void encrypt(StringReader reader, StringWriter writer)
    {
        this.cipher.getInstance().alphabet = this.language.alphabet();
        this.cipher.getInstance().encrypt(reader, writer);
    }
}
