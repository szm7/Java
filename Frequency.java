import java.util.Scanner;

public class Frequency {
    static int n;
    static int val[];


    public static void checkFrequency(int k) {
        int valFre[] = new int[n];
        int v=0;
        System.out.println(""+val.length);
        int freq;
        int maxFre = 0;
        for (int i = 0; i < n; i++) {
            freq = 0;
            for (int j = 0; j < n; j++) {
                if (val[i] == val[j]) {
                    ++freq;
                }
            }
            if (freq >= 1) {
                int flag = 0;
                for (int x = 0; x <= v; x++) {
                    if (val[i] == valFre[x])
                        flag = 1;
                }

                if (flag == 0) {
                    if (freq > maxFre || (freq == maxFre && val[i] > valFre[0])) {
                        maxFre = freq;
                        for (int x = v; x > 0; x--) {
                            valFre[x] = valFre[x - 1];
                        }
                        valFre[0] = val[i];
                    } else {
                        v++;
                        valFre[v] = val[i];
                    }
                }
            }
        }
        System.out.println("Top " + k + " elements with the highest occurrence:");
        for (int j = 0; j < k && j <= v; j++) {
            System.out.println(valFre[j]);
        }
       
        
    }

    public static void main(String args[]) {


        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of elements");
        n = input.nextInt();
        val = new int[n];

        System.out.println("Enter the elements");
        for (int i = 0; i < n; i++) {
            val[i] = input.nextInt();
        }

        System.out.println("Enter the value of K");
        int valK = input.nextInt();

        Frequency.checkFrequency(valK);
    }
}
