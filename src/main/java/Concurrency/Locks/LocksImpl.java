package Concurrency.Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LocksImpl {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread th1 = new Thread(() ->{
            try{
                System.out.println(Thread.currentThread().getName() + " is trying to acquire the lock" );
                lock.lock();
                System.out.println(Thread.currentThread().getName()+ " has got the lock");
                System.out.println(Thread.currentThread().getName() + " is going to sleep now");
                Thread.sleep(1000);
            }catch(InterruptedException e){
                throw new RuntimeException("e");
            }finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " has released the lock");
            }
        });

        Thread th2 = new Thread(() ->{
            try{
                System.out.println(Thread.currentThread().getName() + " is trying to acquire the lock" );
                lock.lock();
                System.out.println(Thread.currentThread().getName()+ " has got the lock");
                System.out.println(Thread.currentThread().getName() + " is going to sleep now");
                Thread.sleep(1000);
            }catch(InterruptedException e){
                throw new RuntimeException("e");
            }finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " has released the lock");
            }
        });

        th1.start();
        th2.start();
    }
}
