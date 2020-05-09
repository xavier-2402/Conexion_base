package Modelo;

import Conexion.Conexion;
import Vista.VistaFormulario;
import Vista.VistaLista;
import com.sun.istack.internal.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Auto {
    private int aut_id;
    private String aut_marca;
    private String aut_modelo;
    private int aut_anio;
    private String aut_color;
    private final String SQL_INSERT="INSERT INTO auto(aut_id,aut_marca,aut_modelo,aut_anio,aut_color)"+
            
            "VALUES(?,?,?,?,?) RETURNING aut_id; ";
     private final String SQL_SELECT="SELECT * FROM auto ";
      Conexion conexion = new Conexion();

    public Auto() {
    }

    public Auto(int aut_id, String aut_marca, String aut_modelo, int aut_anio, String aut_color) {
        this.aut_id = aut_id;
        this.aut_marca = aut_marca;
        this.aut_modelo = aut_modelo;
        this.aut_anio = aut_anio;
        this.aut_color = aut_color;
    }

    public int getAut_id() {
        return aut_id;
    }

    public void setAut_id(int aut_id) {
        this.aut_id = aut_id;
    }

    public String getAut_marca() {
        return aut_marca;
    }

    public void setAut_marca(String aut_marca) {
        this.aut_marca = aut_marca;
    }

    public String getAut_modelo() {
        return aut_modelo;
    }

    public void setAut_modelo(String aut_modelo) {
        this.aut_modelo = aut_modelo;
    }

    public int getAut_anio() {
        return aut_anio;
    }

    public void setAut_anio(int aut_anio) {
        this.aut_anio = aut_anio;
    }

    public String getAut_color() {
        return aut_color;
    }

    public void setAut_color(String aut_color) {
        this.aut_color = aut_color;
    }

   
    public String toString(){
        return aut_id+aut_marca+aut_modelo+aut_anio+aut_color;
    }
    public void cargarDatos(Auto auto,VistaFormulario formulario){
        auto.setAut_id(Integer.parseInt(formulario.getTxt_id().getText()));
        auto.setAut_marca(formulario.getTxt_marca().getText());
        auto.setAut_modelo(formulario.getTxt_modelo().getText());
        auto.setAut_anio(Integer.parseInt(formulario.getTxt_anio().getText()));
        auto.setAut_color(formulario.getTxt_color().getText());

        formulario.getTxt_id().setText("");
        formulario.getTxt_marca().setText("");
        formulario.getTxt_modelo().setText("");
        formulario.getTxt_anio().setText("");
        formulario.getTxt_color().setText("");
    }
   
    public int GuardarAuto(Auto auto){
           int id=0;
        try {
         
            String usuario="postgres";
            String password ="desarrollo";
          
            
            PreparedStatement comando = conexion.conexion(usuario, password, false).prepareStatement(SQL_INSERT);
            comando.setInt(1,auto.getAut_id()) ;
            comando.setString(2, auto.getAut_marca());
            comando.setString(3, auto.getAut_modelo());
            comando.setInt(4, auto.getAut_anio());
            comando.setString(5, auto.getAut_color());
            
            ResultSet res = comando.executeQuery();
            while(res.next()){
                id=res.getInt(1);
            }
            JOptionPane.showMessageDialog(null, "Datos Guardados");
            comando.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
        return id;
    }
    
    public void ListarAutos(VistaLista lista, Auto auto){
         String usuario="postgres";
            String password ="desarrollo";
        DefaultTableModel modelo = new DefaultTableModel();
         String [] cabecera={"ID","MARCA","MODELO","AÑO"," COLOR "};
         modelo.setColumnIdentifiers(cabecera);
         Object fila[] = new Object[modelo.getColumnCount()];
          try {
            Statement comando = conexion.conexion(usuario, password, false).createStatement();
            ResultSet res = comando.executeQuery(SQL_SELECT);
            
            while(res.next()){
                fila[0]=res.getString("aut_id");
                fila[1]=res.getString("aut_marca");
                fila[2]=res.getString("aut_modelo");
                fila[3]=res.getString("aut_anio");
                fila[4]=res.getString("aut_color");
                modelo.addRow(fila);
            }
            lista.getTabla_lista().setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
         
            
        
    }
    
}
