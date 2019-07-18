
class Stampa
{
    public synchronized void stampa(String msg)
    {
        System.out.print("[ " + msg);
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println(" ]");
    }
}

class ChiamaMetodo implements Runnable
{
    private Stampa s;
    public ChiamaMetodo(Stampa ss)
    {
        s = ss;
    }

    @Override
    public void run() {
        s.stampa("Astolfo");
    }
}

public class ThreadForRarted
{
    public static void main(String[] args)
    {
        Stampa s = new Stampa();
        ChiamaMetodo c1 = new ChiamaMetodo(s);
        ChiamaMetodo c2 = new ChiamaMetodo(s);
        new Thread(c1).start();
        new Thread(c2).start();
        // Senza synchronized stampa viene acceduto da più thread alla volta
    }
}

