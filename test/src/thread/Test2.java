package src.thread;

class Singlebridge implements Runnable{
    @Override
    public synchronized void run() {
        System.out.println("---------");
        System.out.println(Thread.currentThread().getName()+"开始过桥");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("过桥完毕");
    }
}

public class Test2 {
    public static void main(String[] args) {
        Singlebridge singlebridge=new Singlebridge();
        Thread p1=new Thread(singlebridge,"a");
        Thread p2=new Thread(singlebridge,"b");
        Thread p3=new Thread(singlebridge,"c");
        Thread p4=new Thread(singlebridge,"d");
        Thread p5=new Thread(singlebridge,"e");
        Thread p6=new Thread(singlebridge,"f");
        Thread p7=new Thread(singlebridge,"g");
        Thread p8=new Thread(singlebridge,"h");
        Thread p9=new Thread(singlebridge,"i");
        Thread p10=new Thread(singlebridge,"j");
//        p1.start();
//        p2.start();
//        p3.start();
//        p4.start();
//        p5.start();
//        p6.start();
//        p7.start();
//        p8.start();
//        p9.start();
//        p10.start();
        Thread t1=new Thread(()->{
            System.out.println("shbao");
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("shbao");
            }
        });
        t1.start();
    }
}
