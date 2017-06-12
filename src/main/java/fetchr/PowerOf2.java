package fetchr;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by tomcat on 5/30/17.
 */
public class PowerOf2 {

    static int[] isPowerOf2(int[] arr) {
        int[] result = new int[arr.length];
        Set<Integer> numbers = new HashSet<Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (Integer.bitCount(arr[i]) == 1) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }


        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int[] res;

        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine().trim());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine().trim());
            _arr[_arr_i] = _arr_item;
        }

        res = isPowerOf2(_arr);
        for(int res_i=0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }

}
