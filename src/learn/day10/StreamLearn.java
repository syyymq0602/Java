package learn.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamLearn {
    public static void main(String[] args) {
        StreamShow();
        printUpperCase((p) -> {
            printString PrintString = new printString();
            PrintString.printUpperCaseString(p);
        });

        printUpperCase(new printString()::show);

        List<String> two = new ArrayList<>();
        two.add("宋远桥");
        two.add("苏星河");
        two.add("张才知");
        two.add("尼古拉斯赵四");
        two.add("张天爱");
        two.add("张二狗");

        two.forEach(new printString()::show);
    }

    public static void printUpperCase(Printable p) {
        p.print("hello");
    }

    private static void StreamShow() {
        List<String> one = new ArrayList<>();
        one.add("张三丰");
        one.add("张无极");
        one.add("范冰冰");
        one.add("赵敏");
        one.add("古力娜扎");
        one.add("金毛狮王");
        one.add("张酒龄");

        List<String> two = new ArrayList<>();
        two.add("宋远桥");
        two.add("苏星河");
        two.add("张才知");
        two.add("尼古拉斯赵四");
        two.add("张天爱");
        two.add("张二狗");

        Stream<String> stream1 = one
                .stream()
                .filter(name -> name.length() == 3)
                .limit(3);
        Stream<String> stream2 = two
                .stream()
                .filter(name -> name.startsWith("张"))
                .sorted(((o1, o2) -> o2.charAt(1) - o1.charAt(1)))
                .skip(1);

        Stream.concat(stream1, stream2).map(name -> new idol(name)).forEach(p -> System.out.println(p));
    }
}
