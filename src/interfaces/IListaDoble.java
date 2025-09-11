package interfaces;

public interface IListaDoble {

//--------------------------------------------------------------
    // Getters - Setters


    // Pre: Lista creada
    // Pos: Devuelve el primer nodo
    // Ax: getPrimero() = primer nodo o null si vacía
    public INodo getPrimero();

    // Pre: Lista creada
    // Pos: El primer nodo es actualizado
    // Ax: getPrimero() = nuevoPrimero luego de setPrimero(nuevoPrimero)
    public void setPrimero(INodo nuevoPrimero);

    // Pre: Lista creada
    // Pos: Devuelve el último nodo
    // Ax: getUltimo() = último nodo o null si vacía
    public INodo getUltimo();

    // Pre: Lista creada
    // Pos: El último nodo es actualizado
    // Ax: getUltimo() = nuevoUltimo luego de setUltimo(nuevoUltimo)
    public void setUltimo(INodo nuevoUltimo);

    // Pre: Lista creada
    // Pos: Devuelve la cantidad de nodos
    // Ax: getCantidad() = cantidad de nodos
    public int getCantidad();
    
    // Pre: Lista creada
    // Pos: La cantidad de nodos es actualizada
    // Ax: getCantidad() = nuevaCantidad luego de setCantidad(nuevaCantidad)
    public void setCantidad(int nuevaCantidad);

//--------------------------------------------------------------
    // Metodos


    // Pre: Lista creada
    // Pos: Retorna true si la lista está vacía
    // Ax: esVacia() <=> getCantidad() == 0
    public boolean esVacia();

    // Pre: dato definido
    // Pos: Inserta el nodo al inicio
    // Ax: getPrimero() = dato luego de insertarPrimero(dato)
    public void insertarPrimero(INodo dato);

    // Pre: dato definido
    // Pos: Inserta el nodo al final
    // Ax: getUltimo() = dato luego de insertarUltimo(dato)
    public void insertarUltimo(INodo dato);

    // Pre: posicion válida, dato definido
    // Pos: Inserta el nodo en la posición indicada
    // Ax: obtenerPosicion(posicion) = dato luego de insertarPosicion(dato, posicion)
    public void insertarPosicion(INodo dato, int posicion);

    // Pre: Lista no vacía
    // Pos: Elimina el primer nodo
    // Ax: getPrimero() cambia luego de eliminarPrimero()
    public void eliminarPrimero();

    // Pre: Lista no vacía
    // Pos: Elimina el último nodo
    // Ax: getUltimo() cambia luego de eliminarUltimo()
    public void eliminarUltimo();

    // Pre: posicion válida
    // Pos: Elimina el nodo en la posición indicada
    // Ax: obtenerPosicion(posicion) cambia luego de eliminarPosicion(posicion)
    public  void eliminarPosicion(int posicion);

    // Pre: Lista no vacía
    // Pos: Retorna el dato del primer nodo
    // Ax: obtenerPrimero() = getPrimero().getDato()
<<<<<<< HEAD
    public IVehiculo obtenerPrimero();
=======
    public int obtenerPrimero();
>>>>>>> main

    // Pre: Lista no vacía
    // Pos: Retorna el dato del último nodo
    // Ax: obtenerUltimo() = getUltimo().getDato()
<<<<<<< HEAD
    public IVehiculo obtenerUltimo();
=======
    public int obtenerUltimo();
>>>>>>> main

    // Pre: posicion válida
    // Pos: Retorna el dato del nodo en la posición indicada
    // Ax: obtenerPosicion(posicion) = nodo en esa posición
<<<<<<< HEAD
    public IVehiculo obtenerPosicion(int posicion);
=======
    public  int obtenerPosicion(int posicion);
>>>>>>> main

    // Pre: Lista creada
    // Pos: Retorna la cantidad de nodos
    // Ax: cantidadElementos() = getCantidad()
    public int cantidadElementos();

<<<<<<< HEAD
    // Pre: patente definida
    // Pos: Devuelve la posición del vehículo con esa patente o -1 si no está
    // Ax: buscarSecuencial(patente) = posición o -1
    public  int buscarSecuencial(String patente);
=======
    // Pre: dato definido
    // Pos: Devuelve la posición del dato o -1 si no está
    // Ax: buscarSecuencial(dato) = posición o -1
    public  int buscarSecuencial(int dato);
>>>>>>> main

    // Pre: Lista creada
    // Pos: Ordena los nodos en forma ascendente
    // Ax: nodos quedan ordenados tras ordenarLista()
    public  void ordenarLista();

    // Pre: Lista creada
    // Pos: Muestra los nodos por consola
    // Ax: mostrarLista() imprime todos los nodos
    public void mostrarLista();

}
