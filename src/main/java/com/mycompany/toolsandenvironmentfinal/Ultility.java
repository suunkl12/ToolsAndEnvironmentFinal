

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.toolsandenvironmentfinal;

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
