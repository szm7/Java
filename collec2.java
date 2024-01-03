import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class collec2 {
    public static void main(String[] args) {
        //List c = new ArrayList();
        Set c = new HashSet();
        c.add("hello");
        c.add(10);
        c.add(12.80);
        c.add("hello");
        for (Object i : c) {
            System.out.println(i);
        }
        //c.remove(1);
        //c.remove(new Integer(10));
        // c.remove("hello");
        // for (Object i : c) {
        //     System.out.println(i);
        // }

    }
}
