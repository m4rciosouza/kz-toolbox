package com.kazale.kztoolbox.algoritmos.ordenacao;

/**
 * Classe que implementa o algoritmo de ordenação quick sort utilizando o
 * pivot como sendo o último elemento da lista.
 *
 * @see https://www.geeksforgeeks.org/quick-sort/
 *
 * @// TODO: 10/06/2019 descrever o algoritmo quick sort aqui...
 *
 * @author <a href="mailto:m4rcio.souza@gmail.com">Marcio Casale de Souza</a>
 * @since 0.0.1
 */
public class QuickSort {

    /* The main function that implements QuickSort()
     arr[] --> Array to be sorted,
     low  --> Starting index,
     high  --> Ending index */
    public void ordenar(int listaOrdenar[], int inicio, int fim) {
        if (inicio < fim) {
            /* pi is partitioning index, arr[pi] is now at right place */
            int partitionIndex = partition(listaOrdenar, inicio, fim);

            // Recursively sort elements before partition and after partition
            ordenar(listaOrdenar, inicio, partitionIndex - 1);
            ordenar(listaOrdenar, partitionIndex + 1, fim);
        }
    }

    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    private int partition(int listaOrdenar[], int inicio, int fim) {
        int pivot = listaOrdenar[fim];
        int i = (inicio - 1); // index of smaller element
        for (int j = inicio; j < fim; j++) {
            // If current element is smaller than or equal to pivot
            if (listaOrdenar[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                if (i == j) {
                    continue;
                }
                int temp = listaOrdenar[i];
                listaOrdenar[i] = listaOrdenar[j];
                listaOrdenar[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = listaOrdenar[i + 1];
        listaOrdenar[i + 1] = listaOrdenar[fim];
        listaOrdenar[fim] = temp;

        return i + 1;
    }

}
