public class MyThreadSleep extends Thread{
    @Override
    public void run(){
        try {
            for(int i =1; i < 20; i++){
                System.out.println(i);
                if(i %2 == 0){
                    Thread.sleep(3000);
                }
            }
        } catch (InterruptedException e) {
            // print.Stack.Trace(e);
            System.err.println(e);
        }
    }
    //psvm for public static void main...
    public static void main(String[] args) {
        MyThreadSleep th = new MyThreadSleep();
        th.start();

        System.out.println("Executing in main method thread");
        for(int i = 20; i <= 40; i++){
            System.out.print(i + "\t");
        }
        
    }
}