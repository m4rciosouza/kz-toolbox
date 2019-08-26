package com.kazale.kztoolbox.algoritmos.listas.listaligada;

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
        if (head == null) {
            head = new Node<>(valor);
            tamanho++;
            return;
        }
        Node<T> node = head;
        while (node.getNext() != null) {
            node = node.getNext();
        }
        node.setNext(new Node<>(valor));
        tamanho++;
    }

    /**
     *
     * @param valor
     * @param posicao iniciando do valor 0
     */
    public void adicionar(T valor, int posicao) {
        if (posicao != 0 && tamanho < posicao) {
            throw new IllegalArgumentException("Posição inválida");
        }
        if (posicao == 0) {
            head = new Node<>(valor);
            tamanho++;
            return;
        }
        int posicaoAtual = 1;
        Node<T> node = head;
        while (posicao != posicaoAtual) {
            node = node.getNext();
            posicaoAtual++;
        }
        Node<T> novoNode = new Node<>(valor);
        novoNode.setNext(node.getNext());
        node.setNext(novoNode);
        tamanho++;
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
