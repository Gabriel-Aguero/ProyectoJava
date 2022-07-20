
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GABY
 */
public class Persistencia {
    private Connection cn;
    private ResultSet rs;
    private PreparedStatement ps;
    
    public String servidor, basededatos, usuario, clave, ejecutar;
    private ResultSetMetaData rsm;
    public Connection conectarse() throws SQLException{
                 
        try {        
            Class.forName("com.mysql.jdbc.Driver");
            servidor = "localhost:3307/";
            basededatos ="cacproyecto2022";
            usuario = "root";
            clave = "";
             cn = DriverManager.getConnection("jdbc:mysql://" + servidor + basededatos + "?autoReconne=true&useSSL", usuario, clave);
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return cn;
    }
    
    public ResultSet consultaSQL(String busqueda){
        try {
            ps = conectarse().prepareStatement(busqueda);
            rs = ps.executeQuery();
       // rsm = rs.getMetaData();
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
}
