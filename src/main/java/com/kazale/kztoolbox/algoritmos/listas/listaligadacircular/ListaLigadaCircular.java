package com.kazale.kztoolbox.algoritmos.listas.listaligadacircular;

import com.kazale.kztoolbox.algoritmos.listas.Node;

public class ListaLigadaCircular<T> {

    private Node<T> head;
    private Node<T> tail;
    private int tamanho;

    public ListaLigadaCircular() {
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
        //TODO
    }

    /**
     *
     * @param valor
     * @param posicao iniciando do valor 0
     */
    public void adicionar(T valor, int posicao) {
        //TODO
    }

    /**
     *
     * @param posicao inicia em 0 para primeira posição
     * @return
     */
    public T obterPosicao(int posicao) {
        //TODO
        return null;
    }

    /**
     *
     * @param posicao inicia em 0 para primeira posição
     * @return
     */
    public void remover(int posicao) {
        //TODO
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
