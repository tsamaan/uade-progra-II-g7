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

    public void setUltimo(Nodo nuevoUltimo) {
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
            throw new IndexOutOfBoundsException("Posición inválida");
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
            throw new IllegalStateException("\n[!] La lista esta vacia");
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
            throw new IllegalStateException("\n[!] La lista esta vacia");
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
    public void eliminarPosicion(int posicion) {}   

    //--------------------------------------------------------------

    @Override
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
    }

    //--------------------------------------------------------------

    @Override
    public int cantidadElementos() {
        return cantidad;
    }

    @Override
    public int buscarSecuencial(int dato) {
        return -1;
    }

    @Override
    public void ordenarLista() {}

    @Override
    public void mostrarLista() {}

    @Override
    public void setUltimo(INodo nuevoUltimo) {
        this.ultimo = nuevoUltimo; //modificar despues?
    }

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

