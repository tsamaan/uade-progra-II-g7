package model;

import interfaces.IGrafo;
import interfaces.INodo;

import java.util.*;

public class Grafo<T> implements IGrafo<T> {
    
    private Map<T, INodo<T>> nodos;
    private boolean esDirigido;

    // ---- Constructores
    public Grafo() {
        this.nodos = new HashMap<>();
        this.esDirigido = false;
    }

    public Grafo(boolean esDirigido) {
        this.nodos = new HashMap<>();
        this.esDirigido = esDirigido;
    }

    // ---- Métodos de la interfaz IGrafo

    @Override
    public void agregarNodo(T valor) {
        if (valor != null && !nodos.containsKey(valor)) {
            nodos.put(valor, new Nodo<>(valor));
        }
    }

    @Override
    public void eliminarNodo(T valor) {
        if (valor == null || !nodos.containsKey(valor)) {
            return;
        }

        // Eliminar el nodo del mapa
        nodos.remove(valor);

        // Eliminar todas las referencias a este nodo en las aristas de otros nodos
        for (INodo<T> nodo : nodos.values()) {
            List<Arista<T>> aristas = nodo.getAristas();
            
            // Buscar y eliminar aristas que apunten a este nodo
            aristas.removeIf(arista -> arista.getDestino().getDato().equals(valor));
        }
    }

    @Override
    public void agregarArista(T origen, T destino, int peso) {
        if (origen == null || destino == null) {
            return;
        }

        // Asegurarse de que ambos nodos existan
        if (!nodos.containsKey(origen)) {
            agregarNodo(origen);
        }
        if (!nodos.containsKey(destino)) {
            agregarNodo(destino);
        }

        INodo<T> nodoOrigen = nodos.get(origen);
        INodo<T> nodoDestino = nodos.get(destino);

        // Agregar la arista desde origen a destino
        nodoOrigen.agregarVecino(nodoDestino, peso);

        // Si no es dirigido, agregar también la arista inversa
        if (!esDirigido) {
            nodoDestino.agregarVecino(nodoOrigen, peso);
        }
    }

    @Override
    public void eliminarArista(T origen, T destino, int peso) {
        if (origen == null || destino == null) {
            return;
        }

        if (!nodos.containsKey(origen) || !nodos.containsKey(destino)) {
            return;
        }

        INodo<T> nodoOrigen = nodos.get(origen);
        List<Arista<T>> aristas = nodoOrigen.getAristas();

        // Buscar y eliminar la arista
        aristas.removeIf(arista -> 
            arista.getDestino().getDato().equals(destino) && arista.getPeso() == peso
        );

        // Si no es dirigido, eliminar también la arista inversa
        if (!esDirigido) {
            INodo<T> nodoDestino = nodos.get(destino);
            List<Arista<T>> aristasDestino = nodoDestino.getAristas();

            aristasDestino.removeIf(arista -> 
                arista.getDestino().getDato().equals(origen) && arista.getPeso() == peso
            );
        }
    }

    @Override
    public void mostrarMatrizAdyacencia() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║            MATRIZ DE ADYACENCIA                            ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        
        if (nodos.isEmpty()) {
            System.out.println("  El grafo está vacío");
            return;
        }

        List<T> listaNodos = new ArrayList<>(nodos.keySet());
        int size = listaNodos.size();
        int[][] matriz = new int[size][size];

        // Crear un mapa de índices para acceso rápido
        Map<T, Integer> indices = new HashMap<>();
        for (int i = 0; i < size; i++) {
            indices.put(listaNodos.get(i), i);
        }

        // Llenar la matriz
        for (int i = 0; i < size; i++) {
            INodo<T> nodo = nodos.get(listaNodos.get(i));
            List<Arista<T>> aristas = nodo.getAristas();
            
            for (Arista<T> arista : aristas) {
                int j = indices.get(arista.getDestino().getDato());
                matriz[i][j] = 1;
            }
        }

        // Calcular ancho de columna basado en el contenido
        int anchoColumna = 8;
        
