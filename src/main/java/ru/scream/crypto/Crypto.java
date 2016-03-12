package ru.scream.crypto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Crypto extends Application
{
	@Override
	public void start(Stage stage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader();
		BorderPane root = loader.load(getClass().getResourceAsStream("/fxml/main.fxml"));
		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.setMinHeight(600);
		stage.setMinWidth(400);
		stage.setTitle("Crypto");
		stage.show();
	}
}
