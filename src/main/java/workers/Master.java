package workers;


import input.InputData;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;


public class Master {

    private InputData input;
    private CopyOnWriteArrayList<Integer> mst_vertices_distributed;
    private CopyOnWriteArrayList<Integer> mst_vertices_procedural;

    public static <K, V extends Comparable<V>> K minValueKey(Map<K, V> map) {
        Optional<Map.Entry<K, V>> minEntry = map.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue());
        return minEntry.map(Map.Entry::getKey).orElse(null);
    }

    public Master(
            InputData input,
            CopyOnWriteArrayList<Integer> mst_vertices_procedural,
            CopyOnWriteArrayList<Integer> mst_vertices_distributed)
    {
        this.input = input;
        this.mst_vertices_distributed = mst_vertices_distributed;
        this.mst_vertices_procedural = mst_vertices_procedural;
    }

    public CopyOnWriteArrayList<Integer> compute_distributed_path()
    {
        int N = this.input.getN();
        for(int i=0; i < N; i++)
        {
            TSPThread thread = new TSPThread(
                    i,
                    input.getGraph().columnMap().get(i),
                    mst_vertices_distributed);
            thread.start();
        }
        while(mst_vertices_distributed.size() != N)
        {/* Active wait */}
        System.out.println("The shortest path is: " + mst_vertices_distributed);
        return mst_vertices_distributed;
    }

    public CopyOnWriteArrayList<Integer> compute_procedural_path(int vertex)
    {
        //TODO: one return is overkill, not sure which one doe.

        Map<Integer, Integer> columnMap = input.getGraph().columnMap().get(vertex);
        Map<Integer, Integer> notVisitedColumnMap = new HashMap<>();
        for(Integer key: columnMap.keySet())
        {
            if(!mst_vertices_procedural.contains(key))
            {
                notVisitedColumnMap.put(key, columnMap.get(key));
            }
        }
        if(notVisitedColumnMap.size() == 0)
            return mst_vertices_procedural;
        Integer minimal_value_key = minValueKey(notVisitedColumnMap);
        if(minimal_value_key != null)
        {
            mst_vertices_procedural.add(minimal_value_key);
            mst_vertices_procedural = compute_procedural_path(minimal_value_key);
        }
        else {
            mst_vertices_procedural.add(vertex);
            return mst_vertices_procedural;
        }
        return this.mst_vertices_procedural;
    }
}
