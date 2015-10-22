/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usac.centrocalculo.listas;

import usac.centrocalculo.nodos.FormaCeroCuatroUno;

/**
 *
 * @author Cristhofer Moya
 */
public class ListaFormaCeroCuatroUno {
      FormaCeroCuatroUno cabeza;
    int cantidad;

    public ListaFormaCeroCuatroUno() {
        this.cabeza = null;
        this.cantidad = 0;
    }
    

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void insetarCeroCuatroUno(FormaCeroCuatroUno accesorios) {
        if (cabeza == null) {
            cabeza = accesorios;
            cantidad++;
        } else {
            FormaCeroCuatroUno actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(accesorios);
            cantidad++;
        }
    }

    public FormaCeroCuatroUno getCabeza() {
        return cabeza;
    }

    public void setCabeza(FormaCeroCuatroUno cabeza) {
        this.cabeza = cabeza;
    }

    public void elminarCeroCuatroUno() {
        if (cabeza != null) {
            FormaCeroCuatroUno actual = cabeza;
            FormaCeroCuatroUno anteriorActual = null;
            while (actual.getSiguiente() != null) {
                anteriorActual = actual;
                actual = actual.getSiguiente();
            }
            if (anteriorActual == null) {
                cabeza = null;
            } else {
                anteriorActual.setSiguiente(null);
            }
            System.out.println("Se elimino exitosamente");
            System.out.println("                          ");
        } else {
            System.out.println("No hay CeroCuatroUnos que elimnar");
            System.out.println("                          ");
        }

    }

}
