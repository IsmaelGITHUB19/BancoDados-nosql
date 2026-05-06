package br.edu.utfpr.td.tsi.agencia.noticias.persistencia.DAO;

import br.edu.utfpr.td.tsi.agencia.noticias.model.Noticia;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import javax.print.Doc;

import org.bson.Document;

public class NoticiaDAO implements GenericDAO<Noticia> {

    @Override
    public void inserir(Noticia objeto) {
        String connectionString = "mongodb+srv://ismael_db_user:***@mydatabase.aatbkbn.mongodb.net/";
        String database = "agencia_noticias";
        MongoClient client;
        MongoDatabase db;
        MongoCollection<Document> col;
        try {
            client = MongoClients.create(connectionString);
            db = client.getDatabase(database);
            col = db.getCollection("noticias");
            Document doc = new Document("assunto", objeto.getAssunto())
                    .append("titulo", objeto.getTitulo())
                    .append("conteudo", objeto.getConteudo())
                    .append("autor", objeto.getAutor().getId());
            col.insertOne(doc);
            System.out.println("Notícia inserida: " + objeto.getTitulo());
            client.close();
        } catch (Exception e) {
            System.out.println("Erro ao inserir a notícia: " + e.getMessage());
        }
    }

    @Override
    public Noticia buscar(String id) {
        String connectionString = "mongodb+srv://ismael_db_user:***@mydatabase.aatbkbn.mongodb.net/";
        String database = "agencia_noticias";

        try {
            MongoClient client = MongoClients.create(connectionString);
            MongoDatabase db = client.getDatabase(database);
            MongoCollection<Document> col = db.getCollection("noticias");
            Document doc = col.find(new Document("_id", id)).first();

            if (doc == null) {
                client.close();
                return null;
            }

            Noticia noticia = new Noticia();
            noticia.setAssunto(doc.getString("assunto"));
            noticia.setTitulo(doc.getString("titulo"));
            noticia.setConteudo(doc.getString("conteudo"));
            noticia.setAutor(new AutorDAO().buscar(doc.getString("autor")));

            client.close();

            return noticia;

        } catch (Exception e) {
            System.out.println("Erro ao buscar a notícia: " + e.getMessage());
        }

        return null;
    }

    @Override
    public void atualizar(Noticia objeto) {
        String connectionString = "mongodb+srv://ismael_db_user:***@mydatabase.aatbkbn.mongodb.net/";
        String database = "agencia_noticias";
        MongoClient client;
        MongoDatabase db;
        MongoCollection<Document> col;
        try {
            client = MongoClients.create(connectionString);
            db = client.getDatabase(database);
            col = db.getCollection("noticias");
            Document doc = new Document("assunto", objeto.getAssunto())
                    .append("titulo", objeto.getTitulo())
                    .append("conteudo", objeto.getConteudo())
                    .append("autor", objeto.getAutor().getId());
            col.replaceOne(new Document("_id", objeto.getId()), doc);
            System.out.println("Notícia atualizada: " + objeto.getTitulo());
            client.close();
        } catch (Exception e) {
            System.out.println("Erro ao atualizar a notícia: " + e.getMessage());
        }
    }

    @Override
    public void excluir(String id) {
        String connectionString = "mongodb+srv://ismael_db_user:***@mydatabase.aatbkbn.mongodb.net/";
        String database = "agencia_noticias";
        MongoClient client;
        MongoDatabase db;
        MongoCollection<Document> col;
        try {
            client = MongoClients.create(connectionString);
            db = client.getDatabase(database);
            col = db.getCollection("noticias");
            col.deleteOne(new Document("_id", id));
            System.out.println("Notícia excluída: " + id);
            client.close();
        } catch (Exception e) {
            System.out.println("Erro ao excluir a notícia: " + e.getMessage());
        }   
    }

}
