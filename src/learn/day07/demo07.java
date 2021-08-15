package learn.day07;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Set;

public class demo07 {
    public static void main(String[] args) throws IOException {
        long sum = b(20);
        System.out.println(sum);

        FileOutputStream fos = new FileOutputStream("a.txt",true);
        BufferedOutputStream bos = new BufferedOutputStream(fos,1024);
        bos.write("好".getBytes(StandardCharsets.UTF_8));
        bos.close();
//        fos.close();

        Properties properties = new Properties();
        properties.setProperty("111","aaa");
        properties.setProperty("222","bbb");
        properties.setProperty("333","ccc");

        Set<String> set = properties.stringPropertyNames();

        for (String key : set) {
            System.out.println(properties.getProperty(key));
        }

    }

    public static void food(Cook cook) {
        cook.makeFood();
    }

    private static long b(int n) {
        if (n == 1)
            return 1;
        return n * b(n - 1);
    }
}
