# -*- coding: utf-8 -*-
"""
Created on Wed Feb  8 20:37:10 2023

@author: moozi
"""
import numpy as np  
import pandas as pd
import sys
import time

#Creating our random ints that will size and populate our matrix
m = np.random.randint(100)
n = np.random.randint(100)

b = np.random.randint(100)

A = np.random.randint(1,100,size=(m,n))
#this lets us see every entry
np.set_printoptions(threshold=sys.maxsize)


#We can time the operation here
def scalarmatmult():
    begin = time.time()
    b = np.random.randint(100)

    A = np.random.randint(1,100,size=(m,n))
    np.set_printoptions(threshold=sys.maxsize)
    #print(A)
    
    A = A * b
    #print(A * b)

    end = time.time()
    print("It took ", end, "nanoseconds to complete") 
    
#call
scalarmatmult()



