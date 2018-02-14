package examples.threads;

public class SimpleThreadDemo extends Thread{

    public SimpleThreadDemo(String name){
        super(name);
    }

    public void run(){
        System.out.println(currentThread().getName()+ " thread is running...");
    }

    public static void main(String[] args){
        SimpleThreadDemo st1 = new SimpleThreadDemo("t1");
        SimpleThreadDemo st2 = new SimpleThreadDemo("t2");
        st1.start();
        st2.start();
    }

}
