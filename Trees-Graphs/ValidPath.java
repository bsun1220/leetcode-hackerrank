import java.util.*;

public class ValidPath {
    HashMap<Integer, Set<Integer>>myGraph;
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(start == end){return true;}
        myGraph = new HashMap<>();
        makeGraph(n, edges);
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        visited.add(start);
        q.add(start);

        while(!q.isEmpty())
        {
            int v = q.remove();
            for(int i : myGraph.get(v))
            {
                if(i == end)
                {
                    return true;
                }
                if(!visited.contains(i))
                {
                    visited.add(i);
                    q.add(i);
                }
            }
        }

        return false;

    }

    public void makeGraph(int n, int[][] edge)
    {
        for(int i = 0; i < edge.length; i++)
        {
            int val1 = edge[i][0];
            int val2 = edge[i][1];
            myGraph.putIfAbsent(val1, new HashSet<Integer>());
            myGraph.putIfAbsent(val2, new HashSet<Integer>());
            myGraph.get(val1).add(val2);
            myGraph.get(val2).add(val1);
        }
    }
}
