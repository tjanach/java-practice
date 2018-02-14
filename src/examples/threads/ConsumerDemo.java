package examples.threads;

public class ConsumerDemo {
    int account =0;

    synchronized void deposit(int amount){
        System.out.println("Want to deposit: "+amount);
        account+=amount;
        System.out.println("Deposit completed. Account: "+account);
        notify();
    }

    synchronized void withdraw(int amount){
        System.out.println("Want to withdraw: "+amount);
        while (amount>account) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        account -= amount;
        System.out.println("Withdrawal ("+amount+") completed. Account: "+account);

    }


    public static void main(String[] args){
        ConsumerDemo consumer = new ConsumerDemo();
        new Thread(){
            public void run(){
                consumer.withdraw(500);
            }
        }.start();
        new Thread(){
            public void run(){
                consumer.withdraw(50);
            }
        }.start();
        new Thread(){
            public void run(){
                consumer.deposit(300);
            }
        }.start();
        new Thread(){
            public void run(){
                consumer.deposit(100);
            }
        }.start();
        new Thread(){
            public void run(){
                consumer.deposit(200);
            }
        }.start();
    }

}
