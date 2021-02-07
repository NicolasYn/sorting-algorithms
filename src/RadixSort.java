public class RadixSort {

    private Sequence<Integer> sequence;
    private int maxLength;

    public RadixSort(Sequence<Integer> sequence){
        this.sequence = sequence;
        this.maxLength = String.valueOf(sequence.getMax()).length();
        this.sequence = sort();
    }

    public Sequence<Integer> sort(){
        Sequence<Integer> sortedSequence = new Sequence<Integer>();
        for (int i = 0; i < maxLength; i++) {
            sortedSequence = countingSort(sequence, maxLength - 1 - i);
        }
        return sortedSequence;
    }

    public Sequence<Integer> countingSort(Sequence<Integer> sequence, int indexByEnd){
        Sequence<Integer> apparitions = new Sequence<Integer>();
        for (int i = 0; i < 10; i++) {
            apparitions.getSequence().add(0);
        }

        //add 0 //if(String.valueOf(sequence.get(i)).length() <= indexByEnd);

        for (int i = 0; i < sequence.getSequence().size(); i++) {
            System.out.println("seqI " + sequence.get(i));
            int digit = String.valueOf(sequence.get(i)).charAt(indexByEnd) - 48; //48 = convert char to int
            System.out.println("digit " + digit + " length " + String.valueOf(sequence.get(i)).length() + " index " +indexByEnd);
            System.out.println("before "+apparitions);
            apparitions.set(digit, apparitions.get(digit) + 1);
            System.out.println("after "+apparitions);
        }
        return this.sequence;
    }
}

/*    Map<Character, Integer> apparitions = new HashMap<>();
        for (int i = 0; i < sequence.getSize(); i++) {
        Character digit = String.valueOf(sequence.get(i)).charAt(indexByEnd);
        if(!apparitions.containsKey(digit)) apparitions.put(digit, 1);
        else apparitions.put(digit, apparitions.get(digit)+1);}*/
