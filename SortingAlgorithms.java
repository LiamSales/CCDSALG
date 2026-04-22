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

    private void merge(Record[] arr, int p, int q, int r) {

        int np = q+1 - p;
        int nr = r - q;

        Record[] left = new Record[np];
        Record[] right = new Record[nr];

        int j = p;

        for(int i=0; i<np; i++){
            left[i] = arr[j];
            j++;
        }

        j = q+1;

        for(int i=0; i<nr; i++){
            right[i] = arr[j];
            j++;
        }

        int i = 0;
        j = 0;
        int k = p;

        while (i < np && j < nr){

            if (left[i].getIdNumber() <= right[j].getIdNumber()){
                arr[k] = left[i]; 
                i++;
            }

            else{
                arr[k] = right[j];
                j++;
            }
            k++;    
        }

        while (i < np) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < nr) {
            arr[k] = right[j];
            j++;
            k++;
        }
        
    }

    public void mergeSort(Record[] arr, int p, int r) {

        if (p < r) {

            int q = p + (r - p) / 2;

            mergeSort(arr, p, q);
            mergeSort(arr, q + 1, r);

            merge(arr, p, q, r);
        }
    }

    private void heapify(Record[] arr, int n, int i){

        int left = 2*i + 1;
        int right = 2*i + 2;
        int largest = i;

        Record temp;

        // ❓ Before accessing arr[left], what condition must be true about left and n?

        if (arr[left].getIdNumber() > arr[i].getIdNumber())
            largest = left;

        // ❓ Before accessing arr[right], what condition must be true about right and n?

        // ❓ Why do we compare with arr[largest] here instead of arr[i]?

        if (arr[right].getIdNumber() > arr[largest].getIdNumber())
            largest = right;

        // ❓ If largest != i, what must we do first?

        if (largest!=i){
            temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // ❓ After swapping, which index may now violate heap property?

            // ❓ What function should be called to fix that subtree?

            // ❓ What arguments should be passed?
        }
    }

    private void buildMaxHeap(Record[] arr, int n){

        // ❓ What is the correct starting index? (non-leaf)

        // ❓ Should the loop move forward or backward?

        for(int i = n/2 - 1;i<=0;i--){
            heapify(arr, n, i);
        }
    }

    private void heapSort(Record[] arr, int n){

        buildMaxHeap(arr, n);

        // ❓ Where is the maximum element after building the heap?

        // ❓ What two indices should be swapped to place it correctly?

        // ❓ After swapping, what should the new heap size be?

        // ❓ Which index should we heapify from after the swap?

        // ❓ How many times should this process repeat?
    }

}