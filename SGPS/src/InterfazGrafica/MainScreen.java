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
import javax.swing.JTable;
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
            JOptionPane.showMessageDialog(null, e, "Error en conexión", JOptionPane.ERROR_MESSAGE);
        }
        usuarioActualLabel.setText("Usuario: " + SGPS.identificadorUsuarioActual);
        
        inicializacionStocksMensualesProductosTerminados();
        inicializacionStocksMensualesInsumos();
        inicializacionStocksMensualesDescarte();
        
        updateEtapasTable();
        updateEmpleadosTable();
        updateInsumosTable();
        updateInsumosProduccionTable();
        updateInsumosEmbalajeTable();
        updateProductosTerminadosTable();
        updateLotesTable();
    }
    
    public void inicializacionStocksMensualesProductosTerminados(){
        // Para cada producto terminado activo debo controlar si existe sotck mensual este mes. En caso de que no exista crearlo.
        ResultSet rs1 = null;
        PreparedStatement pst1 = null;
        ResultSet rs2 = null;
        PreparedStatement pst2 = null;
        ResultSet rs3 = null;
        PreparedStatement pst3 = null;
        ResultSet rs4 = null;
        PreparedStatement pst4 = null;
        
        // Inicializo stocks mensuales de productos terminados
        try{
            String sql = "SELECT PT_Codificacion FROM ProductosTerminados WHERE PT_Activo = 'true'";
            pst1 = conn.prepareStatement(sql);
            rs1 = pst1.executeQuery();
            
            while (rs1.next()){
                
                // Tengo un producto terminado, ahora debo consultar si existe stock mensual del mismo.
                String sql2 = "SELECT PT_Codificacion_CaracterizadoEn_PT FROM StocksMensualesProductosTerminados WHERE PT_Codificacion_CaracterizadoEn_PT = ? AND SM_PT_Fecha = ?";
                pst2 = conn.prepareStatement(sql2);

                Calendar calendarioActual = Calendar.getInstance();
                calendarioActual.set(Calendar.DAY_OF_MONTH, 1);

                java.util.Date today = new java.util.Date(calendarioActual.getTimeInMillis());
                java.sql.Date fechaActual = new java.sql.Date(today.getTime());

                pst2.setString(1, rs1.getString(1));
                pst2.setDate(2,fechaActual);

                rs2 = pst2.executeQuery();
                
                // Vemos si existe stock para este mes
                if (!rs2.next()){
                    // Debemos crear el stock mensual, pero antes se debe consultar el stock del mes pasado
                    String sql3 = "SELECT * FROM StocksMensualesProductosTerminados WHERE PT_Codificacion_CaracterizadoEn_PT = ? AND SM_PT_Fecha = ?";
                    pst3 = conn.prepareStatement(sql3);

                    Calendar calendarioActual2 = Calendar.getInstance();
                    calendarioActual2.set(Calendar.DAY_OF_MONTH, 1);
                    calendarioActual2.add(Calendar.MONTH, -1);

                    java.util.Date today2 = new java.util.Date(calendarioActual2.getTimeInMillis());
                    java.sql.Date fechaActual2 = new java.sql.Date(today2.getTime());

                    pst3.setString(1, rs1.getString(1));
                    pst3.setDate(2,fechaActual2);

                    rs3 = pst3.executeQuery();
                    
                    if (rs3.next()){
                        String sql4 = "INSERT INTO stocksmensualesproductosterminados( " +
                                        "sm_pt_fecha, sm_pt_inicio, sm_pt_ingreso, sm_pt_egreso, " +
                                        "sm_pt_cantidadcalculada, sm_pt_cantidadreal, sm_pt_diferencia, " +
                                        "pt_codificacion_caracterizadoen_pt)" +
                                        "    VALUES (?, ?, ?, ?, " +
                                        "            ?, ?, ?, ?); ";
                        
                        pst4 = conn.prepareStatement(sql4);
                        
                        pst4.setDate(1,fechaActual);
                        pst4.setFloat(2, rs3.getFloat(7));
                        pst4.setFloat(3,0);
                        pst4.setFloat(4,0);
                        pst4.setFloat(5, rs3.getFloat(7));
                        pst4.setFloat(6, rs3.getFloat(7));
                        pst4.setFloat(7, 0);
                        pst4.setString(8, rs1.getString(1));
                        
                        pst4.execute();
                    }
                    else{
                        String sql4 = "INSERT INTO stocksmensualesproductosterminados( " +
                                        "sm_pt_fecha, sm_pt_inicio, sm_pt_ingreso, sm_pt_egreso, " +
                                        "sm_pt_cantidadcalculada, sm_pt_cantidadreal, sm_pt_diferencia, " +
                                        "pt_codificacion_caracterizadoen_pt)" +
                                        "    VALUES (?, ?, ?, ?, " +
                                        "            ?, ?, ?, ?); ";
                        
                        pst4 = conn.prepareStatement(sql4);
                        
                        pst4.setDate(1,fechaActual);
                        pst4.setFloat(2, 0);
                        pst4.setFloat(3,0);
                        pst4.setFloat(4,0);
                        pst4.setFloat(5, 0);
                        pst4.setFloat(6, 0);
                        pst4.setFloat(7, 0);
                        pst4.setString(8, rs1.getString(1));
                        
                        pst4.execute();
                    }
                }
                
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e, "Error al inicializar stocks mensuales de productos terminados", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
        public void inicializacionStocksMensualesInsumos(){
        // Para cada insumo activo debo controlar si existe sotck mensual este mes. En caso de que no exista crearlo.
        ResultSet rs1 = null;
        PreparedStatement pst1 = null;
        ResultSet rs2 = null;
        PreparedStatement pst2 = null;
        ResultSet rs3 = null;
        PreparedStatement pst3 = null;
        ResultSet rs4 = null;
        PreparedStatement pst4 = null;
        
        // Inicializo stocks mensuales de insumos
        try{
            String sql = "SELECT I_Descripcion FROM Insumos WHERE I_Activo = 'true'";
            pst1 = conn.prepareStatement(sql);
            rs1 = pst1.executeQuery();
            
            while (rs1.next()){
                
                // Tengo un producto terminado, ahora debo consultar si existe stock mensual del mismo.
                String sql2 = "SELECT I_Descripcion_CaracterizadoEn FROM StocksMensualesInsumos WHERE I_Descripcion_CaracterizadoEn = ? AND SM_I_Fecha = ?";
                pst2 = conn.prepareStatement(sql2);

                Calendar calendarioActual = Calendar.getInstance();
                calendarioActual.set(Calendar.DAY_OF_MONTH, 1);

                java.util.Date today = new java.util.Date(calendarioActual.getTimeInMillis());
                java.sql.Date fechaActual = new java.sql.Date(today.getTime());

                pst2.setString(1, rs1.getString(1));
                pst2.setDate(2,fechaActual);

                rs2 = pst2.executeQuery();
                
                // Vemos si existe stock para este mes
                if (!rs2.next()){
                    // Debemos crear el stock mensual, pero antes se debe consultar el stock del mes pasado
                    String sql3 = "SELECT * FROM StocksMensualesInsumos WHERE I_Descripcion_CaracterizadoEn = ? AND SM_I_Fecha = ?";
                    pst3 = conn.prepareStatement(sql3);

                    Calendar calendarioActual2 = Calendar.getInstance();
                    calendarioActual2.set(Calendar.DAY_OF_MONTH, 1);
                    calendarioActual2.add(Calendar.MONTH, -1);

                    java.util.Date today2 = new java.util.Date(calendarioActual2.getTimeInMillis());
                    java.sql.Date fechaActual2 = new java.sql.Date(today2.getTime());

                    pst3.setString(1, rs1.getString(1));
                    pst3.setDate(2,fechaActual2);

                    rs3 = pst3.executeQuery();
                    
                    if (rs3.next()){
                        String sql4 = "INSERT INTO StocksMensualesInsumos( " +
                                        "SM_I_Fecha, SM_I_Inicio, SM_I_Ingreso, SM_I_Egreso, " +
                                        "SM_I_CantidadCalculada, SM_I_CantidadReal, SM_I_Diferencia, " +
                                        "I_Descripcion_CaracterizadoEn)" +
                                        "    VALUES (?, ?, ?, ?, " +
                                        "            ?, ?, ?, ?); ";
                        
                        pst4 = conn.prepareStatement(sql4);
                        
                        pst4.setDate(1,fechaActual);
                        pst4.setFloat(2, rs3.getFloat(7));
                        pst4.setFloat(3,0);
                        pst4.setFloat(4,0);
                        pst4.setFloat(5, rs3.getFloat(7));
                        pst4.setFloat(6, rs3.getFloat(7));
                        pst4.setFloat(7, 0);
                        pst4.setString(8, rs1.getString(1));
                        
                        pst4.execute();
                    }
                    else{
                        String sql4 = "INSERT INTO StocksMensualesInsumos( " +
                                        "SM_I_Fecha, SM_I_Inicio, SM_I_Ingreso, SM_I_Egreso, " +
                                        "SM_I_CantidadCalculada, SM_I_CantidadReal, SM_I_Diferencia, " +
                                        "I_Descripcion_CaracterizadoEn)" +
                                        "    VALUES (?, ?, ?, ?, " +
                                        "            ?, ?, ?, ?); ";
                        
                        pst4 = conn.prepareStatement(sql4);
                        
                        pst4.setDate(1,fechaActual);
                        pst4.setFloat(2, 0);
                        pst4.setFloat(3,0);
                        pst4.setFloat(4,0);
                        pst4.setFloat(5, 0);
                        pst4.setFloat(6, 0);
                        pst4.setFloat(7, 0);
                        pst4.setString(8, rs1.getString(1));
                        
                        pst4.execute();
                    }
                }
                
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e, "Error al inicializar stocks mensuales de Insumos", JOptionPane.ERROR_MESSAGE);
        }
    }
        
        
public void inicializacionStocksMensualesDescarte(){
        // Para el stock mensual de descarte debo controlar si existe sotck mensual este mes. En caso de que no exista crearlo.
        ResultSet rs2 = null;
        PreparedStatement pst2 = null;
        ResultSet rs3 = null;
        PreparedStatement pst3 = null;
        ResultSet rs4 = null;
        PreparedStatement pst4 = null;
        
        try{
                            
            // Tengo un producto terminado, ahora debo consultar si existe stock mensual del mismo.
            String sql2 = "SELECT SM_D_Codigo FROM StocksMensualesDescarte WHERE SM_D_Fecha = ?";
            pst2 = conn.prepareStatement(sql2);

            Calendar calendarioActual = Calendar.getInstance();
            calendarioActual.set(Calendar.DAY_OF_MONTH, 1);

            java.util.Date today = new java.util.Date(calendarioActual.getTimeInMillis());
            java.sql.Date fechaActual = new java.sql.Date(today.getTime());

            pst2.setDate(1,fechaActual);

            rs2 = pst2.executeQuery();

            // Vemos si existe stock para este mes
            if (!rs2.next()){
                // Debemos crear el stock mensual, pero antes se debe consultar el stock del mes pasado
                String sql3 = "SELECT * FROM StocksMensualesDescarte WHERE SM_D_Fecha = ?";
                pst3 = conn.prepareStatement(sql3);

                Calendar calendarioActual2 = Calendar.getInstance();
                calendarioActual2.set(Calendar.DAY_OF_MONTH, 1);
                calendarioActual2.add(Calendar.MONTH, -1);

                java.util.Date today2 = new java.util.Date(calendarioActual2.getTimeInMillis());
                java.sql.Date fechaActual2 = new java.sql.Date(today2.getTime());

                pst3.setDate(1,fechaActual2);

                rs3 = pst3.executeQuery();

                if (rs3.next()){
                    String sql4 = "INSERT INTO stocksmensualesdescarte( " +
                                    "sm_d_fecha, sm_d_inicio, sm_d_ingreso, sm_d_egreso, " +
                                    "sm_d_cantidad) " +
                                    "    VALUES (?, ?, ?, ?, " +
                                    "            ?); ";

                    pst4 = conn.prepareStatement(sql4);

                    pst4.setDate(1,fechaActual);
                    pst4.setFloat(2, rs3.getFloat(6));
                    pst4.setFloat(3,0);
                    pst4.setFloat(4,0);
                    pst4.setFloat(5, rs3.getFloat(6));

                    pst4.execute();
                }
                else{
                    String sql4 = "INSERT INTO stocksmensualesdescarte( " +
                                    "sm_d_fecha, sm_d_inicio, sm_d_ingreso, sm_d_egreso, " +
                                    "sm_d_cantidad) " +
                                    "    VALUES (?, ?, ?, ?, " +
                                    "            ?); ";

                    pst4 = conn.prepareStatement(sql4);

                    pst4.setDate(1,fechaActual);
                    pst4.setFloat(2, 0);
                    pst4.setFloat(3,0);
                    pst4.setFloat(4,0);
                    pst4.setFloat(5, 0);

                    pst4.execute();
                }
            }
                
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e, "Error al inicializar stocks mensuales de descarte", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void updateEtapasTable(){
        try{
            String sql = "SELECT etapa_descripcion AS \"Descripcion\" FROM Etapas WHERE Etapa_Activo = 'true'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            etapasTable.setModel(DbUtils.resultSetToTableModel(rs));
            etapasTable.setEnabled(false);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e, "Error al actualizar tabla de etapas", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateEmpleadosTable(){
        try{
            /*
            String sql = "SELECT e_nombre AS \"Nombre\","
                              + "e_dni AS \"DNI\","
                              + "e_telefono AS \"Teléfono\","
                              + "e_fechaingreso AS \"Fecha Ingreso\","
                              + "e_numerolegajo AS \"Num Legajo\","
                              + "e_sueldo AS \"Sueldo\","
                              + "e_cuil AS \"CUIL\","
                              + "e_estadocivil AS \"Estado Civil\","
                              + "e_cantidadhijos AS \"Cant Hijos\","
                              + "e_domicilio AS \"Domicilio\","
                              + "e_codigopostal AS \"Cod Postal\","
                              + "e_paisresidencia AS \"País Residencia\","
                              + "e_provinciaresidencia AS \"Provincia Residencia\","
                              + "e_ciudadresidencia AS \"Ciudad Residencia\","
                              + "e_categoria AS \"Categoria\","
                              + "e_estado AS \"Estado\" "
                        + "FROM empleados "
                        + "WHERE E_Estado <> 'Despedido' ORDER BY e_nombre";*/
            
            String sql = "SELECT e_nombre AS \"Nombre\","
                              + "e_dni AS \"DNI\","
                              + "e_telefono AS \"Teléfono\","
                              + "e_fechaingreso AS \"Fecha Ingreso\","
                              + "e_numerolegajo AS \"Num Legajo\","
                              + "e_cuil AS \"CUIL\","
                              + "e_categoria AS \"Categoria\","
                              + "e_estado AS \"Estado\" "
                        + "FROM empleados "
                        + "WHERE E_Estado <> 'Despedido' ORDER BY e_nombre";
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            empleadosTable.setModel(DbUtils.resultSetToTableModel(rs));
            empleadosTable.setEnabled(false);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e, "Error al actualizar tabla de empleados", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /// HACE REFERENCIA A LAS MATERIAS PRIMAS
    public void updateInsumosTable(){
        try{
            String sql = "SELECT I_Descripcion_CaracterizadoEn AS \"Descripción\","
                             + " SM_I_Inicio AS \"Inicio\","
                             + " SM_I_Ingreso AS \"Ingreso\","
                             + " SM_I_Egreso AS \"Egreso\","
                             + " SM_I_CantidadCalculada AS \"Cantidad Calculada\","
                             + " SM_I_CantidadReal AS \"Cantidad Real\","
                             + " SM_I_Diferencia AS \"Diferencia\" "
                        + "FROM StocksMensualesInsumos, Insumos "
                        + "WHERE I_Descripcion = I_Descripcion_CaracterizadoEn AND I_Tipo = 'Materia Prima' AND SM_I_Fecha = ? ORDER BY I_Descripcion_CaracterizadoEn";
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
            JOptionPane.showMessageDialog(this, e, "Error al actualizar tabla de materias primas", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void updateInsumosEmbalajeTable(){
        try{
            String sql = "SELECT I_Descripcion_CaracterizadoEn AS \"Descripción\","
                             + " SM_I_Inicio AS \"Inicio\","
                             + " SM_I_Ingreso AS \"Ingreso\","
                             + " SM_I_Egreso AS \"Egreso\","
                             + " SM_I_CantidadCalculada AS \"Cantidad Calculada\","
                             + " SM_I_CantidadReal AS \"Cantidad Real\","
                             + " SM_I_Diferencia AS \"Diferencia\" "
                        + "FROM StocksMensualesInsumos, Insumos "
                        + "WHERE I_Descripcion = I_Descripcion_CaracterizadoEn AND I_Tipo = 'Insumo Embalaje' AND SM_I_Fecha = ? ORDER BY I_Descripcion_CaracterizadoEn";
            pst = conn.prepareStatement(sql);
            
            Calendar calendarioActual = Calendar.getInstance();
            calendarioActual.set(Calendar.DAY_OF_MONTH, 1);
                                    
            java.util.Date today = new java.util.Date(calendarioActual.getTimeInMillis());
            java.sql.Date fechaActual = new java.sql.Date(today.getTime());
            
            pst.setDate(1,fechaActual);
            
            rs = pst.executeQuery();
            insumosEmbalajeTable.setModel(DbUtils.resultSetToTableModel(rs));
            insumosEmbalajeTable.setEnabled(false);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e, "Error al actualizar tabla de insumos de embalaje", JOptionPane.ERROR_MESSAGE);
        }
    }
    
   
    public void updateInsumosProduccionTable(){
        try{
            String sql = "SELECT I_Descripcion_CaracterizadoEn AS \"Descripción\","
                             + " SM_I_Inicio AS \"Inicio\","
                             + " SM_I_Ingreso AS \"Ingreso\","
                             + " SM_I_Egreso AS \"Egreso\","
                             + " SM_I_CantidadCalculada AS \"Cantidad Calculada\","
                             + " SM_I_CantidadReal AS \"Cantidad Real\","
                             + " SM_I_Diferencia AS \"Diferencia\" "
                        + "FROM StocksMensualesInsumos, Insumos "
                        + "WHERE I_Descripcion = I_Descripcion_CaracterizadoEn AND I_Tipo = 'Insumo Produccion' AND SM_I_Fecha = ? ORDER BY I_Descripcion_CaracterizadoEn";
            pst = conn.prepareStatement(sql);
            
            Calendar calendarioActual = Calendar.getInstance();
            calendarioActual.set(Calendar.DAY_OF_MONTH, 1);
                                    
            java.util.Date today = new java.util.Date(calendarioActual.getTimeInMillis());
            java.sql.Date fechaActual = new java.sql.Date(today.getTime());
            
            pst.setDate(1,fechaActual);
            
            rs = pst.executeQuery();
            insumosProduccionTable.setModel(DbUtils.resultSetToTableModel(rs));
            insumosProduccionTable.setEnabled(false);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e, "Error al actualizar tabla de insumos de producción", JOptionPane.ERROR_MESSAGE);
        }
    }    
    
        
     
    public void updateProductosTerminadosTable(){
        try{
            String sql = "SELECT PT_Codificacion_CaracterizadoEn_PT AS \"Codificación\","
                             + " SM_PT_Inicio AS \"Inicio\","
                             + " SM_PT_Ingreso AS \"Ingreso\","
                             + " SM_PT_Egreso AS \"Egreso\","
                             + " SM_PT_CantidadCalculada AS \"Cantidad Calculada\","
                             + " SM_PT_CantidadReal AS \"Cantidad Real\","
                             + " SM_PT_Diferencia AS \"Diferencia\" "
                        + "FROM StocksMensualesProductosTerminados "
                        + "WHERE SM_PT_Fecha = ? ORDER BY PT_Codificacion_CaracterizadoEn_PT";
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
            JOptionPane.showMessageDialog(this, e, "Error al actualizar tabla de productos terminados", JOptionPane.ERROR_MESSAGE);
        }
    }
        
    public void updateLotesTable(){
        try{
            String sql = "SELECT L_Identificador AS \"Identificador\","
                             + " L_FechaCreacion AS \"Fecha Creación\","
                             + " L_CantidadDescarteUtilizado AS \"Cantidad Descarte Utilizada\" "
                        + "FROM Lotes "
                        + "WHERE L_Estado = ?";
            pst = conn.prepareStatement(sql);
            
            
            pst.setInt(1, 0); //Lotes en procesamiento
            
            rs = pst.executeQuery();
            lotesTable.setModel(DbUtils.resultSetToTableModel(rs));
            lotesTable.setEnabled(false);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e, "Error al actualizar tabla de lotes", JOptionPane.ERROR_MESSAGE);
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
        tablaSolapaLotesScrollPane = new javax.swing.JScrollPane();
        lotesTable = new javax.swing.JTable();
        imprimirLotesButton = new javax.swing.JButton();
        solapaInsumosPane = new javax.swing.JPanel();
        tablaSolapaInsumosScrollPane = new javax.swing.JScrollPane();
        insumosTable = new javax.swing.JTable();
        imprimirInsumosButton = new javax.swing.JButton();
        solapaInsumoEmbalajePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        insumosEmbalajeTable = new javax.swing.JTable();
        imprimirInsumosEmbalajeButton = new javax.swing.JButton();
        solapaInsumosProduccionPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        insumosProduccionTable = new javax.swing.JTable();
        imprimirInsumosProduccionButton = new javax.swing.JButton();
        solapaProductosTerminadosPane = new javax.swing.JPanel();
        tablaSolapaProductosTerminadosScrollPane = new javax.swing.JScrollPane();
        productosTerminadosTable = new javax.swing.JTable();
        imprimirProductosTerminadosButton = new javax.swing.JButton();
        solapaEmpleadosPane = new javax.swing.JPanel();
        tablaSolapaEmpleadosScrollPane = new javax.swing.JScrollPane();
        empleadosTable = new javax.swing.JTable();
        imprimirEmpleadosButton = new javax.swing.JButton();
        solapaEtapasPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        etapasTable = new javax.swing.JTable();
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
        recontratarMenuItem = new javax.swing.JMenuItem();
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
        InsumosUtilizadosMenuItem = new javax.swing.JMenuItem();
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
        ingresoCantidadDescarteMenuItem = new javax.swing.JMenuItem();
        ayudaMenu = new javax.swing.JMenu();
        acercaDeMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Sistema de Gestion de Produccion y Stock");
        setMinimumSize(new java.awt.Dimension(800, 600));

        usuarioActualLabel.setText("Usuario: ");

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
        imprimirLotesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirLotesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout solapaLotesPaneLayout = new javax.swing.GroupLayout(solapaLotesPane);
        solapaLotesPane.setLayout(solapaLotesPaneLayout);
        solapaLotesPaneLayout.setHorizontalGroup(
            solapaLotesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(solapaLotesPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(solapaLotesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tablaSolapaLotesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1082, Short.MAX_VALUE)
                    .addGroup(solapaLotesPaneLayout.createSequentialGroup()
                        .addComponent(imprimirLotesButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        solapaLotesPaneLayout.setVerticalGroup(
            solapaLotesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, solapaLotesPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tablaSolapaLotesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imprimirLotesButton)
                .addContainerGap())
        );

        solapasTabbedPane.addTab("Lotes", solapaLotesPane);

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
        imprimirInsumosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirInsumosButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout solapaInsumosPaneLayout = new javax.swing.GroupLayout(solapaInsumosPane);
        solapaInsumosPane.setLayout(solapaInsumosPaneLayout);
        solapaInsumosPaneLayout.setHorizontalGroup(
            solapaInsumosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(solapaInsumosPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(solapaInsumosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tablaSolapaInsumosScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1082, Short.MAX_VALUE)
                    .addGroup(solapaInsumosPaneLayout.createSequentialGroup()
                        .addComponent(imprimirInsumosButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        solapaInsumosPaneLayout.setVerticalGroup(
            solapaInsumosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, solapaInsumosPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tablaSolapaInsumosScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imprimirInsumosButton)
                .addContainerGap())
        );

        solapasTabbedPane.addTab("Materias Primas", solapaInsumosPane);

        insumosEmbalajeTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(insumosEmbalajeTable);

        imprimirInsumosEmbalajeButton.setText("Imprimir");
        imprimirInsumosEmbalajeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirInsumosEmbalajeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout solapaInsumoEmbalajePanelLayout = new javax.swing.GroupLayout(solapaInsumoEmbalajePanel);
        solapaInsumoEmbalajePanel.setLayout(solapaInsumoEmbalajePanelLayout);
        solapaInsumoEmbalajePanelLayout.setHorizontalGroup(
            solapaInsumoEmbalajePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(solapaInsumoEmbalajePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(solapaInsumoEmbalajePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1082, Short.MAX_VALUE)
                    .addGroup(solapaInsumoEmbalajePanelLayout.createSequentialGroup()
                        .addComponent(imprimirInsumosEmbalajeButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        solapaInsumoEmbalajePanelLayout.setVerticalGroup(
            solapaInsumoEmbalajePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(solapaInsumoEmbalajePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imprimirInsumosEmbalajeButton)
                .addContainerGap())
        );

        solapasTabbedPane.addTab("Insumos Embalaje", solapaInsumoEmbalajePanel);

        insumosProduccionTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(insumosProduccionTable);

        imprimirInsumosProduccionButton.setText("Imprimir");
        imprimirInsumosProduccionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirInsumosProduccionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout solapaInsumosProduccionPanelLayout = new javax.swing.GroupLayout(solapaInsumosProduccionPanel);
        solapaInsumosProduccionPanel.setLayout(solapaInsumosProduccionPanelLayout);
        solapaInsumosProduccionPanelLayout.setHorizontalGroup(
            solapaInsumosProduccionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(solapaInsumosProduccionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(solapaInsumosProduccionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1082, Short.MAX_VALUE)
                    .addGroup(solapaInsumosProduccionPanelLayout.createSequentialGroup()
                        .addComponent(imprimirInsumosProduccionButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        solapaInsumosProduccionPanelLayout.setVerticalGroup(
            solapaInsumosProduccionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(solapaInsumosProduccionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imprimirInsumosProduccionButton)
                .addContainerGap())
        );

        solapasTabbedPane.addTab("Insumos Producción", solapaInsumosProduccionPanel);

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
        imprimirProductosTerminadosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirProductosTerminadosButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout solapaProductosTerminadosPaneLayout = new javax.swing.GroupLayout(solapaProductosTerminadosPane);
        solapaProductosTerminadosPane.setLayout(solapaProductosTerminadosPaneLayout);
        solapaProductosTerminadosPaneLayout.setHorizontalGroup(
            solapaProductosTerminadosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(solapaProductosTerminadosPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(solapaProductosTerminadosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tablaSolapaProductosTerminadosScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1082, Short.MAX_VALUE)
                    .addGroup(solapaProductosTerminadosPaneLayout.createSequentialGroup()
                        .addComponent(imprimirProductosTerminadosButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        solapaProductosTerminadosPaneLayout.setVerticalGroup(
            solapaProductosTerminadosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, solapaProductosTerminadosPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tablaSolapaProductosTerminadosScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imprimirProductosTerminadosButton)
                .addContainerGap())
        );

        solapasTabbedPane.addTab("Procutos Terminados", solapaProductosTerminadosPane);

        empleadosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "DNI", "Telefono", "Fecha de Ingreso", "Numero de Legajo", "CUIL", "Categoria", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tablaSolapaEmpleadosScrollPane.setViewportView(empleadosTable);

        imprimirEmpleadosButton.setText("Imprimir");
        imprimirEmpleadosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirEmpleadosButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout solapaEmpleadosPaneLayout = new javax.swing.GroupLayout(solapaEmpleadosPane);
        solapaEmpleadosPane.setLayout(solapaEmpleadosPaneLayout);
        solapaEmpleadosPaneLayout.setHorizontalGroup(
            solapaEmpleadosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(solapaEmpleadosPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(solapaEmpleadosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tablaSolapaEmpleadosScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1082, Short.MAX_VALUE)
                    .addGroup(solapaEmpleadosPaneLayout.createSequentialGroup()
                        .addComponent(imprimirEmpleadosButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        solapaEmpleadosPaneLayout.setVerticalGroup(
            solapaEmpleadosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, solapaEmpleadosPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tablaSolapaEmpleadosScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imprimirEmpleadosButton)
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

        imprimirEtapasButton.setText("Imprimir");
        imprimirEtapasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirEtapasButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout solapaEtapasPanelLayout = new javax.swing.GroupLayout(solapaEtapasPanel);
        solapaEtapasPanel.setLayout(solapaEtapasPanelLayout);
        solapaEtapasPanelLayout.setHorizontalGroup(
            solapaEtapasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(solapaEtapasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(solapaEtapasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1082, Short.MAX_VALUE)
                    .addGroup(solapaEtapasPanelLayout.createSequentialGroup()
                        .addComponent(imprimirEtapasButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        solapaEtapasPanelLayout.setVerticalGroup(
            solapaEtapasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(solapaEtapasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imprimirEtapasButton)
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
        nuevoEmpleadoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoEmpleadoMenuItemActionPerformed(evt);
            }
        });
        empleadosMenu.add(nuevoEmpleadoMenuItem);

        actualizarInformacionEmpleadoMenuItem.setText("Actualizar Información Empleado");
        actualizarInformacionEmpleadoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarInformacionEmpleadoMenuItemActionPerformed(evt);
            }
        });
        empleadosMenu.add(actualizarInformacionEmpleadoMenuItem);

        buscarEmpleadosMenuItem.setText("Buscar Empleados");
        buscarEmpleadosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarEmpleadosMenuItemActionPerformed(evt);
            }
        });
        empleadosMenu.add(buscarEmpleadosMenuItem);

        darBajaEmpleadoMenuItem.setText("Dar de Baja Empleado");
        darBajaEmpleadoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darBajaEmpleadoMenuItemActionPerformed(evt);
            }
        });
        empleadosMenu.add(darBajaEmpleadoMenuItem);

        recontratarMenuItem.setText("Recontratar Empleado");
        recontratarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recontratarMenuItemActionPerformed(evt);
            }
        });
        empleadosMenu.add(recontratarMenuItem);

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
        nuevoUsuarioSistemaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoUsuarioSistemaMenuItemActionPerformed(evt);
            }
        });
        usuariosSistemaMenu.add(nuevoUsuarioSistemaMenuItem);

        darBajaUsuarioSistemaMenuItem.setText("Dar de Baja Usuario del Sistema");
        darBajaUsuarioSistemaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darBajaUsuarioSistemaMenuItemActionPerformed(evt);
            }
        });
        usuariosSistemaMenu.add(darBajaUsuarioSistemaMenuItem);

        archivoMenu.add(usuariosSistemaMenu);

        proveedoresMenu.setText("Proveedores");

        nuevoProveedorMenuItem.setText("Nuevo Proveedor");
        nuevoProveedorMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoProveedorMenuItemActionPerformed(evt);
            }
        });
        proveedoresMenu.add(nuevoProveedorMenuItem);

        actualizarInformacionProveedorMenuItem.setText("Actualizar Información Proveedor");
        actualizarInformacionProveedorMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarInformacionProveedorMenuItemActionPerformed(evt);
            }
        });
        proveedoresMenu.add(actualizarInformacionProveedorMenuItem);

        darBajaProveedorMenuItem.setText("Dar de Baja Proveedor");
        darBajaProveedorMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darBajaProveedorMenuItemActionPerformed(evt);
            }
        });
        proveedoresMenu.add(darBajaProveedorMenuItem);

        archivoMenu.add(proveedoresMenu);

        insumosMenu.setText("Insumos");

        nuevoInsumoMenuItem.setText("Nuevo Insumo");
        nuevoInsumoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoInsumoMenuItemActionPerformed(evt);
            }
        });
        insumosMenu.add(nuevoInsumoMenuItem);

        actualizarInformacionInsumoMenuItem.setText("Actualizar Información Insumo");
        actualizarInformacionInsumoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarInformacionInsumoMenuItemActionPerformed(evt);
            }
        });
        insumosMenu.add(actualizarInformacionInsumoMenuItem);

        buscarInsumosMenuItem.setText("Buscar Insumos");
        buscarInsumosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarInsumosMenuItemActionPerformed(evt);
            }
        });
        insumosMenu.add(buscarInsumosMenuItem);

        darBajaInsumoMenuItem.setText("Dar de Baja Insumo");
        darBajaInsumoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darBajaInsumoMenuItemActionPerformed(evt);
            }
        });
        insumosMenu.add(darBajaInsumoMenuItem);

        archivoMenu.add(insumosMenu);

        productosTerminadosMenu.setText("Productos Terminados");

        nuevoProductoTerminadoMenuItem.setText("Nuevo Producto Terminado");
        nuevoProductoTerminadoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoProductoTerminadoMenuItemActionPerformed(evt);
            }
        });
        productosTerminadosMenu.add(nuevoProductoTerminadoMenuItem);

        buscarProductosTerminadosMenuItem.setText("Buscar Productos Terminados");
        buscarProductosTerminadosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarProductosTerminadosMenuItemActionPerformed(evt);
            }
        });
        productosTerminadosMenu.add(buscarProductosTerminadosMenuItem);

        darBajaProductoTerminadoMenuItem.setText("Dar de Baja Producto Terminado");
        darBajaProductoTerminadoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darBajaProductoTerminadoMenuItemActionPerformed(evt);
            }
        });
        productosTerminadosMenu.add(darBajaProductoTerminadoMenuItem);

        despacharProductoTerminadoMenuItem.setText("Despachar Producto Terminado");
        despacharProductoTerminadoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                despacharProductoTerminadoMenuItemActionPerformed(evt);
            }
        });
        productosTerminadosMenu.add(despacharProductoTerminadoMenuItem);

        archivoMenu.add(productosTerminadosMenu);

        descartesMenu.setText("Descartes");

        buscarDescartesMensualesMenuItem.setText("Buscar Descartes Mensuales");
        buscarDescartesMensualesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarDescartesMensualesMenuItemActionPerformed(evt);
            }
        });
        descartesMenu.add(buscarDescartesMensualesMenuItem);

        archivoMenu.add(descartesMenu);

        etapasMenu.setText("Etapas");

        nuevaEtapaMenuItem.setText("Nueva Etapa");
        nuevaEtapaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaEtapaMenuItemActionPerformed(evt);
            }
        });
        etapasMenu.add(nuevaEtapaMenuItem);

        darBajaEtapaMenuItem.setText("Dar de Baja Etapa");
        darBajaEtapaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darBajaEtapaMenuItemActionPerformed(evt);
            }
        });
        etapasMenu.add(darBajaEtapaMenuItem);

        archivoMenu.add(etapasMenu);

        lotesMenu.setText("Lotes");

        nuevoLoteMenuItem.setText("Nuevo Lote");
        nuevoLoteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoLoteMenuItemActionPerformed(evt);
            }
        });
        lotesMenu.add(nuevoLoteMenuItem);

        actualizarInformacionLoteMenuItem.setText("Actualizar Información Lote");
        actualizarInformacionLoteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarInformacionLoteMenuItemActionPerformed(evt);
            }
        });
        lotesMenu.add(actualizarInformacionLoteMenuItem);

        buscarLotesMenuItem.setText("Buscar Lotes");
        buscarLotesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarLotesMenuItemActionPerformed(evt);
            }
        });
        lotesMenu.add(buscarLotesMenuItem);

        InsumosUtilizadosMenuItem.setText("Ver Insumos Utilizados por un Lote");
        InsumosUtilizadosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsumosUtilizadosMenuItemActionPerformed(evt);
            }
        });
        lotesMenu.add(InsumosUtilizadosMenuItem);

        archivoMenu.add(lotesMenu);

        stocksMensualesInsumosMenu.setText("Stocks Mensuales Insumos");

        buscarStocksMensualesInsumosMenuItem.setText("Buscar Stocks Mensuales Insumos");
        buscarStocksMensualesInsumosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarStocksMensualesInsumosMenuItemActionPerformed(evt);
            }
        });
        stocksMensualesInsumosMenu.add(buscarStocksMensualesInsumosMenuItem);

        archivoMenu.add(stocksMensualesInsumosMenu);

        stocksMensualesProductosTerminadosMenu.setText("Stocks Mensuales Productos Terminados");

        buscarStocksMensualesProductosTerminadosMenuItem.setText("Buscar Stocks Mensuales Productos Terminados");
        buscarStocksMensualesProductosTerminadosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarStocksMensualesProductosTerminadosMenuItemActionPerformed(evt);
            }
        });
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

        cerrarSesionMenuItem.setText("Cerrar Sesión");
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
        seEncuentraMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seEncuentraMenuItemActionPerformed(evt);
            }
        });
        procesosMenu.add(seEncuentraMenuItem);

        proveeInsumosMenuItem.setText("Ingresar Cantidad de Insumo Provisto por Proveedor");
        proveeInsumosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proveeInsumosMenuItemActionPerformed(evt);
            }
        });
        procesosMenu.add(proveeInsumosMenuItem);

        esUtilizadaMenuItem.setText("Ingresar Cantidad de Insumo Utilizada para un Lote");
        esUtilizadaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esUtilizadaMenuItemActionPerformed(evt);
            }
        });
        procesosMenu.add(esUtilizadaMenuItem);

        produceMenuItem.setText("Ingresar Cantidad Producto Terminado Producida por un Lote");
        produceMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produceMenuItemActionPerformed(evt);
            }
        });
        procesosMenu.add(produceMenuItem);

        ingresoCantidadDescarteMenuItem.setText("Ingresar Cantidad Descarte Obtenida");
        ingresoCantidadDescarteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresoCantidadDescarteMenuItemActionPerformed(evt);
            }
        });
        procesosMenu.add(ingresoCantidadDescarteMenuItem);

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
                .addComponent(usuarioActualLabel))
        );

        setSize(new java.awt.Dimension(1143, 689));
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

    private void nuevoEmpleadoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoEmpleadoMenuItemActionPerformed
        NuevoEmpleadoScreen nuevoEmpleadoScreen = new NuevoEmpleadoScreen();
        nuevoEmpleadoScreen.setVisible(true);
    }//GEN-LAST:event_nuevoEmpleadoMenuItemActionPerformed

    private void actualizarInformacionEmpleadoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarInformacionEmpleadoMenuItemActionPerformed
        ActualizarInformacionEmpleadoScreen actualizarInformacionEmpleadoScreen = new ActualizarInformacionEmpleadoScreen();
        actualizarInformacionEmpleadoScreen.setVisible(true);
    }//GEN-LAST:event_actualizarInformacionEmpleadoMenuItemActionPerformed

    private void buscarEmpleadosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarEmpleadosMenuItemActionPerformed
        BuscarEmpleadosScreen buscarEmpleadosScreen = new BuscarEmpleadosScreen();
        buscarEmpleadosScreen.setVisible(true);
    }//GEN-LAST:event_buscarEmpleadosMenuItemActionPerformed

    private void darBajaEmpleadoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darBajaEmpleadoMenuItemActionPerformed
        BajaEmpleadoScreen bajaEmpleadoScreen = new BajaEmpleadoScreen();
        bajaEmpleadoScreen.setVisible(true);
    }//GEN-LAST:event_darBajaEmpleadoMenuItemActionPerformed

    private void nuevoUsuarioSistemaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoUsuarioSistemaMenuItemActionPerformed
        NuevoUsuarioSistemaScreen nuevoUsuarioSistemaScreen = new NuevoUsuarioSistemaScreen();
        nuevoUsuarioSistemaScreen.setVisible(true);
    }//GEN-LAST:event_nuevoUsuarioSistemaMenuItemActionPerformed

    private void darBajaUsuarioSistemaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darBajaUsuarioSistemaMenuItemActionPerformed
        BajaUsuarioSistemaScreen bajaUsuarioSistemaScreen = new BajaUsuarioSistemaScreen();
        bajaUsuarioSistemaScreen.setVisible(true);
    }//GEN-LAST:event_darBajaUsuarioSistemaMenuItemActionPerformed

    private void nuevoProveedorMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoProveedorMenuItemActionPerformed
        NuevoProveedorScreen nuevoProveedorScreen = new NuevoProveedorScreen();
        nuevoProveedorScreen.setVisible(true);
    }//GEN-LAST:event_nuevoProveedorMenuItemActionPerformed

    private void actualizarInformacionProveedorMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarInformacionProveedorMenuItemActionPerformed
        ActualizarInformacionProveedorScreen actualizarInformacionProveedorScreen = new ActualizarInformacionProveedorScreen();
        actualizarInformacionProveedorScreen.setVisible(true);
    }//GEN-LAST:event_actualizarInformacionProveedorMenuItemActionPerformed

    private void darBajaProveedorMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darBajaProveedorMenuItemActionPerformed
        BajaProveedorScreen bajaProveedorScreen = new BajaProveedorScreen();
        bajaProveedorScreen.setVisible(true);
    }//GEN-LAST:event_darBajaProveedorMenuItemActionPerformed

    private void nuevoInsumoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoInsumoMenuItemActionPerformed
        NuevoInsumoScreen nuevoInsumoScreen = new NuevoInsumoScreen();
        nuevoInsumoScreen.setVisible(true);
    }//GEN-LAST:event_nuevoInsumoMenuItemActionPerformed

    private void actualizarInformacionInsumoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarInformacionInsumoMenuItemActionPerformed
        ActualizarInformacionInsumoScreen actualizarInformacionInsumoScreen = new ActualizarInformacionInsumoScreen();
        actualizarInformacionInsumoScreen.setVisible(true);
    }//GEN-LAST:event_actualizarInformacionInsumoMenuItemActionPerformed

    private void buscarInsumosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarInsumosMenuItemActionPerformed
        BuscarInsumosScreen buscarInsumosScreen = new BuscarInsumosScreen();
        buscarInsumosScreen.setVisible(true);
    }//GEN-LAST:event_buscarInsumosMenuItemActionPerformed

    private void darBajaInsumoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darBajaInsumoMenuItemActionPerformed
        BajaInsumoScreen bajaInsumoScreen = new BajaInsumoScreen();
        bajaInsumoScreen.setVisible(true);
    }//GEN-LAST:event_darBajaInsumoMenuItemActionPerformed

    private void nuevoProductoTerminadoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoProductoTerminadoMenuItemActionPerformed
        NuevoProductoTerminadoScreen nuevoProductoTerminadoScreen = new NuevoProductoTerminadoScreen();
        nuevoProductoTerminadoScreen.setVisible(true);
    }//GEN-LAST:event_nuevoProductoTerminadoMenuItemActionPerformed

    private void buscarProductosTerminadosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarProductosTerminadosMenuItemActionPerformed
        BuscarProductosTerminadosScreen buscarProductosTerminadosScreen = new BuscarProductosTerminadosScreen();
        buscarProductosTerminadosScreen.setVisible(true);
    }//GEN-LAST:event_buscarProductosTerminadosMenuItemActionPerformed

    private void darBajaProductoTerminadoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darBajaProductoTerminadoMenuItemActionPerformed
        BajaProductoTerminadoScreen bajaProductoTerminadoScreen = new BajaProductoTerminadoScreen();
        bajaProductoTerminadoScreen.setVisible(true);
    }//GEN-LAST:event_darBajaProductoTerminadoMenuItemActionPerformed

    private void despacharProductoTerminadoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_despacharProductoTerminadoMenuItemActionPerformed
        DespacharProductoTerminadoScreen despacharProductoTerminadoScreen = new DespacharProductoTerminadoScreen();
        despacharProductoTerminadoScreen.setVisible(true);
    }//GEN-LAST:event_despacharProductoTerminadoMenuItemActionPerformed

    private void buscarDescartesMensualesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarDescartesMensualesMenuItemActionPerformed
        BuscarDescartesMensualesScreen buscarDescartesMensualesScreen = new BuscarDescartesMensualesScreen();
        buscarDescartesMensualesScreen.setVisible(true);
    }//GEN-LAST:event_buscarDescartesMensualesMenuItemActionPerformed

    private void nuevaEtapaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevaEtapaMenuItemActionPerformed
        NuevaEtapaScreen nuevaEtapaScreen = new NuevaEtapaScreen();
        nuevaEtapaScreen.setVisible(true);
    }//GEN-LAST:event_nuevaEtapaMenuItemActionPerformed

    private void darBajaEtapaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darBajaEtapaMenuItemActionPerformed
        BajaEtapaScreen bajaEtapaScreen = new BajaEtapaScreen();
        bajaEtapaScreen.setVisible(true);
    }//GEN-LAST:event_darBajaEtapaMenuItemActionPerformed

    private void nuevoLoteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoLoteMenuItemActionPerformed
        NuevoLoteScreen nuevoLoteScreen = new NuevoLoteScreen();
        nuevoLoteScreen.setVisible(true);
    }//GEN-LAST:event_nuevoLoteMenuItemActionPerformed

    private void actualizarInformacionLoteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarInformacionLoteMenuItemActionPerformed
        ActualizarInformacionLoteScreen actualizarInformacionLoteScreen = new ActualizarInformacionLoteScreen();
        actualizarInformacionLoteScreen.setVisible(true);
    }//GEN-LAST:event_actualizarInformacionLoteMenuItemActionPerformed

    private void buscarLotesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarLotesMenuItemActionPerformed
        BuscarLotesScreen buscarLotesScreen = new BuscarLotesScreen();
        buscarLotesScreen.setVisible(true);
    }//GEN-LAST:event_buscarLotesMenuItemActionPerformed

    private void buscarStocksMensualesInsumosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarStocksMensualesInsumosMenuItemActionPerformed
        BuscarStocksMensualesInsumosScreen buscarStocksMensualesInsumosScreen = new BuscarStocksMensualesInsumosScreen();
        buscarStocksMensualesInsumosScreen.setVisible(true);
    }//GEN-LAST:event_buscarStocksMensualesInsumosMenuItemActionPerformed

    private void buscarStocksMensualesProductosTerminadosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarStocksMensualesProductosTerminadosMenuItemActionPerformed
        BuscarStocksMensualesProductosTerminadosScreen buscarStocksMensualesProductosTerminadosScreen = new BuscarStocksMensualesProductosTerminadosScreen();
        buscarStocksMensualesProductosTerminadosScreen.setVisible(true);
    }//GEN-LAST:event_buscarStocksMensualesProductosTerminadosMenuItemActionPerformed

    private void seEncuentraMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seEncuentraMenuItemActionPerformed
        AsignarLotesEtapasEmpleadosScreen asignarLotesEtapasEmpleadosScreen = new AsignarLotesEtapasEmpleadosScreen();
        asignarLotesEtapasEmpleadosScreen.setVisible(true);
    }//GEN-LAST:event_seEncuentraMenuItemActionPerformed

    private void proveeInsumosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proveeInsumosMenuItemActionPerformed
        ProveeInsumosScreen proveeInsumosScreen = new ProveeInsumosScreen();
        proveeInsumosScreen.setVisible(true);
    }//GEN-LAST:event_proveeInsumosMenuItemActionPerformed

    private void esUtilizadaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esUtilizadaMenuItemActionPerformed
        EsUtilizadaScreen esUtilizadaScreen = new EsUtilizadaScreen();
        esUtilizadaScreen.setVisible(true);
    }//GEN-LAST:event_esUtilizadaMenuItemActionPerformed

    private void produceMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produceMenuItemActionPerformed
        ProduceScreen produceScreen = new ProduceScreen();
        produceScreen.setVisible(true);
    }//GEN-LAST:event_produceMenuItemActionPerformed

    private void imprimirEmpleadosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirEmpleadosButtonActionPerformed
        try{
            //empleadosTable.print(JTable.PrintMode.NORMAL); // No queda muy bien que digamos
            empleadosTable.print(JTable.PrintMode.FIT_WIDTH);
        }catch(java.awt.print.PrinterException e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error al imprimir", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_imprimirEmpleadosButtonActionPerformed

    private void imprimirEtapasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirEtapasButtonActionPerformed
        try{
            //empleadosTable.print(JTable.PrintMode.NORMAL); // No queda muy bien que digamos
            etapasTable.print(JTable.PrintMode.FIT_WIDTH);
        }catch(java.awt.print.PrinterException e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error al imprimir", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_imprimirEtapasButtonActionPerformed

    private void imprimirProductosTerminadosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirProductosTerminadosButtonActionPerformed
        try{
            //empleadosTable.print(JTable.PrintMode.NORMAL); // No queda muy bien que digamos
            productosTerminadosTable.print(JTable.PrintMode.FIT_WIDTH);
        }catch(java.awt.print.PrinterException e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error al imprimir", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_imprimirProductosTerminadosButtonActionPerformed

    private void imprimirInsumosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirInsumosButtonActionPerformed
        try{
            //empleadosTable.print(JTable.PrintMode.NORMAL); // No queda muy bien que digamos
            insumosTable.print(JTable.PrintMode.FIT_WIDTH);
        }catch(java.awt.print.PrinterException e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error al imprimir", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_imprimirInsumosButtonActionPerformed

    private void imprimirLotesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirLotesButtonActionPerformed
        try{
            //empleadosTable.print(JTable.PrintMode.NORMAL); // No queda muy bien que digamos
            lotesTable.print(JTable.PrintMode.FIT_WIDTH);
        }catch(java.awt.print.PrinterException e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error al imprimir", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_imprimirLotesButtonActionPerformed

    private void ingresoCantidadDescarteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresoCantidadDescarteMenuItemActionPerformed
        IngresoCantidadDescarteObtenidaScreen ingresoCantidadDescarteObtenidaScreen = new IngresoCantidadDescarteObtenidaScreen();
        ingresoCantidadDescarteObtenidaScreen.setVisible(true);
    }//GEN-LAST:event_ingresoCantidadDescarteMenuItemActionPerformed

    private void imprimirInsumosEmbalajeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirInsumosEmbalajeButtonActionPerformed
        try{
            //empleadosTable.print(JTable.PrintMode.NORMAL); // No queda muy bien que digamos
            insumosEmbalajeTable.print(JTable.PrintMode.FIT_WIDTH);
        }catch(java.awt.print.PrinterException e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error al imprimir", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_imprimirInsumosEmbalajeButtonActionPerformed

    private void imprimirInsumosProduccionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirInsumosProduccionButtonActionPerformed
        try{
            //empleadosTable.print(JTable.PrintMode.NORMAL); // No queda muy bien que digamos
            insumosProduccionTable.print(JTable.PrintMode.FIT_WIDTH);
        }catch(java.awt.print.PrinterException e){
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error al imprimir", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_imprimirInsumosProduccionButtonActionPerformed

    private void InsumosUtilizadosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsumosUtilizadosMenuItemActionPerformed
        InsumosUtilizadosScreen insumosUtilizadosScreen = new InsumosUtilizadosScreen();
        insumosUtilizadosScreen.setVisible(true);
    }//GEN-LAST:event_InsumosUtilizadosMenuItemActionPerformed

    private void recontratarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recontratarMenuItemActionPerformed
        RecontratarScreen recontratarScreen = new RecontratarScreen();
        recontratarScreen.setVisible(true);
    }//GEN-LAST:event_recontratarMenuItemActionPerformed

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
    private javax.swing.JMenuItem InsumosUtilizadosMenuItem;
    private javax.swing.JMenuItem acercaDeMenuItem;
    private javax.swing.JMenuItem actualizarInformacionEmpleadoMenuItem;
    private javax.swing.JMenuItem actualizarInformacionInsumoMenuItem;
    private javax.swing.JMenuItem actualizarInformacionLoteMenuItem;
    private javax.swing.JMenuItem actualizarInformacionProveedorMenuItem;
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
    private javax.swing.JButton imprimirInsumosEmbalajeButton;
    private javax.swing.JButton imprimirInsumosProduccionButton;
    private javax.swing.JButton imprimirLotesButton;
    private javax.swing.JButton imprimirProductosTerminadosButton;
    private javax.swing.JMenuItem ingresoCantidadDescarteMenuItem;
    private javax.swing.JTable insumosEmbalajeTable;
    private javax.swing.JMenu insumosMenu;
    private javax.swing.JTable insumosProduccionTable;
    private javax.swing.JTable insumosTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
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
    private javax.swing.JMenuItem recontratarMenuItem;
    private javax.swing.JMenuItem seEncuentraMenuItem;
    private javax.swing.JPopupMenu.Separator separadorEntreEsquemasYCerrarSesion;
    private javax.swing.JPopupMenu.Separator separadoreEntreExportarYEsquemas;
    private javax.swing.JPanel solapaEmpleadosPane;
    private javax.swing.JPanel solapaEtapasPanel;
    private javax.swing.JPanel solapaInsumoEmbalajePanel;
    private javax.swing.JPanel solapaInsumosPane;
    private javax.swing.JPanel solapaInsumosProduccionPanel;
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
