package app.cipher;

import app.base.Cipher;

import java.io.BufferedReader;
import java.io.BufferedWriter;

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
    public void encrypt(BufferedReader reader, BufferedWriter writer)
    {}

    @Override
    public void decrypt(BufferedReader reader, BufferedWriter writer)
    {}

    @Override
    public void hack(BufferedReader reader, BufferedWriter writer)
    {}
}
