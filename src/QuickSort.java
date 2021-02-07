public class QuickSort<T extends Comparable<T>> {

    private Sequence<T> sequence;

    public QuickSort(Sequence<T> sequence){
        this.sequence = sequence;
        sort(sequence, 0, sequence.getSize()-1);
    }

    public void sort(Sequence<T> sequenceList, int lessThan, int greatThan) {
        if(lessThan < greatThan){
            int pivot = (lessThan+greatThan)/2;
            int partition = partition(sequenceList, lessThan, pivot, greatThan);
            sort(sequenceList, lessThan, partition-1);
            sort(sequenceList, partition+1, greatThan);
        }
    }

    public int partition(Sequence<T> sequenceList, int lessThan, int pivot, int greatThan){
        sequence.permute(sequenceList, pivot, lessThan);
        pivot = lessThan;
        int wait = lessThan +1;
        int greaterThan = greatThan + 1;
        while (wait < greaterThan){
            if (sequenceList.get(wait).compareTo(sequenceList.get(pivot)) < 0){
                sequenceList.permute(sequenceList, wait, pivot);
                lessThan++;
                pivot++;
                wait++;
            } else if (sequenceList.get(wait).equals(sequenceList.get(pivot))){
                wait++;
            } else if (sequenceList.get(wait).compareTo(sequenceList.get(pivot)) > 0) {
                sequenceList.permute(sequenceList, wait, greaterThan -1);
                greaterThan--;
            }
        }
        return pivot;
    }

}
