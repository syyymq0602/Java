package learn.day04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        int num = IMyLearn.NUM;
        IMyLearn.hit();
        MyLearn my1 = new MyLearn("ss", 1);
        MyLearn my2 = new MyLearn("ss", 1);
        my1.show();
        System.out.println(num);
        System.out.println(my1.equals(my2));
        System.out.println(new Date());

        Collection<String> stringCollection = new ArrayList<>();
        stringCollection.add("1111");
        stringCollection.add("2222222");
        stringCollection.add("44444");
        stringCollection.add("3333333333333");
        Iterator<String> stringIterator = stringCollection.iterator();
        while (stringIterator.hasNext()) {
            System.out.println(stringIterator.next());
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(5);
        for (int i : arrayList) {
            System.out.println(i);
        }
        print(arrayList);
        print((ArrayList<String>) stringCollection);
    }

    private static void print(ArrayList<?> col) {
        for (int i = 0; i < col.size(); i++) {
            System.out.println(col.get(i));
        }
    }
}
