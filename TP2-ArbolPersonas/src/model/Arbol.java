package model;

import interfaces.IArbol;
import interfaces.INodo;
import interfaces.IComparadorPersona;


public class Arbol<T> implements IArbol<T> {
    
    private INodo<T> raiz;
    private int cantNodos;
    private IComparadorPersona comparador;
    
// ---- Constructor

    public Arbol(IComparadorPersona comparador) {
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

    @Override                                                   // Se usa un callback para comparar 
    public INodo<T> insertarRecursivo(INodo<T> nodo, T dato, IComparadorPersona comparador) {
         // Caso base: Si el nodo es null, hemos encontrado la posición para insertar
        if (nodo == null) {
            cantNodos++;
            return new Nodo<>(dato); // Crear y retornar el nuevo nodo insertado.
        }

        int comparacion = comparador.compare((Persona) dato, (Persona) nodo.getDato());
        
        if (comparacion < 0) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), dato, comparador));
        } 
        else if (comparacion > 0) {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), dato, comparador));
        } 
        else {
            return nodo; // no permite duplicados
        }

        return nodo;
    }

    @Override                                               // Se usa un callback para comparar
    public boolean buscarRecursivo(INodo<T> nodo, T dato, IComparadorPersona comparador) {
         // Caso base: Si el nodo es null, el elemento no está en el árbol
        if (nodo == null) {
            return false;
        }

        int comparacion = comparador.compare((Persona) dato, (Persona) nodo.getDato());
        
        if (comparacion == 0) {
            return true; // Elemento encontrado
        } else if (comparacion < 0) {
            return buscarRecursivo(nodo.getIzquierdo(), dato, comparador);
        } else {
            return buscarRecursivo(nodo.getDerecho(), dato, comparador);
        }
    }


    @Override
    public void recorridoInorden() {
        inordenRecursivo(raiz);
    }

    @Override
    public void recorridoPreorden() {
        preordenRecursivo(raiz);
    }

    @Override
    public void recorridoPostorden() {
        postordenRecursivo(raiz);
    }

    @Override                                               // Se usa un callback para comparar
    public INodo<T> eliminarRecursivo(INodo<T> nodo, T dato, IComparadorPersona comparador) {
         // CASO 1: Nodo no encontrado (árbol vacío o llegamos al final)
        if (nodo == null) {
            return null; // No hay nada que eliminar
        }

        int comparacion = comparador.compare((Persona) dato, (Persona) nodo.getDato());
        
        // Navegar hacia la izquierda o derecha para encontrar el nodo
        if (comparacion < 0) {
            nodo.setIzquierdo(eliminarRecursivo(nodo.getIzquierdo(), dato, comparador));
        } else if (comparacion > 0) {
            nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), dato, comparador));
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
                nodo.setDerecho(eliminarRecursivo(nodo.getDerecho(), sucesor.getDato(), comparador));
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

    // Métodos auxiliares para los recorridos
    private void inordenRecursivo(INodo<T> nodo) {
        if (nodo != null) {
            inordenRecursivo(nodo.getIzquierdo());   // Recorrer subárbol izquierdo
            System.out.println(nodo.getDato());      // Procesar nodo actual
            inordenRecursivo(nodo.getDerecho());     // Recorrer subárbol derecho
        }
    }

    private void preordenRecursivo(INodo<T> nodo) {
        if (nodo != null) {
            System.out.println(nodo.getDato());      // Procesar nodo actual
            preordenRecursivo(nodo.getIzquierdo());  // Recorrer subárbol izquierdo
            preordenRecursivo(nodo.getDerecho());    // Recorrer subárbol derecho
        }
    }

    private void postordenRecursivo(INodo<T> nodo) {
        if (nodo != null) {
            postordenRecursivo(nodo.getIzquierdo()); // Recorrer subárbol izquierdo
            postordenRecursivo(nodo.getDerecho());   // Recorrer subárbol derecho
            System.out.println(nodo.getDato());      // Procesar nodo actual
        }
    }


    @Override
    public String toString() {
        return "Arbol con " + cantNodos + " nodos.";
    }

}