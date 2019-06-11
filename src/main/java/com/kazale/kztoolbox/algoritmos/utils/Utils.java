package com.kazale.kztoolbox.algoritmos.utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Classe utilitária para auxiliar em tarefas repetitivas mos testes unitários.
 *
 * @author <a href="mailto:m4rcio.souza@gmail.com">Marcio Casale de Souza</a>
 * @since 0.0.1
 */
public class Utils {

    /**
     * Gera uma lista de números inteiros dado um determinado intervalo.
     *
     * Caso o intervalo seja inválido uma lista vazia será retornada.
     *
     * Caso os intervalos de início e fim sejam iguais, uma lista com um único elemento será retornada.
     *
     * @param inicioInclusive valor inicial da lista (inclusive)
     * @param fimInclusive valor final da lista (inclusive)
     * @return uma lista contendo os valores do intervalo fornecido
     */
    public static int[] gerarListaOrdenada(int inicioInclusive, int fimInclusive) {
        return IntStream
                .rangeClosed(inicioInclusive, fimInclusive)
                .toArray();
    }

    /**
     * Gera uma lista de números inteiros aleatórios dado um determinado intervalo.
     *
     * Caso o intervalo seja inválido uma lista vazia será retornada.
     *
     * Caso os intervalos de início e fim sejam iguais, uma lista com um único elemento será retornada.
     *
     * @param inicioInclusive valor inicial do intervalo (inclusive)
     * @param fimInclusive valor final do intervalo (inclusive)
     * @return uma lista contendo os valores do intervalo fornecido, mas de modo aleatório
     */
    public static int[] gerarListaAleatoria(int inicioInclusive, int fimInclusive) {
        List<Integer> listaAleatoria = IntStream
                .rangeClosed(inicioInclusive, fimInclusive)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(listaAleatoria);

        return listaAleatoria
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
