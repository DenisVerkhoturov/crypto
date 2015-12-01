package app.cipher;

import app.annotations.*;

/**
 * Caesar algorithm.
 *
 * Encrypt alphabetic text by replacing each letter in the plaintext by
 * a letter some fixed number of positions down the alphabet.
 *
 * Created by Leo.Scream on 29.11.2015.
 */
@CipherAlgorithm(algorithmName = "Caesar algorithm")
public class Caesar
{
    @Encrypt
    public String encrypt(String input)
    {
        String output = "";
        return output;
    }

    @Decrypt
    public String decrypt(String input)
    {
        String output = "";
        return output;
    }

    @Help
    public String help()
    {
        String output = "";
        return output;
    }

    @Hack
    public String hack(String input)
    {
        String output = "";
        return output;
    }
}
