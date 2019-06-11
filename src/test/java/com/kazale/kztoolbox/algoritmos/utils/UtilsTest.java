package com.kazale.kztoolbox.algoritmos.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testes da classe Utils, classe utilitária para auxiliar em tarefas repetitivas mos testes unitários.
 *
 * @author <a href="mailto:m4rcio.souza@gmail.com">Marcio Casale de Souza</a>
 * @since 0.0.1
 */
public class UtilsTest {

    @Test
    public void gerarListaOrdenadaTest() {
        int[] listaOrdenada = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] listaOrdenadaGerada = Utils.gerarListaOrdenada(1, 10);

        assertArrayEquals(listaOrdenada, listaOrdenadaGerada);
    }

    @Test
    public void gerarListaOrdenadaIniciando10Test() {
        int[] listaOrdenada = { 10, 11, 12, 13, 14, 15 };
        int[] listaOrdenadaGerada = Utils.gerarListaOrdenada(10, 15);

        assertArrayEquals(listaOrdenada, listaOrdenadaGerada);
    }

    @Test
    public void gerarListaOrdenadaUnicoNumeroTest() {
        int[] listaOrdenada = { 0 };
        int[] listaOrdenadaGerada = Utils.gerarListaOrdenada(0, 0);

        assertArrayEquals(listaOrdenada, listaOrdenadaGerada);
    }

    @Test
    public void gerarListaOrdenadaFimMenorInicioTest() {
        int[] listaOrdenada = {};
        int[] listaOrdenadaGerada = Utils.gerarListaOrdenada(10, 5);

        assertArrayEquals(listaOrdenada, listaOrdenadaGerada);
    }

    @Test
    public void gerarListaAleatoriaTest() {
        int[] listaOrdenada = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] listaAleatoriaGerada = Utils.gerarListaAleatoria(1, 10);
        boolean existeValorDiferente = false;
        for (int i = 0; i < 10; i++) {
            if (listaOrdenada[i] != listaAleatoriaGerada[i]) {
                existeValorDiferente = true;
                break;
            }
        }

        assertTrue(existeValorDiferente);
    }

    @Test
    public void gerarListaAleatoriaIniciando10Test() {
        int[] listaOrdenada = { 10, 11, 12, 13, 14, 15 };
        int[] listaAleatoriaGerada = Utils.gerarListaAleatoria(10, 15);

        boolean existeValorDiferente = false;
        for (int i = 0; i < 10; i++) {
            if (listaOrdenada[i] != listaAleatoriaGerada[i]) {
                existeValorDiferente = true;
                break;
            }
        }

        assertTrue(existeValorDiferente);
    }

    @Test
    public void gerarListaAleatoriaUnicoNumeroTest() {
        int[] listaAleatoria = { 0 };
        int[] listaAleatoriaGerada = Utils.gerarListaAleatoria(0, 0);

        assertArrayEquals(listaAleatoria, listaAleatoriaGerada);
    }

    @Test
    public void gerarListaAleatoriaFimMenorInicioTest() {
        int[] listaAleatoria = {};
        int[] listaAleatoriaGerada = Utils.gerarListaAleatoria(10, 5);

        assertArrayEquals(listaAleatoria, listaAleatoriaGerada);
    }

}
