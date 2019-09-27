package com.kazale.kztoolbox.algoritmos.arvores;

import com.kazale.kztoolbox.algoritmos.utils.Utils;

public class Arvore<T> {

    private final Node<T> raiz;

    public Arvore(T valorRaiz) {
        raiz = new Node<>(valorRaiz);
    }

    public Node<T> getRaiz() {
        return raiz;
    }

    @Override
    public String toString() {
        return raiz.toString();
    }

}
