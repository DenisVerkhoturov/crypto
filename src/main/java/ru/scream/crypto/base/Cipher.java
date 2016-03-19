package ru.scream.crypto.base;

import java.io.StringReader;
import java.io.StringWriter;

/**
 * Абстрактный класс шифровальщик, с наследниками которого работает внешняя среда.
 */
public abstract class Cipher
{
	/**
	 * Значение-кандидат для использования в качестве ключа.
	 * Это значение открыто и может содержать любую строку,
	 * поэтому не следует использовать это поле как ключ в алгоритмах.
	 * В качестве ключа рекоммендуется использовать поле класса,
	 * например private int key, которое каждый может получить,
	 * но назначается оно только в классе реализации алгоритма в
	 * функции validateKey.
	 */
	public String candidateKey = "";

	public char[] alphabet = Languages.EN.alphabet();

	public abstract Validator validateKey();

	public abstract void encrypt(StringReader reader, StringWriter writer);

	public abstract void decrypt(StringReader reader, StringWriter writer);

	public abstract void hack(StringReader reader, StringWriter writer);

	public class Validator
	{
		private boolean valid;
		private String message;

		public Validator(boolean valid, String message)
		{
			this.valid = valid;
			this.message = message;
		}

		public boolean isValid()
		{
			return this.valid;
		}

		public String getMessage()
		{
			return this.message;
		}
	}
}


