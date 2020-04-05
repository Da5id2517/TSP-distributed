package input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Matrix {

    private int N, M;
    private ArrayList<ArrayList<Integer>> data;

    public Matrix(int N, int M)
    {
        Random random = new Random();
        this.N = N;
        this.M = M;
        data = new ArrayList<>(N);

        //consider decoupling the random number filing to a separate method.

        for(int i = 0; i < N; i++) {
            data.add(new ArrayList<>(M));
            for (int j = 0; j < M; j++) {
                data.get(i).add(j, random.nextInt(10));
            }
        }
    }

    public void create_symmetrical() throws IOException
    {
        if (M != N)
            throw new IOException("Dimensions must match!");
        for(int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if(i == j)
                {
                   ArrayList<Integer> value_of_i_row =  data.get(i);
                   value_of_i_row.set(j, 0);
                   data.set(i, value_of_i_row);
                }
                int value_of_ij = data.get(i).get(j);
                ArrayList<Integer> value_of_j_row = data.get(j);
                value_of_j_row.set(i, value_of_ij);
                data.set(j, value_of_j_row);
            }
        }
    }

    // Exists purely for testing purposes, will be removed.
    public Matrix transpose()
    {
        Matrix trasnposed = new Matrix(this.N, this.M);
        for(int i = 0; i < N; i ++)
            for(int j = 0; j < M; j ++)
            {
                int value_of_ij = this.data.get(i).get(j);
                trasnposed.data.get(j).set(i, value_of_ij);

            }
        return trasnposed;
    }

    public Matrix split(int k)
    {
        //assume that k is lesser than M;
        Matrix result = new Matrix(this.N, k);
        for(int i=0; i<this.N; i++)
            for(int j=0; j<k; j++)
            {
                int value_of_ij = data.get(i).get(j);
                ArrayList<Integer> value_of_result_ij = result.data.get(i);
                value_of_result_ij.set(j, value_of_ij);
                result.data.set(i, value_of_result_ij);
            }
        return result;
    }

    // TODO: add conversion from ArrayList to Matrix?
//    public ArrayList<Integer> getElement(int i)
//    {
//        return ;
//    }

    public int getElement(int i, int j)
    {
        return this.data.get(i).get(j);
    }

    public int getN() {
        return N;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Matrix that = (Matrix) o;
        if(this.N != that.N) return false;
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
            {
                if(!this.data.get(i).get(j).equals(that.data.get(i).get(j)))
                    return false;
            }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < N; i ++) {
            result.append("\n");
            for (int j = 0; j < M; j++) {
                result.append(data.get(i).get(j)).append("\t");
            }
        }
        return result.toString();
    }
}
