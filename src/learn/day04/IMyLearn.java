package learn.day04;

public interface IMyLearn {

    public static final int NUM = 10;

    public abstract void show();

    public default void buy(){
        sayHello();
        System.out.println("我要买10个");
    }

    private void sayHello(){
        System.out.println("你好！");
    }

    public static void hit(){
        System.out.println("你要挨打");
    }
}
