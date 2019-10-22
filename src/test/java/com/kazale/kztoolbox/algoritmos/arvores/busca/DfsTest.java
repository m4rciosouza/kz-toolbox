package com.kazale.kztoolbox.algoritmos.arvores.busca;

import com.kazale.kztoolbox.algoritmos.arvores.Arvore;
import com.kazale.kztoolbox.algoritmos.arvores.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class DfsTest {

    @Test
    public void testDfsModoIterativo() {
        Arvore<String> arvore = obterArvoreExemplo();
        List<Node<String>> visitados = new ArrayList<>();

        Dfs.iterativo(arvore.getRaiz(), visitados);

        String caminhoPercorrido = visitados.stream()
                .map(Node::getValor)
                .collect(Collectors.joining());

        assertEquals("ADKJICHBGF", caminhoPercorrido);
    }

    @Test
    public void testDfsModoRecursivo() {
        Arvore<String> arvore = obterArvoreExemplo();
        List<Node<String>> visitados = new ArrayList<>();

        Dfs.recursivo(arvore.getRaiz(), visitados);

        String caminhoPercorrido = visitados.stream()
                .map(Node::getValor)
                .collect(Collectors.joining());

        assertEquals("ABFGCHDIJK", caminhoPercorrido);
    }

    /**
     * Estrutura da árvore
     *
     * A
     * |--B
     * |  |--F
     * |  |--G
     * |--C
     * |  |--H
     * |--D
     * |  |--I
     * |  |--J
     * |  |--K
     */
    private Arvore<String> obterArvoreExemplo() {
        Arvore<String> arvore = new Arvore<>("A");

        Node<String> node1 = new Node<>("B", arvore.getRaiz());
        arvore.getRaiz().getFilhos().add(node1);
        Node<String> node2 = new Node<>("C", arvore.getRaiz());
        arvore.getRaiz().getFilhos().add(node2);
        Node<String> node3 = new Node<>("D", arvore.getRaiz());
        arvore.getRaiz().getFilhos().add(node3);

        node1.getFilhos().add(new Node<>("F", node1));
        node1.getFilhos().add(new Node<>("G", node1));

        node2.getFilhos().add(new Node<>("H", node2));

        node3.getFilhos().add(new Node<>("I", node3));
        node3.getFilhos().add(new Node<>("J", node3));
        node3.getFilhos().add(new Node<>("K", node3));

        return arvore;
    }

}
