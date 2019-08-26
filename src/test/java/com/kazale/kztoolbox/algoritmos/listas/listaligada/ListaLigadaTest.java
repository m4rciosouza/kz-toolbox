package com.kazale.kztoolbox.algoritmos.listas.listaligada;

import org.junit.Test;

import static org.junit.Assert.*;

public class ListaLigadaTest {

    // ADICIONAR

    @Test
    public void testListaVazia() {
        ListaLigada<Integer> lista = new ListaLigada<>();
        assertEquals("", lista.toString());
    }

    @Test
    public void testAdicionarUmElementoNaLista() {
        ListaLigada<Integer> lista = new ListaLigada<>();
        lista.adicionar(10);
        assertEquals("10", lista.toString());
    }

    @Test
    public void testAdicionarCincoElementosNaLista() {
        ListaLigada<Integer> lista = new ListaLigada<>();
        lista.adicionar(10);
        lista.adicionar(6);
        lista.adicionar(3);
        lista.adicionar(16);
        lista.adicionar(104);
        assertEquals("10, 6, 3, 16, 104", lista.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdicionarNaPosicaoInvalida() {
        ListaLigada<Integer> lista = new ListaLigada<>();
        lista.adicionar(10, 1);
    }

    @Test
    public void testAdicionarNaPrimeiraPosicao() {
        ListaLigada<Integer> lista = new ListaLigada<>();
        lista.adicionar(10, 0);
        assertEquals("10", lista.toString());
    }

    @Test
    public void testAdicionarNoCentroDaLista() {
        ListaLigada<Integer> lista = new ListaLigada<>();
        lista.adicionar(1);
        lista.adicionar(3);
        lista.adicionar(4);
        lista.adicionar(2, 1);
        assertEquals("1, 2, 3, 4", lista.toString());
    }

    @Test
    public void testAdicionarNoFinalDaLista() {
        ListaLigada<Integer> lista = new ListaLigada<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.adicionar(4, 3);
        assertEquals("1, 2, 3, 4", lista.toString());
    }

    // OBTER ELEMENTO

    @Test(expected = IllegalArgumentException.class)
    public void testObterElementoListaVazia() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void testObterElementoPosicaoInvalida() {

    }

    @Test
    public void testObterElementoPrimeiraPosicao() {

    }

    @Test
    public void testObterElementoMeioDaLista() {

    }

    @Test
    public void testObterElementoFinalDaLista() {

    }

    // REMOVER

    @Test(expected = IllegalArgumentException.class)
    public void testRemoverElementoListaVazia() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoverElementoPosicaoInvalida() {

    }

    @Test
    public void testRemoverPrimeiroElementeDaLista() {

    }

    @Test
    public void testRemoverElementoMeioDaLista() {

    }

    @Test
    public void testRemoverElementoFinalDaLista() {

    }

}
