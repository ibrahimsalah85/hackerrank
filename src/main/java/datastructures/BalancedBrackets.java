package datastructures;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BalancedBrackets {
    public static boolean isBalanced(String expression) {

        char[] cArr = expression.toCharArray();
        Stack<Character> s = new Stack<Character>();
        for (char c : cArr){
            if(s.empty() && (c == '}' || c == ']' || c == ')')){
                return false;
            }
            if(c == '{' || c == '[' || c == '('){
                s.push(c);
            }
            else if(c == '}' || c == ']' || c == ')'){
                if ((c == '}' && s.peek() == '{') ||
                     (c == ')' && s.peek() == '(') ||
                      (c == ']' && s.peek() == '[')){
                    s.pop();
                }
            }
            else {
                return false;
            }
        }
        return s.empty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
