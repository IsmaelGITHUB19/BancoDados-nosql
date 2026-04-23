package br.edu.utfpr.td.tsi.agencia.noticias;

public class Autor {
    private String id;
    private String nome;
    private String email;
    private String dataNascimento;

    public Autor() {
    }

    public String getEmail() {
        return email;
    }

    public String getAutor() {
        return nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }
    

}