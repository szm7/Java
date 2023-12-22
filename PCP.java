import java.util.Scanner;

public class PCP {

    final String[] buffer = new String[5];
    int count = 0;

    public static void main(String[] args) {
        PCP pcp = new PCP();
        Producer pos = pcp.new Producer();
        Consumer con = pcp.new Consumer();
        pos.start();
        con.start();
    }

    class Producer extends Thread {
        public void run() {
            while (true) {
                procedData();
            }
        }
    }

    class Consumer extends Thread {
        public void run() {
            while (true) {
                consumeData();
            }
        }
    }

    public void procedData() {
        synchronized (buffer) {
            if (count == buffer.length) {
                try {
                    System.out.println("-----------------");
                    System.out.println("buffer is full");
                    buffer.wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter data");
            String data = sc.nextLine();
            if ("exit".equalsIgnoreCase(data)) {
                System.exit(0);
            }
            buffer[count++] = data;
            System.out.println("Produced Data : " + data);
            buffer.notifyAll();
        }
    }

    public void consumeData() {
        synchronized (buffer) {
            if (count == 0) {
                try {
                    System.out.println("-----------------");
                    System.out.println("buffer is empty");
                    buffer.wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            String data = buffer[--count];
            System.out.println("Consumed Data : " + data);
            buffer.notifyAll();
        }
    }
}