/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan
 */
public class EsUtilizadaScreen extends javax.swing.JFrame {
    
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;    
    ResultSet rs2 = null;
    PreparedStatement pst2 = null;    
    PreparedStatement pst3 = null; 

    /**
     * Creates new form EsUtilizadaScreen
     */
    public EsUtilizadaScreen() {
        initComponents();
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error en conexión", JOptionPane.ERROR_MESSAGE);
        }
        
        try{
            String sql = "SELECT L_Identificador FROM Lotes WHERE L_Estado = 'Procesando' ORDER BY L_Identificador";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()){
                String identificador = rs.getString("L_Identificador");
                identificadorLoteComboBox.addItem(identificador);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error al buscar valores de Identificador de Lotes", JOptionPane.ERROR_MESSAGE);
        }
        
        try{
            String sql2 = "SELECT i_descripcion FROM insumos ORDER BY i_descripcion";
            pst = conn.prepareStatement(sql2);
            rs = pst.executeQuery();
            
            while (rs.next()){
                String descripcionInsumo = rs.getString("i_descripcion");
                descripcionInsumoComboBox.addItem(descripcionInsumo);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error al buscar valores de descripción de insumo", JOptionPane.ERROR_MESSAGE);
            
        }
        
        identificadorLoteComboBox.setSelectedIndex(-1);
        descripcionInsumoComboBox.setSelectedIndex(-1);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        informacionEsUtilizadaPanel = new javax.swing.JPanel();
        identificadorLoteLabel = new javax.swing.JLabel();
        descripcionInsumoLabel = new javax.swing.JLabel();
        cantidadInsumoUtilizadaLabel = new javax.swing.JLabel();
        identificadorLoteComboBox = new javax.swing.JComboBox();
        descripcionInsumoComboBox = new javax.swing.JComboBox();
        cantidadInsumoUtilizadaFormattedTextField = new javax.swing.JFormattedTextField();
        cancelarButton = new javax.swing.JButton();
        aceptarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Nueva Cantidad de Insumo Utilizada por Lote");
        setAlwaysOnTop(true);
        setResizable(false);

        informacionEsUtilizadaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingrese la información del lote, insumo y cantidad utilizada correspondiente:"));

        identificadorLoteLabel.setText("Identificador de Lote:");

        descripcionInsumoLabel.setText("Descripción de Insumo:");

        cantidadInsumoUtilizadaLabel.setText("Cantidad de Insumo Utilizada:");

        cantidadInsumoUtilizadaFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        cantidadInsumoUtilizadaFormattedTextField.setPreferredSize(new java.awt.Dimension(175, 20));

        javax.swing.GroupLayout informacionEsUtilizadaPanelLayout = new javax.swing.GroupLayout(informacionEsUtilizadaPanel);
        informacionEsUtilizadaPanel.setLayout(informacionEsUtilizadaPanelLayout);
        informacionEsUtilizadaPanelLayout.setHorizontalGroup(
            informacionEsUtilizadaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informacionEsUtilizadaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(informacionEsUtilizadaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(identificadorLoteLabel)
                    .addComponent(descripcionInsumoLabel)
                    .addComponent(cantidadInsumoUtilizadaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(informacionEsUtilizadaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cantidadInsumoUtilizadaFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descripcionInsumoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(identificadorLoteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        informacionEsUtilizadaPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cantidadInsumoUtilizadaFormattedTextField, descripcionInsumoComboBox, identificadorLoteComboBox});

        informacionEsUtilizadaPanelLayout.setVerticalGroup(
            informacionEsUtilizadaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informacionEsUtilizadaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(informacionEsUtilizadaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(identificadorLoteLabel)
                    .addComponent(identificadorLoteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(informacionEsUtilizadaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descripcionInsumoLabel)
                    .addComponent(descripcionInsumoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(informacionEsUtilizadaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidadInsumoUtilizadaLabel)
                    .addComponent(cantidadInsumoUtilizadaFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(informacionEsUtilizadaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(informacionEsUtilizadaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarButton)
                    .addComponent(aceptarButton))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(439, 216));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        if (identificadorLoteComboBox.getSelectedIndex() != -1){
            if (descripcionInsumoComboBox.getSelectedIndex() != -1){
                if (!cantidadInsumoUtilizadaFormattedTextField.getText().equals("")){
                    try{
                        String sql = "SELECT SM_I_Codigo FROM StocksMensualesInsumos WHERE I_Descripcion_CaracterizadoEn = ? AND SM_I_Fecha = ?";
                        pst = conn.prepareStatement(sql);

                        pst.setString(1, descripcionInsumoComboBox.getSelectedItem().toString());

                        Calendar calendarioActual = Calendar.getInstance();
                        calendarioActual.set(Calendar.DAY_OF_MONTH, 1);

                        java.util.Date today = new java.util.Date(calendarioActual.getTimeInMillis());
                        java.sql.Date fechaActual = new java.sql.Date(today.getTime());

                        pst.setDate(2,fechaActual);

                        rs = pst.executeQuery();
                        
                        if (rs.next()){
                            String sql2 = "SELECT L_Codigo FROM lotes WHERE L_Identificador=? AND L_Estado='Procesando'";
                            
                            pst2 = conn.prepareStatement(sql2);
                            
                            pst2.setString(1, identificadorLoteComboBox.getSelectedItem().toString());
                            
                            rs2 = pst2.executeQuery();
                            
                            if (rs2.next()){
                            
                                String sql3 = "INSERT INTO esutilizada( l_codigo_esutilizada, sm_i_codigo_esutilizada, cantidadutilizada) VALUES (?, ?, ?);";
                                pst3 = conn.prepareStatement(sql3);

                                pst3.setInt(1, rs2.getInt("L_Codigo"));
                                pst3.setInt(2, rs.getInt("SM_I_Codigo"));
                                pst3.setFloat(3, ((Number)cantidadInsumoUtilizadaFormattedTextField.getValue()).floatValue());

                                pst3.execute();

                                JOptionPane.showMessageDialog(this, "Nueva cantidad de insumo utilizada ingresada satisfactoriamente", "Nuevo uso de insumo por parte de lote", JOptionPane.INFORMATION_MESSAGE);

                                this.dispose();
                            }
                            else{
                                JOptionPane.showMessageDialog(this, "NO TIENE QUE OCURRIR", "NO TIENE QUE OCURRIR", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(this, "NO TIENE QUE OCURRIR", "NO TIENE QUE OCURRIR", JOptionPane.ERROR_MESSAGE);
                        }

                    }catch(Exception e){
                        JOptionPane.showMessageDialog(this, e.getMessage(), "Error al ingresar nueva provisión", JOptionPane.ERROR_MESSAGE);

                    }                    
                }
                else{
                    JOptionPane.showMessageDialog(this, "La cantidad de insumo utilizada no puede ser vacía.", "Error al cargar cantidad de insumo utilizada por lote", JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "Debe seleccionar un insumo.", "Error al cargar cantidad de insumo utilizada por lote", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Debe seleccionar un lote.", "Error al cargar cantidad de insumo utilizada por lote", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(EsUtilizadaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EsUtilizadaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EsUtilizadaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EsUtilizadaScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EsUtilizadaScreen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JFormattedTextField cantidadInsumoUtilizadaFormattedTextField;
    private javax.swing.JLabel cantidadInsumoUtilizadaLabel;
    private javax.swing.JComboBox descripcionInsumoComboBox;
    private javax.swing.JLabel descripcionInsumoLabel;
    private javax.swing.JComboBox identificadorLoteComboBox;
    private javax.swing.JLabel identificadorLoteLabel;
    private javax.swing.JPanel informacionEsUtilizadaPanel;
    // End of variables declaration//GEN-END:variables
}
