package examples.threads.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args){
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i=1; i<=10; i++){
            ThreadSleepCount tsc = new ThreadSleepCount("tcs-"+i, "tcs-"+i, 1000);
            es.execute(tsc);
        }
        es.shutdown();
        while(!es.isTerminated()){}
        System.out.println("Work finished - all threads finished.");
    }
}
