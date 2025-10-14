package interfaces;

public interface IPersona {

    // Pre: La persona debe estar inicializada
    // Pos: Retorna el nombre de la persona
    // Ax: getNombre() = nombre almacenado
    public String getNombre();
    
    // Pre: nombre != null 
    // Pos: Establece el nombre de la persona
    // Ax: setNombre(nonmbre) -> getNombre() = nombre
    public void setNombre(String nombre);
    
    // Pre: La persona debe estar inicializada
    // Pos: Retorna la edad de la persona
    // Ax: getDni() = dni almacenado
    public long getDni();
    
    // Pre: edad >= 0
    // Pos: Establece la edad de la persona
    // Ax: setDni(dni) → getEdad() = dni
    public void setDni(long dni);
    
    // Pre: La persona debe estar inicializada
    // Pos: Retorna una representación en cadena de la persona
    // Ax: toString() = representación textual con nombre y edad
    public String toString();
}
