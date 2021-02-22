package Vista;

import Modelo.ConexionBD;
import Controlador.ControllerCategoria;
import Modelo.SqlUsuarios;
import static Vista.InicioSesion.frmenUsuario;
import static Vista.GestionDeUsuario.actor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sofiarodriguezmorales
 */
public class FiltroDeBusqueda extends javax.swing.JFrame {

    /**
     * Creates new form FiltroDeBusqueda
     */
    
    ConexionBD ventana = new ConexionBD();
    Connection cm = ventana.conexion();
    ControllerCategoria sqlCategorias = new ControllerCategoria();
    PreparedStatement pst;
    
    public FiltroDeBusqueda() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        jComboBoxCategorias.addItem("");
        //FuncionesBaseDeDatos.DatabaseConnection();
        sqlCategorias.updateCategoriesComboBox(jComboBoxCategorias);
        
    }
    
    private void coincidenciasProducto(String categoria, String producto, String codigo){
        
        try {
               pst = cm.prepareStatement("SELECT * FROM producto");
               ResultSet rs = pst.executeQuery();               
                //creamos tabla modelo
                DefaultTableModel dataTable = (DefaultTableModel)jTableCoincidenciasProductos.getModel();
                // iterar por el resulset
                while (rs.next())
                {   
                    
                    if(jTextFieldNombre.getText().equals("") && jTextFieldCodigo.getText().equals("")){
                        
                        if(rs.getString("categoria").equals(categoria)){
                            dataTable.addRow(new Object[]{rs.getInt("id"), rs.getString("categoria"),  rs.getString("nombre"), rs.getString("cantidad")});
                        }
                        
                        
                        
                    }else if(jComboBoxCategorias.getSelectedItem().toString().equals("") && jTextFieldCodigo.getText().equals("")){
                        
                        if(rs.getString("nombre").equals(producto)){
                             dataTable.addRow(new Object[]{rs.getInt("id"), rs.getString("categoria"),  rs.getString("nombre"), rs.getString("cantidad")});
                        }
                       
                        
                        
                    }else if(jComboBoxCategorias.getSelectedItem().toString().equals("") && jTextFieldNombre.getText().equals("")){
                        
                        if(rs.getInt("id") == Integer.parseInt(codigo.trim())){
                             dataTable.addRow(new Object[]{rs.getInt("id"), rs.getString("categoria"),  rs.getString("nombre"), rs.getString("cantidad")});
                        }
                        
                        
                        
                         
                         
                    }else if(jTextFieldCodigo.getText().equals("")){
                        
                        if(rs.getString("categoria").equals(categoria) && rs.getString("nombre").equals(producto)){
                             dataTable.addRow(new Object[]{rs.getInt("id"), rs.getString("categoria"),  rs.getString("nombre"), rs.getString("cantidad")});
                        }
                        
                    }else if(jTextFieldNombre.getText().equals("")){
                        if(rs.getString("categoria").equals(categoria) && rs.getInt("id") == Integer.parseInt(codigo.trim())){
                             dataTable.addRow(new Object[]{rs.getInt("id"), rs.getString("categoria"),  rs.getString("nombre"), rs.getString("cantidad")});
                        }
                    }else if(jComboBoxCategorias.getSelectedItem().toString().equals("")){
                        
                        if(rs.getString("nombre").equals(producto) && rs.getInt("id") == Integer.parseInt(codigo.trim())){
                             dataTable.addRow(new Object[]{rs.getInt("id"), rs.getString("categoria"),  rs.getString("nombre"), rs.getString("cantidad")});
                        }
                        
                    }else{
                        
                        if(rs.getString("categoria").equals(categoria) && rs.getString("nombre").equals(producto) && rs.getInt("id") == Integer.parseInt(codigo.trim())){
                             dataTable.addRow(new Object[]{rs.getInt("id"), rs.getString("categoria"),  rs.getString("nombre"), rs.getString("cantidad")});
                        }
                    }
                    
                    
                    
                    
                 
                  
        
                }
            }catch (SQLException ex){
                Logger.getLogger(AñadirCategoria.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Error de conexión con la base de datos");   
                
            }
    
    }
    
    private void coincidenciasCategoria(String categoria, String producto, String codigo){
        
         try {
               pst = cm.prepareStatement("SELECT * FROM categoria");
               ResultSet rs = pst.executeQuery();               
                //creamos tabla modelo
                DefaultTableModel dataTable = (DefaultTableModel)jTableCoincidenciasCategorias.getModel();
                // iterar por el resulset
                 while (rs.next())
                {   
                 
                    if(jTextFieldCodigo.getText().equals("")){
                        
                        if(rs.getString("categoria").equals(categoria)){
                            dataTable.addRow(new Object[]{rs.getInt("id"), rs.getString("categoria")});  
                        }             
                    }
                    else if(jComboBoxCategorias.getSelectedItem().toString().equals("")){
                        
                        if(rs.getInt("id") == Integer.parseInt(codigo.trim())){
                           dataTable.addRow(new Object[]{rs.getInt("id"), rs.getString("categoria")});  
                        }
                   
                    }
                    else {
                        if(rs.getString("categoria").equals(categoria) && rs.getInt("id") == Integer.parseInt(codigo.trim())){
                           dataTable.addRow(new Object[]{rs.getInt("id"), rs.getString("categoria")});  
                        }
                    }
        
                }        
            }catch (SQLException ex){
                Logger.getLogger(AñadirCategoria.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Error de conexión con la base de datos");   
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

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButtonCategorias = new javax.swing.JButton();
        jButtonUsuario = new javax.swing.JButton();
        jButtonFiltroBusqueda = new javax.swing.JButton();
        jButtonProductos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxCategorias = new javax.swing.JComboBox<>();
        jTextFieldCodigo = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCoincidenciasProductos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCoincidenciasCategorias = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(41, 113, 222));

        jButtonCategorias.setBackground(new java.awt.Color(41, 113, 222));
        jButtonCategorias.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCategorias.setText("Categorias");
        jButtonCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCategoriasActionPerformed(evt);
            }
        });

        jButtonUsuario.setBackground(new java.awt.Color(41, 113, 222));
        jButtonUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jButtonUsuario.setText("Usuario");
        jButtonUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsuarioActionPerformed(evt);
            }
        });

        jButtonFiltroBusqueda.setBackground(new java.awt.Color(41, 113, 222));
        jButtonFiltroBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        jButtonFiltroBusqueda.setText("Filtro de busqueda");
        jButtonFiltroBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltroBusquedaActionPerformed(evt);
            }
        });

        jButtonProductos.setBackground(new java.awt.Color(41, 113, 222));
        jButtonProductos.setForeground(new java.awt.Color(255, 255, 255));
        jButtonProductos.setText("Productos");
        jButtonProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProductosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonFiltroBusqueda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonProductos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButtonUsuario)
                .addGap(7, 7, 7)
                .addComponent(jButtonFiltroBusqueda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCategorias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonProductos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(41, 113, 222));
        jLabel1.setText("Filtro de búsqueda");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Por Nombre");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Por Categoria");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Por código");

        jTextFieldCodigo.setToolTipText("Ingrese nombre");
        jTextFieldCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodigoActionPerformed(evt);
            }
        });

        jTextFieldNombre.setToolTipText("Ingrese nombre");
        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });

        jButtonBuscar.setBackground(new java.awt.Color(51, 153, 255));
        jButtonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jTableCoincidenciasProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Categoria", "Producto", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCoincidenciasProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCoincidenciasProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCoincidenciasProductos);

        jTableCoincidenciasCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableCoincidenciasCategorias);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Productos");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Categoria");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jComboBoxCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jLabel3))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCategoriasActionPerformed
        // TODO add your handling code here:
        GestionDeCategoria GestionDeCategoria = new GestionDeCategoria();
        GestionDeCategoria.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCategoriasActionPerformed

    private void jButtonUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsuarioActionPerformed
        this.dispose();
        try {
            frmenUsuario = new GestionDeUsuario(actor);
            frmenUsuario.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(AñadirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonUsuarioActionPerformed

    private void jButtonFiltroBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltroBusquedaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButtonFiltroBusquedaActionPerformed

    private void jButtonProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProductosActionPerformed
        // TODO add your handling code here:
        GestionDeProducto GestionDeProducto = new GestionDeProducto();
        GestionDeProducto.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButtonProductosActionPerformed

    private void jTextFieldCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodigoActionPerformed

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
        SqlUsuarios sqlUsuarios = new SqlUsuarios();
        
        if(jComboBoxCategorias.getSelectedItem().toString().equals("") && jTextFieldNombre.getText().equals("") && jTextFieldCodigo.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Por favor, ingrese algun campo", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            if (jTextFieldCodigo.getText().equals("") == false && sqlUsuarios.esAlpha(jTextFieldCodigo.getText()) == false){
                JOptionPane.showMessageDialog(null, "El codigo solo debe contener caracteres numericos", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                DefaultTableModel dataTable = (DefaultTableModel)jTableCoincidenciasCategorias.getModel();
                while (dataTable.getRowCount() > 0){
                    dataTable.removeRow(0);
                }
                dataTable = (DefaultTableModel)jTableCoincidenciasProductos.getModel();
                while (dataTable.getRowCount() > 0){
                    dataTable.removeRow(0);
                }
                coincidenciasProducto(jComboBoxCategorias.getSelectedItem().toString(), jTextFieldNombre.getText(), jTextFieldCodigo.getText());
                coincidenciasCategoria(jComboBoxCategorias.getSelectedItem().toString(), jTextFieldNombre.getText(), jTextFieldCodigo.getText());

                if(jTableCoincidenciasCategorias.getRowCount() == 0 && jTableCoincidenciasProductos.getRowCount() == 0){
                    JOptionPane.showMessageDialog(null, "No existen coincidencias");
                }
            }
            
        }
        
 
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jTableCoincidenciasProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCoincidenciasProductosMouseClicked
        // TODO add your handling code here:
        int i = jTableCoincidenciasProductos.getSelectedRow();
        
        InfoProducto Producto = new InfoProducto();
        Producto.setVisible(true);
        this.dispose();
        
        Producto.jLabelProducto.setText(jTableCoincidenciasProductos.getValueAt(i, 2).toString());
        Producto.MostrarInfo(jTableCoincidenciasProductos.getValueAt(i, 2).toString());
    }//GEN-LAST:event_jTableCoincidenciasProductosMouseClicked

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
            java.util.logging.Logger.getLogger(FiltroDeBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FiltroDeBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FiltroDeBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FiltroDeBusqueda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FiltroDeBusqueda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCategorias;
    private javax.swing.JButton jButtonFiltroBusqueda;
    private javax.swing.JButton jButtonProductos;
    private javax.swing.JButton jButtonUsuario;
    private javax.swing.JComboBox<String> jComboBoxCategorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCoincidenciasCategorias;
    private javax.swing.JTable jTableCoincidenciasProductos;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
