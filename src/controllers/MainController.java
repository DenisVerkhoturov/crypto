package controllers;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
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
    private JFXComboBox action;
    @FXML
    private JFXComboBox language;
    @FXML
    private JFXComboBox algorithm;
    @FXML
    private JFXTextField cipherKey;

    private ResourceBundle resourceBundle;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        this.resourceBundle = resources;
    }
}
