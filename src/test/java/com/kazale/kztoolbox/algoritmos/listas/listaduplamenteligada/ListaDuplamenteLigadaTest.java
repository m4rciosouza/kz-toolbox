package com.kazale.kztoolbox.algoritmos.listas.listaduplamenteligada;

import org.junit.Test;

import static org.junit.Assert.*;

public class ListaDuplamenteLigadaTest {

    @Test
    public void testListaVazia() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();

        assertEquals("", lista.toString());
    }

    @Test
    public void testAdicionarUmElementoNaLista() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(10);

        assertEquals("10", lista.toString());
    }

    @Test
    public void testAdicionarCincoElementosNaLista() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(10);
        lista.adicionar(6);
        lista.adicionar(3);
        lista.adicionar(16);
        lista.adicionar(104);

        assertEquals("10, 6, 3, 16, 104", lista.toString());
    }

    @Test
    public void testPreviousAoAdicionarCincoElementosNaLista() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(10);
        lista.adicionar(6);
        lista.adicionar(3);
        lista.adicionar(16);
        lista.adicionar(104);

        assertTrue(validarPrevious(lista.getHead()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdicionarNaPosicaoInvalida() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(10, 1);
    }

    @Test
    public void testAdicionarNaPrimeiraPosicao() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(10, 0);

        assertEquals("10", lista.toString());
    }

    @Test
    public void testPreviousAoAdicionarNaPrimeiraPosicao() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(10, 0);

        assertNull(lista.getHead().getPrevious());
    }

    @Test
    public void testAdicionarNaPrimeiraPosicaoListaNaoNula() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(5);
        lista.adicionar(10, 0);

        assertEquals("10, 5", lista.toString());
    }

    @Test
    public void testPreviousAoAdicionarNaPrimeiraPosicaoListaNaoNula() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(5);
        lista.adicionar(10, 0);

        assertTrue(validarPrevious(lista.getHead()));
    }

    @Test
    public void testTailAoAdicionarNaPrimeiraPosicao() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(10, 0);

        assertEquals(Integer.valueOf(10), lista.getTail().getValor());
    }


    @Test
    public void testAdicionarNoCentroDaLista() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(1);
        lista.adicionar(3);
        lista.adicionar(4);
        lista.adicionar(2, 1);

        assertEquals("1, 2, 3, 4", lista.toString());
    }

    @Test
    public void testTailAoAdicionarNoCentroDaLista() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(1, 0);
        lista.adicionar(3, 1);
        lista.adicionar(4, 2);
        lista.adicionar(2, 1);

        assertEquals(Integer.valueOf(4), lista.getTail().getValor());
    }

    @Test
    public void testPreviousAoAdicionarNoCentroDaLista() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(1, 0);
        lista.adicionar(3, 1);
        lista.adicionar(4, 2);
        lista.adicionar(2, 1);

        assertTrue(validarPrevious(lista.getHead()));
    }

    @Test
    public void testAdicionarNoFinalDaLista() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.adicionar(4, 3);

        assertEquals("1, 2, 3, 4", lista.toString());
    }

    @Test
    public void testPreviousAoAdicionarNoFinalDaLista() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.adicionar(4, 3);

        assertTrue(validarPrevious(lista.getHead()));
    }

    @Test
    public void testTailAoAdicionarNoFinalDaLista() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(1, 0);
        lista.adicionar(3, 1);
        lista.adicionar(4, 2);
        lista.adicionar(2, 3);

        assertEquals(Integer.valueOf(2), lista.getTail().getValor());
    }

    // OBTER ELEMENTO

    @Test(expected = IllegalArgumentException.class)
    public void testObterElementoListaVazia() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.obterPosicao(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testObterElementoPosicaoInvalida() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(1);
        lista.obterPosicao(2);
    }

    @Test
    public void testObterElementoPrimeiraPosicao() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(1);
        Integer valor = lista.obterPosicao(0);

        assertEquals(Integer.valueOf(1), valor);
    }

    @Test
    public void testObterElementoMeioDaLista() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        Integer valor = lista.obterPosicao(1);

        assertEquals(Integer.valueOf(2), valor);
    }

    @Test
    public void testObterElementoFinalDaLista() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        Integer valor = lista.obterPosicao(2);

        assertEquals(Integer.valueOf(3), valor);
    }

    // REMOVER

    @Test(expected = IllegalArgumentException.class)
    public void testRemoverElementoListaVazia() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.remover(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoverElementoPosicaoInvalida() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(1);
        lista.remover(1);
    }

    @Test
    public void testRemoverPrimeiroElementeDaLista() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(1);
        lista.remover(0);

        assertEquals("", lista.toString());
    }

    @Test
    public void testPreviousAoRemoverPrimeiroElementeDaLista() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(1);
        lista.remover(0);

        assertTrue(validarPrevious(lista.getHead()));
    }

    @Test
    public void testTailAoRemoverPrimeiroElementeDaLista() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(1);
        lista.remover(0);

        assertNull(lista.getTail());
    }

    @Test
    public void testRemoverElementoMeioDaLista() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.remover(1);

        assertEquals("1, 3", lista.toString());
    }

    @Test
    public void testPreviousAoRemoverElementoMeioDaLista() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.remover(1);

        assertTrue(validarPrevious(lista.getHead()));
    }

    @Test
    public void testTailAoRemoverElementoMeioDaLista() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.remover(1);

        assertEquals(Integer.valueOf(3), lista.getTail().getValor());
    }

    @Test
    public void testRemoverElementoFinalDaLista() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.remover(2);

        assertEquals("1, 2", lista.toString());
    }

    @Test
    public void testPreviousAoRemoverElementoFinalDaLista() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.remover(2);

        assertTrue(validarPrevious(lista.getHead()));
    }

    @Test
    public void testTailAoRemoverElementoFinalDaLista() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.remover(2);

        assertEquals(Integer.valueOf(2), lista.getTail().getValor());
    }

    @Test
    public void testRemoverEAdicionarElementoDaLista() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.remover(1);
        lista.adicionar(4);

        assertEquals("1, 3, 4", lista.toString());
    }

    @Test
    public void testPreviousAoRemoverEAdicionarElementoDaLista() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.remover(1);
        lista.adicionar(4);

        assertTrue(validarPrevious(lista.getHead()));
    }

    @Test
    public void testTailAoRemoverEAdicionarElementoDaLista() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.remover(1);
        lista.adicionar(4);

        assertEquals(Integer.valueOf(4), lista.getTail().getValor());
    }

    @Test
    public void testRemoverEAdicionarElementoDaListaDuasVezes() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(1);
        lista.remover(0);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.remover(1);
        lista.adicionar(4);

        assertEquals("2, 4", lista.toString());
    }

    @Test
    public void testPreviousAoRemoverEAdicionarElementoDaListaDuasVezes() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(1);
        lista.remover(0);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.remover(1);
        lista.adicionar(4);

        assertTrue(validarPrevious(lista.getHead()));
    }

    @Test
    public void testTailAoRemoverEAdicionarElementoDaListaDuasVezes() {
        ListaDuplamenteLigada<Integer> lista = new ListaDuplamenteLigada<>();
        lista.adicionar(1);
        lista.remover(0);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.remover(1);
        lista.adicionar(4);

        assertEquals(Integer.valueOf(4), lista.getTail().getValor());
    }

    static boolean validarPrevious(Node<Integer> head) {
        if (head == null) {
            return true;
        }
        Node<Integer> previous = head;
        Node<Integer> current = head.getNext();
        if (current.getPrevious() != previous) {
            return false;
        }
        while (current.getNext() != null) {
            if (current.getPrevious() != previous) {
                return false;
            }
            previous = current;
            current = current.getNext();
        }
        return true;

    }

}
