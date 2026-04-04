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

            while (j>=0 && arr[j].getIdNumber() > arr[j+1].getIdNumber()){

                key = arr[j];
                        //This overwrites your original "key". In insertion sort,
                        // key is usually preserved as the element being inserted.

                arr[j] = arr[j+1];
                        //This looks like a swap-style operation,
                        // not the typical "shifting" used in insertion sort.

                arr[j+1] = key;
                j--;
            }
            // In insertion sort, after shifting, you normally place key at arr[j+1].
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