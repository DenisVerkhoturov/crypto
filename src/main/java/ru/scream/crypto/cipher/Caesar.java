package ru.scream.crypto.cipher;

import ru.scream.crypto.base.Cipher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Шифр Цезаря
 *
 * Шифр Цезаря — это вид шифра подстановки,
 * в котором каждый символ в открытом тексте заменяется символом,
 * находящимся на некотором постоянном числе позиций левее или правее него в алфавите.
 * Например, в шифре со сдвигом вправо на 3, А была бы заменена на Г, Б станет Д, и так далее.
 */
public class Caesar extends Cipher
{
    private int intKey = 0;

    @Override
    public boolean validateKey()
    {
        boolean valid = false;
        if (this.key != null) {
            try {
                this.intKey = Integer.parseInt(this.key);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid key '" + this.key + "' for algorithm Caesar");
            }
        }

        return valid;
    }

    @Override
    public void encrypt(BufferedReader reader, BufferedWriter writer)
    {
        int charCode;

        try {
            while ((charCode = reader.read()) != -1) {
                boolean isNotInAlphabet = true;
                for (int i = 0; i < this.alphabet.length; i++) {
                    if ((char) charCode == this.alphabet[i]) {
                        int letterIndex = i + this.intKey;
                        if (letterIndex > this.alphabet.length)
                            letterIndex = letterIndex % this.alphabet.length;
                        writer.write(this.alphabet[letterIndex]);
                        isNotInAlphabet = false;
                    }
                }

                if (isNotInAlphabet) {
                    writer.write((char) charCode);
                }
                System.out.print(String.valueOf((char) charCode));
            }
            writer.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void decrypt(BufferedReader reader, BufferedWriter writer)
    {}

    @Override
    public void hack(BufferedReader reader, BufferedWriter writer)
    {}
}
