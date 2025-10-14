package test;

import model.Nodo;
import model.Vehiculo;

public class TestNodo {
    public static void main(String[] args) {

        Vehiculo vehiculo1 = new Vehiculo("ABC123", "Toyota", "Corolla", 2020);
        Vehiculo vehiculo2 = new Vehiculo("DEF456", "Honda", "Civic", 2019);
        Vehiculo vehiculo3 = new Vehiculo("GHI789", "Ford", "Focus", 2018);

        Nodo<Vehiculo> nodo1 = new Nodo<>(vehiculo1);
        Nodo<Vehiculo> nodo2 = new Nodo<>(vehiculo2);
        Nodo<Vehiculo> nodo3 = new Nodo<>(vehiculo3);

        nodo1.setSiguiente(nodo2);
        nodo2.setAnterior(nodo1);
        nodo2.setSiguiente(nodo3);
        nodo3.setAnterior(nodo2);

        System.out.println("Nodo 1: " + nodo1.toString());
        System.out.println("Nodo 2: " + nodo2.toString());
        System.out.println("Nodo 3: " + nodo3.toString());




    }
}
