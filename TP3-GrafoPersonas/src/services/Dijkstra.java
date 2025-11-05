package services;

import java.util.*;

import interfaces.INodo;
import model.Arista;
import model.Grafo;

public class Dijkstra<T> {

    // Metodo estatico que ejecuta el algoritmo de Dijkstra desde un nodo origen
    public static <T> void ejecutar(Grafo<T> grafo, T origen, Map<T, INodo<T>> nodos) {
        if (origen == null || !nodos.containsKey(origen)) {
            System.out.println("[!] El nodo de origen no existe en el grafo");
            return;
        }

        // Mapa para guardar las distancias minimas desde el nodo origen a cada nodo
        Map<T, Integer> distancias = new HashMap<>();

        // Conjunto para registrar que nodos ya fueron visitados (optimiza el algoritmo)
        Set<T> visitados = new HashSet<>();

        // Cola de prioridad para seleccionar el nodo con menor distancia actual
        PriorityQueue<NodoDistancia<T>> cola = new PriorityQueue<>();

        // Inicializa todas las distancias al valor maximo (infinito)
        for (T id : nodos.keySet()) {
            distancias.put(id, Integer.MAX_VALUE);
        }

        // La distancia al nodo origen es 0 (obvio)
        distancias.put(origen, 0);

        // Se añade el nodo origen a la cola con distancia 0
        cola.add(new NodoDistancia<>(origen, 0));

        // Mientras haya nodos por procesar en la cola...
        while (!cola.isEmpty()) {
            // Se toma el nodo con la menor distancia (gracias a la cola de prioridad)
            NodoDistancia<T> actual = cola.poll();

            // Si ya fue visitado, se saltea para evitar ciclos o reprocesos
            if (visitados.contains(actual.id)) continue;

            // Marca el nodo como visitado
            visitados.add(actual.id);

            // Obtiene el nodo actual desde el mapa de nodos
            INodo<T> nodoActual = nodos.get(actual.id);

            // Obtiene la lista de aristas desde el nodo actual
            List<Arista<T>> aristas = nodoActual.getAristas();

            // Recorre todas las aristas (vecinos) del nodo actual
            for (Arista<T> arista : aristas) {
                T vecinoId = arista.getDestino().getDato(); // ID del nodo vecino
                int peso = arista.getPeso();                // Peso de la arista al vecino

                // Calcula la nueva distancia como la suma de la distancia actual + peso
                int nuevaDistancia = distancias.get(actual.id) + peso;

                // Si la nueva distancia es menor que la registrada, se actualiza
                if (nuevaDistancia < distancias.get(vecinoId)) {
                    distancias.put(vecinoId, nuevaDistancia); // Actualiza la distancia
                    cola.add(new NodoDistancia<>(vecinoId, nuevaDistancia)); // Agrega a la cola
                }
            }
        }

        // Imprime las distancias minimas desde el nodo origen a todos los nodos
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║     ALGORITMO DIJKSTRA - DISTANCIAS MiNIMAS                ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println("  Desde nodo: " + origen);
        System.out.println();
        for (Map.Entry<T, Integer> entry : distancias.entrySet()) {
            String distancia = entry.getValue() == Integer.MAX_VALUE ? "INF" : String.valueOf(entry.getValue());
            System.out.println("  → A " + entry.getKey() + " = " + distancia);
        }
        System.out.println();
    }

    // Clase interna que representa un nodo junto con su distancia acumulada
    private static class NodoDistancia<T> implements Comparable<NodoDistancia<T>> {
        T id;
        int distancia;

        // Constructor para crear el nodo con su respectiva distancia
        NodoDistancia(T id, int distancia) {
            this.id = id;
            this.distancia = distancia;
        }

        // Permite que los objetos de esta clase se ordenen por distancia en la PriorityQueue
        public int compareTo(NodoDistancia<T> otro) {
            return Integer.compare(this.distancia, otro.distancia);
        }
    }
}