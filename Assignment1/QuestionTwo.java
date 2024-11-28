package JAVAPROGRAMMING.Assignment1;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class QuestionTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the file path name:");

        String pathName = sc.nextLine();

        int lastslashindex = pathName.lastIndexOf("\\");
        int lastdotindex = pathName.lastIndexOf(".");

        String path = (lastslashindex != -1) ? pathName.substring(0, lastslashindex): "";
        String filename = (lastdotindex != -1 && lastslashindex != -1) ? pathName.substring(lastslashindex + 1, lastdotindex): "";
        String extention = (lastdotindex != -1) ? pathName.substring(lastdotindex + 1): "";

        System.out.println("Path: " + path);
        System.out.println("Filename: " + filename);
        System.out.println("Extention: " + extention);
        sc.close();
        
     
    } 
}
