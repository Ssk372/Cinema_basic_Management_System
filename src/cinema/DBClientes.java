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
public class DBClientes {
    public static void agregarcliente(EncapsulamientoCliente e1)
    {
    conectar c1 =new conectar();
Connection db = c1.conectar();   

try {
    String consulta= "INSERT INTO clientes_registro (Nombres, Apellidos, Direccion, Telefono, Correo, Nivel_ID) VALUES (?,?,?,?,?,?)";
    PreparedStatement ps = db.prepareStatement(consulta);
   ps.setString(1, e1.getNombres());
   ps.setString(2, e1.getApellidos());
   ps.setString(3, e1.getDireccion());
   ps.setString(4, e1.getTelefono());
   ps.setString(5, e1.getCorreo());
   ps.setInt(6, e1.getNivel_id());
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
    public static List<EncapsulamientoCliente>MostrarCliente()
{
List <EncapsulamientoCliente> Listas = new ArrayList<>();
   conectar c1 =new conectar();
Connection db = c1.conectar();

try{

    String consulta = "SELECT a1.ID, a1.Nombres, a1.Apellidos, a1.Direccion, a1.Telefono, a1.Correo, c1.Nombre FROM clientes_registro a1 INNER JOIN rangosclientes c1 ON a1.Nivel_ID =c1.ID";
    PreparedStatement ps = db.prepareStatement(consulta);
    ResultSet resultSet =ps.executeQuery();
    
    while(resultSet.next())
    {
    EncapsulamientoCliente clasi = new EncapsulamientoCliente();
    clasi.setId(resultSet.getInt("ID"));
   clasi.setNombres(resultSet.getString("Nombres"));
   clasi.setApellidos(resultSet.getString("Apellidos"));
   clasi.setDireccion(resultSet.getString("Direccion"));
   clasi.setTelefono(resultSet.getString("Telefono"));
   clasi.setCorreo(resultSet.getString("Correo"));
   clasi.setNivel(resultSet.getString("Nombre"));
    
    
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
      public static List<EncapsulamientoCliente> MostrarCliente(int vid)
{
List <EncapsulamientoCliente> Listas = new ArrayList<>();
   conectar c1 =new conectar();
Connection db = c1.conectar();

try{

   String consulta = "SELECT * FROM clientes_registro WHERE ID=?";
    PreparedStatement ps = db.prepareStatement(consulta);
    ps.setInt(1, vid);
    
    ResultSet resultSet =ps.executeQuery();
    
    while(resultSet.next())
    {
     EncapsulamientoCliente clasi = new EncapsulamientoCliente();
        clasi.setId(resultSet.getInt("ID"));
   clasi.setNombres(resultSet.getString("Nombres"));
   clasi.setApellidos(resultSet.getString("Apellidos"));
   clasi.setDireccion(resultSet.getString("Direccion"));
   clasi.setTelefono(resultSet.getString("Telefono"));
   clasi.setCorreo(resultSet.getString("Correo"));
   clasi.setNivel_id(resultSet.getInt("Nivel_ID"));

            
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
      
  public static boolean actualizarcliente(EncapsulamientoCliente e1)
  {
    conectar c1 =new conectar();
Connection db = c1.conectar();

boolean resultado=false;

try {

String consulta = "UPDATE clientes_registro set Nombres=?, Apellidos=?, Direccion=?, Telefono=?, Correo=?, Nivel_ID WHERE ID=?";
PreparedStatement ps =db.prepareStatement(consulta);
ps.setString(1, e1.getNombres());
ps.setString(2, e1.getApellidos());
ps.setString(3, e1.getDireccion());
ps.setString(4, e1.getTelefono());
ps.setString(5, e1.getCorreo());
ps.setInt(6, e1.getNivel_id());
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
  
  public static boolean Eliminarcliente(int vid)
  {
    conectar c1 =new conectar();
Connection db = c1.conectar();

boolean resultado=false;

try {

String consulta = "DELETE FROM clientes_registro WHERE ID=?";
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
