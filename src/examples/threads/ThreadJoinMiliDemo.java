package examples.threads;

public class ThreadJoinMiliDemo extends Thread{
    private long sleepPeriod = 500;

    public ThreadJoinMiliDemo(String name, long sleepPeriod){
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
        ThreadJoinMiliDemo st1 = new ThreadJoinMiliDemo("t1", 500L);
        ThreadJoinMiliDemo st2 = new ThreadJoinMiliDemo("---t2", 500L);
        ThreadJoinMiliDemo st3 = new ThreadJoinMiliDemo("------t3", 300L);
        ThreadJoinMiliDemo st4 = new ThreadJoinMiliDemo("---------t4", 300L);
        st1.start();
        try {
            st1.join(1500);
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
        st2.start();
        try {
            st2.join(1500);
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
        st3.start();
        st4.start();
    }



}
