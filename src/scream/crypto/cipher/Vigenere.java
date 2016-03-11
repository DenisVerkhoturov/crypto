package scream.crypto.cipher;

import scream.crypto.base.Cipher;

import java.io.BufferedReader;
import java.io.BufferedWriter;

/**
 * Шифр Вижинера
 *
 * Метод полиалфавитного шифрования буквенного текста с использованием ключевого слова.
 */
public class Vigenere extends Cipher
{
    @Override
    public boolean validateKey()
    {
        return true;
    }

    @Override
    public void encrypt(BufferedReader reader, BufferedWriter writer)
    {}

    @Override
    public void decrypt(BufferedReader reader, BufferedWriter writer)
    {}

    @Override
    public void hack(BufferedReader reader, BufferedWriter writer)
    {}
}
