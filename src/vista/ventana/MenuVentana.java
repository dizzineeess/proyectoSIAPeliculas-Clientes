package vista.ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import servicio.SistemaVideoClub;

public class MenuVentana extends JFrame {

    private SistemaVideoClub sistema;

    public MenuVentana(SistemaVideoClub sistema) {
        this.sistema = sistema;

        setTitle("Sistema de Video Club - Panel Principal");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana en pantalla
        setLayout(new GridLayout(5, 1, 10, 10)); // Organización limpia en filas

        JLabel lblTitulo = new JLabel("GESTIÓN DEL VIDEO CLUB", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));

        JButton btnClientes = new JButton("Módulo Clientes");
        JButton btnEmpleados = new JButton("Módulo Empleados");
        JButton btnPeliculas = new JButton("Catálogo de Películas");
        JButton btnSalir = new JButton("Salir");

        add(lblTitulo);
        add(btnClientes);
        add(btnEmpleados);
        add(btnPeliculas);
        add(btnSalir);


        btnClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaClientes vClientes = new VentanaClientes(MenuVentana.this, sistema);
                vClientes.setVisible(true);
            }
        });

        btnEmpleados.addActionListener(e -> {
            VentanaEmpleados vEmpleados = new VentanaEmpleados(MenuVentana.this, sistema);
            vEmpleados.setVisible(true);
        });

        btnPeliculas.addActionListener(e -> {
            VentanaPeliculas vPeliculas = new VentanaPeliculas(MenuVentana.this, sistema);
            vPeliculas.setVisible(true);
        });

        btnSalir.addActionListener(e -> System.exit(0));
    }
}