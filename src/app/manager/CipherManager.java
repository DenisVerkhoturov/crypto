package app.manager;

import app.base.Helper;
import app.base.Cipher;
import app.base.PackageManager;

/**
 * Класс управляющий алгоритмами шифрования.
 */
public class CipherManager extends PackageManager
{
    private Cipher current;

    public CipherManager()
    {
        super();
        this.workingPath = "cipher";
        this.type = Cipher.class;
    }

    public Cipher getCurrent() throws NullPointerException
    {
        return this.current;
    }

    public boolean setCurrent(String cipherName)
    {
        try {
            this.current = (Cipher) Class.forName(this.workingPath + "." + Helper.capitalize(cipherName)).newInstance();
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println("Такого класса не существует: " + e);
        } catch (InstantiationException e) {
            System.out.println("Не возможно создать экземпляр этого класса: " + e);
        } catch (IllegalAccessException e) {
            System.out.println("Модификатор доступа не позволяет создать экземпляр класса: " + e);
        } catch (Exception e) {
            System.out.println("Неизвестная ошибка: " + e);
        }

        return false;
    }
}
