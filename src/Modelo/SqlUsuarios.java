package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;

public class SqlUsuarios extends ConexionBD {

    public boolean registrar(Usuarios user) throws SQLException {
        PreparedStatement ps = null;
        ConexionBD ventana = new ConexionBD();
        Connection cm = ventana.conexion();

        String sql = "INSERT INTO usuarios (user, password, nombre, correo, "
                + "id_tipo) VALUES(?,?,?,?,?)";

        try {
            ps = cm.prepareStatement(sql);
            ps.setString(1, user.getUsuario());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getNombre());
            ps.setString(4, user.getCorreo());
            ps.setInt(5, user.getId_tipo());
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.err.println("ex");
            conexion().rollback();
            return false;
        }finally{
            try {
                cm.close();
            } catch (SQLException ex) {
                System.err.println("ex");
            }
        }
    }
    
    public boolean modificar (Usuarios user) throws SQLException {
        PreparedStatement ps = null;
        ConexionBD ventana = new ConexionBD();
        Connection cm = ventana.conexion();

        String sql = "UPDATE usuarios SET user=?, nombre=?, correo=?, id_tipo=? WHERE id = ?";

        try {
            ps = cm.prepareStatement(sql);
            ps.setString(1, user.getUsuario());
            ps.setString(2, user.getNombre());
            ps.setString(3, user.getCorreo());
            ps.setInt(4,user.getId_tipo());
            ps.setInt(5, user.getId());
            ps.execute();
            return true;

        } catch (SQLException ex) {
            System.err.println("ex");
            return false;
        }finally{
            try {
                cm.close();
            } catch (SQLException ex) {
                conexion().rollback();
                System.err.println("ex");
            }
        }
    }   
    
    public boolean eliminar (String user) throws SQLException {
        PreparedStatement ps;
        ConexionBD ventana = new ConexionBD();
        Connection cm = ventana.conexion();

        String sql = "DELETE FROM usuarios WHERE nombre = ?";

        try {
            ps = cm.prepareStatement(sql);
            ps.setString(1, user);
            ps.execute();
            return true;

        } catch (SQLException ex) {
            System.err.println("ex");
            conexion().rollback();
            return false;
        }finally{
            try {
                cm.close();
            } catch (SQLException ex) {
                System.err.println("ex");
            }
        }
    }   
         
    public boolean logIn(Usuarios user) throws SQLException {
        PreparedStatement ps;
        ResultSet rs;
        ConexionBD ventana = new ConexionBD();
        Connection cm = ventana.conexion();
        
        //cosulta multitabla
        String sql = "SELECT u.id, u.user, u.password, u.nombre, u.id_tipo, t.nombre FROM "
                + "usuarios AS u INNER JOIN tipo_usuario AS t ON u.id_tipo=t.id WHERE user = ?";

        try {
            ps = cm.prepareStatement(sql);
            ps.setString(1, user.getUsuario());
            rs = ps.executeQuery();

            if (rs.next()) {
                if (user.getPassword().equals(rs.getString(3))){
                    
                    String sqlUpdate = "UPDATE usuarios SET last_sesion = ? WHERE id= ?";
                    ps = cm.prepareStatement(sqlUpdate);
                    ps.setString(1,user.getLast_sesion());
                    ps.setInt(2,rs.getInt(1));
                    ps.execute();
                    
                    user.setId(rs.getInt(1));
                    user.setNombre(rs.getString(4));
                    user.setId_tipo(rs.getInt(5));
                    user.setNombre_tipo(rs.getString(6));
                    
                    return true;
                }else{
                    return false;
                }
            }
            
            return false;

        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            conexion().rollback();
            return false;
        }
    }

    public boolean changePsw(Usuarios user) throws SQLException{
        PreparedStatement ps;
        ConexionBD ventana = new ConexionBD();
        Connection cm = ventana.conexion();
        
        String sqlUpdate = "UPDATE usuarios SET password = ? WHERE user= ?";
        
        try {
            ps = cm.prepareStatement(sqlUpdate);
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getUsuario());
            ps.execute();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            conexion().rollback();
            return false;
        }
    }
    
    public int existeUsuario(String user) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionBD ventana = new ConexionBD();
        Connection cm = ventana.conexion();

        String sql = "SELECT count(id) FROM usuarios WHERE user = ?";

        try {
            ps = cm.prepareStatement(sql);
            ps.setString(1, user);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;

        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            conexion().rollback();
            return 1;
        }
    }

    public boolean esEmail(String correo) {
        // Patrón para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(correo);

        return mather.find();

    }
    
    public boolean esAlphaNumeric(String s){
        String pattern= "^[a-zA-Z0-9]*$";
        return s.matches(pattern);
}
    
    public boolean esAlpha(String s){
        String pattern= "^[a-z]*$";
        return s.matches(pattern);
    }
    
    public boolean valUser (String s){
        if (esAlpha(s)){
            if (s.length()>=5 && s.length()<=8){
                if (s.equals(s.toLowerCase())){
                    return true;
                }
            }    
        }
        return false;
    }
    
    public DefaultTableModel consultar (DefaultTableModel modelo) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        ConexionBD ventana = new ConexionBD();
        Connection cm = ventana.conexion();
        
        String sql = "SELECT u.nombre, t.nombre FROM "
                + "usuarios AS u INNER JOIN tipo_usuario AS t ON u.id_tipo=t.id";
        
        try {
            ps = cm.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            
            modelo.addColumn("Nombre");
            modelo.addColumn("Status");
            Object[] filas = new Object[cantidadColumnas];
            
            while (rs.next()){
                for (int i = 0; i< cantidadColumnas ; i++){
                    filas[i] = rs.getObject(i+1);
                    
                }
                modelo.addRow(filas);
            }
            return modelo;
        } catch (SQLException ex) {
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            conexion().rollback();
            return modelo;
        }
    }
    
    public Usuarios getUsuario (String nombre){
        PreparedStatement ps;
        ResultSet rs;
        ConexionBD ventana = new ConexionBD();
        Connection cm = ventana.conexion();
        Usuarios user = new Usuarios();
        
        String sql = "SELECT id,user, nombre, correo, id_tipo FROM usuarios WHERE nombre = ?";
        
        try {
            ps = cm.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
        
            while  (rs.next()){
                if (rs.getString("nombre").equals(nombre)){
                    user.setId(rs.getInt(1));
                    user.setUsuario(rs.getString(2));
                    user.setNombre(rs.getString(3));
                    user.setCorreo(rs.getString(4));
                    user.setId_tipo(rs.getInt(5));
                    return user;
                }
            }
        } catch (SQLException e) {
            
        }
        user = null;
        return user;
    }
}
    
