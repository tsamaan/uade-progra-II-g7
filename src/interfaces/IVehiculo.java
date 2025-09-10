package interfaces;

public interface IVehiculo {

    // Pre: Vehículo creado
    // Pos: Devuelve la patente
    // Ax: getPatente() = patente
    public String getPatente();

    // Pre: Vehículo creado
    // Pos: La patente es actualizada
    // Ax: getPatente() = patente luego de setPatente(patente)
    public void setPatente(String patente);

    // Pre: Vehículo creado
    // Pos: Devuelve la marca
    // Ax: getMarca() = marca
    public String getMarca();

    // Pre: Vehículo creado
    // Pos: La marca es actualizada
    // Ax: getMarca() = marca luego de setMarca(marca)
    public void setMarca(String marca);

    // Pre: Vehículo creado
    // Pos: Devuelve el modelo
    // Ax: getModelo() = modelo
    public String getModelo();

    // Pre: Vehículo creado
    // Pos: El modelo es actualizado
    // Ax: getModelo() = modelo luego de setModelo(modelo)
    public void setModelo(String modelo);

    // Pre: Vehículo creado
    // Pos: Devuelve el año
    // Ax: getAnio() = anio
    public int getAnio();

    // Pre: Vehículo creado
    // Pos: El año es actualizado
    // Ax: getAnio() = anio luego de setAnio(anio)
    public void setAnio(int anio);

    // Pre: Vehículo creado
    // Pos: Devuelve una representación en texto del vehículo
    // Ax: toString() describe el vehículo
    public String toString();

}