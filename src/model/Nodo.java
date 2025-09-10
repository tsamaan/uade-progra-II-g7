package model;

import interfaces.INodo;
import interfaces.IVehiculo;

public class Nodo implements INodo{
    
    private IVehiculo dato;
    private INodo siguiente;
    private INodo anterior;

    public Nodo(IVehiculo dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    @Override
    public IVehiculo getDato() {
        return dato;
    }

    @Override
    public void setDato(IVehiculo nuevoDato) {
        this.dato = nuevoDato;
    }

    @Override
    public INodo getSiguiente() {
        return siguiente;
    }

    @Override
    public void setSiguiente(INodo nuevoSiguiente) {
        this.siguiente = nuevoSiguiente;
    }

    @Override
    public INodo getAnterior() {
        return anterior;
    }

    @Override
    public void setAnterior(INodo nuevoAnterior) {
        this.anterior = nuevoAnterior;
    }

    @Override
    public String toString() {
        String anteriorPatente = (anterior != null && anterior.getDato() != null) ? anterior.getDato().getPatente() : "null";
        String siguientePatente = (siguiente != null && siguiente.getDato() != null) ? siguiente.getDato().getPatente() : "null";
        return "\n-----------------------------" +
               "\n Nodo:" +
               "\n   Anterior:  " + anteriorPatente +
               "\n   Vehiculo:  " + dato.toString() +
               "\n   Siguiente: " + siguientePatente +
               "\n-----------------------------\n";
    }

}
