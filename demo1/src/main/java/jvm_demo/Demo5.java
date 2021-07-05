package jvm_demo;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class Demo5 {
    static int _100MB = 1024 * 1024 * 10;

    public static void main(String[] args) {
        List<ByteBuffer> list = new ArrayList<>();
        int i = 0;
        try {
            while (true) {
                ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_100MB);
                list.add(byteBuffer);
                i++;
            }
        } finally {
            System.out.println(i);
        }

    }
}
