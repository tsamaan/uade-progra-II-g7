package model;

import interfaces.IArbol;
import interfaces.INodo;
import java.util.Comparator;

public class Arbol<T> implements IArbol<T> {
    
    private INodo<T> raiz;
    private int cantNodos;
    private Comparator<T> comparador;
    
// ---- Constructor

    public Arbol(Comparator<T> comparador) {
        this.raiz = null;
        this.cantNodos = 0;
        this.comparador = comparador;
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
    public INodo<T> insertarRecursivo(INodo<T> nodo, T dato) {
        if (nodo == null) {
            cantNodos++;
            return new Nodo<>(dato); // Crear y retornar el nuevo nodo insertado.
        }

        int comparacion = comparador.compare(dato, nodo.getDato());
        
        if (comparacion < 0) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), dato));
        } 
        else if (comparacion > 0) {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), dato));
        } 
        else {
            return nodo; // no permite duplicados
        }

        return nodo;
    }

    @Override
    public boolean buscarRecursivo(INodo<T> nodo, T dato){
        if (nodo == null) {
            return false;
        }

        int comparacion = comparador.compare(dato, nodo.getDato());
        
        if (comparacion == 0) {
            return true; // Elemento encontrado
        } else if (comparacion < 0) {
            return buscarRecursivo(nodo.getIzquierdo(), dato);
        } else {
            return buscarRecursivo(nodo.getDerecho(), dato);
        }
    }


    @Override
    public void recorridoInorden(INodo<T> nodo) {
        if (nodo != null) {
            recorridoInorden(nodo.getIzquierdo());   // Recorrer subárbol izquierdo
            System.out.println(nodo.getDato());      // Procesar nodo actual
            recorridoInorden(nodo.getDerecho());     // Recorrer subárbol derecho
        }
    }

    @Override
    public void recorridoPreorden(INodo<T> nodo) {
        if (nodo != null) {
            System.out.println(nodo.getDato());      // Procesar nodo actual
            recorridoPreorden(nodo.getIzquierdo());  // Recorrer subárbol izquierdo
            recorridoPreorden(nodo.getDerecho());    // Recorrer subárbol derecho
        }
    }

    @Override
    public void recorridoPostorden(INodo<T> nodo) {
        if (nodo != null) {
            recorridoPostorden(nodo.getIzquierdo()); // Recorrer subárbol izquierdo
            recorridoPostorden(nodo.getDerecho());   // Recorrer subárbol derecho
            System.out.println(nodo.getDato());      // Procesar nodo actual
        }
    }


    @Override
    public INodo<T> eliminarRecursivo(INodo<T> nodo, T dato) {
         // CASO 1: Nodo no encontrado (árbol vacío o llegamos al final)
        if (nodo == null) {
            return null; // No hay nada que eliminar
        }

        int comparacion = comparador.compare(dato, nodo.getDato());
        
        // Navegar hacia la izquierda o derecha para encontrar el nodo
        if (comparacion < 0) {
            nodo.setIzquierdo(eliminarRecursivo(nodo.getIzquierdo(), dato));
        } else if (comparacion > 0) {
            nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), dato));
        } else {
            // NODO ENCONTRADO - Proceder con los 4 casos de eliminación
            cantNodos--; // Decrementar contador solo cuando eliminamos realmente
            
            // CASO 2: Nodo hoja (sin hijos)
            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                return null;
            }
            // CASO 3a: Nodo con solo hijo derecho
            else if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            }
            // CASO 3b: Nodo con solo hijo izquierdo
            else if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }
            // CASO 4: Nodo con dos hijos
            else {
                // Encontrar el sucesor inorden (menor del subárbol derecho)
                INodo<T> sucesor = encontrarMinimo(nodo.getDerecho());
                // Reemplazar el dato del nodo actual con el del sucesor
                nodo.setDato(sucesor.getDato());
                // Eliminar el sucesor (compensar contador porque será decrementado nuevamente)
                cantNodos++;
                nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), sucesor.getDato()));
            }
        }
        
        return nodo;
    }

    // Método auxiliar para encontrar el nodo mínimo (más a la izquierda)
    private INodo<T> encontrarMinimo(INodo<T> nodo) {
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }
        return nodo;
    }


    @Override
    public String toString() {
        return "Arbol con " + cantNodos + " nodos.";
    }

}