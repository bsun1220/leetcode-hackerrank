import java.util.*;
public class BFS {

    public static void main(String[]args){
        List<Integer> edge1 = new ArrayList<>(Arrays.asList(1,2));
        List<Integer> edge2 = new ArrayList<>(Arrays.asList(1,3));
        List<Integer> edge3 = new ArrayList<>(Arrays.asList(3,4));
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(edge1);
        edges.add(edge2);
        edges.add(edge3);

        List<Integer> ret = bfs(5, 3, edges, 1);

    }

    static HashMap<Integer, HashSet<Integer>> myGraph = new HashMap<>();
    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= m; i++){
            if(i == s){continue;}
            list.add(search(i, s));
        }
        return list;

    }
    public static int search(int start, int target){
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        visited.add(start);
        q.add(start);
        int distance = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int curr = q.remove();
                for(int k : myGraph.get(curr)){
                    if(k == target){
                        return distance * 6;
                    }
                    else if(!visited.contains(k)){
                        q.add(k);
                        visited.add(k);
                    }
                }
            }
            distance++;
        }
        return -1;
    }

    public void makeGraph(List<List<Integer>> edges){
        for(int i = 0; i < edges.size(); i++){
            int first = edges.get(i).get(0);
            int second = edges.get(i).get(1);
            myGraph.putIfAbsent(first, new HashSet<>());
            myGraph.putIfAbsent(second, new HashSet<>());
            myGraph.get(first).add(second);
            myGraph.get(second).add(first);
        }
    }
}
