/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usac.centrocalculo.ui;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import usac.centrocalculo.data.Conexion;
import usac.centrocalculo.data.CreateCSV;
import usac.centrocalculo.data.LecturaURyS;
import usac.centrocalculo.listas.ListaURyS;
import usac.centrocalculo.nodos.URyS;
import usac.centrocalculo.ui.bean.URySFx;

/**
 * FXML Controller class
 *
 * @author Cristhofer Moya
 */
public class VentanaExcelController implements Initializable {

    @FXML
    private TableView<URySFx> tablaURyS;
    @FXML
    private TableColumn columna1;
    @FXML
    private TableColumn columna2;
    @FXML
    private TableColumn columna3;
    @FXML
    private TableColumn columna4;
    @FXML
    private TableColumn columna5;
    @FXML
    private TableColumn columna6;
    @FXML
    private TableColumn columna7;
    @FXML
    private TableColumn columna8;
    @FXML
    private TableColumn columna9;
    @FXML
    private TableColumn columna10;
    @FXML
    private TableColumn columna11;
    @FXML
    private TableColumn columna12;
    @FXML
    private TableColumn columna13;
    @FXML
    private TableColumn columna14;
    @FXML
    private TableColumn columna15;
    @FXML
    private TableColumn columna16;
    @FXML
    private TableColumn columna17;
    @FXML
    private TableColumn columna18;
    @FXML
    private TableColumn columna19;
    @FXML
    private TableColumn columna20;
    @FXML
    private TableColumn columna21;
    @FXML
    private TableColumn columna22;
    @FXML
    ObservableList<URySFx> urys;
    @FXML
    private Button btnBuscarDir;
    @FXML
    private TextField txtRuta;
    @FXML
    private AnchorPane sendData;
    @FXML
    private Button btnSendData;

    @FXML
    private void buscarCarpetaExcel(ActionEvent event) {
        LecturaURyS lecturaexcel = new LecturaURyS();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Excel Files", "*.xls", "*.xlsx"));
        File selectedFile = fileChooser.showOpenDialog(txtRuta.getScene().getWindow());
        if (selectedFile == null) {
            txtRuta.setText("Ningun Archivo Seleccionado");
        } else {
            txtRuta.setText(selectedFile.getAbsolutePath());
            if (selectedFile.getName().toLowerCase().endsWith("xlsx")) {
                lecturaexcel.readXlsx(selectedFile);
            } else {
                lecturaexcel.readXls(selectedFile);
            }
            fillTable();
        }

//        DirectoryChooser chooser = new DirectoryChooser();
//        chooser.setTitle("Buscar Carpeta");
//        File selectedDirectory = chooser.showDialog(txtRuta.getScene().getWindow());
//
//        if (selectedDirectory == null) {
//            txtRuta.setText("Ningun Directorio Seleccionado");
//        } else {
//            txtRuta.setText(selectedDirectory.getAbsolutePath());
//            File dir = new File(selectedDirectory.getAbsolutePath());
//            File[] files = dir.listFiles(new FilenameFilter() {
//                public boolean accept(File dir, String name) {
//                    if (name.toLowerCase().endsWith("xlsx") || name.toLowerCase().endsWith("xls")) {
//                        return true;
//                    }
//                    return false;
//                }
//            });
//            for (int i = 0; i < files.length; i++) {
//                if (files[i].getName().toLowerCase().endsWith("xlsx")) {
//                    System.out.println("xlxs");
//                    lecturaexcel.readXlsx(files[i]);
//                } else {
//                    System.out.println("xls");
//                    lecturaexcel.readXls(files[i]);
//                }
//                System.out.println(files[i].getAbsolutePath());
//            }
//            fillTable();
//        }
    }

