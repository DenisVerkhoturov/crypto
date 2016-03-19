package ru.scream.crypto.cipher;

import ru.scream.crypto.base.Cipher;

import java.io.StringReader;
import java.io.StringWriter;

/**
 * Шифр Вижинера
 *
 * Метод полиалфавитного шифрования буквенного текста с использованием ключевого слова.
 */
public class Vigenere extends Cipher
{
    @Override
    public Validator validateKey()
    {
        return null;
    }

    @Override
    public void encrypt(StringReader reader, StringWriter writer)
    {}

    @Override
    public void decrypt(StringReader reader, StringWriter writer)
    {}

    @Override
    public void hack(StringReader reader, StringWriter writer)
    {}
}
