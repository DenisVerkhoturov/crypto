package ru.scream.crypto.base;

import com.sun.istack.internal.NotNull;
import ru.scream.crypto.base.exceptions.CipherKeyIsNotValid;

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


