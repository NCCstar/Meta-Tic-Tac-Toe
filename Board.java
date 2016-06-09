import java.awt.*;
public class Board
{
   private Object[] values;
   
   /*
   0 1 2
   3 4 5
   6 7 8   
   */
   public Board(int layer)
   {
      if(layer==0)
      {
         values = new Integer[9];
         for(int i=0;i<values.length;i++)
         {
            values[i] = new Integer(0);
         }
      }
      else
      {
         values = new Board[9];
         for(int i=0;i<values.length;i++)
         {
            values[i] = new Board(layer-1);
         }
      }
   }
   public Integer get(int[] path)
   {
      if(values instanceof Integer[])
      {
         return (Integer)values[path[0]];
      }
      int index=path[0];
      int[] newPath = new int[path.length-1];
      for(int i=0;i<newPath.length;i++)
      {
         newPath[i]=path[i+1];
      }
      return ((Board)(values[index])).get(newPath);
   }
   public void set(int[] path,boolean isX)
   {
      if(values instanceof Integer[])
      {
         if((Integer)(values[path[0]])==0)
         {
            if(isX)//X=1, O=-1
               values[path[0]]=1;
            else
               values[path[0]]=-1;
         }
         return;
      }
      int index=path[0];
      int[] newPath = new int[path.length-1];
      for(int i=0;i<newPath.length;i++)
      {
         newPath[i]=path[i+1];
      }
      ((Board)(values[index])).set(newPath,isX);
   }
   public void draw(Graphics g,int y,int x)
   {
      int yCo=y;
      int xCo=x;
      if(values instanceof Integer[])
      {
         for(int i=0;i<values.length;i++)
         {
            if(i<3)
            {
               x+=i*MetaBoard.DIM;
            }
            else
               if(i<6)
               {
                  y+=MetaBoard.DIM;
                  x+=(i-3)*MetaBoard.DIM;
               }
               else
               {
                  y+=MetaBoard.DIM*2;
                  x+=(i-6)*MetaBoard.DIM;
               }
            if((Integer)values[i]==1)
            {
               g.drawLine(x,y,x+MetaBoard.DIM,y+MetaBoard.DIM);
               g.drawLine(x,y+MetaBoard.DIM,x+MetaBoard.DIM,y);
            }
            if((Integer)values[i]==-1)
            {
               g.drawOval(x,y,MetaBoard.DIM,MetaBoard.DIM);
            }
            y=yCo;
            x=xCo;
         }
      }
      else
      {
         for(int i=0;i<values.length;i++)
         {
            if(i<3)
            {
               ((Board)values[i]).draw(g,y,x+i*MetaBoard.DIM);
            }
            else
               if(i<6)
               {
                  ((Board)values[i]).draw(g,y+(i-3)*MetaBoard.DIM,x+(i-3)*MetaBoard.DIM);
               }
               else
               {
                  ((Board)values[i]).draw(g,y+(i-6)*MetaBoard.DIM,x+(i-6)*MetaBoard.DIM);
               }
         }
      }
   }
}