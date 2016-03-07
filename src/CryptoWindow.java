import app.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Оконная версия приложения
 */
public class CryptoWindow extends JFrame
{
    static Application app = new Application();

    public CryptoWindow()
    {
        super("Crypto");
        setBounds(0, 0, 500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        createGUI();

        this.setVisible(true);
    }

    public void createGUI()
    {
        Container content = getContentPane();

        content.setLayout(new FlowLayout());

        JComboBox ciphers = new JComboBox(app.cipherManager().getResourceList().toArray());
        ciphers.setEditable(true);
        ciphers.setAlignmentX(LEFT_ALIGNMENT);

        final JLabel testCipherLabel = new JLabel("Не выбран");

        /**
         * Слушатель для списка шифровальщиков
         */
        ActionListener setCipher = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox box = (JComboBox)e.getSource();
                String item = (String)box.getSelectedItem();
                app.cipherManager().setCurrent(item);
                testCipherLabel.setText(item);
            }
        };

        JComboBox languages = new JComboBox(app.languageManager().getResourceList().toArray());
        languages.setEditable(true);
        languages.setAlignmentX(LEFT_ALIGNMENT);

        final JLabel testLanguageLabel = new JLabel("Не выбран");

        /**
         * Слушатель для списка языков
         */
        ActionListener setLanguage = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox box = (JComboBox)e.getSource();
                String item = (String)box.getSelectedItem();
                app.languageManager().setCurrent(item);
                testLanguageLabel.setText(item);
            }
        };

        ciphers.addActionListener(setCipher);
        languages.addActionListener(setLanguage);

        content.add(testCipherLabel);
        content.add(testLanguageLabel);
        content.add(ciphers);
        content.add(languages);
    }

    public static void main(String[] args) throws InterruptedException
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CryptoWindow();
            }
        });
    }
}
