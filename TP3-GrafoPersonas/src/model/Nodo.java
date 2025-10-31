package model;

import interfaces.INodo;
import interfaces.IPersonaIArista;

import java.util.ArrayList;
import java.util.List;

public class Nodo<T> implements INodo<T> {
 
    private T dato;
    private List<Arista<T>> aristas;

// ---- Constructor
    public Nodo(T dato) {
        this.dato = dato;
        this.aristas = new ArrayList<>();
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
    public List<Arista<T>> getAristas() {
        return aristas;
    }

// ---- Metodos
    @Override
    public void agregarVecino(INodo<T> destino, int peso) {
        this.aristas.add(new Arista<>(destino, peso));
    }   

    @Override
    public String toString() {
        return "Nodo{" + "dato=" + dato + '}';
    }

}
