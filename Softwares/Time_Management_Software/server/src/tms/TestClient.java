package tms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TestClient {

	private static int port = 12345;
	private static String host = "localhost";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(
				Socket clientsocket = new Socket(host, port);
				ObjectOutputStream oos = new ObjectOutputStream(clientsocket.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(clientsocket.getInputStream());
				BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
				){
			
			Executive client_exec = (Executive)ois.readObject();
			if(client_exec == null)
				System.out.println("null Reference");
			/*System.out.println(client_exec.getid());
			System.out.println(client_exec.getname());
			System.out.println(client_exec.getaddress());
			System.out.println(client_exec.getpassword());
			System.out.println(client_exec.getavailedleaves());
			System.out.println(client_exec.getMeetingslots());*/
			String userInput;
			while((userInput = stdin.readLine()) != null){
				
			}
		}catch(IOException io){
			io.printStackTrace();
		}catch(ClassNotFoundException c){
			c.printStackTrace();
		}
	}

}
