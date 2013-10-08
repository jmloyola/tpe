/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;

/**
 *
 * @author Juan
 */
public class NuevoUsuarioSistemaScreen extends javax.swing.JFrame {

    /**
     * Creates new form NuevoUsuarioSistemaScreen
     */
    public NuevoUsuarioSistemaScreen() {
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

        informacionNuevoUsuarioSistemaPanel = new javax.swing.JPanel();
        usuarioLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        usuarioTextField = new javax.swing.JTextField();
        passwordTextField = new javax.swing.JTextField();
        usuarioCampoObligatorioLabel = new javax.swing.JLabel();
        passwordCampoObligatorioLabel = new javax.swing.JLabel();
        referenciaCampoObligatorioLabel = new javax.swing.JLabel();
        AceptarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Nuevo Usuario del Sistema");
        setAlwaysOnTop(true);
        setResizable(false);

        informacionNuevoUsuarioSistemaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingrese la informacion del nuevo usuario del sistema:"));

        usuarioLabel.setText("Usuario:");

        passwordLabel.setText("Password:");

        usuarioTextField.setPreferredSize(new java.awt.Dimension(125, 20));

        usuarioCampoObligatorioLabel.setForeground(new java.awt.Color(255, 0, 0));
        usuarioCampoObligatorioLabel.setText("*");

        passwordCampoObligatorioLabel.setForeground(new java.awt.Color(255, 0, 0));
        passwordCampoObligatorioLabel.setText("*");

        referenciaCampoObligatorioLabel.setForeground(new java.awt.Color(255, 0, 0));
        referenciaCampoObligatorioLabel.setText("* Campos Obligatorios");

        javax.swing.GroupLayout informacionNuevoUsuarioSistemaPanelLayout = new javax.swing.GroupLayout(informacionNuevoUsuarioSistemaPanel);
        informacionNuevoUsuarioSistemaPanel.setLayout(informacionNuevoUsuarioSistemaPanelLayout);
        informacionNuevoUsuarioSistemaPanelLayout.setHorizontalGroup(
            informacionNuevoUsuarioSistemaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informacionNuevoUsuarioSistemaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(informacionNuevoUsuarioSistemaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(informacionNuevoUsuarioSistemaPanelLayout.createSequentialGroup()
                        .addGroup(informacionNuevoUsuarioSistemaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuarioLabel)
                            .addComponent(passwordLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(informacionNuevoUsuarioSistemaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(informacionNuevoUsuarioSistemaPanelLayout.createSequentialGroup()
                                .addComponent(usuarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usuarioCampoObligatorioLabel))
                            .addGroup(informacionNuevoUsuarioSistemaPanelLayout.createSequentialGroup()
                                .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordCampoObligatorioLabel))))
                    .addComponent(referenciaCampoObligatorioLabel))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        informacionNuevoUsuarioSistemaPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {passwordTextField, usuarioTextField});

        informacionNuevoUsuarioSistemaPanelLayout.setVerticalGroup(
            informacionNuevoUsuarioSistemaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informacionNuevoUsuarioSistemaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(informacionNuevoUsuarioSistemaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuarioLabel)
                    .addComponent(usuarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuarioCampoObligatorioLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(informacionNuevoUsuarioSistemaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordCampoObligatorioLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(referenciaCampoObligatorioLabel))
        );

        AceptarButton.setText("Aceptar");

        cancelarButton.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(informacionNuevoUsuarioSistemaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(AceptarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelarButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(informacionNuevoUsuarioSistemaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AceptarButton)
                    .addComponent(cancelarButton)))
        );

        setSize(new java.awt.Dimension(285, 195));
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
            java.util.logging.Logger.getLogger(NuevoUsuarioSistemaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoUsuarioSistemaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoUsuarioSistemaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoUsuarioSistemaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoUsuarioSistemaScreen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AceptarButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JPanel informacionNuevoUsuarioSistemaPanel;
    private javax.swing.JLabel passwordCampoObligatorioLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField passwordTextField;
    private javax.swing.JLabel referenciaCampoObligatorioLabel;
    private javax.swing.JLabel usuarioCampoObligatorioLabel;
    private javax.swing.JLabel usuarioLabel;
    private javax.swing.JTextField usuarioTextField;
    // End of variables declaration//GEN-END:variables
}
