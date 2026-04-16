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

    //Merge does not sort from scratch, it only combines already sorted pieces.

private void merge(Record[] arr, int p, int q, int r) {

    //We need exact sizes to create temporary arrays that hold copies

    int np = q+1 - p;
    int nr = r - q;

    Record[] left = new Record[np];
    Record[] right = new Record[nr];

    //sorry am stupid how does declaring a fixed size array work again under the hood

    // WHY: We cannot safely merge in-place because values will be overwritten.
    // These arrays act as safe copies of the data.

    // TODO 3: Copy data into temporary arrays


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


    // WHY: We want clean, sequential access during merging

    int i = 0;
    j = 0;
    int k = p; // tracks position in original array


    while (i < np && j < nr){ //ok standard stuff

        if (left[i].getIdNumber() < right[j].getIdNumber()){
            arr[k] = left[i]; //ok this makes perfect sense
            i++;
            k++;
        }

    }


    // While i < left size AND j < right size:
    //   compare left[i] and right[j] using getIdNumber()
    //   put the smaller one into arr[k]
    //   increment the pointer (i or j) depending on which was used
    //   increment k
    // WHY:
    // - Both halves are already sorted (is this because this was called when it was a smaller array?)
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


public void mergeSort(Record[] arr, int p, int r) {


    if (p < r) {

        int q = p + (r - p) / 2;

        mergeSort(arr, p, q);
        mergeSort(arr, q + 1, r);

        
        //were just holding indices then we pass all indices (all of them) to merge
        //They are sorted because of recursion, not because of merge().

        //ok new thing... when we call recursion, the remainder only happens AFTER the base case, so we start moving up here with everything starting now
        merge(arr, p, q, r);
        //so in actuality its actually a depth first search starting from the left
    }

    // we reach a single element here, no effect (empty function since void), it just goes a layer up like nothing happened
}

public void heapSort() {}


}