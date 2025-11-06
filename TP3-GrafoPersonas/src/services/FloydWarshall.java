package services;

import java.util.*;

import interfaces.INodo;
import model.Arista;
import model.Grafo;

public class FloydWarshall<T> {

    // Metodo principal para ejecutar el algoritmo de Floyd-Warshall sobre un grafo
    public static <T> void ejecutar(Grafo<T> grafo, Map<T, INodo<T>> nodos) {
        if (nodos.isEmpty()) {
            System.out.println("[!] El grafo esta vacio");
            return;
        }

        // Obtener las claves (IDs de los nodos) y ordenarlas para mantener el orden consistente en la matriz
        List<T> claves = new ArrayList<>(nodos.keySet());

        int n = claves.size(); // Cantidad de nodos

        // Matriz de distancias, inicializada con "infinito"
        int[][] dist = new int[n][n];
        final int INF = 1_000_000; // Usamos un numero muy grande como infinito

        // Inicializacion: distancia a si mismo = 0; el resto = infinito
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF); // Llena cada fila con INF
            dist[i][i] = 0;             // Costo de un nodo a si mismo es 0
        }

        // Rellenar la matriz con las distancias directas desde el grafo
        for (int i = 0; i < n; i++) {
            INodo<T> nodo = nodos.get(claves.get(i));       // Nodo actual
            List<Arista<T>> aristas = nodo.getAristas();    // Aristas del nodo

            // Para cada arista, se actualiza la distancia directa en la matriz
            for (Arista<T> arista : aristas) {
                int idxVecino = claves.indexOf(arista.getDestino().getDato()); // indice del vecino en la matriz
                if (idxVecino != -1) {
                    dist[i][idxVecino] = arista.getPeso(); // Peso directo entre nodo y vecino
                }
            }
        }

        // Algoritmo de Floyd-Warshall
        // Se verifica si pasando por k se obtiene un camino mas corto de i a j
        for (int k = 0; k < n; k++) {       // Nodo intermedio
            for (int i = 0; i < n; i++) {   // Nodo origen
                for (int j = 0; j < n; j++) { // Nodo destino
                    // Si la suma de los caminos es menor al actual, se actualiza
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Mostrar la matriz de distancias minimas entre todos los pares de nodos
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║     ALGORITMO FLOYD-WARSHALL                               ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println("  Matriz de distancias minimas:\n");
        
        // Calcular ancho de columna
        int anchoColumna = 8;
        for (T nodo : claves) {
            anchoColumna = Math.max(anchoColumna, nodo.toString().length());
        }
        
        // Encabezado
        System.out.print(String.format("%" + anchoColumna + "s |", ""));
        for (T nodo : claves) {
            System.out.print(String.format(" %-" + anchoColumna + "s", obtenerEtiqueta(nodo)));
        }
        System.out.println();
        
        // Linea separadora
        for (int i = 0; i < anchoColumna; i++) {
            System.out.print("-");
        }
        System.out.print("-+");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < anchoColumna + 1; j++) {
                System.out.print("-");
            }
        }
        System.out.println();
        
        // Datos
        for (int i = 0; i < n; i++) {
            System.out.print(String.format("%" + anchoColumna + "s |", obtenerEtiqueta(claves.get(i))));
            for (int j = 0; j < n; j++) {
                String valor = (dist[i][j] == INF ? "INF" : String.valueOf(dist[i][j]));
                System.out.print(String.format(" %-" + anchoColumna + "s", valor));
            }
            System.out.println();
        }
        System.out.println();
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
}