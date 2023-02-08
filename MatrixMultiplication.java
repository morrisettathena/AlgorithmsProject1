
/*
 * Program: MatrixMultiplication.java
 * 2/6/2023
 * Written by John Morrisett
 * 
 * Purpose:  Practice analyzing algorithms and their time complexity
 * 
 */

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MatrixMultiplication {
	final static int MIN_MATRIX_VAL = 1;
	final static int MAX_MATRIX_VAL = 100;
	final static int ONE_MATRIX_GROWTH_MAX = 100;
	final static int TWO_MATRIX_GROWTH_MAX = 100;
	final static int THREE_MATRIX_GROWTH_MAX = 100;
	
	public static void main(String args[]) throws FileNotFoundException, IOException {
		System.out.println("Testing when one dimension grows in size...");
		testOneDimensionGrowth(ONE_MATRIX_GROWTH_MAX);
		System.out.println("First test done.");
		System.out.println("Testing when two dimensions grows in size...");
		testTwoDimensionGrowth(TWO_MATRIX_GROWTH_MAX);
		System.out.println("Second test done.");
		System.out.println("Testing when three dimensions grows in size...");
		testThreeDimensionGrowth(THREE_MATRIX_GROWTH_MAX);
		System.out.println("Third test done.");
		System.out.println("Results located in root folder of directory.");
	}
	
	/// Function that performs matrix multiplication.  Returns time elapsed.
	public static long matrixMult(int[][] A, int[][] B) {
		// Make sure that the rows and columns of A and B match, otherwise multiplication cannot be performed
		if (A[0].length != B.length) {
			throw new ArithmeticException("# of columns of A must match # of rows of B");
		}
		
		//Make empty C matrix with correct dimensions
		int[][] C = new int[A.length][B[0].length];
		
		long start = System.nanoTime(); //determine the start time
		
		//Loop through every location in the matrix
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < C[0].length; j++) {
				int result = 0;
				
				// Sum the results of matrix multiplication for one entry
				for (int k = 0; k < A[0].length; k++) {
					result += A[i][k]*B[k][j];
				}
				C[i][j] = result; //assign result to entry
			}
		}
		
		long finish = System.nanoTime(); //determine finish time
		long elapsed = finish-start;
		return elapsed;
	}
	
	/// Procedure that tests how matrix multiplication grows as one of the dimensions of
	/// the matrices grows in size.  Output is called OneMatrixOutput.txt
	public static void testOneDimensionGrowth(int max_dimensions) throws IOException {
		FileWriter writer = makeWriter("OneDimensionGrowthOutput.txt");
		// Put results in basic JSON format, by starting with a curly brace
		writer.write("{\n");
		
		//multiply two randomly generated matrices.
		for (int i = 1; i < max_dimensions; i++) {
			int[][] matrix1 = createRandomMatrix(i, 1, MIN_MATRIX_VAL, MAX_MATRIX_VAL);
			int[][] matrix2 = createRandomMatrix(1, 1, MIN_MATRIX_VAL, MAX_MATRIX_VAL);
			long elapsed = matrixMult(matrix1, matrix2); //perform matrix multiplication
			
			//write data to file
			writer.write(String.format("\t%d : %d\n", i, elapsed));
		}
		//Put results in basic JSON format, by ending the data with a curly brace
		writer.write("}\n");
		writer.close();
	}
	
	/// Procedure that tests how matrix multiplication grows as two of the dimensions of
	/// the matrices grows in size.  Output is called TwoMatrixOutput.txt
	public static void testTwoDimensionGrowth(int max_dimensions) throws IOException {
		FileWriter writer = makeWriter("TwoDimensionGrowthOutput.txt");
		// Put results in basic JSON format, by starting with a curly brace
		writer.write("{\n");
		
		//multiply two randomly generated matrices.
		for (int i = 1; i < max_dimensions; i++) {
			int[][] matrix1 = createRandomMatrix(i, i, MIN_MATRIX_VAL, MAX_MATRIX_VAL);
			int[][] matrix2 = createRandomMatrix(i, 1, MIN_MATRIX_VAL, MAX_MATRIX_VAL);
			long elapsed = matrixMult(matrix1, matrix2); //perform matrix multiplication
			
			//write data to file
			writer.write(String.format("\t%d : %d\n", i, elapsed));
		}
		//Put results in basic JSON format, by ending the data with a curly brace
		writer.write("}\n");
		writer.close();	
	}
	
	/// Procedure that tests how matrix multiplication grows as all of the dimensions of
	/// the matrices grows in size.  Output is called ThreeMatrixOutput.txt
	public static void testThreeDimensionGrowth(int max_dimensions) throws IOException {
		FileWriter writer = makeWriter("ThreeDimensionGrowthOutput.txt");
		// Put results in basic JSON format, by starting with a curly brace
		writer.write("{\n");
		
		//multiply two randomly generated matrices.
		for (int i = 1; i < max_dimensions; i++) {
			int[][] matrix1 = createRandomMatrix(i, i, MIN_MATRIX_VAL, MAX_MATRIX_VAL);
			int[][] matrix2 = createRandomMatrix(i, i, MIN_MATRIX_VAL, MAX_MATRIX_VAL);
			long elapsed = matrixMult(matrix1, matrix2); //perform matrix multiplication
			
			//write data to file
			writer.write(String.format("\t%d : %d\n", i, elapsed));
		}
		//Put results in basic JSON format, by ending the data with a curly brace
		writer.write("}\n");
		writer.close();	
	}
	
	/// Function that makes a writer to a certain path
	public static FileWriter makeWriter(String path) throws FileNotFoundException, IOException {
		File file = new File(path);
		file.createNewFile();
		FileWriter writer = new FileWriter(file);
		return writer;
	}
	
	/// Procedure that prints out a matrix
	public static void printMatrixInfo(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.printf("%3d, ", matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	/// Function that creates a random matrix.
	public static int[][] createRandomMatrix(int rowDim, int colDim, int minVal, int maxVal) {
		//swap min and max if needed
		if (minVal > maxVal)  {
			int p = minVal;
			minVal = maxVal;
			maxVal = p;
		}
		
		//for every entry in the matrix, assign a random value
		int[][] matrix = new int[rowDim][colDim];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = (int)(Math.random()*(maxVal - minVal) + minVal);
			}
		}
		return matrix;
	}
	
	/// Function that returns the size of the matrix
	public static int getMatrixSize(int[][] matrix) {
		return matrix.length * matrix[0].length;
	}
}
