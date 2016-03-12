package ru.scream.crypto.base;


import java.io.BufferedReader;
import java.io.BufferedWriter;

/**
 * Абстрактный класс шифровальщик, с наследниками которого работает внешняя среда.
 */
public abstract class Cipher
{
    public char[] alphabet;
    public String key;

    public abstract boolean validateKey();

    public abstract void encrypt(BufferedReader reader, BufferedWriter writer);

    public abstract void decrypt(BufferedReader reader, BufferedWriter writer);

    public abstract void hack(BufferedReader reader, BufferedWriter writer);
}


