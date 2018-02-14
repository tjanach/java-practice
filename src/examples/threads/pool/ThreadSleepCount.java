package examples.threads.pool;

public class ThreadSleepCount extends Thread{
    private long sleepPeriod = 500;
    private String msg;

    public ThreadSleepCount(String name, String msg, long sleepPeriod){
        super(name);
        this.sleepPeriod = sleepPeriod;
        this.msg = msg;
    }

    public void run(){
//        for (int i : IntStream.of(1,2,3).toArray()){
        System.out.println(currentThread().getName() + " thread ["+msg+"] started ...");
        for (int i : new int[] {1,2,3,4,5}){
            try {
                sleep(sleepPeriod);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(currentThread().getName() + " thread ["+msg+"] is counting..."+i);
        }
        System.out.println(currentThread().getName() + " thread ["+msg+"] finished ...");
    }

}
