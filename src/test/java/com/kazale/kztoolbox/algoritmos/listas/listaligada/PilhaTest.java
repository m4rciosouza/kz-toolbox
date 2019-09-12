package com.kazale.kztoolbox.algoritmos.listas.listaligada;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PilhaTest {

    private Pilha<Integer> pilha;

    @Before
    public void init() {
        pilha = new Pilha<>();
    }

    @Test
    public void testAdicionarUmElemento() {
        pilha.adicionar(1);

        assertEquals("1", pilha.toString());
    }

    @Test
    public void testAdicionarMultiplosElementos() {
        pilha.adicionar(1);
        pilha.adicionar(2);
        pilha.adicionar(3);
        pilha.adicionar(4);
        pilha.adicionar(5);

        assertEquals("1, 2, 3, 4, 5", pilha.toString());
    }

    @Test
    public void testRemoverUmElemento() {
        pilha.adicionar(1);
        int valor = pilha.remover();

        assertEquals(1, valor);
    }

    @Test
    public void testRemoverMultiplosElementos() {
        pilha.adicionar(1);
        pilha.adicionar(2);
        pilha.adicionar(3);

        assertEquals(Integer.valueOf(3), pilha.remover());
        assertEquals(Integer.valueOf(2), pilha.remover());
        assertEquals(Integer.valueOf(1), pilha.remover());
    }

}
