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
public class DBLogin {
    
    public static void agregarusuario(EncapsulamientoUsuario e1)
    {
    conectar c1 =new conectar();
Connection db = c1.conectar();   

try {
    String consulta= "INSERT INTO usuarios (usuario, contraseña) VALUES (?,?)";
    PreparedStatement ps = db.prepareStatement(consulta);
   ps.setString(1, e1.getUsuario());
   ps.setString(2, e1.getContraseña());
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
     public static List<EncapsulamientoUsuario>mostraradmin()
{
List <EncapsulamientoUsuario> Listas = new ArrayList<>();
   conectar c1 =new conectar();
Connection db = c1.conectar();

try{

    String consulta = "SELECT * FROM usuarios WHERE ID=?";
    PreparedStatement ps = db.prepareStatement(consulta);
    ResultSet resultSet =ps.executeQuery();
    
    while(resultSet.next())
    {
    EncapsulamientoUsuario usr = new EncapsulamientoUsuario();
    usr.setId(resultSet.getInt("ID"));
    usr.setUsuario(resultSet.getString("usuario"));
    usr.setContraseña(resultSet.getString("contraseña"));
     
    Listas.add(usr);
    
    
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
      public static List<EncapsulamientoUsuario> mostraradmin(int vid)
{
List <EncapsulamientoUsuario> Listas = new ArrayList<>();
   conectar c1 =new conectar();
Connection db = c1.conectar();

try{

   String consulta = "SELECT * FROM usuarios WHERE ID=?";
    PreparedStatement ps = db.prepareStatement(consulta);
    ps.setInt(1, vid);
    
    ResultSet resultSet =ps.executeQuery();
    
    while(resultSet.next())
    {
     EncapsulamientoPeli peli = new EncapsulamientoPeli();
   EncapsulamientoUsuario usr = new EncapsulamientoUsuario();
    usr.setId(resultSet.getInt("ID"));
    usr.setUsuario(resultSet.getString("usuario"));
    usr.setContraseña(resultSet.getString("contraseña"));
     
    Listas.add(usr);
    
    
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

}
