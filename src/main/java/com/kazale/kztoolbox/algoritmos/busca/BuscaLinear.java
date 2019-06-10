package com.kazale.kztoolbox.algoritmos.busca;

/**
 * Implementação do algoritmo de busca linear.
 * A busca linear possui performance de ordem O(n).
 *
 * @author <a href="mailto:m4rcio.souza@gmail.com">Marcio C. de Souza</a>
 * @since 0.0.1
 */
public class BuscaLinear {

    /**
     * Método responsável por realizar uma busca de um número
     * utilizando a busca linear.
     *
     * @param numeros lista contendo os números utilizados para a busca.
     * @param numero número a ser encontrado na lista.
     *
     * @return int índice do número na lista, ou -1 caso não encontrado.
     */
    public int buscar(int[] numeros, int numero) {
        if (numeros == null) {
            return -1;
        }
        for (int i=0; i < numeros.length; i++) {
            if (numeros[i] == numero) {
                return i;
            }
        }
        return -1;
    }

}
