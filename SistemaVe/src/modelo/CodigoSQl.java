
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CodigoSQl {
   public Conexion cn=new Conexion();
   public PreparedStatement ps=null;
   public int retorno=0;//Para saber si se insertaron datos
   
   public int guardarDatosUsuario(int id_usuario,String nombre,String correo,String password){
       Connection con=null;
       try {
           con=cn.getConnection();
           ps=con.prepareStatement("INSERT INTO usuarios(id_usuario,nombre,correo,password)VALUES(?,?,?,?)");
           ps.setInt(1, id_usuario);
           ps.setString(2, nombre);
           ps.setString(3, correo);
           ps.setString(4, password);
           retorno=ps.executeUpdate();//retorna un boolean: 0 no se inserto 1 se inserto
           ps.close();//se cierra conexion
       } catch (Exception e) {
           System.out.println("Ha ocurrido un error al conectarse a la BD: "+e.getMessage());
       }
       return retorno;       
   }
   
   public int eliminarUsuario(int id_usuario){
       Connection con=null;
        try {
           con=cn.getConnection();
           ps=con.prepareStatement("DELETE from usuarios WHERE id_usuario=?");
           ps.setInt(1, id_usuario);
           retorno=ps.executeUpdate();
           ps.close();
        }catch (Exception e){
           System.out.println("Ha ocurrido un error al conectarse a la BD: "+e.toString());
    }
       return retorno;
   }
   public int modificarUsuario(String nombre,String correo,String password,int id_usuario){
       Connection con=null;
       try {
           con=cn.getConnection();
           ps=con.prepareStatement("UPDATE usuarios set nombre=?,correo=?,password=? WHERE id_usuario=?");
           ps.setString(1,nombre);
           ps.setString(2, correo);
           ps.setString(3, password);
           ps.setInt(4, id_usuario);
           retorno=ps.executeUpdate();
           ps.close();
       } catch (Exception e) {
           System.out.println("Ha ocurrido un error al guardar los datos"+e.toString());
       }
       return retorno;
   }
    
}
