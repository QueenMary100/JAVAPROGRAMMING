package JAVAPROGRAMMING.Assignment1;

import java.util.Scanner;

public class StringReplace {

    private String str1;
    private String str2;
    private String str3;

    public StringReplace(String str1, String str2, String str3) {
        this.str1 = str1;
        this.str2 = str2;
        this.str3 = str3;
    }

    public String getStr1(){
        return str1;
    }
    public String getStr2(){
        return str2;
    }
    public String getStr3(){
        return str3;
    }
    public void setStr1(String str1){
        this.str1 = str1;
    }
    public void setStr2(String str2){
        this.str2 = str2;
    }
    public void setStr3(String str3){
        this.str3 = str3;
    }

    public String replaceString(){
        return str1.replace(str2, str3);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the str1 content:");
        String str1 = sc.nextLine();
        System.out.println("Enter the str2 content:");
        String str2 = sc.nextLine();
        System.out.println("Enter the str3 content:");
        String str3 = sc.nextLine();
        StringReplace str = new StringReplace("Hello World", "World", "Java");
        System.out.println(str.replaceString());

        StringReplace str123 = new StringReplace(str1, str2, str3);
        System.out.println(str123.replaceString());
       
    }


}
