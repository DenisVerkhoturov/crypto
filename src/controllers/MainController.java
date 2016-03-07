package controllers;

import app.Manager;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class MainController implements Initializable
{
    @FXML
    private JFXComboBox action;
    @FXML
    private JFXComboBox language;
    @FXML
    private JFXComboBox algorithm;
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

        this.language.getItems().addAll(manager.languageManager().getResourceList());
    }
}
