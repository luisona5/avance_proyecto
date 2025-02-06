
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        UsuarioDAO dao = new UsuarioDAO();

        // Insertar usuario
        dao.insertarUsuario("Ana Gómez", "ana@gmail.com", 30);

        // Leer usuarios
        dao.leerUsuarios();

        // Actualizar usuario (reemplaza el ID con un valor real de tu colección)
        // Usa el ID generado automáticamente en MongoDB
        dao.actualizarUsuario("id_generado", "Ana Actualizada", "ana_actualizada@gmail.com", 31);

        // Leer usuarios nuevamente
        dao.leerUsuarios();

        // Eliminar usuario (reemplaza el ID con un valor real de tu colección)
        dao.eliminarUsuario("id_generado");

        // Leer usuarios nuevamente
        dao.leerUsuarios();

    }
}