package Vista;

import Modelo.Hash;
import Modelo.SqlUsuarios;
import Modelo.Usuarios;
import java.awt.AWTEvent;
import java.awt.Event;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class InicioSesion extends javax.swing.JFrame {

    public static DatosCC frmdatosCC;
    public static GestionDeUsuario frmenUsuario;
    Connection con;
    PreparedStatement pst;
    
    public InicioSesion() {
        initComponents();
        this.setResizable(false);
        CC.frmInicioSesion = null;
    }
   
    @Override
    public int getX() {
        return super.getX(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processEvent(AWTEvent e) {
        super.processEvent(e); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String paramString() {
        return super.paramString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean postEvent(Event e) {
        return super.postEvent(e); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_login = new javax.swing.JButton();
        btn_forgotpsw = new javax.swing.JButton();
        alertas = new javax.swing.JLabel();
        title = new java.awt.Label();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        username = new javax.swing.JLabel();
        password = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(41, 113, 222));

        btn_login.setBackground(new java.awt.Color(41, 113, 222));
        btn_login.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setText("INGRESAR");
        btn_login.setBorder(null);
        btn_login.setBorderPainted(false);
        btn_login.setMaximumSize(new java.awt.Dimension(53, 15));
        btn_login.setMinimumSize(new java.awt.Dimension(53, 15));
        btn_login.setName("INGRESAR"); // NOI18N
        btn_login.setPreferredSize(new java.awt.Dimension(53, 15));
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        btn_forgotpsw.setBackground(new java.awt.Color(41, 113, 222));
        btn_forgotpsw.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_forgotpsw.setForeground(new java.awt.Color(255, 255, 255));
        btn_forgotpsw.setText("RECORDAR CONTRASEÑA");
        btn_forgotpsw.setBorder(null);
        btn_forgotpsw.setBorderPainted(false);
        btn_forgotpsw.setMaximumSize(new java.awt.Dimension(53, 15));
        btn_forgotpsw.setMinimumSize(new java.awt.Dimension(53, 15));
        btn_forgotpsw.setName("RECORDARCON"); // NOI18N
        btn_forgotpsw.setPreferredSize(new java.awt.Dimension(53, 15));
        btn_forgotpsw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_forgotpswActionPerformed(evt);
            }
        });

        alertas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        alertas.setForeground(new java.awt.Color(255, 0, 0));

        title.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("SISTEMA DE INVENTARIO");

        txt_username.setBackground(new java.awt.Color(0, 102, 205));
        txt_username.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_username.setForeground(new java.awt.Color(255, 255, 255));
        txt_username.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_usernameMouseClicked(evt);
            }
        });
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });

        txt_password.setBackground(new java.awt.Color(0, 102, 205));
        txt_password.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_password.setForeground(new java.awt.Color(255, 255, 255));
        txt_password.setAutoscrolls(false);
        txt_password.setName(""); // NOI18N

        username.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setText("USERNAME");

        password.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setText("CLAVE ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(password)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_forgotpsw, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 181, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(alertas, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(250, 250, 250))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(alertas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_forgotpsw, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        txt_username.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_forgotpswActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_forgotpswActionPerformed
        frmdatosCC = null;
        if (frmdatosCC == null) {
            this.dispose();
            frmdatosCC = new DatosCC();
            frmdatosCC.setVisible(true);
        }
    }//GEN-LAST:event_btn_forgotpswActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        frmenUsuario = null;
        if (frmenUsuario == null) {
            SqlUsuarios modSql = new SqlUsuarios();
            Usuarios mod = new Usuarios();

            Date date = new Date();
            DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String psw = new String(txt_password.getPassword());
            if (modSql.valUser(txt_username.getText())) {
                if (!txt_username.getText().equals("") && !psw.equals("")) {
                    String newPass = Hash.sha1(psw);
                    mod.setUsuario(txt_username.getText());
                    mod.setPassword(newPass);
                    mod.setLast_sesion(fechaHora.format(date));

                    try {
                        if (modSql.logIn(mod)) {
                            this.dispose();
                            frmenUsuario = new GestionDeUsuario(mod);
                            frmenUsuario.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "ERROR! Ha introducido un dato inválido");
                            alertas.setText("ERROR! Ha introducido un dato inválido");
                            limpiar();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(InicioSesion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "ERROR! datos incompletos, debe ingresar sus datos");
                    alertas.setText("ERROR! datos incompletos, debe ingresar sus datos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "ERROR! Nombre de usuario escrito en mayuscula o errado");
                alertas.setText("ERROR! usuario no valido");
            }
        }
    }//GEN-LAST:event_btn_loginActionPerformed

    private void txt_usernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_usernameMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_usernameMouseClicked

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void limpiar() {
        txt_username.setText("");
        txt_password.setText("");
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
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new InicioSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alertas;
    private javax.swing.JButton btn_forgotpsw;
    private javax.swing.JButton btn_login;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel password;
    private java.awt.Label title;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
