package tms;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Executive implements Serializable{
	
	private static final int MAX_LEAVES = 5;
	
	private String executive_id;
	private String executive_name;
	private String executive_address;
	private String executive_password;
	private int leaves_availed;
	private int slotsinMeeting;		//slots spent in meeting
		
	Executive(String id, String name, String address, String password){
		
		executive_id = id;
		executive_name = name;
		executive_address = address;
		executive_password = password;
		leaves_availed = 0;
		setDefaultslotsinMeeting();
	}
	
	Executive(String id, String name, String address, String password, int leaves, int slotsinmeeting){
		
		this.executive_id = id;
		this.executive_name = name;
		this.executive_address = address;
		this.executive_password = password;
		this.leaves_availed = leaves;
		this.slotsinMeeting = slotsinmeeting;
		
	}
	
	private void setDefaultslotsinMeeting(){
		Utilities u = new Utilities();
		GregorianCalendar cal = new GregorianCalendar();
		int mondays = u.getnumberofDays(cal.get(Calendar.MONTH), 2, cal.get(Calendar.YEAR));
		int tuesdays = u.getnumberofDays(cal.get(Calendar.MONTH), 3, cal.get(Calendar.YEAR));
		int thursdays = u.getnumberofDays(cal.get(Calendar.MONTH), 5, cal.get(Calendar.YEAR));
		this.slotsinMeeting = mondays + tuesdays + thursdays;
	}
	
	public String getid(){
		return executive_id;
	}
	
	public String getname(){
		return executive_name;
	}
	
	public String getaddress(){
		return executive_address;
	}
	
	public String getpassword(){
		return executive_password;
	}
	
	public int getavailedleaves(){
		return leaves_availed;
	}
	
	public int getMeetingslots(){
		return slotsinMeeting;
	}
	
	public void set_name(String name){
		executive_name = name;
	}
	
	public void set_address(String address){
		executive_address = address;
	}
	
	public void set_password(String password){
		executive_password = password;
	}

	public boolean isNewLeaveAllowed(){
		return leaves_availed < MAX_LEAVES ;
	}
	
	public void incrementLeaves(){
		leaves_availed++;
	}
	
	public Meeting callMeeting(String[] executives, String venue, Date date, String purpose){
		Meeting newmeeting = new Meeting(executive_id, date, executives, venue, purpose);
		return newmeeting;
	}
	
}
