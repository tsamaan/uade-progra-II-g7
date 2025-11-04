package test;

import interfaces.IPersona;
import model.Persona;

public class TestPersona {

    public static void main(String[] args) {
        System.out.println("=== TestPersona ===");

        // Crear persona con constructor completo
        IPersona p1 = new Persona("Juan Perez", 12345678L);

        // Mostrar getters
        System.out.println("Nombre esperado: Juan Perez -> " + p1.getNombre());
        System.out.println("DNI esperado: 12345678 -> " + p1.getDni());

        // Probar setters
        p1.setNombre("Ana Gomez");
        p1.setDni(87654321L);

        System.out.println("Nombre cambiado (esperado Ana Gomez): " + p1.getNombre());
        System.out.println("DNI cambiado (esperado 87654321): " + p1.getDni());

        // toString (en Persona.java: "nombre(DNI:dni)")
        System.out.println("toString esperado: Ana Gomez(DNI:87654321)");
        System.out.println("toString real:     " + p1.toString());
    }
}

