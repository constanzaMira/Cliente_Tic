package com.example.usuario.usuario.Actividades.TiposActividades;

import com.example.usuario.usuario.Actividades.Actividades;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CanchasController implements Initializable {

    Scene scene;
    Stage stage;

    List<Actividades> actividadesCancha= new ArrayList<>();

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Button cerrar_sesion;

    @FXML
    private Button filtrar;

    @FXML
    private ImageView foto_logo;

    @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;

    @FXML
    private Button titulo;

    @FXML
    private Button ver_todas_button;

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
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Actividades/Categorias-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void VerTodasClickedButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/usuario/usuario/Actividades/Actividades-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private List<Actividades> getData() {
        List<Actividades> actividadesList =null;
        try{
            GetRequest apiResponse = Unirest.get("http://localhost:8080/api/v1/gimnasio/actividades")
                    .header("Content-Type", "application/json");
            String temp = apiResponse.asJson().getBody().toString();
            ObjectMapper mapper = new ObjectMapper();
            actividadesList = mapper.readValue(temp, new TypeReference<List<Actividades>>(){});
            for(int i=0; i<actividadesList.size(); i++){
                if(actividadesList.get(i).getCategoria().equals("Cancha")){
                    actividadesCancha.add(actividadesList.get(i));
                }
            }
        }catch (Exception ignored){}
        return actividadesCancha;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Actividades> desplegar = getData();
        System.out.println(desplegar);
       /* int row=0;
        for (int i= 0; i<desplegar.size(); i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("com.example.usuario.usuario.Actividades.Actividades-view.fxml"));
            try {
                AnchorPane anchorPane = fxmlLoader.load();
                UnaActividadPRUEBAController controller = fxmlLoader.getController();
                controller.setData(desplegar.get(i));
                grid.add(anchorPane, 0,0 );
                GridPane.setMargin(anchorPane,new Insets(10));
            } catch (IOException e) {}
        }*/
    }
}
