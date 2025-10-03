package model;

import interfaces.IArbol;
import interfaces.INodo;
public class Arbol<T extends Comparable<T>> implements IArbol<T> {
    
    private INodo<T> raiz;
    private int cantNodos;
    
// ---- Constructor

    public Arbol() {
        this.raiz = null;
        this.cantNodos = 0;
    }


// ---- Getters y Setters

    @Override
    public INodo<T> getRaiz() {
        return raiz;
    }
    @Override
    public void setRaiz(INodo<T> nuevaRaiz) {
        raiz = nuevaRaiz;
    }

    @Override
    public int getCantNodos() {
        return cantNodos;
    }
    @Override        
    public void setCantNodos(int nuevaCantNodos) {
        cantNodos = nuevaCantNodos;
    }


// ---- Metodos de la interfaz IArbol

    @Override
    public void insertar(T dato) {
        raiz = insertarRecursivo(raiz, dato);
        cantNodos++;
    }

    @Override
    public boolean buscar(T dato) {
        // Implementación del metodo buscar
        return false;
    }

    @Override
    public void recorridoInorden() {
        // Implementación del metodo recorridoInorden
    }

    @Override
    public void recorridoPreorden() {
        // Implementación del metodo recorridoPreorden
    }

    @Override
    public void recorridoPostorden() {
        // Implementación del metodo recorridoPostorden
    }

    @Override
    public void eliminar(T dato) {
        // Implementación del metodo eliminar
    }

    @Override
    public String toString() {
        return "Arbol con " + cantNodos + " nodos.";
    }


// ---- Metodos privados auxiliares

    private INodo<T> insertarRecursivo(INodo<T> nodo, T dato) {
        if (nodo == null) {
            return new Nodo<>(dato);
        }

        if (dato < nodo.getDato()) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), dato));
        } else if (dato > nodo.getDato()) {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), dato));
        } else {
            return nodo; // no permite duplicados
        }

        return nodo;
    }









}