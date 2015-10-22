/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usac.centrocalculo.ui;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import usac.centrocalculo.data.LectorFormaCeroCuatroUno;


/**
 * FXML Controller class
 *
 * @author Cristhofer Moya
 */
public class VentanaForma041Controller implements Initializable {

    @FXML
    private Button btnBuscarDir;
    @FXML
    private TextField txtRuta;
   @FXML 
           private TableView tabla;
    @FXML
    private void buscarCarpeta041(ActionEvent event) {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Buscar Carpeta");
        File selectedDirectory = chooser.showDialog(txtRuta.getScene().getWindow());

        if (selectedDirectory == null) {
            txtRuta.setText("Ningun Directorio Seleccionado");
        } else {
            txtRuta.setText(selectedDirectory.getAbsolutePath());
            File dir = new File(selectedDirectory.getAbsolutePath());
            File[] files = dir.listFiles((File dir1, String name) -> name.toLowerCase().endsWith("doc") || name.toLowerCase().endsWith("docx"));
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
                if (file.getName().toLowerCase().endsWith("doc")) {
                    LectorFormaCeroCuatroUno nuevo = new LectorFormaCeroCuatroUno();
                    nuevo.cargaArchivos(file.getAbsolutePath());
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
