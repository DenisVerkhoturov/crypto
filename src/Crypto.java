import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Verhoturov Denis - Leo.Scream.
 */
public class Crypto extends Application
{
    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        this.primaryStage = primaryStage;
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(400);
        this.primaryStage.setTitle("Crypto");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Crypto.class.getResource("fxml/main.fxml"));
        loader.setResources(ResourceBundle.getBundle("bundles.Locale", new Locale("en")));
        this.rootLayout = loader.load();

        Scene scene = new Scene(this.rootLayout);
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
    }
}
