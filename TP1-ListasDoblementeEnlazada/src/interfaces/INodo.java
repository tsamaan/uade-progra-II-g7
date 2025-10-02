package interfaces;

public interface INodo<T> {

    // Pre: Nodo creado
    // Pos: Devuelve el dato almacenado
    // Ax: getDato() = dato
    T getDato();
    
    // Pre: Nodo creado
    // Pos: El dato es actualizado
    // Ax: getDato() = nuevoDato luego de setDato(nuevoDato)
    void setDato(T nuevoDato);

    // Pre: Nodo creado
    // Pos: Devuelve el siguiente nodo
    // Ax: getSiguiente() = siguiente
    INodo<T> getSiguiente();

    // Pre: Nodo creado
    // Pos: El siguiente nodo es actualizado
    // Ax: getSiguiente() = nuevoSiguiente luego de setSiguiente(nuevoSiguiente)
    void setSiguiente(INodo<T> nuevoSiguiente);
    
    // Pre: Nodo creado
    // Pos: Devuelve el nodo anterior
    // Ax: getAnterior() = anterior
    INodo<T> getAnterior();
    
    // Pre: Nodo creado
    // Pos: El nodo anterior es actualizado
    // Ax: getAnterior() = nuevoAnterior luego de setAnterior(nuevoAnterior)
    void setAnterior(INodo<T> nuevoAnterior);

    // Pre: Nodo creado
    // Pos: Devuelve una representación en texto del nodo
    // Ax: toString() describe el nodo y su dato
    @Override    
    String toString();

}
