/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mcte;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author DHRUV
 */
public class Barchart extends JComponent{
   int x,y,width,height;
   public Barchart(int i,int j,int wd,int ht)
   {
    x=i;
    j=wd;
    width=wd;
    height=ht;
   }
  public void paint(Graphics g)
  {
      g.setColor(Color.red);
  g.fillRect(x, y, width, height);
  
  }
}
