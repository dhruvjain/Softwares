package tms;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.mysql.fabric.xmlrpc.base.Array;

class Threading extends Thread{
	
	private Database Thread_D;
	private static final int HOUR = 10;
	
	public Threading() {
		super("Child Thread");
		Thread_D = new Database();
		Thread_D.getConnection();
		start();
	}
	
	public boolean openSlot(Meeting meeting){
		Diary[] diaries = new Diary[meeting.getnumberofexecutives()];
		for(int i=0; i<meeting.getnumberofexecutives(); ++i){
			System.out.println(meeting.getcalledexecutives()[i]);
			diaries[i] = Thread_D.getDiary(meeting.getcalledexecutives()[i]);
		}
		int executives, slots;
		for(slots =0; slots <5; slots++){
			for(executives =0 ; executives<meeting.getnumberofexecutives(); executives++){
				Work w = diaries[executives].getsingleDaytimetable(meeting.getdayinmonth())[slots];
				if(w!=null)
					break;
			}
			if(executives==meeting.getnumberofexecutives())
				break;
		}
		
		System.out.println(slots);
		
		if(slots<5){
			meeting.setSlot(new Slot(slots));
			for(int i=0;i<meeting.getnumberofexecutives();++i){
				diaries[i].insertmeeting(meeting);
				Thread_D.updateDiary(meeting.getcalledexecutives()[i], diaries[i]);
				Thread_D.incrementslots(meeting.getcalledexecutives()[i]);
				//code to write message in file of executive
			}
			Thread_D.incrementMeeting(meeting.getpurpose());
			System.out.println("Meeting Inserted");
			return true;
		}
		return false;
	}
	
	public void run(){
		int hour;
		while((hour = new GregorianCalendar().get(Calendar.MINUTE)) < 10){}
		System.out.println("run...");
		Vector<Meeting> holdMeetings = Thread_D.getholdmeetings();
		Vector<Integer> holdMeetingsID = Thread_D.getholdmeetingsID();
		Vector<Integer> toBecancelled = new Vector<>();
		int todaysdayinmonth = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
		int counter = 0;
		for(Meeting m : holdMeetings){
			int meetingdayofmonth = m.getdayinmonth();
			if(meetingdayofmonth - todaysdayinmonth < 0)
				toBecancelled.add(holdMeetingsID.get(counter));
			else{
				boolean bool = openSlot(m);
				if(bool==true)
					toBecancelled.add(counter);
			}
			counter++;
		}
		for(int id : holdMeetingsID){
			Thread_D.cancelHoldMeetings(id);
		}
	}
	
}

public class Server {
	
	private static final int port = 12345;
	private Database D;
	private String request;
	private static final String END = "5";
	
	private byte[] byteDiary;
	private byte[] bytemeeting;
	private byte[] byteExecutive;
	private String loginexecutive_id;
	private String loginexecutive_password;
	private Diary loginDiary;
	private Meeting meeting;
	
	private ArrayList<String> executivelist;
	private ArrayList<String> diarylist;
	private ArrayList<String> inputlist;
	
	private static final String Secretaryuser = "secretary";
	private static final String Secretarypassword = "12345";  
	
	public boolean openSlot(Meeting meeting){
		Diary[] diaries = new Diary[meeting.getnumberofexecutives()];
		for(int i=0; i<meeting.getnumberofexecutives(); ++i){
			System.out.println(meeting.getcalledexecutives()[i]);
			diaries[i] = D.getDiary(meeting.getcalledexecutives()[i]);
		}
		int executives, slots;
		for(slots =0; slots <5; slots++){
			for(executives =0 ; executives<meeting.getnumberofexecutives(); executives++){
				Work w = diaries[executives].getsingleDaytimetable(meeting.getdayinmonth())[slots];
				if(w!=null)
					break;
			}
			if(executives==meeting.getnumberofexecutives())
				break;
		}
		
		System.out.println(slots);
		
		if(slots<5){
			meeting.setSlot(new Slot(slots));
			for(int i=0;i<meeting.getnumberofexecutives();++i){
				diaries[i].insertmeeting(meeting);
				D.updateDiary(meeting.getcalledexecutives()[i], diaries[i]);
				D.incrementslots(meeting.getcalledexecutives()[i]);
				//code to write message in file of executive
			}
			D.incrementMeeting(meeting.getpurpose());
			System.out.println("Meeting Inserted");
			return true;
		}
		return false;
	}
	
