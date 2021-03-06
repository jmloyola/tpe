/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;

import java.awt.Dialog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import sgps.SGPS;

/**
 *
 * @author Juan
 */
public class ActualizarInformacionEmpleadoScreen extends javax.swing.JFrame {
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    /**
     * Creates new form ActualizarInformacionEmpleadoScreen
     */
    public ActualizarInformacionEmpleadoScreen() {
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

        cancelarButton = new javax.swing.JButton();
        aceptarButton = new javax.swing.JButton();
        numeroLegajoPanel = new javax.swing.JPanel();
        numeroLegajoLabel = new javax.swing.JLabel();
        buscarEmpleadoButton = new javax.swing.JButton();
        numeroLegajoFormattedTextField = new javax.swing.JFormattedTextField();
        cargarButton = new javax.swing.JButton();
        cargarNumeroLegajoButton = new javax.swing.JButton();
        telefonoLabel = new javax.swing.JLabel();
        categoriaLabel = new javax.swing.JLabel();
        sueldoLabel = new javax.swing.JLabel();
        estadoCivilLabel = new javax.swing.JLabel();
        cantidadHijosLabel = new javax.swing.JLabel();
        domicilioLabel = new javax.swing.JLabel();
        paisResidenciaLabel = new javax.swing.JLabel();
        provinciaResidenciaLabel = new javax.swing.JLabel();
        ciudadResidenciaLabel = new javax.swing.JLabel();
        categoriaComboBox = new javax.swing.JComboBox();
        estadoCivilComboBox = new javax.swing.JComboBox();
        domicilioTextField = new javax.swing.JTextField();
        paisResidenciaTextField = new javax.swing.JTextField();
        provinciaResidenciaTextField = new javax.swing.JTextField();
        ciudadResidenciaTextField = new javax.swing.JTextField();
        telefonoFormattedTextField = new javax.swing.JFormattedTextField();
        sueldoFormattedTextField = new javax.swing.JFormattedTextField();
        cantidadHijosFormattedTextField = new javax.swing.JFormattedTextField();
        codigoPostalLabel = new javax.swing.JLabel();
        codigoPostalFormattedTextField = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Actualizar Información Empleado");
        setAlwaysOnTop(true);
        setResizable(false);

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

        numeroLegajoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccione número de legajo del empleado:"));

        numeroLegajoLabel.setText("Número de Legajo:");

        buscarEmpleadoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazGrafica/Icons/search_plus.png"))); // NOI18N
        buscarEmpleadoButton.setToolTipText("En caso que no recuerde el numero de legajo del empleado haga click aqui para buscar el empleado que le interesa");
        buscarEmpleadoButton.setPreferredSize(new java.awt.Dimension(20, 20));
        buscarEmpleadoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarEmpleadoButtonActionPerformed(evt);
            }
        });

        numeroLegajoFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        numeroLegajoFormattedTextField.setPreferredSize(new java.awt.Dimension(120, 20));

        cargarButton.setText("Cargar");
        cargarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarButtonActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cargarButton)
                .addContainerGap())
        );
        numeroLegajoPanelLayout.setVerticalGroup(
            numeroLegajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, numeroLegajoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cargarButton)
                .addContainerGap())
            .addGroup(numeroLegajoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(numeroLegajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cargarNumeroLegajoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(numeroLegajoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(numeroLegajoLabel)
                        .addComponent(buscarEmpleadoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(numeroLegajoFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        telefonoLabel.setText("Teléfono:");

        categoriaLabel.setText("Categoría:");

        sueldoLabel.setText("Sueldo:");

        estadoCivilLabel.setText("Estado Civil:");

        cantidadHijosLabel.setText("Cantidad de Hijos:");

        domicilioLabel.setText("Domicilio:");

        paisResidenciaLabel.setText("País de Residencia:");

        provinciaResidenciaLabel.setText("Provincia de Residencia:");

        ciudadResidenciaLabel.setText("Ciudad de Residencia:");

        categoriaComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Categoría A", "Categoría B", "Categoría A1", "Categoría A2", "Operario Laboratorio Categoría A", "Operario Laboratorio Categoría A1", "Encargado" }));
        categoriaComboBox.setSelectedIndex(-1);

        estadoCivilComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Soltero/a", "Casado/a", "Divorciado/a", "Viudo/a" }));
        estadoCivilComboBox.setSelectedIndex(-1);

        domicilioTextField.setPreferredSize(new java.awt.Dimension(175, 20));

        telefonoFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        sueldoFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        cantidadHijosFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        codigoPostalLabel.setText("Código Postal");

        codigoPostalFormattedTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(aceptarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelarButton))
                    .addComponent(numeroLegajoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telefonoLabel)
                            .addComponent(categoriaLabel)
                            .addComponent(sueldoLabel)
                            .addComponent(domicilioLabel)
                            .addComponent(estadoCivilLabel)
                            .addComponent(cantidadHijosLabel)
                            .addComponent(ciudadResidenciaLabel)
                            .addComponent(paisResidenciaLabel)
                            .addComponent(provinciaResidenciaLabel)
                            .addComponent(codigoPostalLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codigoPostalFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paisResidenciaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(provinciaResidenciaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ciudadResidenciaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(domicilioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cantidadHijosFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(estadoCivilComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sueldoFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categoriaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefonoFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cantidadHijosFormattedTextField, categoriaComboBox, ciudadResidenciaTextField, codigoPostalFormattedTextField, domicilioTextField, estadoCivilComboBox, paisResidenciaTextField, provinciaResidenciaTextField, sueldoFormattedTextField, telefonoFormattedTextField});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(numeroLegajoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonoLabel)
                    .addComponent(telefonoFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoriaLabel)
                    .addComponent(categoriaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sueldoLabel)
                    .addComponent(sueldoFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estadoCivilLabel)
                    .addComponent(estadoCivilComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidadHijosLabel)
                    .addComponent(cantidadHijosFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(domicilioLabel)
                    .addComponent(domicilioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoPostalLabel)
                    .addComponent(codigoPostalFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paisResidenciaLabel)
                    .addComponent(paisResidenciaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(provinciaResidenciaLabel)
                    .addComponent(provinciaResidenciaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ciudadResidenciaLabel)
                    .addComponent(ciudadResidenciaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarButton)
                    .addComponent(aceptarButton))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(406, 465));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void buscarEmpleadoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarEmpleadoButtonActionPerformed
        JOptionPane.showMessageDialog(this, "Realice la búsqueda de empleado, seleccione en la tabla el empleado que desea haciendo click en la fila y presiones el botón salir.", "Recuerde", JOptionPane.INFORMATION_MESSAGE);
        BuscarEmpleadosScreen buscarEmpleadosScreen = new BuscarEmpleadosScreen();
        buscarEmpleadosScreen.setVisible(true);
        
        // TODO PENSAR EN METODO PARA QUE SE ESPERE A QUE CIERRE VENTANA
        /*
        if (SGPS.numeroLegajoEmpleado != -1){
            JOptionPane.showMessageDialog(this, SGPS.numeroLegajoEmpleado);
            numeroLegajoFormattedTextField.setValue(SGPS.numeroLegajoEmpleado);
            SGPS.numeroLegajoEmpleado = -1;
        }*/
    }//GEN-LAST:event_buscarEmpleadoButtonActionPerformed

    private void cargarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarButtonActionPerformed
        if (!numeroLegajoFormattedTextField.getText().equals("")){
            
            try{
                String sql = "SELECT e_telefono, e_sueldo, e_estadocivil, e_cantidadhijos, e_domicilio, e_codigopostal, e_paisresidencia, e_provinciaresidencia, e_ciudadresidencia, e_categoria FROM empleados WHERE e_numerolegajo=? AND E_Estado <> 'Despedido'";
                pst = conn.prepareStatement(sql);


                pst.setInt(1, Integer.parseInt(numeroLegajoFormattedTextField.getText()));

                rs = pst.executeQuery();
                
                if (rs.next()){
                    telefonoFormattedTextField.setValue(rs.getLong("e_telefono"));
                    
                    if (rs.getString("e_categoria").equals("Categoria A")){
                        categoriaComboBox.setSelectedIndex(0);
                    }
                    if (rs.getString("e_categoria").equals("Categoria B")){
                        categoriaComboBox.setSelectedIndex(1);
                    }
                    if (rs.getString("e_categoria").equals("Categoria A1")){
                        categoriaComboBox.setSelectedIndex(2);
                    }
                    if (rs.getString("e_categoria").equals("Categoria A2")){
                        categoriaComboBox.setSelectedIndex(3);
                    }
                    if (rs.getString("e_categoria").equals("Operario Laboratorio Categoria A")){
                        categoriaComboBox.setSelectedIndex(4);
                    }
                    if (rs.getString("e_categoria").equals("Operario Laboratorio Categoria A1")){
                        categoriaComboBox.setSelectedIndex(5);
                    }
                    if (rs.getString("e_categoria").equals("Encargado")){
                        categoriaComboBox.setSelectedIndex(6);
                    }
                    
                    sueldoFormattedTextField.setValue(rs.getFloat("e_sueldo"));
                    
                    if (rs.getString("e_estadocivil").equals("Soltero")){
                        estadoCivilComboBox.setSelectedIndex(0);
                    }
                    if (rs.getString("e_estadocivil").equals("Casado")){
                        estadoCivilComboBox.setSelectedIndex(1);
                    }
                    if (rs.getString("e_estadocivil").equals("Divorciado")){
                        estadoCivilComboBox.setSelectedIndex(2);
                    }
                    if (rs.getString("e_estadocivil").equals("Viudo")){
                        estadoCivilComboBox.setSelectedIndex(3);
                    }
                    
                    cantidadHijosFormattedTextField.setValue(rs.getInt("e_cantidadHijos"));
                    domicilioTextField.setText(rs.getString("e_domicilio"));
                    paisResidenciaTextField.setText(rs.getString("e_paisresidencia"));
                    provinciaResidenciaTextField.setText(rs.getString("e_provinciaresidencia"));
                    ciudadResidenciaTextField.setText(rs.getString("e_ciudadresidencia"));
                    codigoPostalFormattedTextField.setValue(rs.getInt("e_codigopostal"));
                }
                else{
                    JOptionPane.showMessageDialog(this, "El numero de legajo ingresado no se corresponde con el de ningún empleado activo, de licencia o sancionado.", "Error al cargar informacion del empleado", JOptionPane.ERROR_MESSAGE);
                }
                
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error al cargar informacion del empleado", JOptionPane.ERROR_MESSAGE);
            }
            numeroLegajoFormattedTextField.setEnabled(false);
        }
        else{
            JOptionPane.showMessageDialog(this, "El numero de legajo no puede ser vacio.", "Error al actualizar informacion del empleado", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_cargarButtonActionPerformed

    private void cargarNumeroLegajoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarNumeroLegajoButtonActionPerformed
        if (SGPS.numeroLegajoEmpleado != -1){
            numeroLegajoFormattedTextField.setValue(SGPS.numeroLegajoEmpleado);
            SGPS.numeroLegajoEmpleado = -1;
        } 
    }//GEN-LAST:event_cargarNumeroLegajoButtonActionPerformed

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        if (!telefonoFormattedTextField.getText().equals("")){
            if (!sueldoFormattedTextField.getText().equals("")){
                if (!cantidadHijosFormattedTextField.getText().equals("")){
                    if (!domicilioTextField.getText().equals("")){
                        if (!paisResidenciaTextField.getText().equals("")){
                            if (!provinciaResidenciaTextField.getText().equals("")){
                                if (!ciudadResidenciaTextField.getText().equals("")){
                                    if (!codigoPostalFormattedTextField.getText().equals("")){
                                        try{
                                            String sql = "UPDATE empleados SET e_telefono=?, e_sueldo=?, e_estadocivil=?, e_cantidadhijos=?, e_domicilio=?, e_codigopostal=?, e_paisresidencia=?, e_provinciaresidencia=?, e_ciudadresidencia=?, e_categoria=? WHERE e_numerolegajo=?;";
                                            pst = conn.prepareStatement(sql);


                                            pst.setLong(1, Long.parseLong(telefonoFormattedTextField.getText()));
                                            pst.setFloat(2, ((Number)sueldoFormattedTextField.getValue()).floatValue());

                                            switch (estadoCivilComboBox.getSelectedIndex()){
                                                case 0:
                                                    pst.setString(3, "Soltero");
                                                    break;
                                                case 1:
                                                    pst.setString(3, "Casado");
                                                    break;
                                                case 2:
                                                    pst.setString(3, "Divorciado");
                                                    break;
                                                case 3:
                                                    pst.setString(3, "Viudo");
                                                    break;
                                            }

                                            pst.setInt(4, Integer.parseInt(cantidadHijosFormattedTextField.getText()));
                                            pst.setString(5, domicilioTextField.getText().toUpperCase());
                                            pst.setInt(6, Integer.parseInt(codigoPostalFormattedTextField.getText()));
                                            pst.setString(7, paisResidenciaTextField.getText().toUpperCase());
                                            pst.setString(8, provinciaResidenciaTextField.getText().toUpperCase());
                                            pst.setString(9, ciudadResidenciaTextField.getText().toUpperCase());
                                            
                                            switch (categoriaComboBox.getSelectedIndex()){
                                                case 0:
                                                    pst.setString(10, "Categoria A");
                                                    break;
                                                case 1:
                                                    pst.setString(10, "Categoria B");
                                                    break;
                                                case 2:
                                                    pst.setString(10, "Categoria A1");
                                                    break;
                                                case 3:
                                                    pst.setString(10, "Categoria A2");
                                                    break;
                                                case 4:
                                                    pst.setString(10, "Operario Laboratorio Categoria A");
                                                    break;
                                                case 5:
                                                    pst.setString(10, "Operario Laboratorio Categoria A1");
                                                    break;
                                                case 6:
                                                    pst.setString(10, "Encargado");
                                                    break;
                                            }
                                            
                                            pst.setInt(11, Integer.parseInt(numeroLegajoFormattedTextField.getText()));

                                            pst.execute();
                                            JOptionPane.showMessageDialog(this, "Actualización de información de empleado realizada exitosamente.", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
                                            this.dispose();
                                        }catch(Exception e){
                                            JOptionPane.showMessageDialog(this, e.getMessage(), "Error al actualizar la información del empleado", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(this, "El código postal del empleado no puede ser vacío.", "Error al actualizar información del empleado", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                                else{
                                    JOptionPane.showMessageDialog(this, "La ciudad de residencia del empleado no puede ser vacía.", "Error al actualizar información del empleado", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(this, "La provincia de residencia del empleado no puede ser vacía.", "Error al actualizar información del empleado", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(this, "El país de residencia del empleado no puede ser vacío.", "Error al actualizar información del empleado", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "El domicilio del empleado no puede ser vacío.", "Error al actualizar información del empleado", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(this, "La cantidad de hijos del empleado no puede ser vacía.", "Error al actualizar información del empleado", JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "El sueldo del empleado no puede ser vacío.", "Error al actualizar información del empleado", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "El numero de telefono del empleado no puede ser vacío.", "Error al actualizar información del empleado", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(ActualizarInformacionEmpleadoScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActualizarInformacionEmpleadoScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActualizarInformacionEmpleadoScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActualizarInformacionEmpleadoScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActualizarInformacionEmpleadoScreen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JButton buscarEmpleadoButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JFormattedTextField cantidadHijosFormattedTextField;
    private javax.swing.JLabel cantidadHijosLabel;
    private javax.swing.JButton cargarButton;
    private javax.swing.JButton cargarNumeroLegajoButton;
    private javax.swing.JComboBox categoriaComboBox;
    private javax.swing.JLabel categoriaLabel;
    private javax.swing.JLabel ciudadResidenciaLabel;
    private javax.swing.JTextField ciudadResidenciaTextField;
    private javax.swing.JFormattedTextField codigoPostalFormattedTextField;
    private javax.swing.JLabel codigoPostalLabel;
    private javax.swing.JLabel domicilioLabel;
    private javax.swing.JTextField domicilioTextField;
    private javax.swing.JComboBox estadoCivilComboBox;
    private javax.swing.JLabel estadoCivilLabel;
    private javax.swing.JFormattedTextField numeroLegajoFormattedTextField;
    private javax.swing.JLabel numeroLegajoLabel;
    private javax.swing.JPanel numeroLegajoPanel;
    private javax.swing.JLabel paisResidenciaLabel;
    private javax.swing.JTextField paisResidenciaTextField;
    private javax.swing.JLabel provinciaResidenciaLabel;
    private javax.swing.JTextField provinciaResidenciaTextField;
    private javax.swing.JFormattedTextField sueldoFormattedTextField;
    private javax.swing.JLabel sueldoLabel;
    private javax.swing.JFormattedTextField telefonoFormattedTextField;
    private javax.swing.JLabel telefonoLabel;
    // End of variables declaration//GEN-END:variables
}
