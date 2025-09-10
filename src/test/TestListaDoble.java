package test;

import model.ListaDoble;
import model.Vehiculo;
import model.Nodo;

public class TestListaDoble {

    public static void main(String[] args) {


    // Crear una lista doble
    ListaDoble lista = new ListaDoble();
    
    // Crear vehículos de ejemplo
    Vehiculo v1 = new model.Vehiculo("AAA111", "Toyota", "Corolla", 2020);
    Vehiculo v2 = new model.Vehiculo("BBB222", "Honda", "Civic", 2019);
    Vehiculo v3 = new model.Vehiculo("CCC333", "Ford", "Focus", 2018);
    
    // Crear nodos con los vehículos
    Nodo nodo1 = new Nodo(v1);
    Nodo nodo2 = new Nodo(v2);
    Nodo nodo3 = new Nodo(v3);

        // Insertar elementos
        lista.insertarPrimero(nodo1);
        lista.insertarUltimo(nodo2);
        lista.insertarPosicion(nodo3, 1);

        // Mostrar la lista
        System.out.println("\n [+] Lista despues de inserciones: " + lista + "\n");

        // Eliminar elementos
        lista.eliminarPrimero();
        lista.eliminarUltimo();
        lista.eliminarPosicion(0);

        // Mostrar la lista
        System.out.println("\n [+] Lista despues de eliminaciones: " + lista + "\n");

        // Volvemos a agregar para ver que sigue funcionando
        
        // lista.insertarUltimo(nodo2);

        // Mostrar la lista
        // System.out.println("\n [+] Lista despues de volver a insertar: " + lista + "\n");


    }
    
}
