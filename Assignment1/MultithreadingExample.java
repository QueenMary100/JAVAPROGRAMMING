package JAVAPROGRAMMING.Assignment1;

class EvenNumberThread extends Thread {
    @Override
    public void run() {
        System.out.println("Even numbers between 20 and 100:");
        for (int i = 20; i <= 100; i += 2) {
            System.out.println(i);
        }
    }
}

class DivisibleByThreeThread extends Thread {
    @Override
    public void run() {
        System.out.println("Numbers divisible by 3 between 10 and 100:");
        for (int i = 10; i <= 100; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }
    }
}

public class MultithreadingExample {
    public static void main(String[] args) {
        Thread evenThread = new EvenNumberThread();
        Thread divisibleByThreeThread = new DivisibleByThreeThread();

        evenThread.start();
        divisibleByThreeThread.start();
    }
}
