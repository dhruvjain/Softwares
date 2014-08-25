

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Utilities {
	
	private static final String[] RANDOMJOBS = {"Production","Accounting","Insurance","Payment","Advertisement"};
	
	public int getnumberofDays(int monthint, int dayint, int year){
		GregorianCalendar cal = new GregorianCalendar();
		cal.set(Calendar.MONTH, monthint);
		cal.set(Calendar.YEAR, year);
		
		cal.set(Calendar.DAY_OF_MONTH, 1);
		int firstdayofmonth = cal.get(Calendar.DAY_OF_WEEK);
		//System.out.println(firstdayofmonth);
		
		int totaldays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(totaldays);
		int offsetdays = dayint >= firstdayofmonth ? dayint - firstdayofmonth : 7 - firstdayofmonth + dayint;
		System.out.println(offsetdays);
		if((totaldays - offsetdays)%7 == 0)
			return (totaldays - offsetdays)/7;
		else return (totaldays - offsetdays)/7 + 1;
	}
	
	public Work[] getDefaultdailytimetable(int dayofweek, int dayinmonth, int month, int year, String executive_id){
		Work[] dailytimetable = new Work[5];
		switch(dayofweek){
		case 1:
			for(int i=0;i<5;++i)
				dailytimetable[i] = new Leave(new Date(year, month, dayinmonth), executive_id);
			return dailytimetable;
		case 2:
			dailytimetable[1] = null;
			dailytimetable[2] = new Meeting("Sales", "V1", new Slot(2), new Date(year, month, dayinmonth));
			dailytimetable[0] = new Job(new Date(year, month, dayinmonth), RANDOMJOBS[0], new Slot(0), executive_id);
			dailytimetable[4] = null;
			dailytimetable[3] = new Job(new Date(year, month, dayinmonth), RANDOMJOBS[1], new Slot(3), executive_id);
			return dailytimetable;
		case 3:
			dailytimetable[0] = null;
			dailytimetable[1] = null;
			dailytimetable[2] = new Meeting("Customer_Review", "V2", new Slot(2), new Date(year, month, dayinmonth));
			dailytimetable[3] = new Job(new Date(year, month, dayinmonth), RANDOMJOBS[1], new Slot(3), executive_id);
			dailytimetable[4] = null;
			return dailytimetable;
		case 4:
			dailytimetable[0] = null;
			dailytimetable[1] = new Job(new Date(year, month, dayinmonth), RANDOMJOBS[0], new Slot(1), executive_id);
			dailytimetable[3] = null;
			dailytimetable[2] = new Job(new Date(year, month, dayinmonth), RANDOMJOBS[2], new Slot(2), executive_id);
			dailytimetable[4] = new Job(new Date(year, month, dayinmonth), RANDOMJOBS[4], new Slot(4), executive_id);
			return dailytimetable;
		case 5:
			dailytimetable[1] = null;
			dailytimetable[4] = null;
			dailytimetable[2] = new Meeting("Presentation", "V3", new Slot(2), new Date(year, month, dayinmonth));
			dailytimetable[0] = new Job(new Date(year, month, dayinmonth), RANDOMJOBS[3], new Slot(0), executive_id);
			dailytimetable[3] = new Job(new Date(year, month, dayinmonth), RANDOMJOBS[3], new Slot(3), executive_id);
			return dailytimetable;
		case 6:
			dailytimetable[0] = new Job(new Date(year, month, dayinmonth), RANDOMJOBS[2], new Slot(0), executive_id);
			dailytimetable[4] = null;
			dailytimetable[3] = null;
			dailytimetable[2] = null;
			dailytimetable[1] = new Job(new Date(year, month, dayinmonth), RANDOMJOBS[4], new Slot(1), executive_id);
			return dailytimetable;
		case 7:
			for(int i=0;i<5;++i)
				dailytimetable[i] = null;
                        System.out.println("yahoooooooooooo...");
			return dailytimetable;
		}
		return null;
	}
	
	public boolean isvalidmeetingdate(int dayinmonth){
		GregorianCalendar cal = new GregorianCalendar();
		int curdayinmonth = cal.get(Calendar.DAY_OF_MONTH);
		return dayinmonth - curdayinmonth >=2 ; 
	}
	
}
