import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
public class MetaBoard extends JPanel implements MouseListener
{
   public static Board master;
   public static int layers;
   public static int[] ref;
   public static final int DIM=30;
   boolean turn=true;
   public MetaBoard(int n)
   {
      addMouseListener(this);
      layers=n;
      master=new Board(layers);
      ref=new int[]{4,4};
   }
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      drawBoard(g);
      master.draw(g,0,0);
   }
   public void drawBoard(Graphics g)
   {
      switch(layers)
      {
         case 0:
            for(int i=DIM;i<DIM*3;i+=DIM)
            {
               g.fillRect(i,0,1,DIM*3);
               g.fillRect(0,i,DIM*3,1);
            }
            break;
         case 1:
            g.setColor(Color.blue.darker());
            for(int i=DIM;i<DIM*9;i+=DIM)
            {
               g.fillRect(i,0,1,DIM*9);
               g.fillRect(0,i,DIM*9,1);
            }
            g.setColor(Color.black);
            for(int i=DIM*3;i<DIM*9;i+=DIM*3)
            {
               g.fillRect(i,0,2,DIM*9);
               g.fillRect(0,i,DIM*9,2);
            }
            break;
         case 2:
            g.setColor(Color.lightGray);
            int y=0;
            int x=0;
            if(ref[0]<3)
            {
               x+=ref[0]*9*DIM;
            }
            else
               if(ref[0]<6)
               {
                  y+=9*DIM;
                  x+=(ref[0]-3)*9*DIM;
               }
               else
               {
                  y+=DIM*18;
                  x+=(ref[0]-6)*9*DIM;
               }
            if(ref[1]<3)
            {
               x+=ref[1]*DIM*3;
            }
            else
               if(ref[1]<6)
               {
                  y+=DIM*3;
                  x+=(ref[1]-3)*3*DIM;
               }
               else
               {
                  y+=DIM*6;
                  x+=(ref[1]-6)*3*DIM;
               }
            g.fillRect(x,y,DIM*3,DIM*3);
            g.setColor(Color.green.darker());
            for(int i=DIM;i<DIM*27;i+=DIM)
            {
               g.fillRect(i,0,1,DIM*27);
               g.fillRect(0,i,DIM*27,1);
            }
            g.setColor(Color.blue.darker());
            for(int i=DIM*3;i<DIM*27;i+=DIM*3)
            {
               g.fillRect(i,0,2,DIM*27);
               g.fillRect(0,i,DIM*27,2);
            }
            g.setColor(Color.black);
            for(int i=DIM*9;i<DIM*27;i+=DIM*9)
            {
               g.fillRect(i,0,3,DIM*27);
               g.fillRect(0,i,DIM*27,3);
            }
            break;
      }
   }
   public void mouseClicked(MouseEvent e)
   {
      int x=e.getX()/DIM;
      int y=e.getY()/DIM;
      switch(layers)
      {
         case 1:
            
         case 2:
            int[] path=new int[3];
            path[0]=(y/9)*3+(x/9);
            if(path[0]<3)
            {
               x-=path[0]*9;
            }
            else
               if(path[0]<6)
               {
                  x-=(path[0]-3)*9;
                  y-=9;
               }
               else
               {
                  x-=(path[0]-6)*9;
                  y-=18;
               }
            path[1]=(y/3)*3+(x/3);
            if(path[1]<3)
            {
               x-=path[1]*3;
            }
            else
               if(path[1]<6)
               {
                  x-=(path[1]-3)*3;
                  y-=3;
               }
               else
               {
                  x-=(path[1]-6)*3;
                  y-=6;
               }
            path[2]=y*3+x;
            if(path[0]==ref[0]&&path[1]==ref[1])
            {
               master.set(path,turn);
               turn=!turn;
               ref[0]=path[1];
               ref[1]=path[2];
            }
            break;
      }
      repaint();
   }
   public void mouseDragged( MouseEvent e){}
   public void mouseExited( MouseEvent e ){}
   public void mousePressed( MouseEvent e ){}
   public void mouseReleased( MouseEvent e ){}
   public void mouseEntered( MouseEvent e ){}
   public void mouseMoved( MouseEvent e){}
}