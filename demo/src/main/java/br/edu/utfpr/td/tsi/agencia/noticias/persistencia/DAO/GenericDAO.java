package br.edu.utfpr.td.tsi.agencia.noticias.persistencia.DAO;

public interface GenericDAO<T> {

    void inserir(T objeto);

    T buscar(String id);

    void atualizar(T objeto);

    void excluir(String id);
}