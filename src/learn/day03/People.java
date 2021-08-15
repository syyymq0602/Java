package learn.day03;

import java.util.ArrayList;
import java.util.Random;

public class People extends User{
    public People(String name, int money) {
        super(name, money);
    }

    public People() {
    }

    public void receive(ArrayList<Integer> arrayList){
        int index = new Random().nextInt(arrayList.size());
        int money = arrayList.get(index);
        super.setMoney(super.getMoney() + money);
        arrayList.remove(index);
    }
}
