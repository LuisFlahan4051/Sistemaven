package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Autentication {
    Connect NewConnection= new Connect();
    
    Connection connection = NewConnection.getConnection();
    PreparedStatement statement;
    ResultSet result;
    
    public MainUserCapsule Autentication(String name,String password){
        MainUserCapsule userCapsule = new MainUserCapsule();
        String query = "Select * from usuarios WHERE name_user = ? AND password_user = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1,name);
            statement.setString(2,password);
            result = statement.executeQuery();
            
            if(result.next()){
                userCapsule.setId_user(result.getInt("id_user"));
                userCapsule.setName_user(result.getString("name_user"));
                userCapsule.setEmail_user(result.getString("email_user"));
                userCapsule.setPassword_user(result.getString("password_user"));
                return userCapsule;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
        return null;
    }
    
}
