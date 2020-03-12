import java.util.ArrayList;
import java.util.Scanner;

public class Bigrams {
   /**
    * This program takes any input and detects bigrams in every word.
    * It returns the number of occurrences and overall frequency for each bigram.
    */
   public static ArrayList<String> bigrams = new ArrayList<String>();

   /** Array that stores tallies for all possible bigram combinations. */
   private static int[][] tallies = new int[8192][8192];

   /** Counts the total amount of bigrams per given input */
   private static double totalCount;

   /** Scans text as input and detects each token */
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      while (input.hasNext()) {
         String token = input.next();
         token = token.toLowerCase();

         for (int i  = 0; i < token.length() - 1; i++) {
            if (Character.isLetter(token.charAt(i)) && Character.isLetter(token.charAt(i + 1))) {
               tallies[token.charAt(i)][token.charAt(i + 1)]++;
                totalCount++;
     	      }
         }
      }
	
      for (int i = 0; i < tallies.length; i++) {
         for (int j = 0; j < tallies.length; j++) {
            if (tallies[i][j] > 0) {
               char first = (char)i;
               char second = (char)j;
               String one = String.valueOf(first);
               String two = String.valueOf(second);
               System.out.print(one + two + "\t" + tallies[i][j]
                  + "\t" + String.format("%.10f%n", tallies[i][j] / totalCount));
            }
         }
      }
   }
}
