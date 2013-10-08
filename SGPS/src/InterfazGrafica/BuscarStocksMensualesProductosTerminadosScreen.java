/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;

/**
 *
 * @author Juan
 */
public class BuscarStocksMensualesProductosTerminadosScreen extends javax.swing.JFrame {

    /**
     * Creates new form BuscarStocksMensualesProductosTerminadosScreen
     */
    public BuscarStocksMensualesProductosTerminadosScreen() {
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

        parametroABuscarPanel = new javax.swing.JPanel();
        parametroLabel = new javax.swing.JLabel();
        valorLabel = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        buscarStocksMensualesProductosTerminadosButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        stocksMensualesProductosTerminadosTable = new javax.swing.JTable();
        salirButton = new javax.swing.JButton();
        aceptarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Buscar Stocks Mensuales Productos Terminados");
        setAlwaysOnTop(true);
        setResizable(false);

        parametroABuscarPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingrese el parametro y el valor por el que buscar:"));

        parametroLabel.setText("Parametro:");

        valorLabel.setText("Valor:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Codificacion", "Fecha", "Inicio", "Ingreso", "Egreso", "Cantidad Calculada", "Cantidad Real", "Diferencia" }));
        jComboBox1.setSelectedIndex(-1);

        jTextField1.setPreferredSize(new java.awt.Dimension(150, 20));

        buscarStocksMensualesProductosTerminadosButton.setText("Buscar");
        buscarStocksMensualesProductosTerminadosButton.setPreferredSize(new java.awt.Dimension(65, 60));

        javax.swing.GroupLayout parametroABuscarPanelLayout = new javax.swing.GroupLayout(parametroABuscarPanel);
        parametroABuscarPanel.setLayout(parametroABuscarPanelLayout);
        parametroABuscarPanelLayout.setHorizontalGroup(
            parametroABuscarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parametroABuscarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(parametroABuscarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(parametroLabel)
                    .addComponent(valorLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(parametroABuscarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarStocksMensualesProductosTerminadosButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        parametroABuscarPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jComboBox1, jTextField1});

        parametroABuscarPanelLayout.setVerticalGroup(
            parametroABuscarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parametroABuscarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(parametroABuscarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(parametroABuscarPanelLayout.createSequentialGroup()
                        .addGroup(parametroABuscarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(parametroLabel)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(parametroABuscarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(valorLabel)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(buscarStocksMensualesProductosTerminadosButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        stocksMensualesProductosTerminadosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codificacion", "Fecha", "Inicio", "Ingreso", "Egreso", "Cantidad Calculada", "Cantidad Real", "Diferencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(stocksMensualesProductosTerminadosTable);

        salirButton.setText("Salir");

        aceptarButton.setText("Aceptar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(parametroABuscarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(aceptarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(salirButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(parametroABuscarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salirButton)
                    .addComponent(aceptarButton))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(747, 636));
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
            java.util.logging.Logger.getLogger(BuscarStocksMensualesProductosTerminadosScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarStocksMensualesProductosTerminadosScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarStocksMensualesProductosTerminadosScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarStocksMensualesProductosTerminadosScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarStocksMensualesProductosTerminadosScreen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JButton buscarStocksMensualesProductosTerminadosButton;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel parametroABuscarPanel;
    private javax.swing.JLabel parametroLabel;
    private javax.swing.JButton salirButton;
    private javax.swing.JTable stocksMensualesProductosTerminadosTable;
    private javax.swing.JLabel valorLabel;
    // End of variables declaration//GEN-END:variables
}
