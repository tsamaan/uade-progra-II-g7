package services;

import java.util.*;

import interfaces.INodo;
import model.Arista;
import model.Grafo;

public class Prim<T> {

    public static <T> void ejecutar(Grafo<T> grafo, Map<T, INodo<T>> nodos) {
        if (nodos.isEmpty()) {
            System.out.println("[!] El grafo esta vacio");
            return;
        }

        Set<T> visitados = new HashSet<>();
        PriorityQueue<AristaPrim<T>> cola = new PriorityQueue<>(Comparator.comparingInt(a -> a.peso));
        List<AristaPrim<T>> mst = new ArrayList<>();

        // Comenzamos desde el primer nodo disponible
        T inicio = nodos.keySet().iterator().next();
        visitados.add(inicio);

        // Agregar las aristas del nodo inicial a la cola
        agregarAristas(nodos.get(inicio), visitados, cola);

        int pesoTotal = 0;

        // Mientras haya aristas y no se haya completado el MST
        while (!cola.isEmpty() && visitados.size() < nodos.size()) {
            AristaPrim<T> arista = cola.poll();

            // Si el destino ya fue visitado, se descarta (evita ciclos)
            if (visitados.contains(arista.destino)) continue;

            // Agregar arista al MST
            mst.add(arista);
            pesoTotal += arista.peso;
            visitados.add(arista.destino);

            // Agregar nuevas aristas desde el nuevo nodo visitado
            agregarAristas(nodos.get(arista.destino), visitados, cola);
        }

        // Mostrar el arbol de expansion minima
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║     ALGORITMO PRIM - aRBOL DE EXPANSIoN MiNIMA             ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println();
        for (AristaPrim<T> a : mst) {
            System.out.println("  " + obtenerEtiqueta(a.origen) + " - " + obtenerEtiqueta(a.destino) + " (peso=" + a.peso + ")");
        }
        System.out.println("\n  Peso total del MST: " + pesoTotal);
        System.out.println();
    }

    // Agrega a la cola todas las aristas desde un nodo no visitado
    private static <T> void agregarAristas(INodo<T> nodo, Set<T> visitados, PriorityQueue<AristaPrim<T>> cola) {
        List<Arista<T>> aristas = nodo.getAristas();
        T origen = nodo.getDato();

        for (Arista<T> arista : aristas) {
            T destino = arista.getDestino().getDato();
            int peso = arista.getPeso();
            if (!visitados.contains(destino)) {
                cola.add(new AristaPrim<>(origen, destino, peso));
            }
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

    // Clase interna para representar una arista
    private static class AristaPrim<T> {
        T origen, destino;
        int peso;

        AristaPrim(T o, T d, int p) {
            origen = o;
            destino = d;
            peso = p;
        }
    }
}