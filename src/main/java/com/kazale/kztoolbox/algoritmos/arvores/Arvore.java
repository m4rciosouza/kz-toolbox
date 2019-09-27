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

    public static void main(String[] args) {
        Arvore<Integer> arvore = new Arvore<>(1);
        arvore.getRaiz().getFilhos().add(new Node<Integer>(11));
        arvore.getRaiz().getFilhos().add(new Node<Integer>(12));
        arvore.getRaiz().getFilhos().add(new Node<Integer>(13));

        arvore.getRaiz().getFilhos().get(0).getFilhos().add(new Node<Integer>(21));
        arvore.getRaiz().getFilhos().get(0).getFilhos().add(new Node<Integer>(22));
        arvore.getRaiz().getFilhos().get(0).getFilhos().add(new Node<Integer>(23));

        arvore.getRaiz().getFilhos().get(2).getFilhos().add(new Node<Integer>(23));
        arvore.getRaiz().getFilhos().get(2).getFilhos().get(0).getFilhos().add(new Node<Integer>(33));
        arvore.getRaiz().getFilhos().get(2).getFilhos().get(0).getFilhos().add(new Node<Integer>(34));
        arvore.getRaiz().getFilhos().get(2).getFilhos().get(0).getFilhos().get(1).getFilhos().add(new Node<Integer>(43));

        System.out.println(arvore);
        System.out.println(Utils.formatarArvore(arvore));
    }

}
