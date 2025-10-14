package test;

import model.Persona;
import model.Arbol;
import model.ComparadorPersonaDNI;
import interfaces.IArbol;
import interfaces.IPersona;
import interfaces.IComparadorPersona;

public class TestArbol {

    public static void main(String[] args) {
        System.out.println("=== TestArbol ===");

        // Crear 5 personas
        IPersona p1 = new Persona("Juan Perez", 111111111);
        IPersona p2 = new Persona("Ignacio Fernandez", 222222222);
        IPersona p3 = new Persona("Catalina Valles", 333333333);
        IPersona p4 = new Persona("Román Meyer", 444444444);
        IPersona p5 = new Persona("Ana Castro", 555555555);

        // Crear el comparador
        IComparadorPersona comparador = new ComparadorPersonaDNI();

        // Crear el árbol
        IArbol<IPersona> arbol = new Arbol<>(comparador);

        // Insertar las personas en el arbol
        arbol.setRaiz(arbol.insertarRecursivo(arbol.getRaiz(), p1, comparador));
        arbol.setRaiz(arbol.insertarRecursivo(arbol.getRaiz(), p2, comparador));
        arbol.setRaiz(arbol.insertarRecursivo(arbol.getRaiz(), p3, comparador));
        arbol.setRaiz(arbol.insertarRecursivo(arbol.getRaiz(), p4, comparador));
        arbol.setRaiz(arbol.insertarRecursivo(arbol.getRaiz(), p5, comparador));

        // Mostrar información del árbol
        System.out.println("\n" + arbol.toString());

        // Elimino una persona del arbol
        System.out.println("Elimino la persona con DNI: " + p2.getDni());
        arbol.eliminarRecursivo(arbol.getRaiz(), p2, comparador);

        // Vuelvo a mostrar la informacion del arbol para confirmar eliminacion
        System.out.println("\n" + arbol.toString());

        //Busco una persona en el arbol
        if (arbol.buscarRecursivo(arbol.getRaiz(), p3, comparador)){
            System.out.println(p3.getNombre()+ " está en el arbol.");
        } else {
            System.out.println(p3.getNombre() + " no está en el arbol.");
        }
    }

}
