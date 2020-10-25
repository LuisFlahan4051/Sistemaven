/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author luisflahan4051
 */
public class ModelsCRUD {
    Connect NewConnection = new Connect();
    Connection connection = NewConnection.getConnection();
    
    
    
    public ResultSet executeSimpleQuery(String query) throws SQLException{
        Statement statement;
        ResultSet results = null;
        
        statement = connection.createStatement();
        results = statement.executeQuery(query);
        
    
        return results;
    }
    
    public boolean saveModel(String model, String type, String talla) throws SQLException{
        PreparedStatement preStatement;
        boolean result = false;
        
        preStatement = connection.prepareStatement("INSERT INTO models(model_model, type_model, talla_model) VALUES (?, ?, ?)");
        preStatement.setString(1, model);
        preStatement.setString(2, type);
        preStatement.setString(2, talla);
        result = preStatement.execute();
        preStatement.close();
        
        return result;
    }
    
    public boolean deleteModelById(int id) throws SQLException{
        PreparedStatement preStatement;
        boolean result = false;
        
        preStatement = connection.prepareStatement("DELETE FROM models WHERE id_model = ?");
        preStatement.setInt(1, id);
        result = preStatement.execute();
        preStatement.close();
        
        return result;
    }
    
    public boolean updateModel(int id, String model, String type, String talla) throws SQLException{
        PreparedStatement preStatement;
        boolean result = false;
        
        preStatement = connection.prepareStatement("UPDATE models SET "
                + "model_model = ?, "
                + "type_model = ?, "
                + "talla_model = ? "
                + "WHERE id_model = ?"
        );
        preStatement.setString(1, model);
        preStatement.setString(2, type);
        preStatement.setString(3, talla);
        preStatement.setInt(3, id);
        result = preStatement.execute();
        preStatement.close();
        
        return result;
    }
}
