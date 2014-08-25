/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tms;

import java.sql.*;

/**
 *
 * @author DHRUV
 */
public class Database {
    
    public static void main(String[] args){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:/localhost:3306/test");
            System.out.println("Connected");
        }catch(SQLException sql){
            sql.printStackTrace();
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
    }
    
}
