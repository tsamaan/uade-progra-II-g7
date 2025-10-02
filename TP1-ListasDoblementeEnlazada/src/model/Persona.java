package model;

import interfaces.IPersona;

public class Persona implements IPersona{
    
    private String nombre;
    private String apellido;
    private int edad;
    private double dni;
    private ListaDoble<Vehiculo> listaVehiculos; // Lista de vehículos asociada a la persona

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
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    
    @Override
    public String getApellido() {
        return apellido;
    }

    @Override
    public void setApellido(String nuevoApellido) {
        this.apellido = nuevoApellido;
    }


    @Override
    public int getEdad() {
        return edad;
    }

    @Override
    public void setEdad(int nuevaEdad) {
        this.edad = nuevaEdad;
    }


    @Override
    public double getDni() {
        return dni;
    }

    @Override
    public void setDni(double nuevoDni) {
        this.dni = nuevoDni;
    }

//--------------------------------------------------------------

    @Override
    public String toString() {
        return "persona => [" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", dni=" + dni + ", vehiculos= " + listaVehiculos.toString() + ']';
    }
    
//--------------------------------------------------------------

    public ListaDoble<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }
    public void setListaVehiculos(ListaDoble<Vehiculo> listaVehiculos) { //esto setea por una lista ya creada!
        this.listaVehiculos = listaVehiculos;
    }

    public void agregarVehiculo(Vehiculo vehiculo) { //metodo que agrega un vehiculo a la lista de vehiculos
        Nodo<Vehiculo> nuevoNodo = new Nodo<>(vehiculo);
        this.listaVehiculos.insertarUltimo(nuevoNodo); //usa insertarUltimo de ListaDoble
    
    
    
    }


}
