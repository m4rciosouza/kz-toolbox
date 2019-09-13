package com.kazale.kztoolbox.algoritmos.listas.listaligada;

import com.kazale.kztoolbox.algoritmos.listas.Node;
import com.kazale.kztoolbox.algoritmos.utils.Utils;

public class ListaLigadaTail<T> {

    private Node<T> head;
    private Node<T> tail;
    private int tamanho;

    public ListaLigadaTail() {
        head = null;
        tail = null;
        tamanho = 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void adicionar(T valor) {
        Node<T> novoNode = new Node<>(valor);
        if (head == null) {
            head = novoNode;
            tail = novoNode;
        } else {
            tail.setNext(novoNode);
            tail = novoNode;
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
        Node<T> novoNode = new Node<>(valor);
        if (posicao == 0) {
            if (head != null) {
                novoNode.setNext(head);
                tail = head;
            } else {
                tail = novoNode;
            }
            head = novoNode;
        } else {
            Node<T> node = head;
            for (int pos = 1; pos != posicao; pos++) {
                node = node.getNext();
            }
            novoNode.setNext(node.getNext());
            node.setNext(novoNode);
        }
        if (posicao == tamanho) {
            tail = novoNode;
        }
        tamanho++;
    }

    /**
     *
     * @param posicao inicia em 0 para primeira posição
     * @return
     */
    public T obterPosicao(int posicao) {
        if (posicao < 0 || posicao > tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }
        if ((posicao + 1) == tamanho) {
            return tail.getValor();
        }
        Node<T> node = head;
        for (int pos = 0; pos < posicao; pos++) {
            node = node.getNext();
        }
        return node.getValor();
    }

    /**
     *
     * @param posicao inicia em 0 para primeira posição
     * @return
     */
    public void remover(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IllegalArgumentException("Posição inválida.");
        }
        if (posicao == 0) {
            if (head != null && head.getNext() != null) {
                head = head.getNext();
                if (tamanho <= 1) {
                    tail = head;
                }
            } else {
                head = null;
                tail = null;
            }
        } else {
            Node<T> node = head;
            for (int pos = 1; pos != posicao; pos++) {
                node = node.getNext();
            }
            node.setNext(node.getNext().getNext());
            if ((posicao + 1) == tamanho) {
                tail = node;
            }
        }
        tamanho--;
    }

    @Override
    public String toString() {
        return Utils.imprimirListaLigada(head);
    }

}
