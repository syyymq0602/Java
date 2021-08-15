package learn.day10;

public class Son extends idol{

    public Son(String name) {
        super(name);
    }

    @Override
    public void show(String s){
        System.out.println("我是子类方法");
    }

    public void sayFatherHello(){
        method(super::show);
    }

    public void method(Printable p){
        p.print("Q");
    }

    public void saySonHello(){
        method(this::show);
    }

    public static void main(String[] args) {
        new Son("e").sayFatherHello();
        new Son("11").saySonHello();
    }
}
