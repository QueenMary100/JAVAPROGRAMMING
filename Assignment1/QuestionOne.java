package JAVAPROGRAMMING.Assignment1;

public class QuestionOne {
    public static void main(String[] args) {
      String str = "Baseball park";
      
      System.out.println(str.indexOf("l"));
      System.out.println(str.replace("Base" , "Foot"));
      System.out.println(str.substring(8, 13));
      System.out.println(str.substring(str.indexOf("park")));
      System.out.println(str.replace("park" , "Stadium"));
    }
}
