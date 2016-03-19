package ru.scream.crypto.cipher;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class CaesarTest
{
	@Test
	public void testValidateDefaultKey() throws Exception
	{
		Caesar caesar = new Caesar();
		String inputValue = caesar.getKey();

		try {
			caesar.setKey(inputValue);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testValidateStringKey() throws Exception
	{
		Caesar caesar = new Caesar();
		String inputValue = "key";

		try {
			caesar.setKey(inputValue);
			/* Если этот ключ установился без ошибки - тест завален. */
			fail();
		} catch (Exception e) {}
	}

	@Test
	public void testValidateNegativeIntKey() throws Exception
	{
		Caesar caesar = new Caesar();
		String inputValue = "-3";

		try {
			caesar.setKey(inputValue);
			/* Если этот ключ установился без ошибки - тест завален. */
			fail();
		} catch (Exception e) {
		}
	}

	@Test
	public void testValidateBigIntKey() throws Exception
	{
		Caesar caesar = new Caesar();
		String inputValue = "99";

		try {
			caesar.setKey(inputValue);
			/* Если этот ключ установился без ошибки - тест завален. */
			fail();
		} catch (Exception e) {}
	}

	@Test
	public void testValidateNormalIntKey() throws Exception
	{
		Caesar caesar = new Caesar();
		int alphabetLength = caesar.alphabet.length;
		String inputValue = String.valueOf(alphabetLength - 1);

		try {
			caesar.setKey(inputValue);
		} catch (Exception e) {
			fail();
		}
	}
}
