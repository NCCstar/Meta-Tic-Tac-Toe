import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
public class MetaBoard extends JPanel implements MouseListener
{
   public static Board master;
   /*
   8 1 2
   7 0 3
   6 5 4
   */
   public MetaBoard(int n)
   {
      layers=2;
   }
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      drawBoard(g);
   }
   public void drawBoard(Graphics g)
   {
      switch(layers)
      {
         case 2:
            
            break;
      }
   }
   public void mouseClicked(MouseEvent e)
   {
      
   }
   public void mouseDragged( MouseEvent e){}
   public void mouseExited( MouseEvent e ){}
   public void mousePressed( MouseEvent e ){}
   public void mouseReleased( MouseEvent e ){}
   public void mouseEntered( MouseEvent e ){}
   public void mouseMoved( MouseEvent e){}
}