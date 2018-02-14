package examples.threads;

import java.util.Set;
import java.util.stream.IntStream;

public class ThreadSleepDemo extends Thread{
    private long sleepPeriod = 500;

    public ThreadSleepDemo(String name, long sleepPeriod){
        super(name);
        this.sleepPeriod = sleepPeriod;
    }

    public void run(){
//        for (int i : IntStream.of(1,2,3).toArray()){
        for (int i : new int[] {1,2,3,4,5}){
            try {
                sleep(sleepPeriod);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(currentThread().getName() + " thread is running..."+i);
        }
    }

    public static void main(String[] args){
        ThreadSleepDemo st1 = new ThreadSleepDemo("---t1", 500L);
        ThreadSleepDemo st2 = new ThreadSleepDemo("t2", 300L);
        st1.start();
        st2.start();
    }

}
