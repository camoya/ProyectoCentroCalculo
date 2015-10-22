/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usac.centrocalculo.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Cristhofer Moya
 */
public class VentanaPrincipalController implements Initializable {

      @FXML
    private Button btnVentanaExcel;
       @FXML
    private Button btnVentanaForma041;
            
    
    @FXML
    private void abrirVentanaExcel(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("VentanaExcel.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("URyS");
        stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(
        (       (Node)event.getSource()).getScene().getWindow() );
        //stage.setResizable(false);
        stage.show();
    }
     @FXML
    private void abrirVentana041(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("VentanaForma041.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Forma041");
        stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(
        (       (Node)event.getSource()).getScene().getWindow() );
        //stage.setResizable(false);
        stage.show();
    }
     @FXML
    private void abrirVentanaNotificaciones(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("VentanaNotificaciones.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Notificaciones");
        stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(
        (       (Node)event.getSource()).getScene().getWindow() );
        //stage.setResizable(false);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
