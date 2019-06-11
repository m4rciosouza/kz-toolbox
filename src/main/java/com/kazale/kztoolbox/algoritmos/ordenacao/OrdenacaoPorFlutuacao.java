package com.kazale.kztoolbox.algoritmos.ordenacao;

/**
 * Classe que implementa o algoritmo de ordenação por flutuação (bubble sort) de modo eficiente.
 *
 * @// TODO: 10/06/2019 descrever o algoritmo bubble sort aqui...
 *
 * @author <a href="mailto:m4rcio.souza@gmail.com">Marcio Casale de Souza</a>
 * @since 0.0.1
 */
public class OrdenacaoPorFlutuacao {

    /**
     * Método responsável por ordenar a lista.
     *
     * @param listaOrdenar lista de inteiros a ser ordenada
     */
    public void ordenar(int[] listaOrdenar) {
        boolean houveTroca;
        for (int i = 0; i < (listaOrdenar.length - 1); i++) {
            houveTroca = false;
            for (int j = 0; j < (listaOrdenar.length - i - 1); j++) {
                if (listaOrdenar[j] > listaOrdenar[j + 1]) {
                    int temp = listaOrdenar[j];
                    listaOrdenar[j] = listaOrdenar[j + 1];
                    listaOrdenar[j + 1] = temp;
                    houveTroca = true;
                }
            }
            if (!houveTroca) {
                break;
            }
        }
    }

}