        // Imprimir encabezado superior
        System.out.print("        │");
        for (int i = 0; i < size; i++) {
            String str = obtenerEtiqueta(listaNodos.get(i), anchoColumna);
            System.out.print(String.format(" %-" + anchoColumna + "s", str));
        }
        System.out.println();
        
        // Línea separadora
        System.out.print("────────┼");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < anchoColumna + 1; j++) {
                System.out.print("─");
            }
        }
        System.out.println();

        // Imprimir filas con datos
        for (int i = 0; i < size; i++) {
            String etiqueta = obtenerEtiqueta(listaNodos.get(i), 7);
            System.out.print(String.format(" %-7s│", etiqueta));
            
            for (int j = 0; j < size; j++) {
                String valor = matriz[i][j] == 1 ? "■" : "·";
                System.out.print(String.format(" %-" + anchoColumna + "s", valor));
            }
            System.out.println();
        }
        System.out.println();
    }
    
    
    @Override
    public void bfs(T inicio) {
        if (inicio == null || !nodos.containsKey(inicio)) {
            System.out.println("⚠ El nodo de inicio no existe en el grafo");
            return;
        }

        Set<T> visitados = new HashSet<>();
        Queue<INodo<T>> cola = new LinkedList<>();

        INodo<T> nodoInicio = nodos.get(inicio);
        cola.add(nodoInicio);
        visitados.add(inicio);

        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║     RECORRIDO BFS                                          ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.print("  Desde [" + obtenerEtiqueta(inicio, 20) + "]: ");
        
        int contador = 0;
        while (!cola.isEmpty()) {
            INodo<T> actual = cola.poll();
            String etiqueta = obtenerEtiqueta(actual.getDato(), 15);
            
            if (contador > 0) System.out.print(" → ");
            System.out.print(etiqueta);
            contador++;

            for (Arista<T> arista : actual.getAristas()) {
                INodo<T> vecino = arista.getDestino();
                if (!visitados.contains(vecino.getDato())) {
                    visitados.add(vecino.getDato());
                    cola.add(vecino);
                }
            }
        }
        System.out.println("\n  Total de nodos visitados: " + contador);
        System.out.println();
    }

    @Override
    public void dfs(T inicio) {
        if (inicio == null || !nodos.containsKey(inicio)) {
            System.out.println("⚠ El nodo de inicio no existe en el grafo");
            return;
        }

        Set<T> visitados = new HashSet<>();
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║       RECORRIDO DFS                                        ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.print("  Desde [" + obtenerEtiqueta(inicio, 20) + "]: ");
        
        int[] contador = {0};  // Usar array para poder modificar en recursión
        dfsRecursivo(nodos.get(inicio), visitados, contador);
        
        System.out.println("\n  Total de nodos visitados: " + contador[0]);
        System.out.println();
    }

    // ---- Métodos auxiliares privados

    private void dfsRecursivo(INodo<T> actual, Set<T> visitados, int[] contador) {
        visitados.add(actual.getDato());
        String etiqueta = obtenerEtiqueta(actual.getDato(), 15);
        
        if (contador[0] > 0) System.out.print(" → ");
        System.out.print(etiqueta);
        contador[0]++;

        for (Arista<T> arista : actual.getAristas()) {
            INodo<T> vecino = arista.getDestino();
            if (!visitados.contains(vecino.getDato())) {
                dfsRecursivo(vecino, visitados, contador);
            }
        }
    }

    // Obtiene una etiqueta representativa del nodo para mostrar en la matriz.
    // Intenta extraer información útil del toString() del nodo.
    private String obtenerEtiqueta(T nodo, int maxLength) {
        String str = nodo.toString();
        
        // Si es una Persona, intentar extraer solo el nombre
        if (str.contains("Nombre:")) {
            int inicio = str.indexOf("Nombre:") + 7;
            int fin = str.indexOf("\n", inicio);
            if (fin > inicio) {
                str = str.substring(inicio, fin).trim();
            }
        }
        
        // Truncar si es muy largo
        if (str.length() > maxLength) {
            return str.substring(0, maxLength - 2) + "..";
        }
        
        return str;
    }
}
