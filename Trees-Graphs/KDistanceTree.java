public class KDistanceTree {
    Map<Integer, Set<Integer>> myGraph;
    List<Integer> list;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        myGraph = new HashMap<>();
        makeGraph(root);
        list = new ArrayList<>();
        bfs(target.val, k);

        return list;
    }

    public void bfs(int target, int k){
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(target);
        visited.add(target);
        int index = 0;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                temp.add(q.remove());
            }
            if(index == k){
                list.addAll(temp);
                return;
            }

            for(int curr : temp){
                for(int neighbors : myGraph.get(curr)){
                    if(!visited.contains(neighbors)){
                        visited.add(neighbors);
                        q.add(neighbors);
                    }
                }
            }
            index++;
        }
    }

    public void makeGraph(TreeNode root){
        if(root == null){
            return;
        }

        if(!myGraph.containsKey(root.val)){
            myGraph.put(root.val, new HashSet<>());
        }

        if(root.left != null){
            if(!myGraph.containsKey(root.left.val)){
                myGraph.put(root.left.val, new HashSet<>());
            }
            myGraph.get(root.left.val).add(root.val);
            myGraph.get(root.val).add(root.left.val);
            makeGraph(root.left);
        }

        if(root.right != null){
            if(!myGraph.containsKey(root.right.val)){
                myGraph.put(root.right.val, new HashSet<>());
            }
            myGraph.get(root.right.val).add(root.val);
            myGraph.get(root.val).add(root.right.val);
            makeGraph(root.right);
        }

    }
}
