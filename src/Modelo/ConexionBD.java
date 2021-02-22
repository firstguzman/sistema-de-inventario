package Modelo;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionBD {
    private Connection conectar = null;
    public Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemadeinventario","root","cesarguzman00");
            
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "no conectó"+ " " + e);
            
        }
        return conectar;
    }
}
