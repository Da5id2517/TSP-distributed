package input;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;


public class InputData {

    private Table<Integer, Integer, Integer> graph;
    private int N;


    public InputData(Matrix weight_matrix)
    {
        graph = HashBasedTable.create();
        N = weight_matrix.getN();
        for(int i=0; i < N; i++)
            for(int j=0; j < N; j++)
            {
                graph.put(i, j, weight_matrix.getData()[i][j]);
            }
    }

    public Table<Integer, Integer, Integer> getGraph()
    {
        return this.graph;
    }

    public int getN() {
        return N;
    }

    @Override
    public String toString() {
        return "InputData{" +
                "graph=" + graph +
                '}';
    }
}
