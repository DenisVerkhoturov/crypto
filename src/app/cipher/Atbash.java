package app.cipher;

import app.CipherAlgorithm;

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
    public String encrypt(String input)
    {
        return null;
    }

    @Override
    public String decrypt(String input)
    {
        return null;
    }

    @Override
    public String hack(String input)
    {
        return null;
    }

    @Override
    public String help()
    {
        return null;
    }
}
