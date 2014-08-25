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
public class Student {
     private static String path = System.getProperty("user.home") + "/Project2Files";
    // private static String path = System.getProperty("user.home.Documents.NetBeansProjects.IITERP") + "/Project2Files";    
    public static String addStudent(String name,String password)throws IOException
    {
        File f = new File(path + "/StudentStats.txt");
        if(!f.exists())
        {
            f.createNewFile();
            FileWriter fw = new FileWriter(f);
            fw.write("0\n");
            fw.close();
        }
        BufferedReader br = new BufferedReader(new FileReader(f));
        int studentCount = Integer.parseInt(br.readLine());
        br.close();
        studentCount++;
        FileWriter fw = new FileWriter(f);
        fw.write(String.valueOf(studentCount));
        fw.close();
        String rollno="14IIT"+studentCount;
        File f2 = new File(path + "/" + rollno + ".txt");
        if(!f2.exists())
        {
            f2.createNewFile();
            FileWriter fw2 = new FileWriter(f2);
            fw2.write(name + "\n");
            fw2.write(password + "\n");
            fw2.close();
        }
        return rollno;
        
    }
    public static boolean checkLogin(String roll,String password)//throws IOException
    {
        String pass="";
     File f = new File(path + "/" + roll + ".txt");
     File f_1 = new File(path + "/" + roll.toLowerCase() + ".txt");
        if(!f.exists() && !f_1.exists())
            return false;
        try{
        BufferedReader br = new BufferedReader(new FileReader(f));
        br.readLine();
        pass=br.readLine();
        
  
         if(pass.equals(password) || pass.equals(password.toLowerCase()) || pass.equals(password.toUpperCase()))
        {
            br.close();
            return true;
        }
        br.close();
        }
        catch(Exception e){}
        return false;
    }
    public static void register(String name,String rollno,String[] course,int size) throws IOException{
      File f=new File(path + "/"+rollno+".txt");
      try
      {
       
       FileWriter fw=new FileWriter(f,true);
       for(int i=0;i<size;i++){
        fw.write(course[i]+ "\n");
       }
       fw.close();
      }
       catch(Exception e){
       JOptionPane.showMessageDialog(null,e);
       e.printStackTrace();
       }
      String profname="";
      for(int i=0;i<size;i++){
          try{
                profname=Teacher.getprof(course[i]);
               
                Teacher.addstudent(profname,name,rollno);
              }
           catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
              }
            
        }
      }
    public static void addGrade(String rollno,String grade,String cname)throws IOException{
    File f= new File(path + "/"+cname+".txt");
    String credits="";
    try{
     BufferedReader br=new BufferedReader(new FileReader(f));
     br.readLine();
     br.readLine();
     credits=br.readLine();
     
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null,e);
    }
    File f1=new File(path + "/"+rollno+"grades.txt");
    if(!f1.exists()){
     f1.createNewFile();
    }
    
    FileWriter fw=new FileWriter(f1,true);
    fw.write(cname+ "\n");
    fw.write(grade + "\n");
    fw.write(credits + "\n");
    fw.close();
    }
    public static String cgpa(String[] credits,String[] grades,int n){
    if(n==0){
    return "";
    }
    
    String choice;
    int sum=0,credsum=0,i;
     for(i=0;i<n;i++){
      credsum+=Integer.parseInt(credits[i]);
      
              
     }
        for(i=0;i<n;i++){
        choice=grades[i];
        switch(choice){
            case "EX":
            {
             sum+=Integer.parseInt(credits[i])*10;
             break;
            }
            case "A":{
             sum+=Integer.parseInt(credits[i])*9;
             break;
            }
            case "B":
                {
             sum+=Integer.parseInt(credits[i])*8;
             break;
            }
            case "C":
            {
             sum+=Integer.parseInt(credits[i])*7;
             break;
            }
            case "D":
            {sum+=Integer.parseInt(credits[i])*6;
             break;
            }   
            case "P":
            {
              sum+=Integer.parseInt(credits[i])*5;
             break;
            }
            case "F":
            {
             sum+=Integer.parseInt(credits[i])*4;
             break;
            }
        }
     
     
     }
    
    double cg=(sum/(float)credsum);
    cg=Math.round(cg*100.0)/100.0;
    return String.valueOf(cg);
    }
    public static boolean hasGotGrade(String rollno,String cname){
    String name;
        File f=new File(path +"/"+rollno+"grades"+".txt");
    if(!(f.exists()))
        return false;
    try{
      BufferedReader br=new BufferedReader(new FileReader(f));
      while((name=br.readLine())!=null){
       if(name.equals(cname))
           return true;
    }
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null,e);
    e.printStackTrace();
    }
    
    return false;
    }
}

