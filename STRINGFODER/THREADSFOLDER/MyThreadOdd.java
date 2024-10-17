package THREADSFOLDER;

import java.util.random.RandomGenerator;

public class MyThreadOdd extends Thread {
    // public static RandomGenerator rand1 = new RandomGenerator() {
        
    // };
    @Override
    public void run(){
        System.out.println("Printing odd numbers between 1 and 20");

        for(int i = 1; i <= 20 ; i++){
            if(i % 2 != 0 ){
                System.out.print(i + "\t");
            }
        }
    }
    // public static void main(String[] args) {
    //     MyThreadOdd Mto = new MyThreadOdd();
    //     Thread th = new Thread(Mto);
    //     th.start();
    // }

}
