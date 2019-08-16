/* Raynier Leroux ICSI-213    
 * Team 15 Discussion Class Friday 11:30AM
 * Module 3 Due: May 12,2018
 */

import java.io.*; // Import File handlers 
import java.util.Arrays;
import java.util.Scanner;

public class Module_3 {
	
	public static Scanner input = new Scanner(System.in);
	public static int counter = 0;
	private static BufferedReader filetake;
	
	// Creating Node methods for my tree nodes
	public static class Node {
		
		String data;
		Node left, right;
				
		public Node(String X) {
			
			data = X;
			left = null;
			right = null;
			
		}
	
		
	} // End of Node class
	 
	public static class BinaryTree {
		
		Node root;
		
		BinaryTree(String x){
			
			root = new Node(x);
		}	
		BinaryTree(){
			
			root = null;
		}
		
		public void PrintTree(Node k) {
			
			if(k == null) {
				return;
			}
			System.out.println(k.data);
			PrintTree(k.left);
			PrintTree(k.right);
		}
		
	} // End of binarytree class
	
	public static Node sortTree(String[] A, int start, int end) { // Setting up the Binary Tree
		
		if ( start > end) return null;
		int mid = (start + end) / 2;
		
		Node root = new Node(A[mid]);
		root.right = sortTree(A,mid+1,end);	
		root.left = sortTree(A,start,mid-1);
		
		return root;
	}
	
	public static void searchTree(Node A,String S,int count) {
		
		count++;
		if (A.data != null) {
		String[] split = A.data.split(" ", 2); 
					
		if(S.equalsIgnoreCase(split[0])) {
			System.out.println("Census Data: " + split[0] + "\nNumber of times the name was recorded: " + split[1] + "\nAmount of comparisons: " + count );
		} // END IF
		else if(split[0].compareToIgnoreCase(S) > 0 && A.left != null) {
			searchTree(A.left,S,count);
		} // END ELSE IF
		else if(split[0].compareToIgnoreCase(S) < 0 && A.right != null) {
			searchTree(A.right,S,count);
		} // End ELSE IF
		else {
			System.out.print("That name is NOT in this file.\nExiting.....");
		} // End ELSE IF
		
		}
	} // END of searchTree method
	
	public static void main(String[] args) throws IOException {
		
		final int SIZE = 4429; // Size of the array becuase of the number of elements in the text file.
		String nof = "D:\\Eclipse\\ICSI-213\\src\\Census2000.txt";
		File textfile = new File(nof);
		if (!textfile.exists()) {
			System.out.println("Final did not open!\nExiting....");
			return;
		} // End IF
		else {
			
		System.out.print("Enter a name to Search: ");
		String name = input.nextLine();
		
		String[] sArray = new String[SIZE];
		FileReader fileread = new FileReader(nof); // A reader object to check the file
		filetake = new BufferedReader(fileread);
		BinaryTree t = new BinaryTree();
		
		for(int i = 0; i < SIZE; i++) // The for loop just fills an array with all the values
			sArray[i] = filetake.readLine();
		Arrays.sort(sArray); // Sorting the Array before turning it into binary
		
		t.root = sortTree(sArray,0,SIZE-1); // Sorting the tree starting from 
		
		t.PrintTree(t.root); // Prints the tree starting at the root
		
		searchTree(t.root,name, counter); // Searches the tree for the inputted value
		
		} // End ELSE
		
	} // END Main
	
} // End File
