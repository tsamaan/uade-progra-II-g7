package test;

import interfaces.IGrafo;
import interfaces.IPersona;
import model.Grafo;
import model.Persona;
import services.*;

public class TestGeneral {

    public static void main(String[] args){

        // Ejecutar tests de grafos no dirigidos
        testGrafoNoDirigido();

        System.out.println("\n" + "=".repeat(65) + "\n");

        // Ejecutar tests de grafos dirigidos
        testGrafoDirigido();

        // Mensaje final:
        System.out.println("┌───────────────────────────────────────────────────────────────┐");
        System.out.println("│                      CONCLUCION FINAL                         │");
        System.out.println("└───────────────────────────────────────────────────────────────┘\n");
        System.out.println("Se utiliza True para grafos Dirigidos y False para No Dirigidos en la creacion del grafo.");
        System.out.println("Si son no dirigidos, las conexiones son bidireccionales.");
        System.out.println("Si son dirigidos, las conexiones son unidireccionales.");
        System.out.println("Por esta razon hay algoritmos que no se pueden emplear en grafos dirigidos.\t Como Prim y Kruskal.");
        System.out.println("Sin embargo los demas algoritmos funionan correctamente en ambos, Dirgidos y No Dirigidos");

    }


    private static void testGrafoNoDirigido() {
        System.out.println("┌───────────────────────────────────────────────────────────────┐");
        System.out.println("│           TEST: GRAFO NO DIRIGIDO (Bidireccional)             │");
        System.out.println("└───────────────────────────────────────────────────────────────┘\n");

        // Crear Personas
        IPersona p1 = new Persona("Nico", 11);
        IPersona p2 = new Persona("Marco", 22);
        IPersona p3 = new Persona("Catalina", 33);
        IPersona p4 = new Persona("Malena", 44);
        IPersona p5 = new Persona("Ana", 55);

        // Crear grafo NO dirigido (bidireccional)
        IGrafo<IPersona> grafoNoDirigido = new Grafo<>(false);

        // Agregar Nodos
        grafoNoDirigido.agregarNodo(p1);
        grafoNoDirigido.agregarNodo(p2);
        grafoNoDirigido.agregarNodo(p3);
        grafoNoDirigido.agregarNodo(p4);
        grafoNoDirigido.agregarNodo(p5);

        // Crear aristas (seran bidireccionales automaticamente)
        grafoNoDirigido.agregarArista(p1, p2, 2);
        grafoNoDirigido.agregarArista(p2, p4, 7);
        grafoNoDirigido.agregarArista(p2, p3, 1);
        grafoNoDirigido.agregarArista(p3, p5, 5);
        grafoNoDirigido.agregarArista(p1, p5, 3);
        grafoNoDirigido.agregarArista(p4, p5, 6);

        // Visualizacion y Recorridos
        System.out.println("[+] Caracteristicas: Las conexiones son bidireccionales");
        System.out.println("   Ejemplo: Si Nico --> Marco existe, tambien existe Marco --> Nico\n");

        grafoNoDirigido.mostrarMatrizAdyacencia();
        grafoNoDirigido.bfs(p1);
        grafoNoDirigido.dfs(p1);

        // ALGORITMOS PARA GRAFOS NO DIRIGIDOS

        // Dijkstra - Caminos mas cortos desde un nodo
        System.out.println("=".repeat(65));
        System.out.println("[+] DIJKSTRA - Caminos mas cortos desde " + p1.getNombre());
        System.out.println("=".repeat(65));
        Dijkstra.ejecutar((Grafo<IPersona>) grafoNoDirigido, p1, ((Grafo<IPersona>) grafoNoDirigido).getNodos());

        // A* - Busqueda de camino optimo con heuristica
        System.out.println("=".repeat(65));
        System.out.println("[+] A* - Camino optimo de " + p1.getNombre() + " a " + p5.getNombre());
        System.out.println("=".repeat(65));
        // Heuristica simple (retorna 0, hace que A* se comporte como Dijkstra)
        AStar.Heuristica<IPersona> heuristica = (actual, destino) -> 0;
        AStar.ejecutar((Grafo<IPersona>) grafoNoDirigido, p1, p5, heuristica, ((Grafo<IPersona>) grafoNoDirigido).getNodos());

        // Floyd-Warshall - Caminos mas cortos entre todos los pares
        System.out.println("=".repeat(65));
        System.out.println("[+] FLOYD-WARSHALL - Distancias entre todos los pares");
        System.out.println("=".repeat(65));
        FloydWarshall.ejecutar((Grafo<IPersona>) grafoNoDirigido, ((Grafo<IPersona>) grafoNoDirigido).getNodos());

        // Prim - arbol de Expansion Minima
        System.out.println("=".repeat(65));
        System.out.println("[+] PRIM - arbol de Expansion Minima");
        System.out.println("=".repeat(65));
        Prim.ejecutar((Grafo<IPersona>) grafoNoDirigido, ((Grafo<IPersona>) grafoNoDirigido).getNodos());

        // Kruskal - arbol de Expansion Minima
        System.out.println("=".repeat(65));
        System.out.println("[+] KRUSKAL - arbol de Expansion Minima");
        System.out.println("=".repeat(65));
        Kruskal.ejecutar((Grafo<IPersona>) grafoNoDirigido, ((Grafo<IPersona>) grafoNoDirigido).getNodos());
    
    }

