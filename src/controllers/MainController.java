package controllers;

import app.Manager;
import app.base.Language;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

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
    private JFXComboBox<Language> language;
    @FXML
    private JFXComboBox<String> algorithm;
    @FXML
    private JFXTextField cipherKey;

    private Manager manager = new Manager();

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

        this.algorithm.getItems().addAll(manager.cipherManager().getResourceList());

        this.language.getItems().addAll(manager.languageManager().getLanguages());
    }

    public void action(ActionEvent actionEvent)
    {}

    private void encrypt(ActionEvent actionEvent)
    {

    }
}
