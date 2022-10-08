
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brest
 */
public class connection {
    Connection conexion = null;
    
    public Connection establecerConexion(){
        try{
               
         String cadena = "jdbc:sqlserver://localhost:1433;databaseName=javaserver;user=sa;password=Brayan.DEV**;integratedSecurity=false;encrypt=false;trustServerCertificate=false;loginTimeout=30;trustStore=C:\\Program Files\\Java\\jdk-15.0.2\\lib\\security\\cacerts;";

         conexion=DriverManager.getConnection(cadena); 
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error conexion"+e.toString());
        }
        return conexion;
    }

    
       
}
