package com.kazale.kztoolbox.algoritmos.ordenacao;

import com.kazale.kztoolbox.algoritmos.utils.Utils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Testes da classe OrdenacaoPorInsercao, classe que implementa o algoritmo de
 * ordenação por inserção (insertion sort).
 *
 * @author <a href="mailto:m4rcio.souza@gmail.com">Marcio Casale de Souza</a>
 * @since 0.0.1
 */
public class OrdenacaoPorInsercaoTest {

    private OrdenacaoPorInsercao ordenacaoPorInsercao = new OrdenacaoPorInsercao();

    @Test
    public void testOrdenarListaSimples() {
        int[] listaOrdenar = { 4, 1, 3, 9, 7 };
        int[] listaOrdenada = { 1, 3, 4, 7, 9 };
        ordenacaoPorInsercao.ordenar(listaOrdenar);

        Assert.assertArrayEquals(listaOrdenada, listaOrdenar);
    }

    @Test
    public void testInverterLista() {
        int[] listaOrdenar = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        int[] listaOrdenada = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        ordenacaoPorInsercao.ordenar(listaOrdenar);

        Assert.assertArrayEquals(listaOrdenada, listaOrdenar);
    }

    @Test
    public void testListaComUnicoElemento() {
        int[] listaOrdenar = { 1 };
        int[] listaOrdenada = { 1 };
        ordenacaoPorInsercao.ordenar(listaOrdenar);

        Assert.assertArrayEquals(listaOrdenada, listaOrdenar);
    }

    @Test
    public void testListaVazia() {
        int[] listaOrdenar = {};
        int[] listaOrdenada = {};
        ordenacaoPorInsercao.ordenar(listaOrdenar);

        Assert.assertArrayEquals(listaOrdenada, listaOrdenar);
    }

    @Test
    public void testOrdenarListaComMilElementos() {
        int[] listaOrdenada = Utils.gerarListaOrdenada(1,1000);
        int[] listaOrdenar = Utils.gerarListaAleatoria(1, 1000);
        ordenacaoPorInsercao.ordenar(listaOrdenar);

        Assert.assertArrayEquals(listaOrdenada, listaOrdenar);
    }

}
