import java.util.*;
public class bfs {

    public static void main(String[]args){
        List<Integer> edge1 = new ArrayList<>(Arrays.asList(2,3));
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(edge1);
        List<Integer> ret = bfs(3, 1, edges, 2);
        System.out.println();
        for(int i = 0; i < ret.size(); i++){
            System.out.println(ret.get(i));
        }

    }

    static HashMap<Integer, HashSet<Integer>> myGraph = new HashMap<>();
    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        makeGraph(edges);
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(i == s){continue;}
            list.add(search(s, i));
        }
        return list;

    }
    public static int search(int start, int target){
        System.out.println("START");
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        visited.add(start);
        q.add(start);
        int distance = 1;
        while(!q.isEmpty()){
            int size = q.size();
            System.out.println("size is " + size);
            for(int i = 0; i < size; i++){
                int curr = q.remove();
                System.out.println("current is " + curr);
                if(!myGraph.containsKey(curr)){
                    return -1;
                }
                for(int k : myGraph.get(curr)){
                    System.out.println("iteration: " + i + " and num: " + k);
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

    public static void makeGraph(List<List<Integer>> edges){
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
