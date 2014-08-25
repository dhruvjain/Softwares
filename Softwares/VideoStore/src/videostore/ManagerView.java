/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package videostore;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DHRUV
 */
public class ManagerView extends javax.swing.JFrame {
private static String path = System.getProperty("user.home") + "/Project5Files";
 Date dcurrent=new Date();
 int daysgap;
 static String pattern = "dd-MM-yyyy";
 SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
      String mydate =new SimpleDateFormat(pattern).format(dcurrent);
      DefaultTableModel model;
     ArrayList<Store> s=new ArrayList<Store>();
      
    // ArrayList<Store> s2=new ArrayList<Store>();/**
     //* Creates new form ManagerView
     //*/
    public ManagerView() {
        initComponents();
       
        
      model=(DefaultTableModel)jTable1.getModel();  
      jLabeldate.setText(mydate);
       String[] data=new String[5];
          //String date,rental,line;
          double n;
     try{    FileInputStream fis = new FileInputStream(path + "/store.ser");
ObjectInputStream ois = new ObjectInputStream(fis);
s = (ArrayList<Store>) ois.readObject();
ois.close();
      }
      
      catch(Exception e){
       
      }
          
          SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
          
             for(int i=0;i<s.size();i++)
             { data[0]=s.get(i).type;
             data[1]=s.get(i).date;
             
             data[2]=s.get(i).prize;
             data[3]=s.get(i).rent;
             data[4]=s.get(i).isavail;
             try {
        Date d = formatter.parse(data[1]);
        daysgap=(int)( (dcurrent.getTime() - d.getTime()) / (1000 * 60 * 60 * 24));
        
        if(daysgap>=365){
        n=daysgap/365;
         
      data[3]=String.valueOf(Integer.parseInt(data[3])/Math.pow(2,n));
     
        }
        
    } catch (ParseException ex) {
        Logger.getLogger(ManagerView.class.getName()).log(Level.SEVERE, null, ex);
    }  
            model.insertRow(model.getRowCount(),data);
             }
     
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        button2 = new java.awt.Button();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabeldate = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setText("DATE OF PROCUREMENT(dd-mm-yyyy):");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, -1, 20));

        jRadioButton1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jRadioButton1.setText("VIDEO CD (MP4)");
        jRadioButton1.setOpaque(false);
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, -1, -1));

        jRadioButton2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jRadioButton2.setText("VIDEO CD (VHS)");
        jRadioButton2.setOpaque(false);
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, -1, -1));

        jRadioButton3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jRadioButton3.setText("VIDEO DVD (MP4)");
        jRadioButton3.setOpaque(false);
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, -1, -1));

        jRadioButton4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jRadioButton4.setText("VIDEO DVD (VHS)");
        jRadioButton4.setOpaque(false);
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, -1, -1));

        jRadioButton5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jRadioButton5.setText("MUSIC CDs");
        jRadioButton5.setOpaque(false);
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, -1, -1));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 260, 140, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setText("PRIZE (IN RUPEES):");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, -1, -1));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 300, 140, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setText("DAILY RENTAL CHARGE(IN RUPEES):");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, -1, -1));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 350, 140, -1));

        button2.setBackground(new java.awt.Color(204, 0, 0));
        button2.setLabel("OK");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        jPanel1.add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, 70, 40));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/videostore/m2.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -6, 1000, 450));

        jTabbedPane1.addTab("ADD ITEM", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM TYPE", "DATE OF PROCUREMENT", "PRIZE", "DAILY RENTAL CHARGE", "AVAILABILTY"
            }
        ));
        jTable1.setOpaque(false);
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 730, 410));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/videostore/m2.jpg"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 450));

        jTabbedPane1.addTab("LIST OF ITEMS", jPanel2);

        jLabeldate.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N

        button1.setLabel("LOG OUT");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jLabel6.setText("DATE:");

        jButton1.setText("REFRESH");
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabeldate, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel6)))
                                .addGap(0, 11, Short.MAX_VALUE))
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabeldate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
      if(jRadioButton1.isSelected()){
       jRadioButton2.setSelected(false);
       jRadioButton3.setSelected(false);
       jRadioButton4.setSelected(false); 
       jRadioButton5.setSelected(false);
      }
       // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
      if(jRadioButton2.isSelected()){
       jRadioButton1.setSelected(false);
       jRadioButton3.setSelected(false);
       jRadioButton4.setSelected(false); 
       jRadioButton5.setSelected(false);
      }  // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
if(jRadioButton3.isSelected()){
       jRadioButton2.setSelected(false);
       jRadioButton1.setSelected(false);
       jRadioButton4.setSelected(false); 
       jRadioButton5.setSelected(false);
      }        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
