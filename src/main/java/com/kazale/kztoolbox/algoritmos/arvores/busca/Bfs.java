package com.kazale.kztoolbox.algoritmos.arvores.busca;

import com.kazale.kztoolbox.algoritmos.arvores.Node;
import com.kazale.kztoolbox.algoritmos.listas.listaligada.Fila;

import java.util.List;

public class Bfs {

    private Bfs() {
    }

    /**
     * 1   pseudo-código BFS-iterativo(node, visitados):
     * 2      crie um objeto fila
     * 3      adicione o node na fila
     * 4      enquanto a fila não estiver vazia
     * 5          remova elemento da fila
     * 6          se o node não estiver na lista de visitados
     * 7              adicione o node na lista de visitados
     * 8              para cada node filho da lista faça:
     * 9                  adicione filho na fila
     *
     * @param raiz
     * @param visitados
     */
    public static void iterativo(Node<String> raiz, List<Node<String>> visitados) {
        if (raiz == null || visitados == null) {
            return;
        }
        Fila<Node<String>> fila = new Fila<>();
        fila.adicionar(raiz);

        while (fila.getTamanho() > 0) {
            Node<String> node = fila.remover();
            if (!visitados.contains(node)) {
                visitados.add(node);
                for (Node<String> filho: node.getFilhos()) {
                    fila.adicionar(filho);
                }
            }
        }
    }

}
