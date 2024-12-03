package JAVAPROGRAMMING.COLLECTIONS;
import java.util.*;

public class TestCollection3 {
    public static void main(String[] args) {
        //create an empty list to store strings
        LinkedList<String>Ins = new LinkedList<>();
        Collection<String>alist = new ArrayList<>();

        //to store integers
        List<Integer>lint = new LinkedList<>();

        lint.add(10);
        lint.add(15);
        lint.add(20);

        Iterator<Integer>iter = lint.iterator();

        //display elements using iterator objects

        System.out.println("Display elements in Integer list using iterator");
        while (iter.hasNext()) {
            System.out.print(iter.next() +"\t");   
        }
        System.out.println("\n");
            
        String name[] = {"Wendy","Ian","Ivy","Alinur","Merishi"};
        System.out.println("Display the elements of the array");
        for(int i = 0;i < name.length; i++){
            Ins.add(name[i]);
            
        }
            //display the elements in Ins using for each loop
        for(String a:Ins){
            System.out.println(a + "\t");
        }
        System.out.println();
        System.out.println("Display elements as a List");
        System.out.println(Ins);

        //use the List Iterator <String> listIter 
        ListIterator<String> listIter = Ins.listIterator();
        while (listIter.hasNext()) {
            System.out.print(listIter.next() + "\t");     
            System.out.println(listIter.nextIndex());       
        }

        System.out.println("\nTraversing backward:");
        while (listIter.hasPrevious()) {
            System.out.print(listIter.previous()+ "\t");
            System.out.println( listIter.previousIndex());
        }

    }

}
