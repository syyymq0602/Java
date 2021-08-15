package learn.day03;

import java.util.ArrayList;

public class Manager extends User {
    public Manager(String name, int money) {
        super(name, money);
    }

    public Manager() {
    }

    public ArrayList<Integer> send(int totalMoney, int count) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        if (super.getMoney() < totalMoney) {
            return arrayList;
        }
        super.setMoney(super.getMoney() - totalMoney);
        int average = totalMoney / count;
        int more = totalMoney % count;

        for (int i = 0; i < count - 1; i++) {
            arrayList.add(average);
        }

        arrayList.add(average + more);

        return arrayList;
    }
}
