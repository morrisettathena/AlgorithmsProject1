

#   Program: MatrixMultiplication.py
#   2/8/2023
#   Author: Connor Mulberry
 
#   Purpose:  Practice analyzing algorithms and their time complexity
 



import time
import random

MIN_MATRIX_VAL = 1
MAX_MATRIX_VAL = 100
ONE_MATRIX_GROWTH_MAX = 1000
TWO_MATRIX_GROWTH_MAX = 1000
THREE_MATRIX_GROWTH_MAX = 1000
    
    
    # Function that performs matrix multiplication.  Returns time elapsed.
def matrixMult(A, B):
    # Make sure that the rows and columns of A and B match, otherwise multiplication cannot be performed
    if len(A[0]) != len(B):
        raise ArithmeticError("# of columns of A must match # of rows of B")
        
        
    #Make empty C matrix with correct dimensions
    C = [[0 for j in range(len(B[0]))] for i in range(len(A))]
        
    start = time.perf_counter_ns() #determine the start time
        
    #Loop through every location in the matrix
    for i in range(len(C)):
        for j in range(len(C[0])):
            result = 0
        
            # Sum the results of matrix multiplication for one entry
            for k in range (len(A[0])):
                result += A[i][k]*B[k][j]
                
            C[i][j] = result #assign result to entry
        
    finish = time.perf_counter_ns() #determine finish time
    elapsed = finish - start
    return elapsed
    

def testOneDimensionGrowth(max_dimensions):
    with open("OneDimensionGrowthOutput.txt", "w") as writer:
        # Put results in basic JSON format, by starting with a curly brace
        writer.write("{\n")

        #multiply two randomly generated matrices.
        for i in range(1, max_dimensions):
            matrix1 = createRandomMatrix(i, 1, MIN_MATRIX_VAL, MAX_MATRIX_VAL)
            matrix2 = createRandomMatrix(1, 1, MIN_MATRIX_VAL, MAX_MATRIX_VAL)
            elapsed = matrixMult(matrix1, matrix2) #perform matrix muliplication

            #write data to file
            writer.write("\t{}: {}\n".format(i, elapsed))

        #Put results in basic JSON format, by ending the data with a curly brace
        writer.write("}\n")
        

#Procedure that tests how matrix multiplication grows as one of the dimensions of
#the matrices grows in size.  Output is called TwoDimensionGrowthOutput.txt
def testTwoDimensionGrowth(max_dimensions):
    with open("TwoDimensionGrowthOutput.txt", "w") as writer:
        # Put results in basic JSON format, by starting with a curly brace
        writer.write("{\n")

        #multiply two randomly generated matrices.
        for i in range(1, max_dimensions):
            matrix1 = createRandomMatrix(i, i, MIN_MATRIX_VAL, MAX_MATRIX_VAL)
            matrix2 = createRandomMatrix(i, 1, MIN_MATRIX_VAL, MAX_MATRIX_VAL)
            elapsed = matrixMult(matrix1, matrix2) #perform matrix muliplication

            #write data to file
            writer.write("\t{}: {}\n".format(i, elapsed))

        #Put results in basic JSON format, by ending the data with a curly brace
        writer.write("}\n")
        

#Procedure that tests how matrix multiplication grows as one of the dimensions of
#the matrices grows in size.  Output is called ThreeDimensionGrowthOutput.txt
def testThreeDimensionGrowth(max_dimensions):
    with open("ThreeDimensionGrowthOutput.txt", "w") as writer:
        # Put results in basic JSON format, by starting with a curly brace
        writer.write("{\n")

        #multiply two randomly generated matrices.
        for i in range(1, max_dimensions):
            matrix1 = createRandomMatrix(i, i, MIN_MATRIX_VAL, MAX_MATRIX_VAL)
            matrix2 = createRandomMatrix(i, i, MIN_MATRIX_VAL, MAX_MATRIX_VAL)
            elapsed = matrixMult(matrix1, matrix2) #perform matrix muliplication

            #write data to file
            writer.write("\t{}: {}\n".format(i, elapsed))

        #Put results in basic JSON format, by ending the data with a curly brace
        writer.write("}\n")
        

def makeWriter(path):
    #create output file
    with open(path, "w") as writer:
        return writer

def createRandomMatrix(rowDim, colDim, minVal, maxVal):
    if minVal > maxVal:
        p = minVal
        minVal = maxVal
        maxVal = p

    matrix = [[0 for j in range (colDim)] for i in range (rowDim)]
    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            matrix[i][j] = int(random.random()*(maxVal-minVal) + minVal)
    
    return matrix

def printMatrixInfo(matrix):
    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            print(str.ljust(", ", matrix[i][j]))
        print()
            
def getMatrixSize(matrix):
    return len(matrix) * len(matrix[0])

print("Testing when one dimension grows in size...")
testOneDimensionGrowth(ONE_MATRIX_GROWTH_MAX)
print("First test done.")
print("Testing when two dimensions grows in size...")
testTwoDimensionGrowth(TWO_MATRIX_GROWTH_MAX)
print("Second test done.")
print("Testing when three dimensions grows in size...")
testThreeDimensionGrowth(THREE_MATRIX_GROWTH_MAX)
print("Third test done.")
print("Results located in root folder of directory.")




    
        
    