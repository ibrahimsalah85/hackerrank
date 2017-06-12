package algorithms.search.Pairs;


import algorithms.search.ConnectedCellsInAGrid;

import java.io.IOException;
import java.io.InputStream;

public class Runner {
    public static void main(String[] args) throws IOException {
        InputStream is = Runner.class.getResourceAsStream("/algorithms/search/pair/input");
        System.setIn(is);
        Solution.main(args);
    }
}