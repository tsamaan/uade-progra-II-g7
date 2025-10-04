package interfaces;

import model.Persona;

public interface IComparadorPersona {
    
    // Pre: p1 y p2 deben estar inicializadas
    // Pos: Compara dos personas por su DNI
    // Ax: compare(p1, p2) < 0 si p1 < p2, 0 si p1 == p2, > 0 si p1 > p2
    public int compare(Persona p1, Persona p2);

}
