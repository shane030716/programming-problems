# Programming Problems

* [Anagram](#anagram)
* [BiNode Conversion](#binode-conversion)
* [Check if a Linked List is a Palindrome](#check-if-a-linked-list-is-a-palindrome)
* [Coin Change](#coin-change)
* [Delete Middle Node in a Linked List](#delete-middle-node-in-a-linked-list)
* [Edit Distance](#edit-distance)
* [Find the Intersection of two linked lists](#find-the-intersection-of-two-linked-lists)
* [Find the Kth Last Element of A Linked List](#find-the-kth-last-element-of-a-linked-list)
* [Find the Nearest Locker in the City](#find-the-nearest-locker-in-the-city)
* [Find the Number Occurring Odd Number of Times](#find-the-number-occurring-odd-number-of-times)
* [Find the Pair of Integers Whose Sum Is Equal to a Given Number in An (Sorted or Unsorted) Array](#find-the-pair-of-integers-whose-sum-is-equal-to-a-given-number-in-an-sorted-or-unsorted-array)
* [Largest Rectangle in a Histogram](#largest-rectangle-in-a-histogram)
* [Loop Detection in a Linked List](#loop-detection-in-a-linked-list)
* [Move All Zeros to End](#move-all-zeros-to-end)
* [Remove Duplicates in a Linked List](#remove-duplicates-in-a-linked-list)
* [Sum Two Linked Lists](#sum-two-linked-lists)
* [Sum of Weight of Each Path Between Two Nodes in a Graph](#sum-of-weight-of-each-path-between-two-nodes-in-a-graph)
* [Tower of Hanoi](#tower-of-hanoi)
* [Triple Step](#triple-step)
* [Volume of Histogram](#volume-of-histogram)

### [Anagram](src/Anagram.java)

You are given a string which is a valid English word. Return all the anagrams of this word that are also valid words.
Anagram meaning: a string formed by rearranging the characters of another.

Example:

Input: `"seat"`
Output: `["east", "eats", "sate", "seat", "teas"]`

Follow up:

Write a function to check if two strings are anagram of each other.


### [BiNode Conversion](src/BiNodeConversion.java)

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

### [Check if a Linked List is a Palindrome](src/CheckIfALinkedListIsAPalindrome.java)

Given a head node of a singly linked list, check if it's a palindrom.

Example: 

Input: `1 -> 2 -> 3 -> 2 -> 1`

Output: `true`

Input: `1 -> 2 -> 3 -> 4 -> 2 -> 1`

Output: `false`



### [Coin Change](src/CoinChange.java)

Given an amount of money in cents, and a list of all the different coin denominations for this currency,
find how many different ways you can make a change for this amount.
(Suppose you have unlimited supply of all the coins)

This problem could include two parts.
One is to return only the number, and the other is to return all the different ways.

Example1: 

Denominations (USA): `[25, 10, 5, 1]`
The number of ways to make exact change of ¢`12` is `4`
```
{10: 1, 1: 2} 
{5: 2, 1: 2} 
{5: 1, 1: 7} 
{1: 12}
```

This problem can also be extended for the Canadian version, where you need to round the money amount to the nearest 5 cents first

Example2:

Denominations (Canada): `[200, 100, 25, 10, 5]`
The number of ways to make exact change of ¢`10` (rounded from ¢`12`) is `2`
```
{10: 1} 
{5: 2}
```

### [Delete Middle Node in a Linked List](src/DeleteMiddleNodeOfALinkedList.java)

Given only access to a node which is in the middle of a singly linked list (not necessarily the exact middle node, any node but the last node), delete it from the linked list. Note that you don't have access to the head of the list.

Example: Suppose you are given the node `7` from the list `3 -> 5 -> 1 -> 2 -> 3 -> 7 -> 3 -> 1 -> 6 -> 4`, your function should change the list to `3 -> 5 -> 1 -> 2 -> 3 -> 3 -> 1 -> 6 -> 4`. It doesn't need to return anything.

### [Find the Intersection of two linked lists](src/FindIntersectionOfTwoLinkedLists.java)

Given two singly linked lists, find and return the intersection node. Note that the intersection is defined based on reference, not value.

Example:
```
 List1: 3 -> 1 -> 4 -> 1 ⤵︎ 
                          5 -> 9 -> 2
 List2:           3 -> 1 ⤴︎ 
```

The intersection will be 5 -> 9 -> 2

### [Edit Distance](src/EditDistance.java)

Given two strings str1 and str2 and below operations that can performed on str1. 
Find minimum number of edits (operations) required to convert ‘str1′ into ‘str2′.
* Insert
* Remove
* Replace

All of the above operations are of equal cost.

Examples

Input: `Saturday, Sunday`

Output: `3`

Input: `Canada, Canadian`

Output: `3`

Input: `edit, distance`

Output: `6`

### [Find the Kth Last Element of A Linked List](src/FindKthLastElementOfALinkedList.java)

Find the kth to last element of a singly linked list.

Example:

Input: 
* list: `3 -> 5 -> 1 -> 2 -> 3 -> 4 -> 3 -> 1 -> 6 -> 4`
* k: `3`

Output: `1`

### [Find the Nearest Locker in the City](src/FindTheNearestLockerInTheCity.java)

A city will be represented by a 2D array where each element is considered as a block in the city.
Given the width and the length of the city, and the locations of some lockers inside the city, 
which will be represented by the indexes of the array as coordinates,
generate the 2D grid so that each element specifies the distance to the closest locker.
The distance between two blocks is the sum of their horizontal and vertical distance. 
(a move in the diagonal direction is there considered a distance of 2)

Example:

Input:
```
		cityWidth: 5
		cityLength: 7
		lockerXCoordinates: [2, 4]
		lockerYCoordinates: [5, 1]
```		
Output:
```
		-----------------------------
		| 5 | 4 | 5 | 4 | 3 | 2 | 3 |
		-----------------------------
		| 4 | 3 | 4 | 3 | 2 | 1 | 2 |
		-----------------------------
		| 3 | 2 | 3 | 2 | 1 | 0 | 1 |
		-----------------------------
		| 2 | 1 | 2 | 3 | 2 | 1 | 2 |
		-----------------------------
		| 1 | 0 | 1 | 2 | 3 | 2 | 3 |
		-----------------------------
```
### [Find the Number Occurring Odd Number of Times](src/FindTheNumberOccurringOddNumberOfTimes.java)

Given an array of POSITIVE integers. All numbers occur even number of times except one number which occurs odd number of times. Find this number.

Example:

Input: `[1, 2, 3, 2, 3, 2, 1, 2, 3]`

Output: `3`   

### [Loop Detection in a Linked List](src/LoopDetectionInALinkedList.java)

Given a circular linked list, find and return the node at the beginning of the loop.

Example: 

Input: 
```
0 -> 1 -> 2 -> 3 -> 4 
               ⬆︎   ⬇︎︎
               6 <- 5
```
Output:
The `3` Node

### [Find the Pair of Integers Whose Sum Is Equal to a Given Number in An (Sorted or Unsorted) Array](src/FindThePairWhoseSumIsEqualToAGivenNumberInAnArray.java)

Given a sorted integer array and a given number, find a pair of integers from the array whose sum is equal to the given number.

Example:

Input: `{1,3,4,7,9}`, `7`

Output: `3` & `4`

How about an unsorted array?

Example:

Input: `{7,4,1,9,3}`, `7`

Output: `3` & `4`

### [Largest Rectangle in a Histogram](src/LargestRectangleInAHistogram.java)

Given a histogram represented by an array of non-negative integers,
each element in the array represents the height of each bar of the histogram.
Find the largest rectangular area formed by a number of contiguous bars.

Example 1:

Input: `{3,1,4,3,5,2,1}`

Output: `9`
```
                 ___        
         ___    |   |       
 ___    |   |___|   |       
|   |   |+++|+++|+++|___    
|   |___|+++|+++|+++|   |___
|___|___|±±±|±±±|±±±|___|___|
  3   1   4   3   5   2   1 
```
The area of the largest rectangle is `9`, which is formed between bar #`2` and #`4` with height `3`.

  
Example 2:

Input: `{3,1,4,3,5,2,2}`

Output: `10`
```
                 ___        
         ___    |   |       
 ___    |   |___|   |       
|   |   |   |   |   |___ ___
|   |___|+++|+++|+++|+++|+++|
|___|___|±±±|±±±|±±±|±±±|±±±|
  3   1   4   3   5   2   2 
```
The area of the largest rectangle is `10`, which is formed between bar #`2` and #`6` with height `2`.

### [Move All Zeros to End](src/MoveAllZerosToEnd.java)

Given an array of integers, move all elements that are zeros to the end of the array while the rest of the elements are still in their original order.

Example:

Input: `[0, 1, 3, 0, 0, 0, 2, 8, 12, 0, 4, 0, 7]`

Output: `[1, 3, 2, 8, 12, 4, 7, 0, 0, 0, 0, 0, 0]`

### [Remove Duplicates in a Linked List](src/RemoveDupsInALinkedList.java)

Remove duplicates from an unsorted linked list.

Example:

Input: `3 -> 5 -> 1 -> 2 -> 3 -> 4 -> 3 -> 1 -> 6 -> 4`

Output: `3 -> 5 -> 1 -> 2 -> 4 -> 6`

### [Sum Two Linked Lists](src/SumLinkedLists.java)

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

### [Sum of Weight of Each Path Between Two Nodes in a Graph](src/SumOfWeightOfEachPathBetweenTwoNodes.java)

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

### [Tower of Hanoi](src/TowerOfHanoi.java)

Tower of Hanoi is a mathematical puzzle. 
It consists of three poles and a number of disks of different sizes which can slide onto any poles. 
The puzzle starts with the disk in a neat stack in ascending order of size in one pole, 
the smallest at the top thus making a conical shape. 
The objective of the puzzle is to move all the disks from one pole (say ‘source pole’) 
to another pole (say ‘target pole’) with the help of third pole (say auxiliary pole).
The puzzle has the following two rules:
   1. You can’t place a larger disk onto smaller disk
   2. Only one disk can be moved at a time
   
### [Triple Step](src/TripleStep.java)

A child is running up a staircase with n steps and can hop either 1 step, 2 steps or 3 steps at a time, 
count how many possible ways the child can run up n stairs   
  
### [Volume of Histogram](src/VolumeOfHistogram.java)

Given a histogram represented by an array of non-negative integers,
each element in the array represents the height of each bar of the histogram.
Now imagine pouring water inside the histogram.
Find the maximum volume of water that the histogram can hold.
Assume all bars have the same width and the width is 1 unit

Example:

Input: `[1,0,0,0,6,0,0,3,10,1,2,3,4,5,0,3,0]`

Output: `31`

The histogram will look like
```
                                 ___                                
                                |   |                               
                                |   |                               
                                |   |                               
                 ___            |   |                               
                |   |           |   |                ___            
                |   |           |   |            ___|   |           
                |   |        ___|   |        ___|   |   |    ___    
                |   |       |   |   |    ___|   |   |   |   |   |   
 ___            |   |       |   |   |___|   |   |   |   |   |   |   
|___|___ ___ ___|___|___ ___|___|___|___|___|___|___|___|___|___|___
  1   0   0   0   6   0   0   3  10   1   2   3   4   5   0   3   0 
```  
After filling the histogram with water with its maximum capacity, it will then look like this. '+' represents the water.
```
                                 ___                                
                                |   |                               
                                |   |                               
                                |   |                               
                 ___            |   |                               
                |   |+++ +++ +++|   |                ___            
                |   |+++ +++ +++|   |+++ +++ +++ ±±±|   |           
                |   |+++ +++ ±±±|   |+++ +++ ±±±|   |   |    ___    
                |   |+++ +++|   |   |+++ ±±±|   |   |   |+++|   |   
 ___            |   |+++ +++|   |   |±±±|   |   |   |   |+++|   |   
|___|±±± ±±± ±±±|___|±±± ±±±|___|___|___|___|___|___|___|±±±|___|___
  1   0   0   0   6   0   0   3  10   1   2   3   4   5   0   3   0 
```

Note that the solution here includes the method to print out the histogram empty or filled.
