package ru.scream.crypto.crypto.cipher;

import ru.scream.crypto.crypto.exception.CipherKeyIsNotValid;

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
    public void setKey(String candidateKey) throws CipherKeyIsNotValid
    {
	    int candidate = Integer.parseInt(candidateKey);

        if (candidate < 0 || candidate >= this.alphabet.length)
	        throw new CipherKeyIsNotValid();

	    this.intKey = candidate;
    }

	@Override
	public String getKey()
	{
		return String.valueOf(this.intKey);
	}

	@Override
    public String encrypt(String text)
    {
	    StringBuilder result = new StringBuilder();
	    char alpha = this.alphabet[0];

	    for (char letter : text.toCharArray()) {
		    char encrypted = letter;
		    if (Character.isLetter(letter)) {
			    if (Character.isUpperCase(letter)) {
				    encrypted = (char) (Character.toUpperCase(alpha) + (letter - Character.toUpperCase(alpha) + this.intKey) % (this.alphabet.length));
			    } else {
				    encrypted = (char) (alpha + (letter - alpha + this.intKey) % this.alphabet.length );
			    }
		    }
		    result.append(encrypted);
	    }
	    return result.toString();
    }

    @Override
    public String decrypt(String text)
    {
	    int tpm = this.intKey;
	    this.intKey = this.alphabet.length - this.intKey;
	    String result = this.encrypt(text);
	    this.intKey = tpm;
	    return result;
    }
}
