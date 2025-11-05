package test;

import interfaces.IArista;
import interfaces.INodo;
import interfaces.IPersona;
import model.Arista;
import model.Nodo;
import model.Persona;

public class TestArista {

    public static void main(String[] args) {
        System.out.println("=== TestArista ===");

        // Datos de prueba
        IPersona a = new Persona("Ana", 11111111L);
        IPersona b = new Persona("Beto", 22222222L);

        // Nodo destino inicial: b
        INodo<IPersona> nodoB = new Nodo<>(b);

        // Crear arista destino=b, peso=5
        IArista<IPersona> arista = new Arista<>(nodoB, 5);

        // Verificar getters basicos
        System.out.println("Destino esperado: Beto -> " + arista.getDestino().getDato().getNombre());
        System.out.println("Peso esperado: 5 -> " + arista.getPeso());

        // Cambiar peso
        arista.setPeso(9);
        System.out.println("Peso cambiado (esperado 9): " + arista.getPeso());

        // Cambiar destino a 'Ana'
        INodo<IPersona> nodoA = new Nodo<>(a);
        arista.setDestino(nodoA);
        System.out.println("Destino cambiado (esperado Ana): " + arista.getDestino().getDato().getNombre());

        // toString de Arista
        // Arista.toString(): destino.getDato() + "(" + peso + ")"
        // Como destino.getDato() es una Persona, usa Persona.toString(): "Ana(DNI:11111111)"
        // Resultado esperado: "Ana(DNI:11111111)(9)"
        System.out.println("toString esperado: Ana(DNI:11111111)(9)");
        System.out.println("toString real:     " + arista.toString());
    }
}
