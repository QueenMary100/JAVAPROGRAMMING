
// implementing the multithreadings by extending the thread class

public class MyThread extends Thread{
    @Override
    public void run(){
        for(int i = 1; i <= 10; i++){
            System.out.print(i + "\t");
        }
    }

    public static void main(String[] args) {
        MyThread th = new MyThread();
        th.start();
    }
}