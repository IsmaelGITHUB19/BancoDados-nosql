package br.edu.utfpr.td.tsi.agencia.noticias;

import br.edu.utfpr.td.tsi.agencia.noticias.persistencia.BancoDados;

public class Main {
    public static void main(String[] args) {

        BancoDados banco = new BancoDados();
        banco.testaConexao();

    }
}