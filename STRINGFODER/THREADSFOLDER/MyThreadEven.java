package THREADSFOLDER;

public class MyThreadEven implements Runnable {

    public void run(){
        System.out.println( "Printing even numbers between 20 and 40");
        for(int i = 21;i <= 40; i++){
            if(i % 2 == 0){
                System.out.print(i + "\t");
            }
        }
    }

    // public static void main(String[] args) {
    //     MyThreadEven Mte = new MyThreadEven();
    //     Thread th = new Thread(Mte);
    //     th.start();
    // }

}
