interface inf1{
    static void show(){
        System.out.println("Interface 1");
    }
}
interface inf2{
    default void show(){
        System.out.println("Interface 2");
    }
}
 class test implements inf1,inf2 {
    public void show(){
        inf1.show();
        inf2.super.show();
    }
    public static void main(String[] args) {
        test t =new test();
        t.show();
    }
    
}



