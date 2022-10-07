
import java.awt.HeadlessException;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brest
 */
public class ControlEmpleado {
    public ControlEmpleado(){}
    static connection cnx = new connection();
    static Connection con = cnx.establecerConexion();
    
    
    static List<Empleado> listaEmpleados = new ArrayList<Empleado>();
   
    public  void RegistrarEmpleado(Empleado emp){
        String sql = "INSERT INTO empleado VALUES(?,?,?,?,?,?);";
        
        
        try{
            PreparedStatement state = con.prepareStatement(sql);
            state.setString(1, emp.cc);
            state.setString(2, emp.nombre);
            state.setString(3, emp.apellido);
            state.setString(4, emp.telefono);
            state.setString(5, emp.ciudad);
            state.setString(6, emp.direccion);
            
            int registroAdd = state.executeUpdate();
            if(registroAdd>0){
                System.out.println();
                System.out.println("REGISTRO EXITOSO");
                JOptionPane.showMessageDialog(null,"REGISTRO EXITOSO");
            }
        }catch(HeadlessException | SQLException e){
          System.out.println("Error conexion"+e.toString());

        }
        
    }
    
    @SuppressWarnings("empty-statement")
    
    public  void obtenerdatos(DefaultTableModel mdtabla){
         String sql = "SELECT * FROM empleado;";
        
        
        
        try{
            //PreparedStatement ps  = con.prepareStatement(sql);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();      
            int columnas = rsmd.getColumnCount();
            
            while(rs.next()){
                
                String fila[] = new String[columnas];
                  fila[0]=rs.getString("id");
                fila[1]=rs.getString("cc");
                fila[2]=rs.getString("nombre");
                fila[3]=rs.getString("apellido");
                fila[4]=rs.getString("telefono");
                fila[5]=rs.getString("ciudad");
                fila[6]=rs.getString("direccion");             
                mdtabla.addRow(fila);

            };
        
        }catch(SQLException e){
          System.out.println("Error conexion"+e.toString());
          JOptionPane.showMessageDialog(null,e.toString());

        }
        
       
    }
    
    
    public void actualizarEmpleado(String cc,Empleado emp){
        String sql = "UPDATE empleado SET nombre=?,apellido=?,telefono=?,ciudad=?,direccion=? WHERE cc=?;";
        try{
            PreparedStatement state = con.prepareStatement(sql);
            state.setString(1,emp.nombre);
            state.setString(2,emp.apellido);
            state.setString(3,emp.telefono);
            state.setString(4,emp.ciudad);
            state.setString(5,emp.direccion);
            state.setString(6,cc);
            int rUp= state.executeUpdate();
            if(rUp>0){
                System.out.println("SE ACTUALIZO EL REGISTRO EXITOSAMENTE");
                JOptionPane.showMessageDialog(null,"SE ACTUALIZO EL REGISTRO EXITOSAMENTE");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void obtenerEmpleado(String cc,JTextField nom,JTextField ape,JTextField tel,JTextField ci,JTextField dir){
        String sql = "SELECT * FROM empleado WHERE cc="+cc+";";
        try{
            Statement state = con.createStatement();
            ResultSet rs= state.executeQuery(sql);
            while(rs.next()){
                nom.setText(rs.getString("nombre"));
                ape.setText(rs.getString("apellido"));
                tel.setText(rs.getString("telefono"));
                ci.setText(rs.getString("ciudad"));
                dir.setText(rs.getString("direccion"));
                
                /*System.out.println(
                "EMPLEADO: "+
                        "CC: "+rs.getString("cc")+
                        "NOMBRE: "+rs.getString("nombre")+
                        "APELLIDO: "+rs.getString("apellido")+
                        "TELEFONO: "+rs.getString("telefono")+
                        "CIUDAD: "+rs.getString("ciudad")+
                        "DIRECCION: "+rs.getString("direccion")
                );*/
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void borrarEmpleado(String cc){
        try{
            String sql = "DELETE FROM empleado WHERE cc="+cc+";";
            PreparedStatement state = con.prepareStatement(sql);
            int rdelete = state.executeUpdate();
            if(rdelete>0){
                System.out.println("EL REGISTRO SE BORRO EXITOSAMENTE");
                JOptionPane.showMessageDialog(null,"EL REGISTRO SE BORRO EXITOSAMENTE");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}

