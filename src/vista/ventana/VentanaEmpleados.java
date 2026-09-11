package vista.ventana;

import javax.swing.*;
import java.awt.*;
import servicio.SistemaVideoClub;
import modelo.Encargado;
import excepciones.RutInvalidoException;
import excepciones.IdEmpleadoInvalidaException;


public class VentanaEmpleados extends JDialog {

    private SistemaVideoClub sistema;
    private JTextField txtNombre;
    private JTextField txtRut;
    private JTextField txtSueldo;

    public VentanaEmpleados(Frame padre, SistemaVideoClub sistema) {
        super(padre, "Gestión de Encargados", true);
        this.sistema = sistema;

        setSize(450, 300);
        setLocationRelativeTo(padre);
        setLayout(new GridLayout(5, 2, 10, 10));

        // 1. Componentes del Formulario
        add(new JLabel(" Nombre Encargado:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel(" RUT (ej: 12345678-K):"));
        txtRut = new JTextField();
        add(txtRut);

        add(new JLabel(" Sueldo ($):"));
        txtSueldo = new JTextField();
        add(txtSueldo);

        JButton btnGuardar = new JButton("Registrar Encargado");
        JButton btnMostrar = new JButton("Mostrar por RUT");

        add(btnGuardar);
        add(btnMostrar);

        btnGuardar.addActionListener(e -> registrarEncargado());
        btnMostrar.addActionListener(e -> mostrarEncargado());
    }

    private void registrarEncargado() {
        String nombre = txtNombre.getText().trim();
        String rut = txtRut.getText().trim();
        String sueldoTexto = txtSueldo.getText().trim();
        String idEmpleado = txtSueldo.getText().trim();

        if (nombre.isEmpty() || rut.isEmpty() || sueldoTexto.isEmpty() || idEmpleado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double sueldo = Double.parseDouble(sueldoTexto);

            Encargado nuevo = new Encargado(nombre, rut, sueldo, idEmpleado);

            JOptionPane.showMessageDialog(this, sistema.agregarEmpleado(nuevo));
            limpiarCampos();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El sueldo debe ser un número entero válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (RutInvalidoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "RUT Inválido", JOptionPane.ERROR_MESSAGE);
        } catch (IdEmpleadoInvalidaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "ID Inválido", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Datos Inválidos", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarEncargado() {
        String idEmpleado = txtRut.getText().trim();
        
        if (idEmpleado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID para buscar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String resultado = sistema.mostrarEmpleado(idEmpleado);
        JOptionPane.showMessageDialog(this, resultado, "Resultado de Búsqueda", JOptionPane.INFORMATION_MESSAGE);
        
        }
    
    private void limpiarCampos() {
        txtNombre.setText("");
        txtRut.setText("");
        txtSueldo.setText("");
    }
    
}