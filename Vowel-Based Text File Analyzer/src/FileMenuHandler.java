import java.awt.event.*;
import java.io.File;
import java.util.*;
import javax.swing.*;

//ActionListener implemented as it is used to detect user interaction with the GUI like
//clicking on a menu item. 
public class FileMenuHandler implements ActionListener {
   WordGUI wordGUI;
   //A TreeMap is created to store the contents of the chosen file along with the line numbers
   public TreeMap<String, WordLine> WordTreeMap = new TreeMap<>();
   public FileMenuHandler(WordGUI GUI) {
      wordGUI = GUI;
   }

   public void actionPerformed(ActionEvent event) {
      String menuName;
      //returns the command required for checking of the event of user interaction
      //of clicking a menu item
      menuName = event.getActionCommand();
      //checks if the user clicked the menu item "Open" from the file menu
      if (menuName.equals("Open"))
         openFile(); 
      //checks if the user clicked the menu item "Quit" from the file menu
      else if (menuName.equals("Quit") )
         System.exit(0);
   } // actionPerformed

   private void openFile() {
      int status;
      //a file chooser is created so that the user can chose a file from
      //their computer
      JFileChooser chooser = new JFileChooser();

      status = chooser.showOpenDialog(null);
      //checks if file is chosen by the user
      //if chosen the file is sent to the method readSources to be read
      if(status == JFileChooser.APPROVE_OPTION)
         readSources(chooser.getSelectedFile());
      else 
         JOptionPane.showMessageDialog(null, " open file dialog canceled"); 
   } // openFile

   /**The input file is read and the words in the file is split
    * into the words  using StringTokenizer. The words are
    * put into a TreeMap.
    * 
    * @param chosenFile this is the chosen file to be read and its words put into a TreeMap.
    * 
    */
   private void readSources(File chosenFile) {
      //getAbsolutePath is used to get the exact pathname of the chosen file so
      //that the file can be located and used in the program
      String chosenFilePath = chosenFile.getAbsolutePath();

      TextFileInput inFile = new TextFileInput(chosenFilePath);
      String line = inFile.readLine();
      String input = "";
      WordTreeMap.clear();
      //LineNum is initialized to keep track of the line number
      int LineNum = 1;
      /* Get the separated strings one by one from the StringTokenizer and put
       * them in a TreeMap.   
       */
      while(line != null) {
         StringTokenizer token = new StringTokenizer(line," ");
         while(token.hasMoreTokens()) {
            /*replaceAll is used to ensure the same word is not considered as different
             *just because of a comma, colon or another special character
             *so that the word "is" has the same String token as "is:"
             */
            String t = token.nextToken().replaceAll("[,';!:?_()]", "");
            if(WordTreeMap.containsKey(t)) {
               WordTreeMap.get(t).line.add(LineNum);
            }
            else {
               WordLine w = new WordLine(t, new ArrayList<Integer>());
               WordTreeMap.put(t, w);
               w.line.add(LineNum);
            }
         } // while
         input += LineNum + ". " + line + "\n";
         LineNum++;
         line = inFile.readLine();
      } // while
      //the text from the chosen file is displayed on the left column of the GUI
      wordGUI.inputText(input);

   }
}
