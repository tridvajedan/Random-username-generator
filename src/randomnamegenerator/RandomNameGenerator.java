/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomnamegenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Korisnik
 */
public class RandomNameGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        String abc = generateRandomName();
        System.out.println(abc);
    }
    
    public static String generateRandomName() throws FileNotFoundException 
    {
      Random r = new Random();
      File seperatorFile = new File("Seperators.csv");
      Scanner seperatorScanner = new Scanner(seperatorFile);
      File wordsFile = new File("Words.csv");
      Scanner fileScanner = new Scanner(wordsFile);
      String unsplitWords = fileScanner.nextLine();
      String unsplitSeperators = seperatorScanner.nextLine();
      String[] splitWords = unsplitWords.split(",");
      String[] splitSeperators = unsplitSeperators.split(",");
      String fullUser = "";
      int lengthOfName = r.nextInt(3) + 1;
      for(int i = 0; i < lengthOfName; i++)
      {
          int randomInt = r.nextInt(splitWords.length);
        String temporaryWord = splitWords[randomInt];
        int randomSeperatorInt = r.nextInt(splitSeperators.length);
        String temporarySeperator = splitSeperators[randomSeperatorInt];
        fullUser = fullUser + temporaryWord + temporarySeperator;
        
      }
      int choice = r.nextInt(4);
      int lastLetterPlace = fullUser.length();
      fullUser = fullUser.substring(0, lastLetterPlace-1);
      if(choice == 1)
      {
          
      }
      else
      {
          int random = r.nextInt(1000);
          String parsedInt = Integer.toString(random);
          fullUser = fullUser + parsedInt;
      }
      return fullUser;
    }
    
}
