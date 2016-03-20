package ru.scream.crypto.cipher;

import ru.scream.crypto.base.Cipher;
import ru.scream.crypto.base.exceptions.CipherKeyIsNotValid;

import java.io.StringReader;
import java.io.StringWriter;

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
    public void encrypt(StringReader reader, StringWriter writer)
    {}

    @Override
    public void decrypt(StringReader reader, StringWriter writer)
    {}
}
