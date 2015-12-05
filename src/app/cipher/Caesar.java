package app.cipher;

import app.CipherAlgorithm;

/**
 * Шифр Цезаря
 *
 * Шифр Цезаря — это вид шифра подстановки,
 * в котором каждый символ в открытом тексте заменяется символом,
 * находящимся на некотором постоянном числе позиций левее или правее него в алфавите.
 * Например, в шифре со сдвигом вправо на 3, А была бы заменена на Г, Б станет Д, и так далее.
 */
public class Caesar extends CipherAlgorithm
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
