package com.kazale.kztoolbox.algoritmos.listas.listaligada;

public class Fila<T> {

    private ListaLigada<T> lista;

    public Fila() {
        lista = new ListaLigada<>();
    }

    public int getTamanho() {
        return lista.getTamanho();
    }

    public void adicionar(T valor) {
        lista.adicionar(valor);
    }

    public T remover() {
        T valor = lista.obterPosicao(0);
        lista.remover(0);
        return valor;
    }

    @Override
    public String toString() {
        return lista.toString();
    }

}
