package tms;

import java.util.*;

public class Transform {
	
	public Diary ListtoDiary(ArrayList<String> list){
		
		String exid = list.get(0);
        Month month = new Month ( Integer.parseInt(list.get(1)) , Integer.parseInt(list.get(2)) );
        
        int index=4;
        Map<Integer,Day> timetable;
        timetable = new HashMap<>();
        
        for(int i=1; i<=month.getdays() ; i++,index++ ){
        	
        	Work[] work=new Work[5];
        	Date date = new Date(month.getyear(), month.getmonthint(), i);
        	
        	for(int k=0;k<5;k++){
        	
        		String type = list.get(index);
        	
        		switch(type){
        		
        		case "OPENSLOT":
        			work[k]=null;
        			index++;
        			break;
        	
        		case "IMPORTANT JOB":
        			work[k]=new Job(date, list.get(index+1), new Slot(k), exid);
        			index+=2;
        			break;
        		
        		case "LEAVE":
        			work[k]=new Leave(date, exid, list.get(index+1));
        			index+=2;
        			break;
        		
        		case "MEETING":
        			String pur=list.get(index+1);
        			String ven=list.get(index+2);
        			String caller=list.get(index+3);
        			int no_of_ex=Integer.parseInt(list.get(index+4));
        			if(no_of_ex==0){
        				work[k]=new Meeting(pur, ven, new Slot(k), date);
        				index+=5;
        			}
        			else {
        				String[] str= new String[no_of_ex];
        				for(int j=0;j<no_of_ex;j++){
        					str[j]=list.get(index+5+j);
        				}
        				work[k]=new Meeting(caller, date, str, ven, pur);
        				index+=(5+no_of_ex);
        			}

        		}
        	}
        	
        	Day day=new Day(i, date.getDayint(), work);
        	timetable.put(i, day);
        }
        
        Diary dnew = new Diary(exid, month, timetable);
        return dnew;
		
	}

	public ArrayList<String> DiaryToList(Diary diary){
		
		ArrayList<String> list = new ArrayList<>();
		list.add(diary.getexecuitve_id());
		list.add(String.valueOf(diary.getmonth().getmonthint()));
        list.add(String.valueOf(diary.getmonth().getyear()));
        Work[] w=new Work[5];
        
        for(int k = 1; k <= diary.getmonth().getdays() ; k++ ){
        	
        	list.add(String.valueOf(k));
        	w=diary.getsingleDaytimetable(k);
        	
        	for(int i = 0; i < 5; i++ ){
        		
        		if(w[i]==null){
        			list.add("OPENSLOT");
        		}
        		
        		else
        		{
        			list.add(w[i].getName());

        			if(w[i].getName().equals("MEETING"))
        			{
        				list.add(w[i].getpurpose());
        				Meeting m = (Meeting)w[i];
        				
        				list.add(m.getvenue());
        				if(m.getcallerexecutive_id()==null)
        					list.add("null");
        				else list.add(m.getcallerexecutive_id());
        				list.add(String.valueOf(m.getnumberofexecutives()));
        				for(int j=0;j<m.getnumberofexecutives();j++){
        					list.add(m.getExecutiveID(j));
        				}
        			}
        			
        			if(w[i].getName().equals("IMPORTANT JOB"))
        			{
        				list.add(w[i].getpurpose());
        			}
        			if(w[i].getName().equals("LEAVE"))
        			{
        				list.add(w[i].getpurpose());
        			}
        		}
        	}
        }
        
		return list;
	}
	
	public ArrayList<String> ExecutiveToList(Executive e){
		
		ArrayList<String> list = new ArrayList<>();
		list.add(e.getname());
		list.add(e.getid());
		list.add(e.getpassword());
		list.add(e.getaddress());
		list.add(String.valueOf(e.getavailedleaves()));
		list.add(String.valueOf(e.getMeetingslots()));
		return list;
	}
	
	
	
}
