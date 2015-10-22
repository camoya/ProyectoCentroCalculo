/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usac.centrocalculo.nodos;

import java.util.Date;

/**
 *
 * @author Cristhofer Moya
 */
public class URyS {
    private String id;
    private String dependencia ;
    private String tituloPuesto;
    private String partida;
    private String salario ;
    private String horarioDias;
    private String horarioHoras;
    private String motivoVacante;
    private String nombres;
    private String apellidos;
    private String registroPersonal;
    private String vigenciaPuesto;
    private String nombrePropuesta;
    private String apellidoPropuesta ;
    private String fechaIngreso ;
    private String autoriza;
    private String genero ;
    private String edad;
    private String fechaNacimiento;
    private String lugarResidencia;
    private String escolaridad;
    private String experiencia;
    private URyS enlace;

    public URyS() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getTituloPuesto() {
        return tituloPuesto;
    }

    public void setTituloPuesto(String tituloPuesto) {
        this.tituloPuesto = tituloPuesto;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getHorarioDias() {
        return horarioDias;
    }

    public void setHorarioDias(String horarioDias) {
        this.horarioDias = horarioDias;
    }

    public String getHorarioHoras() {
        return horarioHoras;
    }

    public void setHorarioHoras(String horarioHoras) {
        this.horarioHoras = horarioHoras;
    }

    public String getMotivoVacante() {
        return motivoVacante;
    }

    public void setMotivoVacante(String motivoVacante) {
        this.motivoVacante = motivoVacante;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRegistroPersonal() {
        return registroPersonal;
    }

    public void setRegistroPersonal(String registroPersonal) {
        this.registroPersonal = registroPersonal;
    }

    public String getVigenciaPuesto() {
        return vigenciaPuesto;
    }

    public void setVigenciaPuesto(String vigenciaPuesto) {
        this.vigenciaPuesto = vigenciaPuesto;
    }

    public String getNombrePropuesta() {
        return nombrePropuesta;
    }

    public void setNombrePropuesta(String nombrePropuesta) {
        this.nombrePropuesta = nombrePropuesta;
    }

    public String getApellidoPropuesta() {
        return apellidoPropuesta;
    }

    public void setApellidoPropuesta(String apellidoPropuesta) {
        this.apellidoPropuesta = apellidoPropuesta;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getAutoriza() {
        return autoriza;
    }

    public void setAutoriza(String autoriza) {
        this.autoriza = autoriza;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLugarResidencia() {
        return lugarResidencia;
    }

    public void setLugarResidencia(String lugarResidencia) {
        this.lugarResidencia = lugarResidencia;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public URyS getEnlace() {
        return enlace;
    }

    public void setEnlace(URyS enlace) {
        this.enlace = enlace;
    }

    public URyS(String id, String dependencia, String tituloPuesto, String partida, String salario, 
            String horarioDias, String horarioHoras, String motivoVacante, String nombres, 
            String apellidos, String registroPersonal, String vigenciaPuesto, String nombrePropuesta, 
            String apellidoPropuesta, String fechaIngreso, String autoriza, String genero, String edad, 
            String fechaNacimiento, String lugarResidencia, String escolaridad, String experiencia) {
        this.id = id;
        this.dependencia = dependencia;
        this.tituloPuesto = tituloPuesto;
        this.partida = partida;
        this.salario = salario;
        this.horarioDias = horarioDias;
        this.horarioHoras = horarioHoras;
        this.motivoVacante = motivoVacante;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.registroPersonal = registroPersonal;
        this.vigenciaPuesto = vigenciaPuesto;
        this.nombrePropuesta = nombrePropuesta;
        this.apellidoPropuesta = apellidoPropuesta;
        this.fechaIngreso = fechaIngreso;
        this.autoriza = autoriza;
        this.genero = genero;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.lugarResidencia = lugarResidencia;
        this.escolaridad = escolaridad;
        this.experiencia = experiencia;
        this.enlace = null;
    }

    
}
