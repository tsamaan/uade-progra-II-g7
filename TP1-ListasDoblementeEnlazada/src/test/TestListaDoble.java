package test;

import model.ListaDoble;
import model.Vehiculo;
import model.Nodo;

public class TestListaDoble {

    public static void main(String[] args) {

        System.out.println("=== PRUEBA DE LISTA DOBLEMENTE ENLAZADA ===\n");

        // Crear una lista doble
        ListaDoble<Vehiculo> lista = new ListaDoble<>();
        
        // Crear vehículos de ejemplo
        Vehiculo v1 = new Vehiculo("ZZZ999", "Toyota", "Corolla", 2020);
        Vehiculo v2 = new Vehiculo("AAA111", "Honda", "Civic", 2019);
        Vehiculo v3 = new Vehiculo("CCC333", "Ford", "Focus", 2018);
        Vehiculo v4 = new Vehiculo("BBB222", "Chevrolet", "Cruze", 2021);
        
        // Crear nodos con los vehículos
        Nodo<Vehiculo> nodo1 = new Nodo<>(v1);
        Nodo<Vehiculo> nodo2 = new Nodo<>(v2);
        Nodo<Vehiculo> nodo3 = new Nodo<>(v3);
        Nodo<Vehiculo> nodo4 = new Nodo<>(v4);

        System.out.println("1. INSERTANDO ELEMENTOS:");
        System.out.println("   - Insertando al inicio: " + v1.getPatente());
        lista.insertarPrimero(nodo1);
        
        System.out.println("   - Insertando al final: " + v2.getPatente());
        lista.insertarUltimo(nodo2);
        
        System.out.println("   - Insertando en posición 1: " + v3.getPatente());
        lista.insertarPosicion(nodo3, 1);
        
        System.out.println("   - Insertando en posición 2: " + v4.getPatente());
        lista.insertarPosicion(nodo4, 2);

        // Mostrar la lista
        System.out.println("\n2. LISTA DESPUÉS DE INSERCIONES:");
        lista.mostrarLista();

        // Probar métodos de obtención
        System.out.println("3. PROBANDO MÉTODOS DE OBTENCIÓN:");
        System.out.println("   - Primer elemento: " + lista.obtenerPrimero().toString());
        System.out.println("   - Último elemento: " + lista.obtenerUltimo().toString());
        System.out.println("   - Elemento en posición 1: " + lista.obtenerPosicion(1).toString());
        System.out.println("   - Cantidad de elementos: " + lista.cantidadElementos());

        // Probar búsqueda
        System.out.println("\n4. PROBANDO BÚSQUEDA:");
        System.out.println("   - Buscando 'AAA111': posición " + lista.buscarSecuencial("AAA111"));
        System.out.println("   - Buscando 'XXX000': posición " + lista.buscarSecuencial("XXX000"));

        // Probar ordenamiento
        System.out.println("\n5. ORDENANDO LISTA POR PATENTE:");
        lista.ordenarLista();
        lista.mostrarLista();

        // Probar eliminaciones
        System.out.println("6. PROBANDO ELIMINACIONES:");
        System.out.println("   - Eliminando primer elemento");
        lista.eliminarPrimero();
        lista.mostrarLista();
        
        System.out.println("   - Eliminando último elemento");
        lista.eliminarUltimo();
        lista.mostrarLista();
        
        System.out.println("   - Eliminando elemento en posición 0");
        lista.eliminarPosicion(0);
        lista.mostrarLista();

        System.out.println("=== PRUEBA COMPLETADA ===");
    }
}
