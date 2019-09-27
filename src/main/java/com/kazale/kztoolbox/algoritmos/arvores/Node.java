package com.kazale.kztoolbox.algoritmos.arvores;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {

    private final T valor;
    private Node<T> pai;
    private List<Node<T>> filhos;

    public Node(T valor) {
        this.valor = valor;
        filhos = new ArrayList<>();
    }

    public Node(T valor, Node pai) {
        this.pai = pai;
        this.valor = valor;
        filhos = new ArrayList<>();
    }

    public T getValor() {
        return valor;
    }

    public Node<T> getPai() {
        return pai;
    }

    public void setPai(Node<T> pai) {
        this.pai = pai;
    }

    public List<Node<T>> getFilhos() {
        return filhos;
    }

    public void setFilhos(List<Node<T>> filhos) {
        this.filhos = filhos;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(valor.toString());
        if (!filhos.isEmpty()) {
            builder.append("[");
            filhos.forEach(f -> builder.append(f.toString()).append(","));
            builder.deleteCharAt(builder.length() - 1);
            builder.append("]");
        }
        return builder.toString();
    }

}
