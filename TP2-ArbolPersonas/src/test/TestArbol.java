package test;

import model.Arbol;
import model.Persona;
import java.util.Comparator;

public class TestArbol {

    public static void main(String[] args) {
        System.out.println("=== TestArbol ===");

        // Crear personas usando el constructor completo
        Persona p1 = new Persona("Juan Perez", 12345678L);
        Persona p2 = new Persona("Ana Gomez", 87654321L);
        Persona p3 = new Persona("Carlos Lopez", 45678912L);
        Persona p4 = new Persona("Maria Rodriguez", 23456789L);
        Persona p5 = new Persona("Pedro Martinez", 65432198L);

        // Crear un árbol con comparación por DNI
        Arbol<Persona> arbol = new Arbol<>(Comparator.comparing(Persona::getDni));

        // Insertar las personas en el árbol
        arbol.setRaiz(arbol.insertarRecursivo(arbol.getRaiz(), p1));
        arbol.setRaiz(arbol.insertarRecursivo(arbol.getRaiz(), p2));
        arbol.setRaiz(arbol.insertarRecursivo(arbol.getRaiz(), p3));
        arbol.setRaiz(arbol.insertarRecursivo(arbol.getRaiz(), p4));
        arbol.setRaiz(arbol.insertarRecursivo(arbol.getRaiz(), p5));

        // Mostrar el árbol usando toString()
        System.out.println(arbol);

        // Demostrar getCantNodos
        System.out.println("Cantidad de nodos: " + arbol.getCantNodos());
    }

}
