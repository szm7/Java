class A extends Thread {
    public void print() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Christ");
        }
    }
}

class B extends Thread {
    public void print() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("University");
        }

    }
}

class test5 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.print();
        b.print();
    }
}