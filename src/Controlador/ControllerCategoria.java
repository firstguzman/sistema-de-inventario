package Controlador;

import Modelo.ConexionBD;
import Vista.GestionDeCategoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class ControllerCategoria extends ConexionBD {
    ConexionBD FuncionesBaseDeDatos = new ConexionBD();
    PreparedStatement pst = null;

    public void updateCategoriesComboBox(JComboBox JComboBox) {

        try {

            //seleccionar todo de la tabla categoria
            Connection cm = FuncionesBaseDeDatos.conexion();
            pst = cm.prepareStatement("SELECT * FROM categoria");
            ResultSet rs = pst.executeQuery();

            //creamos tabla modelo
            DefaultComboBoxModel dataBox = (DefaultComboBoxModel) JComboBox.getModel();

            // iterar por el resulset
            while (rs.next()) {
                JComboBox.addItem(rs.getString("categoria"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexión con la base de datos");
        }
    }

    private int CodigoRepetido(String codigo) {

        try {
            //seleccionar todo de la tabla categoria
            Connection cm = FuncionesBaseDeDatos.conexion();
            pst = cm.prepareStatement("SELECT id FROM categoria");
            ResultSet rs = pst.executeQuery();

            // iterar por el resulset
            while (rs.next()) {
                if (rs.getString("id").equals(codigo)) {
                    return 1;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionDeCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    private int CategoriaRepetida(String nombre) {

        try {
            //seleccionar todo de la tabla categoria
            Connection cm = FuncionesBaseDeDatos.conexion();
            pst = cm.prepareStatement("SELECT categoria FROM categoria");
            ResultSet rs = pst.executeQuery();

            // iterar por el resulset
            while (rs.next()) {
                if (rs.getString("categoria").equals(nombre)) {
                    return 1;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestionDeCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public boolean chequeo(JTextField nombre, JTextField codigo, String nombreActual, String codigoActual) {

        if (nombre.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese nombre de la categoria", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (codigo.getText().isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese codigo de la categoria", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (CategoriaRepetida(nombre.getText()) == 1 && nombre.getText().equals(nombreActual) == false) {
            JOptionPane.showMessageDialog(null, "El nombre ya se encuentra registrado", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (CodigoRepetido(codigo.getText()) == 1 && codigo.getText().equals(codigoActual) == false) {
            JOptionPane.showMessageDialog(null, "El codigo ya se encuentra registrado", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (codigo.getText().matches("[0-9]+")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "El codigo solo debe contener números", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
