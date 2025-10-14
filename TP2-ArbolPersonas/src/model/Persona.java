package model;

public class Persona implements interfaces.IPersona {
    
    private String nombre;
    private long dni;

// ---- Constructor

    public Persona(String nombre, long dni) {
        this.nombre = nombre;
        this.dni = dni;
    }
    
    public Persona() {
        this.nombre = "";
        this.dni = 0;
    }

// ---- Getters y Setters

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public long getDni() {
        return dni;
    }

    @Override
    public void setDni(long dni) {
        this.dni = dni;
    }

//    

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nDNI: " + dni + "\n";
    }

}
