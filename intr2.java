interface A{
int x =10;
}
interface B{
   int y =100; 
}

class Helli implements A,B{
    public static void main(String[] args) {
        System.err.println(A.x);
        System.out.println(B.y);
    }
}
