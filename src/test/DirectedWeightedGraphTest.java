package test;

import input.DirectedWeightedGraph;
import input.Matrix;
import org.junit.Test;

import java.io.IOException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class DirectedWeightedGraphTest {

    @Test
    public void testInitialization()
    {
        Random random = new Random();
        int n = random.nextInt(10);
        Matrix test_matrix = new Matrix(n,n);
        try
        {
            test_matrix.create_symmetrical();
        }
        catch (IOException e) {e.printStackTrace();}
        DirectedWeightedGraph test_graph = new DirectedWeightedGraph(test_matrix);
        System.out.println(test_graph);
        assertEquals(test_graph.getWeight_matrix().transpose(), test_matrix);
    }
}