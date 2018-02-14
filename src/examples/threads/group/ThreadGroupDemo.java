package examples.threads.group;

import examples.threads.ThreadSleepCount;

public class ThreadGroupDemo {


    public static void main(String[] args){
        ThreadGroup tg = new ThreadGroup("MyThreadGroup");

        ThreadSleepCount st1 = new ThreadSleepCount(tg, "---t1", "M-t1", 500L);
        ThreadSleepCount st2 = new ThreadSleepCount(tg, "------t2", "M-t2", 500L);

        st1.start();
        st2.start();

        System.out.println("Thread group: "+tg.getName());
        tg.list();
        tg.interrupt();
        System.out.println("Thread group parent: "+tg.getParent());
        System.out.println("Thread group active count: "+tg.activeCount());
        System.out.println("Thread group active group count: "+tg.activeGroupCount());
        System.out.println("Thread group active group count: "+tg.activeGroupCount());

    }

}
