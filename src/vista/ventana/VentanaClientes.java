package vista.ventana;

import javax.swing.*;
import java.awt.*;
import servicio.SistemaVideoClub;
import modelo.Cliente;
import modelo.Persona;
import excepciones.RutInvalidoException;

public class VentanaClientes extends JDialog {

    private SistemaVideoClub sistema;
    private JTextField txtNombre;
    private JTextField txtRut;

    public VentanaClientes(Frame padre, SistemaVideoClub sistema) {
        super(padre, "Gestión de Clientes", true); // true = Ventana Modal
        this.sistema = sistema;

        setSize(400, 300);
        setLocationRelativeTo(padre);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Formulario
        add(new JLabel(" Nombre Cliente:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel(" RUT (ej: 12345678-K):"));
        txtRut = new JTextField();
        add(txtRut);

        JButton btnGuardar = new JButton("Registrar Cliente");
        JButton btnBuscar = new JButton("Buscar por RUT");

        add(btnGuardar);
        add(btnBuscar);

        btnGuardar.addActionListener(e -> registrarCliente());

        btnBuscar.addActionListener(e -> buscarCliente());
    }

    private void registrarCliente() {
        String nombre = txtNombre.getText().trim();
        String rut = txtRut.getText().trim();

        try {
            // 1. Validar el RUT con tu método estático centralizado
            Persona.validarRut(rut);

            // 2. Crear y guardar en el servicio
            Cliente nuevo = new Cliente(nombre, rut);
            if (sistema.agregarCliente(nuevo)) {
                JOptionPane.showMessageDialog(this, "Cliente guardado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                txtNombre.setText("");
                txtRut.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "El cliente ya existe.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }

        } catch (RutInvalidoException ex) {
            // 3. Captura la excepción de tu modelo y muestra el mensaje exacto
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarCliente() {
        String rut = txtRut.getText().trim();
        try {
            Persona.validarRut(rut);
            Cliente c = sistema.obtenerCliente(rut);
            if (c != null) {
                JOptionPane.showMessageDialog(this, c.identificarse(), "Cliente Encontrado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "No existe cliente con ese RUT.", "Sin resultados", JOptionPane.WARNING_MESSAGE);
            }
        } catch (RutInvalidoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}