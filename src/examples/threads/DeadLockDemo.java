package examples.threads;

public class DeadLockDemo {

    public static void main(String[] args){
        String resource1 = "Resource 1";
        String resource2 = "Resource 2";

        Thread t1 = new Thread(){
            public void run(){
                synchronized (resource1){
                    System.out.println("Thread 1 locked resource1");

                    try {Thread.sleep(100);} catch (InterruptedException e){};

                    synchronized (resource2){
                        System.out.println("Thread 1 locked resource2");
                    }
                }
            }
        };

        Thread t2 = new Thread(){
            public void run(){
                synchronized (resource2){
                    System.out.println("Thread 2 locked resource2");

                    try {Thread.sleep(100);} catch (InterruptedException e){};

                    synchronized (resource1){
                        System.out.println("Thread 2 locked resource1");
                    }
                }
            }
        };

        t1.start();
        t2.start();

    }

}
