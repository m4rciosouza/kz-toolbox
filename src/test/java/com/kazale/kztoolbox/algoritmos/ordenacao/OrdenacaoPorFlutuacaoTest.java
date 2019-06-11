package com.kazale.kztoolbox.algoritmos.ordenacao;

import com.kazale.kztoolbox.algoritmos.utils.Utils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Testes da classe OrdenacaoPorFlutuacao, classe que implementa o algoritmo de
 * ordenação por flutuação (bubble sort) de modo eficiente.
 *
 * @author <a href="mailto:m4rcio.souza@gmail.com">Marcio Casale de Souza</a>
 * @since 0.0.1
 */
public class OrdenacaoPorFlutuacaoTest {

    OrdenacaoPorFlutuacao ordenacaoPorFlutuacao = new OrdenacaoPorFlutuacao();

    @Test
    public void ordenarListaSimplesTest() {
        int[] listaOrdenar = { 4, 1, 3, 9, 7 };
        int[] listaOrdenada = { 1, 3, 4, 7, 9 };
        ordenacaoPorFlutuacao.ordenar(listaOrdenar);

        Assert.assertArrayEquals(listaOrdenada, listaOrdenar);
    }

    @Test
    public void inverterListaTest() {
        int[] listaOrdenar = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        int[] listaOrdenada = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        ordenacaoPorFlutuacao.ordenar(listaOrdenar);

        Assert.assertArrayEquals(listaOrdenada, listaOrdenar);
    }

    @Test
    public void listaComUnicoElementoTest() {
        int[] listaOrdenar = { 1 };
        int[] listaOrdenada = { 1 };
        ordenacaoPorFlutuacao.ordenar(listaOrdenar);

        Assert.assertArrayEquals(listaOrdenada, listaOrdenar);
    }

    @Test
    public void listaVaziaTest() {
        int[] listaOrdenar = {};
        int[] listaOrdenada = {};
        ordenacaoPorFlutuacao.ordenar(listaOrdenar);

        Assert.assertArrayEquals(listaOrdenada, listaOrdenar);
    }

    @Test
    public void ordenarListaComMilElementosTest() {
        int[] listaOrdenada = Utils.gerarListaOrdenada(1, 1000);
        int[] listaOrdenar = Utils.gerarListaAleatoria(1, 1000);
        ordenacaoPorFlutuacao.ordenar(listaOrdenar);

        Assert.assertArrayEquals(listaOrdenada, listaOrdenar);
    }

}
