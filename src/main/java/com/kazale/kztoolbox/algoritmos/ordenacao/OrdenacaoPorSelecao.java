package com.kazale.kztoolbox.algoritmos.ordenacao;

/**
 * Classe que implementa o algoritmo de ordenação por seleção (selection sort).
 *
 * @// TODO: 10/06/2019 descrever o algoritmo selection sort aqui...
 *
 * @author <a href="mailto:m4rcio.souza@gmail.com">Marcio Casale de Souza</a>
 * @since 0.0.1
 */
public class OrdenacaoPorSelecao {

    /**
     * Método responsável por ordenar a lista.
     *
     * @param listaOrdenar lista de inteiros a ser ordenada
     */
    public void ordenar(int[] listaOrdenar) {

        int indiceMenorValor;

        for (int i = 0; i < listaOrdenar.length - 1; i++) {
            indiceMenorValor = i;

            for (int j = i + 1; j < listaOrdenar.length; j++) {
                if (listaOrdenar[j] < listaOrdenar[indiceMenorValor]) {
                    indiceMenorValor = j;
                }
            }

            int temp = listaOrdenar[i];
            listaOrdenar[i] = listaOrdenar[indiceMenorValor];
            listaOrdenar[indiceMenorValor] = temp;
        }

    }

}
