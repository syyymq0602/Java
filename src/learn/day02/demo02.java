package learn.day02;

import learn.day01.Student;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class demo02 {
    public static void main(String[] args) {
        int num = new Random().nextInt(1000);
        think(num);
        Student stu = new Student();
        String str1 = "abc";
        String str2 = "abc";
        byte[] bytes = {97, 98, 99};
        String str3 = new String(bytes);
        System.out.println(str2.getBytes(StandardCharsets.UTF_8));
    }

    private static void think(int a) {
        for (int i = 0; i < 100; i++) {
            if (a % 2 == 0) {
                a /= 2;
            } else {
                a = a * 3 + 1;
            }
            System.out.println(a);
        }
    }
}