    @FXML
    private void insertData(ActionEvent event) {

        String fileName = System.getProperty("user.home") + "\\Desktop\\urys.csv";
        System.out.println(fileName);
        System.out.println("Write CSV file:");
        CreateCSV.writeCsvFile(fileName, "urys");
        Conexion conn = new Conexion("jdbc:postgresql://localhost:5432/", "Nombramientos", "postgres", "usac123");
        try {
            if (conn.connect()) {
                System.out.println("DB connected");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Ejecutando copy");
            System.out.println(conn.execCopy(fileName));
            ResultSet rs = conn.execQuery("SELECT * FROM urystemp");
            while(rs.next()) {
                //System.out.println(rs.getString("dependencia"));
     
            }       
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    public void fillTable() {
        urys = FXCollections.observableArrayList();
        URyS temp = ListaURyS.getInstancia().obtenerLista();

        while (temp != null) {
            URySFx reg = new URySFx();
            reg.id.set(temp.getId());
            reg.apellidoPropuesta.set(temp.getApellidoPropuesta());
            reg.apellidos.set(temp.getApellidos());
            reg.autoriza.set(temp.getAutoriza());
            reg.dependencia.set(temp.getDependencia());
            reg.edad.set(temp.getEdad());
            reg.escolaridad.set(temp.getEscolaridad());
            reg.experiencia.set(temp.getExperiencia());
            reg.fechaIngreso.set(temp.getFechaIngreso());
            reg.fechaNacimiento.set(temp.getFechaNacimiento());
            reg.genero.set(temp.getGenero());
            reg.horarioDias.set(temp.getHorarioDias());
            reg.horarioHoras.set(temp.getHorarioHoras());
            reg.lugarResidencia.set(temp.getLugarResidencia());
            reg.motivoVacante.set(temp.getMotivoVacante());
            reg.nombrePropuesta.set(temp.getNombrePropuesta());
            reg.nombres.set(temp.getNombres());
            reg.partida.set(temp.getPartida());
            reg.registroPersonal.set(temp.getRegistroPersonal());
            reg.salario.set(temp.getSalario());
            reg.tituloPuesto.set(temp.getTituloPuesto());
            reg.vigenciaPuesto.set(temp.getVigenciaPuesto());
            urys.add(reg);
            temp = temp.getEnlace();
        }

        tablaURyS.setItems(urys);
        btnBuscarDir.setVisible(false);
        txtRuta.setVisible(false);
        btnSendData.setVisible(true);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tablaURyS.setEditable(true);
        columna1.setCellValueFactory(new PropertyValueFactory<URySFx, String>("id"));
        columna2.setCellValueFactory(new PropertyValueFactory<URySFx, String>("dependencia"));
        columna2.setCellFactory(TextFieldTableCell.forTableColumn());
        columna2.setOnEditCommit(
                new EventHandler<CellEditEvent<URySFx, String>>() {
                    @Override
                    public void handle(CellEditEvent<URySFx, String> t) {
                        ((URySFx) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).dependencia.set(t.getNewValue());
                    }
                }
        );
        columna3.setCellValueFactory(new PropertyValueFactory<URySFx, String>("tituloPuesto"));
        columna3.setCellFactory(TextFieldTableCell.forTableColumn());
        columna3.setOnEditCommit(
                new EventHandler<CellEditEvent<URySFx, String>>() {
                    @Override
                    public void handle(CellEditEvent<URySFx, String> t) {
                        ((URySFx) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).tituloPuesto.set(t.getNewValue());
                    }
                }
        );
        columna4.setCellValueFactory(new PropertyValueFactory<URySFx, String>("partida"));
        columna4.setCellFactory(TextFieldTableCell.forTableColumn());
        columna4.setOnEditCommit(
                new EventHandler<CellEditEvent<URySFx, String>>() {
                    @Override
                    public void handle(CellEditEvent<URySFx, String> t) {
                        ((URySFx) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).partida.set(t.getNewValue());
                    }
                }
        );
        columna5.setCellValueFactory(new PropertyValueFactory<URySFx, String>("salario"));
        columna5.setCellFactory(TextFieldTableCell.forTableColumn());
        columna5.setOnEditCommit(
                new EventHandler<CellEditEvent<URySFx, String>>() {
                    @Override
                    public void handle(CellEditEvent<URySFx, String> t) {
                        ((URySFx) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).salario.set(t.getNewValue());
                    }
                }
        );
        columna6.setCellValueFactory(new PropertyValueFactory<URySFx, String>("horarioDias"));
        columna6.setCellFactory(TextFieldTableCell.forTableColumn());
        columna6.setOnEditCommit(
                new EventHandler<CellEditEvent<URySFx, String>>() {
                    @Override
                    public void handle(CellEditEvent<URySFx, String> t) {
                        ((URySFx) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).horarioDias.set(t.getNewValue());
                    }
                }
        );
        columna7.setCellValueFactory(new PropertyValueFactory<URySFx, String>("horarioHoras"));
        columna7.setCellFactory(TextFieldTableCell.forTableColumn());
        columna7.setOnEditCommit(
                new EventHandler<CellEditEvent<URySFx, String>>() {
                    @Override
                    public void handle(CellEditEvent<URySFx, String> t) {
                        ((URySFx) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).horarioHoras.set(t.getNewValue());
                    }
                }
        );
        columna8.setCellValueFactory(new PropertyValueFactory<URySFx, String>("motivoVacante"));
        columna8.setCellFactory(TextFieldTableCell.forTableColumn());
        columna8.setOnEditCommit(
                new EventHandler<CellEditEvent<URySFx, String>>() {
                    @Override
                    public void handle(CellEditEvent<URySFx, String> t) {
                        ((URySFx) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).motivoVacante.set(t.getNewValue());
                    }
                }
        );
        columna9.setCellValueFactory(new PropertyValueFactory<URySFx, String>("nombres"));
        columna9.setCellFactory(TextFieldTableCell.forTableColumn());
        columna9.setOnEditCommit(
                new EventHandler<CellEditEvent<URySFx, String>>() {
                    @Override
                    public void handle(CellEditEvent<URySFx, String> t) {
                        ((URySFx) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).nombres.set(t.getNewValue());
                    }
                }
        );
        columna10.setCellValueFactory(new PropertyValueFactory<URySFx, String>("apellidos"));
        columna10.setCellFactory(TextFieldTableCell.forTableColumn());
        columna10.setOnEditCommit(
                new EventHandler<CellEditEvent<URySFx, String>>() {
                    @Override
                    public void handle(CellEditEvent<URySFx, String> t) {
                        ((URySFx) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).apellidos.set(t.getNewValue());
                    }
                }
        );
        columna11.setCellValueFactory(new PropertyValueFactory<URySFx, String>("registroPersonal"));
        columna11.setCellFactory(TextFieldTableCell.forTableColumn());
        columna11.setOnEditCommit(
                new EventHandler<CellEditEvent<URySFx, String>>() {
                    @Override
                    public void handle(CellEditEvent<URySFx, String> t) {
                        ((URySFx) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).registroPersonal.set(t.getNewValue());
                    }
                }
        );
        columna12.setCellValueFactory(new PropertyValueFactory<URySFx, String>("vigenciaPuesto"));
        columna12.setCellFactory(TextFieldTableCell.forTableColumn());
        columna12.setOnEditCommit(
                new EventHandler<CellEditEvent<URySFx, String>>() {
                    @Override
                    public void handle(CellEditEvent<URySFx, String> t) {
                        ((URySFx) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).vigenciaPuesto.set(t.getNewValue());
                    }
                }
        );
        columna13.setCellValueFactory(new PropertyValueFactory<URySFx, String>("nombrePropuesta"));
        columna13.setCellFactory(TextFieldTableCell.forTableColumn());
        columna13.setOnEditCommit(
                new EventHandler<CellEditEvent<URySFx, String>>() {
                    @Override
                    public void handle(CellEditEvent<URySFx, String> t) {
                        ((URySFx) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).nombrePropuesta.set(t.getNewValue());
                    }
                }
        );
        columna14.setCellValueFactory(new PropertyValueFactory<URySFx, String>("apellidoPropuesta"));
        columna14.setCellFactory(TextFieldTableCell.forTableColumn());
        columna14.setOnEditCommit(
                new EventHandler<CellEditEvent<URySFx, String>>() {
                    @Override
                    public void handle(CellEditEvent<URySFx, String> t) {
                        ((URySFx) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).apellidoPropuesta.set(t.getNewValue());
                    }
                }
        );
        columna15.setCellValueFactory(new PropertyValueFactory<URySFx, String>("fechaIngreso"));
        columna15.setCellFactory(TextFieldTableCell.forTableColumn());
        columna15.setOnEditCommit(
                new EventHandler<CellEditEvent<URySFx, String>>() {
                    @Override
                    public void handle(CellEditEvent<URySFx, String> t) {
                        ((URySFx) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).fechaIngreso.set(t.getNewValue());
                    }
                }
        );
        columna16.setCellValueFactory(new PropertyValueFactory<URySFx, String>("autoriza"));
        columna16.setCellFactory(TextFieldTableCell.forTableColumn());
        columna16.setOnEditCommit(
                new EventHandler<CellEditEvent<URySFx, String>>() {
                    @Override
                    public void handle(CellEditEvent<URySFx, String> t) {
                        ((URySFx) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).autoriza.set(t.getNewValue());
                    }
                }
        );
        columna17.setCellValueFactory(new PropertyValueFactory<URySFx, String>("genero"));
        columna17.setCellFactory(TextFieldTableCell.forTableColumn());
        columna17.setOnEditCommit(
                new EventHandler<CellEditEvent<URySFx, String>>() {
                    @Override
                    public void handle(CellEditEvent<URySFx, String> t) {
                        ((URySFx) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).genero.set(t.getNewValue());
                    }
                }
        );
        columna18.setCellValueFactory(new PropertyValueFactory<URySFx, String>("edad"));
        columna18.setCellFactory(TextFieldTableCell.forTableColumn());
        columna18.setOnEditCommit(
                new EventHandler<CellEditEvent<URySFx, String>>() {
                    @Override
                    public void handle(CellEditEvent<URySFx, String> t) {
                        ((URySFx) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).edad.set(t.getNewValue());
                    }
                }
        );
        columna19.setCellValueFactory(new PropertyValueFactory<URySFx, String>("fechaNacimiento"));
        columna19.setCellFactory(TextFieldTableCell.forTableColumn());
        columna19.setOnEditCommit(
                new EventHandler<CellEditEvent<URySFx, String>>() {
                    @Override
                    public void handle(CellEditEvent<URySFx, String> t) {
                        ((URySFx) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).fechaNacimiento.set(t.getNewValue());
                    }
                }
        );
        columna20.setCellValueFactory(new PropertyValueFactory<URySFx, String>("lugarResidencia"));
        columna20.setCellFactory(TextFieldTableCell.forTableColumn());
        columna20.setOnEditCommit(
                new EventHandler<CellEditEvent<URySFx, String>>() {
                    @Override
                    public void handle(CellEditEvent<URySFx, String> t) {
                        ((URySFx) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).lugarResidencia.set(t.getNewValue());
                    }
                }
        );
        columna21.setCellValueFactory(new PropertyValueFactory<URySFx, String>("escolaridad"));
        columna21.setCellFactory(TextFieldTableCell.forTableColumn());
        columna21.setOnEditCommit(
                new EventHandler<CellEditEvent<URySFx, String>>() {
                    @Override
                    public void handle(CellEditEvent<URySFx, String> t) {
                        ((URySFx) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).escolaridad.set(t.getNewValue());
                    }
                }
        );
        columna22.setCellValueFactory(new PropertyValueFactory<URySFx, String>("experiencia"));
        columna22.setCellFactory(TextFieldTableCell.forTableColumn());
        columna22.setOnEditCommit(
                new EventHandler<CellEditEvent<URySFx, String>>() {
                    @Override
                    public void handle(CellEditEvent<URySFx, String> t) {
                        ((URySFx) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).experiencia.set(t.getNewValue());
                    }
                }
        );

    }

}
