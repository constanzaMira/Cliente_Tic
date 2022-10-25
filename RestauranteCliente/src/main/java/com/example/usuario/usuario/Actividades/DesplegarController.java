package com.example.usuario.usuario.Actividades;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class DesplegarController {

    @FXML
    private Label capacidad1;

    @FXML
    private Label horario1;

    @FXML
    private Label nombre1;

    @FXML
    private Label precio1;


    private Actividades actividades;

    public void setData(Actividades actividades){
        this.actividades = actividades;
        nombre1.setText(actividades.getNombre());
        precio1.setText(String.valueOf(actividades.getPrecio()));
        horario1.setText(actividades.getHorario());
        capacidad1.setText(String.valueOf(actividades.getCapacidad()));
    }

}