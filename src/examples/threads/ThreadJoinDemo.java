package examples.threads;

public class ThreadJoinDemo extends Thread{
    private long sleepPeriod = 500;

    public ThreadJoinDemo(String name, long sleepPeriod){
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
        joinTillEnd();
        joinTillSomeTime();
    }

    private static void joinTillEnd() {
        ThreadJoinDemo st1 = new ThreadJoinDemo("t1", 500L);
        ThreadJoinDemo st2 = new ThreadJoinDemo("---t2", 300L);
        ThreadJoinDemo st3 = new ThreadJoinDemo("------t3", 300L);
        st1.start();
        try {
            st1.join();
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
        st2.start();
        st3.start();
    }

    private static void joinTillSomeTime() {
        ThreadJoinDemo st1 = new ThreadJoinDemo("t4", 500L);
        ThreadJoinDemo st2 = new ThreadJoinDemo("---t5", 300L);
        ThreadJoinDemo st3 = new ThreadJoinDemo("------t6", 300L);
        st1.start();
        try {
            st1.join(1500);
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
        st2.start();
        st3.start();
    }

}
