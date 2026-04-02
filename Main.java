public class Main {
    public static void main(String[] args) {

        // TODO: Use this method to run your experiments.

        String path = "";

        FileReader fileReader = new FileReader();

        Record[] arr = fileReader.readFile(path);

        int n = arr.length;

        //unsorted

        //make a copy then sort for comparisons

        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();

        sortingAlgorithms.insertionSort(arr, n);

        //place in a new file

    }
}
