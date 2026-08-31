# CCDSALG
Data Structures and Algorithms

## Major Course Output 1: Sorting Algorithms

## Project Specifications

### ID NUMBERS DATASET

▪ Once you unzip the starter files for the project, you will find a folder called data.  
This folder contains a set of files. Each file contains a set of records. Each record contains the name of a person and his/her corresponding ID number. The ID numbers are all unique, although the names may have duplicates.  

▪ Each file is in the following format:

```
n
<ID number 1> <name 1>
<ID number 2> <name 2>
<ID number 3> <name 3>
⋮
<ID number n> <name n>
```

Explanation:

The file starts with an integer n on a single line, denoting the number of records in this file.  

This is followed by exactly n lines. Each line contains the ID number (an integer from 1 to 10000000), followed by a single space, followed by the name of the person. The ID number does not have spaces or commas between them.  

The name of the person can only consist of alphabetic characters and spaces.  

▪ Each file should be treated independently of one another.  

---

## CODE STRUCTURE

▪ You are to accomplish this project using either C or Java programming language.  

The starter code given to you contains the following files:  

### For those using C:

▪ record.c: Contains a struct for a single record. You must use this for your sorting algorithm. You are NOT allowed to modify this file.  

▪ filereader.c: Contains a helper function for reading a text file containing records. You are NOT allowed to modify this file.  

▪ timer.c: Contains a helper function for getting the current time in milliseconds. You are NOT allowed to modify this file.  

▪ sortingalgorithms.c: Contains the functions for sorting records.  

▪ main.c: Contains the main function and is the main entry point of the program.  

### For those using Java:

▪ Record.java: A class to represent a single record. You are NOT allowed to modify this class.  

▪ FileReader.java: A helper class containing a method for reading in text files containing records. You are NOT allowed to modify this class.  

▪ SortingAlgorithms.java: A class containing methods for sorting records.  

▪ Main.java: A class containing the main method.  

---

## PART 1: SORTING ALGORITHMS

▪ For this section, your task is to sort the list of records by ascending ID number.  

▪ In sortingalgorithms.c / SortingAlgorithms.java, complete the implementation of insertion sort, selection sort, and merge sort. All these methods accept an array of Record structures (in the case of C) or objects (in the case of Java). Each Record object has two properties: the name and the ID number. After the functions / methods are called, it is expected that the array of records will be sorted according to the ID number. Make sure that the names are still associated with the corresponding ID numbers after sorting!  

▪ Additionally, you must implement one (1) more sorting algorithm of your choice, apart from the ones listed above. Write a method for the implementation of this sorting function in the sortingalgorithms.c / SortingAlgorithms.java class, under the designated section.  

▪ You are NOT allowed to modify any of the existing function / method headers. You are, however, free to define additional helper functions /methods as well as variables to be used by the sorting algorithms. For Java implementations, helper methods should have an access modifier of private.  

---

## PART 2: RUNNING THE ALGORITHMS

▪ Use each sorting algorithm to sort each file from the data folder. Make sure that when you call each sorting algorithm, you pass the original, unsorted list of records, not a list that has already been sorted previously.  

▪ Verify that all your sorting algorithms work correctly on all the given datasets.  

▪ Record the execution time and the empirical frequency count (number of steps) of each algorithm.  

▪ To get the execution time in C, you can use the helper function currentTimeMillis() provided in timer.c. Below is an example of how to record the execution time of a certain algorithm:



▪ record.c: Contains a struct for a single record. You must use this for your sorting algorithm. You are NOT allowed to modify this file.  

▪ filereader.c: Contains a helper function for reading a text file containing records. You are NOT allowed to modify this file.  

▪ timer.c: Contains a helper function for getting the current time in milliseconds. You are NOT allowed to modify this file.  

▪ sortingalgorithms.c: Contains the functions for sorting records.  

▪ main.c: Contains the main function and is the main entry point of the program.  

### For those using Java:

▪ Record.java: A class to represent a single record. You are NOT allowed to modify this class.  

▪ FileReader.java: A helper class containing a method for reading in text files containing records. You are NOT allowed to modify this class.  

