package com.kazale.kztoolbox.algoritmos.ordenacao;

import com.kazale.kztoolbox.algoritmos.utils.Utils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Testes da classe OrdenacaoPorFlutuacaoIneficiente, classe que implementa o algoritmo de
 * ordenação por flutuação (bubble sort) de modo ineficiente.
 *
 * @author <a href="mailto:m4rcio.souza@gmail.com">Marcio Casale de Souza</a>
 * @since 0.0.1
 */
public class OrdenacaoPorFlutuacaoIneficienteTest {

    OrdenacaoPorFlutuacaoIneficiente ordenacaoPorFlutuacaoIneficiente = new OrdenacaoPorFlutuacaoIneficiente();

    @Test
    public void ordenarListaSimplesTest() {
        int[] listaOrdenar = { 4, 1, 3, 9, 7 };
        int[] listaOrdenada = { 1, 3, 4, 7, 9 };
        ordenacaoPorFlutuacaoIneficiente.ordenar(listaOrdenar);

        Assert.assertArrayEquals(listaOrdenada, listaOrdenar);
    }

    @Test
    public void inverterListaTest() {
        int[] listaOrdenar = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        int[] listaOrdenada = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        ordenacaoPorFlutuacaoIneficiente.ordenar(listaOrdenar);

        Assert.assertArrayEquals(listaOrdenada, listaOrdenar);
    }

    @Test
    public void listaComUnicoElementoTest() {
        int[] listaOrdenar = { 1 };
        int[] listaOrdenada = { 1 };
        ordenacaoPorFlutuacaoIneficiente.ordenar(listaOrdenar);

        Assert.assertArrayEquals(listaOrdenada, listaOrdenar);
    }

    @Test
    public void listaVaziaTest() {
        int[] listaOrdenar = {};
        int[] listaOrdenada = {};
        ordenacaoPorFlutuacaoIneficiente.ordenar(listaOrdenar);

        Assert.assertArrayEquals(listaOrdenada, listaOrdenar);
    }

    @Test
    public void ordenarListaComMilElementosTest() {
        int[] listaOrdenada = Utils.gerarListaOrdenada(1,1000);
        int[] listaOrdenar = Utils.gerarListaAleatoria(1, 1000);
        ordenacaoPorFlutuacaoIneficiente.ordenar(listaOrdenar);

        Assert.assertArrayEquals(listaOrdenada, listaOrdenar);
    }

}
