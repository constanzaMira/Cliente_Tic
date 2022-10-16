package com.example.usuario.usuario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class CrearActividadesController {
    ObservableList<String> txt_horario_list= FXCollections.
            observableArrayList("9:00","10:00","11:00","14:00","15:00","16:00","17:00","18:00");
    ObservableList<String> txt_categoria_list= FXCollections.
            observableArrayList("Deporte acuatico","Cancha","Gimnasio", "Otros");
    Stage stage;
    Scene scene;
    @FXML
    private Text actividades_titulo;

    @FXML
    private Text capacidad;

    @FXML
    private Text categoria;

    @FXML
    private Text horario;

    @FXML
    private Text nombre;

    @FXML
    private Text precio;

    @FXML
    private TextField txt_capacidad;

    @FXML
    private ChoiceBox txt_horario;

    @FXML
    private TextField txt_nombre;

    @FXML
    private ChoiceBox txt_categoria;

    @FXML
    private TextField txt_precio;

    @FXML
    private Button volver_button;
    @FXML
    private Button crear_button;

    @FXML
    void volverClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Opciones2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    void crearClickedButton(ActionEvent event) {

    }
    @FXML
    private void initialize(){
        txt_horario.setItems(txt_horario_list);
        txt_horario.setValue("Horario");
        txt_categoria.setItems(txt_categoria_list);
        txt_categoria.setValue("Categoria");
    }

}