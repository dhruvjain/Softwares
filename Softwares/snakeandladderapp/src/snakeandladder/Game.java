/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeandladder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
/**
 *
 * @author DHRUV
 */

public class Game extends javax.swing.JFrame {
   
    static String nplayers,size,nsnakes,nladders,p1,p2,p3;
    
    
    ImageIcon image = new ImageIcon("C:\\Users\\DHRUV\\Documents\\NetBeansProjects\\snakeandladder\\snake.jpg");
    ImageIcon image2 = new ImageIcon("C:\\Users\\DHRUV\\Documents\\NetBeansProjects\\snakeandladder\\ladder3.jpg");
    ImageIcon ladder2=new ImageIcon("C:\\Users\\DHRUV\\Documents\\NetBeansProjects\\snakeandladder\\ladder2.jpg");
    ImageIcon dice1 = new ImageIcon("C:\\Users\\DHRUV\\Documents\\NetBeansProjects\\snakeandladder\\dice.jpg");
    ImageIcon play = new ImageIcon("C:\\Users\\DHRUV\\Documents\\NetBeansProjects\\snakeandladder\\playgame.jpg");
    ImageIcon restart = new ImageIcon("C:\\Users\\DHRUV\\Documents\\NetBeansProjects\\snakeandladder\\restart.jpg");
    ImageIcon newgame = new ImageIcon("C:\\Users\\DHRUV\\Documents\\NetBeansProjects\\snakeandladder\\newgame.jpg");
    ImageIcon exitgame=new ImageIcon("C:\\Users\\DHRUV\\Documents\\NetBeansProjects\\snakeandladder\\exitgame.jpg");
    static boolean isconfi;
    private String[] args;
    public Game(){
        initComponents();
    }
    JLayeredPane jLayeredPane1 = new javax.swing.JLayeredPane();
    JLayeredPane jLayeredPane2 = new JLayeredPane();
    JTextField jTextField1 = new JTextField(50);
    JTextField jTextField2 = new JTextField(30);
    JTextField jTextField3 = new JTextField(30);
    JLabel label1=new JLabel();
    JLabel label2=new JLabel("PLAYER 1");
    JLabel label3=new JLabel("ROLL DICE");
    JLabel congrats=new JLabel();
        
