/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DHRUV
 */
import java.sql.*;
import javax.swing.*;

public class javaconnect {
   Connection conn=null;
   public static Connection ConnecrDb(){
       try{
       Class.forName("org.sqlite.JDBC");
       Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\DHRUV\\Documents\\NetBeansProjects\\market\\market1.sqlite");
         JOptionPane.showMessageDialog(null, "connection established");
       return conn;
    }catch(Exception e){
        
        JOptionPane.showMessageDialog(null, e);
        return null;
    }
   }
    
}
