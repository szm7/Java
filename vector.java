import java.util.*;
import java.util.Vector;

public class vector {
    public static void main(String[] args) {
        // Vector<Integer> v = new Vector<>(100,5);
        // System.out.println("Initial Capacity : "+v.capacity());
        // System.out.println("Initial Size : "+v.size());
        // for(int i =0;i<=100;i++){
        // v.add(i);
        // }
        // System.err.println(v);
        // System.out.println("Initial Capacity : "+v.capacity());
        // System.out.println("Initial Size : "+v.size());
        Object [] obj = new Object[]{"R","S","T"};

        Vector<String> v1 = new Vector<>();
        Vector<String> v2 = new Vector<>();
        Vector v3 = new Vector (Arrays.asList(obj));

        System.out.println(v3.capacity());
        System.out.println("Vector 3 : " + v3);
        v3.add(3, "MIT");
        System.out.println(v3.capacity());
        System.out.println("Vector 3 : " + v3);

        // for (int i = 0; i < 5; i++) {
        //     v1.add("CHTIST" + i);
        // }
        // for (int j = 0; j < v1.size(); j++) {
        //     v2.add(v1.get(j));
        // }
        // System.out.println("Vector 1 : " + v1);
        // System.out.println("Vector 2 : " + v2);
        // System.out.println(v1.containsAll(v2));

        // v1.add(1, "MIT");
        // v2.add(3, "MIT");

        // System.out.println("Vector 1 : " + v1);
        // System.out.println("Vector 2 : " + v2);

        // System.out.println(v1.equals(v2));
        // System.out.println(v1.containsAll(v2));
        // v1.remove(1);
        // System.out.println("Vector 1 after removing element at index 1 : "+v1);
    }

}
