package com.kazale.kztoolbox.algoritmos.listas.listaduplamenteligada;

public class ListaDuplamenteLigada<T> {

    private Node<T> head;
    private Node<T> tail;
    private int tamanho;

    public ListaDuplamenteLigada() {
        head = null;
        tail = null;
        tamanho = 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void adicionar(T valor) {
        Node<T> novoNode = new Node<>(valor);
        if (head == null) {
            head = novoNode;
            tail = novoNode;
        } else {
            novoNode.setPrevious(tail);
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
                head.setPrevious(novoNode);
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
            novoNode.setPrevious(node);
            novoNode.setNext(node.getNext());
            if (node.getNext() != null) {
                node.getNext().setPrevious(novoNode);
            }
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
        Node<T> node;
        if (posicao < (tamanho / 2)) {
            node = head;
            for (int pos = 0; pos < posicao; pos++) {
                node = node.getNext();
            }
        } else {
            node = tail;
            for (int pos = (tamanho - 1); pos > posicao; pos--) {
                node = node.getPrevious();
            }
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
            tail = null;
        } else {
            Node<T> node = head;
            for (int pos = 1; pos != posicao; pos++) {
                node = node.getNext();
            }
            if (node.getNext().getNext() != null) {
                node.getNext().getNext().setPrevious(node);
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
