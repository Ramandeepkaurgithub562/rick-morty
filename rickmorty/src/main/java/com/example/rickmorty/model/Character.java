package com.example.rickmorty.model;

import java.util.List;

public class Character {
    private int id; // Unique identifier for the character
    private String name; // Name of the character
    private String status; // Status of the character (e.g., Alive, Dead, Unknown)
    private String species; // Species of the character
    private String gender; // Gender of the character
    private String image; // URL of the character's image
    private Location location; // Location object representing the character's location
    private List<String> episode; // List of episode URLs in which the character appears

    // Getter for id
    public int getId() {
        return id;
    }
    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for name
    public String getName() {
        return name;
    }
    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for status
    public String getStatus() {
        return status;
    }
    // Setter for status
    public void setStatus(String status) {
        this.status = status;
    }

    // Getter for species
    public String getSpecies() {
        return species;
    }
    // Setter for species
    public void setSpecies(String species) {
        this.species = species;
    }

    // Getter for gender
    public String getGender() {
        return gender;
    }
    // Setter for gender
    public void setGender(String gender) {
        this.gender = gender;
    }

    // Getter for image URL
    public String getImage() {
        return image;
    }
    // Setter for image URL
    public void setImage(String image) {
        this.image = image;
    }

    // Getter for location
    public Location getLocation() {
        return location;
    }
    // Setter for location
    public void setLocation(Location location) {
        this.location = location;
    }

    // Getter for episode list
    public List<String> getEpisode() {
        return episode;
    }
    // Setter for episode list
    public void setEpisode(List<String> episode) {
        this.episode = episode;
    }

    // Override toString method to provide a string representation of the character
    @Override
    public String toString() {
        return name + " (" + species + ", " + status + ")";
    }
}
