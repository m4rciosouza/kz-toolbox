package com.kazale.kztoolbox.algoritmos.listas.listaligada;

import com.kazale.kztoolbox.algoritmos.listas.Node;

public class ListaLigada<T> {

    private Node<T> head;
    private int tamanho;

    public ListaLigada() {
        head = null;
        tamanho = 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public Node getHead() {
        return head;
    }

    public void adicionar(T valor) {
        Node<T> novoNode = new Node<>(valor);
        if (head == null) {
            head = novoNode;
        } else {
            Node<T> node = head;
            while (node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(novoNode);
        }
        tamanho++;
    }

    /**
     *
     * @param valor
     * @param posicao iniciando do valor 0
     */
    public void adicionar(T valor, int posicao) {
        if (posicao < 0 || posicao > tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }
        if (posicao == 0) {
            head = new Node<>(valor);
        } else {
            int posicaoAtual = 1;
            Node<T> node = head;
            while (posicao != posicaoAtual) {
                node = node.getNext();
                posicaoAtual++;
            }
            Node<T> novoNode = new Node<>(valor);
            novoNode.setNext(node.getNext());
            node.setNext(novoNode);
        }
        tamanho++;
    }

    /**
     *
     * @param posicao inicia em 0 para primeira posição
     * @return
     */
    public T obterPosicao(int posicao) {
        if (posicao >= tamanho) {
            throw new IllegalArgumentException("Posição inválida.");
        }
        int posicaoLista = 0;
        Node<T> node = head;
        while (posicaoLista < posicao) {
            node = node.getNext();
            posicaoLista++;
        }
        return node.getValor();
    }

    /**
     *
     * @param posicao inicia em 0 para primeira posição
     * @return
     */
    public void remover(int posicao) {
        if (posicao >= tamanho) {
            throw new IllegalArgumentException("Posição inválida.");
        }
        if (posicao == 0) {
            head = null;
        } else {
            int posicaoLista = 1;
            Node<T> node = head;
            while (posicao != posicaoLista) {
                node = node.getNext();
                posicaoLista++;
            }
            node.setNext(node.getNext().getNext());
        }
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        Node node = head;
        while (node != null) {
            builder.append(node.getValor());
            node = node.getNext();
            if (node != null) {
                builder.append(", ");
            }
        }
        return builder.toString();
    }

}
