package com.kazale.kztoolbox.algoritmos.ordenacao;

/**
 * Classe que implementa o algoritmo de ordenação por inserção (insertion sort).
 *
 * @// TODO: 10/06/2019 descrever o algoritmo insertion sort aqui...
 *
 * @author <a href="mailto:m4rcio.souza@gmail.com">Marcio Casale de Souza</a>
 * @since 0.0.1
 */
public class OrdenacaoPorInsercao {

    /**
     * Método responsável por ordenar a lista.
     *
     * @param listaOrdenar lista de inteiros a ser ordenada
     */
    public void ordenar(int[] listaOrdenar) {

        for (int i = 1; i < listaOrdenar.length; i++) {
            int temp = listaOrdenar[i];
            int j = i - 1;
            while (j >= 0 && listaOrdenar[j] > temp) {
                listaOrdenar[j + 1] = listaOrdenar[j];
                j = j - 1;
            }
            listaOrdenar[j + 1] = temp;
        }

    }

}
