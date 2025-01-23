import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registro {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton ingresarButton;
    public JPanel registroUsuario;
    private JPasswordField passwordField1;

    public registro() {
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula= textField1.getText();
                String nombre= textField2.getText();
                String apellido= textField3.getText();
                String telefono= textField4.getText();
                String direccion= textField5.getText();
                String password2= textField6.getText();
                MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
                // Obtener la base de datos
                MongoDatabase database = mongoClient.getDatabase("Belleza_Spa");
                // llamando a la conexion
                MongoCollection<Document> collection = database.getCollection("Registros");

                // Crear un documento

                Document doc = new Document("cedula",cedula )
                                    .append("nombre", nombre)
                                    .append("apellido", apellido)
                                    .append("telefono", telefono)
                                    .append("direccion", direccion)
                                    .append("password2", password2);
                // Insertar el documento en la colección
                collection.insertOne(doc);
                // Cerrar la conexión
                mongoClient.close();
                System.out.println("Documento insertado en MongoDB.");


            }
        });
    }
}
