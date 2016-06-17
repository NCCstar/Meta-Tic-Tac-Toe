import javax.swing.*;
public class MetaDriver
{
   public static void main(String[] arg)
   {
      /*
      Object[] options = {"Regular","Meta-TTT","Meta^2"};//possible player numbers
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
      }
      */
      MetaBoard board = new MetaBoard(0);
      JFrame frame = new JFrame("Meta-Tic-Tac-Toe");
      frame.setSize(1000,1000);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(board);
      frame.setVisible(true);
   }
}