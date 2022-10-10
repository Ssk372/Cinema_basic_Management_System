/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Axel
 */
public class DBRangoCliente {
    public static void agregarrango(EncapsulamientoRangoc e1)
    {
    conectar c1 =new conectar();
Connection db = c1.conectar();   

try {
    String consulta= "INSERT INTO rangosclientes (Nombre) VALUES (?)";
    PreparedStatement ps = db.prepareStatement(consulta);
    ps.setString(1, e1.getNombrerango());
    ps.executeUpdate();
    ps.close();
    db.close();
    JOptionPane.showMessageDialog(null, "Se a agregado con exito ☺");
}
catch(SQLException ex)
{
    JOptionPane.showMessageDialog(null, "Muajajaja, no se pudo acceder a la base de datos(risa malevola)" + ex.getMessage());


}
    }
    public static List<EncapsulamientoRangoc>mostrarrango()
{
List <EncapsulamientoRangoc> Listas = new ArrayList<>();
   conectar c1 =new conectar();
Connection db = c1.conectar();

try{

    String consulta = "SELECT * FROM rangosclientes";
    PreparedStatement ps = db.prepareStatement(consulta);
    ResultSet resultSet =ps.executeQuery();
    
    while(resultSet.next())
    {
    EncapsulamientoRangoc rango = new EncapsulamientoRangoc();
    rango.setId(resultSet.getInt("ID"));
    rango.setNombrerango(resultSet.getString("Nombre"));
    
    Listas.add(rango);
    
    
    }
    ps.close();
    db.close();

}
catch(SQLException ex)
{
JOptionPane.showConfirmDialog(null,"error, no se ha podido mostrar, mujajajajaja."+ ex.getMessage());

}
return Listas;
}
      public static List<EncapsulamientoRangoc> mostrarrango(int vid)
{
List <EncapsulamientoRangoc> Listas = new ArrayList<>();
   conectar c1 =new conectar();
Connection db = c1.conectar();

try{

   String consulta = "SELECT * FROM rangosclientes WHERE ID=?";
    PreparedStatement ps = db.prepareStatement(consulta);
    ps.setInt(1, vid);
    
    ResultSet resultSet =ps.executeQuery();
    
    while(resultSet.next())
    {
     EncapsulamientoRangoc rango = new EncapsulamientoRangoc();
     rango.setId(resultSet.getInt("ID"));
      rango.setNombrerango(resultSet.getString("Nombre"));

            
    Listas.add(rango);
    
    
    }
    ps.close();
    db.close();

}
catch(SQLException ex)
{
JOptionPane.showConfirmDialog(null,"error"+ ex.getMessage());

}
return Listas;
}
  public static boolean actualizarrango(EncapsulamientoRangoc e1)
  {
    conectar c1 =new conectar();
Connection db = c1.conectar();

boolean resultado=false;

try {

String consulta = "UPDATE rangosclientes set Nombre=? WHERE ID=?";
PreparedStatement ps =db.prepareStatement(consulta);
ps.setString(1, e1.getNombrerango());
ps.setInt(2, e1.getId());
    ps.executeUpdate();
ps.executeUpdate();
ps.close();
db.close();
resultado=true;
}
catch(SQLException ex)
{

JOptionPane.showConfirmDialog(null,"error"+ ex.getMessage());

}
return resultado;
  }
  public static boolean eliminarrangoc(int vid)
  {
    conectar c1 =new conectar();
Connection db = c1.conectar();

boolean resultado=false;

try {

String consulta = "DELETE FROM rangosclientes WHERE ID=?";
PreparedStatement ps =db.prepareStatement(consulta);
ps.setInt(1, vid);
ps.executeUpdate();
ps.close();
db.close();
resultado=true;
}
catch(SQLException ex)
{

JOptionPane.showConfirmDialog(null,"error"+ ex.getMessage());

}
return resultado;
  }
    
}
