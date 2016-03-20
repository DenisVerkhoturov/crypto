package ru.scream.crypto.cipher;

import org.junit.Test;

import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.Assert.*;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class CaesarTest
{
	/**
	 * Тесты метода установки ключа
	 */
	@Test
	public void testSetDefaultKey() throws Exception
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
	public void testSetStringKey() throws Exception
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
	public void testSetNegativeIntKey() throws Exception
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
	public void testSetBigIntKey() throws Exception
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
	public void testSetNormalIntKey() throws Exception
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

	/**
	 * Тесты метода установки ключа
	 */
	@Test
	public void testGetKey() throws Exception
	{
		Caesar caesar = new Caesar();
		String inputValue = "5";
		String excpectedValue = inputValue;
		caesar.setKey(inputValue);
		String actualValue = caesar.getKey();

		assertEquals(excpectedValue, actualValue);
	}

	/**
	 * Тесты методов шифрования
	 */
	@Test
	public void testEncryptWithZeroKey() throws Exception
	{
		Caesar caesar = new Caesar();
		caesar.setKey("0");
		StringReader inputValue = new StringReader("Some test text!");
		String expectedValue = "some test text!";
		StringWriter actualValue = new StringWriter();
		caesar.encrypt(inputValue, actualValue);

		assertEquals(expectedValue, actualValue.toString());
	}

	@Test
	public void testEncryptWithMaxKey() throws Exception
	{
		Caesar caesar = new Caesar();
		caesar.setKey(String.valueOf(caesar.alphabet.length));
		StringReader inputValue = new StringReader("Some test text!");
		String expectedValue = "rnld sdrs sdws!";
		StringWriter actualValue = new StringWriter();
		caesar.encrypt(inputValue, actualValue);

		assertEquals(expectedValue, actualValue.toString());
	}

	@Test
	public void testDecryptWithZeroKey() throws Exception
	{
		Caesar caesar = new Caesar();
		caesar.setKey("0");
		StringReader inputValue = new StringReader("Some test text!");
		String expectedValue = "some test text!";
		StringWriter actualValue = new StringWriter();
		caesar.decrypt(inputValue, actualValue);

		assertEquals(expectedValue, actualValue.toString());
	}

	@Test
	public void testDecryptWithMaxKey() throws Exception
	{
		Caesar caesar = new Caesar();
		caesar.setKey(String.valueOf(caesar.alphabet.length));
		StringReader inputValue = new StringReader("rnld sdrs sdws!");
		String expectedValue = "some test text!";
		StringWriter actualValue = new StringWriter();
		caesar.decrypt(inputValue, actualValue);

		assertEquals(expectedValue, actualValue.toString());
	}
}
