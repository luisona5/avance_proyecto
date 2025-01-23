import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class principal {
    public JPanel ven_Princ;
    private JButton guardarButton;
    private JTextField textField1;
    private JPasswordField passwordField1;

    public principal() {
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
                // Obtener la base de datos
                MongoDatabase database = mongoClient.getDatabase("Belleza_Spa");
                // llamando a la conexion
                MongoCollection<Document> collection = database.getCollection("usuarios");
                // Crear un documento

                Document doc = new Document("name", textField1.getText()) .append("age", 30) ;
                // Insertar el documento en la colección
                collection.insertOne(doc);
                // Cerrar la conexión
                mongoClient.close();
                System.out.println("Documento insertado en MongoDB.");









            }
        });

    }
}
