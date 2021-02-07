public class HeapSort<T extends Comparable<T>> {

    private Sequence<T> sequence;
    private Sequence<T> sortSequence;
    private int indexLast = 0;

    public HeapSort(Sequence<T> sequence){
        this.sequence = new Sequence<>();
        this.sortSequence = new Sequence<>();
        addAll(sequence);
        sort();
    }

    public void sort(){
        for (int i = 0; i < sequence.getSequence().size(); i++) {
            this.sortSequence.getSequence().add(findMax(i));
            stabilizeInvert();
        }
    }

    private void addAll(Sequence<T> sequence) {
        for (int i = 0; i < sequence.getSequence().size(); i++) {
            add(i, sequence.get(i));
        }
    }


    private void add(int index, T element){
        this.sequence.getSequence().add(element);
        stabilize(index);
    }

    private void stabilize(int index) {
        while(index > 0){
            if(getParent(index).compareTo(sequence.get(index)) <= 0){
                sequence.permute(sequence, getIndexParent(index), index);
                index = getIndexParent(index);
            } else break;
        }
    }

    private void stabilizeInvert() {
        int indexCurrent = 0;
        while(indexCurrent < sequence.getSequence().size()){
            int indexMaxChild = getMaxIndexChild(indexCurrent);
            if(sequence.get(indexCurrent).compareTo(sequence.get(indexMaxChild)) >= 0) break;
            sequence.permute(sequence, indexCurrent, indexMaxChild);
            indexCurrent = indexMaxChild;
        }
    }

    private T getParent(int index) {
        return sequence.get(getIndexParent(index));
    }

    private int getMaxIndexChild(int index){
        if(2*index +1 >= indexLast) return index;
        if(2*index + 2 >= indexLast && sequence.get(index).compareTo(sequence.get(2*index+1)) >= 0) return index;
        if(2*index + 2 >= indexLast && sequence.get(index).compareTo(sequence.get(2*index+1)) < 0) return 2*index+1;
        return sequence.get(2*index +1).compareTo(sequence.get(2*index+2)) >= 0 ? 2*index + 1 : 2*index+2;
    }

    private int getIndexParent(int index){
        return (index-1)/2;
    }

    private T findMax(int indexLastAlreadySort){
        indexLast = sequence.getSequence().size() -1 - indexLastAlreadySort;
        sequence.permute(sequence, 0, indexLast);
        return sequence.get(indexLast);
    }

    @Override
    public String toString() {
        return sequence.getSequence().toString();
    }
}