    private static void testGrafoDirigido() {
        System.out.println("┌───────────────────────────────────────────────────────────────┐");
        System.out.println("│            TEST: GRAFO DIRIGIDO (Unidireccional)              │");
        System.out.println("└───────────────────────────────────────────────────────────────┘\n");

        // Crear Personas
        IPersona p1 = new Persona("Flor", 66);
        IPersona p2 = new Persona("Teo", 77);
        IPersona p3 = new Persona("Laura", 88);
        IPersona p4 = new Persona("Diego", 99);
        IPersona p5 = new Persona("Sofia", 101);

        // Crear grafo DIRIGIDO (unidireccional)
        IGrafo<IPersona> grafoDirigido = new Grafo<>(true);

        // Agregar Nodos
        grafoDirigido.agregarNodo(p1);
        grafoDirigido.agregarNodo(p2);
        grafoDirigido.agregarNodo(p3);
        grafoDirigido.agregarNodo(p4);
        grafoDirigido.agregarNodo(p5);

        // Crear aristas dirigidas (unidireccionales)
        grafoDirigido.agregarArista(p1, p2, 1);
        grafoDirigido.agregarArista(p1, p3, 2);
        grafoDirigido.agregarArista(p2, p4, 4);
        grafoDirigido.agregarArista(p3, p4, 3);
        grafoDirigido.agregarArista(p4, p5, 7);
        grafoDirigido.agregarArista(p5, p1, 5);
        grafoDirigido.agregarArista(p4, p4, 1);

        // Visualizacion y Recorridos
        System.out.println("[+] Caracteristicas: Las conexiones son unidireccionales");
        System.out.println("   Ejemplo: Flor --> Teo existe, pero Teo --> Flor NO existe\n");

        grafoDirigido.mostrarMatrizAdyacencia();
        grafoDirigido.bfs(p1);
        grafoDirigido.dfs(p1);

        // ALGORITMOS PARA GRAFOS DIRIGIDOS

        // Dijkstra - Caminos mas cortos desde un nodo
        System.out.println("=".repeat(65));
        System.out.println("[+] DIJKSTRA - Caminos mas cortos desde " + p1.getNombre());
        System.out.println("=".repeat(65));
        Dijkstra.ejecutar((Grafo<IPersona>) grafoDirigido, p1, ((Grafo<IPersona>) grafoDirigido).getNodos());

        // A* - Busqueda de camino optimo con heuristica
        System.out.println("=".repeat(65));
        System.out.println("[+] A* - Camino optimo de " + p1.getNombre() + " a " + p5.getNombre());
        System.out.println("=".repeat(65));
        // Heuristica basada en diferencia de DNI (ejemplo)
        AStar.Heuristica<IPersona> heuristicaDirigido = (actual, destino) -> {
            return Math.abs((int)(actual.getDni() - destino.getDni())) / 10;
        };
        AStar.ejecutar((Grafo<IPersona>) grafoDirigido, p1, p5, heuristicaDirigido, ((Grafo<IPersona>) grafoDirigido).getNodos());

        // Floyd-Warshall - Caminos mas cortos entre todos los pares
        System.out.println("=".repeat(65));
        System.out.println("[+] FLOYD-WARSHALL - Distancias entre todos los pares");
        System.out.println("=".repeat(65));
        FloydWarshall.ejecutar((Grafo<IPersona>) grafoDirigido, ((Grafo<IPersona>) grafoDirigido).getNodos());

        System.out.println("\n[!] Prim y Kruskal NO se ejecutan en grafos dirigidos");
        System.out.println("(estan diseñados solo para grafos no dirigidos)\n");
    }

}