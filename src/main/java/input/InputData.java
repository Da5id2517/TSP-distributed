package input;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.HashMap;
import java.util.Map;


public class InputData {

    private Table<Integer, Integer, Integer> graph;


    public InputData(Matrix weight_matrix)
    {
        graph = HashBasedTable.create();
        int N = weight_matrix.getN();
        for(int i=0; i < N; i++)
            for(int j=0; j < N; j++)
            {
                graph.put(i, j, weight_matrix.getData()[i][j]);
            }
    }

    //subset of k vertices.
    public Map<Integer, Map<Integer, Integer>> split(int begin, int end)
    {
        Map<Integer, Map<Integer, Integer>> result = new HashMap<Integer, Map <Integer, Integer>>();
        for(; begin<end; begin++)
            result.put(begin, this.graph.column(begin));
        return result;
    }

    @Override
    public String toString() {
        return "InputData{" +
                "graph=" + graph +
                '}';
    }

    public static void main(String[] args) {
        //TODO: make this a test
        InputData input = new InputData(new Matrix(5));
        System.out.println(input);
        System.out.println(input.graph.column(1));
        System.out.println(input.split(3, 5));
    }
}
