package learn.day07;

public class ChiHuo extends Thread {
    baozi bz;

    public ChiHuo(baozi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (bz) {
                if (bz.flag == false) {
                    try {
                        bz.wait(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("吃货正在吃" + bz.getPi() + bz.getXian() + "包子");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bz.flag = false;
                bz.notify();
                System.out.println("吃货吃完了");
                System.out.println("-------------------");
            }
        }
    }
}
