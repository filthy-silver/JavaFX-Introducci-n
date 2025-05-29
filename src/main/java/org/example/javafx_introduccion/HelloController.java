package org.example.javafx_introduccion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class HelloController {

    static int count;
    @FXML
    private Label welcomeText;
    @FXML
    private Label contadorLabel;
    @FXML
    private Button contador;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void initialize() {
        Contador cont = new Contador();
        contador.setOnAction(e -> {
            cont.contar();
            contadorLabel.setText(Integer.toString(cont.getCount()));
        });
    }

    public void irASegundaPantalla() throws IOException {
        HelloApplication.setRoot("segunda-pantalla");
    }
}