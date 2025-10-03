package model;

import interfaces.INodo;
public class Nodo<T> implements interfaces.INodo<T> {
    
    private T dato;
    private INodo<T> izquierdo;
    private INodo<T> derecho;

// ---- Constructor

    public Nodo(T dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }

// ---- Getters y Setters

    @Override
    public T getDato() {
        return dato;
    }
    @Override
    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public INodo<T> getIzquierdo() {
        return izquierdo;
    }
    @Override
    public void setIzquierdo(INodo<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    @Override
    public INodo<T> getDerecho() {
        return derecho;
    }
    @Override
    public void setDerecho(INodo<T> derecho) {
        this.derecho = derecho;
    }

    @Override
    public String toString() {
        return dato.toString();
    }
    
}
