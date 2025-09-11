package test;

import model.Persona;
import model.Vehiculo;

<<<<<<< HEAD
public class TestGeneral {
    public static void main(String[] args) {
     
        System.out.println("=== PRUEBA PERSONA CON LISTA DE VEHÍCULOS ===\n");
        
        // Crear persona
        Persona p1 = new Persona("Juan", "Perez", 30, 12345678);
        System.out.println("Persona creada: " + p1.getNombre() + " " + p1.getApellido());
        
        // Crear vehículos
        Vehiculo v1 = new Vehiculo("ZZZ999", "Toyota", "Corolla", 2020);
        Vehiculo v2 = new Vehiculo("AAA111", "Honda", "Civic", 2019);
        Vehiculo v3 = new Vehiculo("CCC333", "Ford", "Focus", 2018);
        Vehiculo v4 = new Vehiculo("BBB222", "Chevrolet", "Cruze", 2021);
        
        System.out.println("\n1. AGREGANDO VEHÍCULOS A LA PERSONA:");
        p1.agregarVehiculo(v1);
        System.out.println("   - Agregado: " + v1.getPatente());
        
        p1.agregarVehiculo(v2);
        System.out.println("   - Agregado: " + v2.getPatente());
        
        p1.agregarVehiculo(v3);
        System.out.println("   - Agregado: " + v3.getPatente());
        
        p1.agregarVehiculo(v4);
        System.out.println("   - Agregado: " + v4.getPatente());

        System.out.println("\n2. MOSTRANDO LISTA DE VEHÍCULOS:");
        p1.getListaVehiculos().mostrarLista();

        System.out.println("3. PROBANDO FUNCIONALIDADES DE LA LISTA:");
        System.out.println("   - Cantidad de vehículos: " + p1.getListaVehiculos().cantidadElementos());
        System.out.println("   - Primer vehículo: " + p1.getListaVehiculos().obtenerPrimero().toString());
        System.out.println("   - Último vehículo: " + p1.getListaVehiculos().obtenerUltimo().toString());
        
        // Buscar un vehículo
        int posicion = p1.getListaVehiculos().buscarSecuencial("AAA111");
        System.out.println("   - Vehículo 'AAA111' encontrado en posición: " + posicion);

        System.out.println("\n4. ORDENANDO VEHÍCULOS POR PATENTE:");
        p1.getListaVehiculos().ordenarLista();
        p1.getListaVehiculos().mostrarLista();

        System.out.println("5. INFORMACIÓN COMPLETA DE LA PERSONA:");
        System.out.println(p1.toString());

        System.out.println("\n=== PRUEBA COMPLETADA ===");
=======

public class TestGeneral {
    public static void main(String[] args) {
     
        Persona p1 = new Persona("Juan", "Perez", 30, 12345678);
        
        Vehiculo v1 = new Vehiculo("ABC123", "Toyota", "Corolla", 2020);
        Vehiculo v2 = new Vehiculo("DEF456", "Honda", "Civic", 2019);
        
        p1.agregarVehiculo(v1);
        p1.agregarVehiculo(v2);

        System.out.println(p1);

>>>>>>> main
    }
}
