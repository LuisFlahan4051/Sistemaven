package model;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
/**
 *
 * @author https://github.com/Brian-54
 * @author https://github.com/LuisFlahan4051
 */

public class ClientsCRUD {
    Connect NewConnection = new Connect();
    Connection connection = NewConnection.getConnection();
    
    
    
    public ResultSet executeSimpleQuery(String query) throws SQLException{
        Statement statement;
        ResultSet results = null;
        
        statement = connection.createStatement();
        results = statement.executeQuery(query);
        
    
        return results;
    }
    
    public boolean saveClient(String name, String email) throws SQLException{
        PreparedStatement preStatement;
        boolean result = false;
        
        preStatement = connection.prepareStatement("INSERT INTO clients(name_client, email_client) VALUES (?, ?)");
        preStatement.setString(1, name );
        preStatement.setString(2, email);
        result = preStatement.execute();
        preStatement.close();
        
        return result;
    }
    
    public boolean deleteClientById(int id) throws SQLException{
        PreparedStatement preStatement;
        boolean result = false;
        
        preStatement = connection.prepareStatement("DELETE FROM clients WHERE id_client = ?");
        preStatement.setInt(1, id);
        result = preStatement.execute();
        preStatement.close();
        
        return result;
    }
    
    public boolean updateClient(int id, String name, String email) throws SQLException{
        PreparedStatement preStatement;
        boolean result = false;
        
        preStatement = connection.prepareStatement("UPDATE clients SET "
                + "name_client = ?, "
                + "email_client = ? "
                + "WHERE id_client = ?"
        );
        preStatement.setString(1, name);
        preStatement.setString(2, email);
        preStatement.setInt(3, id);
        result = preStatement.execute();
        preStatement.close();
        
        return result;
    }
}
