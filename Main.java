public class Main {
    public static void main(String[] args) {

        //Use each sorting algorithm to sort each file from the data folder. 
        // Make sure that when you call each sorting algorithm, you pass the original, unsorted list of records, not a list that has already been sorted previously.

        //Verify that all your sorting algorithms work correctly on all the given datasets.

        //Record the execution time and the empirical frequency count (number of steps) of each algorithm.

        String path = ""; //outside the folder

        FileReader fileReader = new FileReader();

        Record[] arr = fileReader.readFile(path);

        int n = arr.length;

        //unsorted

        //make a copy then sort for comparisons

        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();



        sortingAlgorithms.selectionSort(arr, n);

        sortingAlgorithms.mergeSort(arr, 0, n-1);

        sortingAlgorithms.heapSort (arr, n);

        //place in a new file

        //To get the execution time in Java, you can use the built-in System.currentTimeMillis() function of Java. Below is an example of how to record the execution time of a certain algorithm:

        long startTime = System.currentTimeMillis(); // store the current time
        sortingAlgorithms.insertionSort(arr, n);
        long endTime = System.currentTimeMillis(); // store the current time
        long executionTime = endTime - startTime;

        System.err.println(" "+ executionTime);

        //modularize

    }
}
