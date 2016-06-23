import javax.swing.*;
public class MetaDriver
{
   public static void main(String[] arg)
   {
      MetaBoard board;
      final int SIZE=1100;
      int file=JOptionPane.showConfirmDialog(null,"Read from file?","File?",JOptionPane.YES_NO_OPTION);
      if(file==JOptionPane.YES_OPTION)
      {
         board = new MetaBoard(0,SIZE);
      }
      else
      {
         Object[] options = {"Regular","Meta-TTT","Meta^2","Meta^3"};//possible player numbers
         String sel = (String)JOptionPane.showInputDialog(null,"What type of Tic-Tac-Toe?","Choices",JOptionPane.INFORMATION_MESSAGE, null,options, options[0]);
         int layers=2;
         switch(sel)
         {
            case "Regular":
               layers=0;
               break;
            case "Meta-TTT":
               layers=1;
               break;
            case "Meta^2":
               layers=2;
               break;
            case "Meta^3":
               layers=3;
               break;
         }
         board = new MetaBoard(layers,SIZE);
      }
      JFrame frame = new JFrame("Meta-Tic-Tac-Toe");
      frame.setSize(SIZE+20,SIZE+50);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(board);
      frame.setVisible(true);
   }
}