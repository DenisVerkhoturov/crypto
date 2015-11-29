import app.Application;

import java.util.Scanner;

/**
 * Created by Leo.Scream on 29.11.2015.
 */
public class CryptoConsole
{
    static Application app = new Application();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        try {
            System.out.println("Реализованные шифровальщики: " + app.getCiphersName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        while(true) {
            String cipherName = scanner.nextLine();
            try {
                app.setCipher(cipherName);
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

        System.out.println(app.getCurrentCipher().name());
    }
}
