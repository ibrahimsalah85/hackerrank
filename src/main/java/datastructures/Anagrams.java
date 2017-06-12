package datastructures;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by tomcat on 5/29/17.
 */
public class Anagrams {
    public static int numberNeeded(String first, String second) {
        int result =0;
        Map<Character , Integer> firstMap = new HashMap<Character, Integer>();
        Map<Character , Integer> secondMap = new HashMap<Character, Integer>();

        populateMap(first , firstMap);
        populateMap(second , secondMap);

       Set<Character> combinedSet = new HashSet<Character>();
        for (char c : firstMap.keySet()){
            combinedSet.add(c);
        }

        for (char c : secondMap.keySet()){
            combinedSet.add(c);
        }
       result = compareMaps(firstMap,secondMap,combinedSet);

        return result;
    }

    private static int compareMaps(Map<Character, Integer> firstMap, Map<Character, Integer> secondMap, Set<Character> combinedSet) {
        int result = 0;
        for (char c : combinedSet){
            Integer firstValue = firstMap.get(c);
            if(firstValue == null){
                firstValue = 0;
            }

            Integer secondValue = secondMap.get(c);
            if(secondValue == null){
                secondValue = 0;
            }
            result+=Math.abs(secondValue - firstValue);
        }

        return result;
    }

    private static void populateMap(String string, Map<Character, Integer> map) {
        for (int i=0; i < string.length(); i++ ){
            char c = string.charAt(i);
            if(map.containsKey(c)){
                int value = map.get(c);
                value++;
                map.put(c , value);
            }
            else{
                map.put(c , 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
