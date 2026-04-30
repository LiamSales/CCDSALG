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

        int count=0;

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
        }
        // double check on paper for the for loop count

        System.out.println("Frequency count: " + count);
    }


    public void selectionSort(Record[] arr, int n) {
        
        int count=0;

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
            }

            arr[mindex] = arr[i]; count++;

            arr[i] = min;  count++;

            count++;
            count++;
        }
        
        System.out.println("Frequency count: " + count);

    }

    private void merge(Record[] arr, int p, int q, int r, int count) {

        int np = q+1 - p; count++;
        int nr = r - q; count++;

        Record[] left = new Record[np]; count++;
        Record[] right = new Record[nr]; count++;

        int j = p; count++;

        count++;
        for(int i=0; i<np; i++){
            left[i] = arr[j]; count++;
            j++; count++;
        count++;
        count++;
        }

        j = q+1; count++;

        count++;
        for(int i=0; i<nr; i++){
            right[i] = arr[j]; count++;
            j++; count++;
        
        count++;
        count++;
        }

        int i = 0; count++;
        j = 0; count++;
        int k = p; count++;

        //trace while
        while (i < np && j < nr){

            count++;
            if (left[i].getIdNumber() <= right[j].getIdNumber()){
                arr[k] = left[i];  count++;
                i++; count++;
            }

            else{
                arr[k] = right[j]; count++;
                j++; count++;
            }
            k++;  count++;  
        
        count++;
        }


        while (i < np) {
            arr[k] = left[i]; count++;
            i++; count++;
            k++; count++;

            count++;
        }

        while (j < nr) {
            arr[k] = right[j]; count++;
            j++; count++;
            k++; count++;

        count++;
        }
        
    }

    public void mergeSort(Record[] arr, int p, int r, int count) {

        count++;
        if (p < r) {

            int q = p + (r - p) / 2; count++;

            mergeSort(arr, p, q, count); count++;
            mergeSort(arr, q + 1, r, count); count++;

            merge(arr, p, q, r, count); count++;
        }

        //fix this
        //if (sorted), also it looks like these are all done independently, we need to consolidate
         System.out.println("Frequency count: " + count);

    }

    private void heapify(Record[] arr, int n, int i, int count){

        int left = 2*i + 1; count++;
        int right = 2*i + 2; count++;
        int largest = i; count++;

        Record temp; count++;

        count++; //double because 2 conditions?
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

    private void buildMaxHeap(Record[] arr, int n, int count){

        count++;
        for(int i = n/2 - 1;i >=0 ;i--){
            heapify(arr, n, i, count); count++;

            count++;
            count++;
        }
    }

    public void heapSort(Record[] arr, int n){

        int count = 0;

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
        }

        System.out.println("Frequency count: " + count);

    }

}