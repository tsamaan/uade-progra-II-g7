package model;

import interfaces.INodo;
import interfaces.IArista;

public class Arista<T> implements IArista<T> {
    
    private INodo<T> destino;
    private int peso;

// ---- Constructor
    
// Crea una nueva arista hacia un nodo destino con un peso especifico.
    public Arista(INodo<T> destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }

    // ---- Getters y Setters
    
    public INodo<T> getDestino() {
        return destino;
    }

    public void setDestino(INodo<T> destino) {
        this.destino = destino;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

// ---- Metodos
    
    @Override
    public String toString() {
        return destino.getDato() + "(" + peso + ")";
    }
    
}
