package ru.scream.crypto.cipher;

import ru.scream.crypto.base.Cipher;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

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
    private int key = 0;

    @Override
    public Validator validateKey()
    {
        boolean valid = false;
        String message = "";

        if (candidateKey != null) {
            try {
                this.key = Integer.parseInt(candidateKey);

	            if (this.key > this.alphabet.length) {
		            message = "Key can't be bigger that alphabet length [" + this.alphabet.length + "]";
	            } else if (this.key < 0) {
		            message = "Key can't be negative";
	            }
            } catch (NumberFormatException e) {
                message = "Invalid key '" + candidateKey + "' for algorithm Caesar. Use integer key.";
            }
        }

	    if (message.equals(""))
		    valid = true;

        return new Validator(valid, message);
    }

    @Override
    public void encrypt(StringReader reader, StringWriter writer)
    {
        int charCode;

        try {
            while ((charCode = reader.read()) != -1) {
                boolean isNotInAlphabet = true;
                for (int i = 0; i < this.alphabet.length; i++) {
                    if (Character.toLowerCase(charCode) == this.alphabet[i]) {
                        int letterIndex = (i + this.key) % (this.alphabet.length + 1);
                        writer.write(this.alphabet[letterIndex]);
                        isNotInAlphabet = false;
                    }
                }

                if (isNotInAlphabet) {
                    writer.write((char) charCode);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void decrypt(StringReader reader, StringWriter writer)
    {
	    int charCode;

	    try {
		    while ((charCode = reader.read()) != -1) {
			    boolean isNotInAlphabet = true;
			    for (int i = 0; i < this.alphabet.length; i++) {
				    if (Character.toLowerCase(charCode) == this.alphabet[i]) {
					    int letterIndex = i - this.key;
					    writer.write(this.alphabet[letterIndex]);
					    isNotInAlphabet = false;
				    }
			    }

			    if (isNotInAlphabet) {
				    writer.write((char) charCode);
			    }
		    }
	    }
	    catch (IOException e) {
		    e.printStackTrace();
	    }
    }

    @Override
    public void hack(StringReader reader, StringWriter writer)
    {}
}
