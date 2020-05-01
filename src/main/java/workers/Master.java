package workers;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import input.InputData;
import input.Matrix;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;


public class Master {


    public static void main(String[] args) {
        Random random = new Random();
        int N = random.nextInt(10 - 2) + 2;
        InputData input = new InputData(new Matrix(N));
        Table<Integer, Integer, Integer> minimal_spanning_tree = HashBasedTable.create();
        CopyOnWriteArrayList<Integer> mst_vertices = new CopyOnWriteArrayList<>();
        mst_vertices.add(0);

        for(int i=0; i < N; i++)
        {
            TSPThread thread = new TSPThread(i, input.getGraph().columnMap().get(i), mst_vertices);
            thread.start();
        }

        while(mst_vertices.size() != N)
        {/* Active wait */}
        System.out.println(mst_vertices);

    }
}
