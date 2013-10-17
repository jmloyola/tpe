/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;

import javax.swing.JOptionPane;
import sgps.SGPS;

/**
 *
 * @author Juan
 */
public class AsignarLotesEtapasEmpleadosScreen extends javax.swing.JFrame {


    /**
     * Creates new form AsignarLotesEtapasEmpleadosScreen
     */
    public AsignarLotesEtapasEmpleadosScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        valoresPanel = new javax.swing.JPanel();
        identificadorLoteLabel = new javax.swing.JLabel();
        descripcionEtapaLabel = new javax.swing.JLabel();
        numeroLegajoEmpleadoLabel = new javax.swing.JLabel();
        fechaLabel = new javax.swing.JLabel();
        identificadorLoteComboBox = new javax.swing.JComboBox();
        descripcionEtapaComboBox = new javax.swing.JComboBox();
        fechaDateChooser = new com.toedter.calendar.JDateChooser();
        numeroLegajoFormattedTextField = new javax.swing.JFormattedTextField();
        buscarEmpleadoButton = new javax.swing.JButton();
        cargarNumeroLegajoButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        aceptarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Asignar Lotes-Etapas-Empleados");
        setAlwaysOnTop(true);
        setResizable(false);

        identificadorLoteLabel.setText("Identificador de Lote:");

        descripcionEtapaLabel.setText("Descripción de Etapa:");

        numeroLegajoEmpleadoLabel.setText("Número de Legajo de Empleado:");

        fechaLabel.setText("Fecha:");

        fechaDateChooser.setDateFormatString("dd/MM/yyyy");
        fechaDateChooser.setPreferredSize(new java.awt.Dimension(150, 20));

        numeroLegajoFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

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

        javax.swing.GroupLayout valoresPanelLayout = new javax.swing.GroupLayout(valoresPanel);
        valoresPanel.setLayout(valoresPanelLayout);
        valoresPanelLayout.setHorizontalGroup(
            valoresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(valoresPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(valoresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(identificadorLoteLabel)
                    .addComponent(descripcionEtapaLabel)
                    .addComponent(numeroLegajoEmpleadoLabel)
                    .addComponent(fechaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(valoresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(valoresPanelLayout.createSequentialGroup()
                        .addComponent(numeroLegajoFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarEmpleadoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cargarNumeroLegajoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(descripcionEtapaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(identificadorLoteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        valoresPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {descripcionEtapaComboBox, fechaDateChooser, identificadorLoteComboBox, numeroLegajoFormattedTextField});

        valoresPanelLayout.setVerticalGroup(
            valoresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(valoresPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(valoresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(identificadorLoteLabel)
                    .addComponent(identificadorLoteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(valoresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcionEtapaLabel)
                    .addComponent(descripcionEtapaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(valoresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(valoresPanelLayout.createSequentialGroup()
                        .addGroup(valoresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numeroLegajoEmpleadoLabel)
                            .addComponent(numeroLegajoFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarEmpleadoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, valoresPanelLayout.createSequentialGroup()
                        .addComponent(cargarNumeroLegajoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addGroup(valoresPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fechaLabel)
                    .addComponent(fechaDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        aceptarButton.setText("Aceptar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aceptarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelarButton))
                    .addComponent(valoresPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(valoresPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarButton)
                    .addComponent(aceptarButton))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(407, 220));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void buscarEmpleadoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarEmpleadoButtonActionPerformed
        JOptionPane.showMessageDialog(this, "Realice la busqueda de empleado, seleccione en la tabla el empleado que desea haciendo click en la fila y presiones el boton salir.", "Recuerde", JOptionPane.INFORMATION_MESSAGE);
        BuscarEmpleadosScreen buscarEmpleadosScreen = new BuscarEmpleadosScreen();
        buscarEmpleadosScreen.setVisible(true);
        
        /*if (SGPS.numeroLegajoEmpleado != -1){
            numeroLegajoFormattedTextField.setValue(SGPS.numeroLegajoEmpleado);
            SGPS.numeroLegajoEmpleado = -1;
        } */       
    }//GEN-LAST:event_buscarEmpleadoButtonActionPerformed

    private void cargarNumeroLegajoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarNumeroLegajoButtonActionPerformed
        if (SGPS.numeroLegajoEmpleado != -1){
            numeroLegajoFormattedTextField.setValue(SGPS.numeroLegajoEmpleado);
            SGPS.numeroLegajoEmpleado = -1;
        }         
    }//GEN-LAST:event_cargarNumeroLegajoButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AsignarLotesEtapasEmpleadosScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsignarLotesEtapasEmpleadosScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsignarLotesEtapasEmpleadosScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsignarLotesEtapasEmpleadosScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsignarLotesEtapasEmpleadosScreen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JButton buscarEmpleadoButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JButton cargarNumeroLegajoButton;
    private javax.swing.JComboBox descripcionEtapaComboBox;
    private javax.swing.JLabel descripcionEtapaLabel;
    private com.toedter.calendar.JDateChooser fechaDateChooser;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JComboBox identificadorLoteComboBox;
    private javax.swing.JLabel identificadorLoteLabel;
    private javax.swing.JLabel numeroLegajoEmpleadoLabel;
    private javax.swing.JFormattedTextField numeroLegajoFormattedTextField;
    private javax.swing.JPanel valoresPanel;
    // End of variables declaration//GEN-END:variables
}
