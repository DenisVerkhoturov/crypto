package ru.scream.crypto.crypto.cipher;

import ru.scream.crypto.crypto.exception.CipherKeyIsNotValid;

/**
 * Шифр Атбаш
 *
 * Простой шифр подстановки для иврита.
 * Правило шифрования состоит в замене «i»-й буквы алфавита буквой с номером «n» − «i» + 1,
 * где «n» — число букв в алфавите. Пример для латинского алфавита выглядит так:
 * Исходный текст:      abcdefghijklmnopqrstuvwxyz
 * Зашифрованный текст: ZYXWVUTSRQPONMLKJIHGFEDCBA
 */
public class Atbash extends Cipher
{
    @Override
    public void setKey(String candidateKey) throws CipherKeyIsNotValid
    {}

    @Override
    public String encrypt(String text)
    {
        return null;
    }

    @Override
    public String decrypt(String text)
    {
        return null;
    }
}
