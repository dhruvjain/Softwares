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
import java.util.HashMap;
import java.util.Map;

public class Diary extends Object implements Serializable{
	
	private String executive_id;
	private Month month;
	private Map<Integer, Day > timetable;	// Integer is Day in Month
	
	Diary(String id){
		
		executive_id = id;
		month = new Month();
		timetable = new HashMap<>();
		for(int i=1; i <= month.getdays();++i){
			timetable.put(i, new Day(i, month.getdayinweek(i), month.getmonthint(), month.getyear(), executive_id));
		}
	}
        Diary(String id,Month m,Map<Integer,Day> timetable){
         this.executive_id=id;
         this.month=m;
         this.timetable=timetable;
        
        }
	
	public String getexecuitve_id(){
		return executive_id;
	}
        public Month getmonth(){
        return month;
        }
	
	public Work[] getsingleDaytimetable(int dayinmonth){
		return timetable.get((int)dayinmonth).getdailytimetable();
	}
	public void setsingledaytimetable(Work[] dailytimetable,int dayinmonth){
        Day day=this.timetable.get(dayinmonth);
        day.setdailytimetable(dailytimetable);
        }
	public int changeLeaveDate(int olddayinmonth,int newdayinmonth){ 		
		//0 means rescheduled day has a MEETING, 1 means it already has a leave, 2 means success
		if(olddayinmonth==newdayinmonth)
			return 2;
		Work[] newdaydailytimetable = getsingleDaytimetable(newdayinmonth);
		Work[] olddaydailytimetable = getsingleDaytimetable(olddayinmonth);
                if(olddaydailytimetable[0]!=null && olddaydailytimetable[0].getpurpose().equals("OFFICIAL HOLIDAY")){
                 return 3;
                }
		if(newdaydailytimetable[0]!=null && newdaydailytimetable[0].getName().equals("LEAVE"))		
			return 1;
		for(int i = 0; i<5; ++i){
			if(newdaydailytimetable[i]!=null && newdaydailytimetable[i].getName().equals("MEETING"))
				return 0;
		}
                System.out.println("qwasassaasa");
                System.out.println(olddaydailytimetable[0].getName());
                System.out.println(olddaydailytimetable[4].getName());
               // System.out.println(newdaydailytimetable[0].getName());
                System.out.println(newdaydailytimetable[4].getName());
		for(int i=0; i<5; ++i)
			olddaydailytimetable[i].setDayinDate(newdayinmonth);
		for(int i = 0; i< 5; ++i)newdaydailytimetable[i] = olddaydailytimetable[i];
		Utilities u = new Utilities();
                System.out.println(month.getdayinweek(olddayinmonth));
                System.out.println(olddayinmonth);
                System.out.println(month.getmonthint());
                System.out.println(month.getyear());
                System.out.println(executive_id);
                
		olddaydailytimetable = u.getDefaultdailytimetable(month.getdayinweek(olddayinmonth), olddayinmonth, month.getmonthint(), month.getyear(), executive_id);
		if(olddaydailytimetable[2]==null)
                    System.out.println("messi");
                System.out.println("asasasasasa");
                System.out.println(olddaydailytimetable[1].getName());
                System.out.println(olddaydailytimetable[4].getName());
                System.out.println(newdaydailytimetable[0].getName());
                System.out.println(newdaydailytimetable[4].getName());
                this.setsingledaytimetable(olddaydailytimetable, olddayinmonth);
                this.setsingledaytimetable(newdaydailytimetable, newdayinmonth);
                return 2;
	}
	
	public int takeNewLeave(int dayinmonth, String purpose){	
		//0 means rescheduled day has a MEETING, 1 means it already has a leave, 2 means success
		Work[] dailytimetable = getsingleDaytimetable(dayinmonth);
                
		if(dailytimetable[0]!=null && dailytimetable[0].getName().equals("LEAVE"))
			return 1;
		for(int i = 0; i<5; ++i){
			if(dailytimetable[i]!=null && dailytimetable[i].getName().equals( "MEETING"))
				return 0;
		}
		for(int i=0; i<5; ++i)
			dailytimetable[i] = new Leave(new Date(month.getyear(), month.getmonthint(), dayinmonth), executive_id, purpose);
		return 2;
	}
	
	public int cancelLeave(int dayinmonth){	
		//0 trying to cancel an official Holiday 1 success
		Work[] dailytimetable = getsingleDaytimetable(dayinmonth);
		if(dailytimetable[0].getpurpose() == "OFFICIAL HOLIDAY")
			return 0;
		Utilities u = new Utilities();
		dailytimetable = (Single[])u.getDefaultdailytimetable(month.getdayinweek(dayinmonth), dayinmonth, month.getmonthint(), month.getyear(), executive_id);
		this.setsingledaytimetable(dailytimetable, dayinmonth);
                return 1;
	}
	
	public int changeJobDetails(int olddayinmonth, int newdayinmonth, int oldslot, int newslot){
		//0 rescheduled day has Leave
		//1 rescheduled day and slot has Meeting
		//2 rescheduled day and slot has already a Job
		//3 success
		if(olddayinmonth==newdayinmonth && oldslot==newslot)
			return 3;
		Work[] newdaydailytimetable = getsingleDaytimetable(newdayinmonth);
		Work[] olddaydailytimetable = getsingleDaytimetable(olddayinmonth);
		if(newdaydailytimetable[newslot] != null){
			if(newdaydailytimetable[0].getName() == "LEAVE")
				return 0;
			if(newdaydailytimetable[newslot].getName() == "MEETING")
				return 1;
			if(newdaydailytimetable[newslot].getName() == "IMPORTANT JOB")
				return 2;
		}
		
		Job job = (Job)olddaydailytimetable[oldslot];
                
		job.setSlot(newslot);
		olddaydailytimetable[oldslot].setDayinDate(newdayinmonth);
		newdaydailytimetable[newslot] = olddaydailytimetable[oldslot];
		olddaydailytimetable[oldslot] = null;
                this.setsingledaytimetable(olddaydailytimetable, olddayinmonth);
                this.setsingledaytimetable(newdaydailytimetable, newdayinmonth);
		return 3;
	}
	
	public int planNewJob (String purpose, int dayinmonth, int slot){
		//0 day has Leave
		//1 day and slot has Meeting
		//2 day and slot has already a Job
		//3 success
		
		Work[] dailytimetable = getsingleDaytimetable(dayinmonth);
		if(dailytimetable[slot] != null){
			if(dailytimetable[slot].getName() == "LEAVE")
				return 0;
			if(dailytimetable[slot].getName() == "MEETING")
				return 1;
			if(dailytimetable[slot].getName() == "IMPORTANT JOB")
				return 2;
		}
		dailytimetable[slot] = new Job(new Date(month.getyear(), month.getmonthint(), dayinmonth), purpose, new Slot(slot), executive_id);
		this.setsingledaytimetable(dailytimetable, dayinmonth);
                return 3;
	}
	
	public int cancelJob(int dayinmonth, int slot){
		//0 success
		Work[] dailytimetable = getsingleDaytimetable(dayinmonth);
		dailytimetable[slot] = null;
		return 0;
	}
	
	public void insertmeeting(Meeting meeting){
		Work w = getsingleDaytimetable(meeting.getdayinmonth())[meeting.getSlot().getslotint()];
		w = meeting;
	}	
}

