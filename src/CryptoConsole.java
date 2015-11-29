import app.Application;
import app.cipher.Cipher;

import java.util.Scanner;

/**
 * Created by Leo.Scream on 29.11.2015.
 */
public class CryptoConsole
{
    public static void main(String[] args)
    {
        Application app = new Application();
        Scanner scanner = new Scanner(System.in);

        Cipher cipher;

        while(true) {
            String cipherName = scanner.nextLine();
            try {
                cipher = app.getCipher(cipherName);
                break;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Такого класса не существует!");
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        System.out.println(cipher.name());
    }
}
