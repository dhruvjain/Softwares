package tms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

class Exec extends Object implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1000L;
	String name;
	String password;
	int id;
	
	Exec(String n,String pass,int empid){
		 name=n;
	     password=pass;
	     id=empid;
	}
}

public class Test {
	
	public static void main(String[] args){
		
		int port  = 1500;
		try(
				ServerSocket serversocket = new ServerSocket(port);
				Socket clientsocket = serversocket.accept();
				ObjectInputStream ois = new ObjectInputStream(clientsocket.getInputStream()); 
				){
			Class.forName("Exec");
			System.out.println("Before...");
			tms.Exec to = (tms.Exec)ois.readObject();
			System.out.println("waiting..");
			if (to!=null){System.out.println(to.id);}  
			System.out.println((String)ois.readObject()); 
			/*String user = (String)ois.readObject();
			String user2 = (String)ois.readObject();
			System.out.println(user);
			System.out.println(user2);*/
		}catch(IOException io){
			io.printStackTrace();
		}catch(ClassNotFoundException cl){
			cl.printStackTrace();
		}
		
	}

}
