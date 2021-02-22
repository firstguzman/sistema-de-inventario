/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author sofiarodriguezmorales
 */

import Modelo.ConexionBD;
import static Vista.InicioSesion.frmenUsuario;
import static Vista.GestionDeUsuario.actor;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ModificarUbicacion extends javax.swing.JFrame {

    /**
     * Creates new form EditarUbicacion
     */
    public ModificarUbicacion() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        //FuncionesBaseDeDatos.DatabaseConnection();
    }
    
    ConexionBD ventana = new ConexionBD();
    Connection cm = ventana.conexion();
    PreparedStatement pst;
    String producto = "";
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButtonModificar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButtonCategorias = new javax.swing.JButton();
        jButtonUsuario = new javax.swing.JButton();
        jButtonFiltroBusqueda3 = new javax.swing.JButton();
        jButtonProductos3 = new javax.swing.JButton();
        jLabelProducto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextFieldEditarUbicacion = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jButtonModificar.setBackground(new java.awt.Color(255, 153, 102));
        jButtonModificar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonModificar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonCancelar.setBackground(new java.awt.Color(255, 51, 51));
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
        jLabel1.setText("Modificar ubicación");

        jPanel5.setBackground(new java.awt.Color(41, 113, 222));

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

        jButtonFiltroBusqueda3.setBackground(new java.awt.Color(41, 113, 222));
        jButtonFiltroBusqueda3.setForeground(new java.awt.Color(255, 255, 255));
        jButtonFiltroBusqueda3.setText("Filtro de busqueda");
        jButtonFiltroBusqueda3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltroBusqueda3ActionPerformed(evt);
            }
        });

        jButtonProductos3.setBackground(new java.awt.Color(41, 113, 222));
        jButtonProductos3.setForeground(new java.awt.Color(255, 255, 255));
        jButtonProductos3.setText("Productos");
        jButtonProductos3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProductos3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonFiltroBusqueda3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonProductos3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButtonUsuario)
                .addGap(7, 7, 7)
                .addComponent(jButtonFiltroBusqueda3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCategorias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonProductos3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelProducto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabelProducto.setText("Producto");

        jTextFieldEditarUbicacion.setColumns(20);
        jTextFieldEditarUbicacion.setRows(5);
        jTextFieldEditarUbicacion.setText("Editar Ubicación");
        jScrollPane1.setViewportView(jTextFieldEditarUbicacion);

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
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                        .addComponent(jButtonModificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabelProducto)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButtonModificar)
                .addGap(18, 18, 18)
                .addComponent(jButtonCancelar)
                .addContainerGap(122, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modificarUbicacion(String Ubicacion,String Producto){
       
        try{
            pst = cm.prepareStatement("UPDATE producto SET ubicacion = (?) WHERE nombre = (?)");
            pst.setString(1, Ubicacion);
            pst.setString(2, Producto);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AñadirCategoria.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Error de conexión con la base de datos");
        }    
   
    }
    
    
    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed

        if (jTextFieldEditarUbicacion.getText().isEmpty()){
           
        } else {
            String botones[] = {"Aceptar","Cancelar"};
            int eleccion = JOptionPane.showOptionDialog (this,"Desea modificar la ubicación de este producto?",null,0,0, null,botones,this);
            if (eleccion==JOptionPane.YES_OPTION){
                modificarUbicacion(jTextFieldEditarUbicacion.getText(), jLabelProducto.getText());
                InfoProducto Producto = new InfoProducto();
                Producto.setVisible(true);
                this.dispose();
                Producto.jLabelProducto.setText(jLabelProducto.getText());
                Producto.MostrarInfo(jLabelProducto.getText());
                JOptionPane.showMessageDialog(null,"Ubicación modificada satisfactoriamente");
            }
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        InfoProducto Producto = new InfoProducto();
        Producto.jLabelProducto.setText(jLabelProducto.getText());
        Producto.MostrarInfo(jLabelProducto.getText());
        Producto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

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

    private void jButtonFiltroBusqueda3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltroBusqueda3ActionPerformed
        FiltroDeBusqueda FiltroDeBusqueda = new FiltroDeBusqueda();
        FiltroDeBusqueda.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonFiltroBusqueda3ActionPerformed

    private void jButtonProductos3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProductos3ActionPerformed
        // TODO add your handling code here:
        GestionDeProducto GestionDeProducto = new GestionDeProducto();
        GestionDeProducto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonProductos3ActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarUbicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarUbicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarUbicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarUbicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarUbicacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCategorias;
    private javax.swing.JButton jButtonFiltroBusqueda3;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonProductos3;
    private javax.swing.JButton jButtonUsuario;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabelProducto;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea jTextFieldEditarUbicacion;
    // End of variables declaration//GEN-END:variables
}