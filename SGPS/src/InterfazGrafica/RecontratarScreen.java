/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import sgps.SGPS;

/**
 *
 * @author Juan Martin
 */
public class RecontratarScreen extends javax.swing.JFrame {
    
    
    Connection conn = null;
    PreparedStatement pst = null;
    PreparedStatement pst2 = null;
    ResultSet rs = null;

    /**
     * Creates new form recontratarScreen
     */
    public RecontratarScreen() {
        initComponents();
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error en conexión", JOptionPane.ERROR_MESSAGE);
        }        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        numeroLegajoPanel = new javax.swing.JPanel();
        numeroLegajoLabel = new javax.swing.JLabel();
        numeroLegajoFormattedTextField = new javax.swing.JFormattedTextField();
        buscarEmpleadoButton = new javax.swing.JButton();
        cargarNumeroLegajoButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        aceptarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Recontratar Empleado");

        numeroLegajoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingrese el número de legajo del empleado a recontratar:"));

        numeroLegajoLabel.setText("Número de Legajo:");

        numeroLegajoFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        numeroLegajoFormattedTextField.setPreferredSize(new java.awt.Dimension(150, 20));

        buscarEmpleadoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazGrafica/Icons/search_plus.png"))); // NOI18N
        buscarEmpleadoButton.setPreferredSize(new java.awt.Dimension(20, 20));
        buscarEmpleadoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarEmpleadoButtonActionPerformed(evt);
            }
        });

        cargarNumeroLegajoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazGrafica/Icons/group_add.png"))); // NOI18N
        cargarNumeroLegajoButton.setPreferredSize(new java.awt.Dimension(20, 20));
        cargarNumeroLegajoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarNumeroLegajoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout numeroLegajoPanelLayout = new javax.swing.GroupLayout(numeroLegajoPanel);
        numeroLegajoPanel.setLayout(numeroLegajoPanelLayout);
        numeroLegajoPanelLayout.setHorizontalGroup(
            numeroLegajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(numeroLegajoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(numeroLegajoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numeroLegajoFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarEmpleadoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cargarNumeroLegajoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        numeroLegajoPanelLayout.setVerticalGroup(
            numeroLegajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, numeroLegajoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(numeroLegajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cargarNumeroLegajoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(numeroLegajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(buscarEmpleadoButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(numeroLegajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numeroLegajoLabel)
                            .addComponent(numeroLegajoFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        aceptarButton.setText("Aceptar");
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numeroLegajoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(aceptarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelarButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(numeroLegajoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarButton)
                    .addComponent(aceptarButton))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(365, 155));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buscarEmpleadoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarEmpleadoButtonActionPerformed
        JOptionPane.showMessageDialog(this, "Realice la búsqueda de empleado, seleccione en la tabla el empleado que desea haciendo click en la fila y presiones el botón salir.", "Recuerde", JOptionPane.INFORMATION_MESSAGE);
        BuscarEmpleadosScreen buscarEmpleadosScreen = new BuscarEmpleadosScreen();
        buscarEmpleadosScreen.setVisible(true);

        /*if (SGPS.numeroLegajoEmpleado != -1){
            numeroLegajoFormattedTextField.setValue(SGPS.numeroLegajoEmpleado);
            SGPS.numeroLegajoEmpleado = -1;
        }*/
    }//GEN-LAST:event_buscarEmpleadoButtonActionPerformed

    private void cargarNumeroLegajoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarNumeroLegajoButtonActionPerformed
        if (SGPS.numeroLegajoEmpleado != -1){
            numeroLegajoFormattedTextField.setValue(SGPS.numeroLegajoEmpleado);
            SGPS.numeroLegajoEmpleado = -1;
        }
    }//GEN-LAST:event_cargarNumeroLegajoButtonActionPerformed

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        if (!numeroLegajoFormattedTextField.getText().equals("")){        

            try{
                String sql = "UPDATE empleados SET e_estado = 'Activo' WHERE E_NumeroLegajo = ?";
                
                String sql2 = "SELECT E_Nombre FROM empleados WHERE E_NumeroLegajo = ? AND E_Estado = 'Despedido'";
                
                pst2 = conn.prepareStatement(sql2);
                
                pst2.setInt(1, Integer.parseInt(numeroLegajoFormattedTextField.getText()));
                
                rs = pst2.executeQuery();
                
                if (rs.next()){
                
                    pst = conn.prepareStatement(sql);

                    pst.setInt(1, Integer.parseInt(numeroLegajoFormattedTextField.getText()));

                    pst.execute();

                    JOptionPane.showMessageDialog(this, "Empleado recontratado con éxito", "Recontratación de empleado exitosa", JOptionPane.INFORMATION_MESSAGE);

                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this, "El número de legajo ingresado no se corresponde con el de ningún empleado despedido.", "Error al recontratar empleado", JOptionPane.ERROR_MESSAGE);
                }

            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error al recontratar empleado", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "El número de legajo no puede ser vacío", "Error al recontratar empleado", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_aceptarButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RecontratarScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecontratarScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecontratarScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecontratarScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecontratarScreen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JButton buscarEmpleadoButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JButton cargarNumeroLegajoButton;
    private javax.swing.JFormattedTextField numeroLegajoFormattedTextField;
    private javax.swing.JLabel numeroLegajoLabel;
    private javax.swing.JPanel numeroLegajoPanel;
    // End of variables declaration//GEN-END:variables
}