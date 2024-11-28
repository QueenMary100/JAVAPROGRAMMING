package THREADSFOLDER;

public class TestThread {

    public static void main(String[] args) throws InterruptedException {
        MyThreadalphabets Mta = new MyThreadalphabets();
        MyThreadEven Mte = new MyThreadEven();
        MyThreadOdd Mto = new MyThreadOdd();

        Thread th2 = new Thread(Mto);
        Thread th1 = new Thread(Mte);
        Thread th = new Thread(Mta);
        th.start();
        // th.join();     
        th1.start();
        th2.start();
    }

}
