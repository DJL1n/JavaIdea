package src.thread;


import java.util.Random;

class SellTickets implements Runnable{
    private volatile int tickets;
    private final Random random=new Random();

    public SellTickets(int tickets) {
        this.tickets = tickets;
    }

    public void f1() throws InterruptedException {
        while (tickets>0){
            synchronized (this){
                if (tickets<1){
                    break;
                }
                tickets-=1;
                System.out.println(Thread.currentThread().getName()+"目前还剩"+tickets+"张票");
            }
            Thread.sleep(random.nextInt(50));
        }
    }

    @Override
    public void run() {
        try {
            f1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Test3 {
    public static void main(String[] args) {
        SellTickets sellTickets=new SellTickets(300);
        Thread ha=new Thread(sellTickets,"哈站");
        Thread haxi=new Thread(sellTickets,"哈西站");
        Thread hadong=new Thread(sellTickets,"哈东站");
        ha.start();
        hadong.start();
        haxi.start();
    }


}
