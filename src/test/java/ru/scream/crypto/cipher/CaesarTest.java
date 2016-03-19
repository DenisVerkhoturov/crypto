package ru.scream.crypto.cipher;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.scream.crypto.base.Cipher;
import ru.scream.crypto.base.Languages;

import java.io.*;

import static org.junit.Assert.*;

/**
 * Created by leo on 12.03.16.
 */
public class CaesarTest
{
	private Cipher caesar;

	@Before
	public void setUp() throws Exception
	{
		/*this.caesar = new Caesar();
		this.caesar.alphabet = Languages.RU.alphabet();*/
	}

	@After
	public void tearDown() throws Exception
	{}

	@Test
	public void testValidateKey() throws Exception
	{
		/*assertTrue("Ключ по умолчанию проходит валидацию", caesar.validateKey().isValid());

		this.caesar.candidateKey = "4";
		assertTrue("Десятичный ключ устанавливается", caesar.validateKey().isValid());

		this.caesar.candidateKey = "as";
		assertTrue("Строковый ключ не устанавливается", caesar.validateKey().isValid())*/;
	}

	@Test
	public void testEncrypt() throws Exception
	{
		/*String lowerCase = "строка в нижнем регистре";
		String lowerCaseExpected = "хцфтод ё смксир фижмхцфи";
		StringReader input = new StringReader(lowerCase);
		StringWriter output = new StringWriter();
		this.caesar.encrypt(input, output);
		assertEquals("Строка в нижнем регистре", lowerCaseExpected, output.toString());*/
	}

	@Test
	public void testDecrypt() throws Exception
	{

	}

	@Test
	public void testHack() throws Exception
	{

	}
}