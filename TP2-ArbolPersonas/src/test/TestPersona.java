package test;

import interfaces.IPersona;
import model.Persona;

public class TestPersona {

    public static void main(String[] args) {
        System.out.println("=== TestPersona ===");

        // Crear personas usando el constructor completo
        IPersona p1 = new Persona("Juan Perez", 12345678L);

        // Crear persona por defecto y luego usar setters
        IPersona p2 = new Persona();
        p2.setNombre("Ana Gomez");
        p2.setDni(87654321L);

        // Mostrar usando toString()
        System.out.println("Persona 1:");
        System.out.println(p1);

        System.out.println("Persona 2:");
        System.out.println(p2);

        // Demostrar getters
        System.out.println("Verificando getters:");
        System.out.println("p1 nombre: " + p1.getNombre() + ", dni: " + p1.getDni());
        System.out.println("p2 nombre: " + p2.getNombre() + ", dni: " + p2.getDni());
    }

}

