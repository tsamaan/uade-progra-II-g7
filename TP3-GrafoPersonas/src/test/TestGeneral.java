package test;

import interfaces.IGrafo;
import interfaces.IPersona;
import model.Grafo;
import model.Persona;

public class TestGeneral {

    public static void main(String[] args){

        // Crear Personas
        IPersona p1 = new Persona("Juan Perez", 111111111);
        IPersona p2 = new Persona("Ignacio Fernandez", 222222222);
        IPersona p3 = new Persona("Catalina Valles", 333333333);
        IPersona p4 = new Persona("Román Meyer", 444444444);
        IPersona p5 = new Persona("Ana Castro", 555555555);

        IGrafo grafo = new Grafo();

        // Crear Nodos
        grafo.agregarNodo(p1);
        grafo.agregarNodo(p2);
        grafo.agregarNodo(p3);
        grafo.agregarNodo(p4);
        grafo.agregarNodo(p5);

        // Crear aristas
        grafo.agregarArista(p1,p2, 2);
        grafo.agregarArista(p2,p4, 3);
        grafo.agregarArista(p2,p3, 1);
        grafo.agregarArista(p4,p4, 1);
        grafo.agregarArista(p3,p5,3);
        grafo.agregarArista(p1,p5, 3);
        grafo.agregarArista(p4,p5, 2);

        // Visualizacion y Recorridos
        grafo.mostrarMatrizAdyacencia();
        grafo.bfs(p1);
        grafo.dfs(p1);


    }

    

}
