package com.kazale.kztoolbox.algoritmos.ordenacao;

/**
 * Classe que implementa o algoritmo de ordenação merge sort de modo recursivo.
 *
 * @// TODO: 10/06/2019 descrever o algoritmo merge sort recursivo aqui...
 *
 * @author <a href="mailto:m4rcio.souza@gmail.com">Marcio Casale de Souza</a>
 * @since 0.0.1
 */
public class MergeSortRecursivo {

    public void ordenar(int[] listaOrdenar)
    {
        if(listaOrdenar == null || listaOrdenar.length <= 1) {
            return;
        }

        int meio = listaOrdenar.length / 2;

        // gera lista com a metade da esquerda dos elementos
        int[] listaEquerda = new int[meio];
        for(int i = 0; i < meio; i++) {
            listaEquerda[i] = listaOrdenar[i];
        }

        // gera lista com a metade da direita dos elementos
        int[] listaDireita = new int[listaOrdenar.length - meio];
        for(int i = meio; i < listaOrdenar.length; i++) {
            listaDireita[i - meio] = listaOrdenar[i];
        }

        ordenar(listaEquerda);
        ordenar(listaDireita);

        int indiceListaEsquerda = 0;
        int indiceListaDireita = 0;
        int indiceListaFinal = 0;

        // Concatena as listas da esquerda e direita de modo ordenado
        while(indiceListaEsquerda < listaEquerda.length && indiceListaDireita < listaDireita.length) {
            if(listaEquerda[indiceListaEsquerda] < listaDireita[indiceListaDireita]) {
                listaOrdenar[indiceListaFinal] = listaEquerda[indiceListaEsquerda];
                indiceListaEsquerda++;
            } else {
                listaOrdenar[indiceListaFinal] = listaDireita[indiceListaDireita];
                indiceListaDireita++;
            }
            indiceListaFinal++;
        }

        // Adiciona a lista final os elementos restantes nas listas da esquerda e direita
        while(indiceListaEsquerda < listaEquerda.length) {
            listaOrdenar[indiceListaFinal] = listaEquerda[indiceListaEsquerda];
            indiceListaEsquerda++;
            indiceListaFinal++;
        }

        while(indiceListaDireita < listaDireita.length) {
            listaOrdenar[indiceListaFinal] = listaDireita[indiceListaDireita];
            indiceListaDireita++;
            indiceListaFinal++;
        }

    }

}
