package input;

import java.util.ArrayList;

public class DirectedWeightedGraph {

    private ArrayList<Integer> vertex;
    private Matrix weight_matrix;

    public DirectedWeightedGraph(Matrix weight_matrix)
    {
        //Assume that the matrix passed to the constructor is symmetrical.
        this.weight_matrix = weight_matrix;
        this.vertex = new ArrayList<>(weight_matrix.getN());
        for(int i = 0; i < this.weight_matrix.getN(); i++)
        {
            this.vertex.add(i);
        }
    }

    // TODO: split for graphs.
//    public DirectedWeightedGraph split(int k)
//    {
//
//    }

    public Matrix getWeight_matrix()
    {
        return this.weight_matrix;
    }

    public ArrayList<Integer> getVertex() {return this.vertex;}

    @Override
    public String toString() {
        return "{" +
                "vertex=" + vertex + "}" +
                "\nweight_matrix=" + weight_matrix;
    }
}
