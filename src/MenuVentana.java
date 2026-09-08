import javax.swing.*;
import java.awt.event.*;

public class MenuVentana extends JFrame {
    
    public MenuVentana() {
    // Configuración básica de la ventana
    setTitle("Sistema de Películas - Clientes");
    setSize(800, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null); 
    setLayout(null); 

    // Crear una etiqueta de texto
    JLabel titulo = new JLabel("Bienvenido al Sistema de Películas");
    titulo.setBounds(300, 80, 500, 120);
    add(titulo);

    // Crear un botón
    JButton botonAbrirMenu = new JButton("Iniciar Menú Consola");
    botonAbrirMenu.setBounds(200, 200, 400, 80);
    add(botonAbrirMenu);

    // Acción al hacer clic en el botón
    botonAbrirMenu.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "nada!!!1!");
        }
    });
}

}