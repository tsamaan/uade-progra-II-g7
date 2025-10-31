package interfaces;

public interface IArista<T> {
    
    // Pre: debe estar inicializado
    // Pos: Retorna el nodo destino de la arista
    // Ax: El nodo destino retornado es el mismo que fue establecido en la creación o última modificación
    public INodo<T> getDestino();

    // Pre: destino != null
    // Pos: el nodo destino de la arista es actualizado al nuevo valor
    // Ax: despues de setDestino(d), getDestino() retorna d
    void setDestino(INodo<T> destino);

    // Pre: debe estar inicializado
    // Pos: Retorna el peso actual de la arista
    // Ax: El peso retornado es el mismo que fue establecido en la creación o última modificación
    int getPeso();

    // Pre: debe estar inicializado, puede ser cualquier valor entero
    // Pos: el peso de la arista es actualizado al nuevo valor
    // Ax: despues de setPeso(p), getPeso() retorna p
    void setPeso(int peso);

    // Pre: debe estar inicializado
    // Pos: Retorna una representación en cadena de la arista
    // Ax: La representación en cadena incluye el dato del nodo destino y el peso de la arista
    String toString();
}