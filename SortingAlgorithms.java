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

        if (arr[left].getIdNumber() > arr[i].getIdNumber())
            largest = left;

        if (arr[right].getIdNumber() > arr[largest].getIdNumber())
            largest = right;



    }

//
// TODO STEPS:

//
// 3. Compare with LEFT child:
//      If left < n (valid index) AND arr[left] > arr[largest]:
//          update largest = left
//
// 4. Compare with RIGHT child:
//      If right < n AND arr[right] > arr[largest]:
//          update largest = right
//
// 5. If largest != i:
//      → Swap arr[i] with arr[largest]
//      → Recursively call heapify on index = largest
//
// WHY recursion?
// After swapping, the subtree below may now violate heap property.
//
// RESULT:
// Subtree rooted at i becomes a valid max heap.



    private void buildMaxHeap(Record[] arr, int n){

        for(int i = n/2 - 1;i<=0;i--){ //so this is all non leaf nodes
            heapify(arr, n, i);
        }
    } // is this it for building the max heap?

// Entire array now satisfies max heap property.


    private void heapSort(Record[] arr, int n){

        buildMaxHeap(arr, n);
    }
// HIGH-LEVEL IDEA:
// 1. Build max heap
// 2. Repeatedly extract the maximum (root)
// 3. Place it at the end of the array
// 4. Shrink heap and fix it again
//
// TODO STEPS:
//
// STEP 1: Build max heap
//      call buildMaxHeap(arr, n)
//
// After this:
//      arr[0] = largest element
//
//
// STEP 2: Extract elements one by one
//
// Loop from i = n-1 down to 1:
//
//   a. Swap arr[0] with arr[i]
//
//      WHY:
//      - arr[0] is the largest
//      - move it to its correct final position at the end
//
//   b. Reduce heap size:
//      new heap size = i
//
//      WHY:
//      - last element is now sorted
//      - exclude it from heap
//
//   c. Call heapify on root (index 0)
//
//      WHY:
//      - swapping broke the heap property
//      - need to restore it
//
//
// STEP 3: Continue until heap size = 1
//
// RESULT:
// Array becomes sorted in ascending order

// Heap sort = selection sort + efficient max retrieval
//
// - Instead of scanning O(n) for max:
//     heap gives max in O(1)
//     fixing heap costs O(log n)
//
// - Overall complexity:
//     O(n log n)
//
// - Sorting happens IN-PLACE (no extra arrays like merge sort)
}