import java.util.ArrayList;
import java.util.Vector;

 class Test12 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> v=new ArrayList<>();
        Thread t1=new Thread(()->
        {
            synchronized(v)
            {
            for(int i=0;i<=5;i++)
            {
                v.add("CHRIST"+i);
            }
        }
        });
        Thread t2=new Thread(()->
        {
            synchronized(v){
            for(int i=6;i<=10;i++)
            {
                v.add("MIT"+i);
            }
        }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(v);
       
    }
    
}
