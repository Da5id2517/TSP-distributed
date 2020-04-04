package test;

import input.Matrix;
import org.junit.Test;

import java.io.IOException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class MatrixTest {
    @Test
    public void isSymmetrical()
    {
        Random random = new Random();
        int n = random.nextInt(15);
        Matrix test_matrix = new Matrix(n,n);
        try
        {test_matrix.create_symmetrical();}
        catch (IOException e)
        {e.printStackTrace();}
        assertEquals(test_matrix, test_matrix.transpose());
    }

    @Test(expected = IOException.class)
    public void testIOException_create_symmetrical()
    {
        Matrix test_matrix = new Matrix(5,4);

        //This seems to not be working... figure it out
        assertThrows(IOException.class, test_matrix::create_symmetrical);
    }
}