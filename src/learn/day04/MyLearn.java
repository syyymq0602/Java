package learn.day04;

public class MyLearn implements IMyLearn {

    private String name;
    private int age;

    public MyLearn(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.println("这是接口");
    }
}
