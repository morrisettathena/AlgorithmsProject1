//*********************
//Algorithm1.java
//
// Author: Jack Noyes
// Date: 2/5/23
// Instructor: S. Cates
// Class: Algorithm Analysis
//
// Purpose: Class for an algorithm that adds the numbers in a array



import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Algorithms{

private int[] userarray;


	
	 public Algorithms(){
		 
	}
/*
 * Method Def: Generates an array with a user decided size and fills it with random integers
 * Return: int[] userarray
 */
	 public int[] generateArray() {//start method
		 
		 Scanner obj = new Scanner(System.in);//allows for user input
		 System.out.println("Enter the size of the array: "); //prompt to the user
		 int size = obj.nextInt();//gets the size of the array form the user
		 userarray = new int[size];//establishes the userarry's size
		 
		 //for loop that updates the index of the array with a random integer
		 for(int i = 0; i < userarray.length; i++) {
			 userarray[i] += (Math.random() * 100);
		 }
		 
		 return userarray;
	 }//end method
	
/*
 * 
 * Method Def:  adds all of the elements of the user array while tracking the time of the function
 * Returns; int total
 * 
 */
	 public long addElements(int[] userArray){//start method
			long start = System.nanoTime(); //starts clock
			int total = 0;
			for(int i = 0; i <= userArray.length-1; i++ ) {
				 total += userArray[i]; //adds the index value to the total variable
			}
			long end = System.nanoTime(); // stops clock
			long time = end - start; //measures the difference between the start and the end
			System.out.println("\n Time of the algorithm: " + time + " Nanoseconds");
			return total;
		}//end method



	
	
	
	
	
	
	
	
	
	
	
	
}
