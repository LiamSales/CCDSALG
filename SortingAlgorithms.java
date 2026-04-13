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
        int mindex = i;

        for (int j=i+1; j<n; j++){
            if (arr[j].getIdNumber() < min.getIdNumber()){
                min = arr[j];
                mindex = j;
            }
        }

        arr[mindex] = arr[i];

        arr[i] = min;
    }
}


    private void merge(int arr[], int p, int q, int r){

    }

    public void mergeSort(Record[] arr, int p, int r) { //starting index p, ending index r

        //stop when the subarray has 1 or 0 elements, we cant split

        if (p<r){

            int q = p+(r-p)/2; //this will always be center(?)

            mergeSort(arr, p, q);
            mergeSort(arr, q+1, r); //so were just passing indices but were not giving a new array?

        }

    }


    /*
    heap sort
     */

}