/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usac.centrocalculo.data;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

/**
 *
 * @author Cristhofer Moya
 */
public class LectorNotificaciones {
     public void cargaArchivos(String docs)
    {
        
        File file = null;
        WordExtractor extractor = null;
        try
        {

            file = new File(docs);
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            HWPFDocument document = new HWPFDocument(fis);
            extractor = new WordExtractor(document);
            String fileData2= extractor.getText();
            String dependencia=this.getDato("DEPENDENCIA", "TITULO DEL PUESTO", fileData2);
            String puesto=this.getDato("TITULO DEL PUESTO", "No. PLAZA", fileData2);
            String noPlaza=this.getDato("No. PLAZA", "NOMBRE DEL TITULAR", fileData2);
            String nombrePersonaTitular=this.getDato("NOMBRE DEL TITULAR", "MOTIVO DE LA EMERGENCIA", fileData2);
            String motivoEmergencia=this.getDato("MOTIVO DE LA EMERGENCIA", "dkljafsld;kjfa;lsdkjf", fileData2);
            String nombrePersonaContratada=this.getDato("NOMBRE DE LA PERSONA CONTRATADA", "VIGENCIA DEL CONTRATO", fileData2);
            String vigenciaContratoInicio=this.getDato("VIGENCIA DEL CONTRATO", " AL ", fileData2);
           // String vigenciaContratoFin=this.getDato(" AL ", "ESTUDIOS REALIZADOS", fileData2);
            String estudiosRealizados=this.getDato("ESTUDIOS REALIZADOS", "EXPERIENCIA LABORAL", fileData2);
            //String experienciaLaboral=this.getDato("EXPERIENCIA LABORAL", "DEPENDENCIA", fileData2);
            String vigenciaAutorizadaInicio=this.getDato("VIGENCIA AUTORIZADA DEL", "AL", fileData2);
            //String vigenciaAutorizadaFin=this.getDato("AL", "OBSERVACIONES", fileData2);
            String observaciones=this.getDato("OBSERVACIONES", "Fecha Recibido", fileData2);
            String fechaRecibido=this.getDato("Fecha Recibido", "(f) Profesional de R.R.H.H", fileData2);
            System.out.println("----------------------------------------------------------------------------------------------------------------");
            System.out.println(dependencia.trim());
            System.out.println(puesto.trim());
            System.out.println(noPlaza.trim());
            System.out.println(nombrePersonaTitular.trim());
            System.out.println(motivoEmergencia.trim());
            System.out.println(nombrePersonaContratada.trim());
            System.out.println(vigenciaContratoInicio.trim());
           // System.out.println(vigenciaContratoFin.trim());
            System.out.println(estudiosRealizados.trim());
            //System.out.println(experienciaLaboral.trim());
            System.out.println(vigenciaAutorizadaInicio.trim());
            //System.out.println(vigenciaAutorizadaFin.trim());
            System.out.println(observaciones.trim());
            System.out.println(fechaRecibido.trim());
        }
        catch (Exception exep)
        {
            exep.printStackTrace();
        }
    }
    public String getDato(String inicio,String fin,String texto){
        int posicionInicial=texto.lastIndexOf(inicio);
        int posicionFinal=texto.lastIndexOf(fin);
        String resultado="";
        if(posicionFinal==-1){
            resultado= texto.substring(posicionInicial+inicio.length(), texto.length());
        }else{
            resultado= texto.substring(posicionInicial+inicio.length(), posicionFinal-1);
        }
        return resultado;
    }
}
