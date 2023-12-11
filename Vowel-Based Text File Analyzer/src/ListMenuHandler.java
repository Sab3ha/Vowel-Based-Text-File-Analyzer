import java.awt.event.*;

public class ListMenuHandler implements ActionListener {

   WordGUI a;
   FileMenuHandler b;

   public ListMenuHandler(WordGUI x, FileMenuHandler y) {
      a = x;
      b = y;
   }
   /*displays text on the right hand column of the GUI based 
    *on the user input of clicking on a List menu item
    */
   public void actionPerformed(ActionEvent event) {
      String menuName;
      menuName = event.getActionCommand();
      //checks if the user clicked the menu item "A" from the list menu
      if (menuName.equals("A")) {
         /*the alphabetically sorted words starting with A along with
          *the line numbers on which they appeared in the input file
          *are displayed on the right hand column of the GUI
          */
         a.sortedText(b.WordTreeMap, 'A');
      }
      //checks if the user clicked the menu item "E" from the list menu
      else if (menuName.equals("E")) {
         /*the alphabetically sorted words starting with E along with
          *the line numbers on which they appeared in the input file
          *are displayed on the right hand column of the GUI
          */
         a.sortedText(b.WordTreeMap, 'E');
      }
      //checks if the user clicked the menu item "I" from the list menu
      else if (menuName.equals("I")) {
         /*the alphabetically sorted words starting with I along with
          *the line numbers on which they appeared in the input file
          *are displayed on the right hand column of the GUI
          */
         a.sortedText(b.WordTreeMap, 'I');
      }
      //checks if the user clicked the menu item "O" from the list menu
      else if (menuName.equals("O")) {
         /*the alphabetically sorted words starting with O along with
          *the line numbers on which they appeared in the input file
          *are displayed on the right hand column of the GUI
          */
         a.sortedText(b.WordTreeMap, 'O');
      }
      //checks if the user clicked the menu item "U" from the list menu
      else if (menuName.equals("U")) {
         /*the alphabetically sorted words starting with U along with
          *the line numbers on which they appeared in the input file
          *are displayed on the right hand column of the GUI
          */
         a.sortedText(b.WordTreeMap, 'U');
      }
   } // actionPerformed

}