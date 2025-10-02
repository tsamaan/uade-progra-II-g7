package interfaces;

public interface IPersona{
    
    // Pre: Persona creada
    // Pos: Devuelve el nombre
    // Ax: getNombre() = nombre
    public String getNombre();
    
    // Pre: Persona creada
    // Pos: El nombre es actualizado
    // Ax: getNombre() = nuevoNombre luego de setNombre(nuevoNombre)
    public void setNombre(String nuevoNombre);
    
    // Pre: Persona creada
    // Pos: Devuelve el apellido
    // Ax: getApellido() = apellido
    public String getApellido();

    // Pre: Persona creada
    // Pos: El apellido es actualizado
    // Ax: getApellido() = nuevoApellido luego de setApellido(nuevoApellido)
    public void setApellido(String nuevoApellido);

    // Pre: Persona creada
    // Pos: Devuelve la edad
    // Ax: getEdad() = edad
    public int getEdad();

    // Pre: Persona creada
    // Pos: La edad es actualizada
    // Ax: getEdad() = nuevaEdad luego de setEdad(nuevaEdad)
    public void setEdad(int nuevaEdad);

    // Pre: Persona creada
    // Pos: Devuelve el DNI
    // Ax: getDni() = dni
    public double getDni();

    // Pre: Persona creada
    // Pos: El DNI es actualizado
    // Ax: getDni() = nuevoDni luego de setDni(nuevoDni)
    public void setDni(double nuevoDni); 

    // Pre: Persona creada
    // Pos: Devuelve una representación en texto de la persona
    // Ax: toString() describe la persona
    @Override
    public String toString();
}
