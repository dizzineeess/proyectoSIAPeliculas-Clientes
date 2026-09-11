package vista.ventana;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import modelo.Pelicula;
import servicio.SistemaVideoClub;

public class VentanaPelicula extends javax.swing.JPanel {

    private SistemaVideoClub sistema;

    public VentanaPelicula() {
        initComponents();
    }

    public VentanaPelicula(SistemaVideoClub sistema) {
        initComponents();
        this.sistema = sistema;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnQuitarPeliculaActionPerformed = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnMostrarCatalogoActionPerformed = new javax.swing.JButton();
        btnAgregarPeliculaActionPerformed = new javax.swing.JButton();

        btnQuitarPeliculaActionPerformed.setText("Quitar");
        btnQuitarPeliculaActionPerformed.addActionListener(this::btnQuitarPeliculaActionPerformedActionPerformed);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pelicula");
        jLabel1.setToolTipText("");

        btnMostrarCatalogoActionPerformed.setText("Mostrar catalogo");
        btnMostrarCatalogoActionPerformed.addActionListener(this::btnMostrarCatalogoActionPerformedActionPerformed);

        btnAgregarPeliculaActionPerformed.setText("Agregar");
        btnAgregarPeliculaActionPerformed.addActionListener(this::btnAgregarPeliculaActionPerformedActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregarPeliculaActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnQuitarPeliculaActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnMostrarCatalogoActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarPeliculaActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuitarPeliculaActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnMostrarCatalogoActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarPeliculaActionPerformedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPeliculaActionPerformedActionPerformed
        String titulo = JOptionPane.showInputDialog(this, "Ingrese titulo:", "Agregar Pelicula", JOptionPane.QUESTION_MESSAGE);
        if (titulo == null || titulo.trim().isEmpty()) {
            return;
        }

        String autor = JOptionPane.showInputDialog(this, "Ingrese autor:", "Agregar Pelicula", JOptionPane.QUESTION_MESSAGE);
        if (autor == null || autor.trim().isEmpty()) {
            return;
        }

        String genero = JOptionPane.showInputDialog(this, "Ingrese genero:", "Agregar Pelicula", JOptionPane.QUESTION_MESSAGE);
        if (genero == null || genero.trim().isEmpty()) {
            return;
        }

        try {
            String inputAnio = JOptionPane.showInputDialog(this, "Ingrese anio de publicacion:", "Agregar Pelicula", JOptionPane.QUESTION_MESSAGE);
            if (inputAnio == null || inputAnio.trim().isEmpty()) {
                return;
            }
            int estrenoYear = Integer.parseInt(inputAnio.trim());

            String inputId = JOptionPane.showInputDialog(this, "Ingrese ID de la pelicula:", "Agregar Pelicula", JOptionPane.QUESTION_MESSAGE);
            if (inputId == null || inputId.trim().isEmpty()) {
                return;
            }
            int idPelicula = Integer.parseInt(inputId.trim());

            if (sistema.busquedaBinariaPeliculas(idPelicula) != null) {
                JOptionPane.showMessageDialog(this, "Ya existe una pelicula con ese ID.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String inputCopias = JOptionPane.showInputDialog(this, "Ingrese cantidad de copias en stock:", "Agregar Pelicula", JOptionPane.QUESTION_MESSAGE);
            if (inputCopias == null || inputCopias.trim().isEmpty()) {
                return;
            }
            int copiasDisponibles = Integer.parseInt(inputCopias.trim());

            int restriccion = JOptionPane.showConfirmDialog(this, "La pelicula tiene restriccion de edad (+18)?", "Agregar Pelicula", JOptionPane.YES_NO_OPTION);
            if (restriccion == JOptionPane.CLOSED_OPTION) {
                return;
            }
            boolean mayor18 = restriccion == JOptionPane.YES_OPTION;

            Pelicula nueva = new Pelicula(titulo.trim(), autor.trim(), genero.trim(), estrenoYear, idPelicula, copiasDisponibles, mayor18);
            sistema.agregarOrdenado(nueva);
            JOptionPane.showMessageDialog(this, "Pelicula agregada con exito.", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Anio, ID y copias deben ser numeros enteros.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarPeliculaActionPerformedActionPerformed

    private void btnQuitarPeliculaActionPerformedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarPeliculaActionPerformedActionPerformed
        String inputId = JOptionPane.showInputDialog(this, "Ingrese ID de la pelicula a eliminar:", "Quitar Pelicula", JOptionPane.WARNING_MESSAGE);
        if (inputId == null || inputId.trim().isEmpty()) {
            return;
        }
        try {
            int id = Integer.parseInt(inputId.trim());
            String resultado = sistema.eliminarPelicula(id);
            JOptionPane.showMessageDialog(this, resultado, "Quitar Pelicula", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID debe ser un numero entero valido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnQuitarPeliculaActionPerformedActionPerformed

    private void btnMostrarCatalogoActionPerformedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarCatalogoActionPerformedActionPerformed
        String catalogo = sistema.mostrarCatalogoPeliculas();
        if (catalogo == null || catalogo.trim().isEmpty() || sistema.listarPeliculas().isEmpty()) {
            catalogo = "No hay peliculas para mostrar";
        }

        JTextArea textArea = new JTextArea(15, 30);
        textArea.setText(catalogo);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JOptionPane.showMessageDialog(this, scrollPane, "Catalogo de Peliculas", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_btnMostrarCatalogoActionPerformedActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPeliculaActionPerformed;
    private javax.swing.JButton btnMostrarCatalogoActionPerformed;
    private javax.swing.JButton btnQuitarPeliculaActionPerformed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
