public class ConnectedComponents {
    Map<Integer, Set<Integer>> graph;
    public int findCircleNum(int[][] isConnected) {
        graph = new HashMap<>();
        makeGraph(isConnected);

        int total = 0;
        Set<Integer> visited = new HashSet<>();
        for(int i : graph.keySet()){
            System.out.println(i);
            if(!visited.contains(i)){
                Set<Integer> path = dfs(i);
                visited.addAll(path);
                total ++;
            }
        }
        return total;

    }

    public HashSet<Integer> dfs (int i){
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> s = new Stack<>();
        visited.add(i);
        s.add(i);
        while(!s.isEmpty()){
            int val = s.pop();
            Set<Integer> adj = graph.get(val);
            for(int neighbor : adj){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    s.add(neighbor);
                }
            }

        }
        return visited;

    }

    public void makeGraph(int [][] arr){
        for(int i = 0; i < arr.length; i++){
            graph.put(i, new HashSet<>());
            for(int k = 0; k < arr.length; k++){
                if(arr[i][k] == 1 && i != k){
                    graph.get(i).add(k);
                }
            }
        }
    }
}
