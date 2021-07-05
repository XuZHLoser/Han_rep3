package jvm_demo;

public class Demo4 {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
//        String s3 = "a" + "b";
        String s4 = s1 + s2;
//        String s5 = "ab";
        String s6 = s4.intern();
        String s7 = new String("a");
        String s8 = new String("a");
//        System.out.println(s3 == s4);
        System.out.println(s4 == s6);
//        System.out.println(s3 == s6);
//        System.out.println(s7 == s8);
        String s9 = new String("abc");
        String s10 = s9.intern();
        System.out.println(s9 == s10);


    }
}
