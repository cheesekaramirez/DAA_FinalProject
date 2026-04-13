package code;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Driver {
    
    public static void main(String[] args) {

      try(Scanner scn = new Scanner(new FileReader("src/file/words.txt")))
      {
        while(scn.hasNextLine()){
          String string1=scn.nextLine();
          if(string1.isEmpty() && scn.hasNextLine()){
            string1=scn.nextLine();
          }
          String string2=scn.nextLine();
          Levenshtein lvn = new Levenshtein(string1, string2);
          long startTime = System.nanoTime();
          lvn.display();
          long endTime = System.nanoTime();
          long duration = endTime - startTime;
          System.out.println("Execution time for m="+string1.length()+", n=" + string2.length() + ": " + duration + " ns");
        }
      } catch (FileNotFoundException e) {
        System.out.println(e.getMessage());
    }
  }
}