package jvm_demo;

public class Demo3 {
    static A a = new A();
    static B b = new B();
//死锁
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (b) {
                        System.out.println("????");
                    }
                }
            }
        }).start();
        Thread.sleep(1000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (b) {
                    synchronized (a) {
                        System.out.println("???");
                    }
                }
            }
        }).start();
    }
}
class A {

}
class B {

}

