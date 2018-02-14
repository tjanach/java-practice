package examples.threads.runtime;

import java.io.IOException;

public class RuntimeDemo {

    private int[] a = new int[1000];

    public static void main(String[] args){
        Runtime r = Runtime.getRuntime();
        System.out.println("Available processors: "+r.availableProcessors());
        System.out.println("Max memory: "+r.maxMemory()/1024/1024);
        System.out.println("Total memory: "+r.totalMemory()/1024/1024);
        System.out.println("Free memory: "+r.freeMemory()/1024/1024);
        for (int i=0; i<1000; i++){
            new RuntimeDemo();
        }
        System.out.println("Free memory after big allocation: "+r.freeMemory()/1024/1024);
        System.gc();
        System.out.println("Free memory after gc(): "+r.freeMemory()/1024/1024);
        try {
            r.exec("notepad++");
            r.exec("unknown command");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
