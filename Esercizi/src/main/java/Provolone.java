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
    private int x;
    private int y;
    private int z;
    public static void main(String[] args){
        Exam4 that = new Exam4();
        Thread a = (new Thread(that)); // linea 1
        a.start();
        try{a.join();}
        catch(InterruptedException e){}
        Thread b = (new Thread(that)); // linea 1
        b.start();
    }
    public void run(){ // linea 3 - Se con synchronized e' come se usassi .run(), va in modo sequenziale
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) { }
        for(int i=0; i<10; i++){ // linea 4
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
            x++;
            y++;
            z = z+2;
            System.out.println(" x = " + x + " | y = " + y + " | z = "+ z);
        }
    }
}