
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
    String usuario = "sa";
    String pass= "Brayan.DEV**";
    String bd="javaserver";
    String ip = "localhost";
    String puerto = "1433";
    //String cadena = "jdbc:sqlserver//"+ip+":"+puerto+"/"+bd;
    
    public Connection establecerConexion(){
        try{
                //String cadena = "jdbc:sqlserver://localhost\\LAPTOP-B5JDEKBQ:1433;databaseName=javaserver;user=sa;password=Brayan.DEV**";
                String cadena = "jdbc:sqlserver://localhost:1433;databaseName=javaserver;user=sa;password=Brayan.DEV**;integratedSecurity=false;encrypt=false;trustServerCertificate=false;loginTimeout=30;trustStore=C:\\Program Files\\Java\\jdk-15.0.2\\lib\\security\\cacerts;";
                        //+puerto+";"+"databaseName="+bd;

            conexion=DriverManager.getConnection(cadena); 
           //  System.out.println("hola Dio!");
          //  JOptionPane.showMessageDialog(null,"Exito en la conexion");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error conexion"+e.toString());
        }
        return conexion;
    }

    
       
}
