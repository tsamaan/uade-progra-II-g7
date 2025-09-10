package test;

import model.Persona;
import model.Vehiculo;


public class TestGeneral {
    public static void main(String[] args) {
     
        Persona p1 = new Persona("Juan", "Perez", 30, 12345678);
        
        Vehiculo v1 = new Vehiculo("ABC123", "Toyota", "Corolla", 2020);
        Vehiculo v2 = new Vehiculo("DEF456", "Honda", "Civic", 2019);
        
        p1.agregarVehiculo(v1);
        p1.agregarVehiculo(v2);

        System.out.println(p1);

    }
}
