/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usac.centrocalculo.listas;

import usac.centrocalculo.nodos.URyS;

/**
 *
 * @author Cristhofer Moya
 */
public class ListaURyS {
    private URyS inicio;
    private URyS fin;
    private static ListaURyS instancia;
    
     public static ListaURyS getInstancia() {
        if (instancia == null) {
            instancia = new ListaURyS();
        }
        return instancia;
    }
    public ListaURyS() {
        this.inicio = null;
        this.fin = null;
    }

    public void addURyS(String id, String dependencia, String tituloPuesto, String partida, String salario, 
            String horarioDias, String horarioHoras, String motivoVacante, String nombres, 
            String apellidos, String registroPersonal, String vigenciaPuesto, String nombrePropuesta, 
            String apellidoPropuesta, String fechaIngreso, String autoriza, String genero, String edad, 
            String fechaNacimiento, String lugarResidencia, String escolaridad, String experiencia) {
        
        URyS nuevo = new URyS( id, dependencia,tituloPuesto,partida,salario,horarioDias,
        horarioHoras, motivoVacante, nombres, apellidos, registroPersonal, vigenciaPuesto,
        nombrePropuesta, apellidoPropuesta, fechaIngreso, autoriza,genero,edad,fechaNacimiento,
        lugarResidencia, escolaridad,experiencia);
        
        if(this.inicio == null){
            this.inicio = nuevo;
            if(this.fin == null){
                this.fin = this.inicio;
            }
        }else{
            this.fin.setEnlace(nuevo);
            this.fin = nuevo;
        }
    }

    public URyS obtenerLista() {
        return inicio;
    }
    public int getIdNext(){
        if(inicio!=null){
            return Integer.parseInt(this.fin.getId())+1;
        }else{
            return 1;
        }
     
    };
}
