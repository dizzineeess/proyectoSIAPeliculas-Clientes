package vista.ventana;

import javax.swing.JOptionPane;
import servicio.SistemaVideoClub;

public class VentanaAccionesEmpleado extends javax.swing.JPanel {

    private SistemaVideoClub sistema;
    private String idEmpleado;

    public VentanaAccionesEmpleado() {
        initComponents();
    }

    public VentanaAccionesEmpleado(SistemaVideoClub sistema, String idEmpleado) {
        initComponents();
        this.sistema = sistema;
        this.idEmpleado = idEmpleado;
        lblIdEmpleado.setText("ID empleado actual: " + this.idEmpleado);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblIdEmpleado = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnCambiarTurnoActionPerformed = new javax.swing.JButton();
        btnIntercambiarTurnoActionPerformed = new javax.swing.JButton();
        btnCambiarSueldoActionPerformed = new javax.swing.JButton();
        btnSalirActionPerformed = new javax.swing.JButton();

        lblIdEmpleado.setText("ID empleado actual: ");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Acciones empleado");
        jLabel1.setToolTipText("");

        btnCambiarTurnoActionPerformed.setText("Cambiar turno");
        btnCambiarTurnoActionPerformed.addActionListener(this::btnCambiarTurnoActionPerformedActionPerformed);

        btnIntercambiarTurnoActionPerformed.setText("Cambiar turno con otro");
        btnIntercambiarTurnoActionPerformed.addActionListener(this::btnIntercambiarTurnoActionPerformedActionPerformed);

        btnCambiarSueldoActionPerformed.setText("Cambiar sueldo");
        btnCambiarSueldoActionPerformed.addActionListener(this::btnCambiarSueldoActionPerformedActionPerformed);

        btnSalirActionPerformed.setText("Salir");
        btnSalirActionPerformed.addActionListener(this::btnSalirActionPerformedActionPerformed);

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
                    .addComponent(lblIdEmpleado)
                    .addComponent(btnCambiarTurnoActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIntercambiarTurnoActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambiarSueldoActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalirActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(lblIdEmpleado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCambiarTurnoActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIntercambiarTurnoActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCambiarSueldoActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalirActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCambiarTurnoActionPerformedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarTurnoActionPerformedActionPerformed
        String turno = JOptionPane.showInputDialog(this, "Ingrese el nuevo turno:", "Cambiar Turno", JOptionPane.QUESTION_MESSAGE);
        if (turno == null || turno.trim().isEmpty()) {
            return;
        }
        String resultado = sistema.cambioDeTurno(this.idEmpleado, turno.trim());
        JOptionPane.showMessageDialog(this, resultado, "Cambiar Turno", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnCambiarTurnoActionPerformedActionPerformed

    private void btnIntercambiarTurnoActionPerformedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIntercambiarTurnoActionPerformedActionPerformed
        String idOtro = JOptionPane.showInputDialog(this, "Ingrese el ID del otro empleado:", "Intercambiar Turno", JOptionPane.QUESTION_MESSAGE);
        if (idOtro == null || idOtro.trim().isEmpty()) {
            return;
        }
        String resultado = sistema.intercambioDeTurno(this.idEmpleado, idOtro.trim());
        JOptionPane.showMessageDialog(this, resultado, "Intercambiar Turno", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnIntercambiarTurnoActionPerformedActionPerformed

    private void btnCambiarSueldoActionPerformedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarSueldoActionPerformedActionPerformed
        String inputSueldo = JOptionPane.showInputDialog(this, "Ingrese el nuevo sueldo:", "Cambiar Sueldo", JOptionPane.QUESTION_MESSAGE);
        if (inputSueldo == null || inputSueldo.trim().isEmpty()) {
            return;
        }
        try {
            double sueldo = Double.parseDouble(inputSueldo.trim());
            String resultado = sistema.cambioDeSueldo(this.idEmpleado, sueldo);
            JOptionPane.showMessageDialog(this, resultado, "Cambiar Sueldo", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un sueldo numerico valido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCambiarSueldoActionPerformedActionPerformed

    private void btnSalirActionPerformedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformedActionPerformed
        java.awt.Window ventana = javax.swing.SwingUtilities.getWindowAncestor(this);
        if (ventana != null) {
            ventana.dispose();
        }
    }//GEN-LAST:event_btnSalirActionPerformedActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarSueldoActionPerformed;
    private javax.swing.JButton btnCambiarTurnoActionPerformed;
    private javax.swing.JButton btnIntercambiarTurnoActionPerformed;
    private javax.swing.JButton btnSalirActionPerformed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblIdEmpleado;
    // End of variables declaration//GEN-END:variables
}
