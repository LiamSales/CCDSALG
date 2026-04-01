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
