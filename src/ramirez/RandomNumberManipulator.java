/*
 *   Name:              Jose Ramirez
 * 
 *   Program:           Random Number Manipulator
 * 
 *   Description:       This programs takes a number from the user and generates
 *                      random numbers based on that number. The program then
 *                      will compute the smallest, highest, sum, and average of
 *                      all the random generated numbers.
 *
 *   Date Started:      2/24/18
 *   Last Modified:     2/25/18
 *
 */

package ramirez;

import java.util.Random;
import javax.swing.JOptionPane;

public class RandomNumberManipulator 
{
    public static void main(String[] args) 
    {
        // random number object
        Random ranNum    = new Random();
        // user input object for the user
        String userInput = new String();
        // string object to concatenate all numbers into one string literal
        String numString = new String();
        
        // holds the user number
        int userNumber;
        // holds the random number
        int newRandomNumber;
        // holds the highest random number
        int highestNum;
        // holds the lowest random number
        int lowestNum;
        // holds the sum of all random numbers
        int randomSum;
        // holds the average of all random numbers
        int randomAvg;
        
        // dialog box where the user inputs a number from 1 - 100
        userInput = JOptionPane.showInputDialog
                    (
                      null,
                      "Please enter a number between 1 and 100.",
                      "Random Number Manipulator",
                      JOptionPane.QUESTION_MESSAGE
                    );
        
        // conversion of the user number into an integer from a string literal
        userNumber = Integer.parseInt(userInput);
        
        newRandomNumber = 0;
        highestNum      = 0;
        lowestNum       = 0;
        randomSum       = 0;
        
        // for loop that determines the highest, lowest, sum of random numbers
        for (int i = 1; i <= userNumber; i++)
        {
            newRandomNumber = (int)(ranNum.nextFloat()*100+1);
            
            if (newRandomNumber >= highestNum)
            {
                highestNum = newRandomNumber;
            }
            else
            {
                if (lowestNum == 0)
                {
                    lowestNum = newRandomNumber;
                }
                else
                {
                    if (newRandomNumber <= lowestNum)
                    {
                        lowestNum = newRandomNumber;
                    }
                }
            }
            
            if (i < userNumber)
            {
                numString += Integer.toString(newRandomNumber) + ", ";
            }
            else
            {
                numString += Integer.toString(newRandomNumber) + ".";
            }
      
            randomSum += newRandomNumber;
        }
        
        // random numbers average calculation
        randomAvg = randomSum/userNumber;
        
        // displays all the calculations to the user
        JOptionPane.showMessageDialog
        (
          null,
          "You wanted to generate " + userNumber + " numbers. " + 
          "The numbers are: \n"     + numString  + "\n"         +
          "We've calculated that: \nThe smallest number is "    + lowestNum  + 
          ", the highest number is "                            + highestNum + 
          ", \nthe sum of all is "                              + randomSum  +
          ", and the average is "                               + randomAvg  + ".",
          "Random Number Manipulator - Results",
          JOptionPane.INFORMATION_MESSAGE
        );
  
    } // main
} // class
