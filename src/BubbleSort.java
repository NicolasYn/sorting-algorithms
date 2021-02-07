public class BubbleSort<T extends Comparable<T>> {

    private Sequence<T> sequence;

    public BubbleSort(Sequence<T> sequence){
        this.sequence = sequence;
        sort();
    }

    public void sort(){
        for (int i = sequence.getSize()-1; i >= 1; i--) {
            for (int j = 0; j < i ; j++) {
                if(sequence.get(j).compareTo(sequence.get(j+1)) > 0 ) sequence.permute(sequence, j, j+1);
            }
        }
    }
}
