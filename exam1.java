import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class exam1 {
    static Vector<int[]> v = new Vector<>();
    static Scanner sc = new Scanner(System.in);
    static Thread t1 = new Thread(() -> {
        synchronized (v) {
            System.out.println("Welcome to Java Programming Practical Test2");
        }
    });
    static Thread t2 = new Thread(() -> {
        synchronized (v) {
            for (int i = 0; i < v.size(); i++) {
                int[] arr1 = new int[2];
                for (int j = 0; j < 2; j++) {
                    if (v.get(i)[j] % 2 == 0) {
                        
                        for (int k = 0; k < arr1.length; k++) {
                            arr1[i] = v.get(i)[j];
                        }

                    }

                }

            }
        }
    });

    static Thread t3 = new Thread(() -> {
        synchronized (v) {
            for(int[] v1:v){
                System.out.println(v1);
            }
        }
    });
    public static void main(String[] args) throws InterruptedException {
        int choice = 0;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add Array : ");
            System.out.println("2. Execute Thread : ");
            System.out.println("3. Exit : ");

            System.out.println("Enter your choice : ");

            choice = sc.nextInt();

            switch ((choice)) {
                case 1:
                    addArray();
                    break;
                case 2:
                    t1.start();
                    t2.start();
                    t3.start();
                    t1.join();
                    t2.join();
                    t3.join();

                    break;
                default:
                    break;
            }
        } while (choice < 3);

    }

    static void addArray() {
        int[] arr = new int[2];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter the value of " + (i + 1) + " element : ");
            arr[i] = sc.nextInt();
        }
        v.add(arr);
    }
}