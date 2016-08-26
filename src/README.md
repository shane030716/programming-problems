# Programming Problems

* [BiNode Conversion](#binode-conversion)
* [Edit Distance](#edit-distance)
* [Find the Number Occurring Odd Number of Times](#find-the-number-occurring-odd-number-of-times)
* [Move All Zeros to End](#move-all-zeros-to-end)
* [Sum Two Linked Lists](#sum-two-linked-lists)
* [Sum of Weight of Each Path Between Two Nodes in a Graph](#sum-of-weight-of-each-path-between-two-nodes-in-a-graph)
* [Tower of Hanoi](#tower-of-hanoi)
* [Volume Of Histogram](#volume-of-histogram)

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

Given an array of POSITIVE integers. All numbers occur even number of times except one number which occurs odd number of times. Find this number.

Example:

Input: `[1, 2, 3, 2, 3, 2, 1, 2, 3]`

Output: `3`   

### [Move All Zeros to End](MoveAllZerosToEnd.java)

Given an array of integers, move all elements that are zeros to the end of the array while the rest of the elements are still in their original order.

Example:

Input: `[0, 1, 3, 0, 0, 0, 2, 8, 12, 0, 4, 0, 7]`

Output: `[1, 3, 2, 8, 12, 4, 7, 0, 0, 0, 0, 0, 0]`

### [Sum Two Linked Lists](SumLinkedLists.java)

Given two numbers represented by two linked lists, write a function that returns sum list. 
The sum list is linked list representation of addition of two input numbers. 
Node that this problem can have two versions:

#### Forward version:

The most significant digit is the first node and the least significant digit is the last node (Natural order). Example: 

Input:

* First list:  `3 -> 4 -> 2 (342)`
* Second list: `9 -> 9 -> 8 -> 6 (9986)`

Output:

* Result list: `1 -> 0 -> 3 -> 2 -> 8 (10328)`



#### Backward version:

The least significant digit is the first node and the most significant digit is the last node (Reverse order). 
Example: 

Input:

* First list: `3 -> 4 -> 2 (243)`

* Second list: `9 -> 9 -> 8 -> 6 (6899)`

Output:

* Result list: `2 -> 4 -> 1 -> 7 (7142)`

### [Sum of Weight of Each Path Between Two Nodes in a Graph](SumOfWeightOfEachPathBetweenTwoNodes.java)

Given a undirected graph with weights, 
return the sum of the weight of each path between two nodes (shortest path between two vertices). 
Assume there are no cycles.
Example:

Input:
```
       A
       | 1
       B
   2 /   \ 3
    C     D
```    
Output:
`18`

since 
* A to B has weight 1
* A to C has weight 3
* A to D has weight 4
* B to C has weight 2
* B to D has weight 3
* C to D has weight 5 

### [Tower of Hanoi](TowerOfHanoi.java)

Tower of Hanoi is a mathematical puzzle. 
It consists of three poles and a number of disks of different sizes which can slide onto any poles. 
The puzzle starts with the disk in a neat stack in ascending order of size in one pole, 
the smallest at the top thus making a conical shape. 
The objective of the puzzle is to move all the disks from one pole (say ‘source pole’) 
to another pole (say ‘target pole’) with the help of third pole (say auxiliary pole).
The puzzle has the following two rules:
   1. You can’t place a larger disk onto smaller disk
   2. Only one disk can be moved at a time

### [Volume of Histogram](VolumeOfHistogram.java)

Given a histogram represented by an array of non-negative integers,
each element in the array represents the height of each bar of the histogram.
Now imagine pouring water inside the histogram.
Find the maximum volume of water that the histogram can hold.
Assume all bars have the same width and the width is 1 unit

Example:

Input: `[1,0,0,4,0,0,6,0,0,3,10,0,2,0,5,2,0,3,0,0]`

Output: `42`

The histogram will look like
```
                                         ___                                    
                                        |   |                                   
                                        |   |                                   
                                        |   |                                   
                         ___            |   |                                   
                        |   |           |   |            ___                    
             ___        |   |           |   |           |   |                   
            |   |       |   |        ___|   |           |   |        ___        
            |   |       |   |       |   |   |    ___    |   |___    |   |       
 ___        |   |       |   |       |   |   |   |   |   |   |   |   |   |       
|___|___ ___|___|___ ___|___|___ ___|___|___|___|___|___|___|___|___|___|___ ___
  1   0   0   4   0   0   6   0   0   3  10   0   2   0   5   2   0   3   0   0 
```  
After filling the histogram with water with its maximum capacity, it will then look like this. '+' represents the water.
```
                                         ___                                    
                                        |   |                                   
                                        |   |                                   
                                        |   |                                   
                         ___            |   |                                   
                        |   |+++ +++ +++|   |            ___                    
             ___        |   |+++ +++ +++|   |+++ +++ +++|   |                   
            |   |+++ +++|   |+++ +++ ±±±|   |+++ +++ +++|   |        ___        
            |   |+++ +++|   |+++ +++|   |   |+++ ±±± +++|   |±±± +++|   |       
 ___        |   |+++ +++|   |+++ +++|   |   |+++|   |+++|   |   |+++|   |       
|___|±±± ±±±|___|±±± ±±±|___|±±± ±±±|___|___|±±±|___|±±±|___|___|±±±|___|___ ___
  1   0   0   4   0   0   6   0   0   3  10   0   2   0   5   2   0   3   0   0 
```
