/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usac.centrocalculo.data;

/**
 *
 * @author Cristhofer Moya
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import usac.centrocalculo.listas.ListaURyS;
import usac.centrocalculo.nodos.URyS;

public class CreateCSV {

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    //CSV file header
    private static final String FILE_HEADER = "id,dependencia,tituloPuesto,partida,salario,horarioDias,horarioHoras,motivoVacante,nombres,apellidos,registroPersonal,vigenciaPuesto,nombrePropuesta,apellidoPropuesta,fechaIngreso,autoriza,genero,edad,fechaNacimiento,lugarResidencia,escolaridad,experiencia";

    public static void writeCsvFile(String fileName, String doc) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fileName);
            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);
            if (doc.equals("urys")) {
                URyS temp = ListaURyS.getInstancia().obtenerLista();
                while (temp != null) {
                    fileWriter.append('"'+temp.getId()+'"');
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append('"'+temp.getDependencia()+'"');
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append('"'+temp.getTituloPuesto()+'"');
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append('"'+temp.getPartida()+'"');
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append('"'+temp.getSalario()+'"');
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append('"'+temp.getHorarioDias()+'"');
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append('"'+temp.getHorarioHoras()+'"');
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append('"'+temp.getMotivoVacante()+'"');
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append('"'+temp.getNombres()+'"');
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append('"'+temp.getApellidos()+'"');
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append('"'+temp.getRegistroPersonal()+'"');
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append('"'+temp.getVigenciaPuesto()+'"');
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append('"'+temp.getNombrePropuesta()+'"');
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append('"'+temp.getApellidoPropuesta()+'"');
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append('"'+temp.getFechaIngreso()+'"');
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append('"'+temp.getAutoriza()+'"');
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append('"'+temp.getGenero()+'"');
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append('"'+temp.getEdad()+'"');
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append('"'+temp.getFechaNacimiento()+'"');
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append('"'+temp.getLugarResidencia()+'"');
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append('"'+temp.getEscolaridad()+'"');
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append('"'+temp.getExperiencia()+'"');
                    fileWriter.append(NEW_LINE_SEPARATOR);
                    temp = temp.getEnlace();
                }
            }
            //Write a new student object list to the CSV file
//			for (Student student : students) {
//				fileWriter.append(String.valueOf(student.getId()));
//				fileWriter.append(COMMA_DELIMITER);
//				fileWriter.append(student.getFirstName());
//				fileWriter.append(COMMA_DELIMITER);
//				fileWriter.append(student.getLastName());
//				fileWriter.append(COMMA_DELIMITER);
//				fileWriter.append(student.getGender());
//				fileWriter.append(COMMA_DELIMITER);
//				fileWriter.append(String.valueOf(student.getAge()));
//				fileWriter.append(NEW_LINE_SEPARATOR);
//			}

            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }
}
