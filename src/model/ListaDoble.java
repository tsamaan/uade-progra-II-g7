package model;

import interfaces.IListaDoble;
import interfaces.INodo;

public class ListaDoble implements IListaDoble {
    
    private INodo primero;
    private INodo ultimo;
    private int cantidad;

//--------------------------------------------------------------

    // Constructor Full
    public ListaDoble (INodo primero, INodo ultimo, int cantidad) {
        this.primero = primero;
        this.ultimo = ultimo;
        this.cantidad = cantidad;
    }

    // Constructor vacio
    public ListaDoble() {
        this.primero = null;
        this.ultimo = null;
        this.cantidad = 0;
    }

//--------------------------------------------------------------
    
    // Getters y Setters
    public INodo getPrimero() {
        return primero;
    }

    public void setPrimero(INodo nuevoPrimero) {
        this.primero = nuevoPrimero;
    }

    public INodo getUltimo() {
        return ultimo;
    }

<<<<<<< HEAD
    public void setUltimo(INodo nuevoUltimo) {
=======
    public void setUltimo(Nodo nuevoUltimo) {
>>>>>>> main
        this.ultimo = nuevoUltimo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int nuevaCantidad) {
        this.cantidad = nuevaCantidad;
    }
    
//--------------------------------------------------------------

    // Metodos
    @Override
    public boolean esVacia() {
        return (this.cantidad == 0);
    }

    //--------------------------------------------------------------

    @Override
    public void insertarPrimero(INodo dato) {
        Nodo nuevoNodo = (Nodo) dato;
        if (esVacia()) { //pregunta si la lista esta vacia
            setPrimero(nuevoNodo); //si esta vacia ultimo y primero son el mismo
            setUltimo(nuevoNodo);
        } 
        else {
            nuevoNodo.setSiguiente(getPrimero());
            getPrimero().setAnterior(nuevoNodo);
            setPrimero(nuevoNodo);
        }

        setCantidad(getCantidad() + 1); //suma la cantidad de nodos en 1
    }

    @Override
    public void insertarUltimo(INodo dato) {
        Nodo nuevoNodo = (Nodo) dato;
        if (esVacia()) { //pregunta si la lista esta vacia
            setPrimero(nuevoNodo); //si esta vacia ultimo y primero son el mismo
            setUltimo(nuevoNodo);
        } 
        else {
            getUltimo().setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(getUltimo());
            setUltimo(nuevoNodo);
        }

        setCantidad(getCantidad() + 1); //suma la cantidad de nodos en 1
    }

    @Override
    public void insertarPosicion(INodo dato, int posicion) {
        if (posicion < 0 || posicion > cantidad) {
<<<<<<< HEAD
            return; // No hacer nada si la posición es inválida
=======
            throw new IndexOutOfBoundsException("Posición inválida");
>>>>>>> main
        }
        if (posicion == 0) {
            insertarPrimero(dato);
        } 
        else if (posicion == cantidad) {
            insertarUltimo(dato);
        } 
        else {
            Nodo nuevoNodo = (Nodo) dato;
            INodo actual = primero;

            for (int i = 0; i < posicion - 1; i++) {
                actual = actual.getSiguiente();
            }
            nuevoNodo.setSiguiente(actual.getSiguiente());
            nuevoNodo.setAnterior(actual);
            actual.getSiguiente().setAnterior(nuevoNodo);
            actual.setSiguiente(nuevoNodo);
            cantidad++;
        }
    }

    //--------------------------------------------------------------

    @Override
    public void eliminarPrimero() {
        if (esVacia()) {
<<<<<<< HEAD
            return; // No hacer nada si la lista está vacía
=======
            throw new IllegalStateException("\n[!] La lista esta vacia");
>>>>>>> main
        }
        if (cantidad == 1) { //si hay un solo nodo
            setPrimero(null);
            setUltimo(null);
        } 
        else {
            setPrimero(getPrimero().getSiguiente());
            getPrimero().setAnterior(null);
        }
        setCantidad(getCantidad() - 1); //resta la cantidad de nodos en 1
    }

    @Override
    public void eliminarUltimo() {
        if (esVacia()) {
<<<<<<< HEAD
            return; // No hacer nada si la lista está vacía
=======
            throw new IllegalStateException("\n[!] La lista esta vacia");
>>>>>>> main
        }
        if (cantidad == 1) { //si hay un solo nodo
            setPrimero(null);
            setUltimo(null);
        } 
        else {
            setUltimo(getUltimo().getAnterior());
            getUltimo().setSiguiente(null);
        }
        setCantidad(getCantidad() - 1); //resta la cantidad de nodos en 1
    }

    @Override
<<<<<<< HEAD
    public void eliminarPosicion(int posicion) {
        if (posicion < 0 || posicion >= cantidad || esVacia()) {
            return; // No hacer nada si la posición es inválida o la lista está vacía
        }
        
        if (posicion == 0) {
            eliminarPrimero();
        } else if (posicion == cantidad - 1) {
            eliminarUltimo();
        } else {
            INodo actual = primero;
            for (int i = 0; i < posicion; i++) {
                actual = actual.getSiguiente();
            }
            actual.getAnterior().setSiguiente(actual.getSiguiente());
            actual.getSiguiente().setAnterior(actual.getAnterior());
            cantidad--;
        }
    }   
=======
    public void eliminarPosicion(int posicion) {}   
>>>>>>> main

    //--------------------------------------------------------------

    @Override
<<<<<<< HEAD
    public IVehiculo obtenerPrimero() {
        if (esVacia()) {
            return null;
        }
        return getPrimero().getDato();
    }

    @Override
    public IVehiculo obtenerUltimo() {
        if (esVacia()) {
            return null;
        }
        return getUltimo().getDato();
    }

    @Override
    public IVehiculo obtenerPosicion(int posicion) {
        if (posicion < 0 || posicion >= cantidad) {
            return null;
        }
        INodo actual = primero;
        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getDato();
=======
    public int obtenerPrimero() {
        return cantidad;
    }

    @Override
    public int obtenerUltimo() {
        return cantidad;
    }

    @Override
    public int obtenerPosicion(int posicion) {
        return cantidad;
>>>>>>> main
    }

    //--------------------------------------------------------------

    @Override
    public int cantidadElementos() {
        return cantidad;
    }

    @Override
<<<<<<< HEAD
    public int buscarSecuencial(String patente) {
        if (esVacia() || patente == null) {
            return -1;
        }
        
        INodo actual = primero;
        int posicion = 0;
        
        while (actual != null) {
            if (actual.getDato() != null && patente.equals(actual.getDato().getPatente())) {
                return posicion;
            }
            actual = actual.getSiguiente();
            posicion++;
        }
        
=======
    public int buscarSecuencial(int dato) {
>>>>>>> main
        return -1;
    }

    @Override
<<<<<<< HEAD
    public void ordenarLista() {
        if (esVacia() || cantidad == 1) {
            return; // No hay nada que ordenar
        }
        
        // Usar bubble sort para ordenar por patente
        boolean intercambio;
        do {
            intercambio = false;
            INodo actual = primero;
            
            while (actual.getSiguiente() != null) {
                if (actual.getDato().getPatente().compareTo(actual.getSiguiente().getDato().getPatente()) > 0) {
                    // Intercambiar datos
                    IVehiculo temp = actual.getDato();
                    actual.setDato(actual.getSiguiente().getDato());
                    actual.getSiguiente().setDato(temp);
                    intercambio = true;
                }
                actual = actual.getSiguiente();
            }
        } while (intercambio);
    }

    @Override
    public void mostrarLista() {
        if (esVacia()) {
            System.out.println("La lista está vacía");
            return;
        }
        
        System.out.println("\n=== LISTA DE VEHÍCULOS ===");
        System.out.println("Cantidad de elementos: " + cantidad);
        System.out.println("------------------------");
        
        INodo actual = primero;
        int posicion = 0;
        
        while (actual != null) {
            System.out.println("Posición " + posicion + ": " + actual.getDato().toString());
            actual = actual.getSiguiente();
            posicion++;
        }
        
        System.out.println("========================\n");
    }

=======
    public void ordenarLista() {}

    @Override
    public void mostrarLista() {}

    @Override
    public void setUltimo(INodo nuevoUltimo) {
        this.ultimo = nuevoUltimo; //modificar despues?
    }
>>>>>>> main

    public String toString() {
        String datos = "";
        INodo actual = primero;
        while (actual != null) { // se puede hacer con for tambien por la cantidad de nodos que hay la sabemos
            datos += actual.getDato().toString() + ", ";
            actual = actual.getSiguiente();
        }
        return datos;
    }

}

