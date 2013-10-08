/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;

/**
 *
 * @author Juan
 */
public class NuevoProductoTerminadoScreen extends javax.swing.JFrame {

    /**
     * Creates new form NuevoProductoTerminadoScreen
     */
    public NuevoProductoTerminadoScreen() {
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

        informacionProductoTerminadoPanel = new javax.swing.JPanel();
        codificacionLabel = new javax.swing.JLabel();
        tipoLabel = new javax.swing.JLabel();
        descripcionLabel = new javax.swing.JLabel();
        destinoLabel = new javax.swing.JLabel();
        kilosPorEnvaseLabel = new javax.swing.JLabel();
        codificacionTextField = new javax.swing.JTextField();
        tipoComboBox = new javax.swing.JComboBox();
        descripcionTextField = new javax.swing.JTextField();
        destinoTextField = new javax.swing.JTextField();
        kilosPorEnvaseFormattedTextField = new javax.swing.JFormattedTextField();
        codificacionCampoObligatorioLabel = new javax.swing.JLabel();
        tipoCampoObligatorioLabel = new javax.swing.JLabel();
        descripcionCampoObligatorioLabel = new javax.swing.JLabel();
        destinoCampoObligatorioLabel = new javax.swing.JLabel();
        kilosPorEnvaseCampoObligatorioLabel = new javax.swing.JLabel();
        referenciaCampoObligatorioLabel = new javax.swing.JLabel();
        presentacionLabel = new javax.swing.JLabel();
        presentacionTextField = new javax.swing.JTextField();
        presentacionCampoObligatorioLabel = new javax.swing.JLabel();
        cancelarButton = new javax.swing.JButton();
        aceptarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nuevo Producto Terminado");
        setResizable(false);

        informacionProductoTerminadoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingrese la informacion del nuevo producto terminado:"));

        codificacionLabel.setText("Codificacion:");

        tipoLabel.setText("Tipo:");

        descripcionLabel.setText("Descripcion:");

        destinoLabel.setText("Destino:");

        kilosPorEnvaseLabel.setText("Kilos Por Envase:");

        tipoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pastillas", "Comprimidos", "Tabletas", "Granulado" }));
        tipoComboBox.setSelectedIndex(-1);

        descripcionTextField.setPreferredSize(new java.awt.Dimension(150, 20));

        kilosPorEnvaseFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        codificacionCampoObligatorioLabel.setForeground(new java.awt.Color(255, 0, 0));
        codificacionCampoObligatorioLabel.setText("*");

        tipoCampoObligatorioLabel.setForeground(new java.awt.Color(255, 0, 0));
        tipoCampoObligatorioLabel.setText("*");

        descripcionCampoObligatorioLabel.setForeground(new java.awt.Color(255, 0, 0));
        descripcionCampoObligatorioLabel.setText("*");

        destinoCampoObligatorioLabel.setForeground(new java.awt.Color(255, 0, 0));
        destinoCampoObligatorioLabel.setText("*");

        kilosPorEnvaseCampoObligatorioLabel.setForeground(new java.awt.Color(255, 0, 0));
        kilosPorEnvaseCampoObligatorioLabel.setText("*");

        referenciaCampoObligatorioLabel.setForeground(new java.awt.Color(255, 0, 0));
        referenciaCampoObligatorioLabel.setText("* Campo Obligatorio");

        presentacionLabel.setText("Presentacion:");

        presentacionCampoObligatorioLabel.setForeground(new java.awt.Color(255, 0, 0));
        presentacionCampoObligatorioLabel.setText("*");

        javax.swing.GroupLayout informacionProductoTerminadoPanelLayout = new javax.swing.GroupLayout(informacionProductoTerminadoPanel);
        informacionProductoTerminadoPanel.setLayout(informacionProductoTerminadoPanelLayout);
        informacionProductoTerminadoPanelLayout.setHorizontalGroup(
            informacionProductoTerminadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informacionProductoTerminadoPanelLayout.createSequentialGroup()
                .addGroup(informacionProductoTerminadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(informacionProductoTerminadoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(informacionProductoTerminadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codificacionLabel)
                            .addComponent(tipoLabel)
                            .addComponent(descripcionLabel)
                            .addComponent(presentacionLabel)
                            .addComponent(destinoLabel)
                            .addComponent(kilosPorEnvaseLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(informacionProductoTerminadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codificacionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descripcionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(presentacionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(destinoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kilosPorEnvaseFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(informacionProductoTerminadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tipoCampoObligatorioLabel)
                            .addComponent(codificacionCampoObligatorioLabel)
                            .addComponent(descripcionCampoObligatorioLabel)
                            .addComponent(destinoCampoObligatorioLabel)
                            .addComponent(kilosPorEnvaseCampoObligatorioLabel)
                            .addComponent(presentacionCampoObligatorioLabel)))
                    .addGroup(informacionProductoTerminadoPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(referenciaCampoObligatorioLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        informacionProductoTerminadoPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {codificacionTextField, descripcionTextField, destinoTextField, kilosPorEnvaseFormattedTextField, presentacionTextField, tipoComboBox});

        informacionProductoTerminadoPanelLayout.setVerticalGroup(
            informacionProductoTerminadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informacionProductoTerminadoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(informacionProductoTerminadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codificacionLabel)
                    .addComponent(codificacionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codificacionCampoObligatorioLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(informacionProductoTerminadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoLabel)
                    .addComponent(tipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoCampoObligatorioLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(informacionProductoTerminadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcionLabel)
                    .addComponent(descripcionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descripcionCampoObligatorioLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(informacionProductoTerminadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(presentacionLabel)
                    .addComponent(presentacionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(presentacionCampoObligatorioLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(informacionProductoTerminadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(destinoLabel)
                    .addComponent(destinoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destinoCampoObligatorioLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(informacionProductoTerminadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kilosPorEnvaseLabel)
                    .addComponent(kilosPorEnvaseFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kilosPorEnvaseCampoObligatorioLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(referenciaCampoObligatorioLabel))
        );

        cancelarButton.setText("Cancelar");

        aceptarButton.setText("Aceptar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(informacionProductoTerminadoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(informacionProductoTerminadoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarButton)
                    .addComponent(aceptarButton))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(314, 293));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(NuevoProductoTerminadoScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoProductoTerminadoScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoProductoTerminadoScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoProductoTerminadoScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoProductoTerminadoScreen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JLabel codificacionCampoObligatorioLabel;
    private javax.swing.JLabel codificacionLabel;
    private javax.swing.JTextField codificacionTextField;
    private javax.swing.JLabel descripcionCampoObligatorioLabel;
    private javax.swing.JLabel descripcionLabel;
    private javax.swing.JTextField descripcionTextField;
    private javax.swing.JLabel destinoCampoObligatorioLabel;
    private javax.swing.JLabel destinoLabel;
    private javax.swing.JTextField destinoTextField;
    private javax.swing.JPanel informacionProductoTerminadoPanel;
    private javax.swing.JLabel kilosPorEnvaseCampoObligatorioLabel;
    private javax.swing.JFormattedTextField kilosPorEnvaseFormattedTextField;
    private javax.swing.JLabel kilosPorEnvaseLabel;
    private javax.swing.JLabel presentacionCampoObligatorioLabel;
    private javax.swing.JLabel presentacionLabel;
    private javax.swing.JTextField presentacionTextField;
    private javax.swing.JLabel referenciaCampoObligatorioLabel;
    private javax.swing.JLabel tipoCampoObligatorioLabel;
    private javax.swing.JComboBox tipoComboBox;
    private javax.swing.JLabel tipoLabel;
    // End of variables declaration//GEN-END:variables
}
