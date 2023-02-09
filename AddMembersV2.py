# -*- coding: utf-8 -*-
"""
Name: AddMembersV2.py
Date: 2/6/2023
Class: Comsc340
Instructor: Sonya Cates

Description: Algorithm for adding members of an array

"""
#numpy imported to make arrays
import numpy as np

#addMembers(array) will add all of the elements of an array if the array has ints as members
def addMembers(array):
    total = 0; #used for holding the addition of members
    for i in array: #goes through the whole array
        total += i
    
    return total


#test
array1 = np.array([1,2,3,4,5,6,7,8,9,10])

total = addMembers(array1)
print(total)