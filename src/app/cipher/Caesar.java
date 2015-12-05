package app.cipher;

import app.base.CipherAlgorithm;

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
public class Caesar extends CipherAlgorithm
{
    private int key;

    @Override
    public void encrypt(BufferedReader reader, BufferedWriter writer)
    {
        int charCode;

        try {
            while ((charCode = reader.read()) != -1) {
                String letter = String.valueOf((char) charCode);
                boolean isNotInAlphabet = true;
                for (int i = 0; i < currentLanguage.alphabeth.length; i++) {
                    if (letter.toLowerCase().equals(currentLanguage.alphabeth[i])) {
                        writer.write(currentLanguage.alphabeth[i + key < currentLanguage.alphabeth.length ? i + key : (i + key) % currentLanguage.alphabeth.length]);
                        isNotInAlphabet = false;
                    }
                }

                if (isNotInAlphabet) {
                    writer.write(letter);
                }
            }
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
