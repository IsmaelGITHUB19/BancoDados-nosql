package br.edu.utfpr.td.tsi.agencia.noticias.persistencia;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
public class BancoDados {
   private String connectionString = "mongodb+srv://ismael_db_user:Azul8088@mydatabase.aatbkbn.mongodb.net/";
   private String database = "agencia_noticias";
   private MongoClient client;
   private MongoDatabase db;
   public void testaConexao(){
    try {
        this.client = MongoClients.create(connectionString);
        this.db = client.getDatabase(database);
        System.out.println("Conectado ao banco de dados" + db.getName());
        client.close();
    } catch (Exception e) {
        System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
    }
   }
}
