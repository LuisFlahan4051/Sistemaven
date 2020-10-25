
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
    
    public void Connect(){
    }
    
    
    
    public Connection getConnection(){
        String driver = "jdbc:mysql://localhost:3306/sistemaven?serverTimezone=UTC";
        String user = "root";  
        String password = "404080loisMysql*"; 
        Connection connection;
        try {  
            connection = DriverManager.getConnection(driver, user, password);
            return connection;
        } catch (SQLException e) {
            System.out.println("error"+e.getMessage());
        }
       return null;
    }
    
    public ResultSet testConnectionQuery(String query){
        Connection connection=getConnection();
        Statement statement;
        ResultSet results;
        
        try {
            statement=connection.createStatement();
            results=statement.executeQuery(query);
            while (results.next())
            {
                System.out.println (results.getInt (1) + " " + results.getString (2));
            }
            return results;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }   
    
    }


}
