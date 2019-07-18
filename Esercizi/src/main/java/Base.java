import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Base {
    public static void main(String[] args) {
        /*Short y = new Short((short) 3);
        Object x = y;

        System.out.println(x);

         */


        try(DatagramSocket socket = new DatagramSocket(8080)){
            String buf = "Ciao";
            DatagramPacket packet = new DatagramPacket(buf.getBytes(), buf.getBytes().length);
// A
            String input = new String(packet.getData(), 0,
                    packet.getLength());
            System.out.println(input);
           socket.close();
        }
        catch (SocketException e)
        { System.out.print("NOOOOOO");}
    }
}


class Exam{
    public static void main(String[] args){
        String name = "PCD1819";
        Runnable r = () -> System.out.println(name);
        // name = name.toLowerCase();
        r.run();
        System.out.println("2 appello");
    }
}