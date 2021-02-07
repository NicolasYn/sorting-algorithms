import java.util.LinkedList;

public class MergeSort<T extends Comparable<T>> {

    private LinkedList<T> sequence;

    public MergeSort(Sequence<T> sequence){
        this.sequence = new LinkedList<>();
        this.sequence = sort(new LinkedList<>((sequence.getSequence())));
    }

    public LinkedList<T> sort(LinkedList<T> sequenceList){
        if(sequenceList.size() <= 1) return sequenceList;
        LinkedList<T> firstList = new LinkedList<>(sequenceList.subList(0, (sequenceList.size() / 2)));
        LinkedList<T> secondList = new LinkedList<>(sequenceList.subList(sequenceList.size() / 2, sequenceList.size()));
        return merge(sort(firstList), sort(secondList));
    }

    private LinkedList<T> merge(LinkedList<T> firstList, LinkedList<T> secondList){
        if(firstList.isEmpty()) return secondList;
        if(secondList.isEmpty()) return firstList;
        LinkedList<T> linkedList = new LinkedList<>();
        if(firstList.getFirst().compareTo(secondList.getFirst()) <= 0){
            T head = firstList.removeFirst();
            linkedList.addFirst(head);
            linkedList.addAll(merge(firstList, secondList));
        } else {
            T head = secondList.removeFirst();
            linkedList.addFirst(head);
            linkedList.addAll(merge(firstList, secondList));
        }
        return linkedList;
    }

    @Override
    public String toString() {
        return this.sequence.toString();
    }
}
