/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;

/**
 *
 * @author Juan
 */
public class NuevoInsumoScreen extends javax.swing.JFrame {

    /**
     * Creates new form NuevoInsumoScreen
     */
    public NuevoInsumoScreen() {
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

        informacionInsumoPanel = new javax.swing.JPanel();
        descripcionLabel = new javax.swing.JLabel();
        unidadLabel = new javax.swing.JLabel();
        limitePedidoLabel = new javax.swing.JLabel();
        tipoLabel = new javax.swing.JLabel();
        descripcionTextField = new javax.swing.JTextField();
        unidadComboBox = new javax.swing.JComboBox();
        limitePedidoFormattedTextField = new javax.swing.JFormattedTextField();
        tipoComboBox = new javax.swing.JComboBox();
        descripcionCampoObligatorioLabel = new javax.swing.JLabel();
        unidadCampoObligatorioLabel = new javax.swing.JLabel();
        limitePedidoCampoObligatorioLabel = new javax.swing.JLabel();
        tipoCampoObligatorioLabel = new javax.swing.JLabel();
        referenciaCampoObligatorioLabel = new javax.swing.JLabel();
        cancelarButton = new javax.swing.JButton();
        aceptarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Nuevo Insumo");
        setAlwaysOnTop(true);
        setResizable(false);

        informacionInsumoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingrese la informacion del nuevo insumo:"));

        descripcionLabel.setText("Descripcion:");

        unidadLabel.setText("Unidad:");

        limitePedidoLabel.setText("Limite Pedido:");

        tipoLabel.setText("Tipo:");

        descripcionTextField.setPreferredSize(new java.awt.Dimension(175, 20));

        unidadComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kilogramo", "Cada Uno", "Metros Cubicos", "Litros", "Metros" }));
        unidadComboBox.setSelectedIndex(-1);

        limitePedidoFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        tipoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Materia Prima", "Insumo Embalaje", "Insumo Produccion" }));
        tipoComboBox.setSelectedIndex(-1);

        descripcionCampoObligatorioLabel.setForeground(new java.awt.Color(255, 0, 0));
        descripcionCampoObligatorioLabel.setText("*");

        unidadCampoObligatorioLabel.setForeground(new java.awt.Color(255, 0, 0));
        unidadCampoObligatorioLabel.setText("*");

        limitePedidoCampoObligatorioLabel.setForeground(new java.awt.Color(255, 0, 0));
        limitePedidoCampoObligatorioLabel.setText("*");

        tipoCampoObligatorioLabel.setForeground(new java.awt.Color(255, 0, 0));
        tipoCampoObligatorioLabel.setText("*");

        referenciaCampoObligatorioLabel.setForeground(new java.awt.Color(255, 0, 0));
        referenciaCampoObligatorioLabel.setText("* Campo Obligatorio");

        javax.swing.GroupLayout informacionInsumoPanelLayout = new javax.swing.GroupLayout(informacionInsumoPanel);
        informacionInsumoPanel.setLayout(informacionInsumoPanelLayout);
        informacionInsumoPanelLayout.setHorizontalGroup(
            informacionInsumoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informacionInsumoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(informacionInsumoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(informacionInsumoPanelLayout.createSequentialGroup()
                        .addGroup(informacionInsumoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descripcionLabel)
                            .addComponent(unidadLabel)
                            .addComponent(limitePedidoLabel)
                            .addComponent(tipoLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(informacionInsumoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(informacionInsumoPanelLayout.createSequentialGroup()
                                .addComponent(descripcionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(descripcionCampoObligatorioLabel))
                            .addGroup(informacionInsumoPanelLayout.createSequentialGroup()
                                .addComponent(unidadComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(unidadCampoObligatorioLabel))
                            .addGroup(informacionInsumoPanelLayout.createSequentialGroup()
                                .addComponent(limitePedidoFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(limitePedidoCampoObligatorioLabel))
                            .addGroup(informacionInsumoPanelLayout.createSequentialGroup()
                                .addComponent(tipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipoCampoObligatorioLabel))))
                    .addComponent(referenciaCampoObligatorioLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        informacionInsumoPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {descripcionTextField, limitePedidoFormattedTextField, tipoComboBox, unidadComboBox});

        informacionInsumoPanelLayout.setVerticalGroup(
            informacionInsumoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informacionInsumoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(informacionInsumoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcionLabel)
                    .addComponent(descripcionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descripcionCampoObligatorioLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(informacionInsumoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unidadLabel)
                    .addComponent(unidadComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unidadCampoObligatorioLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(informacionInsumoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limitePedidoLabel)
                    .addComponent(limitePedidoFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limitePedidoCampoObligatorioLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(informacionInsumoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoLabel)
                    .addComponent(tipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoCampoObligatorioLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(referenciaCampoObligatorioLabel))
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(informacionInsumoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(informacionInsumoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarButton)
                    .addComponent(aceptarButton))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(323, 241));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(NuevoInsumoScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoInsumoScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoInsumoScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoInsumoScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoInsumoScreen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JLabel descripcionCampoObligatorioLabel;
    private javax.swing.JLabel descripcionLabel;
    private javax.swing.JTextField descripcionTextField;
    private javax.swing.JPanel informacionInsumoPanel;
    private javax.swing.JLabel limitePedidoCampoObligatorioLabel;
    private javax.swing.JFormattedTextField limitePedidoFormattedTextField;
    private javax.swing.JLabel limitePedidoLabel;
    private javax.swing.JLabel referenciaCampoObligatorioLabel;
    private javax.swing.JLabel tipoCampoObligatorioLabel;
    private javax.swing.JComboBox tipoComboBox;
    private javax.swing.JLabel tipoLabel;
    private javax.swing.JLabel unidadCampoObligatorioLabel;
    private javax.swing.JComboBox unidadComboBox;
    private javax.swing.JLabel unidadLabel;
    // End of variables declaration//GEN-END:variables
}
