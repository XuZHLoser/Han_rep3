package jvm_demo;

import java.util.ArrayList;

public class Demo7 {
    private static int _512KB = 512 * 1024;
    private static int _1MB = 1024 * 1024;
    private static int _6MB = 6 * 1024 * 1024;
    private static int _7MB = 7 * 1024 * 1024;
    private static int _8MB = 8 * 1024 * 1024;
    /*
    查看虚拟机运行参数
    “D:\Program Files\Java\jdk-11.0.11\bin\java” -XX:+PrintFlagsFinal -version | findstr "GC"
     */
//ctrl + shift + space自动lambda补全
    public static void main(String[] args) throws InterruptedException {

            ArrayList<byte[]> list = new ArrayList<>();
            list.add(new byte[_8MB]);
            list.add(new byte[_8MB]);

    }

}
