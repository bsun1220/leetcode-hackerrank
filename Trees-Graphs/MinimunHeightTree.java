public class MinimunHeightTree {
    Map<Integer, Set<Integer>> myGraph;
    int min;
    List<Integer> minList;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n < 2){
            List<Integer> answer = new ArrayList<>();
            for(int i = 0; i < n; i++){
                answer.add(i);
            }
            return answer;
        }

        myGraph = new HashMap<>();
        makeGraph(edges, n);

        List<Integer> leaves = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(myGraph.get(i).size() == 1){
                leaves.add(i);
            }
        }

        int remainingNodes = n;
        while(remainingNodes > 2){
            remainingNodes -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(int leaf : leaves){

                int neighbor = 0;
                for(int i : myGraph.get(leaf)){
                    neighbor = i;
                }

                myGraph.get(neighbor).remove(leaf);
                if(myGraph.get(neighbor).size() == 1){
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;

        }
        return leaves;

    }

    public void makeGraph(int[][] edges, int n){
        for(int i = 0; i < n; i++){
            myGraph.put(i, new HashSet<>());
        }
        for(int i = 0; i < edges.length; i++){
            int nodeOne = edges[i][0];
            int nodeTwo = edges[i][1];

            myGraph.get(nodeOne).add(nodeTwo);
            myGraph.get(nodeTwo).add(nodeOne);

        }
    }
}
