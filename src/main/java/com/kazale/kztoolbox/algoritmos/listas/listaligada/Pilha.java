package com.kazale.kztoolbox.algoritmos.listas.listaligada;

public class Pilha<T> {

    private ListaLigadaTail<T> lista;

    public Pilha() {
        lista = new ListaLigadaTail<>();
    }

    public int getTamanho() {
        return lista.getTamanho();
    }

    public void adicionar(T valor) {
        lista.adicionar(valor);
    }

    public T remover() {
        T valor = lista.obterPosicao(getTamanho() - 1);
        lista.remover(getTamanho() - 1);
        return valor;
    }

    @Override
    public String toString() {
        return lista.toString();
    }

}
