package tms;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Diary extends Object implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3411056797614644123L;
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
	
	Diary(String id, Month month, Map<Integer, Day> timetable){
		executive_id = id;
		this.month = month;
		this.timetable = timetable;
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
	
	public void setsingleDaytimetable(Work[] dailytimetable, int dayinmonth){
        Day day = this.timetable.get(dayinmonth);
        day.setdailytimetable(dailytimetable);
	}
	
	public int changeLeaveDate(int olddayinmonth,int newdayinmonth){ 		
		//0 means rescheduled day has a MEETING, 1 means it already has a leave, 2 means success
		if(olddayinmonth==newdayinmonth)
			return 2;
		Work[] newdaydailytimetable = getsingleDaytimetable(newdayinmonth);
		Work[] olddaydailytimetable = getsingleDaytimetable(olddayinmonth);
		if(newdaydailytimetable[0].getName().equals("LEAVE"))		
			return 1;
		for(int i = 0; i<5; ++i){
			if(newdaydailytimetable[i]!=null && newdaydailytimetable[i].getName().equals("MEETING"))
				return 0;
		}
		for(int i=0; i<5; ++i)
			olddaydailytimetable[i].setDayinDate(newdayinmonth);
		newdaydailytimetable = olddaydailytimetable;
		Utilities u = new Utilities();
		olddaydailytimetable = u.getDefaultdailytimetable(month.getdayinweek(olddayinmonth), olddayinmonth, month.getmonthint(), month.getyear(), executive_id);
		return 2;
	}
	
	public int takeNewLeave(int dayinmonth, String purpose){	
		//0 means rescheduled day has a MEETING, 1 means it already has a leave, 2 means success
		Work[] dailytimetable = getsingleDaytimetable(dayinmonth);
		if(dailytimetable[0]!=null && dailytimetable[0].getName().equals("LEAVE"))
			return 1;
		for(int i = 0; i<5; ++i){
			if(dailytimetable[i]!=null && dailytimetable[i].getName().equals("MEETING"))
				return 0;
		}
		for(int i=0; i<5; ++i)
			dailytimetable[i] = new Leave(new tms.Date(month.getyear(), month.getmonthint(), dayinmonth), executive_id, purpose);
		return 2;
	}
	
	public int cancelLeave(int dayinmonth){	
		//0 trying to cancel an official Holiday 1 success
		Work[] dailytimetable = getsingleDaytimetable(dayinmonth);
		if(dailytimetable[0].getpurpose() == "OFFICIAL HOLIDAY")
			return 0;
		Utilities u = new Utilities();
		dailytimetable = (Single[])u.getDefaultdailytimetable(month.getdayinweek(dayinmonth), dayinmonth, month.getmonthint(), month.getyear(), executive_id);
		return 1;
	}
	
	public int changeJobDetails(int olddayinmonth, int newdayinmonth, int oldslot, int newslot, int purpose){
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
		return 3;
	}
	
	public int cancelJob(int dayinmonth, int slot){
		//0 success
		Work[] dailytimetable = getsingleDaytimetable(dayinmonth);
		dailytimetable[slot] = null;
		return 0;
	}
	
	public void insertmeeting(Meeting meeting){
		System.out.println(meeting.getdayinmonth());
		System.out.println(meeting.getSlot().getslotint());
		//Work w = getsingleDaytimetable(meeting.getdayinmonth())[meeting.getSlot().getslotint()];
		Day day = this.timetable.get(meeting.getdayinmonth());
		day.insertmeetingindailytimetable(meeting);
		System.out.println("meeting inserted...");
		//w = meeting;
	}	
	
	public int getmeetings(int start, int end){
		
		int meetings = 0;
		for(int i = start ; i <= end ; ++i){
			Work[] w = getsingleDaytimetable(i);
			for(int j = 0; j<5 ; ++j)
				if(w[j]!=null && w[j].getName().equals("MEETING")==true)
					meetings++;
		}
		return meetings;
	}
	
	public int getjobs(int start, int end){
		
		int jobs = 0;
		for(int i = start ; i <= end ; ++i){
			Work[] w = getsingleDaytimetable(i);
			for(int j = 0; j<5 ; ++j)
				if(w[j]!=null && w[j].getName().equals("IMPORTANT JOB")==true)
					jobs++;
		}
		
		return jobs;
		
	}
}
