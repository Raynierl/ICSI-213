/* Raynier Leroux ICSI-213 
 * Team 15 Discussion Class Friday 11:20AM
 * Module 1 Due: March 5,2018
 */

import java.util.Scanner;

public class Module_1 {
	
	 private static Scanner input = new Scanner(System.in); // Scanner object
	 
	public static void main(String[] args) {
		int check = -1; 			// To keep checking and reapating 
		while ( check < 0) {
		System.out.println("Enter the string to reverse,or ‘done’ to exit.");
		String word = input.nextLine(); // inputing the String
		
		char[] array = word.toCharArray(); // Turn the String into a character array
		
		int index = 0; // for the actual palindrome scanning
		
		// Big IF statement to Test is user typed Done
			if	(array.length == 4 && (array[0] == 'd' || array[0] == 'D') && (array[1] == 'o' || array[1] == 'O') && 
					(array[2] == 'n' || array[2] == 'N') && (array[3] == 'e' || array[3] == 'E')) {
					check++;
					System.out.println("You typed 'Done'\nExiting...");
				}	
		else {
			System.out.println("Your orginal String");
		for(int j = 0; j<array.length;j++) 			//Printing out the original string
			System.out.print(array[j]);
		
		System.out.println("\nYour Reversed String");
		for(int j = array.length-1 ; j >= 0; j--) 		//Printing out the original string reversed
			System.out.print(array[j]);
		
			palindrome(array,index);
			}//END else
		} // END While
		input.close(); // Close Input Scanner Scanner
	}	
	
/*
 * Palindrome
 * @param char[]
 * @param int
 * @returns int
 * @Author Raynier Leroux
 */
	public static int palindrome(char[] ar,int i) {
		

		if(i == ar.length) { // Check to see if String is a Palindrome
			System.out.println("\nYour String is a Palindrome!"); 
			return -1;
			} // END IF
		
		else {
			char reverse = ar[ar.length-i-1]; // Check the 
			
			if(ar[i] != reverse) { // Check to see if String is NOT a Palindrome
			System.out.println("\nYour String is not a plaindrome!");
			return -1;
			} // END Inner IF
			else {
				return palindrome(ar,i+1);
			} // END Inner ELSE
				
		} // END Else
			
	} // End of Palindrome method
	
} // End of Program
