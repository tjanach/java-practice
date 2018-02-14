package examples.threads;

public class ThreadSetNameDemo extends Thread{
    private long sleepPeriod = 500;

    public ThreadSetNameDemo(String name, long sleepPeriod){
        super(name);
        this.sleepPeriod = sleepPeriod;
    }

    public void run(){
//        for (int i : IntStream.of(1,2,3).toArray()){
        for (int i : new int[] {1,2,3,4,5}){
            System.out.println(currentThread().getName() + ": thread is running..."+i);
            try {
                sleep(sleepPeriod);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args){
        ThreadSetNameDemo st1 = new ThreadSetNameDemo("t1", 500L);
        ThreadSetNameDemo st2 = new ThreadSetNameDemo("t2", 300L);
        st1.start();
        st2.start();
        try {
            currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        st1.setName("new T1 name");
        st2.setName("new T2 name");
    }

}
