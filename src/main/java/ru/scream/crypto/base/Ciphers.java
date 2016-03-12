package ru.scream.crypto.base;

import ru.scream.crypto.cipher.Atbash;
import ru.scream.crypto.cipher.Caesar;
import ru.scream.crypto.cipher.Vigenere;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public enum Ciphers
{
    CAESAR(Caesar.class), VIGENERE(Vigenere.class), ATBASH(Atbash.class);

    private final Class <? extends Cipher> cipherClass;
    private Cipher instance;

    Ciphers(Class <? extends Cipher> cipherClass)
    {
        this.cipherClass = cipherClass;
    }

    public Cipher getInstance()
    {
        if (this.instance == null) {
            try {
                this.instance = this.cipherClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return this.instance;
    }
}
