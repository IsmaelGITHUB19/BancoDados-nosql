package br.edu.utfpr.td.tsi.agencia.noticias;

import br.edu.utfpr.td.tsi.agencia.noticias.model.Autor;
import br.edu.utfpr.td.tsi.agencia.noticias.persistencia.BancoDados;
import br.edu.utfpr.td.tsi.agencia.noticias.persistencia.DAO.AutorDAO;

public class Main {
    public static void main(String[] args) {

        Autor autor = new Autor();
        autor.setNome("Isma");
        autor.setEmail("isma@gmail.com");
        autor.setDataNascimento("20/04/1980");

        AutorDAO autorDAO = new AutorDAO();
        autorDAO.inserir(autor);

        Autor autorBuscado = autorDAO.buscar("Isma");
        System.out.println(autorBuscado.getNome());

    }
}