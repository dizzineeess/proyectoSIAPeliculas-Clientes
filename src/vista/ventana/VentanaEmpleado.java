package vista.ventana;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import modelo.Encargado;
import servicio.SistemaVideoClub;

public class VentanaEmpleado extends javax.swing.JPanel {

    private SistemaVideoClub sistema;

    public VentanaEmpleado() {
        initComponents();
    }

    public VentanaEmpleado(SistemaVideoClub sistema) {
        initComponents();
        this.sistema = sistema;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnQuitarEmpleadoActionPerformed = new javax.swing.JButton();
        btnAccionesEmpleadoActionPerformed = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnMostrarEmpleadoActionPerformed = new javax.swing.JButton();
        btnAgregarEmpleadoActionPerformed = new javax.swing.JButton();

        btnQuitarEmpleadoActionPerformed.setText("Quitar");
        btnQuitarEmpleadoActionPerformed.addActionListener(this::btnQuitarEmpleadoActionPerformedActionPerformed);

        btnAccionesEmpleadoActionPerformed.setText("Acciones empleado");
        btnAccionesEmpleadoActionPerformed.addActionListener(this::btnAccionesEmpleadoActionPerformedActionPerformed);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Empleado");
        jLabel1.setToolTipText("");

        btnMostrarEmpleadoActionPerformed.setText("Mostrar empleado");
        btnMostrarEmpleadoActionPerformed.addActionListener(this::btnMostrarEmpleadoActionPerformedActionPerformed);

        btnAgregarEmpleadoActionPerformed.setText("Agregar");
        btnAgregarEmpleadoActionPerformed.addActionListener(this::btnAgregarEmpleadoActionPerformedActionPerformed);

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnQuitarEmpleadoActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarEmpleadoActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMostrarEmpleadoActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAccionesEmpleadoActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarEmpleadoActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMostrarEmpleadoActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuitarEmpleadoActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAccionesEmpleadoActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnAgregarEmpleadoActionPerformedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEmpleadoActionPerformedActionPerformed
        String nombre = JOptionPane.showInputDialog(this, "Ingrese nombre:", "Agregar Empleado", JOptionPane.QUESTION_MESSAGE);
        if (nombre == null || nombre.trim().isEmpty()) {
            return;
        }

        String rut = JOptionPane.showInputDialog(this, "Ingrese RUT (ej: 12345678-K):", "Agregar Empleado", JOptionPane.QUESTION_MESSAGE);
        if (rut == null || rut.trim().isEmpty()) {
            return;
        }

        String idEmpleado = JOptionPane.showInputDialog(this, "Ingrese ID de empleado (ej: EMP-001):", "Agregar Empleado", JOptionPane.QUESTION_MESSAGE);
        if (idEmpleado == null || idEmpleado.trim().isEmpty()) {
            return;
        }

        String turno = JOptionPane.showInputDialog(this, "Ingrese turno:", "Agregar Empleado", JOptionPane.QUESTION_MESSAGE);
        if (turno == null || turno.trim().isEmpty()) {
            return;
        }

        String inputSueldo = JOptionPane.showInputDialog(this, "Ingrese sueldo base:", "Agregar Empleado", JOptionPane.QUESTION_MESSAGE);
        if (inputSueldo == null || inputSueldo.trim().isEmpty()) {
            return;
        }

        try {
            modelo.Persona.validarRut(rut.trim());
            Encargado.validarIdEmpleado(idEmpleado.trim());
            double sueldoBase = Double.parseDouble(inputSueldo.trim());
            Encargado nuevo = new Encargado(nombre.trim(), rut.trim(), sueldoBase, idEmpleado.trim(), turno.trim());
            String resultado = sistema.agregarEmpleado(nuevo);
            JOptionPane.showMessageDialog(this, resultado, "Agregar Empleado", JOptionPane.INFORMATION_MESSAGE);
        } catch (excepciones.RutInvalidoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "RUT Invalido", JOptionPane.ERROR_MESSAGE);
        } catch (excepciones.IdEmpleadoInvalidaException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ID Invalido", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El sueldo debe ser un numero valido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarEmpleadoActionPerformedActionPerformed

    private void btnQuitarEmpleadoActionPerformedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarEmpleadoActionPerformedActionPerformed
        String id = JOptionPane.showInputDialog(this, "Ingrese ID del empleado a eliminar:", "Quitar Empleado", JOptionPane.WARNING_MESSAGE);
        if (id == null || id.trim().isEmpty()) {
            return;
        }
        String resultado = sistema.quitarEmpleado(id.trim());
        JOptionPane.showMessageDialog(this, resultado, "Quitar Empleado", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnQuitarEmpleadoActionPerformedActionPerformed

    private void btnMostrarEmpleadoActionPerformedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarEmpleadoActionPerformedActionPerformed
        String id = JOptionPane.showInputDialog(this, "Ingrese ID del empleado:", "Mostrar Empleado", JOptionPane.QUESTION_MESSAGE);
        if (id == null || id.trim().isEmpty()) {
            return;
        }

        String datos = sistema.mostrarEmpleado(id.trim());
        JTextArea textArea = new JTextArea(10, 25);
        textArea.setText(datos);
        textArea.setEditable(false);
        JOptionPane.showMessageDialog(this, new JScrollPane(textArea), "Ficha del Empleado", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_btnMostrarEmpleadoActionPerformedActionPerformed

    private void btnAccionesEmpleadoActionPerformedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccionesEmpleadoActionPerformedActionPerformed
        String idIngresado = JOptionPane.showInputDialog(this, "Ingrese el ID del empleado:", "Seleccionar Empleado", JOptionPane.QUESTION_MESSAGE);
        if (idIngresado == null || idIngresado.trim().isEmpty()) {
            return;
        }

        String idLimpio = idIngresado.trim();
        if (sistema.obtenerEmpleado(idLimpio) != null) {
            JFrame marco = new JFrame("Acciones empleado");
            marco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            marco.add(new VentanaAccionesEmpleado(sistema, idLimpio));
            marco.pack();
            marco.setLocationRelativeTo(this);
            marco.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No existe un empleado registrado con ese ID.", "Empleado No Encontrado", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAccionesEmpleadoActionPerformedActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccionesEmpleadoActionPerformed;
    private javax.swing.JButton btnAgregarEmpleadoActionPerformed;
    private javax.swing.JButton btnMostrarEmpleadoActionPerformed;
    private javax.swing.JButton btnQuitarEmpleadoActionPerformed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
