

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Khang
 */
public class Ultility {
    public Connection connectionDB() throws Exception{
        String dbURL = "jdbc:mysql://localhost:3306/hutechdb";
        String username = "root";
        String password = "";
        return (Connection)DriverManager.getConnection(dbURL, username, password);
    }
    
    public int insertEmployee(Connection conn, int code, String fullname, String address, String phone, String birthdate, String gender){
        String sql = "INSERT INTO Employee values('";
        sql += code + "','";
        sql += fullname + "','";
        sql += birthdate + "','";
        sql += gender + "','";
        sql += address + "','";
        sql += phone + "','";
        int count = 0;
        
        try {
            Statement st = conn.createStatement();
            count = st.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    
    public ResultSet selectEmploye(Connection con, int code, String fullname){
       Statement st = null;
       ResultSet rs = null;
        try{
        st = con.createStatement();
        String sql = " SELECT * FROM Employee ";
        //sql+= "WHERE code=" + code;
        //sql+= " and fullname like" + fullname;
        rs = st.executeQuery(sql);
       }
       catch(SQLException e){
           e.printStackTrace();
       }
        return rs;
    }
}
