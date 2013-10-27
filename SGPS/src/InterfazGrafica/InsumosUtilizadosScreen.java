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
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import sgps.SGPS;

/**
 *
 * @author Juan Martin
 */
public class InsumosUtilizadosScreen extends javax.swing.JFrame {
    
   
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null; 
    ResultSet rs2 = null;
    PreparedStatement pst2 = null; 

    /**
     * Creates new form InsumosUtilizadosScreen
     */
    public InsumosUtilizadosScreen() {
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

        jLabel1 = new javax.swing.JLabel();
        identificadorFechaCreacionPanel = new javax.swing.JPanel();
        identificadorLabel = new javax.swing.JLabel();
        identificadorTextField = new javax.swing.JTextField();
        fechaCreacionLabel = new javax.swing.JLabel();
        fechaCreacionDateChooser = new com.toedter.calendar.JDateChooser();
        cargarButton = new javax.swing.JButton();
        buscarLoteButton = new javax.swing.JButton();
        cargarIdentificadorYFechaCreacionButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        insumosLoteTable = new javax.swing.JTable();
        salirButton = new javax.swing.JButton();
        imprimirButton = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Insumos Utilizados");
        setAlwaysOnTop(true);
        setResizable(false);

        identificadorFechaCreacionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingrese el identificador y fecha de creación del lote:"));

        identificadorLabel.setText("Identificador de Lote:");

        identificadorTextField.setPreferredSize(new java.awt.Dimension(150, 20));

        fechaCreacionLabel.setText("Fecha de Creación:");

        cargarButton.setText("Cargar");
        cargarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarButtonActionPerformed(evt);
            }
        });

        buscarLoteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazGrafica/Icons/search_plus.png"))); // NOI18N
        buscarLoteButton.setPreferredSize(new java.awt.Dimension(25, 25));
        buscarLoteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarLoteButtonActionPerformed(evt);
            }
        });

        cargarIdentificadorYFechaCreacionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazGrafica/Icons/add_package.png"))); // NOI18N
        cargarIdentificadorYFechaCreacionButton.setPreferredSize(new java.awt.Dimension(25, 25));
        cargarIdentificadorYFechaCreacionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarIdentificadorYFechaCreacionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout identificadorFechaCreacionPanelLayout = new javax.swing.GroupLayout(identificadorFechaCreacionPanel);
        identificadorFechaCreacionPanel.setLayout(identificadorFechaCreacionPanelLayout);
        identificadorFechaCreacionPanelLayout.setHorizontalGroup(
            identificadorFechaCreacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(identificadorFechaCreacionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(identificadorFechaCreacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(identificadorFechaCreacionPanelLayout.createSequentialGroup()
                        .addComponent(fechaCreacionLabel)
                        .addGap(15, 15, 15)
                        .addComponent(fechaCreacionDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, identificadorFechaCreacionPanelLayout.createSequentialGroup()
                        .addComponent(identificadorLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(identificadorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buscarLoteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cargarIdentificadorYFechaCreacionButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cargarButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        identificadorFechaCreacionPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {fechaCreacionDateChooser, identificadorTextField});

        identificadorFechaCreacionPanelLayout.setVerticalGroup(
            identificadorFechaCreacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(identificadorFechaCreacionPanelLayout.createSequentialGroup()
                .addGroup(identificadorFechaCreacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(identificadorFechaCreacionPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(identificadorFechaCreacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(identificadorFechaCreacionPanelLayout.createSequentialGroup()
                                .addGroup(identificadorFechaCreacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fechaCreacionLabel)
                                    .addComponent(fechaCreacionDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(identificadorFechaCreacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(identificadorLabel)
                                    .addComponent(identificadorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(cargarButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(identificadorFechaCreacionPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(identificadorFechaCreacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscarLoteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(identificadorFechaCreacionPanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(cargarIdentificadorYFechaCreacionButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        insumosLoteTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Insumo", "Cantidad Utilizada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(insumosLoteTable);

        salirButton.setText("Salir");
        salirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirButtonActionPerformed(evt);
            }
        });

        imprimirButton.setText("Imprimir");
        imprimirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(identificadorFechaCreacionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(imprimirButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(salirButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(identificadorFechaCreacionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salirButton)
                    .addComponent(imprimirButton))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(671, 619));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void salirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_salirButtonActionPerformed

    private void imprimirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirButtonActionPerformed
        try{
            insumosLoteTable.print(JTable.PrintMode.FIT_WIDTH);
        }catch(java.awt.print.PrinterException e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error al imprimir", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_imprimirButtonActionPerformed

    private void cargarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarButtonActionPerformed
        identificadorTextField.setEnabled(false);
        fechaCreacionDateChooser.setEnabled(false);
        cargarButton.setEnabled(false);
        if (!identificadorTextField.getText().equals("")){
            if (fechaCreacionDateChooser.getDate() != null){
                try{
                    String sql = "SELECT L_Codigo FROM lotes WHERE L_Identificador=? AND L_FechaCreacion=?";
                    
                    pst = conn.prepareStatement(sql);
                    
                    pst.setString(1, identificadorTextField.getText());
                    
                    // Preparo fecha
                    java.sql.Date fechaCreacionSql = new java.sql.Date(fechaCreacionDateChooser.getDate().getTime());
                    pst.setDate(2, fechaCreacionSql);                      
                    
                    rs = pst.executeQuery();
                    
                    if (rs.next()){
                    
                        String sql2 = "SELECT I_Descripcion_CaracterizadoEn AS \"Insumo\","
                                         + " CantidadUtilizada AS \"Cantidad Utilizada\" "
                                    + "FROM EsUtilizada, StocksMensualesInsumos "
                                    + "WHERE L_Codigo_EsUtilizada = ? AND SM_I_Codigo_EsUtilizada=SM_I_Codigo";
                        pst2 = conn.prepareStatement(sql2);


                        pst2.setInt(1, rs.getInt("L_Codigo"));

                        rs2 = pst2.executeQuery();
                        insumosLoteTable.setModel(DbUtils.resultSetToTableModel(rs2));
                        insumosLoteTable.setEnabled(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "No ingresó información válida.", "Error al mostrar insumos utilizados por lote", JOptionPane.ERROR_MESSAGE);
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this, e, "Error al actualizar tabla de insumos", JOptionPane.ERROR_MESSAGE);
                }                
            }
            else{
                JOptionPane.showMessageDialog(this, "La fecha de creación del lote no puede ser vacía.", "Error al cargar lote", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "El identificador no puede ser vacío.", "Error al cargar lote", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cargarButtonActionPerformed

    private void buscarLoteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarLoteButtonActionPerformed
        JOptionPane.showMessageDialog(this, "Realice la búsqueda del lote, seleccione en la tabla el lote que desea haciendo click en la fila y presiones el botón salir.", "Recuerde", JOptionPane.INFORMATION_MESSAGE);
        BuscarLotesScreen buscarLotesScreen = new BuscarLotesScreen();
        buscarLotesScreen.setVisible(true);
    }//GEN-LAST:event_buscarLoteButtonActionPerformed

    private void cargarIdentificadorYFechaCreacionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarIdentificadorYFechaCreacionButtonActionPerformed
        if (!SGPS.identificadorLote.equals("")){
            int anio = Integer.parseInt(SGPS.fechaCreacionLote.substring(0, 4));
            int mes = Integer.parseInt(SGPS.fechaCreacionLote.substring(5, 7)) - 1; //Para que sea el mes correcto
            int dia = Integer.parseInt(SGPS.fechaCreacionLote.substring(8, 10));
            Calendar fechaIngresada = new GregorianCalendar(anio, mes, dia);

            java.util.Date fecha = new java.util.Date(fechaIngresada.getTimeInMillis());
            java.sql.Date fechaActual = new java.sql.Date(fecha.getTime()); 
            
            //fechaCreacionDateChooser.setDate(fecha);
            fechaCreacionDateChooser.setDate(fechaActual);
            identificadorTextField.setText(SGPS.identificadorLote);
            SGPS.identificadorLote = "";
            SGPS.fechaCreacionLote = "";
        }
    }//GEN-LAST:event_cargarIdentificadorYFechaCreacionButtonActionPerformed

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
            java.util.logging.Logger.getLogger(InsumosUtilizadosScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsumosUtilizadosScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsumosUtilizadosScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsumosUtilizadosScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsumosUtilizadosScreen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarLoteButton;
    private javax.swing.JButton cargarButton;
    private javax.swing.JButton cargarIdentificadorYFechaCreacionButton;
    private com.toedter.calendar.JDateChooser fechaCreacionDateChooser;
    private javax.swing.JLabel fechaCreacionLabel;
    private javax.swing.JPanel identificadorFechaCreacionPanel;
    private javax.swing.JLabel identificadorLabel;
    private javax.swing.JTextField identificadorTextField;
    private javax.swing.JButton imprimirButton;
    private javax.swing.JTable insumosLoteTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton salirButton;
    // End of variables declaration//GEN-END:variables
}
