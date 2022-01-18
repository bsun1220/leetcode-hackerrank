import java.util.*;

public class Ograph {
    HashMap<String, HashSet<String>> myGraph;
    HashSet<String> myVisited;
    public int[] components(String[] data) {
        myGraph = new HashMap<>();
        myVisited = new HashSet<>();
        List<Integer> ret = new ArrayList<>();
        makeGraph(data);
        for(String node : myGraph.keySet()){
            if(!myVisited.contains(node)){
                Set<String> set = bfs(node);
                myVisited.addAll(set);
                ret.add(set.size());
            }
        }

        int[] fin = ret.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(fin);
        return fin;

    }
    public Set<String> bfs(String start){
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        visited.add(start);
        q.add(start);
        while(!q.isEmpty()){
            String key = q.remove();
            for(String adj: myGraph.get(key)){
                if(!visited.contains(adj)){
                    visited.add(adj);
                    q.add(adj);
                }
            }
        }
        return visited;
    }

    public void makeGraph(String[] data){
        for(int i = 0; i < data.length; i++){
            String[] line = data[i].split(" ");
            String index = "" + i;
            for(String k : line){
                myGraph.putIfAbsent(k, new HashSet<>());
                myGraph.putIfAbsent(index, new HashSet<>());
                myGraph.get(k).add(index);
                myGraph.get(index).add(k);
            }
        }
    }
}
