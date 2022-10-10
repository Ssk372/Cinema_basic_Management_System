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
public class DBClasificacion {
    public static void agregarclasi(Encapsulamientoclasificacion e1)
    {
    conectar c1 =new conectar();
Connection db = c1.conectar();   

try {
    String consulta= "INSERT INTO clasificaciones (Clasificacion) VALUES (?)";
    PreparedStatement ps = db.prepareStatement(consulta);
    ps.setString(1, e1.getClasificacion());
    ps.executeUpdate();
    ps.close();
    db.close();
    JOptionPane.showMessageDialog(null, "Se a agregado con exito");
}
catch(SQLException ex)
{
    JOptionPane.showMessageDialog(null, "Muajajaja, no se pudo acceder a la base de datos(risa malevola)" + ex.getMessage());


}
    }
    public static List<Encapsulamientoclasificacion>mostrarclasi()
{
List <Encapsulamientoclasificacion> Listas = new ArrayList<>();
   conectar c1 =new conectar();
Connection db = c1.conectar();

try{

    String consulta = "SELECT * FROM clasificaciones";
    PreparedStatement ps = db.prepareStatement(consulta);
    ResultSet resultSet =ps.executeQuery();
    
    while(resultSet.next())
    {
    Encapsulamientoclasificacion clasi = new Encapsulamientoclasificacion();
    clasi.setId(resultSet.getInt("ID"));
    clasi.setClasificacion(resultSet.getString("Clasificacion"));
    
    Listas.add(clasi);
    
    
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
      public static List<Encapsulamientoclasificacion> mostrarclasi(int vid)
{
List <Encapsulamientoclasificacion> Listas = new ArrayList<>();
   conectar c1 =new conectar();
Connection db = c1.conectar();

try{

   String consulta = "SELECT * FROM clasificaciones WHERE ID=?";
    PreparedStatement ps = db.prepareStatement(consulta);
    ps.setInt(1, vid);
    
    ResultSet resultSet =ps.executeQuery();
    
    while(resultSet.next())
    {
     Encapsulamientoclasificacion clasi = new Encapsulamientoclasificacion();
     clasi.setId(resultSet.getInt("ID"));
           clasi.setClasificacion(resultSet.getString("Clasificacion"));

            
    Listas.add(clasi);
    
    
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
  public static boolean actualizarclasi(Encapsulamientoclasificacion e1)
  {
    conectar c1 =new conectar();
Connection db = c1.conectar();

boolean resultado=false;

try {

String consulta = "UPDATE clasificaciones set Clasificacion=? WHERE ID=?";
PreparedStatement ps =db.prepareStatement(consulta);
ps.setString(1, e1.getClasificacion());
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
  public static boolean Eliminarclasi(int vid)
  {
    conectar c1 =new conectar();
Connection db = c1.conectar();

boolean resultado=false;

try {

String consulta = "DELETE FROM clasificaciones WHERE ID=?";
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
