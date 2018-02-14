package examples.threads;

public class RunnableDemo implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ " thread is running...");
    }

    public static void main(String[] args){
        RunnableDemo rd1 = new RunnableDemo();
        RunnableDemo rd2 = new RunnableDemo();
        Thread t1 = new Thread(rd1, "rd1");
        Thread t2 = new Thread(rd2, "rd2");
        t1.start();
        t2.start();
    }

}
