package java;

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

class Program
{
    public static void main(String[] args)
    {
        Provolone g = new Gorgonzola();
        System.out.println("Prova");
    }
}