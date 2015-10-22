/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usac.centrocalculo.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import usac.centrocalculo.listas.ListaURyS;
import usac.centrocalculo.nodos.URyS;

/**
 *
 * @author Cristhofer Moya
 */
public class LecturaURyS {

    private String doc = "";
    private ListaURyS lista = ListaURyS.getInstancia();

    public void readXlsx(File inputFile) {
        try {
            // Get the workbook instance for XLSX file
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(inputFile));

            // Get first sheet from the workbook
            XSSFSheet sheet = wb.getSheetAt(0);

            Row row;
            Cell cell;

            // Iterate through each rows from first sheet
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                ArrayList<String> nodo = new ArrayList<>();
                // For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    cell = cellIterator.next();

                    switch (cell.getCellType()) {

                        case Cell.CELL_TYPE_BOOLEAN:
                            nodo.add(cell.toString());
                            //System.out.println(cell.getBooleanCellValue());
                            break;

                        case Cell.CELL_TYPE_NUMERIC:
                            nodo.add(cell.toString());
                            //System.out.println(cell.getNumericCellValue());
                            break;

                        case Cell.CELL_TYPE_STRING:
                            nodo.add(cell.toString());
                            //System.out.println(cell.getStringCellValue());
                            break;

                        case Cell.CELL_TYPE_BLANK:
                            nodo.add("-");
                            break;

                        default:
                            nodo.add(cell.toString());
                    }
                }
                fillList(nodo);
            }
        } catch (Exception e) {
            System.err.println("Exception :" + e.getMessage());
        }
    }

    public void fillList(ArrayList<String> listaString) {
        lista.addURyS(
                String.valueOf(lista.getIdNext()),
                listaString.get(0),
                listaString.get(1),
                listaString.get(2),
                listaString.get(3),
                listaString.get(4),
                listaString.get(5),
                listaString.get(6),
                listaString.get(7),
                listaString.get(8),
                listaString.get(9),
                listaString.get(10), 
                listaString.get(11), 
                listaString.get(12),
                listaString.get(13), 
                listaString.get(14), 
                listaString.get(15),
                listaString.get(16),
                listaString.get(17),
                listaString.get(18), 
                listaString.get(19), 
                listaString.get(20)
        );
           }

    public void readXls(File inputFile) {
        List cellDataList = new ArrayList();
        try {
            // Get the workbook instance for XLS file
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(inputFile));
            // Get first sheet from the workbook
            HSSFSheet sheet = workbook.getSheetAt(0);
            Cell cell;
            Row row;
            Iterator rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext()) {
                HSSFRow hssfRow = (HSSFRow) rowIterator.next();
                Iterator iterator = hssfRow.cellIterator();
                List cellTempList = new ArrayList();
                while (iterator.hasNext()) {
                    HSSFCell hssfCell = (HSSFCell) iterator.next();
                    cellTempList.add(hssfCell);
                }
                cellDataList.add(cellTempList);
            }
            // Iterate through each rows from first sheet
            /*Iterator<Row> rowIterator = sheet.iterator();

             while (rowIterator.hasNext()) {
             row = rowIterator.next();

             // For each row, iterate through each columns
             Iterator<Cell> cellIterator = row.cellIterator();

             while (cellIterator.hasNext()) {
             cell = cellIterator.next();

             switch (cell.getCellType()) {
   
             case Cell.CELL_TYPE_BOOLEAN:
                           
             System.out.print(cell.getBooleanCellValue());
             break;

             case Cell.CELL_TYPE_NUMERIC:
             System.out.print(cell.getNumericCellValue());
             break;

             case Cell.CELL_TYPE_STRING:
             System.out.print(cell.getStringCellValue());
             break;

             case Cell.CELL_TYPE_BLANK:
             //System.out.print("<>");
             break;

             default:
             //  System.out.print(cell);
             }
             }
             }*/

        } catch (FileNotFoundException e) {
            System.err.println("Exception" + e.getMessage());
        } catch (IOException e) {
            System.err.println("Exception" + e.getMessage());
        }
        printTo(cellDataList);
        printToConsole(cellDataList);
    }

    private void printToConsole(List cellDataList) {
        for (int i = 0; i < cellDataList.size(); i++) {
            List cellTempList = (List) cellDataList.get(i);
            for (int j = 0; j < cellTempList.size(); j++) {
                HSSFCell hssfCell = (HSSFCell) cellTempList.get(j);
                String stringCellValue = hssfCell.toString();
                System.out.print(hssfCell.toString());
            }
            System.out.println();
        }
    }

    private void printTo(List cellDataList) {
        for (int i = 0; i < cellDataList.size(); i++) {
            List cellTempList = (List) cellDataList.get(i);
            for (int j = 0; j < cellTempList.size(); j++) {
                HSSFCell hssfCell = (HSSFCell) cellTempList.get(j);
                //String CellValue = (hssfCell.toString()).replaceAll(" ", "");
                String CellValue = hssfCell.toString();
                switch (hssfCell.getCellType()) {

                    case Cell.CELL_TYPE_BOOLEAN:

                        doc = doc + CellValue + "<>";
                        break;

                    case Cell.CELL_TYPE_NUMERIC:
                        doc = doc + CellValue + "<>";
                        break;

                    case Cell.CELL_TYPE_STRING:
                        doc = doc + CellValue + "<>";
                        break;

                    case Cell.CELL_TYPE_BLANK:

                        break;

                    default:

                }

            }

        }
        /*this.getDato("F<>","<>Salario",doc);
         this.getDato("<>Salario Q.<>",">       Edad:",doc);
         this.getDato("<>Dependencia:<>",">Título del puesto vacante:<>",doc);
         this.getDato("FORMATO PERFIL DEL PUESTO<>",">       Datos Generales<>",doc);
         //Motivo ....
         this.getDato("NOMBRE:    <>",">       __________________________________<>Registro de Personal:<>",doc);
         this.getDato("Registro de Personal:<>",">       __________________________________<>Vigencia del Puesto",doc);
         //Sexo...
         this.getDato("<>       Edad:        de","        a _________<>Horario de trabajo",doc);
         this.getDato("<>       Edad:        de_________        a","<>Horario de trabajo:<>",doc);
         this.getDato("<>       Lugar de residencia:","<>Motivo de la Vacante",doc);
         this.getDato("Experiencia:  Incluir aspectos técnicos, equipo que debe<>       manejar, programas de computación, etc.)<>","NOMBRE:    <>",doc);
         this.getDato("<>       Breve descripción de funciones del puesto:<>",getDato("NOMBRE:    <>",">       __________________________________<>Registro de Personal:<>",doc),doc);
         this. getDato("<>OBSERVACIONES:<>*","Inga. Rocío Carolina Medina ",doc);
         this.getDato("____<>Guatemala,<>","<>       __________________________________<>       __________________________________<>       __________________________________<>          (f) <>Delegado por autoridad nominadora<>O",doc);
         this.getDato("<>Persona Propuesta (en el caso de ascenso)<>       Breve descripción de funciones del puesto:<>",">       __________________________________<>Guatemala,",doc);
         this.getDato("","",doc);
         this.getDato("","",doc);
         this.getDato("","",doc);
         this.getDato("","",doc);
         this.getDato("","",doc);
         this.getDato("","",doc);
         this.getDato("","",doc);
         this.getDato("","",doc);*/

        doc = null;
    }

    public String getDato(String inicio, String fin, String texto) {
        int posicionInicial = texto.lastIndexOf(inicio);
        int posicionFinal = texto.lastIndexOf(fin);
        String resultado = "";
        if (posicionFinal == -1) {

            resultado = texto.substring(posicionInicial + inicio.length(), texto.length());
        } else {

            resultado = texto.substring(posicionInicial + inicio.length(), posicionFinal - 1);
        }
        posicionInicial = 0;
        posicionFinal = 1;
        return resultado;
    }

}
