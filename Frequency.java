import java.util.Scanner;

public class Frequency {
    static int valK;
    static int n ;
    static int val[] = new int[n];
    static int valFre[] = new int[10];
    static int[] topVal = new int[valK];
    static int[] topValFre = new int[valK];

    void input() {
        Scanner read = new Scanner(System.in);
        System.out.println("Enter the size of the Array");
        n = read.nextInt();
        int val[] = new int[n];
        
        System.out.println("Enter the Array values");
        for (int i = 0; i < n; i++) {
            val[i] = read.nextInt();
        }
        System.out.println("Enter the value of K: ");
        valK = read.nextInt();
        
    }

    public static void checkFrequency() {
        int count;
        System.err.println(""+n);
        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = 0; j < n; j++) {
                if (val[i] == val[j]) {
                    ++count;
                }
            }
            valFre[i] = count;
        }
        for (int i = 0; i < valFre.length; i++) {
            System.out.print(valFre[i] + " ");
        }
        for (int i = 0; i < valFre.length; i++) {
            int frequency = valFre[i];

            for (int j = 0; j < valK; j++) {
                if (frequency > topValFre[j]) {
                    for (int m = valK - 1; m > j; m--) {
                        topValFre[m] = topValFre[m - 1];
                        topVal[m] = topVal[m - 1];
                    }
                    topValFre[j] = frequency;
                    topVal[j] = i;
                    break;
                }
            }
        }
        System.out.println("Top " + valK + " elements based on frequency:");
        for (int i = 0; i < valK; i++) {
            System.out.println("Element: " + topVal[i] + ", Frequency: " + topValFre[i]);
        }
    }

    public static void main(String args[]) {
        Frequency f1 = new Frequency();
        f1.input();
        Frequency.checkFrequency();
    }
}
