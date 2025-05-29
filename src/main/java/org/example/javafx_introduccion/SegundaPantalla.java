package org.example.javafx_introduccion;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SegundaPantalla {

    @FXML
    public TextField nombreTextField;

    @FXML
    public TextField edadTextField;

    @FXML
    private TableView<Persona> tablaPersonas;

    @FXML
    private TableColumn<Persona, String> nombreColumna;

    @FXML
    private TableColumn<Persona, Integer> edadColumna;

    private ObservableList<Persona> personas = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        nombreColumna.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getNombre()));
        edadColumna.setCellValueFactory(cellData -> new javafx.beans.property.SimpleIntegerProperty(cellData.getValue().getEdad()).asObject());

        tablaPersonas.setItems(RepositorioPersonas.getPersona());
    }

    @FXML
    private void guardarPersona(){
        String nombre = nombreTextField.getText();

        int edad;

        try{
            edad = Integer.parseInt(edadTextField.getText());
        } catch (NumberFormatException e){
            System.out.println("Error: edad inválida.");
            return;
        }

        Persona persona = new Persona(nombre, edad);

        RepositorioPersonas.getPersona().add(persona);

        System.out.println("Persona guardada:" + persona.getNombre() + ", " + persona.getEdad());
        nombreTextField.clear();
        edadTextField.clear();
    }

    public void volverAPantalla1() throws IOException {
        HelloApplication.setRoot("hello-view");
    }
}
