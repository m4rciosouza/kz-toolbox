package com.kazale.kztoolbox.algoritmos.arvores;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArvoreTest {

    @Test
    public void testArvoreNula() {
        Arvore<Integer> arvore = new Arvore<>(null);

        assertNull(arvore.getRaiz().getValor());
        assertNull(arvore.getRaiz().getPai());
    }

    @Test
    public void testArvoreUnicoElemento() {
        Arvore<Integer> arvore = new Arvore<>(10);

        assertEquals(10, arvore.getRaiz().getValor().intValue());
        assertNull(arvore.getRaiz().getPai());
    }

    @Test
    public void testArvoreDoisElementos() {
        Arvore<Integer> arvore = new Arvore<>(10);
        Node<Integer> node = new Node<>(100, arvore.getRaiz());
        arvore.getRaiz().getFilhos().add(node);

        assertEquals(10, arvore.getRaiz().getValor().intValue());
        assertEquals(100, arvore.getRaiz().getFilhos().get(0).getValor().intValue());
    }

    @Test
    public void testPaiRefenciadoCorretamente() {
        Arvore<Integer> arvore = new Arvore<>(10);
        Node<Integer> node = new Node<>(100, arvore.getRaiz());
        arvore.getRaiz().getFilhos().add(node);

        assertEquals(arvore.getRaiz(), arvore.getRaiz().getFilhos().get(0).getPai());
    }

}
