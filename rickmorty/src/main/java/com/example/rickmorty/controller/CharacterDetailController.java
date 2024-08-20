package com.example.rickmorty.controller;

import com.example.rickmorty.model.Character;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CharacterDetailController {

    @FXML
    private Label nameLabel; // Label to display character's name
    @FXML
    private Label speciesLabel; // Label to display character's species
    @FXML
    private Label statusLabel; // Label to display character's status
    @FXML
    private Label idLabel; // Label to display character's ID
    @FXML
    private Label locationLabel; // Label to display character's location
    @FXML
    private TextArea episodesArea; // TextArea to display character's episodes
    @FXML
    private ImageView characterImageView; // ImageView to display character's image
    @FXML
    private Button backButton; // Button to go back to the previous scene

    // Method to set character details in the view
    public void setCharacter(Character character) {
        nameLabel.setText(character.getName()); // Set name label with character's name
        speciesLabel.setText(character.getSpecies()); // Set species label with character's species
        statusLabel.setText(character.getStatus()); // Set status label with character's status
        idLabel.setText("ID: " + character.getId()); // Set ID label with character's ID
        locationLabel.setText("Location: " + character.getLocation()); // Set location label with character's location

        // Join episode URLs into a single string and set it in the TextArea
        String episodesText = String.join("\n", character.getEpisode());
        episodesArea.setText(episodesText); // Display episodes in the TextArea

        // Load and set character's image in the ImageView
        characterImageView.setImage(new Image(character.getImage()));
    }

    // Method to handle the back button click event
    @FXML
    private void handleBackButton() {
        // Close the current stage (window) to go back to the previous scene
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    // Method to set the title and icon for the secondary stage
    public void setStageProperties(Stage stage) {
        stage.setTitle("Character Details");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/icon.png")));
    }
}
