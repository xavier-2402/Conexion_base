package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
     
    Connection conexion;
    
    public Conexion(){
        
        
    }
    
     public Connection conexion(String usuario,String password,boolean produccion)
    {
         
           String url="jdbc:postgresql://localhost:5432/Base_Autos";
           
           try{
               Class.forName("org.postgresql.Driver");
               conexion = DriverManager.getConnection(url,usuario,password);
               if(conexion !=null)
               {
                   System.out.println("CONECTADO A LA BASE DE DATOS");
               }
               
               
           }
           catch(Exception e)
           {
              JOptionPane.showMessageDialog(null,"PROBLEMAS DE CONEXION "+e);
           }
           
           return conexion;
         
    }
}
