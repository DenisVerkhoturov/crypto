package ru.scream.crypto.crypto.cipher;

import com.sun.istack.internal.NotNull;
import ru.scream.crypto.crypto.Languages;
import ru.scream.crypto.crypto.exception.CipherKeyIsNotValid;

/**
 * Абстрактный класс шифровальщик, с наследниками которого работает внешняя среда.
 */
public abstract class Cipher
{
	private String key;

	public char[] alphabet = Languages.EN.alphabet();

	public String getKey()
	{
		return this.key;
	}

	public abstract void setKey(@NotNull String candidateKey) throws CipherKeyIsNotValid;

	public abstract String encrypt(String text);

	public abstract String decrypt(String text);
}


