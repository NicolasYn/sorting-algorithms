@SuppressWarnings("ALL")
public class Main {

    public static void main(String[] args) {
        System.out.println("Original List");
        Sequence<Integer> sequence = new Sequence<Integer>(1000, 0, 100, "int");
        System.out.println(sequence.getSequence().toString()+"\n");


        System.out.println("Bubble Sort");
        Sequence<Integer> sequenceBubble = sequence.copy();
        long startTimeBubble = System.nanoTime();
        BubbleSort bubbleSort = new BubbleSort(sequenceBubble);
        long endTimeBubble = System.nanoTime();
        System.out.println(sequenceBubble.toString());
        System.out.println("Time: " + (endTimeBubble-startTimeBubble)/1000000+ "ms \n");

        System.out.println("Merge Sort");
        Sequence<Integer> sequenceMerge = sequence.copy();
        long startTimeMerge = System.nanoTime();
        MergeSort mergeSort = new MergeSort(sequenceMerge);
        long endTimeMerge = System.nanoTime();
        System.out.println(mergeSort.toString());
        System.out.println("Time: " + (endTimeMerge-startTimeMerge)/1000000+ "ms \n");

        System.out.println("Quick Sort");
        Sequence<Integer> sequenceQuick = sequence.copy();
        long startTimeQuick = System.nanoTime();
        QuickSort quickSort = new QuickSort(sequenceQuick);
        long endTimeQuick = System.nanoTime();
        System.out.println(sequenceQuick.toString());
        System.out.println("Time: " + (endTimeQuick-startTimeQuick)/1000000+ "ms \n");


        System.out.println("Heap Sort");
        Sequence<Integer> sequenceHeap = sequence.copy();
        long startTimeHeap = System.nanoTime();
        HeapSort heapSort = new HeapSort(sequenceHeap);
        long endTimeHeap = System.nanoTime();
        System.out.println(heapSort.toString());
        System.out.println("Time: " + (endTimeHeap-startTimeHeap)/1000000+ "ms \n");

       // System.out.println("Radix Sort");
       // Sequence<Integer> sequenceRadix = sequence.copy();
       // RadixSort radixSort = new RadixSort(sequenceRadix);
       // System.out.println(sequenceRadix.toString()+"\n");

    }
}