if(jRadioButton4.isSelected()){
       jRadioButton2.setSelected(false);
       jRadioButton3.setSelected(false);
       jRadioButton1.setSelected(false); 
       jRadioButton5.setSelected(false);
      }        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
if(jRadioButton5.isSelected()){
       jRadioButton2.setSelected(false);
       jRadioButton3.setSelected(false);
       jRadioButton4.setSelected(false); 
       jRadioButton1.setSelected(false);
      }        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton5ActionPerformed
public static boolean isDateValid(String date) 
{
        try {
            DateFormat df = new SimpleDateFormat(pattern);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
}
    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
    String type="";
        if(jRadioButton1.isSelected())
        
        {
         type="MP4 CD";
         
        }
        if(jRadioButton2.isSelected())
        
        {
         type="VHS CD";
         
        }
        if(jRadioButton3.isSelected())
        
        {
         type="MP4 DVD";
         
        }
        if(jRadioButton4.isSelected())
        
        {
         type="VHS DVD";
         
        }
        if(jRadioButton5.isSelected())
        
        {
         type="MUSIC CD";
         
        }
        if(!jRadioButton1.isSelected() && !jRadioButton2.isSelected() && !jRadioButton3.isSelected() && !jRadioButton4.isSelected() && !jRadioButton5.isSelected())
        {
        JOptionPane.showMessageDialog(null,"enter the type of item");
        return;
        }     
         String date,prize,rental;
        date=jTextField1.getText();
        prize=jTextField2.getText();
        rental=jTextField3.getText();
         String regex="[0-9]+";
        double n;
        
        if(!prize.matches(regex) || !rental.matches(regex))
        {
        JOptionPane.showMessageDialog(null,"Enter correct details");
        return;
        }
        String datePattern = "\\d{1,2}-\\d{1,2}-\\d{4}";
        if(!date.matches(datePattern)){
        JOptionPane.showMessageDialog(null,"Enter date in correct format");
        return;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    try {
        Date d = formatter.parse(date);
       
        
        if(!d.before(dcurrent)){
         JOptionPane.showMessageDialog(null,"enter valid date");
         return;
        }
        boolean a=this.isDateValid(date);
        if(a==false)
        {
         JOptionPane.showMessageDialog(null,"enter valid date");
         return;
        }
    } catch (ParseException ex) {
        Logger.getLogger(ManagerView.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
		
        JOptionPane.showMessageDialog(null,"Item added");
        
      /* File f=new File(path + "/store.ser");
        if(!f.exists()){
        try {
            f.createNewFile();
            
        } catch (IOException ex) {
            Logger.getLogger(ManagerView.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        */
        /*
    try {
        FileWriter fw = new FileWriter(f,true);
        fw.write(date + "\n");
        fw.write(prize + "\n");
        fw.write(rental + "\n");
        fw.close();
      //add your handling code here:
    } catch (IOException ex) {
        Logger.getLogger(ManagerView.class.getName()).log(Level.SEVERE, null, ex);
    }
    int custcount=0;
    File f2 = new File(path + "/"+type+ "count.txt");
        if(!f2.exists())
        {
           try{ f2.createNewFile();
            FileWriter fw = new FileWriter(f2);
            fw.write("0\n");
            fw.close();
           }
           catch(Exception e){}
        }
         try{BufferedReader br = new BufferedReader(new FileReader(f2));
          custcount = Integer.parseInt(br.readLine());
          br.close();
         }
         catch(Exception e){}
          custcount++;
        String newText = String.valueOf(custcount); 
        //int newText=Custcount;
        try{FileWriter fw = new FileWriter(f2);
        fw.write(newText);
        fw.close();
        }
        catch(Exception e){}
    /*model=(DefaultTableModel)jTable1.getModel();
    String[] data=new String[5];
    data[0]=type;
    data[1]=date;
    data[2]=prize;
    data[3]=rental;
    data[4]="yes";
    model.insertRow(model.getRowCount(),data);
    */
     Store stor=new Store();
     stor.type=type;
     stor.date=date;
     stor.prize=prize;
     stor.rent=rental;
     stor.isavail="yes";
     s.add(stor);
   try{  
FileOutputStream fos = new FileOutputStream(path + "/store.ser");
ObjectOutputStream oos = new ObjectOutputStream(fos);
oos.writeObject(s);
oos.close();
  }
   catch(Exception e){
   JOptionPane.showMessageDialog(null,e);
   }
    }//GEN-LAST:event_button2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.setVisible(false);
       ManagerView m=new ManagerView();
       m.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
   this.setVisible(false);
   Home h=new Home();
   h.setVisible(true);
   this.dispose();
   // TODO add your handling code here:
    }//GEN-LAST:event_button1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabeldate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
