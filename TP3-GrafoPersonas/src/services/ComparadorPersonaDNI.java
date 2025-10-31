package services;

import java.util.Comparator;
import interfaces.IComparadorPersona;
import model.Persona;

public class ComparadorPersonaDNI implements IComparadorPersona, Comparator<Persona> {
    
    @Override
    public int compare(Persona p1, Persona p2) {
        // Comparamos por DNI (de menor a mayor)
        return Long.compare(p1.getDni(), p2.getDni());
    }
}