package interfaces;

import java.util.List;

public interface INodo<T> {
    
    // Pre: El nodo debe estar inicializado
    // Pos: Retorna el dato almacenado en el nodo
    // Ax: getDato() = dato almacenado en el nodo
    public T getDato();

    // Pre: dato != null
    // Pos: El nodo almacena el nuevo dato
    // Ax: setDato(dato) → getDato() = dato
    public void setDato(T dato);

    // Pre: destino != null && peso > 0
    // Pos: Agrega un nodo vecino con el peso asociado
    // Ax: agregarVecino(destino, peso) --> getVecino() contiene destino con peso asociado
    public void agregarVecino(INodo<T> destino, int peso);

    // Pre: El nodo debe estar inicializado
    // Pos: Retorna el nodo vecino asociado
    // Ax: getVecino() = nodo vecino asociado
    public List<INodo<T>> getVecinos();

    // Pre: El nodo debe estar inicializado
    // Pos: Retorna el peso asociado al nodo vecino
    // Ax: getPeso() = peso asociado al nodo vecino
    public List<Integer> getPesos();

    // Pre: El nodo debe estar inicializado
    // Pos: Retorna una representacion en cadena del nodo
    // Ax: toString() = representacion textual del nodo con su dato
    public String toString();
}