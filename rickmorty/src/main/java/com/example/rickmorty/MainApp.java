package com.example.rickmorty;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainApp extends Application {

    // The main entry point for JavaFX applications
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file for the main character view
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CharacterView.fxml"));
        Scene scene = new Scene(loader.load()); // Create a new scene with the loaded FXML

        // Apply CSS styles to the scene
        scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

        // Set the title of the primary stage (main window)
        primaryStage.setTitle("Rick and Morty Characters");

        // Set the icon of the primary stage
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/icon.png")));

        // Set the scene to the primary stage
        primaryStage.setScene(scene);

        // Set the initial width and height of the primary stage
        primaryStage.setWidth(800); // Set width to 800 pixels
        primaryStage.setHeight(600); // Set height to 600 pixels

        // Display the primary stage
        primaryStage.show();
    }

    // The main method to launch the JavaFX application
    public static void main(String[] args) {
        launch(args); // Launch the application
    }
}
