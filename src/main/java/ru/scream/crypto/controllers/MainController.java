package ru.scream.crypto.controllers;

import javafx.scene.control.Tooltip;
import ru.scream.crypto.base.Crypto;
import ru.scream.crypto.base.Ciphers;
import ru.scream.crypto.base.Languages;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class MainController implements Initializable
{
    @FXML
    private JFXComboBox<String> action;
    @FXML
    private JFXComboBox<Languages> language;
    @FXML
    private JFXComboBox<Ciphers> algorithm;
    @FXML
    private JFXTextField cipherKey;
    @FXML
    private Tooltip errorMessage;
    @FXML
    private JFXTextArea inputText;
    @FXML
    private JFXTextArea outputText;
    @FXML
    private JFXButton doMagic;

    private Crypto crypto = new Crypto();

    private ResourceBundle resourceBundle;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        this.resourceBundle = resources;

        this.initListeners();
    }

    private void initListeners()
    {
        String[] actions = {"Зашифровать", "Расшифровать"};
        this.action.getItems().addAll(actions);
        this.action.getSelectionModel().select("Зашифровать");

        this.algorithm.getItems().addAll(Ciphers.values());
        this.algorithm.getSelectionModel().select(this.crypto.getCipher());

        this.language.getItems().addAll(Languages.values());
        this.language.getSelectionModel().select(this.crypto.getLanguage());
    }

    public void action(ActionEvent actionEvent)
    {
        this.crypto.getCipher().getInstance().key = this.cipherKey.getText();
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new OutputStream()
        {
            @Override
            public void write(int b) throws IOException
            {
                outputText.appendText(String.valueOf((char) b));
            }
        }));

        switch (this.action.getSelectionModel().getSelectedItem())
        {
            case "Зашифровать":
                this.crypto.encrypt(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(this.inputText.getText().getBytes()))), output);
                break;
            case "Расшифровать":
                break;
            case "Взломать":
                break;
        }
    }
}
