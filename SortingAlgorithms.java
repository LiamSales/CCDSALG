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
                j--;
            } 
            arr[j+1] = key;
        }
    }


public void selectionSort(Record[] arr, int n) {
        
    Record min;
    int mindex = 0;

    for (int i=0; i<n; i++){
        min = arr[i];

        for (int j=i+1; j<n; j++){
            if (arr[j].getIdNumber() < min.getIdNumber()){
                min = arr[j];
                mindex=j;
            }
        }
        arr[mindex] = arr[i];
        arr[i] = min;
    }
}

    public void mergeSort(Record[] arr, int p, int r) {
        // TODO: Implement this sorting algorithm here.

    }

    /*
    heap sort
     */

}