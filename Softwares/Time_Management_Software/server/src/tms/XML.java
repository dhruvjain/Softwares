package tms;
import java.net.*;
import java.sql.*;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XML {

	public static void main(String[] args){
		
		try{
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
			System.out.println("Connection Established...");
			XStream xstream = new XStream();
			Diary d = new Diary("12323");
			String xml = xstream.toXML(d);
			
			SQLXML sqlxml = con.createSQLXML();
			sqlxml.setString(xml);
			
			String SQL = "insert into xml(xml) values(?)";
			PreparedStatement p = con.prepareStatement(SQL);
			if(p == null)
				System.out.println("null");
			else 
				System.out.println("not null");
			p.setSQLXML(1, sqlxml);
			p.executeUpdate();
			//System.out.println(xml);
			SQL = "select * from xml";
			p = con.prepareStatement(SQL);
			ResultSet rs = p.executeQuery();
			rs.next();
			SQLXML rsxml = rs.getSQLXML("xml");
			String str = rsxml.getString();
			Diary newd = (Diary)xstream.fromXML(str);
			Transform t = new Transform();
			ArrayList<String> list = new ArrayList<>();
			list = t.DiaryToList(newd);
			for(String s : list){
				System.out.println(s);
			}
		}catch(SQLException sql){
			sql.printStackTrace();
		}
		
	}
	
}
