package com.kazale.kztoolbox.algoritmos.utils;

import com.kazale.kztoolbox.algoritmos.arvores.Arvore;
import com.kazale.kztoolbox.algoritmos.listas.Node;

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

    /**
     * Retorna os valores de uma lista ligada a serem impressos.
     *
     * @param head Node com o valor inicial da lista
     * @return uma String contendo os elementos da lista ligada separados por vírgula
     */
    public static String imprimirListaLigada(Node head) {
        final StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.getValor());
            head = head.getNext();
            if (head != null) {
                builder.append(", ");
            }
        }
        return builder.toString();
    }

    /**
     * Formata e retorna uma árvore em formato visual, conforme o exemplo a seguir.
     *
     * 1
     * |--11
     * |  |--21
     * |  |--22
     * |  |--23
     * |--12
     * |--13
     * |  |--23
     * |     |--33
     * |     |--34
     * |        |--43
     *
     * @param arvore Arvore
     * @return String contendo a árvore formatada conforme exemplo acima.
     */
    public static String formatarArvore(Arvore arvore) {
        if (arvore == null) {
            return "";
        }
        final String toString = arvore.toString();
        final StringBuilder builder = new StringBuilder();
        builder.append(toString.charAt(0));
        int tab = 0;
        for (int i = 1; i < toString.length(); i++) {
            char c = toString.charAt(i);
            switch (c) {
                case '[':
                    printTabs(builder, ++tab);
                    break;
                case ']':
                    tab--;
                    break;
                case ',':
                    printTabs(builder, tab);
                    break;
                default:
                    builder.append(c);
                    break;
            }
        }
        return builder.toString();
    }

    /**
     * Método auxiliar utilizado por "formatarArvore" para adicionar os
     * espaçamentos de uma árvore.
     *
     * @param builder StringBuilder contendo informações da árvore
     * @param tab int contendo o número de espaçamentos (tabs) a serem adicionadas
     */
    private static void printTabs(StringBuilder builder, int tab) {
        builder.append("\n");
        for (int t = 0; t < tab; t++) {
            if (tab - 1 == t) {
                builder.append("|--");
            } else if (t == 0) {
                builder.append("|  ");
            } else {
                builder.append("   ");
            }
        }
    }

}
