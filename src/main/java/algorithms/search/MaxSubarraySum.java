package algorithms.search;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import static sun.java2d.cmm.ColorTransform.In;

public class MaxSubarraySum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long numOfQueries = Long.parseLong(in.nextLine().trim());

        for (long i=0L; i < numOfQueries; i++){
            String[] firstLine = in.nextLine().trim().split("\\s");
            int numOfElements = Integer.parseInt(firstLine[0]);
            long mod =  Long.parseLong(firstLine[1]);
            String[] secondLine = in.nextLine().trim().split("\\s");
            long[] inputArray = new long[numOfElements];
            for (int k=0; k< numOfElements; k++){
                inputArray[k]=Long.parseLong(secondLine[k]);
            }

            long maxSum = calculateMaxSum(inputArray , mod);
            System.out.println(maxSum);
        }
    }

    private static long calculateMaxSum(long[] inputArray, long mod) {

        long max = 0;
        max = Math.max(max , inputArray[0] % mod);
        long[] prefixSums =  new long[inputArray.length];
        prefixSums[0] = inputArray[0] % mod;
        for (int i=1; i< inputArray.length;i++){
            long currentNumber = inputArray[i]%mod;
            max = Math.max(max , currentNumber);
            prefixSums[i] = (currentNumber + prefixSums[i-1])%mod;
            max = Math.max(max ,  prefixSums[i]);
        }

        if(max+1 == mod || inputArray.length == 2) {
            return max;
        }

        TreeSet<Long> treeSet = new TreeSet<Long>();
        treeSet.add(prefixSums[0]);

        for (int i =2; i < prefixSums.length; i++){
            Long current = prefixSums[i];
            Long ceiling = treeSet.ceiling(current);

            if(ceiling == null){
                treeSet.add(prefixSums[i-1]);
                continue;
            }

            if(ceiling.equals(current)){
                treeSet.remove(ceiling);
                Long greaterCeiling = treeSet.ceiling(current);

                if(greaterCeiling == null){
                    treeSet.add(ceiling);
                    treeSet.add(prefixSums[i -1]);
                    continue;
                }

                treeSet.add(ceiling);
                ceiling = greaterCeiling;
            }

            long newMax = (current -ceiling + mod);
            max = Math.max(max , newMax);
            treeSet.add(prefixSums[i-1]);
        }






        return max;


    }

}