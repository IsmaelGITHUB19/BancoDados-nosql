package br.edu.utfpr.td.tsi.agencia.noticias;

import java.time.LocalDate;

public class Noticia {
    private String nomeJornalista;
    private String emailJornalista;
    private LocalDate data;
    private String titulo;

    public String getNomeJornalista() {
        return nomeJornalista;
    }
    public void setNomeJornalista(String nomeJornalista) {
        this.nomeJornalista = nomeJornalista;
    }
    public String getEmailJornalista() {
        return emailJornalista;
    }
    public void setEmailJornalista(String emailJornalista) {
        this.emailJornalista = emailJornalista;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
