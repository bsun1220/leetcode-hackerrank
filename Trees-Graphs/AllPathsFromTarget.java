import java.util.*;
public class AllPathsFromTarget {
    List<List<Integer>> myList;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        myList = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        traverse(graph, 0, path, graph.length - 1);
        return myList;

    }
    public void traverse(int[][] graph, int start, List<Integer> path, int target){
        if(target == start){
            path.add(target);
            myList.add(path);
            return;
        }
        path.add(start);
        for(int i : graph[start]){
            traverse(graph, i, new ArrayList<Integer>(path), target);
        }
    }
}
