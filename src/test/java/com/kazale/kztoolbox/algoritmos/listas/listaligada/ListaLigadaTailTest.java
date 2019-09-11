package com.kazale.kztoolbox.algoritmos.listas.listaligada;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ListaLigadaTailTest {

    @Test
    public void testListaVazia() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();

        assertEquals("", lista.toString());
    }

    @Test
    public void testAdicionarUmElementoNaLista() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();
        lista.adicionar(10);

        assertEquals("10", lista.toString());
    }

    @Test
    public void testAdicionarCincoElementosNaLista() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();
        lista.adicionar(10);
        lista.adicionar(6);
        lista.adicionar(3);
        lista.adicionar(16);
        lista.adicionar(104);

        assertEquals("10, 6, 3, 16, 104", lista.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdicionarNaPosicaoInvalida() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();
        lista.adicionar(10, 1);
    }

    @Test
    public void testAdicionarNaPrimeiraPosicao() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();
        lista.adicionar(10, 0);

        assertEquals("10", lista.toString());
    }

    @Test
    public void testTailAoAdicionarNaPrimeiraPosicao() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();
        lista.adicionar(10, 0);

        assertEquals(10, lista.getTail().getValor());
    }

    @Test
    public void testAdicionarNaPrimeiraPosicaoListaNaoNula() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();
        lista.adicionar(5);
        lista.adicionar(10, 0);

        assertEquals("10, 5", lista.toString());
    }

    @Test
    public void testTailAoAdicionarNaPrimeiraPosicaoListaNaoNula() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();
        lista.adicionar(5);
        lista.adicionar(10, 0);

        assertEquals(5, lista.getTail().getValor());
    }

    @Test
    public void testAdicionarNoCentroDaLista() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();
        lista.adicionar(1);
        lista.adicionar(3);
        lista.adicionar(4);
        lista.adicionar(2, 1);

        assertEquals("1, 2, 3, 4", lista.toString());
    }

    @Test
    public void testTailAoAdicionarNoCentroDaLista() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();
        lista.adicionar(1, 0);
        lista.adicionar(3, 1);
        lista.adicionar(4, 2);
        lista.adicionar(2, 1);

        assertEquals(4, lista.getTail().getValor());
    }

    @Test
    public void testAdicionarNoFinalDaLista() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.adicionar(4, 3);

        assertEquals("1, 2, 3, 4", lista.toString());
    }

    @Test
    public void testTailAoAdicionarNoFinalDaLista() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();
        lista.adicionar(1, 0);
        lista.adicionar(3, 1);
        lista.adicionar(4, 2);
        lista.adicionar(2, 3);

        assertEquals(2, lista.getTail().getValor());
    }

    // OBTER ELEMENTO

    @Test(expected = IllegalArgumentException.class)
    public void testObterElementoListaVazia() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();
        lista.obterPosicao(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testObterElementoPosicaoInvalida() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();
        lista.adicionar(1);
        lista.obterPosicao(2);
    }

    @Test
    public void testObterElementoPrimeiraPosicao() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();
        lista.adicionar(1);
        Integer valor = lista.obterPosicao(0);

        assertEquals(Integer.valueOf(1), valor);
    }

    @Test
    public void testObterElementoMeioDaLista() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        Integer valor = lista.obterPosicao(1);

        assertEquals(Integer.valueOf(2), valor);
    }

    @Test
    public void testObterElementoFinalDaLista() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        Integer valor = lista.obterPosicao(2);

        assertEquals(Integer.valueOf(3), valor);
    }

    // REMOVER

    @Test(expected = IllegalArgumentException.class)
    public void testRemoverElementoListaVazia() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();
        lista.remover(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoverElementoPosicaoInvalida() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();
        lista.adicionar(1);
        lista.remover(1);
    }

    @Test
    public void testRemoverPrimeiroElementeDaLista() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();
        lista.adicionar(1);
        lista.remover(0);

        assertEquals("", lista.toString());
    }

    @Test
    public void testTailAoRemoverPrimeiroElementeDaLista() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();
        lista.adicionar(1);
        lista.remover(0);

        assertNull(lista.getTail());
    }

    @Test
    public void testRemoverElementoMeioDaLista() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.remover(1);

        assertEquals("1, 3", lista.toString());
    }

    @Test
    public void testTailAoRemoverElementoMeioDaLista() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.remover(1);

        assertEquals(3, lista.getTail().getValor());
    }

    @Test
    public void testRemoverElementoFinalDaLista() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.remover(2);

        assertEquals("1, 2", lista.toString());
    }

    @Test
    public void testTailAoRemoverElementoFinalDaLista() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.remover(2);

        assertEquals(2, lista.getTail().getValor());
    }

    @Test
    public void testRemoverEAdicionarElementoDaLista() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.remover(1);
        lista.adicionar(4);

        assertEquals("1, 3, 4", lista.toString());
    }

    @Test
    public void testTailAoRemoverEAdicionarElementoDaLista() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.remover(1);
        lista.adicionar(4);

        assertEquals(4, lista.getTail().getValor());
    }

    @Test
    public void testRemoverEAdicionarElementoDaListaDuasVezes() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();
        lista.adicionar(1);
        lista.remover(0);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.remover(1);
        lista.adicionar(4);

        assertEquals("2, 4", lista.toString());
    }

    @Test
    public void testTailAoRemoverEAdicionarElementoDaListaDuasVezes() {
        ListaLigadaTail<Integer> lista = new ListaLigadaTail<>();
        lista.adicionar(1);
        lista.remover(0);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.remover(1);
        lista.adicionar(4);

        assertEquals(4, lista.getTail().getValor());
    }
    
}
