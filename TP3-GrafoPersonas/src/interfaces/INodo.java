package interfaces;

import java.util.List;
import model.Arista;

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
    // Ax: agregarVecino(destino, peso) --> getAristas() contiene una arista al destino con el peso asociado
    public void agregarVecino(INodo<T> destino, int peso);

    // Pre: El nodo debe estar inicializado
    // Pos: Retorna la lista de aristas (conexiones a nodos vecinos con sus pesos)
    // Ax: getAristas() = lista de aristas del nodo
    public List<Arista<T>> getAristas();

    // Pre: El nodo debe estar inicializado
    // Pos: Retorna una representacion en cadena del nodo
    // Ax: toString() = representacion textual del nodo con su dato
    public String toString();
}