    JButton dice = new JButton();
    JLabel[] box = new JLabel[Integer.parseInt(size) *Integer.parseInt(size)];
    Snakes[] snak=new Snakes[Integer.parseInt(nsnakes)];
    Ladder[] lad=new Ladder[Integer.parseInt(nladders)];
    int clickcount=0,player1moves,player2moves,player3moves;
    int player1pos=0,player2pos=0,player3pos=0;
    public void initComponents() {
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
          
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        jLayeredPane2.setBounds(0, 0,1000,600);
       
        int n = Integer.parseInt(size);
        for(int i=n;i>0;i--)
        {        
            if((i+1)%2 == 0)
                {
                    for(int j=n;j>0;j--)
                    {
                        
                        
                            
                        box[(i*n)-j] = new JLabel(String.valueOf(i*n-j+1));
                       
                        box[(i*n)-j].setForeground(Color.white);
                        box[(i*n)-j].setFont(new Font("Tahoma Bold", 1, 20));
                        
                        box[(i*n)-j].setOpaque(true);
                        box[(i*n)-j].setBackground(Color.gray);
                        
                        Border border = BorderFactory.createLineBorder(Color.BLACK);
                        box[(i*n)-j].setBorder(border);
                        box[(i*n)-j].setBounds((((n-j)*600)/n), (((n-i)*600)/n), 600/n, 600/n);
                        jLayeredPane1.add(box[(i*n)-j]);
                        
                    }
                }
            else
                
            {
                for(int j=0;j<n;j++)
                    {
                        
                        box[((n*i)-j)-1] = new JLabel(""+((n*i)-j));
                       
                        box[((n*i)-j)-1].setOpaque(true);
                        box[((n*i)-j)-1].setForeground(Color.white);
                        box[((n*i)-j)-1].setFont(new Font("Tahoma Bold", 1, 20));
                        box[((n*i)-j)-1].setBackground(Color.gray);
                        Border border = BorderFactory.createLineBorder(Color.BLACK);
                        box[((i*n)-j)-1].setBorder(border);
                        box[((n*i)-j)-1].setBounds(((j*600)/n), (((n-i)*600)/n), 600/n, 600/n);
                        jLayeredPane1.add(box[((n*i)-j)-1]);
                        
                    }            
            }
        }
        if(!isconfi){
            int head,tail,top,bottom;
            
        for(int i=0;i<Integer.parseInt(nsnakes);i++){
          snak[i]=new Snakes();
          
          head=(int)(2*n + (Math.random() * (n*n - 2*n)));
          tail=(int)(1 + (Math.random() * ((head-10) - 1)));
          
          box[head-1].setIcon(image);
          
          snak[i].head=head;
          snak[i].tail=tail;
          
        }
        for(int i=0;i<Integer.parseInt(nladders);i++){
          lad[i]=new Ladder();
            top=(int)(2*n + (Math.random() * (n*n - 2*n))+1);
          bottom=(int)(1 + (Math.random() * ((top-10) - 1)));
          
           box[bottom-1].setIcon(image2);
           box[top-1].setIcon(ladder2);
           
          lad[i].top=top;
          lad[i].bottom=bottom;
                    
          
        }
        }
        if(isconfi)
        {
           
         
         jTextField1.setBounds(700,100,150,30);
         jTextField1.setText("Enter snake 1 head");
         jTextField1.setEditable(false);
         
         
         label1.setBounds(700, 140,100 ,30);
         label1.setText("YOU Clicked on");
     
        jTextField2.setBounds(820, 140, 50, 30);
        jTextField2.setEditable(false);
        jLayeredPane2.add(label1);
        jLayeredPane2.add(jTextField2);
        jLayeredPane2.add(jTextField1);
        for(int i=0;i<n*n;i++)
        {
           box[i].addMouseListener(new Mouseclickforsandl());
        }
        }
        
        
        label2.setBounds(740, 180, 180, 50);
        label2.setFont(new Font("Helvetica", Font.BOLD, 18));
      
        label2.setForeground(Color.red);
        jLayeredPane2.add(label2);
        
        label3.setBounds(700, 250, 180, 50);
        label3.setFont(new Font("Helvetica", Font.BOLD, 18));
        congrats.setBounds(640,120,380, 50);
        congrats.setFont(new Font("Helvetica", Font.BOLD, 16));
      
        congrats.setForeground(Color.red);
        jLayeredPane2.add(congrats);    
        label3.setForeground(Color.blue);
        jLayeredPane2.add(label3);
        jTextField3.setBounds(800,250,50,50);
         jTextField3.setText("");
         jTextField3.setEditable(false);
         
         jLayeredPane2.add(jTextField3);
        
        dice.setIcon(dice1);
        dice.setBounds(700, 300, 100, 100);
        jLayeredPane1.add(dice);
        label2.setVisible(false);
        label3.setVisible(false);
        dice.setVisible(false);
        jTextField3.setVisible(false);
        dice.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    diceButtonActionPerformed(evt);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        JButton startbutton = new JButton();
        startbutton.setIcon(play);
        startbutton.setBounds(900, 450, 80, 80);
        jLayeredPane2.add(startbutton);
        startbutton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
         JButton restartbutton = new JButton();
        restartbutton.setIcon(restart);
        restartbutton.setBounds(800, 450, 80, 80);
        jLayeredPane2.add(restartbutton);
        restartbutton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartButtonActionPerformed(evt);
            }
        });
        JButton newgamebutton = new JButton();
        newgamebutton.setIcon(newgame);
        newgamebutton.setBounds(700, 450, 80, 80);
        jLayeredPane2.add(newgamebutton);
        newgamebutton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newgameButtonActionPerformed(evt);
            }
        });
        JButton exitbutton = new JButton();
        exitbutton.setIcon(exitgame);
        exitbutton.setBounds(900, 30, 80, 80);
        jLayeredPane2.add(exitbutton);
        exitbutton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitgameButtonActionPerformed(evt);
            }
        });
        

        
        jLayeredPane2.setVisible(true);
        jLayeredPane1.add(jLayeredPane2);
        
        
        pack();
    
    }
  public class Mouseclickforsandl extends MouseAdapter{
      @Override
        public void mouseClicked(MouseEvent evt){
                int index;
                clickcount++; 
                
                JLabel label = new JLabel();
                label = (JLabel) (evt.getSource());
                
                String s1 = label.getText();
                
                
                jTextField2.setText(s1);
                if(clickcount<2*Integer.parseInt(nsnakes)){
                   if((clickcount%2)!=0)
                   {
                   jTextField1.setText("Enter snake "+((clickcount+1)/2)+ " tail");
                   snak[(clickcount+1)/2-1]=new Snakes();
                   snak[(clickcount+1)/2-1].head=Integer.parseInt(s1);
                   box[Integer.parseInt(s1)-1].setIcon(image);
                   }
                   else
                   {
                       jTextField1.setText("Enter snake "+((clickcount)/2+1)+ " head");
                       snak[(clickcount)/2-1].tail=Integer.parseInt(s1);
                   
                   }
                }
                else if(clickcount==2*Integer.parseInt(nsnakes)){
                 jTextField1.setText("Enter ladder 1 top");
                snak[(clickcount)/2-1].tail=Integer.parseInt(s1);
                }
                if(clickcount>2*Integer.parseInt(nsnakes) && clickcount<(2*Integer.parseInt(nsnakes)+2*Integer.parseInt(nladders))){
                         if((clickcount%2)!=0)
                   {
                       index=(clickcount-2*Integer.parseInt(nsnakes)+1)/2-1;
                   jTextField1.setText("Enter ladder "+(index+1)+ " bottom");
                   
                   lad[(clickcount-2*Integer.parseInt(nsnakes)+1)/2-1]=new Ladder();
                   lad[(clickcount-2*Integer.parseInt(nsnakes)+1)/2-1].top=Integer.parseInt(s1);
                    box[Integer.parseInt(s1)-1].setIcon(ladder2);
                   }
                 else{
                 index=(clickcount-2*Integer.parseInt(nsnakes))/2-1;
                 jTextField1.setText("Enter ladder "+(index+1)+ " top");
                 
                 lad[(clickcount-2*Integer.parseInt(nsnakes))/2-1].bottom=Integer.parseInt(s1);
                 
                 box[Integer.parseInt(s1)-1].setIcon(image2);
                 }
                }
                if(clickcount==2*(Integer.parseInt(nsnakes)+Integer.parseInt(nladders))){
                lad[(clickcount-2*Integer.parseInt(nsnakes))/2-1].bottom=Integer.parseInt(s1);
                box[Integer.parseInt(s1)-1].setIcon(image2);
                    jTextField1.setText("Done!! Now you can play");
                jTextField2.setText("");
                }
         
    }
    }
  private void startButtonActionPerformed(ActionEvent evt) {
         label2.setVisible(true);
        label3.setVisible(true);
        dice.setVisible(true);
        jTextField1.setVisible(false);
        jTextField2.setVisible(false);
        label1.setVisible(false);
        jTextField3.setVisible(true);
    }
  private void newgameButtonActionPerformed(ActionEvent evt){
   this.setVisible(false);
   Home h=new Home();
   h.setVisible(true);
   this.dispose();
  
  }
  private void restartButtonActionPerformed(ActionEvent evt){
   if(player1pos!=0){
   box[player1pos-1].setBackground(Color.GRAY);
   box[player2pos-1].setBackground(Color.GRAY);
   
   }if(player3pos!=0)
   {
   box[player3pos-1].setBackground(Color.GRAY);
   }
   player1pos=0;player2pos=0;player3pos=0;
   player1moves=0;player2moves=0;player3moves=0;
   label2.setText("PLAYER 1");
   label2.setForeground(Color.red);
   jTextField3.setText("");
   congrats.setText("");
   
   
  
  }
  private void diceButtonActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException{
      String playerno="";
      
      
      int n,k;
      if(label2.getText().equals("PLAYER 1")){
       playerno="1";
       if(player1pos!=0 &&player1pos<Integer.parseInt(size)*Integer.parseInt(size))
       {
       box[player1pos-1].setBackground(Color.gray);
       }
       n=(int)(1 + (Math.random() * (6)));
       player1moves++;
       player1pos+=n;
       k=isSnake(player1pos);
       if(k<player1pos)
           JOptionPane.showMessageDialog(null, "Snake at postion "+player1pos+" got player 1 to position "+k);
       player1pos=k;
       
       k=isLadder(player1pos);
       if(k>player1pos)
       JOptionPane.showMessageDialog(null, "Player 1 is up through the ladder at position "+k);
       
       player1pos=k;
       
       if(player1pos==Integer.parseInt(size)*Integer.parseInt(size))
       {
         box[player1pos-1].setBackground(Color.red);  
        JOptionPane.showMessageDialog(null,"Congo Player 1 wins in "+player1moves+" moves");
        Player.addscore(p1,player1moves);
        congrats.setText("CONGRATULATIONS!!! PALYER 1 WINS");
        congrats.setForeground(Color.red);
        return;
       }
       if(player1pos>Integer.parseInt(size)*Integer.parseInt(size))
       {
        player1pos=player1pos-n;
       }
       if(player1pos>0){
       box[player1pos-1].setBackground(Color.red);
       }
       jTextField3.setText(String.valueOf(n));
       if(n==6){
           JOptionPane.showMessageDialog(null, "Player 1 got 6 1 more chance");
           return;
       } 
       label2.setText("PLAYER 2");
       label2.setForeground(Color.blue);
       return;
       //JOptionPane.showMessageDialog(null,label2.getText());
       
     }
      if(label2.getText().equals("PLAYER 2")){
       playerno="2";
       if(player2pos!=0 &&player2pos<Integer.parseInt(size)*Integer.parseInt(size)){
       box[player2pos-1].setBackground(Color.gray);
       }
       n=(int)(1 + (Math.random() * (6)));
       player2moves++;
       player2pos+=n;
       k=isSnake(player2pos);
       if(k<player2pos)
           JOptionPane.showMessageDialog(null, "Snake at postion "+player2pos+" got player2");
        player2pos=k;
       
       k=isLadder(player2pos);
       if(k>player2pos)
       JOptionPane.showMessageDialog(null, "Player 2 is up through the ladder at position "+k);
       player2pos=k;
       
       if(player2pos==Integer.parseInt(size)*Integer.parseInt(size))
       {box[player2pos-1].setBackground(Color.blue);
        JOptionPane.showMessageDialog(null,"Player 2 wins in "+player2moves+" moves");
        congrats.setText("CONGRATULATIONS!!! PALYER 2 WINS");
        Player.addscore(p2,player2moves);
        congrats.setForeground(Color.blue);
        return;
       }
       if(player2pos>Integer.parseInt(size)*Integer.parseInt(size))
       {
        player2pos=player2pos-n;
       }
       if(player2pos>0){
       box[player2pos-1].setBackground(Color.blue);
      
       }jTextField3.setText(String.valueOf(n));
       
       if(Integer.parseInt(nplayers)==3)
       {if(n==6){
           JOptionPane.showMessageDialog(null, "Player 2 got 6 1 more chance");
           return;
       }
          label2.setText("PLAYER 3");
       label2.setForeground(Color.yellow);
       }
       else
       {if(n==6){
           JOptionPane.showMessageDialog(null, "Player 2 got 6 1 more chance");
           return;
       }    
        label2.setText("PLAYER 1");
         label2.setForeground(Color.red);
       }
       return;
     }
      if(label2.getText().equals("PLAYER 3")){
          playerno="3";
          if(player3pos!=0 && player3pos<Integer.parseInt(size)*Integer.parseInt(size)){
          box[player3pos-1].setBackground(Color.gray);
          
          }
          n=(int)(1 + (Math.random() * (6)));
       player3moves++;
       player3pos+=n;
       k=isSnake(player3pos);
        if(k<player3pos)
           JOptionPane.showMessageDialog(null, "Snake at postion "+player3pos+"got player 3");
        player3pos=k;
       
       k=isLadder(player3pos);
       if(k>player3pos)
       JOptionPane.showMessageDialog(null, "Player 3 is up through the ladder at position"+k);
                    
       player3pos=k;
       
       if(player3pos==Integer.parseInt(size)*Integer.parseInt(size))
       {box[player3pos-1].setBackground(Color.yellow);
        JOptionPane.showMessageDialog(null,"Player 3 wins in "+player3moves+ "moves");
        congrats.setText("CONGRATULATIONS!!! PALYER 3 WINS");
         Player.addscore(p3,player3moves);
        congrats.setForeground(Color.YELLOW);
        return;
       }
       if(player3pos>Integer.parseInt(size)*Integer.parseInt(size))
       {
        player3pos=player3pos-n;
       }
       if(player3pos>0){
       box[player3pos-1].setBackground(Color.yellow);
       
       }jTextField3.setText(String.valueOf(n));
       if(n==6){
           JOptionPane.showMessageDialog(null, "Player 3 got 6 1 more chance");
           return;
       }
       label2.setText("PLAYER 1");
       label2.setForeground(Color.red);
       return;
     }
         
    
    }
  private void exitgameButtonActionPerformed(ActionEvent evt) {
    this.dispose();
  
  }
  public int isSnake(int head){
    int i;
    for(i=0;i<Integer.parseInt(nsnakes);i++){
     if(snak[i].head==head)
         return snak[i].tail;
     
            
    }
  return head;
  }
   public int isLadder(int bottom){
    int i;
    for(i=0;i<Integer.parseInt(nladders);i++){
     if(lad[i].bottom==bottom)
         return lad[i].top;
     
            
    }
  return bottom;
  } 
    public static void main(String players,String boardsize,String snakes,String ladders,boolean isconf,String player1,String player2,String player3){
       nplayers=players;
       size=boardsize;
       nsnakes=snakes;
       nladders=ladders;
       isconfi=isconf;
       p1=player1;
       p2=player2;
       p3=player3;
       
       java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Game().setVisible(true);
            }
        });
    
    }
     
    
}
 
