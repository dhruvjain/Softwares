/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package iiterp;
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
public class Course {
    private static String path = System.getProperty("user.home") + "/Project2Files";

    //private static String path = System.getProperty("user.home.Documents.NetBeansProjects.IITERP") + "/Project2Files";
   String name,teacherid,credits,type;
   public static void addtocompulsory(String cname)throws IOException
   {
      
    File fcomp=new File(path + "/compulsorycourses.txt");
    if(!(fcomp.exists()))
    {
     fcomp.createNewFile();
    }
    FileWriter fw2= new FileWriter(fcomp,true);
    fw2.write(cname + "\n");
    fw2.close();
   }
   public static void addtoelective(String cname)throws IOException
   {
      
    
    File felec=new File(path + "/electivecourses.txt");
    if(!(felec.exists()))
    {
     felec.createNewFile();
    }
    FileWriter fw2= new FileWriter(felec,true);
    fw2.write(cname+"\n");
    fw2.close();
   }
   
    
    
   
   
   }

