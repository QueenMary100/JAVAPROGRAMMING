package JAVAPROGRAMMING.COLLECTIONS;

import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;

public class TestMap1 {
    public static void main(String[] args) {
        
        Map<Integer,String>mp1 = new HashMap<>();
        mp1.put(1,"Matthew");
        mp1.put(2, "Mark");
        mp1.put(46, "Luke"); 

        //display the gospels using keys
        for(Integer i: mp1.keySet()){
            System.out.println(mp1.get(i));
        }
    }
}
