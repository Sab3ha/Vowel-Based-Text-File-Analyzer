import java.util.ArrayList;

public class WordLine {

   protected String word;
   protected ArrayList<Integer> line ;
   /**A two argument constructor which initializes a string value as
    * word and an ArrayList of line numbers.
    * 
    * @param w the string that is initialized as the word
    * @param l the ArrayList<Integer> that is initialized as the ArrayList of line numbers
    */
   public WordLine( String w, ArrayList<Integer> l) {
      //An exception is thrown if the line number y is less than 1
      if(l.size() >= 1 && l.get(l.size() - 1) < 1) {
         throw new InvalidWordLineException("Invalid word!");
      }
      word = w;
      line = l;
   }
} 
