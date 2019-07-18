import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class StreamStuff {

    public static List<String> genElements()
    {
        return Stream.generate( () -> new String("Prova"))
                .limit(15)
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
       /* ArrayList<Double> array = new ArrayList<>();
        array.add(1.0);
        array.add(2.0);
        array.add(3.0);
        array.add(4.0);
        array.add(5.0);
        System.out.println("Elementi presenti: ");
        Spliterator<Double> s = array.spliterator();
        while(s.tryAdvance( n -> System.out.println(n)));

        */

       Spliterator<String> primo = genElements().spliterator();
       Spliterator<String> secondo = primo.trySplit();

    }
}
