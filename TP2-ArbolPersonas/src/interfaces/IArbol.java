package interfaces;

public interface IArbol<T> {
    
    // Pre: El arbol debe estar inicializado
    // Pos: Retorna el nodo raiz del arbol
    // Ax: getRaiz() = nodo raiz del arbol
    public INodo<T> getRaiz();
    
    // Pre: El arbol debe estar inicializado
    // Pos: Establece nuevaRaiz como el nodo raiz del arbol
    // Ax: setRaiz(nuevaRaiz) -> getRaiz() = nuevaRaiz
    public void setRaiz(INodo<T> nuevaRaiz);
    
    // Pre: El arbol debe estar inicializado
    // Pos: Retorna la cantidad total de nodos en el arbol
    // Ax: getCantNodos() = numero total de nodos en el arbol
    public int getCantNodos();
    
    // Pre: nuevaCantNodos >= 0
    // Pos: Actualiza el contador de nodos del arbol
    // Ax: setCantNodos(n) -> getCantNodos() = n
    public void setCantNodos(int nuevaCantNodos);
    
    // Pre: dato != null, comparador != null
    // Pos: El dato se inserta en el arbol respetando el orden BST
    // Ax: insertar(dato) -> buscar(dato) = true
    public INodo<T> insertarRecursivo(INodo<T> nodo, T dato, IComparadorPersona comparador);

    // Pre: dato != null, comparador != null
    // Pos: Retorna true si el dato esta en el arbol, false en caso contrario
    // Ax: buscar(dato) = true <-> dato esta en arbol
    public boolean buscarRecursivo(INodo<T> nodo, T dato, IComparadorPersona comparador);

    // Pre: El arbol debe estar inicializado
    // Pos: Imprime los elementos del arbol en orden (izq-raiz-der)
    // Ax: recorridoInorden() = secuencia ordenada ascendente de elementos
    public void recorridoInorden();
    
    // Pre: El arbol debe estar inicializado
    // Pos: Imprime los elementos del arbol en preorden (raiz-izq-der)
    // Ax: recorridoPreorden() = secuencia con raiz primero, luego subarboles
    public void recorridoPreorden();
    
    // Pre: El arbol debe estar inicializado
    // Pos: Imprime los elementos del arbol en postorden (izq-der-raiz)
    // Ax: recorridoPostorden() = secuencia con subarboles primero, luego raiz
    public void recorridoPostorden();

    // Pre: dato != null, comparador != null
    // Pos: Elimina el dato del arbol manteniendo la propiedad BST
    // Ax: eliminar(dato) -> buscar(dato) = false
    public INodo<T> eliminarRecursivo(INodo<T> nodo, T dato, IComparadorPersona comparador);

    // Pre: El arbol debe estar inicializado
    // Pos: Retorna una representacion en cadena del arbol
    // Ax: toString() = representacion textual del arbol con sus elementos
    public String toString();

    



}
