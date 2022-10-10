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
public class DBEmpleados {
    public static void agregarempleado(EncapsulamientoEmpleados e1)
    {
    conectar c1 =new conectar();
Connection db = c1.conectar();   

try {
    String consulta= "INSERT INTO empleados (Nombres, Apellidos, Dirección, Teléfono, Correo, Nivel_ID) VALUES (?,?,?,?,?,?)";
    PreparedStatement ps = db.prepareStatement(consulta);
  ps.setString(1, e1.getNombres());
  ps.setString(2, e1.getApe());
  ps.setString(3, e1.getDirec());
  ps.setString(4, e1.getTele());
  ps.setString(5, e1.getCorre());
  ps.setInt(6, e1.getNivel_ID());
    ps.executeUpdate();
    ps.close();
    db.close();
    JOptionPane.showMessageDialog(null, "Empleado agregado");
}
catch(SQLException ex)
{
    JOptionPane.showMessageDialog(null, "Error" + ex.getMessage());


}
    }
    public static List<EncapsulamientoEmpleados> MostrarEmpleados()
{
List <EncapsulamientoEmpleados> Listas = new ArrayList<>();
   conectar c1 =new conectar();
Connection db = c1.conectar();

try{

    String consulta = "SELECT a1.ID, a1.Nombres, a1.Apellidos, a1.Dirección, a1.Teléfono, a1.Correo, c1.Nombre FROM empleados a1 INNER JOIN rango c1 ON a1.Nivel_ID =c1.ID";
    PreparedStatement ps = db.prepareStatement(consulta);
    ResultSet resultSet =ps.executeQuery();
    
    while(resultSet.next())
    {
    EncapsulamientoEmpleados emp = new EncapsulamientoEmpleados();
   emp.setId(resultSet.getInt("ID"));
    emp.setNombres(resultSet.getString("Nombres"));
    emp.setApe(resultSet.getString("Apellidos"));
       emp.setDirec(resultSet.getString("Dirección"));
          emp.setTele(resultSet.getString("Teléfono"));
          emp.setCorre(resultSet.getString("Correo"));
           emp.setNivel(resultSet.getString("Nombre"));
   
    Listas.add(emp);
    
    
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
    
      public static List<EncapsulamientoEmpleados> MostrarEmpleados(int vid)
{
List <EncapsulamientoEmpleados> Listas = new ArrayList<>();
   conectar c1 =new conectar();
Connection db = c1.conectar();

try{

   String consulta = "SELECT * FROM empleados WHERE ID=?";
    PreparedStatement ps = db.prepareStatement(consulta);
    ps.setInt(1, vid);
    
    ResultSet resultSet =ps.executeQuery();
    
    while(resultSet.next())
    {
        EncapsulamientoEmpleados emp = new EncapsulamientoEmpleados();
    emp.setId(resultSet.getInt("ID"));
   emp.setNombres(resultSet.getString("Nombres"));
   emp.setApe(resultSet.getString("Apellidos"));
    emp.setDirec(resultSet.getString("Dirección"));
    emp.setTele(resultSet.getString("Teléfono"));
   emp.setCorre(resultSet.getString("Correo"));
   emp.setNivel_ID(resultSet.getInt("Nivel_ID"));
     emp.setId(resultSet.getInt(consulta));
    Listas.add(emp);
            
    
    
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
  public static boolean actualizarempleado(EncapsulamientoEmpleados e1)
  {
    conectar c1 =new conectar();
Connection db = c1.conectar();

boolean resultado=false;

try {

String consulta = "UPDATE empleados set Nombres=?, Apellidos=?, Dirección=?, Teléfono=?, Correo=?, Nivel_ID=? WHERE ID=?";
PreparedStatement ps =db.prepareStatement(consulta);
 ps.setString(1, e1.getNombres());
  ps.setString(2, e1.getApe());
  ps.setString(3, e1.getDirec());
  ps.setString(4, e1.getTele());
  ps.setString(5, e1.getCorre());
  ps.setInt(6, e1.getNivel_ID());
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
  public static boolean eliminarempleado(int vid)
  {
    conectar c1 =new conectar();
Connection db = c1.conectar();

boolean resultado=false;

try {

String consulta = "DELETE FROM empleados WHERE ID=?";
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
