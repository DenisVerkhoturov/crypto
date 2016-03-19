package ru.scream.crypto.base;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public enum Actions
{
	ENCRYPT("Encrypt"), DECRYPT("Decrypt"), HACK("Hack");

	private final String name;

	Actions(String name)
	{
		this.name = name;
	}
}
