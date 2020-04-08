package tests;

import input.InputData;
import input.Matrix;
import junit.framework.TestCase;

import java.util.Map;


public class InputDataTest extends TestCase {

    public void testSplit()
    {
        InputData input = new InputData(new Matrix(5));
        Map<Integer, Map<Integer, Integer>> test_column = input.split(1,2);
        assertEquals(test_column.get(1), input.getGraph().column(1));

        test_column = input.split(3, 5);
        assertEquals(test_column.get(3), input.getGraph().column(3));
        assertEquals(test_column.get(4), input.getGraph().column(4));

        test_column = input.split(0,0);
        assertNull(test_column.get(0));

        test_column = input.split(5, 4);
        assertNull(test_column.get(5));
    }
}