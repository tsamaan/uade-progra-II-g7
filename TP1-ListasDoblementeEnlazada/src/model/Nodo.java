package model;

import interfaces.INodo;
import interfaces.IVehiculo;

public class Nodo<T> implements INodo<T>{
    
    private T dato;
    private INodo<T> siguiente;
    private INodo<T> anterior;

    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    @Override
    public T getDato() {
        return dato;
    }

    @Override
    public void setDato(T nuevoDato) {
        this.dato = nuevoDato;
    }

    @Override
    public INodo<T> getSiguiente() {
        return siguiente;
    }

    @Override
    public void setSiguiente(INodo<T> nuevoSiguiente) {
        this.siguiente = nuevoSiguiente;
    }

    @Override
    public INodo<T> getAnterior() {
        return anterior;
    }

    @Override
    public void setAnterior(INodo<T> nuevoAnterior) {
        this.anterior = nuevoAnterior;
    }

    @Override
    public String toString() {
        String anteriorPatente = (anterior != null && anterior.getDato() != null) ? ((IVehiculo) anterior.getDato()).getPatente() : "null";
        String siguientePatente = (siguiente != null && siguiente.getDato() != null) ? ((IVehiculo) siguiente.getDato()).getPatente() : "null";
        return "\n-----------------------------" +
               "\n Nodo:" +
               "\n   Anterior:  " + anteriorPatente +
               "\n   Vehiculo:  " + dato.toString() +
               "\n   Siguiente: " + siguientePatente +
               "\n-----------------------------\n";
    }
}
