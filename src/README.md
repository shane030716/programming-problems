# Programming Problems

* [BiNode Conversion](#binode-conversion)
* [Edit Distance](#edit-distance)
* [Find the Number Occurring Odd Number of Times](#find-the-number-occurring-odd-number-of-times)
* [Move All Zeros to End](#move-all-zeros-to-end)
* Sum Two Linked Lists
* Sum of Weight of Each Path Between Two Nodes in a Graph
* Tower of Hanoi

### [BiNode Conversion](BiNodeConversion.java)

Convert a Binary Tree to an 'in-order' double-linked list, where the left child represents previous element and the right child represent next element

Example Input: 
```
         8
       /   \
      4     10
     / \      \
    1   5     15
         \    /
          7  12
```
Output:
```
1 <-> 4 <-> 5 <-> 7 <-> 8 <-> 10 <-> 12 <-> 15
```

### [Edit Distance](EditDistance.java)

Given two strings str1 and str2 and below operations that can performed on str1. 

Find minimum number of edits (operations) required to convert ‘str1′ into ‘str2′.
* Insert
* Remove
* Replace

All of the above operations are of equal cost.

### [Find the Number Occurring Odd Number of Times](FindTheNumberOccurringOddNumberOfTimes.java)

Given an array of POSITIVE integers. 
All numbers occur even number of times except one number which occurs odd number of times. 

Example:

Input: [1, 2, 3, 2, 3, 2, 1, 2, 3]

Output: 3   

### [Move All Zeros to End](MoveAllZerosToEnd.java)

Given an array of integers, move all elements that are zeros to the end of the array while the rest of the elements are still in their original order.

Example:

Input: [0, 1, 3, 0, 0, 0, ,2 8, 12, 0, 4, 0, 7]

Output: [1, 3, 2, 8, 12, 4, 7, 0, 0, 0, 0, 0, 0]
