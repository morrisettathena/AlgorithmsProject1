# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""

import numpy as np  
import time


#addMembers(array) will add all of the elements of an array if the array has ints as members
def addMembers(array):
    begin = time.perf_counter_ns() #determine the start time
    total = 0; #used for holding the addition of members
    for i in array: #goes through the whole array
        total += i
    end = time.perf_counter_ns() #determine the start time
    endtime = end - begin
    print(endtime)
    return total
    
def generateArray():
    n = 50
    A = np.random.randint(1,100,size=(n))
    
    return A

array1 = np.array(generateArray())

total = addMembers(array1)
