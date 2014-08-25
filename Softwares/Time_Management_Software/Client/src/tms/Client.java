package tms;

import java.net.*;  
import java.io.*;  
public class Client {  
public static void main(String args[])
{ 
        String hostname = "10.102.70.129";
        int port = 1500;
try{  
Socket s = new Socket(hostname,port);  
OutputStream os = s.getOutputStream();  
ObjectOutputStream oos = new ObjectOutputStream(os);  
Exec to = new Exec("ram","object",7303);  
oos.writeObject(to); 

//oos.writeObject(new String("object from the client"));  
//oos.writeObject(new String("another object from the client"));
oos.close();  
os.close();  
s.close();  
}catch(Exception e){System.out.println(e);}  
}  
}  
