package ru.scream.crypto.cipher;

import ru.scream.crypto.base.Cipher;
import ru.scream.crypto.base.exceptions.CipherKeyIsNotValid;

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
	/**
	 * Ключ не может быть меньше нуля или больше размера используемого алфавита.
	 */
    private int intKey = 0;

    @Override
    public void setKey(String candidateKey) throws CipherKeyIsNotValid
    {
	    int candidate = Integer.parseInt(candidateKey);

        if (candidate < 0 || candidate > this.alphabet.length)
	        throw new CipherKeyIsNotValid();

	    this.intKey = candidate;
    }

	@Override
	public String getKey()
	{
		return String.valueOf(this.intKey);
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
                        int letterIndex = (i + this.intKey) % (this.alphabet.length + 1);
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
					    int letterIndex = i - this.intKey;
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
