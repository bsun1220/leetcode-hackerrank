public class NumIslands {
    Set<Integer> visited;
    public int numIslands(char[][] grid) {
        visited = new HashSet<>();
        int total = 0;
        for(int i = 0; i < grid.length; i++){
            for(int k = 0; k < grid[0].length; k++){
                int value = i * grid[0].length + k;
                if(!visited.contains(value) && grid[i][k] == '1'){
                    traverse(grid, i, k);
                    total++;
                }
            }
        }
        return total;


    }

    public void traverse(char[][] grid, int i, int k){
        int value = i * grid[0].length + k;
        if(i < 0 || visited.contains(value) || i >= grid.length || k < 0 || k >= grid[0].length || grid[i][k] == '0'){
            return;
        }
        visited.add(value);

        traverse(grid, i + 1, k);
        traverse(grid, i - 1, k);
        traverse(grid, i, k + 1);
        traverse(grid, i, k - 1);
    }
}
