package examples.threads;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumerOnVectorDemo {


    public static void main(String args[]) {
        Vector sharedQueue = new Vector();
        int size = 4;
        int batchSize = 100;
        Thread prodThreadA = new Thread(new Producer(sharedQueue, size, 1, batchSize), "ProducerA");
        Thread prodThreadB = new Thread(new Producer(sharedQueue, size, batchSize+1,3*batchSize), "ProducerB");
        Thread consThreadA = new Thread(new Consumer(sharedQueue), "ConsumerA");
        Thread consThreadB = new Thread(new Consumer(sharedQueue), "ConsumerB");
        Thread consThreadC = new Thread(new Consumer(sharedQueue), "ConsumerC");
        prodThreadA.start();
        consThreadA.start();
        prodThreadB.start();
        consThreadB.start();
        consThreadC.start();
    }
}

class Producer implements Runnable {

    private final Vector sharedQueue;
    private final int size;
    private final int from;
    private final int to;

    public Producer(Vector sharedQueue, int size, int from, int to) {
        this.sharedQueue = sharedQueue;
        this.size = size;
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        for (int i = from; i <= to; i++) {
            System.out.println(Thread.currentThread().getName()+" produced: " + i);
            try {
                produce(i);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerOnList.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void produce(int i) throws InterruptedException {

        while (sharedQueue.size() == size) {
            System.out.println("Queue is full " + Thread.currentThread().getName()
                    + " is waiting , size: " + sharedQueue.size());

            Thread.sleep(50);
        }
        sharedQueue.add(i);

    }
}

class Consumer implements Runnable {

    private final Vector sharedQueue;

    public Consumer(Vector sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName()+" consumed: " + consume());
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(ConsumerOnList.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private int consume() throws InterruptedException {
        //wait if queue is empty
        while (sharedQueue.isEmpty()) {
            System.out.println("Queue is empty " + Thread.currentThread().getName()
                    + " is waiting , size: " + sharedQueue.size());
            Thread.sleep(50);
        }

        return (Integer) sharedQueue.remove(0);
    }
}
