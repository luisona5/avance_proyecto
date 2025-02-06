
import org.example.LOGIN;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login | Radio Button Use");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setPreferredSize(new Dimension(600, 600));
        frame.setContentPane(new LOGIN().login);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}