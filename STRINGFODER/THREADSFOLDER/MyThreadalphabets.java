package THREADSFOLDER;

public class MyThreadalphabets extends Thread {
    
    public void run(){
        System.out.println( "Printing 10 alphabetic numbers");
        char chr = 'a';
        for(int i = 1;i <= 10; i++){
          System.out.print(chr + "\t");
          chr++;  
        }
    }

    // public static void main(String[] args) {
    //     MyThreadalphabets Mta = new MyThreadalphabets();
    //     Thread th = new Thread(Mta);
    //     th.start();
    // }

}
