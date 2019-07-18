import java.util.concurrent.Semaphore;

class Shared{
    static int count = 0;
}

class IncThread implements Runnable {
    private String name;
    private Semaphore sem;

    public IncThread(Semaphore s, String n)
    {
        name = n;
        sem = s;
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);

        try{
            System.out.println(name + " vuole permesso");
            sem.acquire();
            System.out.println(name + " ha il permesso");
            for(int i = 0; i < 5; ++i) {
                //Incrementa di 1 count e poi stampa
                System.out.println(++Shared.count);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(name + " rilascia permesso");
        sem.release();
    }
}

//Classe che decrementa fino a 0 il valore di count

class DecThread implements Runnable {

    private String name;
    private Semaphore sem;

    public DecThread(Semaphore s, String n)
    {
        name = n;
        sem = s;
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);

        try {//Ottengo un permesso

            System.out.println(name + " vuole permesso");
            sem.acquire();System.out.println(name + " ha il permesso");

            for(int i = 0; i < 5; ++i) {//Decrementa di 1 count e poi stampa

                System.out.println(--Shared.count);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(name + " rilascia permesso");
        sem.release();
    }
}



public class Semafori {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1); // Un solo permesso

        // Thread in parallelo
        new Thread(new IncThread(sem, "Alice")).start();
        new Thread(new IncThread(sem, "Charlie")).start();
        new Thread(new DecThread(sem, "Bob")).start();

    }
}
