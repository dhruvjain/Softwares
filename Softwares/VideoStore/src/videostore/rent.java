/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package videostore;

/**
 *
 * @author DHRUV
 */
public class rent extends javax.swing.JFrame {

    /**
     * Creates new form rent
     */
    public rent(String custno,CustPurchase item1,CustPurchase item2) {
        
        initComponents();
        jTextField1.setText(custno);
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
        jTextField2.setVisible(false);
        jTextField3.setVisible(false);
        
      
         if(!item1.type.equals("")){
        jLabelitem1.setText(item1.type);
        jTextField2.setText(item1.rent);
        jTextField2.setVisible(true);
         jLabel5.setVisible(true);       ;
        
        }
           if(!item2.type.equals("")){
        jLabelitem2.setText(item2.type);
        jTextField3.setText(item2.rent);
        jTextField3.setVisible(true);
         jLabel6.setVisible(true);       ;
        
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelitem1 = new javax.swing.JLabel();
        jLabelitem2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        button1 = new java.awt.Button();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jLabel3.setText("CUSTOMER'S NUMBER:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jTextField1.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 140, -1));

        jLabel4.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jLabel4.setText("RENTAL CHARGE FOR :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 190, -1));

        jLabel5.setText("1.");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jLabel6.setText("2.");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jLabelitem1.setBackground(new java.awt.Color(204, 204, 204));
        jLabelitem1.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jLabelitem1.setOpaque(true);
        jPanel1.add(jLabelitem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 80, 20));

        jLabelitem2.setBackground(new java.awt.Color(204, 204, 204));
        jLabelitem2.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jLabelitem2.setOpaque(true);
        jPanel1.add(jLabelitem2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 80, 20));

        jTextField2.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 70, -1));

        jTextField3.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 70, -1));

        button1.setLabel("CLOSE");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        jPanel1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/videostore/amount.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_button1ActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelitem1;
    private javax.swing.JLabel jLabelitem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}