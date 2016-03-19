package ru.scream.crypto.base;

import com.sun.istack.internal.NotNull;
import ru.scream.crypto.base.exceptions.CipherKeyIsNotValid;

import java.io.StringReader;
import java.io.StringWriter;

/**
 * Абстрактный класс шифровальщик, с наследниками которого работает внешняя среда.
 */
public abstract class Cipher
{
	public char[] alphabet = Languages.EN.alphabet();

	public abstract void setKey(@NotNull String candidateKey) throws CipherKeyIsNotValid;

	public abstract void encrypt(StringReader reader, StringWriter writer);

	public abstract void decrypt(StringReader reader, StringWriter writer);

	public abstract void hack(StringReader reader, StringWriter writer);
}


