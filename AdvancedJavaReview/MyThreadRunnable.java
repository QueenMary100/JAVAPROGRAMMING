public class MyThreadRunnable implements Runnable {
    @Override
    public void run(){
        for(int i = 1; i <= 10; i++){
            System.out.print(i +"\t");
        }
    }

    public static void main(String[] args) {
        MyThreadRunnable runnable = new MyThreadRunnable();
        Thread th = new Thread(runnable, "current thread");

        System.out.println(th.getName());
       
        th.start();
        System.out.println(th.isAlive());
        System.out.println(th.isDaemon());
        System.out.println(th.isInterrupted());
    }

}
