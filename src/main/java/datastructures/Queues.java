package datastructures;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Stack;

/**
 * Created by tomcat on 5/29/17.
 */
public class Queues {

    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.push(value);

        }



        public T peek() {
            fillOldestOnTop();
            return stackOldestOnTop.peek();
        }

        public T dequeue() {
            fillOldestOnTop();
            T result = stackOldestOnTop.pop();
            return result;
        }



        private void fillOldestOnTop() {

            if(!stackOldestOnTop.empty()){
                return;
            }
            while(!stackNewestOnTop.empty()){
                stackOldestOnTop.push(stackNewestOnTop.pop());
            }
        }
    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
