package interfaces;

public interface IArbol<T> {
    
    // Pre: dato != null
    // Pos: El dato se inserta en el arbol respetando el orden BST
    // Ax: insertar(dato) -> buscar(dato) = se imserta en arbol
    public void insertar(T dato);

    // Pre: dato != null
    // Pos: Retorna true si el dato está en el arbol, false en caso contrario
    // Ax: buscar(dato) = true <-> dato esta en arbol
    public boolean buscar(T dato);

    // Pre: El arbol debe estar inicializado
    // Pos: Imprime los elementos del arbol en orden (izq-raíz-der)
    // Ax: recorridoInorden() = secuencia ordenada ascendente de elementos
    public void recorridoInorden();
    
    // Pre: El arbol debe estar inicializado
    // Pos: Imprime los elementos del arbol en preorden (raíz-izq-der)
    // Ax: recorridoPreorden() = secuencia con raíz primero, luego subarboles
    public void recorridoPreorden();
    
    // Pre: El arbol debe estar inicializado
    // Pos: Imprime los elementos del arbol en postorden (izq-der-raíz)
    // Ax: recorridoPostorden() = secuencia con subarboles primero, luego raíz
    public void recorridoPostorden();

    // Pre: dato != null
    // Pos: Elimina el dato del arbol manteniendo la propiedad BST
    // Ax: eliminar(dato) -> buscar(dato) = false
    public void eliminar(T dato);

    // Pre: El arbol debe estar inicializado
    // Pos: Retorna una representación en cadena del arbol
    // Ax: toString() = representación textual del arbol con sus elementos
    public String toString();



}
