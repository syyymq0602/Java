package learn.day06;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyImpl implements Runnable{
    private static int ticket = 500;

    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (ticket > 0){
            lock.lock();
            if(ticket>0){
                System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票.");
                ticket--;
            }
            lock.unlock();
        }
        return;
    }

    private synchronized void payTicket(){
        if(ticket>0){
            System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票.");
            ticket--;
        }
    }
}
