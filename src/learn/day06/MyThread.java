package learn.day06;

public class MyThread extends Thread {
    @Override
    public void run() {
        var t = Thread.currentThread();
        System.out.println(t);
    }
}
