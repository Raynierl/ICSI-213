/* Raynier Leroux ICSI-213   
 * Team 15 Discussion Class Friday 11:30AM
 * Module 2 Due: April 27,2018
 */
import java.util.Random;

public class Module_2 {
	
	// Global Variables
	public static int bubavgComparisons = 0; // Global variable to keep track of the total number of comparisons.
	public static int quickavgComparisons = 0; // Global variable to keep track of the total number of comparisons
	public static int qcomparisoncounter = 0; // Global variable to keep track of the number of comparisons for each array.
	public final static int SIZE = 100; // Global variable Determines the size of all the variables
	public static int Acounter = 0; // Global variable that Keeps track of which array we are in
	
	public static void main(String[] args) {
		
		// Creating the Arrays 
		int[] A1 = new int[SIZE];
		MethodManager(A1);
		int[] A2 = new int[SIZE];
		MethodManager(A2);
		int[] A3 = new int[SIZE];
		MethodManager(A3);
		int[] A4 = new int[SIZE];
		MethodManager(A4);
		int[] A5 = new int[SIZE];
		MethodManager(A5);
		int[] A6 = new int[SIZE];
		MethodManager(A6);
		int[] A7 = new int[SIZE];
		MethodManager(A7);
		int[] A8 = new int[SIZE];
		MethodManager(A8);
		int[] A9 = new int[SIZE];
		MethodManager(A9);
		int[] A10 = new int[SIZE];
		MethodManager(A10);
		
		System.out.println("Average Number of BubbleSort Comparisons: " + (bubavgComparisons/10)
							+ "\nAverage Number of QuickSort Comparisons: " + (quickavgComparisons/10));
	} // End Main

	public static void fill(int[] A) {
		//Filling the arrays with random values from 0-99
		Random rand = new Random();
		System.out.print("[ ");
		for(int i = 0 ; i < A.length; i++) // Displaying the Unsorted Array
		{
			A[i] =  rand.nextInt(99);
			System.out.print(A[i]);
			if( i == A.length - 1)
				System.out.print(" ] \n");
			else 
			System.out.print(", ");
		}
		
	} // End fill Method
	
	public static void BubbleSort(int[] A) {
		
		int temp = 0;
		int totalComparisons = 0;
		int[] tempArray = new int[SIZE];
		for(int i = 0; i < tempArray.length; i++) {
			tempArray[i] = A[i];
		}
		for (int i = 0;i < A.length; i++) { // Bubble Sort
			for ( int j = 0 ; j < tempArray.length - 1 - i; j++) {
				if (tempArray[j] > tempArray[j+1] ) {
					//Swap
					temp = tempArray[j];
					tempArray[j] = tempArray[j+1];
					tempArray[j+1] = temp;
				}
				totalComparisons++; // Keeps track of comparisons
			} // End inner For
		} // End outer FOR
		
		System.out.println("BubbleSorted: ");
		System.out.print("[ " + tempArray[0]);
		for ( int i = 1; i < tempArray.length; i++) {
			if ( i == tempArray.length-1)
			System.out.print(", " + tempArray[i] + " ]\n");
			else
			System.out.print(", " + tempArray[i]);
		} // End For
		System.out.println("BuubleSort Comparisons: " + totalComparisons);
		bubavgComparisons += totalComparisons;
	} // End Method BubleSort
	
	public static void QuickSort(int[] A, int low,int high) {
		
		if (low < high) {
			int part = partition(A,low,high);
			QuickSort(A, low, part-1);
			QuickSort(A,part+1,high);
		}
	} // End QuickSort Method
	
	public static int partition(int[] A,int low, int high) {
		
		int totalComparisons = 0;
		int pivot = A[high];
		int min = low-1;
		for ( int i = low ; i < high; i ++) {
			if (A[i] <= pivot) {
				min++;
				//Swap
				int temp = A[min];
				A[min] = A[i];
				A[i] = temp;
			totalComparisons++;
			}
			
		} // End for
		//Swap 
		int temp = A[min+1];
		A[min+1] = A[high];
		A[high] = temp;
		
		qcomparisoncounter += totalComparisons;
		quickavgComparisons += totalComparisons;
		return min+1;
	} // End partition method
	
	public static void QuickShow(int[] A) {
		System.out.print("Quick Sorted:\n[ ");
		for ( int i =0; i < A.length; i++) {
			if ( i == A.length-1)
				System.out.print(A[i] + " ]\n");
			else
				System.out.print(A[i] + ", ");
			}
		System.out.println("QuickSort Comparisons: " + qcomparisoncounter + "\n");
		qcomparisoncounter = 0; // Reset the counter for the next array.
	} // End QuickShow Method
	
	public static void Arraytracker() { // Keeping track of which Array is being "Worked on"
		Acounter++;
		System.out.println("Array " + Acounter + ": ");
		
	} // End Arraytacker method
	
	public static void MethodManager(int[] A) { // Added this for "neatness"
		Arraytracker();
		fill(A);
		BubbleSort(A);
		QuickSort(A,0,SIZE-1);
		QuickShow(A);
	} // End MethodManager Method
} // End of program