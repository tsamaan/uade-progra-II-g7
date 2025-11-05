package services;

import java.util.*;

import interfaces.INodo;
import model.Arista;
import model.Grafo;

public class Kruskal<T> {

    // Metodo principal que ejecuta el algoritmo de Kruskal sobre el grafo dado
    public static <T> void ejecutar(Grafo<T> grafo, Map<T, INodo<T>> nodos) {
        if (nodos.isEmpty()) {
            System.out.println("[!] El grafo esta vacio");
            return;
        }

        // Lista que contendra todas las aristas unicas del grafo
        List<AristaKruskal<T>> aristas = new ArrayList<>();

        // Estructura Union-Find para detectar ciclos y manejar componentes conexas
        UnionFind<T> uf = new UnionFind<>(nodos.keySet());

        // Conjunto auxiliar para evitar aristas duplicadas (en grafos no dirigidos)
        Set<String> vistas = new HashSet<>();

        // Recorremos todos los nodos para construir la lista de aristas
        for (Map.Entry<T, INodo<T>> entry : nodos.entrySet()) {
            T origen = entry.getKey();
            INodo<T> nodo = entry.getValue();
            List<Arista<T>> aristasNodo = nodo.getAristas();

            for (Arista<T> arista : aristasNodo) {
                T destino = arista.getDestino().getDato();
                int peso = arista.getPeso();

                // Clave unica para identificar la arista sin importar el orden (evita duplicados)
                String clave = generarClave(origen, destino);

                // Si esta arista no ha sido vista, la agregamos
                if (!vistas.contains(clave)) {
                    vistas.add(clave);
                    aristas.add(new AristaKruskal<>(origen, destino, peso));
                }
            }
        }

        // Ordenamos todas las aristas por peso (de menor a mayor)
        aristas.sort(Comparator.comparingInt(a -> a.peso));

        // Lista que almacenara las aristas seleccionadas para el arbol de Expansion Minima (MST)
        List<AristaKruskal<T>> mst = new ArrayList<>();
        int pesoTotal = 0;

        // Recorremos las aristas ya ordenadas
        for (AristaKruskal<T> arista : aristas) {
            // Solo añadimos la arista si conecta dos componentes distintas (evita ciclos)
            if (uf.union(arista.origen, arista.destino)) {
                mst.add(arista);
                pesoTotal += arista.peso;
            }
        }

        // Mostramos el resultado del arbol de Expansion Minima
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║     ALGORITMO KRUSKAL - aRBOL DE EXPANSIoN MiNIMA          ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println();
        for (AristaKruskal<T> a : mst) {
            System.out.println("  " + obtenerEtiqueta(a.origen) + " - " + obtenerEtiqueta(a.destino) + " (peso=" + a.peso + ")");
        }
        System.out.println("\n  Peso total del MST: " + pesoTotal);
        System.out.println();
    }

    private static <T> String generarClave(T origen, T destino) {
        int hashOrigen = origen.hashCode();
        int hashDestino = destino.hashCode();
        if (hashOrigen < hashDestino) {
            return origen.toString() + "-" + destino.toString();
        } else {
            return destino.toString() + "-" + origen.toString();
        }
    }

    private static <T> String obtenerEtiqueta(T nodo) {
        String str = nodo.toString();
        
        // Si es una Persona, extraer solo el nombre
        if (str.contains("Nombre:")) {
            int inicio = str.indexOf("Nombre:") + 7;
            int fin = str.indexOf("\n", inicio);
            if (fin > inicio) {
                return str.substring(inicio, fin).trim();
            }
        }
        
        return str.trim();
    }

    // Clase interna que representa una arista del grafo con su origen, destino y peso
    private static class AristaKruskal<T> {
        T origen, destino;
        int peso;

        AristaKruskal(T o, T d, int p) {
            origen = o;
            destino = d;
            peso = p;
        }
    }

    // Clase que implementa el algoritmo Union-Find (tambien llamado Disjoint Set)
    private static class UnionFind<T> {
        Map<T, T> padre;

        // Constructor: inicializa cada nodo como su propio padre (conjunto individual)
        UnionFind(Set<T> nodos) {
            padre = new HashMap<>();
            for (T nodo : nodos)
                padre.put(nodo, nodo);
        }

        // Encuentra la raiz del conjunto al que pertenece el nodo x (con compresion de caminos)
        T find(T x) {
            if (!padre.get(x).equals(x))
                padre.put(x, find(padre.get(x))); // compresion de camino
            return padre.get(x);
        }

        // Une los conjuntos de x e y si no forman ciclo; devuelve true si se unieron
        boolean union(T x, T y) {
            T raizX = find(x);
            T raizY = find(y);
            if (raizX.equals(raizY)) return false; // ya estan en el mismo conjunto (formarian ciclo)
            padre.put(raizX, raizY);               // unimos las raices
            return true;
        }
    }
}