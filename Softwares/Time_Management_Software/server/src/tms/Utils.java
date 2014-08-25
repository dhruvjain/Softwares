package tms;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

class Month extends Object implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8551346313267379533L;
	private static final String[] MONTHS = {"January","February","March","April","May","June","July","August"
		,"September","October","November","December"};
	private static String[] DAYS = {"SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};
	private int month;
	private int year;
	
	Month(){
		GregorianCalendar cal = new GregorianCalendar();
		month = cal.get(Calendar.MONTH);
		year = cal.get(Calendar.YEAR);
	}
	
	Month(int month){
		GregorianCalendar cal = new GregorianCalendar();
		year = cal.get(Calendar.YEAR);
		this.month = month;
	}
	
	Month(int month, int year){
		this.month = month;
		this.year = year;
	}
	
	public int getmonthint(){
		return month;
	}
	
	public String getmonthname(){
		return MONTHS[month];
	}
	
	public int getdays(){
		
		GregorianCalendar cal = new GregorianCalendar();
		cal.set(Calendar.MONTH, month);
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
	}
	
	public int getyear(){
		return year;
	}
	
	public String getdayname(int dayinmonth){
		
		GregorianCalendar cal = new GregorianCalendar();
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, dayinmonth);
		int dayinweek = cal.get(Calendar.DAY_OF_WEEK);
		return DAYS[dayinweek-1];
		
	}
	
	public int getdayinweek(int dayinmonth){
		
		GregorianCalendar cal = new GregorianCalendar();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, dayinmonth);
		return cal.get(Calendar.DAY_OF_WEEK);
		
	}
	
}

class Date extends Object implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7013885347805515248L;
	private static final String[] DAYS = {"SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};
	private static final String[] MONTHS = {"January","February","March","April","May","June","July","August"
		,"September","October","November","December"};
	private int day;
	private int month;
	private int year;
	
	Date(){
		GregorianCalendar cal = new GregorianCalendar();
		day = cal.get(Calendar.DAY_OF_MONTH);
		month = cal.get(Calendar.MONTH);
		year = cal.get(Calendar.YEAR);
	}
	
	Date(int year, int month, int day){
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public int getDayint(){
		return day;
	}
	
	public String getDayname(){
		GregorianCalendar cal = new GregorianCalendar();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, day);
		return DAYS[cal.get(Calendar.DAY_OF_WEEK)-1];
	}
	
	public int getMonthint(){
		return month;
	}
	
	public String getMonthname(){
		return MONTHS[month];
	}
	
	public int getyear(){
		return year;
	}
	
	public void setdayint(int dayint){
		day = dayint;
	}
	
}

class Slot extends Object implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2659197548301346197L;
	private static final String[] SLOTS = {"9:00 - 10:00","10:00 - 11:00","11:00 - 12:00","1:00 - 2:00","2:00 - 3:00"};
	private int slot;
	
	Slot(int slot){
		this.slot = slot;
	}
	
	public int getslotint(){
		return slot;
	}
	
	public String getslotname(){
		return SLOTS[slot];
	}
	
	public void setslot(int slot){
		this.slot = slot;
	}
	
}

class Day extends Object implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4722945717014667884L;

	private static final String[] DAYS = {"SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};
	
	private int dayinmonth;
	private int dayinweek;
	private Work[] dailytimetable = null;	
	
	Day(){}
	
	Day(int dayinmonth, int dayinweek, int month, int year, String executive_id){
		//used in default time table
		this.dayinmonth = dayinmonth;
		this.dayinweek = dayinweek;
		dailytimetable = new Work[5];
		Utilities u = new Utilities();
		dailytimetable = u.getDefaultdailytimetable(dayinweek, dayinmonth, month, year, executive_id);
	}
	
	public Day(int i, int dayint, Work[] work) {
		dayinmonth = i;
		dayinweek = dayint;
		dailytimetable = work;
	}

	public Work[] getdailytimetable(){
		return dailytimetable;
	}
	
	public void setdailytimetable(Work[] dailytimetable){
        this.dailytimetable = dailytimetable;
    }
	
	public void insertmeetingindailytimetable(Meeting meeting){
		this.dailytimetable[meeting.getSlot().getslotint()] = meeting;
	}
}