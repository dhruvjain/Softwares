package snakeandladder;
import javax.swing.JApplet;
import javax.swing.JOptionPane;

public class Web extends JApplet  {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void init()
    {
        // TODO start asynchronous download of heavy resources
        String nplayers=JOptionPane.showInputDialog("enter the no. of players (maximum 3)");
        String size=JOptionPane.showInputDialog("enter the boards size(betwwen 5 and 12)");
            String nsnakes=JOptionPane.showInputDialog("enter no. of snakes");
        String nladders=JOptionPane.showInputDialog("enter no. of sladders");
        String player1="",player2="",player3="";
        if(Integer.parseInt(nplayers)==2){
            player1=JOptionPane.showInputDialog("enter name of player 1");
            player2=JOptionPane.showInputDialog("enter name of player 2");
        }
         if(Integer.parseInt(nplayers)==3){
            player1=JOptionPane.showInputDialog("enter name of player 1");
            player2=JOptionPane.showInputDialog("enter name of player 2");
           player3=JOptionPane.showInputDialog("enter name of player 3");
        }   
         boolean isconfi;
        String isconf=JOptionPane.showInputDialog("Do you want to configure(enter yes or no)");
        if(isconf.equals("yes"))
        {
            isconfi=true;
            
        }
        else
            isconfi=false;
        Game.main(nplayers,size,nsnakes,nladders, isconfi, player1, player2, player3);
        //this.setContentPane(ar.getContentPane());
        
    }}