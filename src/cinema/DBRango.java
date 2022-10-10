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
public class DBRango {
    public static void agregarrango(EncapsulamientoRango e1)
    {
    conectar c1 =new conectar();
Connection db = c1.conectar();   

try {
    String consulta= "INSERT INTO rango (Nombre) VALUES (?)";
    PreparedStatement ps = db.prepareStatement(consulta);
    ps.setString(1, e1.getNombre());
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
    public static List<EncapsulamientoRango>mostrarrango()
{
List <EncapsulamientoRango> Listas = new ArrayList<>();
   conectar c1 =new conectar();
Connection db = c1.conectar();

try{

    String consulta = "SELECT * FROM rango";
    PreparedStatement ps = db.prepareStatement(consulta);
    ResultSet resultSet =ps.executeQuery();
    
    while(resultSet.next())
    {
    EncapsulamientoRango rango = new EncapsulamientoRango();
    rango.setID(resultSet.getInt("ID"));
    rango.setNombre(resultSet.getString("Nombre"));
    
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
      public static List<EncapsulamientoRango> mostrarrango(int vid)
{
List <EncapsulamientoRango> Listas = new ArrayList<>();
   conectar c1 =new conectar();
Connection db = c1.conectar();

try{

   String consulta = "SELECT * FROM rango WHERE ID=?";
    PreparedStatement ps = db.prepareStatement(consulta);
    ps.setInt(1, vid);
    
    ResultSet resultSet =ps.executeQuery();
    
    while(resultSet.next())
    {
     EncapsulamientoRango rango = new EncapsulamientoRango();
     rango.setID(resultSet.getInt("ID"));
      rango.setNombre(resultSet.getString("Nombre"));

            
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
  public static boolean actualizarrango(EncapsulamientoRango e1)
  {
    conectar c1 =new conectar();
Connection db = c1.conectar();

boolean resultado=false;

try {

String consulta = "UPDATE rango set Nombre=? WHERE ID=?";
PreparedStatement ps =db.prepareStatement(consulta);
ps.setString(1, e1.getNombre());
ps.setInt(2, e1.getID());
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
  public static boolean eliminarrango(int vid)
  {
    conectar c1 =new conectar();
Connection db = c1.conectar();

boolean resultado=false;

try {

String consulta = "DELETE FROM rango WHERE ID=?";
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
