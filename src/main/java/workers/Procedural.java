package workers;

import com.google.common.collect.Table;
import input.InputData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Procedural {

    private InputData input;
    private Map<Integer, int[]> path_map;
    private ArrayList<int[]> path_list;

    public Procedural(InputData input)
    {
        this.input = input;
        this.path_map = new HashMap<>();
        this.path_list = new ArrayList<>();
    }

    public ArrayList<int[]> getPath_list() {
        return path_list;
    }

    private void swap(int[] input, int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }

    public void compute_permutations()
    {
        int n = input.getN();
        int[] elements = new int[n];
        int[] indexes = new int[n];
        for(int i = 0; i < n; i++)
        {
            indexes[i] = 0;
            elements[i] = i;
        }

        this.path_list.add(elements.clone());

        int i = 0;
        while(i < n)
        {
            if(indexes[i] < i)
            {
                swap(elements, i % 2 == 0 ? 0 : indexes[i], i);
                indexes[i]++;
                i = 0;
                this.path_list.add(elements.clone());
            }
            else
            {
                indexes[i] = 0;
                i++;
            }
        }
    }

    public int compute_path_weight(int [] path)
    {
        Table<Integer, Integer, Integer> graph = this.input.getGraph();
        int n = input.getN();
        int weight = graph.get(path[n-1], path[0]);
        for(int i = 0; i < n-1; i++)
        {
            weight += graph.get(path[i], path[i+1]);
        }
        return weight;
    }

    public void load_paths_with_weight()
    {
        this.compute_permutations();
        for(int[] path: path_list)
        {
            int current_path_weight = this.compute_path_weight(path);
            path_map.put(current_path_weight, path);
        }
        for(Map.Entry<Integer, int[]> path_with_weight : path_map.entrySet())
        {
            System.out.println("Path:");
            for(int element: path_with_weight.getValue())
            {
                System.out.print(element + " ");
            }
            System.out.println();
            System.out.println("Has the weight: " + path_with_weight.getKey());
        }
    }

    public int[] shortest_cycle()
    {
        this.load_paths_with_weight();
        //TODO: workaround for this.
        Master.minValueKey(path_map);
    }

}
