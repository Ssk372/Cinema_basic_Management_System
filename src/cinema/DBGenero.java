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
public class DBGenero {
    public static void agregargenero(Encapsulamientogenero e1)
    {
    conectar c1 =new conectar();
Connection db = c1.conectar();   

try {
    String consulta= "INSERT INTO genero (Genero) VALUES (?)";
    PreparedStatement ps = db.prepareStatement(consulta);
    ps.setString(1, e1.getGenero());
    ps.executeUpdate();
    ps.close();
    db.close();
    JOptionPane.showMessageDialog(null, "Genero agregado");
}
catch(SQLException ex)
{
    JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());


}
    }
    public static List<Encapsulamientogenero>mostrargenero()
{
List <Encapsulamientogenero> Listas = new ArrayList<>();
   conectar c1 =new conectar();
Connection db = c1.conectar();

try{

    String consulta = "SELECT * FROM genero";
    PreparedStatement ps = db.prepareStatement(consulta);
    ResultSet resultSet =ps.executeQuery();
    
    while(resultSet.next())
    {
    Encapsulamientogenero genero = new Encapsulamientogenero();
    genero.setId(resultSet.getInt("ID"));
    genero.setGenero(resultSet.getString("Genero"));
    
    Listas.add(genero);
    
    
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
      public static List<Encapsulamientogenero> mostrargenero(int vid)
{
List <Encapsulamientogenero> Listas = new ArrayList<>();
   conectar c1 =new conectar();
Connection db = c1.conectar();

try{

   String consulta = "SELECT * FROM genero WHERE ID=?";
    PreparedStatement ps = db.prepareStatement(consulta);
    ps.setInt(1, vid);
    
    ResultSet resultSet =ps.executeQuery();
    
    while(resultSet.next())
    {
     Encapsulamientogenero genero = new Encapsulamientogenero();
     genero.setId(resultSet.getInt("ID"));
         genero.setGenero(resultSet.getString("Genero"));

            
    Listas.add(genero);
    
    
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
 public static boolean actualizarGenero(Encapsulamientogenero e1)
  {
    conectar c1 =new conectar();
Connection db = c1.conectar();

boolean resultado=false;

try {

String consulta = "UPDATE genero set Genero=? WHERE ID=?";
PreparedStatement ps =db.prepareStatement(consulta);
ps.setString(1, e1.getGenero());
    ps.setInt(2, e1.getId());
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
  public static boolean Eliminargenero(int vid)
  {
    conectar c1 =new conectar();
Connection db = c1.conectar();

boolean resultado=false;

try {

String consulta = "DELETE FROM genero WHERE ID=?";
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
