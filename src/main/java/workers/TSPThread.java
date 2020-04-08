package workers;

import java.util.Map;

public class TSPThread extends Thread {

    private Map<Integer, Map<Integer, Integer>> sub_graph;

    public TSPThread(Map<Integer, Map<Integer, Integer>> sub_graph)
    {
        this.sub_graph = sub_graph;
    }

    @Override
    public void run() {
        System.out.println(sub_graph);
    }
}
