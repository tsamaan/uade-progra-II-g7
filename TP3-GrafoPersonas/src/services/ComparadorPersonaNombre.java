package services;

import java.util.Comparator;
import interfaces.IComparadorPersona;
import model.Persona;

public class ComparadorPersonaNombre implements IComparadorPersona, Comparator<Persona> {
    
    @Override
    public int compare(Persona p1, Persona p2) {
        // Comparamos por nombre (orden alfabético)
        return p1.getNombre().compareTo(p2.getNombre());
    }
}
