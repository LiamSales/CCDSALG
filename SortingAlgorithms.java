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

        // You're comparing arr[j] with arr[j+1], but insertion sort should compare arr[j] with "key".
        // arr[j+1] changes during shifting, so this condition becomes unreliable.

        while (j>=0 && arr[j].getIdNumber() > arr[j+1].getIdNumber()){

            arr[j+1] = arr[j]; 

            arr[j] = key;
            // ⚠️ Problem:
            // You are placing "key" too early, inside the loop.
            // This breaks the shifting process. Key should only be inserted AFTER shifting is done.
            j--;
            // ⚠️ Because of the line above, key keeps getting moved multiple times incorrectly
        }
        // After the loop, key should be placed at arr[j+1]
        // Right now, final placement is not guaranteed to be correct
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