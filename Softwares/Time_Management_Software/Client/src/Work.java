/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DHRUV
 */

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Work implements Serializable{
	
	protected Date date = null;
	protected String purpose = null;
	
	public abstract String[] getDetails();
	public abstract String getName();
	
	public String getpurpose(){
		return purpose;
	}
		
	public void setDayinDate(int newdayint){
		date.setdayint(newdayint);
	}
	
	public Date getDate(){
		return date;
	}
	
	public int getdayinmonth(){
		return date.getDayint();
	}
	
}

@SuppressWarnings("serial")
abstract class Single extends Work {
	
	protected String executive_id = null;
				
}

@SuppressWarnings("serial")
class Job extends Single {
		
	private Slot slot;
		
	Job(Date date, String purpose, Slot slot, String id){
		this.date = date;
		this.purpose = purpose;
		this.slot = slot;
		this.executive_id = id;
	}
	
	public String getName(){
		return "IMPORTANT JOB";
	}
	
	public String[] getDetails(){
		String[] details = new String[1];
		details[0] = purpose;
		return details;
	}
	
	public void setSlot(int newslotint){
		slot.setslot(newslotint);
	}
	
}

@SuppressWarnings("serial")
class Leave extends Single {
			
	Leave(Date date, String executive_id){
		//used in default Diary
		this.date = date;
		this.executive_id = executive_id;
		this.purpose = "OFFICIAL HOLIDAY";
	}
	
	Leave(Date date, String executive_id, String purpose){
		this.date = date;
		this.executive_id = executive_id;
		this.purpose = purpose;
	}
	
	public String[] getDetails(){
		String[] details = new String[1];
		details[0] = purpose;
		return details;
	}
	
	public String getName(){
		return "LEAVE";
	}
			
}

@SuppressWarnings("serial")
class Meeting extends Work implements Serializable{
	
	private int numberofExecutives;
	private String callerExecutiveID;
	private String[] executives = null;
	private String venue = null;
	
	private Slot slot;
	// meeting is always of one hour
	private int state;
	// 0 means new Meeting
	// 1 means Approved Meeting
	// 2 means Meeting is on Hold
	// 3 means Meeting has been cancelled
	
	Meeting(String project, String venue, Slot slot, Date date){  //used in default Diary
		this.purpose = project;
		this.venue = venue;
		this.setSlot(slot);
		this.date = date;
	}
	
	Meeting(String executive_id, Date date, String[] executives, String venue, String project){
		// used when calling a new meeting
		this.callerExecutiveID = executive_id;
		this.date = date;
		this.executives = executives;
		this.venue = venue;
		this.purpose = project;
		this.numberofExecutives = executives.length;
		setstate(0);
		
	}
	
	public void setstate(int st){
		state = st;
	}
		
	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}

	public String getName(){
		return "MEETING";
	}
	

	
	public int getnumberofexecutives(){
		return numberofExecutives;
	}
	
	public String getExecutiveID(int index){
		return executives[index];
	}
	
	public String[] getcalledexecutives(){
		return executives;
	}
	
	public String getvenue(){
		return venue;
	}
        public String getcallerexecutive_id(){
        return callerExecutiveID;
        }
	public String[] getDetails() {
		String[] details = new String[2];
		details[0] = purpose;
		details[1] = venue;
		return details;
	}
		
}

