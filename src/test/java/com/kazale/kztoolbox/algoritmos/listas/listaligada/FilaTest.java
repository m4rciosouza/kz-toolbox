package com.kazale.kztoolbox.algoritmos.listas.listaligada;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FilaTest {

    private Fila<Integer> fila;

    @Before
    public void init() {
        fila = new Fila<>();
    }

    @Test
    public void testAdicionarUmElemento() {
        fila.adicionar(1);

        assertEquals("1", fila.toString());
    }

    @Test
    public void testAdicionarMultiplosElementos() {
        fila.adicionar(1);
        fila.adicionar(2);
        fila.adicionar(3);
        fila.adicionar(4);
        fila.adicionar(5);

        assertEquals("1, 2, 3, 4, 5", fila.toString());
    }

    @Test
    public void testRemoverUmElemento() {
        fila.adicionar(1);
        int valor = fila.remover();

        assertEquals(1, valor);
    }

    @Test
    public void testRemoverMultiplosElementos() {
        fila.adicionar(1);
        fila.adicionar(2);
        fila.adicionar(3);

        assertEquals(Integer.valueOf(1), fila.remover());
        assertEquals(Integer.valueOf(2), fila.remover());
        assertEquals(Integer.valueOf(3), fila.remover());
    }

}
