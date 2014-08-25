package tms;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.sql.rowset.serial.SerialBlob;

import com.thoughtworks.xstream.XStream;

public class Database {
	
	private Connection con;
	private Statement state;
	private PreparedStatement pstate;
	private ResultSet rs;
	private String SQL;
	
	private ByteArrayOutputStream bos = null;
	private ByteArrayInputStream bis = null;
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	private byte[] byteObject = null;
	private Blob blob = null;
	
	private Clob clob;
	private String diaryxml;
	private String meetingxml;
	private XStream xstream;
	
	public void getConnection(){
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
			System.out.println("Connected to Database...");
		}catch(SQLException s){
			s.printStackTrace();
		}
	}
	
	public void insertnewExecutive(Executive exec){
		try{
			
			SQL = "insert into executive(executive_id,executive_name,executive_address,executive_password,"
					+ "leaves_availed,slotsinmeeting,diary) values(?,?,?,?,?,?,?)";
			pstate = con.prepareStatement(SQL);
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.close();
			bos.close();
			Diary diary = new Diary(exec.getid());
			/*oos.writeObject(diary);
			byteObject = bos.toByteArray();
			blob = new SerialBlob(byteObject);*/
			
			xstream = new XStream();
			diaryxml = xstream.toXML(diary);
			clob = con.createClob();
			clob.setString(1, diaryxml);
			
			pstate.setString(1, exec.getid());
			pstate.setString(2, exec.getname());
			pstate.setString(3, exec.getaddress());
			pstate.setString(4, exec.getpassword());
			pstate.setInt(5, exec.getavailedleaves());
			pstate.setInt(6, exec.getMeetingslots());
			pstate.setClob(7, clob);
			
			pstate.executeUpdate();
			System.out.println("new Executive inserted...");
			pstate.close();
			
		}catch(SQLException s){
			s.printStackTrace();
		}catch(IOException io){
			io.printStackTrace();
		}
	}
	
	public Diary getDiary(String exec_id){
		try{
			
			SQL = "select diary from executive where executive_id  = ?";
			pstate = con.prepareStatement(SQL);
			pstate.setString(1, exec_id);
			rs = pstate.executeQuery();
			rs.next();
			//byteObject = rs.getBytes("diary");
			//ois = new ObjectInputStream(new ByteArrayInputStream(byteObject));
			
			//Diary diary = (Diary)ois.readObject();
			//Object obj = ois.readObject();
			//System.out.println(obj.getClass().getName());
			//System.out.println(byteObject);
			
			xstream = new XStream();
			diaryxml = rs.getString("diary");
			Diary diary = (Diary)xstream.fromXML(diaryxml);
			pstate.close();
			return diary;
			
		}catch(SQLException s){
			s.printStackTrace();
		}/*catch(IOException io){
			io.printStackTrace();
		}catch(ClassNotFoundException c){
			c.printStackTrace();
		}*/
		return null;
	}
	
	public Executive Login(String executive_id, String password){
		try{
			
			SQL = "select executive_id,executive_name,executive_address,executive_password,leaves_availed,slotsinmeeting from "
					+ "executive where executive_id = ? and executive_password = ?";
			pstate = con.prepareStatement(SQL);
			pstate.setString(1, executive_id);
			pstate.setString(2, password);
			rs = pstate.executeQuery();
			if(rs.next() == true){
				Executive exec = new Executive(rs.getString("executive_id"), rs.getString("executive_name"), 
						rs.getString("executive_address"), rs.getString("executive_password"), rs.getInt("leaves_availed"), 
						rs.getInt("slotsinmeeting"));
				pstate.close();
				return exec;
			}
			pstate.close();
						
		}catch(SQLException sq){
			sq.printStackTrace();
		}
		System.out.println("Not found");
		return null;
	}
	
	public void updateDiary(String executive_id, Diary newdiary){
		
		try{
			SQL = "update executive set diary = ? where executive_id = ?";
			pstate = con.prepareStatement(SQL);
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.close();
			bos.close();
			oos.writeObject(newdiary);
			byteObject = bos.toByteArray();
			//blob = new SerialBlob(byteObject);
			
			xstream = new XStream();
			diaryxml = xstream.toXML(newdiary);
			clob = con.createClob();
			clob.setString(1, diaryxml);
			
			pstate.setClob(1, clob);
			pstate.setString(2, executive_id);
			pstate.execute();
			pstate.close();
			
		}catch(SQLException sql){
			sql.printStackTrace();
		}catch(IOException io){
			io.printStackTrace();
		}
	}
	
	public void incrementMeeting(String projectname){
		try{
			
			SQL = "update project set meetings = meetings + 1, manhours = manhours + 1 where projectName = ?";
			pstate = con.prepareStatement(SQL);
			pstate.setString(1, projectname);
			pstate.execute();
			pstate.close();
		}catch(SQLException sql){
			sql.printStackTrace();
		}
	}
	
	public void incrementslots(String exec_id){
		try{
			SQL = "update executive set slotsinmeeting = slotsinmeeting + 1 where executive_id = ?";
			pstate = con.prepareStatement(SQL);
			pstate.setString(1, exec_id);
			pstate.execute();
			pstate.close();
		}catch(SQLException sql){
			sql.printStackTrace();
		}
	}
	
	public void insertHoldMeetings(Meeting meeting){
		try{
			SQL = "insert into holdmeetings(meeting) values(?)";
			pstate = con.prepareStatement(SQL);
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.close();
			bos.close();
			oos.writeObject(meeting);
			byteObject = bos.toByteArray();
			//blob = new SerialBlob(byteObject);
			
			xstream = new XStream();
			meetingxml = xstream.toXML(meeting);
			clob = con.createClob();
			clob.setString(1, meetingxml);
			
			pstate.setClob(1, clob);
			pstate.executeUpdate();
			pstate.close();
		}catch(IOException io){
			io.printStackTrace();
		}catch(SQLException sql){
			sql.printStackTrace();
		}
	}
	
	public Vector<Meeting> getholdmeetings(){
		try{
			SQL = "select meeting from holdmeetings";
			pstate = con.prepareStatement(SQL);
			rs = pstate.executeQuery();
			Vector<Meeting> meetingvec  = new Vector<>();
			xstream = new XStream();
			while(rs != null && rs.next() == true){
				meetingxml = rs.getString("meeting");
				Meeting meeting = (Meeting)xstream.fromXML(meetingxml);
				meetingvec.add(meeting);
			}
			pstate.close();
			return meetingvec;
		}catch(SQLException sql){
			sql.printStackTrace();
		}
		return null;
	}
	
	public Vector<Integer> getholdmeetingsID(){
		try{
			SQL = "select id from holdmeetings";
			pstate = con.prepareStatement(SQL);
			rs = pstate.executeQuery();
			Vector<Integer> idvec = new Vector<>();
			while(rs != null && rs.next() == true){
				int id = rs.getInt("id");
				idvec.add(id);
			}
			pstate.close();
			return idvec;
		}catch(SQLException sql){
			sql.printStackTrace();
		}
		return null;
	}
	
	public void cancelHoldMeetings(int id){
		try{
			SQL = "delete from holdmeetings where id = ?";
			pstate = con.prepareStatement(SQL);
			pstate.setInt(1, id);
			pstate.execute();
			pstate.close();
		}catch(SQLException sql){
			sql.printStackTrace();
		}
	}
	
	public ArrayList<String> getidnameofexecutives(){
		
		try{
			ArrayList<String> list = new ArrayList<>();
			SQL = "select executive_id, executive_name from executive";
			pstate = con.prepareStatement(SQL);
			rs = pstate.executeQuery();
			while(rs != null && rs.next()==true){
				String id = rs.getString("executive_id");
				String name = rs.getString("executive_name");
				list.add(id);
				list.add(name);
			}
			pstate.close();
			return list;
		}catch(SQLException sql){
			sql.printStackTrace();
		}
		return null;
	}
	
	public void addMessage(String exid, String message){
		//single message display for now
		try{
			
			SQL = "select inbox from executive where executive_id = ?";
			pstate = con.prepareStatement(SQL);
			pstate.setString(1, exid);
			rs = pstate.executeQuery();
			rs.next();
			String msg = rs.getString("inbox");
			if(msg != null){
				//msg = clob.toString();
				msg = msg.concat("\n");
				msg = msg.concat(message);
			}
			else
				msg = message;
			pstate.close();
			
			SQL = "update executive set inbox = ? where executive_id = ?";
			pstate = con.prepareStatement(SQL);
			clob = con.createClob();
			clob.setString(1, msg);
			
			pstate.setClob(1, clob);
			pstate.setString(2, exid);
			pstate.execute();
			
			pstate.close();
		}catch(SQLException sql){
			sql.printStackTrace();
		}
	}
	
	public int getsingleexecutivestat(String executive_id, int start, int end){
		try{
			
			SQL = "select diary from executive where executive_id = ?";
			pstate = con.prepareStatement(SQL);
			pstate.setString(1, executive_id);
			
			rs = pstate.executeQuery();
			rs.next();
			
			xstream = new XStream();
			diaryxml = rs.getString("diary");
			Diary diary = (Diary)xstream.fromXML(diaryxml);
			pstate.close();
			
			return diary.getmeetings(start, end);
			
			
		}catch(SQLException sql){
			sql.printStackTrace();
		}
		
		return 10;
	}
	
	public int getsingleexecutivestat_(String executive_id, int start, int end){
		try{
			
			SQL = "select diary from executive where executive_id = ?";
			pstate = con.prepareStatement(SQL);
			pstate.setString(1, executive_id);
			
			rs = pstate.executeQuery();
			rs.next();
			
			xstream = new XStream();
			diaryxml = rs.getString("diary");
			Diary diary = (Diary)xstream.fromXML(diaryxml);
			pstate.close();
			
			return diary.getjobs(start, end);
			
		}catch(SQLException sql){
			sql.printStackTrace();
		}
		return 0;
	}
	
	public ArrayList<String> getprojstat(){
		try{
			
			SQL = "select meetings from project";
			pstate = con.prepareStatement(SQL);
			
			rs = pstate.executeQuery();
			ArrayList<String> stat = new ArrayList<>();
			while(rs!=null && rs.next()==true){
				int meet = rs.getInt("meetings");
				stat.add(String.valueOf(meet));
				
			}
			pstate.close();
			return stat;
		}catch(SQLException sql){
			sql.printStackTrace();
		}
		return null;
	}
	
	public String getinbox(String id){
		try{
			
			SQL = "select inbox from executive where executive_id = ?";
			pstate = con.prepareStatement(SQL);
			pstate.setString(1, id);
			rs = pstate.executeQuery();
			rs.next();
			String message = rs.getString("inbox");
			pstate.close();
			return message;
		}catch(SQLException sql){
			sql.printStackTrace();
		}
		return null;
		
	}
	
}
