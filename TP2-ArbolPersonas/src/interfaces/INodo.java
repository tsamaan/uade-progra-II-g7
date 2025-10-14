package interfaces;

public interface INodo<T> {
    
    // Pre: El nodo debe estar inicializado
    // Pos: Retorna el dato almacenado en el nodo
    // Ax: getDato() = dato almacenado en el nodo
    public T getDato();

    // Pre: dato != null
    // Pos: El nodo almacena el nuevo dato
    // Ax: setDato(dato) → getDato() = dato
    public void setDato(T dato);

    // Pre: El nodo debe estar inicializado
    // Pos: Retorna la referencia al hijo izquierdo o null si no existe
    // Ax: getIzquierdo() = referencia al nodo hijo izquierdo o null
    public INodo<T> getIzquierdo();

    // Pre: -
    // Pos: Establece el hijo izquierdo del nodo
    // Ax: setIzquierdo(nodo) -> getIzquierdo() = nodo
    public void setIzquierdo(INodo<T> izquierdo);

    // Pre: El nodo debe estar inicializado
    // Pos: Retorna la referencia al hijo derecho o null si no existe
    // Ax: getDerecho() = referencia al nodo hijo derecho o null
    public INodo<T> getDerecho();

    // Pre: -
    // Pos: Establece el hijo derecho del nodo
    // Ax: setDerecho(nodo) -> getDerecho() = nodo
    public void setDerecho(INodo<T> derecho);

    // Pre: El nodo debe estar inicializado
    // Pos: Retorna una representacion en cadena del nodo
    // Ax: toString() = representacion textual del nodo con su dato
    public String toString();
}