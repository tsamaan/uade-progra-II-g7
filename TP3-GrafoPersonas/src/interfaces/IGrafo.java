package interfaces;

public interface IGrafo<T> {

    // Pre: vertice != null
    // Pos: Agrega un vertice al grafo
    // Ax: agregarArista(Arista) --> el grafo contiene vertice
    public void agregarArista(T Origen, T Destino, int peso);

    //pre: vertice != null
    //pos: elimina una arista del grafo
    //Ax: eliminarArista(Arista) --> el grafo no contiene vertice
    public void eliminarArista(T Origen, T Destino, int peso);

    // Pre: valor != null
    // Pos: Agrega un nodo al grafo
    // Ax: agregarNodo(valor) --> el grafo contiene un nodo con valor
    public void agregarNodo(T valor);
    
    // Pre: valor != null
    // Pos: Elimina un nodo del grafo
    // Ax: eliminarNodo(valor) --> el grafo no contiene un nodo con valor
    public void eliminarNodo(T valor);

    // Pre: El grafo debe estar inicializado
    // Pos: Muestra la matriz de adyacencia del grafo
    // Ax: mostrarMatrizAdyacencia() --> muestra la matriz de adyacencia por consola
    public void mostrarMatrizAdyacencia();

    // Pre: El grafo debe estar inicializado
    // Pos: Realiza un recorrido BFS desde el nodo de inicio
    // Ax: bfs(inicio) --> recorre el grafo en anchura desde el nodo inicio
    public void bfs(T inicio);

    // Pre: El grafo debe estar inicializado
    // Pos: Realiza un recorrido DFS desde el nodo de inicio
    // Ax: dfs(inicio) --> recorre el grafo en profundidad desde el nodo inicio
    public void dfs(T inicio);
}


