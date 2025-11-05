package test;

import interfaces.IGrafo;
import interfaces.IPersona;
import model.Grafo;
import model.Persona;

public class TestGeneral {

    public static void main(String[] args){

        // Ejecutar tests de grafos no dirigidos
        testGrafoNoDirigido();

        System.out.println("\n" + "=".repeat(65) + "\n");

        // Ejecutar tests de grafos dirigidos
        testGrafoDirigido();
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

        // Crear aristas (serán bidireccionales automáticamente)
        grafoNoDirigido.agregarArista(p1, p2, 2);
        grafoNoDirigido.agregarArista(p2, p4, 7);
        grafoNoDirigido.agregarArista(p2, p3, 1);
        grafoNoDirigido.agregarArista(p3, p5, 5);
        grafoNoDirigido.agregarArista(p1, p5, 3);
        grafoNoDirigido.agregarArista(p4, p5, 6);

        // Visualización y Recorridos
        System.out.println("[+] Características: Las conexiones son bidireccionales");
        System.out.println("   Ejemplo: Si Nico --> Marco existe, también existe Marco --> Nico\n");

        grafoNoDirigido.mostrarMatrizAdyacencia();
        grafoNoDirigido.bfs(p1);
        grafoNoDirigido.dfs(p1);
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

        // Visualización y Recorridos
        System.out.println("[+] Características: Las conexiones son unidireccionales");
        System.out.println("   Ejemplo: Flor --> Teo existe, pero Teo --> Flor NO existe\n");

        grafoDirigido.mostrarMatrizAdyacencia();
        grafoDirigido.bfs(p1);
        grafoDirigido.dfs(p1);
    }

}