import java.util.ArrayList;
import java.util.Collection;
import java.util.*;

public class collec {
    public static void main(String[] args) {
        // int a[]=new int[4];
        // Object b[]=new Object[4];
        // a[0]=1;
        // a[1]="Christ";
        // b[0]=1;
        // b[1]="Christ";
        Collection<Object> b = new ArrayList<>();
        b.add(10);
        b.add("Christ");
        b.add(10.7);
        // System.out.println(b);
        // Iterator i = b.iterator();
        // while(i.hasNext()){
        // System.out.println(i.next());
        // }
        for(Object i:b)
        {
            System.out.println(i);
        }
    }

}
