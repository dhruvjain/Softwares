/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.market;

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
public class customerdata {
   String add,lic,cusno,tel;
  
   int purchase;
   private static String path = System.getProperty("user.home") + "/Project1Files";
   public static String addCustomer(customerdata data)throws IOException{
    File f = new File(path + "/NoOfCust.txt");
        if(!f.exists())
        {
            f.createNewFile();
            FileWriter fw = new FileWriter(f);
            fw.write("0\n");
            fw.close();
        }
         BufferedReader br = new BufferedReader(new FileReader(f));
          int Custcount = Integer.parseInt(br.readLine());
          br.close();
        Custcount++;
        String newText = String.valueOf(Custcount); 
        //int newText=Custcount;
        FileWriter fw = new FileWriter(f);
        fw.write(newText);
        fw.close();
        String custno;
        custno="C2014"+Custcount;
        File f2 = new File(path + "/" + custno + ".txt");
        if(!f2.exists())
        {
            f2.createNewFile();
            FileWriter fw2 = new FileWriter(f2);
            fw2.write(String.valueOf(data.purchase));
            
            fw2.close();
        }
        File f3 = new File(path + "/" + custno +"details"+".txt");
        if(!f3.exists())
        {
            f3.createNewFile();
            FileWriter fw3 = new FileWriter(f3);
          
            fw3.write(data.add);
            fw3.close();
        }
        
        return custno;
   }
   public static boolean checkLogin(String custno)throws Exception
    {
        File f = new File(path + "/" + custno + ".txt");
        if(!f.exists())
            return false;
        else
            return true;
    }
   public static String getpurchase(String custno)throws IOException
    {
        File f = new File(path + "/" + custno + ".txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        String purchase = br.readLine();
        br.close();
        return purchase;
    }
   public static String addpurchase(String custno,String purchase)throws IOException
    {
        File f = new File(path + "/" + custno + ".txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        String currentpurchase = br.readLine();
        int p1=Integer.parseInt(currentpurchase);
        int p2=Integer.parseInt(purchase);
        p1=p1+p2;
        purchase=Integer.toString(p1);
        br.close();
        FileWriter fw2 = new FileWriter(f);
            fw2.write(purchase);
            
            fw2.close();
        
       
        File f2 = new File(path + "/gold.txt");
        if(!f2.exists())
        {
           try{ f2.createNewFile();
            
           }
           catch(Exception e)
           {
             JOptionPane.showMessageDialog(null, e);
           }
        }
        if(Integer.parseInt(purchase)>=10000)
        {
         try
         {FileWriter fw = new FileWriter(f2,true);
         
         fw.write(custno+"\n");
         fw.close();
         }
         catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
         }
         
        }
         return purchase;
    } 
   
 }
