public class Main {
    public static void main(String[] args) {

        String path = "../data/random100.txt";
        FileReader fileReader = new FileReader();
        Record[] arr = fileReader.readFile(path);

        int n = arr.length;

        Record[] insertion = arr.clone();
        Record[] selection = arr.clone();
        Record[] merge = arr.clone();
        Record[] heap = arr.clone();

        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();

        System.out.println("Insertion: " +
            measure(() -> sortingAlgorithms.insertionSort(insertion, n)));

        System.out.println("Selection: " +
            measure(() -> sortingAlgorithms.selectionSort(selection, n)));

        System.out.println("Merge: " +
            measure(() -> sortingAlgorithms.mergeSort(merge, 0, n-1)));

        System.out.println("Heap: " +
            measure(() -> sortingAlgorithms.heapSort(heap, n)));
    }

    private static long measure(Runnable algorithm) {
        long start = System.currentTimeMillis();
        algorithm.run();
        return System.currentTimeMillis() - start;
    }
}