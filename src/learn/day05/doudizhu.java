package learn.day05;

import java.util.*;

public class doudizhu {

    static String[] names = {"111","222","333"};
    public static void main(String[] args) throws RegisterException {
        // 准备牌
        ArrayList<String> poker = new ArrayList<>();
        // 存储花色
        String[] colors = {"♠","♥","♦","♣"};
        String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
        poker.add("大王");
        poker.add("小王");

        for(String color:colors){
            for(String number:numbers){
                poker.add(number + color);
            }
        }

        Collections.shuffle(poker);
        ArrayList<Person> arrayList= new ArrayList<>();
        Collections.addAll(arrayList,new Person("111",12),new Person("000",14),new Person("777",10));
        System.out.println(arrayList.get(0).age);
        arrayList.sort((o1, o2) -> o1.name.compareTo(o2.name));
        System.out.println(arrayList.get(0).age);
        Map<String,String> map = new HashMap<>();
        map.put("111","222");
        map.put("111","33");
        System.out.println(map);

        Set<String> set = new HashSet<>();
        set.add("111");
        set.add("555");
        System.out.println(set);
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入注册名:");
        String name = sc.next();
        checkName(name);
    }

    private static void checkName(String name) throws RegisterException {
        for (String s : names) {
            if (s.equals(name)){
                throw new RegisterException("此用户已存在");
            }
        }
    }
}
