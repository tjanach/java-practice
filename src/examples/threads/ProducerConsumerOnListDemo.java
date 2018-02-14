package examples.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumerOnListDemo {


    public static void main(String[] args) {
        int size = 4;
        List<Integer> sharedQueue = new ArrayList(size);

        int batchSize = 100;
        Thread prodThreadA = new Thread(new ProducerOnList(sharedQueue, size, 1, batchSize), "ProducerA");
        Thread prodThreadB = new Thread(new ProducerOnList(sharedQueue, size, batchSize+1,3*batchSize), "ProducerB");
        Thread consThreadA = new Thread(new ConsumerOnList(sharedQueue), "ConsumerA");
        Thread consThreadB = new Thread(new ConsumerOnList(sharedQueue), "ConsumerB");
        Thread consThreadC = new Thread(new ConsumerOnList(sharedQueue), "ConsumerC");
        prodThreadA.start();
        consThreadA.start();
        prodThreadB.start();
        consThreadB.start();
        consThreadC.start();
    }
}

class ProducerOnList implements Runnable {

    private final List<Integer> sharedQueue;
    private final int size;
    private final int from;
    private final int to;

    public ProducerOnList(List<Integer> sharedQueue, int size, int from, int to) {
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

        //wait if queue is full
        while (sharedQueue.size() == size) {
            synchronized (sharedQueue) {
                System.out.println("Queue is full " + Thread.currentThread().getName()
                        + " is waiting , size: " + sharedQueue.size());

                sharedQueue.wait();
            }
        }

        //producing element and notify consumers
        synchronized (sharedQueue) {
            sharedQueue.add(i);
            sharedQueue.notifyAll();
        }
    }
}

class ConsumerOnList implements Runnable {

    private final List<Integer> sharedQueue;

    public ConsumerOnList(List<Integer> sharedQueue) {
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
            synchronized (sharedQueue) {
                System.out.println("Queue is empty " + Thread.currentThread().getName()
                        + " is waiting , size: " + sharedQueue.size());

                sharedQueue.wait();
            }
        }

        //Otherwise consume element and notify waiting producer
        synchronized (sharedQueue) {
            sharedQueue.notifyAll();
            return (Integer) sharedQueue.remove(0);
        }
    }
}
