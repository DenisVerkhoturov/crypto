package ru.scream.crypto.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Paint;
import ru.scream.crypto.base.*;
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
    private JFXComboBox<Actions> action;
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

    private ResourceBundle resourceBundle;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        this.resourceBundle = resources;

        this.initListeners();
    }

    private void initListeners()
    {
        this.action.getItems().addAll(Actions.values());
        this.action.getSelectionModel().select(Actions.ENCRYPT);

        this.algorithm.getItems().addAll(Ciphers.values());
        this.algorithm.getSelectionModel().select(Ciphers.CAESAR);

        this.language.getItems().addAll(Languages.values());
        this.language.getSelectionModel().select(Languages.EN);
        this.language.setOnAction((event) ->
            algorithm.getValue().getInstance().alphabet = language.getValue().alphabet());

        this.cipherKey.focusedProperty().addListener((observable, oldValue, newValue) ->
            {
                if(!newValue) {
                    algorithm.getValue().getInstance().candidateKey = cipherKey.getText();
                    if (algorithm.getValue().getInstance().validateKey().isValid()) {
                        cipherKey.setFocusColor(Paint.valueOf("#4059A9"));
                        errorMessage.setText(algorithm.getValue().getInstance().validateKey().getMessage());
                        doMagic.setDisable(false);
                    } else {
                        cipherKey.setFocusColor(Paint.valueOf("#dd1515"));
                        errorMessage.setText(algorithm.getValue().getInstance().validateKey().getMessage());
                        doMagic.setDisable(true);
                    }
                }
            });
    }

    public void action(ActionEvent actionEvent)
    {
        StringReader input = new StringReader(this.inputText.getText());
        StringWriter result = new StringWriter();

        switch (this.action.getSelectionModel().getSelectedItem())
        {
            case ENCRYPT:
                algorithm.getValue().getInstance().encrypt(input, result);
                this.outputText.setText(result.toString());
                break;
            case DECRYPT:
                algorithm.getValue().getInstance().decrypt(input, result);
                this.outputText.setText(result.toString());
                break;
            case HACK:
                break;
        }
    }
}
