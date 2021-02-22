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
 * 
 */



public class InfoProducto extends javax.swing.JFrame {
    
    //conexion base de datos
    PreparedStatement pst;
    ConexionBD ventana = new ConexionBD();
    Connection cm = ventana.conexion();
    ControllerProducto sqlProductos = new ControllerProducto();
    
    Integer idProducto = null;

    /**
     * Creates new form Producto
     */
    public InfoProducto() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        //FuncionesBaseDeDatos.DatabaseConnection();
        switch (actor.getId_tipo()) {
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                this.jButtonModificar.setVisible(false);
                this.jButtonEliminar.setVisible(false);
                this.jButtonModificarUbicacion.setVisible(false);
                this.jButtonAñadirMovimiento.setVisible(false);
                break;
            default:
                break;
        }
    }
    
    public String getCategoria(String producto){

            try {
                pst = cm.prepareStatement("SELECT * FROM producto");
                ResultSet rs = pst.executeQuery();               
                // iterar por el resulset
                while (rs.next())
                { 
                    if(rs.getString("nombre").equals(producto) ){
                        idProducto = rs.getInt("id");
                       return rs.getString("categoria");
                    }
                                    
                }                    
                    
            } catch (SQLException ex) {
                Logger.getLogger(GestionDeCategoria.class.getName()).log(Level.SEVERE, null, ex);
            }           

        return "";
    }
    
    private void tableUpdateMovimientos(){

            try {
                //seleccionar todo de la tabla categoria
                pst = cm.prepareStatement("SELECT * FROM movimiento");
                ResultSet rs = pst.executeQuery();               
                //creamos tabla modelo
                DefaultTableModel dataTable = (DefaultTableModel)jTableMovimientos.getModel();
                // iterar por el resulset
                while (rs.next())
                { 
                    if(rs.getString("producto").equals(jLabelProducto.getText()) ){
                        dataTable.addRow(new Object[]{rs.getInt("id"), rs.getString("tipo"), rs.getString("destino"), rs.getInt("cantidad"), rs.getString("usuario")});
                    }
                                    
                }               
            } catch (SQLException ex) {
                Logger.getLogger(GestionDeCategoria.class.getName()).log(Level.SEVERE, null, ex);
            }           
     
    }
    
    public void MostrarInfo(String producto){
        
        try {
            //seleccionar todo de la tabla categoria
            pst = cm.prepareStatement("SELECT * FROM producto");
            ResultSet rs = pst.executeQuery();

            // iterar por el resulset
            System.out.print(rs);
            while (rs.next()) {
                if (rs.getString("nombre").equals(producto)) {
                    jLabelCategoria.setText(rs.getString("categoria"));
                    jLabelCodigo.setText(rs.getString("id"));
                    if (rs.getInt("cantidad") == 0) {
                        jLabelDisponibilidad.setText("AGOTADO");
                    } else {
                        jLabelDisponibilidad.setText("DISPONIBLE");
                    }
                    jLabelPrecioT.setText(rs.getString("precioTotal"));
                    jLabelPrecioU.setText(rs.getString("precioUnidad"));
                    jLabelUnidades.setText(rs.getString("cantidad"));
                    jLabelUbicacion.setText(rs.getString("ubicacion"));
                    sqlProductos.mostrarImagen(rs.getString("ImagenUrl"), jLabelImagenProducto);

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionDeCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void EliminarProducto(String producto){
        try {
                 //eliminar movimientos de la bd
                pst = cm.prepareStatement("DELETE FROM movimiento WHERE producto = ?");
                pst.setString(1, producto);
                pst.executeUpdate();
                //eliminar producto en la base de datos sql statement
                pst = cm.prepareStatement("DELETE FROM producto WHERE nombre = ?");
                pst.setString(1, producto);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Producto eliminado satisfactoriamente", "", JOptionPane.WARNING_MESSAGE);
                          
            } catch (SQLException ex) {
                Logger.getLogger(GestionDeCategoria.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error de conexión con la base de datos", "", JOptionPane.WARNING_MESSAGE);
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
        jLabelProducto = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButtonCategorias = new javax.swing.JButton();
        jButtonUsuario = new javax.swing.JButton();
        jButtonFiltroBusqueda3 = new javax.swing.JButton();
        jButtonProductos3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelCodigo = new javax.swing.JLabel();
        jLabelUnidades = new javax.swing.JLabel();
        jLabelPrecioT = new javax.swing.JLabel();
        jLabelCategoria = new javax.swing.JLabel();
        jLabelDisponibilidad = new javax.swing.JLabel();
        jLabelPrecioU = new javax.swing.JLabel();
        jLabelImagenProducto = new javax.swing.JLabel();
        jButtonEliminar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonAñadirMovimiento = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableMovimientos = new javax.swing.JTable();
        jButtonModificarUbicacion = new javax.swing.JButton();
        jLabelUbicacion1 = new javax.swing.JLabel();
        jLabelUbicacion2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabelUbicacion = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabelProducto.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabelProducto.setForeground(new java.awt.Color(41, 113, 222));
        jLabelProducto.setText("Producto");

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
                .addGap(23, 23, 23)
                .addComponent(jButtonUsuario)
                .addGap(11, 11, 11)
                .addComponent(jButtonFiltroBusqueda3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCategorias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonProductos3)
                .addContainerGap(378, Short.MAX_VALUE))
        );

        jLabel1.setText("Código:");

        jLabel3.setText("Unidades:");

        jLabel4.setText("Categoria:");

        jLabel5.setText("Disponibilidad:");

        jLabel6.setText("Precio total:");

        jLabel7.setText("Precio Unidad:");

        jLabelCodigo.setText("Código:");

        jLabelUnidades.setText("Unidades:");

        jLabelPrecioT.setText("Preccio total:");

        jLabelCategoria.setText("Categoria:");

        jLabelDisponibilidad.setText("Disponibilidad:");

        jLabelPrecioU.setText("Precio Unidad:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelImagenProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelPrecioT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelUnidades)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelCodigo)
                        .addGap(144, 144, 144)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCategoria)
                    .addComponent(jLabelDisponibilidad)
                    .addComponent(jLabelPrecioU))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelImagenProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabelCodigo)
                            .addComponent(jLabelCategoria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel3)
                                .addComponent(jLabelUnidades))
                            .addComponent(jLabelDisponibilidad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(jLabelPrecioU))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jLabelPrecioT)))
                        .addGap(11, 31, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonEliminar.setBackground(new java.awt.Color(255, 102, 102));
        jButtonEliminar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEliminar.setText("- Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonModificar.setBackground(new java.awt.Color(255, 153, 102));
        jButtonModificar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonModificar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonAñadirMovimiento.setBackground(new java.awt.Color(51, 204, 0));
        jButtonAñadirMovimiento.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAñadirMovimiento.setText("Añaidr movimiento");
        jButtonAñadirMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAñadirMovimientoActionPerformed(evt);
            }
        });

        jTableMovimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Movimiento", "Destino", "Cantidad", "Usuario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableMovimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMovimientosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableMovimientos);

        jButtonModificarUbicacion.setBackground(new java.awt.Color(255, 153, 102));
        jButtonModificarUbicacion.setForeground(new java.awt.Color(255, 255, 255));
        jButtonModificarUbicacion.setText("Editar Ubicación");
        jButtonModificarUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarUbicacionActionPerformed(evt);
            }
        });

        jLabelUbicacion1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelUbicacion1.setText("Movimientos");

        jLabelUbicacion2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelUbicacion2.setText("Ubicación");

        jLabelUbicacion.setEditable(false);
        jLabelUbicacion.setColumns(20);
        jLabelUbicacion.setRows(5);
        jScrollPane1.setViewportView(jLabelUbicacion);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabelUbicacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonAñadirMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelUbicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonModificarUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(31, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProducto)
                    .addComponent(jButtonModificar)
                    .addComponent(jButtonEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUbicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonModificarUbicacion))
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUbicacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAñadirMovimiento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        // TODO add your handling code here:
       String botones[] = {"Aceptar","Cancelar"};
        int eleccion = JOptionPane.showOptionDialog (this,"Desea eliminar este producto?",null,0,0, null,botones,this);
        if (eleccion==JOptionPane.YES_OPTION){
           
            GestionDeProducto GestionDeProducto = new GestionDeProducto();
            GestionDeProducto.setVisible(true);
            this.dispose();
            EliminarProducto(jLabelProducto.getText());
       }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        // TODO add your handling code here:
       
         ModificarProducto ModificarProducto = new ModificarProducto();
         ModificarProducto.setVisible(true);
         this.dispose();

         ModificarProducto.jLabelProducto.setText(jLabelProducto.getText());
        
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonAñadirMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAñadirMovimientoActionPerformed
        // TODO add your handling code here:
        AñadirMovimiento AñadirMovimiento = new AñadirMovimiento();
        AñadirMovimiento.setVisible(true);
        this.dispose();
        AñadirMovimiento.jLabelNombreProducto.setText(jLabelProducto.getText());
    }//GEN-LAST:event_jButtonAñadirMovimientoActionPerformed
    

    private void jTableMovimientosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMovimientosMouseClicked

        int i = jTableMovimientos.getSelectedRow();
       
        if (i +1 == jTableMovimientos.getRowCount()){
            System.out.println("id");
            System.out.println(jTableMovimientos.getValueAt(i, 0));
            ModificarMovimiento ModificarMovimiento = new ModificarMovimiento();
            ModificarMovimiento.idMovimientoModificado = (Integer) jTableMovimientos.getValueAt(i, 0);
            ModificarMovimiento.nombreProducto = jLabelProducto.getText();
            ModificarMovimiento.actualizarCampos((Integer) jTableMovimientos.getValueAt(i, 0));        
            this.dispose();
            ModificarMovimiento.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Este movimiento no es modificable", "", JOptionPane.WARNING_MESSAGE);
        }
        

    }//GEN-LAST:event_jTableMovimientosMouseClicked

    private void jButtonModificarUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarUbicacionActionPerformed
        // TODO add your handling code here:
        ModificarUbicacion EditarUbicacion = new ModificarUbicacion();
        EditarUbicacion.jLabelProducto.setText(jLabelProducto.getText());
        EditarUbicacion.jTextFieldEditarUbicacion.setText(jLabelUbicacion.getText());
        EditarUbicacion.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButtonModificarUbicacionActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        MostrarInfo(jLabelProducto.getText());
        tableUpdateMovimientos();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(InfoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoProducto().setVisible(true);
                
                
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAñadirMovimiento;
    private javax.swing.JButton jButtonCategorias;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonFiltroBusqueda3;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonModificarUbicacion;
    private javax.swing.JButton jButtonProductos3;
    private javax.swing.JButton jButtonUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelDisponibilidad;
    private javax.swing.JLabel jLabelImagenProducto;
    private javax.swing.JLabel jLabelPrecioT;
    private javax.swing.JLabel jLabelPrecioU;
    public javax.swing.JLabel jLabelProducto;
    private javax.swing.JTextArea jLabelUbicacion;
    private javax.swing.JLabel jLabelUbicacion1;
    private javax.swing.JLabel jLabelUbicacion2;
    private javax.swing.JLabel jLabelUnidades;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableMovimientos;
    // End of variables declaration//GEN-END:variables
}
