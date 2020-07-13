/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Virtu
 */
public abstract class AbstractDao {
    public Connection connection() throws Exception{
         
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        final String url="jdbc:mysql://localhost:3306/salary_calculation";
        final String username="root";
        final String password="12345";
        
        Connection c=DriverManager.getConnection(url, username, password);
        System.out.println("connected");
        
        return c;
    
    }
}
