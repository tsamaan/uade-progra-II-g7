package model;

import interfaces.IComparadorPersona;

public class ComparadorPersonaNombre implements IComparadorPersona {
    
    @Override
    public int compare(Persona p1, Persona p2) {
        // Comparamos por nombre para mantener el orden alfabético en el árbol
        return p1.getNombre().compareTo(p2.getNombre());
    }
}
