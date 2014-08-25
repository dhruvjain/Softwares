
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DHRUV
 */
public class Diarytoarray {
    public static void main(String args[]) throws IOException{
        // Diary to string aray conversion
        String id="7302";
        Diary d=new Diary(id);
        List<String> list = new ArrayList<String>();
        list.add(id);
        list.add(String.valueOf(d.getmonth().getmonthint()));
        list.add(String.valueOf(d.getmonth().getyear()));
        Work[] w=new Work[5];
        
        for(int k=1;k<=d.getmonth().getdays();k++){
        list.add(String.valueOf(k));
        w=d.getsingleDaytimetable(k);
        for(int i=0;i<5;i++){
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
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         DataOutputStream out = new DataOutputStream(baos);
         for (String element : list) {
           try {
               out.writeUTF(element);
           } catch (IOException ex) {
               Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
           }
}
        byte[] bytes = baos.toByteArray();
        
        for (String element : list) {
            System.out.println(element);
        }
        
        
        System.out.println("////////////////// \n");
        String exid=list.get(0);
        Month m=new Month(Integer.parseInt(list.get(1)),Integer.parseInt(list.get(2)));
        int index=4;
        Map<Integer,Day> timetable;
        timetable = new HashMap<>();
        for(int i=1;i<=m.getdays();i++,index++){
            Work[] work=new Work[5];
            Date date = new Date(m.getyear(), m.getmonthint(), i);
            
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
        Diary dnew=new Diary(exid, m, timetable);
        System.out.println(dnew.getmonth().getdays());
        for(int i=1;i<=dnew.getmonth().getdays();i++){
        Work[] work2=dnew.getsingleDaytimetable(i);
            for(int j=0;j<5;j++){
                if(work2[j]!=null){
                String[] ar=work2[j].getDetails();
                System.out.println(work2[j].getName());
                    for(int k=0;k<ar.length;k++)
                        System.out.println(ar[k]);
                }
            }
        }
            
        
   /*     ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(baos);
        for (String element : list) {
           try {
               out.writeUTF(element);
           } catch (IOException ex) {
               Logger.getLogger(signup.class.getName()).log(Level.SEVERE, null, ex);
           }
}
    byte[] bytes = baos.toByteArray();
    ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
    DataInputStream in = new DataInputStream(bais);
    List<String> al = new ArrayList<String>();
    while (in.available() > 0) {
    String element = in.readUTF();
    System.out.println(element);
    al.add(element);
}
    
 */ 
}
}
