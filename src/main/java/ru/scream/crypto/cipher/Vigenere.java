package ru.scream.crypto.cipher;

import ru.scream.crypto.base.Cipher;
import ru.scream.crypto.base.exceptions.CipherKeyIsNotValid;

import java.io.StringReader;
import java.io.StringWriter;

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
    public void encrypt(StringReader reader, StringWriter writer)
    {}

    @Override
    public void decrypt(StringReader reader, StringWriter writer)
    {}
}
