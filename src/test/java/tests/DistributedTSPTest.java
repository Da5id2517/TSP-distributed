package tests;

import input.InputData;
import input.Matrix;
import junit.framework.TestCase;
import workers.Master;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;


public class DistributedTSPTest extends TestCase {

    public void testDistributedComputePath()
    {
        Random random = new Random();
        int N = random.nextInt(8) + 2;
        InputData input = new InputData(new Matrix(N));
        CopyOnWriteArrayList<Integer> mst_vertices_procedural = new CopyOnWriteArrayList<>();
        CopyOnWriteArrayList<Integer> mst_vertices_distributed = new CopyOnWriteArrayList<>();
        mst_vertices_procedural.add(0);
        mst_vertices_distributed.add(0);
        Master test_example = new Master(input, mst_vertices_procedural, mst_vertices_distributed);
        CopyOnWriteArrayList<Integer> distributed_path, procedural_path;

        procedural_path = test_example.compute_procedural_path(0);

        distributed_path = test_example.compute_distributed_path();

        while(distributed_path.size() != input.getN())
        { /* */ }
        assertEquals(distributed_path, procedural_path);

    }
}