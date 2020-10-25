package model;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class UserCRUD {
    Connect NewConnection = new Connect();
    Connection connection = NewConnection.getConnection();
    
    
    
    public ResultSet executeSimpleQuery(String query) throws SQLException{
        Statement statement;
        ResultSet results = null;
        
        statement = connection.createStatement();
        results = statement.executeQuery(query);
        
    
        return results;
    }
    
    public boolean saveUser(String name, String password, String email) throws SQLException{
        PreparedStatement preStatement;
        boolean result = false;
        
        preStatement = connection.prepareStatement("INSERT INTO users(name_user, password_user, email_user) VALUES (?, ?, ?)");
        preStatement.setString(1, name );
        preStatement.setString(2, password);
        preStatement.setString(3, email);
        result = preStatement.execute();
        preStatement.close();
        
        return result;
    }
    
    public boolean deleteUserById(int id) throws SQLException{
        PreparedStatement preStatement;
        boolean result = false;
        
        preStatement = connection.prepareStatement("DELETE FROM users WHERE id_user = ?");
        preStatement.setInt(1, id);
        result = preStatement.execute();
        preStatement.close();
        
        return result;
    }
    
    public boolean updateUser(int id, String name, String password, String email) throws SQLException{
        PreparedStatement preStatement;
        boolean result = false;
        
        preStatement = connection.prepareStatement("UPDATE users SET "
                + "name_user = ?, "
                + "password_user = ?, "
                + "email_user = ? "
                + "WHERE id_user = ?"
        );
        preStatement.setString(1, name);
        preStatement.setString(2, password);
        preStatement.setString(3, email);
        preStatement.setInt(4, id);
        result = preStatement.execute();
        preStatement.close();
        
        return result;
    }
    
}
