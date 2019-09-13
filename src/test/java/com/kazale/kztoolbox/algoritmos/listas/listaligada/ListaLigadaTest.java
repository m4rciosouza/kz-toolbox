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
    public void testAdicionarNaPrimeiraPosicaoListaNaoNula() {
        ListaLigada<Integer> lista = new ListaLigada<>();
        lista.adicionar(5);
        lista.adicionar(10, 0);

        assertEquals("10, 5", lista.toString());
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
        ListaLigada<Integer> lista = new ListaLigada<>();
        lista.obterPosicao(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testObterElementoPosicaoInvalida() {
        ListaLigada<Integer> lista = new ListaLigada<>();
        lista.adicionar(1);
        lista.obterPosicao(2);
    }

    @Test
    public void testObterElementoPrimeiraPosicao() {
        ListaLigada<Integer> lista = new ListaLigada<>();
        lista.adicionar(1);
        Integer valor = lista.obterPosicao(0);

        assertEquals(Integer.valueOf(1), valor);
    }

    @Test
    public void testObterElementoMeioDaLista() {
        ListaLigada<Integer> lista = new ListaLigada<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        Integer valor = lista.obterPosicao(1);

        assertEquals(Integer.valueOf(2), valor);
    }

    @Test
    public void testObterElementoFinalDaLista() {
        ListaLigada<Integer> lista = new ListaLigada<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        Integer valor = lista.obterPosicao(2);

        assertEquals(Integer.valueOf(3), valor);
    }

    // REMOVER

    @Test(expected = IllegalArgumentException.class)
    public void testRemoverElementoListaVazia() {
        ListaLigada<Integer> lista = new ListaLigada<>();
        lista.remover(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoverElementoPosicaoInvalida() {
        ListaLigada<Integer> lista = new ListaLigada<>();
        lista.adicionar(1);
        lista.remover(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoverElementoPosicaoNegativa() {
        ListaLigada<Integer> lista = new ListaLigada<>();
        lista.adicionar(1);
        lista.remover(-1);
    }

    @Test
    public void testRemoverPrimeiroElementeDaLista() {
        ListaLigada<Integer> lista = new ListaLigada<>();
        lista.adicionar(1);
        lista.remover(0);

        assertEquals("", lista.toString());
    }

    @Test
    public void testRemoverPrimeiroElementeDaListaComMultiplosElementos() {
        ListaLigada<Integer> lista = new ListaLigada<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.remover(0);

        assertEquals("2, 3", lista.toString());
    }

    @Test
    public void testRemoverElementoMeioDaLista() {
        ListaLigada<Integer> lista = new ListaLigada<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.remover(1);

        assertEquals("1, 3", lista.toString());
    }

    @Test
    public void testRemoverElementoFinalDaLista() {
        ListaLigada<Integer> lista = new ListaLigada<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.remover(2);

        assertEquals("1, 2", lista.toString());
    }

    @Test
    public void testRemoverEAdicionarElementoDaLista() {
        ListaLigada<Integer> lista = new ListaLigada<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.remover(1);
        lista.adicionar(4);

        assertEquals("1, 3, 4", lista.toString());
    }

    @Test
    public void testRemoverEAdicionarElementoDaListaDuasVezes() {
        ListaLigada<Integer> lista = new ListaLigada<>();
        lista.adicionar(1);
        lista.remover(0);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.remover(1);
        lista.adicionar(4);

        assertEquals("2, 4", lista.toString());
    }

}
