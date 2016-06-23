import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
public class MetaBoard extends JPanel implements MouseListener
{
   private static Board master;
   private static int layers;
   private static int[] ref;
   public static int DIM;
   private boolean isPath=true;
   boolean turn=true;
   public MetaBoard(int n,int s)
   {
      DIM=(int)(s/Math.pow(3,n+1));
      addMouseListener(this);
      layers=n;
      master=new Board(layers);
      ref=new int[n];
      for(int i=0;i<ref.length;i++)
      {
         ref[i]=-1;
      }
   }
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      drawBoard(g);
      g.setColor(Color.black);
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
            g.setColor(Color.lightGray);
            int y=0;
            int x=0;
            if(ref[0]==-1)
            {
               g.fillRect(x,y,DIM*9,DIM*9);
            }
            else
            {
               if(ref[0]<3)
               {
                  x+=ref[0]*DIM*3;
               }
               else
                  if(ref[0]<6)
                  {
                     y+=DIM*3;
                     x+=(ref[0]-3)*3*DIM;
                  }
                  else
                  {
                     y+=DIM*6;
                     x+=(ref[0]-6)*3*DIM;
                  }
               g.fillRect(x,y,DIM*3,DIM*3);
            }
            g.setColor(Color.blue);
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
            if(isPath)
               g.setColor(Color.green);
            else
               g.setColor(Color.blue);
            g.fillRect((int)(DIM*9),0,DIM*2,DIM*2);
            g.setColor(Color.black);
            if(turn)
            {
               g.drawLine(DIM*9,0,DIM*11,DIM*2);
               g.drawLine(DIM*9,DIM*2,DIM*11,0);
            }
            else
            {
               g.drawOval(DIM*9,0,DIM*2,DIM*2);
            }
            String temp="[";
            for(int i=0;i<ref.length;i++)
            {
               temp+=ref[i];
               if(i<ref.length-1)
               {
                  temp+=",";
               }
            }
            temp+="]";
            g.drawString(temp,0,DIM*10);
            break;
         case 2:
            g.setColor(Color.lightGray);
            y=0;
            x=0;
            if(ref[0]==-1)
            {
               g.fillRect(x,y,DIM*27,DIM*27);
            }
            else
            {
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
               if(ref[1]==-1)
               {
                  g.fillRect(x,y,DIM*9,DIM*9);
               }
               else
               {
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
               }
            }
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
            if(isPath)
               g.setColor(Color.green);
            else
               g.setColor(Color.blue);
            g.fillRect((int)(DIM*27.1),0,DIM*2,DIM*2);
            g.setColor(Color.black);
            temp="[";
            for(int i=0;i<ref.length;i++)
            {
               temp+=ref[i];
               if(i<ref.length-1)
               {
                  temp+=",";
               }
            }
            temp+="]";
            g.drawString(temp,0,DIM*28);
            break;
         case 3:
            g.setColor(Color.lightGray);
            y=0;
            x=0;
            if(ref[0]==-1)
            {
               g.fillRect(x,y,DIM*81,DIM*81);
            }
            else
            {
               if(ref[0]<3)
               {
                  x+=ref[0]*27*DIM;
               }
               else
                  if(ref[0]<6)
                  {
                     y+=27*DIM;
                     x+=(ref[0]-3)*27*DIM;
                  }
                  else
                  {
                     y+=DIM*54;
                     x+=(ref[0]-6)*27*DIM;
                  }
               if(ref[1]==-1)
               {
                  g.fillRect(x,y,DIM*27,DIM*27);
               }
               else
               {
                  if(ref[1]<3)
                  {
                     x+=ref[1]*DIM*9;
                  }
                  else
                     if(ref[1]<6)
                     {
                        y+=DIM*9;
                        x+=(ref[1]-3)*9*DIM;
                     }
                     else
                     {
                        y+=DIM*18;
                        x+=(ref[1]-6)*9*DIM;
                     }
                  g.fillRect(x,y,DIM*9,DIM*9);
               }
            }
            g.setColor(Color.pink.darker());
            for(int i=DIM;i<DIM*81;i+=DIM)
            {
               g.fillRect(i,0,1,DIM*81);
               g.fillRect(0,i,DIM*81,1);
            }
            g.setColor(Color.green.darker());
            for(int i=DIM*3;i<DIM*81;i+=DIM*3)
            {
               g.fillRect(i,0,1,DIM*81);
               g.fillRect(0,i,DIM*81,1);
            }
            g.setColor(Color.blue.darker());
            for(int i=DIM*9;i<DIM*81;i+=DIM*9)
            {
               g.fillRect(i,0,2,DIM*81);
               g.fillRect(0,i,DIM*81,2);
            }
            g.setColor(Color.black);
            for(int i=DIM*27;i<DIM*81;i+=DIM*27)
            {
               g.fillRect(i,0,3,DIM*81);
               g.fillRect(0,i,DIM*81,3);
            }
            if(isPath)
               g.setColor(Color.green);
            else
               g.setColor(Color.blue);
            g.fillRect((int)(DIM*81.1),0,DIM*2,DIM*2);
            g.setColor(Color.black);
            temp="[";
            for(int i=0;i<ref.length;i++)
            {
               temp+=ref[i];
               if(i<ref.length-1)
               {
                  temp+=",";
               }
            }
            temp+="]";
            g.drawString(temp,0,DIM*82);
            break;
      }
   }
   public void mouseClicked(MouseEvent e)
   {
      int x=e.getX()/DIM;
      int y=e.getY()/DIM;
      int[] path;
      switch(layers)
      {
         case 0:
            path = new int[1];
            path[0]=y*3+x;
            if(master.set(path,turn))
               turn=!turn;  
            break;    
         case 1:
            if(x>9&&x<11&&y<2)
            {
               isPath=!isPath;
               break;
            }
            path=new int[2];
            path[0]=(y/3)*3+(x/3);
            if(path[0]<3)
            {
               x-=path[0]*3;
            }
            else
               if(path[0]<6)
               {
                  x-=(path[0]-3)*3;
                  y-=3;
               }
               else
               {
                  x-=(path[0]-6)*3;
                  y-=6;
               }
            path[1]=y*3+x;
            if(path[0]==ref[0]||ref[0]==-1||!isPath)
            {
               if(master.set(path,turn))
               {
                  turn=!turn;
                  if(((Board)(master.get(new int[]{path[1]}))).getSolve()!=0)
                  {
                     ref[0]=-1;
                  }
                  else
                     ref[0]=path[1];
               }
            }
            break;
         case 2:
            if(x>27&&x<29&&y<2)
            {
               isPath=!isPath;
               break;
            }
            path=new int[3];
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
            if((path[0]==ref[0]&&path[1]==ref[1])||ref[0]==-1||(path[0]==ref[0]&&ref[1]==-1)||!isPath)//normal move
            {
               if(master.set(path,turn))
               {
                  turn=!turn;
                  if(((Board)(master.get(new int[]{path[1]}))).getSolve()!=0)
                  {
                     ref[0]=-1;
                  }
                  else
                     ref[0]=path[1];
                  if(((Board)(master.get(new int[]{path[1],path[2]}))).getSolve()!=0)
                  {
                     ref[1]=-1;
                  }
                  else
                     ref[1]=path[2];
               }
            }
            break;
         case 3:
            if(x>81&&x<83&&y<2)
            {
               isPath=!isPath;
               break;
            }
            path=new int[4];
            path[0]=(y/27)*3+(x/27);
            if(path[0]<3)
            {
               x-=path[0]*27;
            }
            else
               if(path[0]<6)
               {
                  x-=(path[0]-3)*27;
                  y-=27;
               }
               else
               {
                  x-=(path[0]-6)*27;
                  y-=54;
               }
            path[1]=(y/9)*3+(x/9);
            if(path[1]<3)
            {
               x-=path[1]*9;
            }
            else
               if(path[1]<6)
               {
                  x-=(path[1]-3)*9;
                  y-=9;
               }
               else
               {
                  x-=(path[1]-6)*9;
                  y-=18;
               }
            path[2]=(y/3)*3+(x/3);
            if(path[2]<3)
            {
               x-=path[2]*3;
            }
            else
               if(path[2]<6)
               {
                  x-=(path[2]-3)*3;
                  y-=3;
               }
               else
               {
                  x-=(path[2]-6)*3;
                  y-=6;
               }
            path[3]=y*3+x;
            if((path[0]==ref[0]&&path[1]==ref[1]&&path[2]==ref[2])||ref[0]==-1||(path[0]==ref[0]&&ref[1]==-1)||(path[0]==ref[0]&&ref[1]==path[1]&&ref[2]==-1)||!isPath)//normal move
            {
               if(master.set(path,turn))
               {
                  turn=!turn;
                  if(((Board)(master.get(new int[]{path[1]}))).getSolve()!=0)
                  {
                     ref[0]=-1;
                  }
                  else
                     ref[0]=path[1];
                  if(((Board)(master.get(new int[]{path[1],path[2]}))).getSolve()!=0)
                  {
                     ref[1]=-1;
                  }
                  else
                     ref[1]=path[2];
                  if(((Board)(master.get(new int[]{path[1],path[2],path[3]}))).getSolve()!=0)
                  {
                     ref[2]=-1;
                  }
                  else
                     ref[2]=path[3];
               }
            }
         
            break;
      }
      master.checkSolved();
      if(master.getSolve()==1)
      {
         
      }
      else
         if(master.getSolve()==-1)
         {
         
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