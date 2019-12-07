package com.coolF.JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author ChenWenFei
 * @create 2019-12-04 10:48
 */
public class PrdctCstm {

}

class Depot{

    private int capacity;
    private int size;
    private Lock lock;
    private Condition fullCondtion;
    private Condition emptyCondtion;

    public Depot(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.lock = new ReentrantLock();
        this.fullCondtion = lock.newCondition();
        this.emptyCondtion = lock.newCondition();
    }

    public void produce(int val) {
        lock.lock();
        try {
            int left = val;
            while (left > 0) {
                while (size >= capacity)
                    fullCondtion.await();
                int inc = (size + left) > capacity ? (capacity - size) : left;
                size += inc;
                left -= inc;
                System.out.printf("%s produce(%3d) --> left=%3d, inc=%3d, size=%3d\n",
                                    Thread.currentThread().getName(), val, left, inc, size);
                emptyCondtion.signal();
            }
        }catch (InterruptedException e){}finally {
            lock.unlock();
        }
    }

    public void consume(int val) {
        lock.unlock();
        try {
            int left = val;
            while (left > 0) {
                while (size<=0)
                    emptyCondtion.await();
                int dec = (size < left) ? size : left;
                size -= dec;
                left -= dec;
                System.out.printf("%s consume(%3d) <-- left=%3d, dec=%3d, size=%3d\n",
                                    Thread.currentThread().getName(), val, left, dec, size);
                fullCondtion.signal();
            }
        }catch (InterruptedException e){} finally {
            lock.unlock();
        }
    }
}