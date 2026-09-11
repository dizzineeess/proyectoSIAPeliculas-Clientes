package vista.ventana;

import javax.swing.*;
import java.awt.*;
import servicio.SistemaVideoClub;
import modelo.Pelicula;

public class VentanaPeliculas extends JDialog {

    private SistemaVideoClub sistema;
    
    private JTextField txtId;
    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtGenero;
    private JTextField txtEstrenoYear;
    private JTextField txtCopias;
    private JCheckBox chkMayor18;

    public VentanaPeliculas(Frame padre, SistemaVideoClub sistema) {
        super(padre, "Gestión de Películas y Catálogo", true);
        this.sistema = sistema;

        setSize(500, 420);
        setLocationRelativeTo(padre);
        
        // Formulario organizado en 9 filas x 2 columnas con márgenes
        setLayout(new GridLayout(9, 2, 8, 8));

        // 1. Campos del Formulario
        add(new JLabel(" ID Película (Número):"));
        txtId = new JTextField();
        add(txtId);

        add(new JLabel(" Título:"));
        txtTitulo = new JTextField();
        add(txtTitulo);

        add(new JLabel(" Autor / Director:"));
        txtAutor = new JTextField();
        add(txtAutor);

        add(new JLabel(" Género:"));
        txtGenero = new JTextField();
        add(txtGenero);

        add(new JLabel(" Año de Estreno:"));
        txtEstrenoYear = new JTextField();
        add(txtEstrenoYear);

        add(new JLabel(" Copias Disponibles:"));
        txtCopias = new JTextField();
        add(txtCopias);

        add(new JLabel(" Clasificación:"));
        chkMayor18 = new JCheckBox("Restringida (+18)");
        add(chkMayor18);

        // 2. Botones de Acción
        JButton btnGuardar = new JButton("Registrar Película");
        JButton btnVerCatalogo = new JButton("Ver Catálogo Completo");

        add(btnGuardar);
        add(btnVerCatalogo);

        // 3. Eventos
        btnGuardar.addActionListener(e -> registrarPelicula());
        btnVerCatalogo.addActionListener(e -> mostrarCatalogo());
    }

    private void registrarPelicula() {
        String idTxt = txtId.getText().trim();
        String titulo = txtTitulo.getText().trim();
        String autor = txtAutor.getText().trim();
        String genero = txtGenero.getText().trim();
        String yearTxt = txtEstrenoYear.getText().trim();
        String copiasTxt = txtCopias.getText().trim();
        boolean mayor18 = chkMayor18.isSelected();

        // Validación de campos vacíos
        if (idTxt.isEmpty() || titulo.isEmpty() || autor.isEmpty() || 
            genero.isEmpty() || yearTxt.isEmpty() || copiasTxt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int id = Integer.parseInt(idTxt);
            int year = Integer.parseInt(yearTxt);
            int copias = Integer.parseInt(copiasTxt);

            if (copias < 0) {
                JOptionPane.showMessageDialog(this, "El numero de copias no puede ser negativo.", "Error de Datos", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Pelicula nueva = new Pelicula(titulo, autor, genero, year, id, copias, mayor18);

            sistema.agregarOrdenado(nueva); 
            limpiarCampos();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID, Año de estreno y Copias deben ser valores numericos enteros.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error en Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarCatalogo() {
        String catalogo = sistema.mostrarCatalogoPeliculas(); 
        
        if (catalogo == null || catalogo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El catálogo se encuentra vacío.", "Catálogo Vacío", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JTextArea textArea = new JTextArea(15, 35);
            textArea.setText(catalogo);
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);

            JOptionPane.showMessageDialog(this, scrollPane, "Catálogo de Películas", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtTitulo.setText("");
        txtAutor.setText("");
        txtGenero.setText("");
        txtEstrenoYear.setText("");
        txtCopias.setText("");
        chkMayor18.setSelected(false);
    }
}