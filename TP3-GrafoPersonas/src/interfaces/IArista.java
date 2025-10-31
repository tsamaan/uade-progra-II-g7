package interfaces;

/**
 * Interfaz que define el comportamiento de una arista en un grafo.
 * Una arista representa una conexión entre nodos con un peso asociado.
 * 
 * @param <T> Tipo genérico del dato almacenado en los nodos
 */
public interface IArista<T> {
    
    /**
     * Obtiene el nodo destino de la arista.
     * 
     * @pre true
     * @post Retorna el nodo destino de la arista
     * @return INodo<T> - El nodo destino de la arista
     * @axioma El nodo destino retornado es el mismo que fue establecido en la creación o última modificación
     */
    INodo<T> getDestino();

    /**
     * Establece el nodo destino de la arista.
     * 
     * @pre destino != null
     * @post El nodo destino de la arista es actualizado al nuevo valor
     * @param destino Nuevo nodo destino de la arista
     * @axioma Después de setDestino(d), getDestino() retorna d
     */
    void setDestino(INodo<T> destino);

    /**
     * Obtiene el peso o costo de la arista.
     * 
     * @pre true
     * @post Retorna el peso actual de la arista
     * @return int - El peso de la arista
     * @axioma El peso retornado es el mismo que fue establecido en la creación o última modificación
     */
    int getPeso();

    /**
     * Establece el peso de la arista.
     * 
     * @pre true (puede aceptar cualquier valor entero)
     * @post El peso de la arista es actualizado al nuevo valor
     * @param peso Nuevo peso de la arista
     * @axioma Después de setPeso(p), getPeso() retorna p
     */
    void setPeso(int peso);

    /**
     * Compara esta arista con otro objeto para determinar si son iguales.
     * Dos aristas son iguales si tienen el mismo destino y peso.
     * 
     * @pre obj != null
     * @post Retorna true si las aristas son iguales, false en caso contrario
     * @param obj Objeto a comparar con esta arista
     * @return boolean - true si son iguales, false si no lo son
     * @axioma a1.equals(a2) implica a2.equals(a1)
     * @axioma Si a1.equals(a2) entonces a1.hashCode() == a2.hashCode()
     */
    boolean equals(Object obj);

    /**
     * Genera un código hash para la arista basado en su destino y peso.
     * 
     * @pre true
     * @post Retorna un código hash único para esta arista
     * @return int - El código hash de la arista
     * @axioma Si a1.equals(a2) entonces a1.hashCode() == a2.hashCode()
     */
    int hashCode();

    /**
     * Retorna una representación en String de la arista.
     * 
     * @pre true
     * @post Retorna un String que representa la arista en formato "destino(peso)"
     * @return String - Representación textual de la arista
     * @axioma El String retornado contiene tanto la información del destino como del peso
     */
    String toString();
}