package model;

import interfaces.IVehiculo;

public class Vehiculo implements IVehiculo{
    
    private String patente;
    private String marca;
    private String modelo;
    private int anio;

//--------------------------------------------------------------    

    // Constructor Full
    public Vehiculo(String patente, String marca, String modelo, int anio) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    // Constructor Vacio
    public Vehiculo() {
        this.patente = "";
        this.marca = "";
        this.modelo = "";
        this.anio = 0;
    }

//--------------------------------------------------------------   
 
    // Getters and Setters
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }   


    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }  

//--------------------------------------------------------------

    @Override
    public String toString() {
        return "[" +
                "patente=" + patente + 
                ", marca=" + marca + 
                ", modelo=" + modelo + 
                ", anio=" + anio + ']';
    }

}