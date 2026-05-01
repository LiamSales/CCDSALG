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

        long count=0;

        count++;
        for (int i=1; i<n; i++){

            Record key = arr[i]; count++;
            int j = i-1; count++;

            while (j>=0 && arr[j].getIdNumber() > key.getIdNumber()){
                arr[j+1] = arr[j]; count++;
                j--; count++;
            } 
            arr[j+1] = key; count++;

            count++;
            count++;
        } count++;

        System.out.println("Frequency count: " + count);
    }


    public void selectionSort(Record[] arr, int n) {
        
        long count=0;

        Record min; count++;

        count++;
        for (int i=0; i<n; i++){

            min = arr[i]; count++;
            int mindex = i; count++;

            count++;
            for (int j=i+1; j<n; j++){

                count++;
                if (arr[j].getIdNumber() < min.getIdNumber()){
                    min = arr[j]; count++;
                    mindex = j; count++;
                }

                count++;
                count++;
            } count++;

            arr[mindex] = arr[i]; count++;

            arr[i] = min;  count++;

            count++;
            count++;

        } count++;
        
        System.out.println("Frequency count: " + count);

    }

    private void merge(Record[] arr, int p, int q, int r, long[] count) {

        int np = q+1 - p; count[0]++;
        int nr = r - q; count[0]++;

        Record[] left = new Record[np]; count[0]++;
        Record[] right = new Record[nr]; count[0]++;

        int j = p; count[0]++;

        count[0]++;
        for(int i=0; i<np; i++){

            left[i] = arr[j]; count[0]++;
            j++; count[0]++;

        count[0]++;
        count[0]++;
        } count[0]++;

        j = q+1; count[0]++;

        count[0]++;
        for(int i=0; i<nr; i++){
            right[i] = arr[j]; count[0]++;
            j++; count[0]++;
        
        count[0]++;
        count[0]++;
        } count[0]++;

        int i = 0; count[0]++;
        j = 0; count[0]++;
        int k = p; count[0]++;

        count[0]++;
        while (i < np && j < nr){

            count[0]++;
            if (left[i].getIdNumber() <= right[j].getIdNumber()){
                arr[k] = left[i];  count[0]++;
                i++; count[0]++;
            }

            else{
                arr[k] = right[j]; count[0]++;
                j++; count[0]++;
            }
            k++;  count[0]++;  
        
        count[0]++;
        }

        count[0]++;
        while (i < np) {
            arr[k] = left[i]; count[0]++;
            i++; count[0]++;
            k++; count[0]++;

            count[0]++;
        }

        count[0]++;
        while (j < nr) {
            arr[k] = right[j]; count[0]++;
            j++; count[0]++;
            k++; count[0]++;

        count[0]++;
        }
        
    }

    public void mergeSort(Record[] arr, int n) {
        long[] count = {0};
        mergeSortHelper(arr, 0, n - 1, count);
        System.out.println("Frequency count: " + count[0]);
    }

    private void mergeSortHelper(Record[] arr, int p, int r, long[] count) {
        count[0]++;
        if (p < r) {
            int q = p + (r - p) / 2; count[0]++;
            mergeSortHelper(arr, p, q, count); count[0]++;
            mergeSortHelper(arr, q + 1, r, count); count[0]++;
            merge(arr, p, q, r, count); count[0]++;
        }
    }

    private void heapify(Record[] arr, int n, int i, long count){

        int left = 2*i + 1; count++;
        int right = 2*i + 2; count++;
        int largest = i; count++;

        Record temp; count++;

        count++;
        if (left < n && arr[left].getIdNumber() > arr[i].getIdNumber())
            largest = left; count++;

        count++;
        if (right < n && arr[right].getIdNumber() > arr[largest].getIdNumber())
            largest = right; count++;

        count++;
        if (largest!=i){

        temp = arr[i]; count++;
        arr[i] = arr[largest]; count++;
        arr[largest] = temp; count++;
        heapify(arr, n, largest, count); count++; 
    
        }
    }

    private void buildMaxHeap(Record[] arr, int n, long count){

        count++;
        for(int i = n/2 - 1;i >=0 ;i--){
            heapify(arr, n, i, count); count++;

            count++;
            count++;
        } count++;

    }

    public void heapSort(Record[] arr, int n){

        long count = 0;

        Record temp; count++;

        buildMaxHeap(arr, n, count); count++;
        
        count++;
        for (int i=n-1; i>0; i--){

            temp = arr[i]; count++;
            arr[i] = arr[0]; count++;
            arr [0] = temp; count++;

            heapify(arr, i, 0, count); count++;

            count++;
            count++;
        } count++;

        System.out.println("Frequency count: " + count);

    }

}