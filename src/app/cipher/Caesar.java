package app.cipher;

import app.base.Cipher;

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
    @Override
    public void encrypt(BufferedReader reader, BufferedWriter writer)
    {
        int charCode;

        try {
            while ((charCode = reader.read()) != -1) {
                boolean isNotInAlphabet = true;
                for (int i = 0; i < this.alphabet.length; i++) {
                    if ((char) charCode == this.alphabet[i]) {
                        writer.write(this.alphabet[i + Integer.parseInt(key) < this.alphabet.length ? i + Integer.parseInt(key) : (i + Integer.parseInt(key)) % this.alphabet.length]);
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
    {

    }

    @Override
    public void hack(BufferedReader reader, BufferedWriter writer)
    {

    }

    @Override
    public String help()
    {
        return null;
    }
}
