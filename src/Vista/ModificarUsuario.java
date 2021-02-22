package Vista;

import Modelo.ConexionBD;
import Modelo.SqlUsuarios;
import Modelo.Usuarios;
import static Vista.InicioSesion.frmenUsuario;
import static Vista.GestionDeUsuario.actor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ModificarUsuario extends javax.swing.JFrame {
    private Usuarios user = new Usuarios();
    public ModificarUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionBD ventana = new ConexionBD();
        Connection cm = ventana.conexion();
        
        try {
            ps = cm.prepareStatement("SELECT nombre FROM usuarios");
            rs = ps.executeQuery();
            
            while (rs.next()){
                this.box_user.addItem(rs.getString("nombre"));
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModificarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButtonFiltroBusqueda = new javax.swing.JButton();
        jButtonProductos = new javax.swing.JButton();
        jButtonCategorias = new javax.swing.JButton();
        jButtonUsuario = new javax.swing.JButton();
        modificarUsuario = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JButton();
        txt2 = new javax.swing.JLabel();
        txt3 = new javax.swing.JLabel();
        box_status = new javax.swing.JComboBox<>();
        box_user = new javax.swing.JComboBox<>();
        btn_modify = new javax.swing.JButton();
        name = new javax.swing.JLabel();
        jTextField_name = new javax.swing.JTextField();
        correo = new javax.swing.JLabel();
        jTextField_mail = new javax.swing.JTextField();
        username = new javax.swing.JLabel();
        jTextField_username = new javax.swing.JTextField();
        alertas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 550));

        jPanel2.setBackground(new java.awt.Color(41, 113, 222));

        jButtonFiltroBusqueda.setBackground(new java.awt.Color(41, 113, 222));
        jButtonFiltroBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        jButtonFiltroBusqueda.setText("Filtro de busqueda");
        jButtonFiltroBusqueda.setMaximumSize(new java.awt.Dimension(69, 23));
        jButtonFiltroBusqueda.setMinimumSize(new java.awt.Dimension(69, 23));
        jButtonFiltroBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltroBusquedaActionPerformed(evt);
            }
        });

        jButtonProductos.setBackground(new java.awt.Color(41, 113, 222));
        jButtonProductos.setForeground(new java.awt.Color(255, 255, 255));
        jButtonProductos.setText("Productos");
        jButtonProductos.setMaximumSize(new java.awt.Dimension(69, 23));
        jButtonProductos.setMinimumSize(new java.awt.Dimension(69, 23));
        jButtonProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProductosActionPerformed(evt);
            }
        });

        jButtonCategorias.setBackground(new java.awt.Color(41, 113, 222));
        jButtonCategorias.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCategorias.setText("Categorias");
        jButtonCategorias.setMaximumSize(new java.awt.Dimension(69, 23));
        jButtonCategorias.setMinimumSize(new java.awt.Dimension(69, 23));
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonProductos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFiltroBusqueda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCategorias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButtonUsuario)
                .addGap(18, 18, 18)
                .addComponent(jButtonFiltroBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        modificarUsuario.setFont(new java.awt.Font("Arial", 1, 19)); // NOI18N
        modificarUsuario.setForeground(new java.awt.Color(41, 113, 222));
        modificarUsuario.setText("Modificar Usuario");

        btn_cancel.setBackground(new java.awt.Color(204, 0, 0));
        btn_cancel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_cancel.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancel.setText("Cancelar");
        btn_cancel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        txt2.setFont(new java.awt.Font("Arial", 0, 19)); // NOI18N
        txt2.setText("Usuario");

        txt3.setFont(new java.awt.Font("Arial", 0, 19)); // NOI18N
        txt3.setText("Estatus");

        box_status.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        box_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Administrador", "Contribuyente", "Invitado" }));
        box_status.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        box_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_statusActionPerformed(evt);
            }
        });

        box_user.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        box_user.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona" }));
        box_user.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        box_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_userActionPerformed(evt);
            }
        });

        btn_modify.setBackground(new java.awt.Color(255, 204, 0));
        btn_modify.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_modify.setForeground(new java.awt.Color(255, 255, 255));
        btn_modify.setText("Modificar");
        btn_modify.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modifyActionPerformed(evt);
            }
        });

        name.setFont(new java.awt.Font("Arial", 0, 19)); // NOI18N
        name.setText("Nombre Completo");

        jTextField_name.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField_name.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nameActionPerformed(evt);
            }
        });

        correo.setFont(new java.awt.Font("Arial", 0, 19)); // NOI18N
        correo.setText("Correo");

        jTextField_mail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField_mail.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField_mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_mailActionPerformed(evt);
            }
        });

        username.setFont(new java.awt.Font("Arial", 0, 19)); // NOI18N
        username.setText("Nombre De Usuario");

        jTextField_username.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField_username.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_usernameActionPerformed(evt);
            }
        });

        alertas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        alertas.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(correo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(392, 392, 392)))
                        .addGap(88, 88, 88))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box_status, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_modify, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField_username, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_mail, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(box_user, javax.swing.GroupLayout.Alignment.LEADING, 0, 298, Short.MAX_VALUE)
                                    .addComponent(name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                                    .addComponent(jTextField_name, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alertas, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(modificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt2))
                    .addComponent(alertas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(box_user, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name)
                    .addComponent(username))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_username, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(correo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_mail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(box_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(btn_modify, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 915, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void box_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_userActionPerformed
        SqlUsuarios sqlMod = new SqlUsuarios();
        if (box_user.getSelectedItem() == "Selecciona"){
             this.limpiar();
        } else {
            this.user = sqlMod.getUsuario((String)box_user.getSelectedItem());
            if (user != null){
                this.jTextField_name.setText(user.getNombre());
                this.jTextField_username.setText(user.getUsuario());
                this.jTextField_mail.setText(user.getCorreo());
                this.box_status.setSelectedIndex(user.getId_tipo());
            }
        }
    }//GEN-LAST:event_box_userActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        this.dispose();
        try {
            frmenUsuario = new GestionDeUsuario(actor);
            frmenUsuario.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(AñadirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void box_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box_statusActionPerformed

    private void jTextField_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nameActionPerformed

    private void jTextField_mailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_mailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_mailActionPerformed

    private void jTextField_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_usernameActionPerformed

    private void btn_modifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifyActionPerformed
        SqlUsuarios modSql = new SqlUsuarios();
        if (modSql.esEmail(this.jTextField_mail.getText())) {
            user.setCorreo(this.jTextField_mail.getText());
            if (modSql.valUser(this.jTextField_username.getText())) {
                user.setUsuario(this.jTextField_username.getText());
                user.setNombre(this.jTextField_name.getText());
                user.setId_tipo(box_status.getSelectedIndex());
                try {
                    if (modSql.modificar(user)) {
                        this.box_user.removeItemAt(this.box_user.getSelectedIndex());
                        JOptionPane.showMessageDialog(null, "USUARIO MODIFICADO SATISFACTORIAMENTE");
                        this.actualizar();
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR EN SOLICITUD");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ModificarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "FORMATO DEL NOMBRE DE USUARIO INCORRECTO");
            }
        } else {
            JOptionPane.showMessageDialog(null, "CORREO ELECTRONICO INVALIDO");
        }
    }//GEN-LAST:event_btn_modifyActionPerformed

    private void jButtonFiltroBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltroBusquedaActionPerformed
        FiltroDeBusqueda FiltroDeBusqueda = new FiltroDeBusqueda();
        FiltroDeBusqueda.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonFiltroBusquedaActionPerformed

    private void jButtonProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProductosActionPerformed
        GestionDeProducto GestionDeProducto = new GestionDeProducto();
        GestionDeProducto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonProductosActionPerformed

    private void jButtonCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCategoriasActionPerformed
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

    private void limpiar() {
        jTextField_name.setText("");
        jTextField_mail.setText("");
        jTextField_username.setText("");
        box_status.setSelectedIndex(0);
    }
    
    private void actualizar(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionBD ventana = new ConexionBD();
        Connection cm = ventana.conexion();
        
        
        /*this.box_user.setSelectedIndex(0);
        int cont = this.box_user.getItemCount();
            for (int i=0;i<=cont;i++){
                System.out.println(cont);
                System.out.println(this.box_user.getItemAt(i));
                this.box_user.remove(i);
            }*/
            
        try {
            this.box_user.removeAllItems();
            this.box_user.addItem("Selecciona");
            ps = cm.prepareStatement("SELECT nombre FROM usuarios");
            rs = ps.executeQuery();
            
            while (rs.next()){
                this.box_user.addItem(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModificarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("aqui estoy");
        }
    }
    
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
            java.util.logging.Logger.getLogger(ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alertas;
    private javax.swing.JComboBox<String> box_status;
    private javax.swing.JComboBox<String> box_user;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_modify;
    private javax.swing.JLabel correo;
    private javax.swing.JButton jButtonCategorias;
    private javax.swing.JButton jButtonFiltroBusqueda;
    private javax.swing.JButton jButtonProductos;
    private javax.swing.JButton jButtonUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField jTextField_mail;
    public javax.swing.JTextField jTextField_name;
    public javax.swing.JTextField jTextField_username;
    private javax.swing.JLabel modificarUsuario;
    private javax.swing.JLabel name;
    private javax.swing.JLabel txt2;
    private javax.swing.JLabel txt3;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
