package workers;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class TSPThread extends Thread {

    private Map<Integer, Integer> sub_graph;
    private CopyOnWriteArrayList<Integer> mst_vertices;
    private Integer current_vertex;

    public TSPThread(Integer current_vertex, Map<Integer, Integer> sub_graph, CopyOnWriteArrayList<Integer> mst_vertices)
    {
        this.sub_graph = sub_graph;
        this.mst_vertices = mst_vertices;
        this.current_vertex = current_vertex;
    }

    public <K, V extends Comparable<V>> K minValueKey(Map<K, V> map) throws NoSuchElementException {
        Optional<Map.Entry<K, V>> minEntry = map.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue());
        return minEntry.get()
                .getKey();
    }

    @Override
    public void run() {
        System.out.println(current_vertex + " : " + sub_graph);

        if(mst_vertices.size() == sub_graph.size() - 1)
        {
            mst_vertices.add(current_vertex);
            return;
        }

        while(!mst_vertices.contains(current_vertex))
        {/* Active wait */}

        //remove all nodes already in the mst_vertice set
        for(Integer visited : mst_vertices)
        { sub_graph.remove(visited); }

        try
        {
            mst_vertices.add(minValueKey(sub_graph));
        } catch (NoSuchElementException e)
        {
            e.printStackTrace();
        }
    }
}
