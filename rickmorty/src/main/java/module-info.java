module com.example.rickmorty {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens com.example.rickmorty to javafx.graphics;
    opens com.example.rickmorty.controller to javafx.fxml;
    opens com.example.rickmorty.model to com.google.gson;

    exports com.example.rickmorty;
    exports com.example.rickmorty.controller;
}
