package br.edu.utfpr.td.tsi.agencia.noticias.model;

public class Noticia {
    private String id;
    private String assunto;
    private String conteudo;
    private String titulo;
    private Autor autor;

public Noticia() {
    // Construtor vazio necessário para o Spring criar a instância
}

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    } 
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getConteudo() {
        return conteudo;
    }
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    
}
