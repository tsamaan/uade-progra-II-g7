
package test;

import model.Persona;
import model.Arbol;
import model.ComparadorPersonaDNI;
import model.ComparadorPersonaNombre;
import interfaces.IArbol;
import interfaces.IPersona;

public class TestGeneral {
    
    public static void main(String[] args) {
        // Crear 15 personas
        IPersona[] personas = {
            new Persona("Nicolas Cortese", 38893014),
            new Persona("Juan Pérez", 12345678),
            new Persona("Pedro Smith", 23456789),
            new Persona("Teodoro Samaan", 34567890),
            new Persona("Maria Luzzolino", 45678901),
            new Persona("Nayla Mongelos", 56789012),
            new Persona("Lucas Pratto", 67890123),
            new Persona("Lionel Messi", 78901234),
            new Persona("Enzo Perez", 89012345),
            new Persona("Juanfer Quintero", 90123456),
            new Persona("Franco Armani", 10234567),
            new Persona("Julian Alvarez", 11234567),
            new Persona("Agustin Creevy", 12234567),
            new Persona("Gonzalo Montiel", 13234567),
            new Persona("Franco Mastantuono", 14234567)
        };
        
        // Comparativa por DNI
        System.out.println("=== ÁRBOL ORDENADO POR DNI ===");
        IArbol<IPersona> arbolDNI = new Arbol<>(new ComparadorPersonaDNI());
        
        // Insertar 15 personas
        for (IPersona persona : personas) {
            arbolDNI.setRaiz(arbolDNI.insertarRecursivo(arbolDNI.getRaiz(), persona, new ComparadorPersonaDNI()));
        }
        
        // Mostrar recorridos
        System.out.println("RECORRIDO INORDEN:");
        arbolDNI.recorridoInorden();
        
        System.out.println("\nRECORRIDO PREORDEN:");
        arbolDNI.recorridoPreorden();
        
        System.out.println("\nRECORRIDO POSTORDEN:");
        arbolDNI.recorridoPostorden();
        
        // Búsquedas
        System.out.println("\nBÚSQUEDAS:");
        System.out.println("Buscar Nicolas Cortese: " + arbolDNI.buscarRecursivo(arbolDNI.getRaiz(), personas[0], new ComparadorPersonaDNI()));
        System.out.println("Buscar Lionel Messi: " + arbolDNI.buscarRecursivo(arbolDNI.getRaiz(), personas[7], new ComparadorPersonaDNI()));
        
        // Eliminaciones
        System.out.println("\nELIMINACIONES:");
        arbolDNI.setRaiz(arbolDNI.eliminarRecursivo(arbolDNI.getRaiz(), personas[2], new ComparadorPersonaDNI()));
        arbolDNI.setRaiz(arbolDNI.eliminarRecursivo(arbolDNI.getRaiz(), personas[8], new ComparadorPersonaDNI()));
        
        // Mostrar recorridos después de eliminaciones
        System.out.println("\nRECORRIDOS DESPUÉS DE ELIMINACIONES:");
        System.out.println("INORDEN:");
        arbolDNI.recorridoInorden();
        System.out.println("\nPREORDEN:");
        arbolDNI.recorridoPreorden();
        System.out.println("\nPOSTORDEN:");
        arbolDNI.recorridoPostorden();
        
        // Comparativa por Nombre
        System.out.println("\n\n=== ÁRBOL ORDENADO POR NOMBRE ===");
        IArbol<IPersona> arbolNombre = new Arbol<>(new ComparadorPersonaNombre());
        
        // Insertar 15 personas
        for (IPersona persona : personas) {
            arbolNombre.setRaiz(arbolNombre.insertarRecursivo(arbolNombre.getRaiz(), persona, new ComparadorPersonaNombre()));
        }
        
        // Mostrar recorridos
        System.out.println("RECORRIDO INORDEN:");
        arbolNombre.recorridoInorden();
        
        System.out.println("\nRECORRIDO PREORDEN:");
        arbolNombre.recorridoPreorden();
        
        System.out.println("\nRECORRIDO POSTORDEN:");
        arbolNombre.recorridoPostorden();
        
        // Búsquedas
        System.out.println("\nBÚSQUEDAS:");
        System.out.println("Buscar Nicolas Cortese: " + arbolNombre.buscarRecursivo(arbolNombre.getRaiz(), personas[0], new ComparadorPersonaNombre()));
        System.out.println("Buscar Lionel Messi: " + arbolNombre.buscarRecursivo(arbolNombre.getRaiz(), personas[7], new ComparadorPersonaNombre()));
        
        // Eliminaciones
        System.out.println("\nELIMINACIONES:");
        arbolNombre.setRaiz(arbolNombre.eliminarRecursivo(arbolNombre.getRaiz(), personas[2], new ComparadorPersonaNombre()));
        arbolNombre.setRaiz(arbolNombre.eliminarRecursivo(arbolNombre.getRaiz(), personas[8], new ComparadorPersonaNombre()));
        
        // Mostrar recorridos después de eliminaciones
        System.out.println("\nRECORRIDOS DESPUÉS DE ELIMINACIONES:");
        System.out.println("INORDEN:");
        arbolNombre.recorridoInorden();
        System.out.println("\nPREORDEN:");
        arbolNombre.recorridoPreorden();
        System.out.println("\nPOSTORDEN:");
        arbolNombre.recorridoPostorden();
    }
}
