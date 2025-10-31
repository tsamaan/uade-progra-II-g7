package test;

import model.Grafo;
import model.Persona;

public class TestGeneral {

    public static void main(String[] args) {
        System.out.println("=== TEST GRAFO DE PERSONAS ===\n");

        // Crear personas
        Persona p1 = new Persona("Juan", 12345678);
        Persona p2 = new Persona("Maria", 23456789);
        Persona p3 = new Persona("Pedro", 34567890);
        Persona p4 = new Persona("Ana", 45678901);
        Persona p5 = new Persona("Luis", 56789012);

        System.out.println("1. GRAFO NO DIRIGIDO");
        System.out.println("====================\n");
        
        // Crear grafo no dirigido de Personas
        Grafo<Persona> grafoNoDirigido = new Grafo<>(false);
        
        // Agregar nodos
        grafoNoDirigido.agregarNodo(p1);
        grafoNoDirigido.agregarNodo(p2);
        grafoNoDirigido.agregarNodo(p3);
        grafoNoDirigido.agregarNodo(p4);
        grafoNoDirigido.agregarNodo(p5);
        
        // Agregar aristas (amistades bidireccionales)
        grafoNoDirigido.agregarArista(p1, p2, 1);  // Juan <-> Maria
        grafoNoDirigido.agregarArista(p1, p3, 1);  // Juan <-> Pedro
        grafoNoDirigido.agregarArista(p2, p4, 1);  // Maria <-> Ana
        grafoNoDirigido.agregarArista(p3, p4, 1);  // Pedro <-> Ana
        grafoNoDirigido.agregarArista(p4, p5, 1);  // Ana <-> Luis
        
        // Mostrar Matriz de adyacencia
        System.out.println("\nMatriz de Adyacencia:");
        System.out.println("--------------------");
        grafoNoDirigido.mostrarMatrizAdyacencia();
        
        // Recorridos
        System.out.println("\nRecorrido BFS desde Juan:");
        System.out.println("-------------------------");
        grafoNoDirigido.bfs(p1);
        
        System.out.println("\nRecorrido DFS desde Juan:");
        System.out.println("-------------------------");
        grafoNoDirigido.dfs(p1);
        
        System.out.println("\n\n2. GRAFO DIRIGIDO");
        System.out.println("=================\n");
        
        // Crear grafo dirigido de Personas (por ejemplo, seguidores en redes sociales)
        Grafo<Persona> grafoDirigido = new Grafo<>(true);
        
        // Agregar nodos
        grafoDirigido.agregarNodo(p1);
        grafoDirigido.agregarNodo(p2);
        grafoDirigido.agregarNodo(p3);
        grafoDirigido.agregarNodo(p4);
        grafoDirigido.agregarNodo(p5);
        
        // Agregar aristas dirigidas (quien sigue a quien)
        grafoDirigido.agregarArista(p1, p2, 1);  // Juan sigue a Maria
        grafoDirigido.agregarArista(p1, p3, 1);  // Juan sigue a Pedro
        grafoDirigido.agregarArista(p2, p1, 1);  // Maria sigue a Juan
        grafoDirigido.agregarArista(p2, p4, 1);  // Maria sigue a Ana
        grafoDirigido.agregarArista(p3, p4, 1);  // Pedro sigue a Ana
        grafoDirigido.agregarArista(p4, p5, 1);  // Ana sigue a Luis
        grafoDirigido.agregarArista(p5, p1, 1);  // Luis sigue a Juan
        
        // Mostrar Matriz de adyacencia
        System.out.println("\nMatriz de Adyacencia (Dirigido):");
        System.out.println("--------------------------------");
        grafoDirigido.mostrarMatrizAdyacencia();
        
        // Recorridos - SÍ SE PUEDE RECORRER IGUAL
        System.out.println("\nRecorrido BFS desde Juan (Grafo Dirigido):");
        System.out.println("------------------------------------------");
        grafoDirigido.bfs(p1);
        
        System.out.println("\nRecorrido DFS desde Juan (Grafo Dirigido):");
        System.out.println("------------------------------------------");
        grafoDirigido.dfs(p1);
        
        System.out.println("\n\n3. PRUEBA DE ELIMINACIÓN");
        System.out.println("========================\n");
        
        System.out.println("Eliminando arista Juan -> Maria del grafo dirigido:");
        grafoDirigido.eliminarArista(p1, p2, 1);
        grafoDirigido.mostrarMatrizAdyacencia();
        
        System.out.println("\n=== FIN DEL TEST ===");
    }
}
