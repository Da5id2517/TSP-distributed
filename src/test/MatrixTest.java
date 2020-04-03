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
        System.out.println(test_matrix);
        try
        {test_matrix.create_symmetrical();}
        catch (IOException e)
        {e.printStackTrace();}
        assertEquals(test_matrix, test_matrix.transpose());
        System.out.println(test_matrix);
    }
}