package model;

import interfaces.IGrafo;
import interfaces.INodo;
import interfaces.IPersona
import interfaces.IArista;

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
        System.out.println("Matriz de Adyacencia:");
        
        if (nodos.isEmpty()) {
            System.out.println("El grafo está vacío");
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

        // Imprimir encabezado
        System.out.print("      ");
        for (T nodo : listaNodos) {
            String str = nodo.toString();
            System.out.print(String.format("%-10s", str.substring(0, Math.min(str.length(), 10))));
        }
        System.out.println();

        // Imprimir filas
        for (int i = 0; i < size; i++) {
            String str = listaNodos.get(i).toString();
            System.out.print(String.format("%-6s", str.substring(0, Math.min(str.length(), 6))) + "|");
            for (int j = 0; j < size; j++) {
                System.out.print(String.format("%-10d", matriz[i][j]));
            }
            System.out.println();
        }
    }

    @Override
    public void mostrarListaAdyacencia() {
        System.out.println("Lista de Adyacencia:");
        
        if (nodos.isEmpty()) {
            System.out.println("El grafo está vacío");
            return;
        }

        for (Map.Entry<T, INodo<T>> entrada : nodos.entrySet()) {
            System.out.print(entrada.getKey() + ": ");
            
            INodo<T> nodo = entrada.getValue();
            List<Arista<T>> aristas = nodo.getAristas();
            
            for (Arista<T> arista : aristas) {
                System.out.print(arista + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void bfs(T inicio) {
        if (inicio == null || !nodos.containsKey(inicio)) {
            System.out.println("El nodo de inicio no existe en el grafo");
            return;
        }

        Set<T> visitados = new HashSet<>();
        Queue<INodo<T>> cola = new LinkedList<>();

        INodo<T> nodoInicio = nodos.get(inicio);
        cola.add(nodoInicio);
        visitados.add(inicio);

        System.out.println("Recorrido BFS:");
        while (!cola.isEmpty()) {
            INodo<T> actual = cola.poll();
            System.out.print(actual.getDato() + " ");

            for (Arista<T> arista : actual.getAristas()) {
                INodo<T> vecino = arista.getDestino();
                if (!visitados.contains(vecino.getDato())) {
                    visitados.add(vecino.getDato());
                    cola.add(vecino);
                }
            }
        }
        System.out.println();
    }

    @Override
    public void dfs(T inicio) {
        if (inicio == null || !nodos.containsKey(inicio)) {
            System.out.println("El nodo de inicio no existe en el grafo");
            return;
        }

        Set<T> visitados = new HashSet<>();
        System.out.println("Recorrido DFS:");
        dfsRecursivo(nodos.get(inicio), visitados);
        System.out.println();
    }

    // ---- Métodos auxiliares privados

    private void dfsRecursivo(INodo<T> actual, Set<T> visitados) {
        visitados.add(actual.getDato());
        System.out.print(actual.getDato() + " ");

        for (Arista<T> arista : actual.getAristas()) {
            INodo<T> vecino = arista.getDestino();
            if (!visitados.contains(vecino.getDato())) {
                dfsRecursivo(vecino, visitados);
            }
        }
    }

}
