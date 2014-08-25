
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DHRUV
 */
public class Openslot {
    public static void main(String args[]){
    System.out.println("Enter number of executives");
     Scanner in = new Scanner(System.in);
     int n=in.nextInt();
     int arr[][]=new int [n][5];
    
     for(int i=0;i<n;i++)
         for(int j=0;j<5;j++)
         {
         arr[i][j]=in.nextInt();
         }
     
     int c[]=new int[5];
     c[0]=c[1]=c[2]=c[3]=c[4]=0;
     
     for(int i=0;i<5;i++)
     {
     for(int j=0;j<n;j++)
        {
         if(arr[j][i]==1)
         c[i]++;  
     
        }
   
     }
     
     int find=0;
     for(int i=0;i<5;i++)
     {
     if(c[i]==n)
     { find=1;
     System.out.println("slot"+i+"is common");
     break;
     }
     }
     
     if(find!=1){
     System.out.println("no open slot");
     }
         
    
    
    
    
    
    }
}
