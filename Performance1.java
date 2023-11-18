import java.util.Scanner;

public class Performance1 {
    int[] mark = new int[10];
    int mode, modf, hmark, lmark, n;

    Performance1() {
        mode = 0;
        modf = 0;
        hmark = 0;
        lmark = 0;
    }

    void readMarks() {
        Scanner read = new Scanner(System.in);
        System.out.println("Enter number of marks of students you want to enter");
        n = read.nextInt();
        System.out.println("Enter marks of students");
        for (int i = 0; i < n; i++) {
            mark[i] = read.nextInt();
        }
    }

    int highestMark() {
        int hm = mark[0];
        for (int i = 1; i < n; i++) {
            if (mark[i] > hm)
                hm = mark[i];
        }
        return hm;
    }

    int leastMark() {
        int lm = mark[0];
        for (int i = 1; i < n; i++) {
            if (mark[i] < lm)
                lm = mark[i];
        }
        return lm;
    }

    int getMode() {
        int maxcount = 0;
        int value = 0;
        int count;
        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = 0; j < n; j++) {
                if (mark[j] == mark[i])
                    ++count;
            }
            if (count > maxcount) {
                maxcount = count;
                value = mark[i];
            }
        }
        return value;
    }

    int getFreqAtMode() {
        int maxcount = 0;
        int count;
        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = 1; j < n; j++) {
                if (mark[j] == mark[i])
                    ++count;
            }
            if (count > maxcount) {
                maxcount = count;
            }
        }
        return maxcount;
    }

    void display() {
        System.out.println("Highest marks: " + hmark);
        System.out.println("Lowest marks: " + lmark);
        System.out.println("Mode : " + mode);
        System.out.println("Frequency of mode: " + modf);
    }

    public static void main(String[] args) {
        Performance1 p = new Performance1();
        p.readMarks();
        p.hmark = p.highestMark();
        p.lmark = p.leastMark();
        p.mode = p.getMode();
        p.modf = p.getFreqAtMode();
        p.display();
    }
}
