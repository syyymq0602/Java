package learn.day01;

import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        printMethod();
        Student stu = new Student();
        stu.name = "sss";
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        System.out.println("输入数字为： " + num);
    }

    private static void printMethod() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
