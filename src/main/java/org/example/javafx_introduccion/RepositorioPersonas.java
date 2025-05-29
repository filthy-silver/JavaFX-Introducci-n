package org.example.javafx_introduccion;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RepositorioPersonas {
    private static final ObservableList<Persona> personas = FXCollections.observableArrayList();


    public static ObservableList<Persona> getPersona() {
        return personas;
    }

    public static void agregarPersona(Persona persona) {
        personas.add(persona);
    }


}
