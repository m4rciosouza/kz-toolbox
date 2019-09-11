package com.kazale.kztoolbox.algoritmos.listas.listaduplamenteligada;

public class Node<T> {
    private final T valor;
    private Node<T> next;
    private Node<T> previous;

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

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

}
