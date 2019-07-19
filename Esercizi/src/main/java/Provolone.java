import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;

public class Provolone {

    int x;

    public void m(float f, double d) {
        return;
    }
}


class Gorgonzola extends Provolone {

    Gorgonzola() {
        super.m((float) 1.1, 1.1);
    }

}

class A{
    private int x;

    static class B{
        public static void m()
        {return;}
    }
}

class Program
{
    public static void main(String[] args)
    {
        //Provolone g = new Gorgonzola();
        //System.out.println("Prova");
        A.B.m();
    }
}

@FunctionalInterface
interface FuncI{
    Boolean pari(Integer x);
}


class Exam2{
    public static void main(String[] args){
        FuncI impl = (Integer x) -> (x%2 == 0);
        Consumer<Boolean> c = System.out::println;
        c.accept(impl.pari(3));
    }
}

class Exam3{
    public static void main(String[] args){
        Supplier<Integer> s = () -> Stream.of("uno", "due",
                "tre")
                .mapToInt(String::length)
                .reduce(0, (len1, len2) -> len1+len2);

        System.out.println(s.get());
        Consumer<Supplier<Integer>> c = elem ->
                System.out.println(elem.get());
        c.accept(s);
    }
}

class Exam4 implements Runnable{
    private AtomicInteger x = new AtomicInteger(1);
    private AtomicInteger y = new AtomicInteger(1);
    public static void main(String[] args){
        Exam4 that = new Exam4();
        Thread a = (new Thread(that)); // linea 1
        a.start();
        Thread b = (new Thread(that)); // linea 2
        b.start();
    }
    public void run(){ // linea 3 - Se con synchronized e' come se usassi .run(), va in modo sequenziale
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) { }
        */

        for(int i=0; i<100; i++){ // linea 4

           /* try {
                Thread.sleep(500);
            } catch (InterruptedException e) { }
            */
            x.incrementAndGet();
            y.incrementAndGet();
            System.out.println(" x = " + x + " | y = " + y);
        }
    }
}