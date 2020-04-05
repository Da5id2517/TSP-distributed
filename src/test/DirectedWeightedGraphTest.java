package test;

import input.DirectedWeightedGraph;
import input.Matrix;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.Random;


public class DirectedWeightedGraphTest extends TestCase {

    private Matrix test_matrix;

    @Override
    public void setUp()
    {
        Random random = new Random();
        int n = random.nextInt(10);
        test_matrix = new Matrix(n,n);
        try
        {
            test_matrix.create_symmetrical();
        }
        catch (IOException e) {e.printStackTrace();}
    }


    public void testInitialization()
    {
        DirectedWeightedGraph test_graph = new DirectedWeightedGraph(test_matrix);
        assertEquals(test_graph.getWeight_matrix().transpose(), test_matrix);
        assertEquals(test_graph.getVertex().size(), test_graph.getWeight_matrix().getN());
    }


    //TODO: add teardown.
}