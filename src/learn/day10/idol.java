package learn.day10;

public class idol {
    private String name;

    public idol(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "idol{" +
                "name='" + name + '\'' +
                '}';
    }

    public void show(String s){
        System.out.println("我是父类方法");
    }
}
