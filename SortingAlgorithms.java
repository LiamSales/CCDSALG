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

    //arr 0-3 becomes first 4 elements sorted on our first pass
    //ok lowkenuinely puzzled on how its reassembled
    
}

public void mergeSort(Record[] arr, int p, int r) {

    if (p < r) {

        int q = p + (r - p) / 2;

        mergeSort(arr, p, q);
        mergeSort(arr, q + 1, r);

        merge(arr, p, q, r);
    }
}

public void heapSort() {}


}