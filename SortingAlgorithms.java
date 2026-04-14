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

    
 // ===================== MERGE FUNCTION =====================

private void merge(Record[] arr, int p, int q, int r) {

    // TODO 1: Determine sizes of the two subarrays
    // Left subarray is from p to q
    // Right subarray is from q+1 to r
    // Size formula:
    // left size  = q - p + 1
    // right size = r - q
    // WHY: We need exact sizes to create temporary arrays that hold copies

    // TODO 2: Create temporary arrays
    // Create two arrays:
    // Record[] left
    // Record[] right
    // WHY: We cannot safely merge in-place because values will be overwritten.
    // These arrays act as safe copies of the data.

    // TODO 3: Copy data into temporary arrays
    // Copy arr[p ... q] into left[]
    // Copy arr[q+1 ... r] into right[]
    // IMPORTANT:
    // - left starts at index 0 but corresponds to arr[p]
    // - right starts at index 0 but corresponds to arr[q+1]
    // WHY: We want clean, sequential access during merging

    // TODO 4: Initialize pointers
    // i = 0 → tracks position in left[]
    // j = 0 → tracks position in right[]
    // k = p → tracks position in original array
    // WHY:
    // - i and j move through temp arrays
    // - k writes back into original array in correct position

    // TODO 5: Merge while both arrays have elements
    // While i < left size AND j < right size:
    //   compare left[i] and right[j] using getIdNumber()
    //   put the smaller one into arr[k]
    //   increment the pointer (i or j) depending on which was used
    //   increment k
    // WHY:
    // - Both halves are already sorted
    // - We are combining them into a single sorted segment

    // TODO 6: Copy remaining elements from left[]
    // If i < left size:
    //   copy all remaining left[i...] into arr[k...]
    // WHY:
    // - If right[] is exhausted first, left[] still has elements
    // - These are already sorted, so just append

    // TODO 7: Copy remaining elements from right[]
    // If j < right size:
    //   copy all remaining right[j...] into arr[k...]
    // WHY:
    // - Same logic as above, but for the right side

    // FINAL RESULT:
    // arr[p ... r] is now fully sorted
}



// ===================== MERGE SORT FUNCTION =====================

public void mergeSort(Record[] arr, int p, int r) {

    // TODO 1: Base case
    // If p >= r, stop recursion
    // WHY:
    // - A subarray of size 1 (or 0) is already sorted
    // - Prevents infinite recursion

    if (p < r) {

        // TODO 2: Find middle index
        // q = p + (r - p) / 2
        // WHY:
        // - Splits array into two roughly equal halves
        // - This version avoids integer overflow (best practice)

        int q = p + (r - p) / 2;

        // TODO 3: Recursively sort left half
        // mergeSort(arr, p, q)
        // WHY:
        // - This reduces the problem into smaller subproblems
        // - Eventually reaches size 1 arrays

        mergeSort(arr, p, q);

        // TODO 4: Recursively sort right half
        // mergeSort(arr, q+1, r)
        // WHY:
        // - Same idea, but for the second half

        mergeSort(arr, q + 1, r);

        // TODO 5: Merge the two sorted halves
        // merge(arr, p, q, r)
        // WHY:
        // - At this point:
        //     arr[p ... q] is sorted
        //     arr[q+1 ... r] is sorted
        // - This step combines them into one sorted segment

        merge(arr, p, q, r);
    }
}

    /*
    heap sort
     */

}