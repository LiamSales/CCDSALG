/* This file contains implementations of sorting algorithms.
 * You are NOT allowed to modify any of the given method headers.
 */

public class SortingAlgorithms {

    /*
     * You may define additional helper functions here if you need to.
     * Make sure the helper functions have the private access modifier, as
     * they will only be used in this class.
     */

public void insertionSort(Record[] arr, int n) {

    for (int i=1; i<n; i++){

        Record key = arr[i];
        int j = i-1;

        while (j>=0 && arr[j].getIdNumber() > key.getIdNumber()){

            arr[j+1] = arr[j]; 
            
            if (j>=1)
                if (arr[j-1].getIdNumber()<=key.getIdNumber()){
                    arr[j] = key;
                }
                j--;
        }

    }

}


    public void selectionSort(Record[] arr, int n) {
        // TODO: Implement this sorting algorithm here.

    }

    public void mergeSort(Record[] arr, int p, int r) {
        // TODO: Implement this sorting algorithm here.

    }

    /*
     * Define AT LEAST ONE more sorting algorithm here, apart from the
     * ones given above. Make sure that the method accepts an array of
     * records
     */

}