▪ SortingAlgorithms.java: A class containing methods for sorting records.  

▪ Main.java: A class containing the main method.  

---

## PART 1: SORTING ALGORITHMS

▪ For this section, your task is to sort the list of records by ascending ID number.  

▪ In sortingalgorithms.c / SortingAlgorithms.java, complete the implementation of insertion sort, selection sort, and merge sort. All these methods accept an array of Record structures (in the case of C) or objects (in the case of Java). Each Record object has two properties: the name and the ID number. After the functions / methods are called, it is expected that the array of records will be sorted according to the ID number. Make sure that the names are still associated with the corresponding ID numbers after sorting!  

▪ Additionally, you must implement one (1) more sorting algorithm of your choice, apart from the ones listed above. Write a method for the implementation of this sorting function in the sortingalgorithms.c / SortingAlgorithms.java class, under the designated section.  

▪ You are NOT allowed to modify any of the existing function / method headers. You are, however, free to define additional helper functions /methods as well as variables to be used by the sorting algorithms. For Java implementations, helper methods should have an access modifier of private.  

---

## PART 2: RUNNING THE ALGORITHMS

▪ Use each sorting algorithm to sort each file from the data folder. Make sure that when you call each sorting algorithm, you pass the original, unsorted list of records, not a list that has already been sorted previously.  

▪ Verify that all your sorting algorithms work correctly on all the given datasets.  

▪ Record the execution time and the empirical frequency count (number of steps) of each algorithm.  

▪ To get the execution time in C, you can use the helper function currentTimeMillis() provided in timer.c. Below is an example of how to record the execution time of a certain algorithm:

```
long startTime, endTime, executionTime;
startTime = currentTimeMillis(); // store the current time
/* CALL THE ALGORITHM HERE */
endTime = currentTimeMillis(); // store the current time
executionTime = endTime - startTime;
```

To get the execution time in Java, you can use the built-in System.currentTimeMillis() function of Java. Below is an example of how to record the execution time of a certain algorithm:

```
long startTime = System.currentTimeMillis(); // store the current time
/* CALL THE ALGORITHM HERE */
long endTime = System.currentTimeMillis(); // store the current time
long executionTime = endTime - startTime;
```


## Major Course Output 2: Graphs

# Project Specifications

## SOCIAL GRAPH DATASET

- For this project, you will work on a real-world dataset collected from Facebook (Traud, Mucha & Porter, 2005).

- The data is composed of complete Facebook networks of selected American colleges and universities. It was collected as a snapshot of a single day in September 2005. In this project, you can focus only on a few selected colleges or universities.

- The data describes the structure of the social network within a given college or university. It describes which accounts are friends with each other within the network. Names of the people are anonymized.

- The social network structure, otherwise known as the social graph, can be represented as a graph, where each node represents an account. An edge is present from node `a` to node `b` if and only if `a` and `b` are friends.

- For this project, the data has been converted from its original MATLAB (`.mat`) format to a text file for easier reading.

- You are provided several sets of data of varying sizes from selected colleges and universities. If you want more datasets, you can check out this link, but you have to convert them to `.txt` by yourself.

---

## FILE FORMAT

- Data is stored as a text file. There is a separate file for each network.

- Instead of the actual names of the accounts, a unique integer identifier is given to each account. The identifiers for each file will always start from `0, 1, 2, …, n − 1`, where `n` is the number of accounts in the network.

- The first line of the file contains two integers `n` and `e`, separated by a space. `n` is the number of accounts in the network, while `e` is the number of friendships in the network.

- For this project, your code must at least be able to handle up to 5000 accounts in a single network. In the example data provided, this includes: Caltech36, Rice31, and Trinity100.

- This is followed by `e` lines, each describing a link between two accounts. Each of these lines contains two integers `a` and `b` (`0 ≤ a, b < n`). This means that `a` is friends with `b`.

- Remember that on Facebook, friendships are bi-directional. Therefore, if `a` is friends with `b`, it implies that `b` is also friends with `a`.

### Example Text File

```text
6 5
0 1
0 3
1 4
2 3
3 5
