package com.coolF.Thread;

/**
 * @Author ChenWenFei
 * @create 2019-12-03 18:59
 */
public class ProductCustomer {

    public static void main(String[] args) {

        Depot mDepot = new Depot(100);
        Producer mPro = new Producer(mDepot);
        Customer mCus = new Customer(mDepot);

        mPro.produce(60);
        mPro.produce(120);
        mCus.consume(90);
        mCus.consume(150);
        mPro.produce(110);
    }
}

//仓库
class Depot{
    private int capacity;
    private int size;

    public Depot(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public synchronized void product(int val) {
        try {
            int left = val;
            while (left > 0) {
                while (size >= capacity)
                    wait();
                int inc = (size+left)>capacity ? (capacity-size) : left;
                size += inc;
                left -= inc;
                System.out.printf("%s produce(%3d) --> left=%3d, inc=%3d, size=%3d\n",
                                    Thread.currentThread().getName(), val, left, inc, size);
                notifyAll();
            }
        }catch (InterruptedException e) { }
    }

    public synchronized void consume(int val){
        try {
            int left = val;
            while (left > 0) {
                while (size<0)
                    wait();
                int dec = (size < left) ? size : left;
                size -= dec;
                left -= dec;
                System.out.printf("%s consume(%3d) <-- left=%3d, dec=%3d, size=%3d\n",
                                   Thread.currentThread().getName(), val, left, dec, size);
                notifyAll();
            }
        }catch (InterruptedException e) {}
    }
}

//生产者
class Producer{

    private Depot depot;

    public Producer(Depot depot) {
        this.depot = depot;
    }

    public void produce(final int val) {
        new Thread(){
            public void run(){
                depot.product(val);
            }
        }.start();
    }
}

//消费者
class Customer{

    private Depot depot;

    public Customer(Depot depot) {
        this.depot = depot;
    }

    public void consume(final int val) {
        new Thread(){
            public void run(){
                depot.consume(val);
            }
        }.start();
    }
}