	public void runserver(){
		System.out.println("Inside runserver()");
		try(
				ServerSocket serversocket = new ServerSocket(port);
				Socket clientsocket = serversocket.accept();
				ObjectInputStream dis = new ObjectInputStream(clientsocket.getInputStream());
				ObjectOutputStream dos = new ObjectOutputStream(clientsocket.getOutputStream());
				){
			System.out.println("Connection with Client has been Established...");
			while(dis!=null && (request = (String)dis.readObject()).equals("5")==false){
				System.out.println("inside while loop");
				System.out.println(request);
				switch(request){
				
				case "0":					// 0  means new Executive Register
					System.out.println("Inside 0");
					//executivelist = new ArrayList<>();
					executivelist = (ArrayList<String>)dis.readObject();
					Executive newexecutive = new Executive(executivelist.get(0),executivelist.get(2),executivelist.get(2),executivelist.get(3));
					D.insertnewExecutive(newexecutive);
					break;
					
				case "1":				// 1 means Login Request
					System.out.println("Inside 1");
					//0 is sent if executive not found
					//1 is sent if executive found
					inputlist = (ArrayList<String>)dis.readObject();
					loginexecutive_id = inputlist.get(0);
					loginexecutive_password = inputlist.get(1);
					Executive loginExecutive = D.Login(loginexecutive_id, loginexecutive_password);
					if(loginExecutive == null){
						dos.writeObject("0");
						System.out.println("nullll");
					}
					else{
						dos.writeObject("1");
						System.out.println("DJJJ");
						Transform transform = new Transform();
						Utilities util = new Utilities();
						executivelist = transform.ExecutiveToList(loginExecutive);
						//loginDiary = D.getDiary(loginexecutive_id);
						//Code to Convert Diary to byteArray
						//byteExecutive = util.arraylisttobytearray(list);
						dos.writeObject(executivelist);
						//Code to send Diary
					}
					break;
					
				case "2":
					// Client in Homepage
					String loginid = (String)dis.readObject();
					loginDiary = D.getDiary(loginid);
					Transform transform = new Transform();
					diarylist = transform.DiaryToList(loginDiary);
					dos.writeObject(diarylist);
					//code to write Diary
					inputlist = D.getidnameofexecutives();
					dos.writeObject(inputlist);
					String msg = D.getinbox(loginid);
					dos.writeObject(msg);
					//code to send file
					break;
				case "3":				// 2 means updateDiary request
					System.out.println("Inside 3");
					diarylist = (ArrayList<String>)dis.readObject();
					Transform trans= new Transform();
					loginDiary = trans.ListtoDiary(diarylist);
					D.updateDiary(loginexecutive_id, loginDiary);
					//code to send success or failure flag
					System.out.println("Diary Updated");
					break;
					
				case "4":				// 3 means call Meeting
					inputlist = (ArrayList<String>)dis.readObject();
					String callerexecutive = inputlist.get(0);
					int day = Integer.parseInt(inputlist.get(1));
					int month = Integer.parseInt(inputlist.get(2));
					int year = Integer.parseInt(inputlist.get(3));
					int numberofexecutives = Integer.parseInt(inputlist.get(4));
					String[] executives = new String[numberofexecutives];
					for(int i = 0;i < numberofexecutives ; ++i)
						executives[i] = inputlist.get(5+i);
					String venue = inputlist.get(5 + numberofexecutives);
					String purpose = inputlist.get(6 + numberofexecutives);
					
					System.out.println(callerexecutive);
					System.out.println(day);
					System.out.println(month);
					System.out.println(year);
					System.out.println(numberofexecutives);
					for(int i = 0; i < numberofexecutives ; ++i){
						System.out.println(executives[i]);
					}
					System.out.println(venue);
					System.out.println(purpose);
					System.out.println();
					System.out.println();
					
					meeting = new Meeting(callerexecutive, new Date(year, month, day), executives, venue, purpose);
					if(openSlot(meeting)){
						System.out.println("Inside Meeting");
						//code to send success
					}
					else{
						System.out.println("Meeting not found");
						File file = new File("/home/sabyasachee/secretary.txt");
						FileWriter filewriter = new FileWriter(file,true);
						GregorianCalendar cal = new GregorianCalendar();
						String date = String.valueOf(cal.get(Calendar.DAY_OF_MONTH)) +"/"+String.valueOf(cal.get(Calendar.MONTH)) +"/"+String.valueOf(cal.get(Calendar.YEAR));
						String message = "Meeting on "+meeting.getpurpose()+" to be scheduled on "+meeting.getdayinmonth()+" April"
								+" in Venue "+meeting.getvenue()+" among ";
						for(int i=0; i<meeting.getnumberofexecutives();++i)
							message+=meeting.getcalledexecutives()[i]+" ";
						filewriter.append((CharSequence)date+"\n");
						filewriter.append((CharSequence)message+"\n");
						D.insertHoldMeetings(meeting);
						filewriter.close();
					}
					break;
					
				case "6":			// Secretary Login
					//1 to send on success
					//0 to send on failure
					//String user = (String)dis.readObject();
					//String pwd = (String)dis.readObject();
					//if(user.equals(Secretaryuser) && pwd.equals(Secretarypassword)){
					//	dos.writeObject("1");
						inputlist = D.getidnameofexecutives();
						dos.writeObject(inputlist);
						File file = new File("/home/sabyasachee/secretary.txt");
						//FileReader filereader = new FileReader(file);
						BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
						String sq;
						ArrayList<String> message = new ArrayList<>();
						while((sq = bufferedreader.readLine())!=null){
							message.add(sq);
						}
						bufferedreader.close();
						dos.writeObject(message);
					//}
					//else 
					//	dos.writeObject("0");
					
					break;
					
				case "7":			// Secretary Request to send message to particular Executive
					int number = Integer.parseInt((String)dis.readObject());
					ArrayList<String> asd = (ArrayList<String>)dis.readObject();
					System.out.println(asd.size());
					for(String x : asd)
					System.out.println(x);
					String message_ = (String)dis.readObject();
					for(int i=0;i<number;++i){
						D.addMessage(asd.get(i), message_);
					}
					break;
					
				case "8":		//Executive request to see stats
					inputlist = (ArrayList<String>)dis.readObject();
					String id = inputlist.get(0);
					int start = Integer.parseInt(inputlist.get(1));
					int end = Integer.parseInt(inputlist.get(2));
					int meetings = D.getsingleexecutivestat(id, start, end);
					int jobs = D.getsingleexecutivestat_(id, start, end);
					System.out.println(meetings);
					System.out.println(jobs);
					dos.writeObject(String.valueOf(meetings));
					dos.writeObject(String.valueOf(jobs));
					break;
					
				case "9":		//general stat
					//inputlist = (ArrayList<String>)dis.readObject();
					//int start_ = Integer.parseInt(inputlist.get(0));
					//int end_ = Integer.parseInt(inputlist.get(1));
					int start_ = 1;
					int end_ = 30;
					ArrayList<String> stat = new ArrayList<>();
					ArrayList<String> idname = D.getidnameofexecutives();
					System.out.println(idname.size());
					for(int i = 0; i < idname.size() ; i+=2){
						stat.add(idname.get(i+1));
						int meeting = D.getsingleexecutivestat(idname.get(i), start_, end_);
						stat.add(String.valueOf(meeting));
					}
					for(String s : stat){
						System.out.println(s);
					}
					dos.writeObject(stat);
					inputlist = D.getprojstat();
					for(String s : inputlist){
						System.out.println(s);
					}
					dos.writeObject(inputlist);
					break;
				case "10":		//project stat
					inputlist = D.getprojstat();
					dos.writeObject(inputlist);
				}
			}
			System.out.println("Connection Ended...");
		}catch(IOException io){
			io.printStackTrace();
		}catch(ClassNotFoundException clao){
			clao.printStackTrace();
		}
	}
	
	Server(){
		D = new Database();
		D.getConnection();
		//D.addMessage("ERP1001", "tere naal");
	}
	
	public static void main(String[] args){
				
		Server server = new Server();
		while(true){
			server.runserver();
		}
		//GregorianCalendar cal = new GregorianCalendar();
		//System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		//Threading t = new Threading();
		/*while(true){
			server.runserver();
		}*/
		
	}
		

}
