package com.xu.demo2;
public class TestInner {
//    static class In {
//        int i = 0;
//
//        public int getI() {
//            return i;
//        }
//
//        public void setI(int i) {
//            this.i = i;
//        }
//    }
    public interface Inner {
        public void test() ;
    }

    public static void main(String[] args) {
        int i = 0;
        Inner inner = new Inner() {

            @Override
            public void test() {
                System.out.println(i);
            }
        };
        System.out.println(i);
    }

}
