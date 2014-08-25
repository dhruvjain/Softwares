/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iiterp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author DHRUV
 */
public class StudentView extends javax.swing.JFrame {
 private static String path = System.getProperty("user.home") + "/Project2Files";
   //private static String path = System.getProperty("user.home.Documents.NetBeansProjects.IITERP") + "/Project2Files"; 
      
        
       
        /**
     * Creates new form StudentView
     */
    public StudentView(String rollno,String name) {
        initComponents();
        
        jTextField2.setText("");
        String elective="",NoofComp="";
        jLabel6.setText(name);
        jLabel13.setText(rollno);
        File f1 = new File(path + "/Semesterelective.txt");
        if(!f1.exists()){
        return;}
       try{ 
        BufferedReader br = new BufferedReader(new FileReader(f1));
        elective =br.readLine();
        br.close();
       }
       catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
       }
        jTextField1.setText(elective);
        jTextField1.setEditable(false);
        
         File f2=new File(path + "/compulsorycourses.txt");
         ArrayList<String> compcourses  = new ArrayList<String>();
            String course;
            try{
             BufferedReader br3 = new BufferedReader(new FileReader(f2));
            while((course = br3.readLine()) != null)
            {
                compcourses.add(course);
            }
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            
            }
            String[] courseArr = new String[compcourses.size()];
            
            compcourses.toArray(courseArr);
            
            jList2.setListData(courseArr);
            
            
            /*try{
                Student.register(jLabel6.getText(),jLabel7.getText(), courseArr,compcourses.size());
            }
            catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
            }*/
            File f3=new File(path + "/electivecourses.txt");
            ArrayList<String> courses2  = new ArrayList<String>();
            
            try{
             BufferedReader br4 = new BufferedReader(new FileReader(f3));
            while((course = br4.readLine()) != null)
            {
                courses2.add(course);
            }
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            
            }
            String[] courseArr2 = new String[courses2.size()];
            courses2.toArray(courseArr2);
            jList1.setListData(courseArr2);
            jList1.setSelectionModel(new MySelectionModel(jList1,Integer.parseInt(jTextField1.getText())));
            /*
            File f5=new File(path + "/"+rollno+"grades.txt");
            if(!f5.exists())
                return;
            String cname,grade,cr;
            ArrayList<String> optcourses  = new ArrayList<String>();
            ArrayList<String> credits  = new ArrayList<String>();
            ArrayList<String> grades  = new ArrayList<String>();
            try{
             BufferedReader br5=new BufferedReader(new FileReader(f5));
             while((cname=br5.readLine())!=null){
                    grade=br5.readLine();
                    cr=br5.readLine();
                 optcourses.add(cname);
                 grades.add(grade);
                 credits.add(cr);
                 }
             
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            e.printStackTrace();
            }
            String[] optCourses = new String[optcourses.size()];
            optcourses.toArray(optCourses);
            jList4.setListData(optCourses);
           String[] Grades = new String[grades.size()];
            grades.toArray(Grades);
            jList5.setListData(Grades);
            String[] Credits = new String[credits.size()];
            credits.toArray(Credits);
            jList6.setListData(Credits);
            JOptionPane.showMessageDialog(null,optcourses.size());
            String cg=Student.cgpa(Credits,Grades,optcourses.size());
           
            jTextField2.setText(cg);
            jTextField2.setEditable(false);
            if(Float.parseFloat(cg)>=9.0){
            JOptionPane.showMessageDialog(null,"congartulations");
            }
             if(Float.parseFloat(cg)<=6.0){
            jLabel13.setVisible(true);
            }*/
    }
private static class MySelectionModel extends DefaultListSelectionModel
{
    private JList list;
    private int maxCount;

    private MySelectionModel(JList list,int maxCount)
    {
        this.list = list;

        this.maxCount = maxCount;
    }

    @Override
    public void setSelectionInterval(int index0, int index1)
    {
        if (index1 - index0 >= maxCount)
        {
            index1 = index0 + maxCount - 1;
        }
        super.setSelectionInterval(index0, index1);
    }

