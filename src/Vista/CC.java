package Vista;

import Modelo.Hash;
import Modelo.SqlUsuarios;
import Modelo.Usuarios;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CC extends javax.swing.JFrame {
    public static InicioSesion frmInicioSesion;
    public static Usuarios mod;
    
    public CC() {
        initComponents();
        this.setLocationRelativeTo(null);
        DatosCC.frmCC = null;
    }

    public CC(Usuarios mod) {
        initComponents();
        DatosCC.frmCC = null;
        this.mod = mod;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        title = new java.awt.Label();
        txt_newpsw = new javax.swing.JPasswordField();
        txt_confirmnewpsw = new javax.swing.JPasswordField();
        newpsw = new javax.swing.JLabel();
        confirmnewpsw = new javax.swing.JLabel();
        btn_change = new javax.swing.JButton();
        alertas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(41, 113, 222));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 550));

        title.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Recordar contraseña");

        txt_newpsw.setBackground(new java.awt.Color(0, 102, 205));
        txt_newpsw.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_newpsw.setForeground(new java.awt.Color(255, 255, 255));
        txt_newpsw.setAutoscrolls(false);
        txt_newpsw.setName(""); // NOI18N
        txt_newpsw.setPreferredSize(new java.awt.Dimension(6, 15));
        txt_newpsw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_newpswActionPerformed(evt);
            }
        });

        txt_confirmnewpsw.setBackground(new java.awt.Color(0, 102, 205));
        txt_confirmnewpsw.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_confirmnewpsw.setForeground(new java.awt.Color(255, 255, 255));
        txt_confirmnewpsw.setAutoscrolls(false);
        txt_confirmnewpsw.setName(""); // NOI18N
        txt_confirmnewpsw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_confirmnewpswActionPerformed(evt);
            }
        });

        newpsw.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        newpsw.setForeground(new java.awt.Color(255, 255, 255));
        newpsw.setText("NUEVA CLAVE ");

        confirmnewpsw.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        confirmnewpsw.setForeground(new java.awt.Color(255, 255, 255));
        confirmnewpsw.setText("CONFIRMAR NUEVA CLAVE ");

        btn_change.setBackground(new java.awt.Color(41, 113, 222));
        btn_change.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btn_change.setForeground(new java.awt.Color(255, 255, 255));
        btn_change.setText("CAMBIAR");
        btn_change.setToolTipText("");
        btn_change.setBorder(null);
        btn_change.setBorderPainted(false);
        btn_change.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_change.setName("AVANZAR"); // NOI18N
        btn_change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_changeActionPerformed(evt);
            }
        });

        alertas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        alertas.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(218, 218, 218)
                                .addComponent(newpsw))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(confirmnewpsw)))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_confirmnewpsw, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_newpsw, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_change, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(alertas, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(274, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(alertas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newpsw, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_newpsw, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmnewpsw, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_confirmnewpsw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btn_change, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(232, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_changeActionPerformed
        if (frmInicioSesion == null){
            SqlUsuarios modSql = new SqlUsuarios();
            
            String psw = new String(txt_newpsw.getPassword());
            String passCon = new String(txt_confirmnewpsw.getPassword());
            
            //validación de la nueva contraseña con lo escrito en el ERS
            if ((modSql.esAlphaNumeric(psw))&&(psw.length()>=5&&psw.length()<=8)){
                //compara las contraseñas
                if (psw.equals(passCon)) {
                    //cifra la contraseña
                    String nuevoPass = Hash.sha1(psw);
                    mod.setPassword(nuevoPass);
                    try {
                        if (modSql.changePsw(mod)) {
                            JOptionPane.showMessageDialog(null, "SE HA CAMBIADO LA CONTRASEÑA CORRECTAMENTE");
                            alertas.setText("Cambio realizado satisfactoriamentee");
                            frmInicioSesion = new InicioSesion();
                            frmInicioSesion.setVisible(true);
                            this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "SE HA PRODUCIDO UN ERROR EN SU SOLICITUD");
                            alertas.setText("Error en solicitud");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(CC.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "LAS CONTRASEÑAS NO COINCIDEN");
                    alertas.setText("Contraseñas no coinciden");
                }
            }
        }
    }//GEN-LAST:event_btn_changeActionPerformed

    private void txt_newpswActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_newpswActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_newpswActionPerformed

    private void txt_confirmnewpswActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_confirmnewpswActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_confirmnewpswActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CC().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alertas;
    private javax.swing.JButton btn_change;
    private javax.swing.JLabel confirmnewpsw;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel newpsw;
    private java.awt.Label title;
    private javax.swing.JPasswordField txt_confirmnewpsw;
    private javax.swing.JPasswordField txt_newpsw;
    // End of variables declaration//GEN-END:variables
}
