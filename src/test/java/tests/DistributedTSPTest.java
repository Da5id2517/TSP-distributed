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
        //TODO: move to @Before
        Random random = new Random();
        int N = random.nextInt(8) + 2;
        InputData input = new InputData(new Matrix(N));
        CopyOnWriteArrayList<Integer> mst_vertices_procedural = new CopyOnWriteArrayList<>();
        CopyOnWriteArrayList<Integer> mst_vertices_distributed = new CopyOnWriteArrayList<>();
        mst_vertices_distributed.add(0);
        Master test_example = new Master(input, mst_vertices_procedural, mst_vertices_distributed);
        CopyOnWriteArrayList<Integer> distributed_path, procedural_path;

        long start_time_procedural = System.nanoTime();
        procedural_path = test_example.compute_procedural_path(0);
        long end_time_procedural = System.nanoTime();

        long start_time_distributed = System.nanoTime();
        distributed_path = test_example.compute_distributed_path();
        while(distributed_path.size() != input.getN())
        { /* */ }
        long end_time_distributed = System.nanoTime();

        long time_elapsed_procedural = (end_time_procedural - start_time_procedural)/1000;
        long time_elapsed_distributed = (end_time_distributed - start_time_distributed)/1000;
        long factor_of_acceleration = time_elapsed_procedural/ time_elapsed_distributed;

        System.out.println("Procedural execution time in milliseconds: "+ time_elapsed_procedural);
        System.out.println("Distributed execution time in milliseconds: "+ time_elapsed_distributed);
        System.out.println("Factor of acceleration is " + factor_of_acceleration);

        //TODO: split into separate tests.
        assertEquals(distributed_path, procedural_path);
        assertTrue(time_elapsed_distributed < time_elapsed_procedural);
    }
}