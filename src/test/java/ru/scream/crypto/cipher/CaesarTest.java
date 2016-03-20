package ru.scream.crypto.cipher;

import org.junit.Test;
import ru.scream.crypto.crypto.cipher.Caesar;

import static org.junit.Assert.*;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class CaesarTest
{
	private final Caesar caesar = new Caesar();

	/**
	 * Тесты метода установки ключа
	 */
	@Test
	public void testSetDefaultKey() throws Exception
	{
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
		String inputValue = String.valueOf(caesar.alphabet.length / 2);

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
		String inputValue = "5";
		String expectedValue = inputValue;
		caesar.setKey(inputValue);
		String actualValue = caesar.getKey();

		assertEquals(expectedValue, actualValue);
	}

	/**
	 * Тесты методов шифрования
	 */
	@Test
	public void testEncryptWithZeroKey() throws Exception
	{
		caesar.setKey("0");
		String inputValue = "Some test text!";
		String expectedValue = inputValue;
		String actualValue = caesar.encrypt(inputValue);

		assertEquals(expectedValue, actualValue);
	}

	@Test
	public void testEncryptWithMaxKey() throws Exception
	{
		caesar.setKey(String.valueOf(caesar.alphabet.length - 1));
		String inputValue = "Some test text!";
		String expectedValue = "Rnld sdrs sdws!";
		String actualValue = caesar.encrypt(inputValue);

		assertEquals(expectedValue, actualValue);
	}

	@Test
	public void testDecryptWithZeroKey() throws Exception
	{
		caesar.setKey("0");
		String inputValue = "Some test text!";
		String expectedValue = inputValue;
		String actualValue = caesar.decrypt(inputValue);

		assertEquals(expectedValue, actualValue);
	}

	@Test
	public void testDecryptWithMaxKey() throws Exception
	{
		caesar.setKey(String.valueOf(caesar.alphabet.length - 1));
		String inputValue = "Rnld sdrs sdws!";
		String expectedValue = "Some test text!";
		String actualValue = caesar.decrypt(inputValue);

		assertEquals(expectedValue, actualValue);
	}
}
