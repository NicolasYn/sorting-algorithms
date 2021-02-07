import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@SuppressWarnings("unchecked")
public class Sequence<T extends Comparable<T>> {

    private int size;
    private int min;
    private int max;
    private String type;
    private List<T> sequence;

    public Sequence(int size, int min, int max, String type){
        this.size = size;
        this.min = min;
        this.max = max;
        this.type = type;
        this.sequence = new ArrayList<T>();
        fillSequence();
    }

    public Sequence(){
        this.sequence = new ArrayList<>();
    }

    public void fillSequence(){
        for (int i = 0; i < size; i++) {
            sequence.add(generateRandom().findFirst().get());
        }
    }

    public Sequence<T> copy(){
        Sequence<T> copy = new Sequence<>(size, min, max, type);
        for (int i = 0; i < size; i++) {
            copy.set(i, sequence.get(i));
        }
        return copy;
    }

    public Sequence<T> permute(Sequence<T> sequencePermute, int positionFirst, int positionSecond){
        T tempValueSecond = sequencePermute.get(positionSecond);
        sequencePermute.set(positionSecond, sequencePermute.get(positionFirst));
        sequencePermute.set(positionFirst, tempValueSecond);
        return sequencePermute;
    }

    private Stream<T> generateRandom(){
        if(min <= max){
            switch (type){
                case "char":
                    return generateRandomChar();
                case "int":
                default:
                    return generateRandomInteger();
            }
        }
        else throw new IllegalArgumentException("generateRandom: min > max");
    }

    ;
    private Stream<T> generateRandomInteger(){
        Random random = new Random();
        return (Stream<T>) Stream.generate(() -> random.nextInt((max - min) + 1) + min).limit(1);
    }

    private Stream<T> generateRandomChar() {
        Random random = new Random();
        if(max <= 26) return (Stream<T>) Stream.generate(() -> (char)(random.nextInt(max) + 'a')).limit(1);
        else return (Stream<T>) Stream.generate(() -> (char)(random.nextInt(26) + 'a')).limit(1);
    }

    public T get(int index){
        return sequence.get(index);
    }

    public void set(int index, T element){
        sequence.set(index, element);
    }

    public int getSize() {
        return size;
    }

    public List<T> getSequence() {
        return sequence;
    }

    public int getMax(){
        return this.max;
    }

    @Override
    public String toString() {
        return sequence.toString();
    }
}
