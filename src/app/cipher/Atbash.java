package app.cipher;

import app.CipherAlgorithm;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Шифр Атбаш
 *
 * Простой шифр подстановки для иврита.
 * Правило шифрования состоит в замене «i»-й буквы алфавита буквой с номером «n» − «i» + 1,
 * где «n» — число букв в алфавите. Пример для латинского алфавита выглядит так:
 * Исходный текст:      abcdefghijklmnopqrstuvwxyz
 * Зашифрованный текст: ZYXWVUTSRQPONMLKJIHGFEDCBA
 */
public class Atbash extends CipherAlgorithm
{
    @Override
    public OutputStreamWriter encrypt(InputStreamReader input)
    {
        return null;
    }

    @Override
    public OutputStreamWriter decrypt(InputStreamReader input)
    {
        return null;
    }

    @Override
    public OutputStreamWriter hack(InputStreamReader input)
    {
        return null;
    }

    @Override
    public String help()
    {
        return null;
    }
}
