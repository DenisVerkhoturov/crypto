package ru.scream.crypto.crypto.cipher;

import ru.scream.crypto.crypto.exception.CipherKeyIsNotValid;

/**
 * Шифр Вижинера
 *
 * Метод полиалфавитного шифрования буквенного текста с использованием ключевого слова.
 */
public class Vigenere extends Cipher
{
	@Override
	public void setKey(String candidateKey) throws CipherKeyIsNotValid
	{}

	@Override
    public String encrypt(String text)
    {
	    return null;
    }

    @Override
    public String decrypt(String text)
    {
	    return null;
    }
}
