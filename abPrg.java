import java.util.Scanner;

abstract class Robber {
    void RobbingClass() {
        System.out.println("MScAI&ML");
    }
    void MachineLearning() {
        System.out.println("I love MachineLearning");
    }
}

class JAVAProfessionalRobber extends Robber {
    int RowHouses(int[] arr) {
        int inimax = 0;

        for (int i = 0; i < 2; i++) {
            int temp = arr[i] + arr[i + 2];
            int maxVal = temp;
            if (maxVal > inimax)
                inimax = maxVal;
        }

        if (arr[0] + arr[arr.length - 1] > inimax)
            inimax = arr[0] + arr[arr.length - 1];
        return inimax;

    }

    int RoundHouses(int[] arr) {
        int val1 = 0;
        int val2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                val2 += arr[i];
            } else {
                val1 += arr[i];
            }
        }
        if (val1 > val2) {
            return val1;
        } else {
            return val2;
        }
    }

    int SquareHouse(int[] arr) {
        int val1 = 0;
        int val2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                val2 += arr[i];
            } else {
                val1 += arr[i];
            }

        }
        if (val1 > val2) {
            return val1;
        } else {
            return val2;
        }
    }

    void RectangleHouse() {
    }
}

class abPrg {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 4;
        int[] array = new int[n];
        System.out.print("Enter the array elements : ");
        for (int i = 0; i < n; i++) {
            array[i] = input.nextInt();
        }
        JAVAProfessionalRobber r1 = new JAVAProfessionalRobber();
        System.out.println("");
        System.out.println("--------------------------------------");
        r1.RobbingClass();
        r1.MachineLearning();
        System.out.println("--------------------------------------");
        System.out.println("Answer Circle : " + r1.RowHouses(array));
        System.out.println("--------------------------------------");
        System.out.println("Answer Square : " + r1.SquareHouse(array));
        System.out.println("--------------------------------------");
        System.out.println("Answer Circle : " + r1.RoundHouses(array));
        System.out.println("--------------------------------------");
    }
}
