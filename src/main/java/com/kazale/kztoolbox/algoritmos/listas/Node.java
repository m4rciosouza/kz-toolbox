package com.kazale.kztoolbox.algoritmos.listas;

public class Node<T> {
    private final T valor;
    private Node next;

    public Node(T valor) {
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> node) {
        next = node;
    }

}
