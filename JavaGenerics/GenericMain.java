public class GenericMain {
    public static void main(String[] args) {
        // Print a greeting message
        System.out.println("Hello, World!");

        // Example of a method call
        int result = addNumbers(5, 7);
        System.out.println("The sum of 5 and 7 is: " + result);
    }

    // A method to add two numbers
    public static int addNumbers(int a, int b) {
        return a + b;
    }
}
