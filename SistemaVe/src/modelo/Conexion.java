
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {  
    public static Connection getConnection(){
        String driver = "jdbc:mysql://localhost:3306/sistemaven?serverTimezone=UTC";
        String password = "root";
        String user = "muso54";    
        Connection con;
        try {  
            con = DriverManager.getConnection(driver, password, user);
            return con;
        } catch (SQLException e) {
            System.out.println("error"+e.getMessage());           
        }
       return null;
    }
    
    public static ResultSet getTabla(String consulta){
        Connection con=getConnection();
        Statement st;
        ResultSet rs=null;
        try {
            st=con.createStatement();
            rs=st.executeQuery(consulta);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return rs;
    }
}
