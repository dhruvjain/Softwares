package tms;

import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.thoughtworks.xstream.XStream;

public class MyClob {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			
			/*GregorianCalendar cal = new GregorianCalendar();
			int dayinmonth = cal.get(Calendar.DAY_OF_MONTH);*/
			
			Diary d = new Diary("qwerty");
			XStream xstream = new XStream();
			String idiot = xstream.toXML(d);
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
			String SQL = "insert into datatable(col) values(?)";
			Clob myclob = con.createClob();
			myclob.setString(1, idiot);
			PreparedStatement pstate = con.prepareStatement(SQL);
			pstate.setClob(1, myclob);
			pstate.execute();
			
			SQL = "select col from datatable";
			pstate = con.prepareStatement(SQL);
			ResultSet rs = pstate.executeQuery();
			rs.next();
			String str = rs.getString("col");
			System.out.println(str);
			
		}catch(SQLException sql){
			sql.printStackTrace();
		}
		
	}

}