    @Override
    public void addSelectionInterval(int index0, int index1)
    {
        int selectionLength = list.getSelectedIndices().length;
        if (selectionLength >= maxCount)
            return;

        if (index1 - index0 >= maxCount - selectionLength)
        {
            index1 = index0 + maxCount - 1 - selectionLength;
        }
        if (index1 < index0)
            return;
        super.addSelectionInterval(index0, index1);
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanelcomp = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList5 = new javax.swing.JList();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList6 = new javax.swing.JList();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton2.setText("jButton2");

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("NO. OF ELECTIVES TO BE TAKEN");

        jLabel2.setText("CORE COURSES: (COMPULSORY) ");

        jLabel3.setText("ELECTIVES AVAILABLE:");

        jScrollPane3.setViewportView(jList2);

        javax.swing.GroupLayout jPanelcompLayout = new javax.swing.GroupLayout(jPanelcomp);
        jPanelcomp.setLayout(jPanelcompLayout);
        jPanelcompLayout.setHorizontalGroup(
            jPanelcompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        jPanelcompLayout.setVerticalGroup(
            jPanelcompLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jList1);

        jButton3.setText("DONE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jList3.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jList3);

        jLabel12.setText("ELECTIVES TAKEN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelcomp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                                .addGap(28, 28, 28))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelcomp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(jScrollPane4))))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(109, 109, 109))
        );

        jTabbedPane1.addTab("COURSES", jPanel1);

        jScrollPane5.setViewportView(jList4);

        jScrollPane6.setViewportView(jList5);

        jLabel8.setText("SUBJECTS");

        jLabel9.setText("GRADE");

        jScrollPane7.setViewportView(jList6);

        jLabel10.setText("CREDIT");

        jLabel11.setText("CGPA:");

        jButton4.setText("GET GRADES");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(jButton4)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(130, 130, 130))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addContainerGap(156, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("GRADE SHEET", jPanel2);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("NAME:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("ROLL NO.");

        jButton1.setText("LOG OUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.setVisible(false);
       Home h=new Home();
       h.setVisible(true);
       this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            String rollno=jLabel13.getText();    
            File f=new File(path +"/"+rollno+".txt");
            String n=jTextField1.getText();
            String[] data=new String[Integer.parseInt(n)];
            String s;
            try
            {
             BufferedReader br2= new BufferedReader(new FileReader(f));
             br2.readLine();
             br2.readLine();
             //s=br2.readLine();
             
             if((s=br2.readLine())!=null)
             {JOptionPane.showMessageDialog(null,"already registered");
             return;
             }
             
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
            }
            
            
            jList3.setListData(jList1.getSelectedValues());
            Object[] values=jList1.getSelectedValues();
            String[] elec = new String[values.length];
            int count=0;
            for(Object o:values){
             elec[count]=(String)o;
              count++;
            }
            //JOptionPane.showMessageDialog(null,values.length);
            try{
                
            Student.register(jLabel6.getText(),rollno,elec,values.length);
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
            }
            File f2=new File(path + "/compulsorycourses.txt");
            ArrayList<String> compcourses  = new ArrayList<String>();
            String course;
            try{
             BufferedReader br3 = new BufferedReader(new FileReader(f2));
            while((course = br3.readLine()) != null)
            {
                compcourses.add(course);
            }
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            e.printStackTrace();
            }
            String[] courseArr = new String[compcourses.size()];
            
            compcourses.toArray(courseArr);
            try{
                
                Student.register(jLabel6.getText(),rollno,courseArr,compcourses.size());
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
            }
            // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String rollno=jLabel13.getText();
        File f5=new File(path + "/"+rollno+"grades.txt");
            if(!f5.exists())
                return;
            String cname,grade,cr;
            ArrayList<String> optcourses  = new ArrayList<String>();
            ArrayList<String> credits  = new ArrayList<String>();
            ArrayList<String> grades  = new ArrayList<String>();
            try{
             BufferedReader br5=new BufferedReader(new FileReader(f5));
             while((cname=br5.readLine())!=null){
                    grade=br5.readLine();
                    cr=br5.readLine();
                 optcourses.add(cname);
                 grades.add(grade);
                 credits.add(cr);
                 }
             
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            e.printStackTrace();
            }
            String[] optCourses = new String[optcourses.size()];
            optcourses.toArray(optCourses);
            jList4.setListData(optCourses);
           String[] Grades = new String[grades.size()];
            grades.toArray(Grades);
            jList5.setListData(Grades);
            String[] Credits = new String[credits.size()];
            credits.toArray(Credits);
            jList6.setListData(Credits);
            //JOptionPane.showMessageDialog(null,optcourses.size());
            String cg=Student.cgpa(Credits,Grades,optcourses.size());
           
            jTextField2.setText(cg);
            jTextField2.setEditable(false);
            if(Float.parseFloat(cg)>=9.0){
            JOptionPane.showMessageDialog(null,"congartulations");
            }
             if(Float.parseFloat(cg)<=6.0){
            JOptionPane.showMessageDialog(null,"work hard you are in danger zone");
            }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JList jList3;
    private javax.swing.JList jList4;
    private javax.swing.JList jList5;
    private javax.swing.JList jList6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelcomp;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
  
}
