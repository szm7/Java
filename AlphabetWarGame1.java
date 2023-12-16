import java.util.Scanner;

public class AlphabetWarGame1 {
    private int lftVal = 0;
    private int rgtVal = 0;

    void WordValue(String str) {
        for (int i = 0; i < str.length(); i++) {
            char lt = str.charAt(i);
            if (lt == 'w' || lt == 'p' || lt == 'b' || lt == 's') {
                if (lt == 'w') {
                    lftVal += 4;
                } else if (lt == 'p') {
                    lftVal += 3;
                } else if (lt == 'b') {
                    lftVal += 2;
                } else {
                    lftVal += 1;
                }
            } else if (lt == 'm' || lt == 'q' || lt == 'd' || lt == 'z') {
                if (lt == 'm') {
                    rgtVal += 4;
                } else if (lt == 'q') {
                    rgtVal += 3;
                } else if (lt == 'd') {
                    rgtVal += 2;
                } else {
                    rgtVal += 1;
                }
            }
        }
    }

    void display() {
        if (lftVal > rgtVal) {
            System.out.println("Left Side Wins");
        } else if (lftVal < rgtVal) {
            System.out.println("Right Side Wins");
        } else {
            System.out.println("Its a Draw");
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String inpStr = scanner.nextLine();
        AlphabetWarGame1 w1 = new AlphabetWarGame1();
        w1.WordValue(inpStr);
        w1.display();
    }
}
