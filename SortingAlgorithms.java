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

    for (int i=0; i<n; i++){
        min = arr[i];
        // ⚠️ You are only tracking the minimum VALUE (reference),
        // not its INDEX. This becomes a problem for swapping.

        for (int j=i; j<n; j++){
            if (arr[j].getIdNumber() < min.getIdNumber())
                min = arr[j];
                // ⚠️ You lose where this min came from (its index)
        }

        arr[i] = min;
        // ⚠️ Problem:
        // You overwrite arr[i] with min,
        // BUT you never put the old arr[i] anywhere.

        // ⚠️ This causes:
        // - duplicates of the minimum
        // - loss of original elements
    }
}

    public void mergeSort(Record[] arr, int p, int r) {
        // TODO: Implement this sorting algorithm here.

    }

    /*
    heap sort
     */

}