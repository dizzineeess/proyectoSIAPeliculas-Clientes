/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista.ventana;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import servicio.SistemaVideoClub;

public class VentanaCliente extends javax.swing.JPanel {

    private SistemaVideoClub sistema;
    
    /**
     * Creates new form MenuVentana
     */
    public VentanaCliente() {
        initComponents();
    }
    
    public VentanaCliente(SistemaVideoClub sistema) {
        initComponents();
        this.sistema = sistema;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnQuitarClienteActionPerformed = new javax.swing.JButton();
        btnAccionesClienteActionPerformed = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnMostrarTodosClientesActionPerformed = new javax.swing.JButton();
        btnClientesAtrasadosActionPerformed = new javax.swing.JButton();
        btnAgregarClienteActionPerformed = new javax.swing.JButton();

        btnQuitarClienteActionPerformed.setText("Quitar");
        btnQuitarClienteActionPerformed.addActionListener(this::btnQuitarClienteActionPerformedActionPerformed);

        btnAccionesClienteActionPerformed.setText("Acciones cliente");
        btnAccionesClienteActionPerformed.addActionListener(this::btnAccionesClienteActionPerformedActionPerformed);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cliente");
        jLabel1.setToolTipText("");

        btnMostrarTodosClientesActionPerformed.setText("Mostrar clientes");
        btnMostrarTodosClientesActionPerformed.addActionListener(this::btnMostrarTodosClientesActionPerformedActionPerformed);

        btnClientesAtrasadosActionPerformed.setText("Mostrar atrasados");
        btnClientesAtrasadosActionPerformed.addActionListener(this::btnClientesAtrasadosActionPerformedActionPerformed);

        btnAgregarClienteActionPerformed.setText("Agregar");
        btnAgregarClienteActionPerformed.addActionListener(this::btnAgregarClienteActionPerformedActionPerformed);

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
                            .addComponent(btnQuitarClienteActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarClienteActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMostrarTodosClientesActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnClientesAtrasadosActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAccionesClienteActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarClienteActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClientesAtrasadosActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuitarClienteActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAccionesClienteActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnMostrarTodosClientesActionPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void btnAgregarClienteActionPerformedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformedActionPerformed
        // TODO add your handling code here: 
        String rut = JOptionPane.showInputDialog(this, "Ingrese RUT del nuevo cliente:", "Agregar Cliente", JOptionPane.QUESTION_MESSAGE);
    
        if (rut != null && !rut.trim().isEmpty()) {
            try {
                modelo.Persona.validarRut(rut.trim());

                String nombre = JOptionPane.showInputDialog(this, "Ingrese Nombre del cliente:", "Agregar Cliente", JOptionPane.QUESTION_MESSAGE);
                if (nombre != null && !nombre.trim().isEmpty()) {

                    modelo.Cliente nuevo = new modelo.Cliente(nombre.trim(), rut.trim());
                    boolean exito = sistema.agregarCliente(nuevo);

                    if (exito) {
                        JOptionPane.showMessageDialog(this, "Cliente agregado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Ya existe un cliente registrado con ese RUT.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (excepciones.RutInvalidoException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "RUT Inválido", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAgregarClienteActionPerformedActionPerformed

    private void btnQuitarClienteActionPerformedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarClienteActionPerformedActionPerformed
        // TODO add your handling code here:
        String rut = JOptionPane.showInputDialog(this, "Ingrese RUT del cliente a eliminar:", "Quitar Cliente", JOptionPane.WARNING_MESSAGE);
        if (rut != null && !rut.trim().isEmpty()) {
            boolean eliminado = sistema.quitarCliente(rut.trim());
            if (eliminado) {
                JOptionPane.showMessageDialog(this, "Cliente eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "El RUT ingresado no existe en el sistema.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }   
    }//GEN-LAST:event_btnQuitarClienteActionPerformedActionPerformed

    private void btnMostrarTodosClientesActionPerformedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodosClientesActionPerformedActionPerformed
        // TODO add your handling code here:
        String todos = sistema.mostrarTodosClientes();
    
        JTextArea textArea = new JTextArea(15, 30);
        textArea.setText(todos);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JOptionPane.showMessageDialog(this, scrollPane, "Lista de Clientes", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_btnMostrarTodosClientesActionPerformedActionPerformed

    private void btnClientesAtrasadosActionPerformedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesAtrasadosActionPerformedActionPerformed
        // TODO add your handling code here:
        String atrasados = sistema.mostrarClientesAtrasados();
    
        JTextArea textArea = new JTextArea(15, 30);
        textArea.setText(atrasados);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JOptionPane.showMessageDialog(this, scrollPane, "Clientes Atrasados", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnClientesAtrasadosActionPerformedActionPerformed

    private void btnAccionesClienteActionPerformedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccionesClienteActionPerformedActionPerformed
        // TODO add your handling code here:
        String rutIngresado = JOptionPane.showInputDialog(this, "Ingrese el RUT del cliente:", "Seleccionar Cliente", JOptionPane.QUESTION_MESSAGE);
    
        if (rutIngresado != null && !rutIngresado.trim().isEmpty()) {
            String rutLimpio = rutIngresado.trim();

            if (sistema.obtenerCliente(rutLimpio) != null) {
                JFrame marco = new JFrame("Acciones cliente");
                marco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                marco.add(new VentanaAccionesCliente(sistema, rutLimpio));
                marco.pack();
                marco.setLocationRelativeTo(this);
                marco.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "No existe un cliente registrado con ese RUT.", "Cliente No Encontrado", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAccionesClienteActionPerformedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccionesClienteActionPerformed;
    private javax.swing.JButton btnAgregarClienteActionPerformed;
    private javax.swing.JButton btnClientesAtrasadosActionPerformed;
    private javax.swing.JButton btnMostrarTodosClientesActionPerformed;
    private javax.swing.JButton btnQuitarClienteActionPerformed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
