/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usac.centrocalculo.nodos;

/**
 *
 * @author Cristhofer Moya
 */
public class FormaCeroCuatroUno {
    private int noPlaza;
    private String vigenciaContratoInicio;
    private String vigenciaContratoFin;
    private String estudiosRealizados;
    private String experiencialLaboral;
    private String vigenciaAutorizadoraInicio;
    private String vigenciaAutorizadoraFin;
    private String observaciones;
    private String fechaRecibido;
    private String puesto;
    private String dependencia;
    private String motivo;
    private String nombrePersona;
    private String registroPersona;
    private FormaCeroCuatroUno siguiente;
    private FormaCeroCuatroUno anterior;
    

    public FormaCeroCuatroUno(int noPlaza, String vigenciaContratoInicio, String vigenciaContratoFin, String estudiosRealizados, String experiencialLaboral, String vigenciaAutorizadoraInicio, String vigenciaAutorizadoraFin, String observaciones, String fechaRecibido, String puesto, String dependencia, String motivo, String nombrePersona, String registroPersona) {
        this.noPlaza = noPlaza;
        this.vigenciaContratoInicio = vigenciaContratoInicio;
        this.vigenciaContratoFin = vigenciaContratoFin;
        this.estudiosRealizados = estudiosRealizados;
        this.experiencialLaboral = experiencialLaboral;
        this.vigenciaAutorizadoraInicio = vigenciaAutorizadoraInicio;
        this.vigenciaAutorizadoraFin = vigenciaAutorizadoraFin;
        this.observaciones = observaciones;
        this.fechaRecibido = fechaRecibido;
        this.puesto = puesto;
        this.dependencia = dependencia;
        this.motivo = motivo;
        this.nombrePersona = nombrePersona;
        this.registroPersona = registroPersona;
    }
    

    public int getNoPlaza() {
        return noPlaza;
    }

    public void setNoPlaza(int noPlaza) {
        this.noPlaza = noPlaza;
    }

    public String getVigenciaContratoInicio() {
        return vigenciaContratoInicio;
    }

    public void setVigenciaContratoInicio(String vigenciaContratoInicio) {
        this.vigenciaContratoInicio = vigenciaContratoInicio;
    }

    public String getVigenciaContratoFin() {
        return vigenciaContratoFin;
    }

    public void setVigenciaContratoFin(String vigenciaContratoFin) {
        this.vigenciaContratoFin = vigenciaContratoFin;
    }

    public String getEstudiosRealizados() {
        return estudiosRealizados;
    }

    public void setEstudiosRealizados(String estudiosRealizados) {
        this.estudiosRealizados = estudiosRealizados;
    }

    public String getExperiencialLaboral() {
        return experiencialLaboral;
    }

    public void setExperiencialLaboral(String experiencialLaboral) {
        this.experiencialLaboral = experiencialLaboral;
    }

    public String getVigenciaAutorizadoraInicio() {
        return vigenciaAutorizadoraInicio;
    }

    public void setVigenciaAutorizadoraInicio(String vigenciaAutorizadoraInicio) {
        this.vigenciaAutorizadoraInicio = vigenciaAutorizadoraInicio;
    }

    public String getVigenciaAutorizadoraFin() {
        return vigenciaAutorizadoraFin;
    }

    public void setVigenciaAutorizadoraFin(String vigenciaAutorizadoraFin) {
        this.vigenciaAutorizadoraFin = vigenciaAutorizadoraFin;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getFechaRecibido() {
        return fechaRecibido;
    }

    public void setFechaRecibido(String fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public FormaCeroCuatroUno getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(FormaCeroCuatroUno siguiente) {
        this.siguiente = siguiente;
    }

    public FormaCeroCuatroUno getAnterior() {
        return anterior;
    }

    public void setAnterior(FormaCeroCuatroUno anterior) {
        this.anterior = anterior;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getRegistroPersona() {
        return registroPersona;
    }

    public void setRegistroPersona(String registroPersona) {
        this.registroPersona = registroPersona;
    }
    
}
