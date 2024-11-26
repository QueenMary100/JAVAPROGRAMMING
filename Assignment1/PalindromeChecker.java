package JAVAPROGRAMMING.Assignment1;

public class PalindromeChecker {

    public static void main(String[] args) {
        String arrayString[] = {"madam", "hello", "radar", "world", "civic", "java"};

        System.out.println(arrayString.length);

        for (int i = 0; i < arrayString.length; i++) {
            String str = arrayString[i];
            String reversedStr = "";
            for (int j = str.length() - 1; j >= 0; j--) {
                reversedStr += str.charAt(j);
            }
            if (str.equals(reversedStr)) {
                System.out.println(str + " is a palindrome.");
            }
            else 
                System.out.println(str + " is not a palindrome.");
                
    
        }
        
        
    }
}
