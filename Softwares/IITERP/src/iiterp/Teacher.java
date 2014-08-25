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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author DHRUV
 */
public class Teacher {
    private static String path = System.getProperty("user.home") + "/Project2Files";
   // private static String path = System.getProperty("user.home.Documents.NetBeansProjects.IITERP") + "/Project2Files";
    public static String[] addTeacher(String name)throws IOException{
     File f = new File(path + "/NoofTeachers.txt");
        if(!f.exists())
        {
            f.createNewFile();
            FileWriter fw = new FileWriter(f);
            fw.write("0\n");
            fw.close();
        }
     BufferedReader br = new BufferedReader(new FileReader(f));
        int teacherCount = Integer.parseInt(br.readLine());
     br.close();
        teacherCount++;
        FileWriter fw = new FileWriter(f);
        fw.write(String.valueOf(teacherCount));
        fw.close();
     String id,password;
     id="TIIT"+teacherCount;
     File f2=new File(path+"/"+id+".txt");
     if(!f2.exists()){
      f2.createNewFile();
     }
        password = "";
        
        for(int i=1;i<=6;i++)
        {
            int rand = (int)(Math.random()*26);
            password = password + (char)(97+rand);
        }
       
      FileWriter fw2 = new FileWriter(f2,true);
      fw2.write(name + "\n" + id + "\n" + password + "\n");
        fw2.close();
         String s[] = new String[2];
        s[0] = id;
        s[1] = password;
        return s;
    
    }
    public static void addCourse(Course course)throws IOException{
     File f = new File(path + "/NoofCourses.txt");
        if(!f.exists())
        {
            f.createNewFile();
            FileWriter fw = new FileWriter(f);
            fw.write("0\n");
            fw.close();
        }
        
        BufferedReader br = new BufferedReader(new FileReader(f));
        int coursecount = Integer.parseInt(br.readLine());
        br.close();
        coursecount++;
        FileWriter fw = new FileWriter(f);
        fw.write(String.valueOf(coursecount));
        fw.close();
        File f2=new File(path +"/"+course.name+".txt");
        if(!f2.exists()){
         f2.createNewFile();
         FileWriter fw2 = new FileWriter(f2,true);
         fw2.write(course.name+"\n"+course.teacherid+"\n"+course.credits+"\n"+course.type);
         fw2.close();
        }
        String s=course.teacherid;
        File f3=new File(path+"/"+s+".txt");
               
         FileWriter fw3=new FileWriter(f3,true);
         fw3.write(course.name+ "\n");
         fw3.close();
         
        
    }
    public static boolean checkid(String id)
    {
     File f= new File(path +"/"+id+".txt");
     File f_1= new File(path +"/"+id.toLowerCase()+".txt");
     if(f.exists() || f_1.exists())
     {
      return true;
     }
     else
         return false;
    }
    public static void addstudent(String profname,String stuname,String sturoll)throws IOException{
    String name;   
    File f1=new File(path + "/NoofTeachers.txt");
    BufferedReader br = new BufferedReader(new FileReader(f1));
    String tcount=br.readLine();
    br.close();
    for(int i=1;i<=Integer.parseInt(tcount);i++){
     File f2=new File(path + "/"+"TIIT"+i+".txt");
     BufferedReader br2 = new BufferedReader(new FileReader(f2));
     name=br2.readLine();
     br2.close();
     if(name.equals(profname))
     {
      File f3=new File(path + "/"+"TIIT"+i+"students.txt");
      if(!f3.exists()){
          f3.createNewFile();
      }
      FileWriter fw=new FileWriter(f3,true);
      fw.write(stuname+ "\n");
      fw.write(sturoll+ "\n");
      fw.close();
      FileWriter fw2=new FileWriter(f2,true);
      fw2.write(stuname+ "\n");
      fw2.write(sturoll+ "\n");
      fw2.close();
     }
     else
         continue;
     
    }
   
    
}
    public static String getprof(String cname)throws IOException{
        
        String name="";
        File f1=new File(path + "/NoofTeachers.txt");
        BufferedReader br = new BufferedReader(new FileReader(f1));
        String tcount=br.readLine();
        br.close();
        for(int i=1;i<=Integer.parseInt(tcount);i++)
        {
        File f2=new File(path + "/"+"TIIT"+i+".txt");
        BufferedReader br2 = new BufferedReader(new FileReader(f2));
        name=br2.readLine();
        br2.readLine();br2.readLine();
        if(cname.equals(br2.readLine()))
        {br2.close();
        return name;
        }
       }
        return "";
     }
    public static boolean checkLogin(String id,String password)throws IOException{
     if(!checkid(id))
       return false;
     else if(checkid(id)){
           File f=new File(path + "/"+id+".txt");
           
           BufferedReader br=new BufferedReader(new FileReader(f));
           br.readLine();
           br.readLine();
           String pass=br.readLine();
           br.close();
           if(pass.equals(password))
           return true;
           
      }
     
       return false;
   
    }
}
