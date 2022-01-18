import java.util.*;
public class BipartiteGraph {
    HashSet<Integer> blueVisited;
    HashSet<Integer> redVisited;
    HashMap<Integer, Boolean> map;
    int[][]myGraph;
    public boolean isBipartite(int[][] graph){

        blueVisited = new HashSet<>();
        redVisited = new HashSet<>();
        map = new HashMap<>();
        myGraph = graph;

        for(int i = 0; i < graph.length; i++){
            bfs(i);
        }
        blueVisited.retainAll(redVisited);
        return blueVisited.size() == 0;
    }

    public void bfs(int start){
        if(blueVisited.contains(start) || redVisited.contains(start)){
            return;
        }
        if(start >= myGraph.length){
            blueVisited.add(start);
            return;
        }
        Stack<Integer> s = new Stack<>();
        s.add(start);
        blueVisited.add(start);
        map.putIfAbsent(start, true);
        while(!s.isEmpty()){
            int curr = s.pop();
            for(int i : myGraph[curr]){
                if(map.get(curr) && !blueVisited.contains(i)){
                    redVisited.add(i);
                    map.putIfAbsent(i, false);
                    s.add(i);
                }
                else if(!map.get(curr) && !blueVisited.contains(i)){
                    blueVisited.add(i);
                    map.putIfAbsent(i, true);
                    s.add(i);
                }
            }
        }

    }
}
