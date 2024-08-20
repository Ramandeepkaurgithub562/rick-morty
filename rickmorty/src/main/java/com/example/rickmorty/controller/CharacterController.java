package com.example.rickmorty.controller;

import com.example.rickmorty.model.Character;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class CharacterController {

    @FXML
    private TextField searchField; // TextField for entering the character search query
    @FXML
    private Button searchButton; // Button to initiate the search
    @FXML
    private ListView<Character> characterListView; // ListView to display the list of characters

    @FXML
    private void initialize() {
        // Set an action event for the search button
        searchButton.setOnAction(event -> loadData(searchField.getText()));

        // Set a click event handler for the ListView
        characterListView.setOnMouseClicked(this::handleCharacterClick);

        // Set a custom cell factory for displaying character details
        characterListView.setCellFactory(new Callback<ListView<Character>, ListCell<Character>>() {
            @Override
            public ListCell<Character> call(ListView<Character> listView) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(Character character, boolean empty) {
                        super.updateItem(character, empty);
                        if (empty || character == null) {
                            setText(null); // Clear the cell if empty or character is null
                        } else {
                            setText(character.toString()); // Display the character's string representation
                        }
                    }
                };
            }
        });
    }

    // Method to load character data based on the search query
    private void loadData(String query) {
        try {
            // Construct the URL for the API request
            URL url = new URL("https://rickandmortyapi.com/api/character/?name=" + query);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET"); // Set request method to GET
            connection.connect(); // Establish connection

            // Read the response from the API
            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            JsonObject jsonResponse = new Gson().fromJson(reader, JsonObject.class);
            JsonArray jsonArray = jsonResponse.getAsJsonArray("results");

            // Deserialize the JSON response into a list of Character objects
            Type characterListType = new TypeToken<List<Character>>(){}.getType();
            List<Character> characters = new Gson().fromJson(jsonArray, characterListType);

            // Update the ListView with the retrieved characters
            characterListView.getItems().setAll(characters);

        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace if an exception occurs
        }
    }

    // Method to handle character selection in the ListView
    private void handleCharacterClick(MouseEvent event) {
        if (event.getClickCount() == 2) { // Check if double-clicked
            Character selectedCharacter = characterListView.getSelectionModel().getSelectedItem();
            if (selectedCharacter != null) {
                try {
                    // Load the FXML for the character detail view
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CharacterDetailView.fxml"));
                    Stage stage = new Stage(); // Create a new stage for the character detail view
                    Scene scene = new Scene(loader.load()); // Load the scene from FXML
                    scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm()); // Apply CSS styles

                    // Get the controller for the detail view and set the character
                    CharacterDetailController controller = loader.getController();
                    controller.setCharacter(selectedCharacter);

                    // Set the title and icon for the secondary stage
                    controller.setStageProperties(stage);

                    stage.setScene(scene); // Set the scene to the stage
                    stage.show(); // Display the stage
                } catch (Exception e) {
                    e.printStackTrace(); // Print the stack trace if an exception occurs
                }
            }
        }
    }
}
