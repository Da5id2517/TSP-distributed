package test;

import input.Matrix;
import junit.framework.TestCase;

import java.io.IOException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class MatrixTest extends TestCase {

    private Matrix test_matrix_symmetrical;

    @Override
    public void setUp() {
        Random random = new Random();
        int n = random.nextInt(15);
        test_matrix_symmetrical = new Matrix(n, n);
        try {
            test_matrix_symmetrical.create_symmetrical();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testIsSymmetrical()
    {
        assertEquals(test_matrix_symmetrical, test_matrix_symmetrical.transpose());
    }

    public void testIOException_create_symmetrical()
    {
        Matrix test_matrix = new Matrix(5,4);
        assertThrows(IOException.class, test_matrix::create_symmetrical);
        // don't use @Test(expected = exception_class) with assertThrows!
    }

    public void testSplit()
    {
        // k == 0
        // k > M
        // cases above ignored for now.

        System.out.println(test_matrix_symmetrical);
        System.out.println(test_matrix_symmetrical.split(1));
        // assertEquals(test_matrix_symmetrical.split(1), test_matrix_symmetrical.getElement(1));
    }

    //TODO: add teardown
}