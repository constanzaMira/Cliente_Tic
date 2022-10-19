package com.example.usuario.usuario;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInController implements Initializable {
    private Stage stage;

    private Scene scene;

    @FXML
    private AnchorPane LogInButton;

    @FXML
    private Label contraseña;

    @FXML
    private Label usuario;

    @FXML
    private Button LogIn_button;

    @FXML
    private Label titulo_bienvenidos;

    @FXML
    private TextField txt_contraseña;

    @FXML
    private TextField txt_email;

    @FXML
    void LogInClickedButton(ActionEvent event) throws IOException {
        if (txt_email.getText().equals("superadmin") && txt_contraseña.getText().equals("superadmin")) {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Opciones1-view.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        if (txt_email.getText().equals("admincentro") && txt_contraseña.getText().equals("admincentro")) {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Actividades/CrearActividades-view.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

        if (txt_email.getText().equals("usuario") && txt_contraseña.getText().equals("usuario")) {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Actividades/Actividades-view.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if (txt_email.getText().equals("adminempresa") && txt_contraseña.getText().equals("adminempresa")) {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Empleado-view.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    @FXML
    void CancelClickedButton(ActionEvent event) {
        System.out.println("Ingrese correctamente todos los datos para acceder");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}




