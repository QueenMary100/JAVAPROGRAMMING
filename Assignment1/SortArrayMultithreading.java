package JAVAPROGRAMMING.Assignment1;

import java.util.Arrays;

class SortArrayRunnable implements Runnable {
    private String[] array;

    public SortArrayRunnable(String[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        Arrays.sort(array);
        System.out.println(Thread.currentThread().getName() + " - Sorted Array: " + Arrays.toString(array));
    }
}

public class SortArrayMultithreading {
    public static void main(String[] args) {
        String[] array1 = {"banana", "apple", "cherry"};
        String[] array2 = {"dog", "elephant", "cat"};

        Thread thread1 = new Thread(new SortArrayRunnable(array1), "Thread 1");
        Thread thread2 = new Thread(new SortArrayRunnable(array2), "Thread 2");

        thread1.start();
        thread2.start();
    }
}
