package Controlador;

import Modelo.ConexionBD;
import Vista.GestionDeCategoria;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ControllerProducto {
    public String filename = new String();
    ConexionBD FuncionesBaseDeDatos = new ConexionBD();
    PreparedStatement pst;

    public boolean chequeoMovimiento(JComboBox jComboBoxMovimento, JTextField jTextFieldCantidadUnidades, JTextField jTextFieldDestino, JTextField jTextFieldPrecio) {
        //chequeo
        if (jTextFieldCantidadUnidades.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese cantidad", "Error", JOptionPane.ERROR_MESSAGE);
        }else if(jComboBoxMovimento.getSelectedItem().toString() == "Selecciona"){
             JOptionPane.showMessageDialog(null, "Por favor, seleccione un tipo de movimiento", "Error", JOptionPane.ERROR_MESSAGE);
        }else if (jTextFieldDestino.getText().isEmpty() && jTextFieldDestino.isVisible() == true) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese destino", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (jTextFieldPrecio.getText().isEmpty() && jTextFieldPrecio.isVisible() == true) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese precio", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (((ConversionInteger(jTextFieldCantidadUnidades.getText()) == -5000005) && jTextFieldCantidadUnidades.isVisible() == true) || ((ConversionInteger(jTextFieldPrecio.getText())) == -5000005) && jTextFieldPrecio.isVisible() == true) {
            JOptionPane.showMessageDialog(null, "La cantidad y el precio solo deben contener numeros", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            return true;
        }
        return false;
    }

    private int ProductoRepetido(String nombre) {

        try {
            Connection cm = FuncionesBaseDeDatos.conexion();
            pst = cm.prepareStatement("SELECT nombre FROM producto");
            ResultSet rs = pst.executeQuery();

            // iterar por el resulset
            while (rs.next()) {
                if (rs.getString("nombre").equals(nombre)) {
                    return 1;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(GestionDeCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    private int CodigoRepetido(String codigo) {

        try {
            Connection cm = FuncionesBaseDeDatos.conexion();
            pst = cm.prepareStatement("SELECT id FROM producto");
            ResultSet rs = pst.executeQuery();

            // iterar por el resulset
            while (rs.next()) {
                if (rs.getInt("id") == Integer.parseInt(codigo.trim())) {
                    return 1;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(GestionDeCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public boolean chequeoCampos(JTextField JTextFieldNombre, JTextField JTextFieldCodigo, JTextField JTextFieldCantidad, JTextField JTextFieldPrecioUnidad, String nombreActual, String codigoActual) {

        if (JTextFieldNombre.getText().isEmpty() || JTextFieldCodigo.getText().isEmpty() || JTextFieldCantidad.getText().isEmpty() || JTextFieldPrecioUnidad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Faltan campos por rellenar", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (ConversionInteger(JTextFieldCodigo.getText()) == -5000005 || ConversionInteger(JTextFieldCantidad.getText()) == -5000005 || ConversionInteger(JTextFieldPrecioUnidad.getText()) == -5) {
            JOptionPane.showMessageDialog(null, "El codigo, la cantidad y los precios deben contener unicamente números", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (ProductoRepetido(JTextFieldNombre.getText()) == 1 && (JTextFieldNombre.getText().equals(nombreActual) == false)) {
            JOptionPane.showMessageDialog(null, "Nombre ya registrado", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (CodigoRepetido(JTextFieldCodigo.getText()) == 1 && (JTextFieldCodigo.getText().equals(codigoActual) == false)) {
            JOptionPane.showMessageDialog(null, "Codigo ya registrado", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            return true;
        }
        return false;
    }

    public static String getFileExtension(String fullName) {
        String fileName = new File(fullName).getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

    public String seleccionarImagen() {
        JFileChooser seleccionadorImagen = new JFileChooser();
        seleccionadorImagen.showOpenDialog(null);
        File archivo = seleccionadorImagen.getSelectedFile();
        filename = archivo.getAbsolutePath();
        if (getFileExtension(filename).equals("png") || getFileExtension(filename).equals("img") || getFileExtension(filename).equals("jpeg") || getFileExtension(filename).equals("jpg")) {
            return filename;
        } else {
            return "invalido";
        }

    }

    public void mostrarImagen(String filename, JLabel jLabelImagenProducto) {
        ImageIcon imageicon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(jLabelImagenProducto.getWidth(), jLabelImagenProducto.getHeight(), Image.SCALE_SMOOTH));
        jLabelImagenProducto.setIcon(imageicon);
        try {

        } catch (Exception e) {

        }
    }

    public int ConversionInteger(String numero) {

        int numeroConvertido = -5000005;
        try {
            // the String to int conversion happens here
            numeroConvertido = Integer.parseInt(numero.trim());
        } catch (NumberFormatException nfe) {

        }
        return numeroConvertido;
    }


}
