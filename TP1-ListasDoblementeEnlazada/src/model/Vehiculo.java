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
    @Override
    public String getPatente() {
        return patente;
    }

    @Override
    public void setPatente(String patente) {
        this.patente = patente;
    }

    @Override
    public String getMarca() {
        return marca;
    }

    @Override
    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String getModelo() {
        return modelo;
    }

    @Override
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }   

    @Override
    public int getAnio() {
        return anio;
    }

    @Override
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