package model;

import interfaces.IPersona;

public class Persona implements IPersona{
    
    private String nombre;
    private String apellido;
    private int edad;
    private double dni;
    private ListaDoble listaVehiculos; // Lista de vehículos asociada a la persona

//--------------------------------------------------------------    

    // Constructor Full
    public Persona(String nombre, String apellido, int edad, double dni) { //no recibe vehiculos porque se agragan manualmente en el test.
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
        this.listaVehiculos = new ListaDoble(); // Inicializar la lista de vehículos
    }

    // Constructor Vacio
    public Persona() {
        this.nombre = "";
        this.apellido = "";
        this.edad = 0;
        this.dni = 0;
        this.listaVehiculos = new ListaDoble(); // Inicializar la lista de vehículos
    }

//--------------------------------------------------------------
    // Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String nuevoApellido) {
        this.apellido = nuevoApellido;
    }


    public int getEdad() {
        return edad;
    }

    public void setEdad(int nuevaEdad) {
        this.edad = nuevaEdad;
    }


    public double getDni() {
        return dni;
    }

    public void setDni(double nuevoDni) {
        this.dni = nuevoDni;
    }

//--------------------------------------------------------------

    @Override
    public String toString() {
        return "persona => [" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", dni=" + dni + ", vehiculos= " + listaVehiculos.toString() + ']';
    }
    
//--------------------------------------------------------------

    public ListaDoble getListaVehiculos() {
        return listaVehiculos;
    }
    public void setListaVehiculos(ListaDoble listaVehiculos) { //esto setea por una lista ya creada!
        this.listaVehiculos = listaVehiculos;
    }

    public void agregarVehiculo(Vehiculo vehiculo) { //metodo que agrega un vehiculo a la lista de vehiculos
        Nodo nuevoNodo = new Nodo(vehiculo);
        this.listaVehiculos.insertarUltimo(nuevoNodo); //usa insertarUltimo de ListaDoble
    
    
    
    }


}
