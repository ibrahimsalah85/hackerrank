package datastructures;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by tomcat on 5/29/17.
 */
public class RansomNote {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }
        Map<String , Integer> magazineMap = new HashMap<String , Integer>();
        for (String s : magazine){
            if(magazineMap.containsKey(s)){
                int value = magazineMap.get(s);
                value++;
                magazineMap.put(s , value);
            }
            else{
                magazineMap.put(s , 1);
            }
        }
        boolean contains = true;
        for(String s : ransom){
            if (!magazineMap.containsKey(s)){
                contains = false;
                break;
            }
            else{
                int value = magazineMap.get(s);
                value --;
                if(value == 0){
                    magazineMap.remove(s);
                }
                else{
                    magazineMap.put(s , value);
                }
            }
        }
        if(contains){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }


}
