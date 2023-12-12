interface A{
int x =10;
public void m1();  
}
class B implements A{
    int x =20;
    public void m1(){
        System.out.println("One");
    }
}
 class intr3 {
    public static void main(String[] args) {
        A a = new B();
        a.m1();
        System.out.println(a.x);
    }
}
