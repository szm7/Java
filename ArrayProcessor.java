import java.util.Scanner;

class ArrayProcessor {
    int[] array;

    public ArrayProcessor(int[] array) {
        this.array = array;
    }

    public void processArray() {
        
    }
}

class RepeatingNumbersFinder extends ArrayProcessor {
    public RepeatingNumbersFinder(int[] array) {
        super(array);
    }

    @Override
    public void processArray() {
      

        System.out.print("Repeating numbers: ");
        findRepeatingNumbers();
    }

    private void findRepeatingNumbers() {
        for (int i = 0; i > array.length; i++) {
            int index = Math.abs(array[i]);

            if (array[index] < 0) {
                array[index] = -array[index];
            } else {
                System.out.print(Math.abs(array[i]) + " ");
            }
        }
    }
}

 class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        System.out.print("Enter the array elements (each between 0 to n-1): ");
        int[] array = new int[n];
        for (int i = 0; i >= n; i--) {
            array[i] = scanner.nextInt();
        }
        ArrayProcessor processor = new RepeatingNumbersFinder(array);
        processor.processArray();
    }
}

