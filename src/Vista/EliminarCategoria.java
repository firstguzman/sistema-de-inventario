/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.ConexionBD;
import Controlador.ControllerCategoria;
import static Vista.InicioSesion.frmenUsuario;
import static Vista.GestionDeUsuario.actor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author sofiarodriguezmorales
 */
public class EliminarCategoria extends javax.swing.JFrame {

    /**
     * Creates new form EliminarCategoria
     */
    
    ControllerCategoria sqlCategorias = new ControllerCategoria();
    ConexionBD ventana = new ConexionBD();
    Connection cm = ventana.conexion();
    PreparedStatement pst;
    
    
    public EliminarCategoria() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        //FuncionesBaseDeDatos.DatabaseConnection();
        sqlCategorias.updateCategoriesComboBox(jComboBoxCategorias);
    }
    
    private void eliminarProductosCategoria(String nombre){
       try {
                pst = cm.prepareStatement("DELETE FROM producto WHERE categoria = ?");
                pst.setString(1, nombre);
                pst.executeUpdate();

                            
            } catch (SQLException ex) {
                Logger.getLogger(GestionDeCategoria.class.getName()).log(Level.SEVERE, null, ex);
            }          
    }
    
    private void eliminarMovimientosCategoria(String nombre){
       
            try {
                pst = cm.prepareStatement("DELETE FROM movimiento WHERE categoria = ?");
                pst.setString(1, nombre);
                pst.executeUpdate();
                  
            } catch (SQLException ex) {
                Logger.getLogger(GestionDeCategoria.class.getName()).log(Level.SEVERE, null, ex);
            }                      
    }
    
    private void eliminarCategoria(String nombre){
        try {        
                eliminarMovimientosCategoria(nombre);
                eliminarProductosCategoria(nombre);
                //eliminar categoria en la base de datos sql statement
                pst = cm.prepareStatement("DELETE FROM categoria WHERE categoria = ?");
                pst.setString(1, nombre);
                pst.executeUpdate();
                          
            } catch (SQLException ex) {
                Logger.getLogger(GestionDeCategoria.class.getName()).log(Level.SEVERE, null, ex);
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
        jPanel5 = new javax.swing.JPanel();
        jButtonCategorias = new javax.swing.JButton();
        jButtonUsuario3 = new javax.swing.JButton();
        jButtonFiltroBusqueda3 = new javax.swing.JButton();
        jButtonProductos = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxCategorias = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(41, 113, 222));

        jButtonCategorias.setBackground(new java.awt.Color(41, 113, 222));
        jButtonCategorias.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCategorias.setText("Categorias");
        jButtonCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCategoriasActionPerformed(evt);
            }
        });

        jButtonUsuario3.setBackground(new java.awt.Color(41, 113, 222));
        jButtonUsuario3.setForeground(new java.awt.Color(255, 255, 255));
        jButtonUsuario3.setText("Usuario");
        jButtonUsuario3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsuario3ActionPerformed(evt);
            }
        });

        jButtonFiltroBusqueda3.setBackground(new java.awt.Color(41, 113, 222));
        jButtonFiltroBusqueda3.setForeground(new java.awt.Color(255, 255, 255));
        jButtonFiltroBusqueda3.setText("Filtro de busqueda");
        jButtonFiltroBusqueda3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltroBusqueda3ActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonUsuario3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFiltroBusqueda3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jButtonUsuario3)
                .addGap(18, 18, 18)
                .addComponent(jButtonFiltroBusqueda3)
                .addGap(18, 18, 18)
                .addComponent(jButtonCategorias)
                .addGap(18, 18, 18)
                .addComponent(jButtonProductos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonEliminar.setBackground(new java.awt.Color(255, 51, 51));
        jButtonEliminar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonCancelar.setBackground(new java.awt.Color(255, 102, 102));
        jButtonCancelar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(41, 113, 222));
        jLabel1.setText("Eliminar categoria");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                        .addComponent(jButtonEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jComboBoxCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(245, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addComponent(jComboBoxCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                .addComponent(jButtonEliminar)
                .addGap(18, 18, 18)
                .addComponent(jButtonCancelar)
                .addGap(120, 120, 120))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jButtonUsuario3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsuario3ActionPerformed
        this.dispose();
        try {
            frmenUsuario = new GestionDeUsuario(actor);
            frmenUsuario.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(AñadirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonUsuario3ActionPerformed

    private void jButtonFiltroBusqueda3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltroBusqueda3ActionPerformed
        FiltroDeBusqueda FiltroDeBusqueda = new FiltroDeBusqueda();
        FiltroDeBusqueda.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonFiltroBusqueda3ActionPerformed

    private void jButtonProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProductosActionPerformed
        // TODO add your handling code here:
        GestionDeProducto GestionDeProducto = new GestionDeProducto();
        GestionDeProducto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonProductosActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
       String nombreCategoria = jComboBoxCategorias.getSelectedItem().toString();

        // TODO add your handling code here:
        String botones[] = {"Aceptar","Cancelar"};
        int eleccion = JOptionPane.showOptionDialog (this,"Desea eliminar esta categoria?",null,0,0, null,botones,this);
        if (eleccion==JOptionPane.YES_OPTION){
            
            eliminarCategoria(nombreCategoria);
            this.dispose();
            GestionDeCategoria GestionDeCategoria = new GestionDeCategoria();
            GestionDeCategoria.setVisible(true);
            this.dispose();
            JOptionPane.showMessageDialog(null,"Categoria eliminada satisfactoriamente");
       }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        GestionDeCategoria GestionDeCategoria = new GestionDeCategoria();
        GestionDeCategoria.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(EliminarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminarCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCategorias;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonFiltroBusqueda3;
    private javax.swing.JButton jButtonProductos;
    private javax.swing.JButton jButtonUsuario3;
    private javax.swing.JComboBox<String> jComboBoxCategorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
