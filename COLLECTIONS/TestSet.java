package JAVAPROGRAMMING.COLLECTIONS;

import java.util.*;

public class TestSet {
    public static void main(String[] args) {
        
        //visit elements in a sorted manner using treeset
        Set<String> names = new TreeSet<>();
        //main characters

        String myarray[] ={"Romeo","Juliet","Hermecue","Draco"};

        for(String s:myarray){
            names.add(s);
        }
        //iterate through set collection ordered
        Iterator<String>iter1 = names.iterator();

        while(iter1.hasNext()){
            System.out.println(iter1.next());
        }
        //include minor characters
        String myarray2[] = {"Romeo","Juliet","Lady","Montague","Capulet","Paris","Tybalt","Mercutio","Benvolio"};
        //add characters not in myarray2

        for(String s1:myarray2){
            if(!names.contains(s1)){
                names.add(s1);
                System.out.println(s1 + "\tNot in the initial set");
            }
        }
        //display the new set
        System.out.println("Updated actors set in Romeo and Juliet");
        System.out.println(names);

    }
}
