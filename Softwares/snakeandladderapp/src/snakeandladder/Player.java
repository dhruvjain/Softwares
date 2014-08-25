/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeandladder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author DHRUV
 */
public class Player {
   static String path = System.getProperty("user.home") + "/Project3Files";
   public static void createprofile(String name)
   {
  
    File f = new File(path + "/"+name+".txt");
        if(!f.exists())
        {
           try{ f.createNewFile();
            FileWriter fw = new FileWriter(f);
            fw.write("0\n");
            fw.close();
           }
           catch(Exception e)
           {
            e.printStackTrace();
           }
        }
  
   }
    public static void addscore(String name,int score){
     File f = new File(path + "/"+name+".txt");
     int prevscore;
     if(f.exists()){
     try{
     BufferedReader br=new BufferedReader(new FileReader(f));
     prevscore=Integer.parseInt(br.readLine());
     if(score>prevscore){
     JOptionPane.showMessageDialog(null,"congrats "+name+" you broke your previous resord of"+prevscore+" new score"+score);
     FileWriter fw=new FileWriter(f);
     fw.write(String.valueOf(score));
     fw.close();
     }
     }
     catch(Exception e){
         JOptionPane.showMessageDialog(null, e);
     e.printStackTrace();
     }
     }
    
    }
}
