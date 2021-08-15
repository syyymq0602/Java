package learn.day03;

import java.util.ArrayList;
import java.util.Arrays;

public class demo03 {
    public static void main(String[] args) {
        Manager manager = new Manager("群主", 100);
        People p1 = new People("p1", 0);
        People p2 = new People("p2", 20);
        People p3 = new People("p3", 10);

        var list = manager.send(40, 3);
        p1.receive(list);
        System.out.println(list);
        p2.receive(list);
        System.out.println(list);
        p3.receive(list);

        manager.show();
        p1.show();
        p2.show();
        p3.show();

        ArrayList<Integer> list1 = new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(5);
        }
        };
        System.out.println(list1);
        ArrayList<Integer> list2 = list1;
        list2.remove(1);
        System.out.println(list2);
        System.out.println(list1);
    }
}
