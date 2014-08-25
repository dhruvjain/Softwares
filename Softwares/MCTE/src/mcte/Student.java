/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mcte;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author DHRUV
 */
public class Student {
     private static String path = System.getProperty("user.home") + "/Project4Files";
    // private static String path = System.getProperty("user.home.Documents.NetBeansProjects.IITERP") + "/Project2Files";    
    public static void addStudent(String rollno,String name,int score)throws IOException
    {
        File f = new File(path + "/students.txt");
        
         if(!f.exists())
        {
            f.createNewFile();
        }
            FileWriter fw = new FileWriter(f,true);
            
            fw.write(name + "\n");
            fw.write(rollno + "\n");
            fw.write(score + "\n");
            fw.close();
        
    }
    public static void addscore(String name,String qno,int score)throws IOException{
     File f=new File(path + "/"+name+".txt");
     FileWriter fw = new FileWriter(f,true);
     fw.write(qno+ "\n");
     fw.write(String.valueOf(score) +"\n");
            
     fw.close();
    
    }
}
