/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabletesting.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tabletesting.entities.User;

/**
 *
 * @author User
 */
public class UserSQL {
    
    private static final Connect con = new Connect();
    
    public static final String TABLE_NAME = "users";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_ADDRESS = "address";
    public static final String COL_NUMBER = "number";
    
    public static final void insertUser(User user){
        
        String query = "INSERT INTO " + TABLE_NAME + "("
        + COL_NAME + ","
        + COL_ADDRESS +","
        + COL_NUMBER + ") VALUES "
        + "('" + user.getName() +"',"
        + "'" + user.getAddress()+ "',"
        + "'" + user.getNumber() + "');";
        
        System.out.println(query);
        con.setQuery(query);
    }
    
    public static final List<User> getAllUsers(){
        
        List<User> users = new ArrayList<>();
        
        String query = "SELECT * FROM " + TABLE_NAME + ";";
        
        ResultSet results =  con.getQuery(query);
        
        try {
            while (results.next()){
                int id = results.getInt(COL_ID);
                String name = results.getString(COL_NAME);
                String address = results.getString(COL_ADDRESS);
                String number = results.getString(COL_NUMBER);
                
                User user = new User(id, name, address, number);
                
                users.add(user);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        return users;
    }

    public static final void deleteRow(int id){
        String query = "DELETE FROM " + TABLE_NAME +" WHERE " + COL_ID + "=" + id + ";";
        con.setQuery(query);
    }
    
}
