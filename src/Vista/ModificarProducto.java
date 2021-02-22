/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.ConexionBD;
import Controlador.ControllerProducto;
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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sofiarodriguezmorales
 */
public class ModificarProducto extends javax.swing.JFrame {

    /**
     * Creates new form ModificarProducto
     */
    PreparedStatement pst;
    String filename = null;
    String codigo = null;
    Integer precioTotalActual = 0;

    ControllerProducto sqlProductos = new ControllerProducto();
    ConexionBD ventana = new ConexionBD();
    Connection cm = ventana.conexion();

    public ModificarProducto() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        //FuncionesBaseDeDatos.DatabaseConnection();
    }

    private void ActualizarCampos(String producto) {
        try {

            //seleccionar todo de la tabla categoria
            pst = cm.prepareStatement("SELECT * FROM producto");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                if (rs.getString("nombre").equals(producto)) {
                    jTextFieldNuevoNombre.setText(rs.getString("nombre"));
                    jTextFieldNuevoCodigo.setText(rs.getString("id"));
                    codigo = rs.getString("id");
                    precioTotalActual = rs.getInt("precioTotal");                   
                    jTextFieldNuevoPrecioU.setText(rs.getString("precioUnidad"));
                    jTextFieldNuevaCantidad.setText(rs.getString("cantidad"));
                    sqlProductos.mostrarImagen(rs.getString("ImagenUrl"), jLabelImagenProducto);
                    filename = rs.getString("ImagenUrl");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionDeCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateCategoriesComboBox() {
        try {

            //seleccionar todo de la tabla categoria
            pst = cm.prepareStatement("SELECT * FROM categoria");
            ResultSet rs = pst.executeQuery();

            //creamos tabla modelo
            DefaultComboBoxModel dataBox = (DefaultComboBoxModel) jComboBoxCategorias.getModel();

            // iterar por el resulset
            while (rs.next()) {
                jComboBoxCategorias.addItem(rs.getString("categoria"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(GestionDeCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ModificarProducto() {
        try {
            //categoria seleccionada
            String nombreCategoria = jComboBoxCategorias.getSelectedItem().toString();
            //modificar categoria en la base de datos sql statement
            pst = cm.prepareStatement("UPDATE producto SET  id=?, nombre=?, categoria = ?, cantidad=?, precioTotal=?, precioUnidad=?, imagenUrl=? WHERE nombre = ?");
            pst.setString(1, jTextFieldNuevoCodigo.getText());
            pst.setString(2, jTextFieldNuevoNombre.getText());
            pst.setString(3, nombreCategoria);
            pst.setString(4, jTextFieldNuevaCantidad.getText());
            pst.setInt(5, sqlProductos.ConversionInteger(jTextFieldNuevoPrecioU.getText()) * sqlProductos.ConversionInteger(jTextFieldNuevaCantidad.getText()));
            pst.setString(6, jTextFieldNuevoPrecioU.getText());
            pst.setString(7, filename);
            pst.setString(8, jLabelProducto.getText());
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
        jButtonModificar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabelProducto = new javax.swing.JLabel();
        jTextFieldNuevoCodigo = new javax.swing.JTextField();
        jTextFieldNuevoNombre = new javax.swing.JTextField();
        jComboBoxCategorias = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jButtonCategorias = new javax.swing.JButton();
        jButtonUsuario = new javax.swing.JButton();
        jButtonFiltroBusqueda3 = new javax.swing.JButton();
        jButtonProductos3 = new javax.swing.JButton();
        jTextFieldNuevoPrecioU = new javax.swing.JTextField();
        jTextFieldNuevaCantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButtonSeleccionarImagen = new javax.swing.JButton();
        jLabelImagenProducto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

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

        jButtonCancelar.setBackground(new java.awt.Color(255, 102, 102));
        jButtonCancelar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabelProducto.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabelProducto.setForeground(new java.awt.Color(41, 113, 222));
        jLabelProducto.setText("Modificar producto");

        jTextFieldNuevoCodigo.setText("Nuevo código");
        jTextFieldNuevoCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldNuevoCodigoMouseClicked(evt);
            }
        });

        jTextFieldNuevoNombre.setText("Nuevo nombre ");
        jTextFieldNuevoNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldNuevoNombreMouseClicked(evt);
            }
        });
        jTextFieldNuevoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNuevoNombreActionPerformed(evt);
            }
        });

        jComboBoxCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoriasActionPerformed(evt);
            }
        });

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
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonProductos3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFiltroBusqueda3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jButtonUsuario)
                .addGap(18, 18, 18)
                .addComponent(jButtonFiltroBusqueda3)
                .addGap(18, 18, 18)
                .addComponent(jButtonCategorias)
                .addGap(18, 18, 18)
                .addComponent(jButtonProductos3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextFieldNuevoPrecioU.setText("Precio última unidad");
        jTextFieldNuevoPrecioU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldNuevoPrecioUMouseClicked(evt);
            }
        });
        jTextFieldNuevoPrecioU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNuevoPrecioUActionPerformed(evt);
            }
        });

        jTextFieldNuevaCantidad.setText("Cantidad");
        jTextFieldNuevaCantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldNuevaCantidadMouseClicked(evt);
            }
        });
        jTextFieldNuevaCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNuevaCantidadActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Nombre ");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Precio de última unidad");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Código");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Categoria");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setText("Cantidad");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setText("Imagen");

        jButtonSeleccionarImagen.setBackground(new java.awt.Color(102, 255, 51));
        jButtonSeleccionarImagen.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonSeleccionarImagen.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSeleccionarImagen.setText("Seleccionar");
        jButtonSeleccionarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeleccionarImagenActionPerformed(evt);
            }
        });

        jLabelImagenProducto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNuevoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldNuevoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldNuevoPrecioU, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButtonCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                .addComponent(jButtonModificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldNuevaCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelImagenProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonSeleccionarImagen)))))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabelProducto)
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNuevoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNuevaCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNuevoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel11)
                    .addComponent(jButtonSeleccionarImagen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextFieldNuevoPrecioU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(jButtonModificar))
                    .addComponent(jLabelImagenProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonCancelar)
                .addContainerGap(122, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        if (sqlProductos.chequeoCampos(jTextFieldNuevoNombre, jTextFieldNuevoCodigo, jTextFieldNuevaCantidad,  jTextFieldNuevoPrecioU, jLabelProducto.getText(), codigo) == true) {
            String botones[] = {"Aceptar", "Cancelar"};
            int eleccion = JOptionPane.showOptionDialog(this, "Desea modificar este producto?", null, 0, 0, null, botones, this);
            if (eleccion == JOptionPane.YES_OPTION) {
                ModificarProducto();
                this.dispose();
                InfoProducto Producto = new InfoProducto();
                Producto.jLabelProducto.setText(jTextFieldNuevoNombre.getText());
                Producto.MostrarInfo(jTextFieldNuevoNombre.getText());
                Producto.setVisible(true);
                this.dispose();
                JOptionPane.showMessageDialog(null, "Producto modificado satisfactoriamente");
            }
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        InfoProducto Producto = new InfoProducto();
        Producto.jLabelProducto.setText(jTextFieldNuevoNombre.getText());
        Producto.MostrarInfo(jTextFieldNuevoNombre.getText());
        Producto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldNuevoCodigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldNuevoCodigoMouseClicked
        // TODO add your handling code here:
        jTextFieldNuevoCodigo.setText(null);
    }//GEN-LAST:event_jTextFieldNuevoCodigoMouseClicked

    private void jTextFieldNuevoNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldNuevoNombreMouseClicked
        // TODO add your handling code here:
        jTextFieldNuevoNombre.setText(null);
    }//GEN-LAST:event_jTextFieldNuevoNombreMouseClicked

    private void jTextFieldNuevoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNuevoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNuevoNombreActionPerformed

    private void jComboBoxCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCategoriasActionPerformed

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

    private void jTextFieldNuevoPrecioUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldNuevoPrecioUMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNuevoPrecioUMouseClicked

    private void jTextFieldNuevoPrecioUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNuevoPrecioUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNuevoPrecioUActionPerformed

    private void jTextFieldNuevaCantidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldNuevaCantidadMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNuevaCantidadMouseClicked

    private void jTextFieldNuevaCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNuevaCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNuevaCantidadActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        ActualizarCampos(jLabelProducto.getText());
        updateCategoriesComboBox();

    }//GEN-LAST:event_formWindowOpened

    private void jButtonSeleccionarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSeleccionarImagenActionPerformed
        // TODO add your handling code here:
        filename = sqlProductos.seleccionarImagen();
        if (filename.equals("invalido")) {
            JOptionPane.showMessageDialog(null, "El archivo seleccionado es inválido", "Error", JOptionPane.ERROR_MESSAGE);
            filename = null;
        } else {
            sqlProductos.mostrarImagen(filename, jLabelImagenProducto);
        }
        sqlProductos.mostrarImagen(filename, jLabelImagenProducto);
    }//GEN-LAST:event_jButtonSeleccionarImagenActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCategorias;
    private javax.swing.JButton jButtonFiltroBusqueda3;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonProductos3;
    private javax.swing.JButton jButtonSeleccionarImagen;
    private javax.swing.JButton jButtonUsuario;
    private javax.swing.JComboBox<String> jComboBoxCategorias;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelImagenProducto;
    public javax.swing.JLabel jLabelProducto;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextFieldNuevaCantidad;
    private javax.swing.JTextField jTextFieldNuevoCodigo;
    private javax.swing.JTextField jTextFieldNuevoNombre;
    private javax.swing.JTextField jTextFieldNuevoPrecioU;
    // End of variables declaration//GEN-END:variables
}