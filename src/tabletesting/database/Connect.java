/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabletesting.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hirantha
 */
public class Connect {

    Connection con = null;

    public Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:db/mydb.db");
            System.out.println("Connection success!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }

    public boolean setQuery(String query) {
        try {
            con = getConnection();
            Statement st = con.createStatement();
            st.execute(query);
            System.out.println("success!");
            return true; //exucted
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Falied!");
            return false;
        }
    }
    
    public ResultSet getQuery(String query){
        
        ResultSet r = null;
        try {
            con = getConnection();
            Statement s = con.createStatement();
            r = s.executeQuery(query);
            System.out.println("suxxess!");
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Failed");
        }
      return r;  
    }

}
