/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

/**
 *
 * @author German Valdez
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import org.apache.commons.dbcp.BasicDataSource;

public class Conexion{
    private DataSource dataSource;
    
    /*public Conexion(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://104.131.187.70/pruebas?autoReconnect=true&useSSL=false");
        basicDataSource.setUsername("megapub");
        basicDataSource.setPassword("sistemas");
        
        dataSource = basicDataSource;
    }*/
    
    public Connection conectar2(){ // Creac
        try {
            return dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } //Uso con Pool de conexion
    
    public Connection conectar(){ // Uso tradicional de conexionBD
        Connection con;
        try{
           Class.forName("com.mysql.jdbc.Driver");
           String url = "jdbc:mysql://187.204.9.178:3306/megapublicidad?autoReconnect=true&useSSL=false";
           con = DriverManager.getConnection(url, "megapub", "sistemas");
           //String url = "jdbc:mysql://localhost/megapublicidad";
           //con = DriverManager.getConnection(url, "root", "");
        }
        //ip publica = 189.234.26.151
        //ip publica 2 = 187.204.9.178 -- 187.204.9.178:3306
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error en la Conexión con la BD "+ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            con=null;
        }
        return con;
    }
}