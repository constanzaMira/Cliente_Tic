package com.example.usuario.usuario.Usuario;

import com.example.usuario.usuario.Actividades.Actividades;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import kong.unirest.GetRequest;
import kong.unirest.Unirest;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ActividadesController implements Initializable {

    Scene scene;

    Stage stage;

    @FXML
    private HBox hbox;
    @FXML
    private Button cerrar_sesion;

    @FXML
    private Button filtrar;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Button actividades;
    @FXML
    private Label titulo;

    @FXML
    private ImageView foto_logo;

    @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;
    @FXML
    private Button reservas;
    List<Actividades> actividades1 = new ArrayList<>();

    public String mail;


    @FXML
    void ActividadesClickedButton(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Usuario/Actividades-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void CerrrSesionClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/LogIn-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void FiltrarClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Usuario/FiltrarPor-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void MisReservasClickedButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(ActividadesController.class.getResourceAsStream("/com/example/usuario/usuario/Usuario/MisReservas-view.fxml"));
        MisReservasController misReservasController = fxmlLoader.getController();
        misReservasController.setMail(mail);
        misReservasController.inf();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public List<Actividades> getData() {
        List<Actividades> actividadesList =null;
        try{
            GetRequest apiResponse = Unirest.get("http://localhost:8080/api/v1/gimnasio/actividades")
                    .header("Content-Type", "application/json");
            String temp = apiResponse.asJson().getBody().toString();
            System.out.println(temp);
            ObjectMapper mapper = new ObjectMapper();
            actividadesList = mapper.readValue(temp, new TypeReference<List<Actividades>>(){});
            System.out.println(actividadesList);
            }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return actividadesList;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        actividades1.addAll(getData());
         int row=1;
         int colum =0;

         try {
             for (int i = 0; i < actividades1.size(); i++) {
                 FXMLLoader fxmlLoader = new FXMLLoader();
                 fxmlLoader.setLocation(getClass().getResource("/com/example/usuario/usuario/Usuario/Desplegar.fxml"));
                 AnchorPane anchorPane = fxmlLoader.load();


                 DesplegarController desplegarController = fxmlLoader.getController();
                 desplegarController.setData(actividades1.get(i));

                 if (colum == 1) {
                     colum = 0;
                     row++;
                 }

                 grid.add(anchorPane, colum++, row);

                 grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                 grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                 grid.setMaxHeight(Region.USE_COMPUTED_SIZE);

                 grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                 grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                 grid.setMinWidth(Region.USE_COMPUTED_SIZE);

                 GridPane.setMargin(anchorPane,new Insets(10));

             }
         }catch (Exception ignored){}

    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}