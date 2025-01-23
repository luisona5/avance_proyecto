import com.mongodb.client.*;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class principal {
    public JPanel ven_Princ;
    private JButton iniciarButton;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton registrarButton;

    public principal() {
        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
                // Obtener la base de datos
                MongoDatabase database = mongoClient.getDatabase("Belleza_Spa");
                // llamando a la conexion
                MongoCollection<Document> collection = database.getCollection("usuarios");
                // Crear un documento

                String nombre = textField1.getText();
                String password = String.valueOf(passwordField1.getPassword());

                Document doc = new Document("name", nombre) .append("password", password);

                try {
                    // Buscar al usuario en la base de datos
                    long count = collection.countDocuments(doc);

                    // Si el conteo es mayor a 0, el usuario ya existe
                    if (count > 0) {
                        JOptionPane.showMessageDialog(ven_Princ, "Usuario ya existe");
                    } else {
                        JOptionPane.showMessageDialog(ven_Princ, "no existen registros");

                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }



                // Insertar el documento en la colección
                //collection.insertOne(doc);
                // Cerrar la conexión
                mongoClient.close();
                System.out.println("Documento insertado en MongoDB.");
            }























        });

    }
}
