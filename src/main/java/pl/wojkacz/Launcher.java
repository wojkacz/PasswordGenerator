package pl.wojkacz;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Launcher extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        URL url = new File("src/main/java/pl/wojkacz/App.fxml").toURI().toURL();

        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root, 1024, 576);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Random Password Generator");

        stage.getIcons().add(new Image("/icon.png"));
        // Icon created by Gregor Cresnar

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
