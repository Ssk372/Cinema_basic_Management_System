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
public class DBPeliculas {
     public static void agregarpeli(EncapsulamientoPeli e1)
    {
    conectar c1 =new conectar();
Connection db = c1.conectar();   

try {
    String consulta= "INSERT INTO cartelera (Pelinombre, Fecha, Sinopsis, Genero_ID, Clasificacion_ID, Costo, Duracion) VALUES (?,?,?,?,?,?,?)";
    PreparedStatement ps = db.prepareStatement(consulta);
    ps.setString(1, e1.getNombre());
    ps.setString(2, e1.getFecha());
    ps.setString(3, e1.getSinopsis());
    ps.setInt(4, e1.getGenero_ID());
    ps.setInt(5, e1.getClasificacion_ID());
    ps.setInt(6, e1.getCosto());
    ps.setString(7, e1.getDuracion());
    ps.executeUpdate();
    ps.close();
    db.close();
    JOptionPane.showMessageDialog(null, "Pelicula agregada");
}
catch(SQLException ex)
{
    JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());


}
    }
    public static List<EncapsulamientoPeli>MostrarPelis()
{
List <EncapsulamientoPeli> Listas = new ArrayList<>();
   conectar c1 =new conectar();
Connection db = c1.conectar();

try{

    String consulta = "SELECT a1.ID, a1.Pelinombre, a1.Fecha, a1.Sinopsis, c1.Genero, c2.Clasificacion, a1.Costo, a1.Duracion FROM cartelera a1 INNER JOIN genero c1 ON a1.Genero_ID=c1.ID INNER JOIN clasificaciones c2 ON a1.Clasificacion_ID=c2.ID";
    PreparedStatement ps = db.prepareStatement(consulta);
    ResultSet resultSet =ps.executeQuery();
    
    while(resultSet.next())
    {
    EncapsulamientoPeli peli = new EncapsulamientoPeli();
    peli.setId(resultSet.getInt("ID"));
    peli.setNombre(resultSet.getString("Pelinombre"));
    peli.setFecha(resultSet.getString("Fecha"));
       peli.setSinopsis(resultSet.getString("Sinopsis"));
        peli.setGenero(resultSet.getString("Genero"));
       peli.setClasificacion(resultSet.getString("Clasificacion"));
       peli.setCosto(resultSet.getInt("Costo"));
       peli.setDuracion(resultSet.getString("Duracion"));
    Listas.add(peli);
    
    
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
      public static List<EncapsulamientoPeli> MostrarPelis(int vid)
{
List <EncapsulamientoPeli> Listas = new ArrayList<>();
   conectar c1 =new conectar();
Connection db = c1.conectar();

try{

   String consulta = "SELECT * FROM cartelera WHERE ID=?";
    PreparedStatement ps = db.prepareStatement(consulta);
    ps.setInt(1, vid);
    
    ResultSet resultSet =ps.executeQuery();
    
    while(resultSet.next())
    {
     EncapsulamientoPeli peli = new EncapsulamientoPeli();
   peli.setId(resultSet.getInt("ID"));
    peli.setNombre(resultSet.getString("Pelinombre"));
    peli.setFecha(resultSet.getString("Fecha"));
       peli.setSinopsis(resultSet.getString("Sinopsis"));
        peli.setGenero(resultSet.getString("Genero"));
       peli.setClasificacion(resultSet.getString("Clasificacion"));
       peli.setCosto(resultSet.getInt("Costo"));
       peli.setDuracion(resultSet.getString("Duracion"));
            
    Listas.add(peli);
    
    
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
  public static boolean actualizarPelis(EncapsulamientoPeli e1)
  {
    conectar c1 =new conectar();
Connection db = c1.conectar();

boolean resultado=false;

try {

String consulta = "UPDATE cartelera set Pelinombre=?, Fecha=?, Sinopsis=?, Genero_ID=?, Clasificacion_ID=?, Costo=?, Duracion=? WHERE ID=?";
PreparedStatement ps =db.prepareStatement(consulta);
ps.setString(1, e1.getNombre());
   ps.setString(1, e1.getNombre());
    ps.setString(2, e1.getFecha());
    ps.setString(3, e1.getSinopsis());
    ps.setInt(4, e1.getGenero_ID());
    ps.setInt(5, e1.getClasificacion_ID());
    ps.setInt(6, e1.getCosto());
    ps.setString(7, e1.getDuracion());
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
  public static boolean Eliminarpeli(int vid)
  {
    conectar c1 =new conectar();
Connection db = c1.conectar();

boolean resultado=false;

try {

String consulta = "DELETE FROM cartelera   WHERE ID=?";
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
