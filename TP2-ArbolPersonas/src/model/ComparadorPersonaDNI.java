package model;

import java.util.Comparator;
import interfaces.IComparadorPersona;

public class ComparadorPersonaDNI implements IComparadorPersona, Comparator<Persona> {
    
    @Override
    public int compare(Persona p1, Persona p2) {
        // Comparamos por DNI para mantener el orden en el árbol
        return Long.compare(p1.getDni(), p2.getDni());
    }
}