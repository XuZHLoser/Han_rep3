package jvm_demo;

import java.io.IOException;
import java.nio.ByteBuffer;

public class Demo6 {
    static int _1Gb = 1024 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_1Gb);
        System.out.println("allocate end...");
        System.in.read();
        System.out.println("start");
        byteBuffer = null;
        System.gc();
        System.in.read();
    }
}

