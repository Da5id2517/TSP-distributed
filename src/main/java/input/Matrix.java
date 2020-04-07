package input;

import java.util.Random;

public class Matrix {

    private int[][] data;
    private int N;

    public Matrix(int N) {
        this.N = N;
        data = new int[N][N];
        Random random = new Random();
        for (int i = 0; i < this.N; i++)
            for (int j = 0; j < i; j++) {
                data[i][j] = random.nextInt(100);
                data[j][i] = data[i][j];
            }
    }

    public int getN() {
        return N;
    }

    public int[][] getData()
    {
        return this.data;
    }
}
