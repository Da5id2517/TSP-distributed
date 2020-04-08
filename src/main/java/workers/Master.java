package workers;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import input.InputData;
import input.Matrix;


public class Master {

    public static void main(String[] args) {

        Table<Integer, Integer, Integer> minimal_spanning_tree = HashBasedTable.create();
        

        InputData input = new InputData(new Matrix(5));
        for(int i=0; i < 5; i++)
        {
            TSPThread thread = new TSPThread(input.split(i, i+1));
            thread.start();
        }
    }
}
