import java.awt.*;
import javax.swing.*;
import java.util.*;

public class WordGUI extends JFrame {

   protected TextArea input, sorted;
   FileMenuHandler fmh;

   public WordGUI() {
      setTitle("WordGUI");
      setLayout(new GridLayout(1, 2));
      input = new TextArea();
      sorted = new TextArea();
      Container myContentPane = getContentPane();
      /*the text areas are cleared so that the GUI is able to display 
       *text a different input file if required
       */
      clear();
      myContentPane.add(input);
      myContentPane.add(sorted);
      //a new menu bar is created
      JMenuBar menuBar = new JMenuBar();
      createFileMenu(menuBar);
      createListMenu(menuBar);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      setVisible(true);
   }
   /**A menu is created on the menu bar called file menu with menu items
    * "Open" and "Quit".
    *  
    * @param menubar this is the menu bar on which the file menu is created.
    * 
    */
   private void createFileMenu(JMenuBar menubar) {
      //a new menu is created and labeled as "File"
      JMenu fileMenu = new JMenu("File");
      JMenuItem item;
      fmh = new FileMenuHandler(this);
      //a menu item labeled as "Open" is created
      item = new JMenuItem("Open");
      //The ActionListener FileMenuHandler is added to check for user interaction with
      //the file menu item "Open"
      item.addActionListener(fmh);
      fileMenu.add(item);
      //adds horizontal separator between menu items
      fileMenu.addSeparator();
      //a menu item labeled as "Quit" is created
      item = new JMenuItem("Quit");
      //The ActionListener FileMenuHandler is added to check for user interaction with
      //the file menu item "Quit"
      item.addActionListener(fmh);
      fileMenu.add(item);
      //adds file menu to the menu bar
      setJMenuBar(menubar);
      menubar.add(fileMenu);

   } // createmenu

   /**A menu is created on the menu bar called "List" menu with menu items
    * "A", "E", "I", "O" and "U".
    *  
    * @param menubar this is the menu bar on which the list menu is created.
    * 
    */
   private void createListMenu(JMenuBar menubar){

      JMenu listMenu = new JMenu("List");
      JMenuItem items;
      ListMenuHandler lmh = new ListMenuHandler(this,fmh);

      items = new JMenuItem("A");
      //The ActionListener ListMenuHandler is added to check for user interaction with
      //the list menu item "A"
      items.addActionListener(lmh);
      listMenu.add(items);

      listMenu.addSeparator();

      items = new JMenuItem("E");
      //The ActionListener ListMenuHandler is added to check for user interaction with
      //the list menu item "E"
      items.addActionListener(lmh);
      listMenu.add(items);

      listMenu.addSeparator();

      items = new JMenuItem("I");
      //The ActionListener ListMenuHandler is added to check for user interaction with
      //the list menu item "I"
      items.addActionListener(lmh);
      listMenu.add(items);

      listMenu.addSeparator();

      items = new JMenuItem("O");
      //The ActionListener ListMenuHandler is added to check for user interaction with
      //the list menu item "O"
      items.addActionListener(lmh);
      listMenu.add(items);

      listMenu.addSeparator();

      items = new JMenuItem("U");
      //The ActionListener ListMenuHandler is added to check for user interaction with
      //the list menu item "U"
      items.addActionListener(lmh);
      listMenu.add(items);
      //adds list menu to the menu bar
      setJMenuBar(menubar);

      menubar.add(listMenu);

   } // ListMenu
   /**This method clears the input and sorted text areas
    */
   public void clear() {
      input.setText("");
      sorted.setText("");
   }
   /**This method displays the text file to the input text area
    * 
    * @param l the string that is displayed in the input text area
    */
   public void inputText(String l) {
      input.setText(l);
   }
   /**This method displays the sorted words to the sorted text area
    * 
    * @param  tmap the TreeMap that contains the sorted word and their line numbers
    * @param vowel the character that is the vowel letter all the words need to start with
    */
   public void sortedText(TreeMap<String, WordLine> tmap, char vowel) {
      sorted.setText(null);

      Set set = tmap.entrySet();
      Iterator i = set.iterator();
      Map.Entry<String, WordLine> me;

      while (i.hasNext()) {
         me = (Map.Entry) i.next();

         String WordPrint = me.getValue().word;

         if (
               Character.toLowerCase(me.getKey().charAt(0)) ==
               Character.toLowerCase(vowel)
               ) {

            sorted.append(WordPrint + ": " + LineNumbers(me.getValue().line) + "\n");
         }
      }
   } //sortedText

   /**This method returns the contents of the integer ArrayList as string
    * separated by commas and without brackets
    * 
    * @param  aList the ArrayList<Integer> that contains the line numbers
    */
   public String LineNumbers(ArrayList<Integer> aList) {
      ArrayList<Integer> array = new ArrayList<Integer>(removeDuplicates(aList));
      String linenumber ="";
      int lastindex = array.size()-1;
      for (Integer i: array) {
         linenumber = linenumber+i;
         if (array.indexOf(i) != lastindex) linenumber =linenumber+", ";
      }
      linenumber = linenumber.replaceAll("[\\[]]", "");
      return(linenumber);

   }
   /**This method returns the ArrayList without any duplicate elements
    * 
    * @param  aList the ArrayList<Integer> that contains the line numbers
    */
   public ArrayList<Integer> removeDuplicates(ArrayList<Integer> aList){
      ArrayList<Integer> List = new ArrayList<Integer>();
      // Traverse through the first list
      for (Integer i : aList) {
         // If this element is not present in newList then add it
         if (!List.contains(i)) {
            List.add(i);
         }
      }
      // return the new list
      return List;
   }

}
