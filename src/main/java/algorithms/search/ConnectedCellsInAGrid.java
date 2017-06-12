package algorithms.search;

import javafx.util.Pair;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by tomcat on 6/4/17.
 */
public class ConnectedCellsInAGrid {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = Integer.parseInt(in.nextLine().trim());
        int columns = Integer.parseInt(in.nextLine().trim());
        int[][] input = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            String[] rowString = in.nextLine().trim().split("\\s");
            int[] row = new int[columns];
            for (int j = 0; j < row.length; j++) {
                row[j] = Integer.parseInt(rowString[j]);
            }
            input[i] = row;


        }

        System.out.println(maxRegion(input , rows , columns));
    }

    private static int maxRegion (int[][] input ,int rows ,int columns){
        boolean [][] visited = new boolean[rows][columns];
        Pair p  = new Pair(0 ,0);

        Stack<Pair> regionStarts = new Stack<Pair>();

        regionStarts.push(p);
        int max = 0;

        while(!regionStarts.isEmpty()){

            int result = traverse (input ,  rows ,  columns ,regionStarts.pop() , visited , regionStarts ,0);
            max = Math.max(max , result);
        }
        return max;
    }

    private static int traverse(int[][] input, int rows, int columns, Pair p, boolean[][] visited, Stack<Pair> regionStarts , int accum) {
        if(visited[p.row][p.column]){
            return 0;
        }
        visited[p.row][p.column] = true;

        if(input[p.row][p.column] == 1){
            List<Pair> neighbors = getNeighbors(input, rows , columns , p);
            accum ++;
            for (Pair n : neighbors){
               accum+= traverse(input , rows , columns , n , visited , regionStarts , 0);
            }
            return accum;
        }
        if(input[p.row][p.column] == 0){
            List<Pair> neighbors = getNeighbors(input, rows , columns , p);
            for (Pair n : neighbors){
                regionStarts.push(n);
            }
            return 0;
        }
        return 0;
    }

    private static int getFromMatrix (int[][] input , int rows , int columns ,Pair p){
        if(p.row < rows && p.column < columns){
            return input[p.row][p.column];
        }
        return -1;
    }

    private static List<Pair> getNeighbors(int[][] input ,int rows , int columns ,Pair p){
        List<Pair> results = new ArrayList<Pair>();
        if(p.column - 1 > -1){
            results.add(new Pair(p.row , p.column -1));
            if(p.row -1 > -1){
                results.add(new Pair(p.row-1 , p.column-1));
            }
            if(p.row + 1 < rows){
                results.add(new Pair(p.row+1 , p.column-1));
            }
        }

        if(p.column +1 < columns){
            results.add(new Pair(p.row , p.column +1));
            if(p.row -1 > -1){
                results.add(new Pair(p.row-1 , p.column+1));
            }
            if(p.row + 1 < rows){
                results.add(new Pair(p.row+1 , p.column+1));
            }
        }
        if(p.row + 1 < rows){
            results.add(new Pair(p.row+1 , p.column));
        }
        if(p.row - 1 > -1){
            results.add(new Pair(p.row-1 , p.column));
        }

        return results;
    }

    private static class Pair{
        int row;
        int column;

        public Pair(int row , int column){
            this.row = row;
            this.column = column;
        }
    }


}
