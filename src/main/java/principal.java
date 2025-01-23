import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class principal {
    public JPanel ven_Princ;
    private JButton iniciarButton;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton registrarButton;
    private JComboBox comboBox1;

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
                String tipo = comboBox1.getSelectedItem().toString();

                Document doc = new Document("name", nombre)
                                    .append("password", password)
                                    .append("tipo",tipo);

                try {
                    // para buscar con un nombre en especifico
                    Bson query = Filters.and(Filters.eq("name", nombre),
                                                    Filters.eq("password",password),
                                                    Filters.eq("tipo",tipo));

                    // devolviendo el resultado
                    FindIterable<Document> results = collection.find(query);
                    Document encontrar = results.first();

                    // Si se encuentra un resultado, el usuario ya existe
                    if (encontrar != null) {
                        JOptionPane.showMessageDialog(ven_Princ, "Usuario ya existe");
                    } else {
                        // Si no se encuentra ningún resultado, el usuario no existe, redireccionar al formulario de registro
                        JOptionPane.showMessageDialog(ven_Princ, "Usuario no existe");
                    }
                } catch (Exception ex) {
                    // Manejar la excepción de forma adecuada
                    JOptionPane.showMessageDialog(null, "Error al verificar el usuario: " + ex.getMessage());
                }



                // Insertar el documento en la colección
                collection.insertOne(doc);
                // Cerrar la conexión
                mongoClient.close();
                System.out.println("Documento insertado en MongoDB.");
            }























        });

    }
}
