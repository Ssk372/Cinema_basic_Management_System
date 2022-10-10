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
public class DBReserva {
        public static void agregarreserva(EncapsulamientoCompra e1)
    {
    conectar c1 =new conectar();
Connection db = c1.conectar();   

try {
    String consulta= "INSERT INTO reservación (Nombre, Apellidos, Horario, Precio, Silla, Sala, Pelicula_ID) VALUES (?,?,?,?,?,?,?)";
    PreparedStatement ps = db.prepareStatement(consulta);
   ps.setString(1, e1.getNombre());
   ps.setString(2, e1.getApe());
   ps.setString(3, e1.getHora());
   ps.setInt(4, e1.getPrecio());
   ps.setString(5, e1.getSilla());
   ps.setString(6, e1.getSala());
   ps.setInt(7, e1.getPelicula_id());
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
    public static List<EncapsulamientoCompra>MostrarReserva()
{
List <EncapsulamientoCompra> Listas = new ArrayList<>();
   conectar c1 =new conectar();
Connection db = c1.conectar();

try{

    String consulta = "SELECT a1.ID, a1.Nombre, a1.Apellidos, a1.Horario, a1.Precio, a1.Silla, a1.Sala, c1.Pelinombre FROM reservación a1 INNER JOIN cartelera c1 ON a1.Pelicula_ID =c1.ID";
    PreparedStatement ps = db.prepareStatement(consulta);
    ResultSet resultSet =ps.executeQuery();
    
    while(resultSet.next())
    {
    EncapsulamientoCompra compra = new EncapsulamientoCompra();
compra.setId(resultSet.getInt("ID"));
compra.setNombre(resultSet.getString("Nombre"));
compra.setApe(resultSet.getString("Apellidos"));
compra.setHora(resultSet.getString("Horario"));
compra.setPrecio(resultSet.getInt("Precio"));
compra.setSilla(resultSet.getString("Silla"));
compra.setSala(resultSet.getString("Sala"));
compra.setPelicula(resultSet.getString("Pelinombre"));

    
    
    Listas.add(compra);
    
    
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
      public static List<EncapsulamientoCompra> MostrarReserva(int vid)
{
List <EncapsulamientoCompra> Listas = new ArrayList<>();
   conectar c1 =new conectar();
Connection db = c1.conectar();

try{

   String consulta = "SELECT * FROM reservación WHERE ID=?";
    PreparedStatement ps = db.prepareStatement(consulta);
    ps.setInt(1, vid);
    
    ResultSet resultSet =ps.executeQuery();
    
    while(resultSet.next())
    {
     EncapsulamientoCompra compra = new EncapsulamientoCompra();
compra.setId(resultSet.getInt("ID"));
compra.setNombre(resultSet.getString("Nombre"));
compra.setApe(resultSet.getString("Apellidos"));
compra.setHora(resultSet.getString("Horario"));
compra.setPrecio(resultSet.getInt("Precio"));
compra.setSilla(resultSet.getString("Silla"));
compra.setSala(resultSet.getString("Sala"));
compra.setPelicula_id(resultSet.getInt("Pelicula_ID"));

            
    Listas.add(compra);
    
    
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
      /*
  public static boolean actualizarcliente(EncapsulamientoCliente e1)
  {
    conectar c1 =new conectar();
Connection db = c1.conectar();

boolean resultado=false;

try {

String consulta = "UPDATE clasificaciones set Clasificacion=? WHERE ID=?";
PreparedStatement ps =db.prepareStatement(consulta);
ps.setString(1, e1.getClasificacion());
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
  */
  public static boolean EliminarReserva(int vid)
  {
    conectar c1 =new conectar();
Connection db = c1.conectar();

boolean resultado=false;

try {

String consulta = "DELETE FROM reservación WHERE ID=?";
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
