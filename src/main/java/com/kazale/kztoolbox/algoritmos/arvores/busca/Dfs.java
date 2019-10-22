package com.kazale.kztoolbox.algoritmos.arvores.busca;

import com.kazale.kztoolbox.algoritmos.arvores.Node;
import com.kazale.kztoolbox.algoritmos.listas.listaligada.Pilha;

import java.util.List;

public class Dfs {

    private Dfs() {
    }

    /**
     * 1   pseudo-código DFS-iterativo(node, visitados):
     * 2      crie um objeto pilha
     * 3      adicione o node na pilha
     * 4      enquanto a pilha não estiver vazia
     * 5          remova elemento da pilha
     * 6          se o node não estiver na lista de visitados
     * 7              adicione o node na lista de visitados
     * 8              para cada node filho da lista faça:
     * 9                  adicione filho na pilha
     *
     * @param raiz
     * @param visitados
     */
    public static void iterativo(Node<String> raiz, List<Node<String>> visitados) {
        if (raiz == null || visitados == null) {
            return;
        }
        Pilha<Node<String>> pilha = new Pilha<>();
        pilha.adicionar(raiz);

        while (pilha.getTamanho() > 0) {
            Node<String> node = pilha.remover();
            if (!visitados.contains(node)) {
                visitados.add(node);
                for (Node<String> filho: node.getFilhos()) {
                    pilha.adicionar(filho);
                }
            }
        }
    }

    /**
     * 1  pseudo-código DFS-recursivo(node, visitados):
     * 2      adicione o node na lista de visitados
     * 3      para cada node filho da lista faça:
     * 4          se o node não estiver na lista de visitados
     * 5              chame recursivamente DFS-recursivo(node, visitados)
     *
     * @param node
     * @param visitados
     */
    public static void recursivo(Node<String> node, List<Node<String>> visitados) {
        if (node == null || visitados == null) {
            return;
        }
        visitados.add(node);
        for (Node<String> filho: node.getFilhos()) {
            if (!visitados.contains(filho)) {
                recursivo(filho, visitados);
            }
        }
    }

}
