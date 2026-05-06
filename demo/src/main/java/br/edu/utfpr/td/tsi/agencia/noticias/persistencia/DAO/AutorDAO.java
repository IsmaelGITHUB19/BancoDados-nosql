package br.edu.utfpr.td.tsi.agencia.noticias.persistencia.DAO;

import br.edu.utfpr.td.tsi.agencia.noticias.model.Autor;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import javax.print.Doc;

import org.bson.Document;

public class AutorDAO implements GenericDAO<Autor> {

    @Override
    public void inserir(Autor objeto) {
        String connectionString = "mongodb+srv://ismael_db_user:*****@mydatabase.aatbkbn.mongodb.net/";
        String database = "agencia_noticias";
        MongoClient client;
        MongoDatabase db;
        MongoCollection<Document> col;
        try {
            client = MongoClients.create(connectionString);
            db = client.getDatabase(database);
            col = db.getCollection("autores");
            Document doc = new Document("nome", objeto.getNome())
                    .append("email", objeto.getEmail())
                    .append("dataNascimento", objeto.getDataNascimento());
            col.insertOne(doc);
            System.out.println("Autor inserido: " + objeto.getNome() + " - " + objeto.getEmail() + " - "
                    + objeto.getDataNascimento());
            client.close();
        } catch (Exception e) {
            System.out.println("Erro ao inserir o autor: " + e.getMessage());
        }
    }

    @Override
    public Autor buscar(String nome) {
        String connectionString = "mongodb+srv://ismael_db_user:*****@mydatabase.aatbkbn.mongodb.net/";
        String database = "agencia_noticias";

        try {
            MongoClient client = MongoClients.create(connectionString);
            MongoDatabase db = client.getDatabase(database);
            MongoCollection<Document> col = db.getCollection("autores");
            Document doc = col.find(new Document("nome", nome)).first();

            if (doc == null) {
                client.close();
                return null;
            }

            Autor autor = new Autor();
            autor.setNome(doc.getString("nome"));
            autor.setEmail(doc.getString("email"));
            autor.setDataNascimento(doc.getString("dataNascimento"));

            client.close();

            return autor;

        } catch (Exception e) {
            System.out.println("Erro ao buscar o autor: " + e.getMessage());
        }

        return null;
    }

    @Override
    public void atualizar(Autor objeto) {
        String connectionString = "mongodb+srv://ismael_db_user:*****@mydatabase.aatbkbn.mongodb.net/";
        String database = "agencia_noticias";
        MongoClient client;
        MongoDatabase db;
        MongoCollection<Document> col;
        try {
            client = MongoClients.create(connectionString);
            db = client.getDatabase(database);
            col = db.getCollection("autores");
            Document doc = new Document("nome", objeto.getNome())
                    .append("email", objeto.getEmail())
                    .append("dataNascimento", objeto.getDataNascimento());
            col.replaceOne(new Document("nome", objeto.getNome()), doc);
            System.out.println("Autor atualizado: " + objeto.getNome() + " - " + objeto.getEmail() + " - "
                    + objeto.getDataNascimento());
            client.close();
        } catch (Exception e) {
            System.out.println("Erro ao atualizar o autor: " + e.getMessage());
        }
    }

    @Override
    public void excluir(String id) {
        String connectionString = "mongodb+srv://ismael_db_user:*****@mydatabase.aatbkbn.mongodb.net/";
        String database = "agencia_noticias";
        MongoClient client;
        MongoDatabase db;
        MongoCollection<Document> col;
        try {
            client = MongoClients.create(connectionString);
            db = client.getDatabase(database);
            col = db.getCollection("autores");
            col.deleteOne(new Document("_id", id));
            System.out.println("Autor excluído: " + id);
            client.close();
        } catch (Exception e) {
            System.out.println("Erro ao excluir o autor: " + e.getMessage());
        }
    }

}
