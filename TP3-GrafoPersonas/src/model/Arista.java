package model;

import interfaces.INodo;

/**
 * Clase que representa una arista en un grafo.
 * Encapsula el nodo destino y el peso de la conexión.
 * 
 * @param <T> Tipo genérico del dato almacenado en los nodos
 */
public class Arista<T> {
    
    private INodo<T> destino;
    private int peso;

    // ---- Constructor
    
    /**
     * Crea una nueva arista hacia un nodo destino con un peso específico.
     * 
     * @param destino Nodo de destino de la arista
     * @param peso Peso o costo de la arista
     */
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

    // ---- Métodos
    
    @Override
    public String toString() {
        return destino.getDato() + "(" + peso + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        @SuppressWarnings("unchecked")
        Arista<T> other = (Arista<T>) obj;
        
        return peso == other.peso && 
               destino.getDato().equals(other.destino.getDato());
    }

    @Override
    public int hashCode() {
        int result = destino.getDato().hashCode();
        result = 31 * result + peso;
        return result;
    }
}
