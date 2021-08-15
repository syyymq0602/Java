package learn.day07;

public class baozipu extends Thread {
    private baozi bz;

    public baozipu(baozi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (bz) {
                if (bz.flag) {
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (count % 2 == 0) {
                    bz.setPi("薄皮");
                    bz.setXian("三鲜");
                    count++;
                } else {
                    bz.setPi("冰皮");
                    bz.setXian("牛肉");
                    count--;
                }

                System.out.println("包子铺正在生产" + bz.getPi() + bz.getXian() + "包子");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bz.flag = true;
                bz.notify();
                System.out.println("生产好了");
            }
        }
    }
}
