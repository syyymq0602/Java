package learn.day06;

public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(name + "---->" + (i + 1));
        }
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
