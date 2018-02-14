package examples.threads;

public class ThreadSetPriorityDemo extends Thread{
    private long sleepPeriod = 500;

    public ThreadSetPriorityDemo(String name, long sleepPeriod){
        super(name);
        this.sleepPeriod = sleepPeriod;
    }

    public void run(){
//        for (int i : IntStream.of(1,2,3).toArray()){
        for (int i : new int[] {1,2,3,4,5}){
            System.out.println(currentThread().getName() + ": thread is running..."+i);
            int a =0;
            for (int j=0; j<1000000;j++){
                a++;
            }
            try {
                sleep(sleepPeriod);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args){
        ThreadSetPriorityDemo st1 = new ThreadSetPriorityDemo("t1", 3L);
        ThreadSetPriorityDemo st2 = new ThreadSetPriorityDemo("t2", 3L);
        st1.start();
        st2.start();
        st1.setPriority(1);
        st2.setPriority(10);
    }

}
