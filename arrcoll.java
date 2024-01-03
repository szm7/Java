import java.util.ArrayList;

class A extends thread {
    public void assign() {
        for (int i = 0; i < 100; i++) {
            try {
                {
                    a[i] = i;

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class B extends thread {
    public void assign() {
         for (int i = 0; i < 100; i++)  {
            try {
               {
            b.add[i];
            
                }
        
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           
        }
}
}

public class arrcoll {
    public static void main(String[] args) {
        int a[] = new int[1000000];
        ArrayList<Integer> b = new ArrayList<Integer>();
        for (int i = 0; i < 1000000; i++) {
            a[i] = i;
            b.add(i);
        }

        long stimearrayList = System.nanoTime();
        long arrayvalueList = b.get(500000);
        long etimearrayList = System.nanoTime();
        long accesstimearrayList = etimearrayList - stimearrayList;

        long stimearray = System.nanoTime();
        long arrayvalue = a[500000];
        long etimearray = System.nanoTime();
        long accesstimearray = etimearray - stimearray;

        System.out.println("Array access time: " + accesstimearray + "ns");
        System.out.println("ArrayList access time: " + accesstimearrayList + "ns");
    }

}
