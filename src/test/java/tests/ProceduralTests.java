package tests;

import input.InputData;
import input.Matrix;
import junit.framework.TestCase;
import workers.Procedural;

import java.util.ArrayList;
import java.util.Random;

public class ProceduralTests extends TestCase {

    private int factorial(int N)
    {
        if(N == 1 || N == 0)
            return 1;
        else
            return N*factorial(N-1);
    }

    //TODO: how to bundle tests into a suite. add path weight computing tests.

    public void testPathPermutation()
        {
            Random random = new Random();
            int N = random.nextInt(2) + 4;
            InputData input = new InputData(new Matrix(N));
            Procedural test_data = new Procedural(input);
            test_data.load_paths_with_weight();
            ArrayList<int[]> computations_found = test_data.getPath_list();

//            TODO: move to separate test.
//            int[] test_path = computations_found.get(0);
//            System.out.println("First path length is: " + test_data.compute_path_weight(test_path));

            for(int[] array: computations_found)
            {
                for(int element: array)
                {
                    System.out.print(element + " ");
                }
                System.out.println();
            }

            assertEquals(computations_found.size(), factorial(N));
        }

}
