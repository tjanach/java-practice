package examples.threads;

public class ThreadRunCallDemo extends Thread{
    private long sleepPeriod = 500;

    public ThreadRunCallDemo(String name, long sleepPeriod){
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
        ThreadRunCallDemo st1 = new ThreadRunCallDemo("t1", 500L);
        ThreadRunCallDemo st2 = new ThreadRunCallDemo("t2", 300L);
        st1.run();
        st2.run();
    }

}
