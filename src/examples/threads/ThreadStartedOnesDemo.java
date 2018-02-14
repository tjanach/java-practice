package examples.threads;

public class ThreadStartedOnesDemo extends Thread{

    public ThreadStartedOnesDemo(String name){
        super(name);
    }

    public void run(){
        System.out.println(currentThread().getName()+ " thread is running...");
    }

    public static void main(String[] args){
        ThreadStartedOnesDemo st1 = new ThreadStartedOnesDemo("t1");
        st1.start();
        st1.start();
    }

}
