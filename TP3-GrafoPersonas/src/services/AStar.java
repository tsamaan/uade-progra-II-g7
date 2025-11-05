package services;

import java.util.*;

import interfaces.INodo;
import model.Arista;
import model.Grafo;

public class AStar<T> {

    // Heuristica: funcion estimada de distancia
    // Aca uso distancia Euclidiana u otra metrica segun el contexto
    public interface Heuristica<T> {
        int estimar(T nodoActual, T nodoDestino);
    }

    public static <T> void ejecutar(Grafo<T> grafo, T inicio, T objetivo, Heuristica<T> heuristica, Map<T, INodo<T>> nodos) {
        if (inicio == null || objetivo == null || !nodos.containsKey(inicio) || !nodos.containsKey(objetivo)) {
            System.out.println("[!] El nodo de inicio o destino no existe en el grafo");
            return;
        }

        final int INF = 1_000_000; // Usar un valor grande pero seguro para evitar overflow
        
        Map<T, Integer> gCost = new HashMap<>(); // costo desde inicio al nodo
        Map<T, Integer> fCost = new HashMap<>(); // costo estimado total (g + h)
        Map<T, T> padres = new HashMap<>(); // para reconstruir camino
        Set<T> cerrados = new HashSet<>();

        // Inicializar costos con infinito
        for (T id : nodos.keySet()) {
            gCost.put(id, INF);
            fCost.put(id, INF);
        }

        gCost.put(inicio, 0);
        fCost.put(inicio, heuristica.estimar(inicio, objetivo));

        // Cola priorizada por fCost
        PriorityQueue<NodoCosto<T>> cola = new PriorityQueue<>();
        cola.add(new NodoCosto<>(inicio, fCost.get(inicio)));

        while (!cola.isEmpty()) {
            NodoCosto<T> actual = cola.poll();
            T idActual = actual.id;

            // Si ya fue procesado con un costo menor, ignorar
            if (cerrados.contains(idActual)) continue;

            // Si llegamos al objetivo, reconstruir el camino
            if (idActual.equals(objetivo)) {
                // Reconstruir camino desde objetivo hasta inicio
                List<T> camino = new ArrayList<>();
                T temp = idActual;
                while (padres.containsKey(temp)) {
                    camino.add(temp);
                    temp = padres.get(temp);
                }
                camino.add(inicio);
                Collections.reverse(camino);
                
                System.out.println("\n╔════════════════════════════════════════════════════════════╗");
                System.out.println("║     ALGORITMO A* - CAMINO ENCONTRADO                       ║");
                System.out.println("╚════════════════════════════════════════════════════════════╝");
                System.out.println("  Camino: " + camino);
                System.out.println("  Costo total: " + gCost.get(objetivo));
                System.out.println();
                return;
            }

            cerrados.add(idActual);

            INodo<T> nodoActual = nodos.get(idActual);
            List<Arista<T>> aristas = nodoActual.getAristas();

            for (Arista<T> arista : aristas) {
                T vecinoId = arista.getDestino().getDato();
                
                // Si ya fue procesado, saltearlo
                if (cerrados.contains(vecinoId)) continue;

                int tentativeG = gCost.get(idActual) + arista.getPeso();
                
                // Si encontramos un camino mejor
                if (tentativeG < gCost.get(vecinoId)) {
                    padres.put(vecinoId, idActual);
                    gCost.put(vecinoId, tentativeG);
                    int h = heuristica.estimar(vecinoId, objetivo);
                    fCost.put(vecinoId, tentativeG + h);

                    // Agregar a la cola (puede haber duplicados pero seran ignorados por cerrados)
                    cola.add(new NodoCosto<>(vecinoId, fCost.get(vecinoId)));
                }
            }
        }

        System.out.println("\n[!] No se encontro camino desde " + inicio + " hasta " + objetivo);
    }

    private static class NodoCosto<T> implements Comparable<NodoCosto<T>> {
        T id;
        int fCost;

        NodoCosto(T id, int fCost) {
            this.id = id;
            this.fCost = fCost;
        }

        @Override
        public int compareTo(NodoCosto<T> otro) {
            return Integer.compare(this.fCost, otro.fCost);
        }
    }
}