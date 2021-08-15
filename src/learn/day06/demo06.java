package learn.day06;

public class demo06 {
    public static void main(String[] args) {
        Object obj = new Object();
        new Thread(){
            @Override
            public void run(){
                synchronized (obj){
                    System.out.println("告知老板要的包子的种类和数量");
                    try {
                        obj.wait(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("吃包子咯！");
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (obj){
                    System.out.println("5s后告知顾客可以吃包子了");
                    obj.notifyAll();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run(){
                synchronized (obj){
                    System.out.println("告知老板要的包子的种类和数量");
                    try {
                        obj.wait(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("吃包子咯！");
                }
            }
        }.start();
    }
}
