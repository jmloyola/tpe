/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazGrafica;

/**
 *
 * @author Juan
 */

import java.sql.*;
import java.util.Calendar;
import javax.swing.JOptionPane;
import sgps.SGPS;
import net.proteanit.sql.DbUtils;

public class MainScreen extends javax.swing.JFrame {
    
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        initComponents();
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error en conexion", JOptionPane.ERROR_MESSAGE);
        }
        usuarioActualLabel.setText("Usuario: " + SGPS.identificadorUsuarioActual);
        updateEtapasTable();
        updateEmpleadosTable();
        updateInsumosTable();
        updateProductosTerminadosTable();
        updateLotesTable();
    }
    
    public void updateEtapasTable(){
        try{
            String sql = "SELECT etapa_descripcion AS \"Descripcion\" FROM Etapas";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            etapasTable.setModel(DbUtils.resultSetToTableModel(rs));
            etapasTable.setEnabled(false);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e, "Error al Actualizar Tabla de Etapas", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateEmpleadosTable(){
        try{
            String sql = "SELECT e_nombre AS \"Nombre\","
                              + "e_dni AS \"DNI\","
                              + "e_telefono AS \"Telefono\","
                              + "e_fechaingreso AS \"Fecha Ingreso\","
                              + "e_numerolegajo AS \"Numero Legajo\","
                              + "e_sueldo AS \"Sueldo\","
                              + "e_cuil AS \"CUIL\","
                              + "e_estadocivil AS \"Estado Civil\","
                              + "e_cantidadhijos AS \"Cantidad Hijos\","
                              + "e_domicilio AS \"Domicilio\","
                              + "e_codigopostal AS \"Codigo Postal\","
                              + "e_paisresidencia AS \"Pais Residencia\","
                              + "e_provinciaresidencia AS \"Provincia Residencia\","
                              + "e_ciudadresidencia AS \"Ciudad Residencia\","
                              + "e_categoria AS \"Categoria\","
                              + "e_estado AS \"Estado\" FROM empleados";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            empleadosTable.setModel(DbUtils.resultSetToTableModel(rs));
            empleadosTable.setEnabled(false);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e, "Error al Actualizar Tabla de Empleados", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateInsumosTable(){
        try{
            String sql = "SELECT I_Descripcion_CaracterizadoEn AS \"Descripcion\","
                             + " SM_I_Inicio AS \"Inicio\","
                             + " SM_I_Ingreso AS \"Ingreso\","
                             + " SM_I_Egreso AS \"Egreso\","
                             + " SM_I_CantidadCalculada AS \"Cantidad Calculada\","
                             + " SM_I_CantidadReal AS \"Cantidad Real\","
                             + " SM_I_Diferencia AS \"Diferencia\" "
                        + "FROM StocksMensualesInsumos "
                        + "WHERE SM_I_Fecha = ?";
            pst = conn.prepareStatement(sql);
            
            Calendar calendarioActual = Calendar.getInstance();
            calendarioActual.set(Calendar.DAY_OF_MONTH, 1);
                                    
            java.util.Date today = new java.util.Date(calendarioActual.getTimeInMillis());
            java.sql.Date fechaActual = new java.sql.Date(today.getTime());
            
            pst.setDate(1,fechaActual);
            
            rs = pst.executeQuery();
            insumosTable.setModel(DbUtils.resultSetToTableModel(rs));
            insumosTable.setEnabled(false);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e, "Error al Actualizar Tabla de Insumos", JOptionPane.ERROR_MESSAGE);
        }
    }
        
     
    public void updateProductosTerminadosTable(){
        try{
            String sql = "SELECT PT_Codificacion_CaracterizadoEn_PT AS \"Codificacion\","
                             + " SM_PT_Inicio AS \"Inicio\","
                             + " SM_PT_Ingreso AS \"Ingreso\","
                             + " SM_PT_Egreso AS \"Egreso\","
                             + " SM_PT_CantidadCalculada AS \"Cantidad Calculada\","
                             + " SM_PT_CantidadReal AS \"Cantidad Real\","
                             + " SM_PT_Diferencia AS \"Diferencia\" "
                        + "FROM StocksMensualesProductosTerminados "
                        + "WHERE SM_PT_Fecha = ?";
            pst = conn.prepareStatement(sql);
            
            Calendar calendarioActual = Calendar.getInstance();
            calendarioActual.set(Calendar.DAY_OF_MONTH, 1);
                                    
            java.util.Date today = new java.util.Date(calendarioActual.getTimeInMillis());
            java.sql.Date fechaActual = new java.sql.Date(today.getTime());
            
            pst.setDate(1,fechaActual);
            
            rs = pst.executeQuery();
            productosTerminadosTable.setModel(DbUtils.resultSetToTableModel(rs));
            productosTerminadosTable.setEnabled(false);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e, "Error al Actualizar Tabla de Insumos", JOptionPane.ERROR_MESSAGE);
        }
    }
        
    public void updateLotesTable(){
        try{
            String sql = "SELECT L_Identificador AS \"Identificador\","
                             + " L_FechaCreacion AS \"Fecha Creacion\","
                             + " L_CantidadDescarteUtilizado AS \"Cantidad Descarte Utilizada\" "
                        + "FROM Lotes "
                        + "WHERE L_Estado = ?";
            pst = conn.prepareStatement(sql);
            
            
            pst.setInt(1, 0); //Lotes en procesamiento
            
            rs = pst.executeQuery();
            lotesTable.setModel(DbUtils.resultSetToTableModel(rs));
            lotesTable.setEnabled(false);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e, "Error al Actualizar Tabla de Insumos", JOptionPane.ERROR_MESSAGE);
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

        usuarioActualLabel = new javax.swing.JLabel();
        solapasTabbedPane = new javax.swing.JTabbedPane();
        solapaLotesPane = new javax.swing.JPanel();
        actualizarTablaSolapaLotesButton = new javax.swing.JButton();
        tablaSolapaLotesScrollPane = new javax.swing.JScrollPane();
        lotesTable = new javax.swing.JTable();
        imprimirLotesButton = new javax.swing.JButton();
        solapaInsumosPane = new javax.swing.JPanel();
        actualizarTablaSolapaInsumosButton = new javax.swing.JButton();
        tablaSolapaInsumosScrollPane = new javax.swing.JScrollPane();
        insumosTable = new javax.swing.JTable();
        imprimirInsumosButton = new javax.swing.JButton();
        solapaProductosTerminadosPane = new javax.swing.JPanel();
        actualizarTablaSolapaProductosTerminadosButton = new javax.swing.JButton();
        tablaSolapaProductosTerminadosScrollPane = new javax.swing.JScrollPane();
        productosTerminadosTable = new javax.swing.JTable();
        imprimirProductosTerminadosButton = new javax.swing.JButton();
        solapaEmpleadosPane = new javax.swing.JPanel();
        actualizarTablaSolapaEmpleadosButton = new javax.swing.JButton();
        tablaSolapaEmpleadosScrollPane = new javax.swing.JScrollPane();
        empleadosTable = new javax.swing.JTable();
        imprimirEmpleadosButton = new javax.swing.JButton();
        solapaEtapasPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        etapasTable = new javax.swing.JTable();
        actualizarEtapasButton = new javax.swing.JButton();
        imprimirEtapasButton = new javax.swing.JButton();
        mainScreenMenuBar = new javax.swing.JMenuBar();
        archivoMenu = new javax.swing.JMenu();
        exportarMenuItem = new javax.swing.JMenuItem();
        separadoreEntreExportarYEsquemas = new javax.swing.JPopupMenu.Separator();
        empleadosMenu = new javax.swing.JMenu();
        nuevoEmpleadoMenuItem = new javax.swing.JMenuItem();
        actualizarInformacionEmpleadoMenuItem = new javax.swing.JMenuItem();
        buscarEmpleadosMenuItem = new javax.swing.JMenuItem();
        darBajaEmpleadoMenuItem = new javax.swing.JMenuItem();
        nuevoAccidenteMenuItem = new javax.swing.JMenuItem();
        nuevaSancionMenuItem = new javax.swing.JMenuItem();
        nuevoPremioMenuItem = new javax.swing.JMenuItem();
        usuariosSistemaMenu = new javax.swing.JMenu();
        nuevoUsuarioSistemaMenuItem = new javax.swing.JMenuItem();
        darBajaUsuarioSistemaMenuItem = new javax.swing.JMenuItem();
        proveedoresMenu = new javax.swing.JMenu();
        nuevoProveedorMenuItem = new javax.swing.JMenuItem();
        actualizarInformacionProveedorMenuItem = new javax.swing.JMenuItem();
        darBajaProveedorMenuItem = new javax.swing.JMenuItem();
        insumosMenu = new javax.swing.JMenu();
        nuevoInsumoMenuItem = new javax.swing.JMenuItem();
        actualizarInformacionInsumoMenuItem = new javax.swing.JMenuItem();
        buscarInsumosMenuItem = new javax.swing.JMenuItem();
        darBajaInsumoMenuItem = new javax.swing.JMenuItem();
        productosTerminadosMenu = new javax.swing.JMenu();
        nuevoProductoTerminadoMenuItem = new javax.swing.JMenuItem();
        buscarProductosTerminadosMenuItem = new javax.swing.JMenuItem();
        darBajaProductoTerminadoMenuItem = new javax.swing.JMenuItem();
        despacharProductoTerminadoMenuItem = new javax.swing.JMenuItem();
        descartesMenu = new javax.swing.JMenu();
        buscarDescartesMensualesMenuItem = new javax.swing.JMenuItem();
        etapasMenu = new javax.swing.JMenu();
        nuevaEtapaMenuItem = new javax.swing.JMenuItem();
        darBajaEtapaMenuItem = new javax.swing.JMenuItem();
        lotesMenu = new javax.swing.JMenu();
        nuevoLoteMenuItem = new javax.swing.JMenuItem();
        actualizarInformacionLoteMenuItem = new javax.swing.JMenuItem();
        buscarLotesMenuItem = new javax.swing.JMenuItem();
        stocksMensualesInsumosMenu = new javax.swing.JMenu();
        buscarStocksMensualesInsumosMenuItem = new javax.swing.JMenuItem();
        stocksMensualesProductosTerminadosMenu = new javax.swing.JMenu();
        buscarStocksMensualesProductosTerminadosMenuItem = new javax.swing.JMenuItem();
        analisisMenu = new javax.swing.JMenu();
        nuevoAnalisisMenuItem = new javax.swing.JMenuItem();
        buscarAnalisisMenuItem = new javax.swing.JMenuItem();
        separadorEntreEsquemasYCerrarSesion = new javax.swing.JPopupMenu.Separator();
        cerrarSesionMenuItem = new javax.swing.JMenuItem();
        editarMenu = new javax.swing.JMenu();
        preferenciasMenuItem = new javax.swing.JMenuItem();
        procesosMenu = new javax.swing.JMenu();
        seEncuentraMenuItem = new javax.swing.JMenuItem();
        proveeInsumosMenuItem = new javax.swing.JMenuItem();
        esUtilizadaMenuItem = new javax.swing.JMenuItem();
        produceMenuItem = new javax.swing.JMenuItem();
        ayudaMenu = new javax.swing.JMenu();
        acercaDeMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Sistema de Gestion de Produccion y Stock");
        setMinimumSize(new java.awt.Dimension(800, 600));

        usuarioActualLabel.setText("Usuario: ");

        actualizarTablaSolapaLotesButton.setText("Actualizar");
        actualizarTablaSolapaLotesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarTablaSolapaLotesButtonActionPerformed(evt);
            }
        });

        lotesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaSolapaLotesScrollPane.setViewportView(lotesTable);

        imprimirLotesButton.setText("Imprimir");

        javax.swing.GroupLayout solapaLotesPaneLayout = new javax.swing.GroupLayout(solapaLotesPane);
        solapaLotesPane.setLayout(solapaLotesPaneLayout);
        solapaLotesPaneLayout.setHorizontalGroup(
            solapaLotesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(solapaLotesPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(solapaLotesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tablaSolapaLotesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                    .addGroup(solapaLotesPaneLayout.createSequentialGroup()
                        .addComponent(imprimirLotesButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(actualizarTablaSolapaLotesButton)))
                .addContainerGap())
        );
        solapaLotesPaneLayout.setVerticalGroup(
            solapaLotesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, solapaLotesPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tablaSolapaLotesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(solapaLotesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actualizarTablaSolapaLotesButton)
                    .addComponent(imprimirLotesButton))
                .addContainerGap())
        );

        solapasTabbedPane.addTab("Lotes", solapaLotesPane);

        actualizarTablaSolapaInsumosButton.setText("Actualizar");
        actualizarTablaSolapaInsumosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarTablaSolapaInsumosButtonActionPerformed(evt);
            }
        });

        insumosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Descripcion", "Inicio", "Ingreso", "Egreso", "Cantidad Calculada", "Cantidad Real", "Diferencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaSolapaInsumosScrollPane.setViewportView(insumosTable);

        imprimirInsumosButton.setText("Imprimir");

        javax.swing.GroupLayout solapaInsumosPaneLayout = new javax.swing.GroupLayout(solapaInsumosPane);
        solapaInsumosPane.setLayout(solapaInsumosPaneLayout);
        solapaInsumosPaneLayout.setHorizontalGroup(
            solapaInsumosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(solapaInsumosPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(solapaInsumosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tablaSolapaInsumosScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                    .addGroup(solapaInsumosPaneLayout.createSequentialGroup()
                        .addComponent(imprimirInsumosButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(actualizarTablaSolapaInsumosButton)))
                .addContainerGap())
        );
        solapaInsumosPaneLayout.setVerticalGroup(
            solapaInsumosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, solapaInsumosPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tablaSolapaInsumosScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(solapaInsumosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actualizarTablaSolapaInsumosButton)
                    .addComponent(imprimirInsumosButton))
                .addContainerGap())
        );

        solapasTabbedPane.addTab("Insumos", solapaInsumosPane);

        actualizarTablaSolapaProductosTerminadosButton.setText("Actualizar");
        actualizarTablaSolapaProductosTerminadosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarTablaSolapaProductosTerminadosButtonActionPerformed(evt);
            }
        });

        productosTerminadosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo Producto Terminado", "Inicio", "Ingreso", "Egreso", "Cantidad Calculada", "Cantidad Real", "Diferencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaSolapaProductosTerminadosScrollPane.setViewportView(productosTerminadosTable);

        imprimirProductosTerminadosButton.setText("Imprimir");

        javax.swing.GroupLayout solapaProductosTerminadosPaneLayout = new javax.swing.GroupLayout(solapaProductosTerminadosPane);
        solapaProductosTerminadosPane.setLayout(solapaProductosTerminadosPaneLayout);
        solapaProductosTerminadosPaneLayout.setHorizontalGroup(
            solapaProductosTerminadosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(solapaProductosTerminadosPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(solapaProductosTerminadosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tablaSolapaProductosTerminadosScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                    .addGroup(solapaProductosTerminadosPaneLayout.createSequentialGroup()
                        .addComponent(imprimirProductosTerminadosButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(actualizarTablaSolapaProductosTerminadosButton)))
                .addContainerGap())
        );
        solapaProductosTerminadosPaneLayout.setVerticalGroup(
            solapaProductosTerminadosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, solapaProductosTerminadosPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tablaSolapaProductosTerminadosScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(solapaProductosTerminadosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actualizarTablaSolapaProductosTerminadosButton)
                    .addComponent(imprimirProductosTerminadosButton))
                .addContainerGap())
        );

        solapasTabbedPane.addTab("Procutos Terminados", solapaProductosTerminadosPane);

        actualizarTablaSolapaEmpleadosButton.setText("Actualizar");
        actualizarTablaSolapaEmpleadosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarTablaSolapaEmpleadosButtonActionPerformed(evt);
            }
        });

        empleadosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "DNI", "Telefono", "Fecha de Ingreso", "Numero de Legajo", "Sueldo", "CUIL", "Estado Civil", "Cantidad de Hijos", "Domicilio", "Codigo Postal", "Pais de Residencia", "Provincia de Residencia", "Ciudad de Residencia", "Categoria", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaSolapaEmpleadosScrollPane.setViewportView(empleadosTable);

        imprimirEmpleadosButton.setText("Imprimir");

        javax.swing.GroupLayout solapaEmpleadosPaneLayout = new javax.swing.GroupLayout(solapaEmpleadosPane);
        solapaEmpleadosPane.setLayout(solapaEmpleadosPaneLayout);
        solapaEmpleadosPaneLayout.setHorizontalGroup(
            solapaEmpleadosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(solapaEmpleadosPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(solapaEmpleadosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tablaSolapaEmpleadosScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                    .addGroup(solapaEmpleadosPaneLayout.createSequentialGroup()
                        .addComponent(imprimirEmpleadosButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(actualizarTablaSolapaEmpleadosButton)))
                .addContainerGap())
        );
        solapaEmpleadosPaneLayout.setVerticalGroup(
            solapaEmpleadosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, solapaEmpleadosPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tablaSolapaEmpleadosScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(solapaEmpleadosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actualizarTablaSolapaEmpleadosButton)
                    .addComponent(imprimirEmpleadosButton))
                .addContainerGap())
        );

        solapasTabbedPane.addTab("Empleados", solapaEmpleadosPane);

        etapasTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(etapasTable);

        actualizarEtapasButton.setText("Actualizar");
        actualizarEtapasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarEtapasButtonActionPerformed(evt);
            }
        });

        imprimirEtapasButton.setText("Imprimir");

        javax.swing.GroupLayout solapaEtapasPanelLayout = new javax.swing.GroupLayout(solapaEtapasPanel);
        solapaEtapasPanel.setLayout(solapaEtapasPanelLayout);
        solapaEtapasPanelLayout.setHorizontalGroup(
            solapaEtapasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(solapaEtapasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(solapaEtapasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                    .addGroup(solapaEtapasPanelLayout.createSequentialGroup()
                        .addComponent(imprimirEtapasButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(actualizarEtapasButton)))
                .addContainerGap())
        );
        solapaEtapasPanelLayout.setVerticalGroup(
            solapaEtapasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(solapaEtapasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(solapaEtapasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actualizarEtapasButton)
                    .addComponent(imprimirEtapasButton))
                .addContainerGap())
        );

        solapasTabbedPane.addTab("Etapas", solapaEtapasPanel);

        archivoMenu.setText("Archivo");

        exportarMenuItem.setText("Exportar");
        exportarMenuItem.setEnabled(false);
        archivoMenu.add(exportarMenuItem);
        archivoMenu.add(separadoreEntreExportarYEsquemas);

        empleadosMenu.setText("Empleados");

        nuevoEmpleadoMenuItem.setText("Nuevo Empleado");
        empleadosMenu.add(nuevoEmpleadoMenuItem);

        actualizarInformacionEmpleadoMenuItem.setText("Actualizar Informacion Empleado");
        empleadosMenu.add(actualizarInformacionEmpleadoMenuItem);

        buscarEmpleadosMenuItem.setText("Buscar Empleados");
        empleadosMenu.add(buscarEmpleadosMenuItem);

        darBajaEmpleadoMenuItem.setText("Dar de Baja Empleado");
        empleadosMenu.add(darBajaEmpleadoMenuItem);

        nuevoAccidenteMenuItem.setText("Nuevo Accidente");
        nuevoAccidenteMenuItem.setEnabled(false);
        empleadosMenu.add(nuevoAccidenteMenuItem);

        nuevaSancionMenuItem.setText("Nueva Sancion");
        nuevaSancionMenuItem.setEnabled(false);
        empleadosMenu.add(nuevaSancionMenuItem);

        nuevoPremioMenuItem.setText("Nuevo Premio");
        nuevoPremioMenuItem.setEnabled(false);
        empleadosMenu.add(nuevoPremioMenuItem);

        archivoMenu.add(empleadosMenu);

        usuariosSistemaMenu.setText("Usuarios del Sistema");

        nuevoUsuarioSistemaMenuItem.setText("Nuevo Usuario del Sistema");
        usuariosSistemaMenu.add(nuevoUsuarioSistemaMenuItem);

        darBajaUsuarioSistemaMenuItem.setText("Dar de Baja Usuario del Sistema");
        usuariosSistemaMenu.add(darBajaUsuarioSistemaMenuItem);

        archivoMenu.add(usuariosSistemaMenu);

        proveedoresMenu.setText("Proveedores");

        nuevoProveedorMenuItem.setText("Nuevo Proveedor");
        proveedoresMenu.add(nuevoProveedorMenuItem);

        actualizarInformacionProveedorMenuItem.setText("Actualizar Informacion Proveedor");
        proveedoresMenu.add(actualizarInformacionProveedorMenuItem);

        darBajaProveedorMenuItem.setText("Dar de Baja Proveedor");
        proveedoresMenu.add(darBajaProveedorMenuItem);

        archivoMenu.add(proveedoresMenu);

        insumosMenu.setText("Insumos");

        nuevoInsumoMenuItem.setText("Nuevo Insumo");
        insumosMenu.add(nuevoInsumoMenuItem);

        actualizarInformacionInsumoMenuItem.setText("Actualizar Informacion Insumo");
        insumosMenu.add(actualizarInformacionInsumoMenuItem);

        buscarInsumosMenuItem.setText("Buscar Insumos");
        insumosMenu.add(buscarInsumosMenuItem);

        darBajaInsumoMenuItem.setText("Dar de Baja Insumo");
        insumosMenu.add(darBajaInsumoMenuItem);

        archivoMenu.add(insumosMenu);

        productosTerminadosMenu.setText("Productos Terminados");

        nuevoProductoTerminadoMenuItem.setText("Nuevo Producto Terminado");
        productosTerminadosMenu.add(nuevoProductoTerminadoMenuItem);

        buscarProductosTerminadosMenuItem.setText("Buscar Productos Terminados");
        productosTerminadosMenu.add(buscarProductosTerminadosMenuItem);

        darBajaProductoTerminadoMenuItem.setText("Dar de Baja Producto Terminado");
        productosTerminadosMenu.add(darBajaProductoTerminadoMenuItem);

        despacharProductoTerminadoMenuItem.setText("Despachar Producto Terminado");
        productosTerminadosMenu.add(despacharProductoTerminadoMenuItem);

        archivoMenu.add(productosTerminadosMenu);

        descartesMenu.setText("Descartes");

        buscarDescartesMensualesMenuItem.setText("Buscar Descartes Mensuales");
        descartesMenu.add(buscarDescartesMensualesMenuItem);

        archivoMenu.add(descartesMenu);

        etapasMenu.setText("Etapas");

        nuevaEtapaMenuItem.setText("Nueva Etapa");
        etapasMenu.add(nuevaEtapaMenuItem);

        darBajaEtapaMenuItem.setText("Dar de Baja Etapa");
        etapasMenu.add(darBajaEtapaMenuItem);

        archivoMenu.add(etapasMenu);

        lotesMenu.setText("Lotes");

        nuevoLoteMenuItem.setText("Nuevo Lote");
        lotesMenu.add(nuevoLoteMenuItem);

        actualizarInformacionLoteMenuItem.setText("Actualizar Informacion Lote");
        lotesMenu.add(actualizarInformacionLoteMenuItem);

        buscarLotesMenuItem.setText("Buscar Lotes");
        lotesMenu.add(buscarLotesMenuItem);

        archivoMenu.add(lotesMenu);

        stocksMensualesInsumosMenu.setText("Stocks Mensuales Insumos");

        buscarStocksMensualesInsumosMenuItem.setText("Buscar Stocks Mensuales Insumos");
        stocksMensualesInsumosMenu.add(buscarStocksMensualesInsumosMenuItem);

        archivoMenu.add(stocksMensualesInsumosMenu);

        stocksMensualesProductosTerminadosMenu.setText("Stocks Mensuales Productos Terminados");

        buscarStocksMensualesProductosTerminadosMenuItem.setText("Buscar Stocks Mensuales Productos Terminados");
        stocksMensualesProductosTerminadosMenu.add(buscarStocksMensualesProductosTerminadosMenuItem);

        archivoMenu.add(stocksMensualesProductosTerminadosMenu);

        analisisMenu.setText("Analisis");
        analisisMenu.setEnabled(false);

        nuevoAnalisisMenuItem.setText("Nuevo Analisis");
        analisisMenu.add(nuevoAnalisisMenuItem);

        buscarAnalisisMenuItem.setText("Buscar Analisis");
        analisisMenu.add(buscarAnalisisMenuItem);

        archivoMenu.add(analisisMenu);
        archivoMenu.add(separadorEntreEsquemasYCerrarSesion);

        cerrarSesionMenuItem.setText("Cerrar Sesion");
        cerrarSesionMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionMenuItemActionPerformed(evt);
            }
        });
        archivoMenu.add(cerrarSesionMenuItem);

        mainScreenMenuBar.add(archivoMenu);

        editarMenu.setText("Editar");

        preferenciasMenuItem.setText("Preferencias");
        preferenciasMenuItem.setEnabled(false);
        editarMenu.add(preferenciasMenuItem);

        mainScreenMenuBar.add(editarMenu);

        procesosMenu.setText("Procesos");

        seEncuentraMenuItem.setText("Asignar Lotes-Etapas-Empleados");
        procesosMenu.add(seEncuentraMenuItem);

        proveeInsumosMenuItem.setText("Ingresar Cantidad de Insumo Provisto por Proveedor");
        procesosMenu.add(proveeInsumosMenuItem);

        esUtilizadaMenuItem.setText("Ingresar Cantidad de Insumo Utilizada para un Lote");
        procesosMenu.add(esUtilizadaMenuItem);

        produceMenuItem.setText("Ingresar Cantidad Producto Terminado Producida por un Lote");
        procesosMenu.add(produceMenuItem);

        mainScreenMenuBar.add(procesosMenu);

        ayudaMenu.setText("Ayuda");

        acercaDeMenuItem.setText("Acerca De");
        acercaDeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acercaDeMenuItemActionPerformed(evt);
            }
        });
        ayudaMenu.add(acercaDeMenuItem);

        mainScreenMenuBar.add(ayudaMenu);

        setJMenuBar(mainScreenMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(usuarioActualLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(solapasTabbedPane))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(solapasTabbedPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usuarioActualLabel)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(816, 644));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarSesionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionMenuItemActionPerformed
        SGPS.identificadorUsuarioActual = null;
        SGPS.nivelUsuarioActual = -1;
        this.dispose();
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
    }//GEN-LAST:event_cerrarSesionMenuItemActionPerformed

    private void acercaDeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acercaDeMenuItemActionPerformed
        AcercaDeScreen acercaDeScreen = new AcercaDeScreen();
        acercaDeScreen.setVisible(true);
    }//GEN-LAST:event_acercaDeMenuItemActionPerformed

    private void actualizarEtapasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarEtapasButtonActionPerformed
        updateEtapasTable();
    }//GEN-LAST:event_actualizarEtapasButtonActionPerformed

    private void actualizarTablaSolapaEmpleadosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarTablaSolapaEmpleadosButtonActionPerformed
        updateEmpleadosTable();
    }//GEN-LAST:event_actualizarTablaSolapaEmpleadosButtonActionPerformed

    private void actualizarTablaSolapaInsumosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarTablaSolapaInsumosButtonActionPerformed
        updateInsumosTable();
    }//GEN-LAST:event_actualizarTablaSolapaInsumosButtonActionPerformed

    private void actualizarTablaSolapaProductosTerminadosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarTablaSolapaProductosTerminadosButtonActionPerformed
        updateProductosTerminadosTable();
    }//GEN-LAST:event_actualizarTablaSolapaProductosTerminadosButtonActionPerformed

    private void actualizarTablaSolapaLotesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarTablaSolapaLotesButtonActionPerformed
        updateLotesTable();
    }//GEN-LAST:event_actualizarTablaSolapaLotesButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem acercaDeMenuItem;
    private javax.swing.JButton actualizarEtapasButton;
    private javax.swing.JMenuItem actualizarInformacionEmpleadoMenuItem;
    private javax.swing.JMenuItem actualizarInformacionInsumoMenuItem;
    private javax.swing.JMenuItem actualizarInformacionLoteMenuItem;
    private javax.swing.JMenuItem actualizarInformacionProveedorMenuItem;
    private javax.swing.JButton actualizarTablaSolapaEmpleadosButton;
    private javax.swing.JButton actualizarTablaSolapaInsumosButton;
    private javax.swing.JButton actualizarTablaSolapaLotesButton;
    private javax.swing.JButton actualizarTablaSolapaProductosTerminadosButton;
    private javax.swing.JMenu analisisMenu;
    private javax.swing.JMenu archivoMenu;
    private javax.swing.JMenu ayudaMenu;
    private javax.swing.JMenuItem buscarAnalisisMenuItem;
    private javax.swing.JMenuItem buscarDescartesMensualesMenuItem;
    private javax.swing.JMenuItem buscarEmpleadosMenuItem;
    private javax.swing.JMenuItem buscarInsumosMenuItem;
    private javax.swing.JMenuItem buscarLotesMenuItem;
    private javax.swing.JMenuItem buscarProductosTerminadosMenuItem;
    private javax.swing.JMenuItem buscarStocksMensualesInsumosMenuItem;
    private javax.swing.JMenuItem buscarStocksMensualesProductosTerminadosMenuItem;
    private javax.swing.JMenuItem cerrarSesionMenuItem;
    private javax.swing.JMenuItem darBajaEmpleadoMenuItem;
    private javax.swing.JMenuItem darBajaEtapaMenuItem;
    private javax.swing.JMenuItem darBajaInsumoMenuItem;
    private javax.swing.JMenuItem darBajaProductoTerminadoMenuItem;
    private javax.swing.JMenuItem darBajaProveedorMenuItem;
    private javax.swing.JMenuItem darBajaUsuarioSistemaMenuItem;
    private javax.swing.JMenu descartesMenu;
    private javax.swing.JMenuItem despacharProductoTerminadoMenuItem;
    private javax.swing.JMenu editarMenu;
    private javax.swing.JMenu empleadosMenu;
    private javax.swing.JTable empleadosTable;
    private javax.swing.JMenuItem esUtilizadaMenuItem;
    private javax.swing.JMenu etapasMenu;
    private javax.swing.JTable etapasTable;
    private javax.swing.JMenuItem exportarMenuItem;
    private javax.swing.JButton imprimirEmpleadosButton;
    private javax.swing.JButton imprimirEtapasButton;
    private javax.swing.JButton imprimirInsumosButton;
    private javax.swing.JButton imprimirLotesButton;
    private javax.swing.JButton imprimirProductosTerminadosButton;
    private javax.swing.JMenu insumosMenu;
    private javax.swing.JTable insumosTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu lotesMenu;
    private javax.swing.JTable lotesTable;
    private javax.swing.JMenuBar mainScreenMenuBar;
    private javax.swing.JMenuItem nuevaEtapaMenuItem;
    private javax.swing.JMenuItem nuevaSancionMenuItem;
    private javax.swing.JMenuItem nuevoAccidenteMenuItem;
    private javax.swing.JMenuItem nuevoAnalisisMenuItem;
    private javax.swing.JMenuItem nuevoEmpleadoMenuItem;
    private javax.swing.JMenuItem nuevoInsumoMenuItem;
    private javax.swing.JMenuItem nuevoLoteMenuItem;
    private javax.swing.JMenuItem nuevoPremioMenuItem;
    private javax.swing.JMenuItem nuevoProductoTerminadoMenuItem;
    private javax.swing.JMenuItem nuevoProveedorMenuItem;
    private javax.swing.JMenuItem nuevoUsuarioSistemaMenuItem;
    private javax.swing.JMenuItem preferenciasMenuItem;
    private javax.swing.JMenu procesosMenu;
    private javax.swing.JMenuItem produceMenuItem;
    private javax.swing.JMenu productosTerminadosMenu;
    private javax.swing.JTable productosTerminadosTable;
    private javax.swing.JMenuItem proveeInsumosMenuItem;
    private javax.swing.JMenu proveedoresMenu;
    private javax.swing.JMenuItem seEncuentraMenuItem;
    private javax.swing.JPopupMenu.Separator separadorEntreEsquemasYCerrarSesion;
    private javax.swing.JPopupMenu.Separator separadoreEntreExportarYEsquemas;
    private javax.swing.JPanel solapaEmpleadosPane;
    private javax.swing.JPanel solapaEtapasPanel;
    private javax.swing.JPanel solapaInsumosPane;
    private javax.swing.JPanel solapaLotesPane;
    private javax.swing.JPanel solapaProductosTerminadosPane;
    private javax.swing.JTabbedPane solapasTabbedPane;
    private javax.swing.JMenu stocksMensualesInsumosMenu;
    private javax.swing.JMenu stocksMensualesProductosTerminadosMenu;
    private javax.swing.JScrollPane tablaSolapaEmpleadosScrollPane;
    private javax.swing.JScrollPane tablaSolapaInsumosScrollPane;
    private javax.swing.JScrollPane tablaSolapaLotesScrollPane;
    private javax.swing.JScrollPane tablaSolapaProductosTerminadosScrollPane;
    private javax.swing.JLabel usuarioActualLabel;
    private javax.swing.JMenu usuariosSistemaMenu;
    // End of variables declaration//GEN-END:variables
}
