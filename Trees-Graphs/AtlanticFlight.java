public class AtlanticFlight {
    int[]DIR = new int[]{0,1,0,-1,0};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<>();
        if(heights == null || heights.length == 0 || heights[0].length == 0){
            return list;
        }
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for(int i = 0; i < m; i++){
            dfs(heights, pacific, Integer.MIN_VALUE, i, 0);
            dfs(heights, atlantic, Integer.MIN_VALUE, i, n - 1);
        }
        for(int i = 0; i < n; i++){
            dfs(heights, pacific, Integer.MIN_VALUE, 0, i);
            dfs(heights, atlantic, Integer.MIN_VALUE, m - 1, i);
        }
        for(int i = 0; i < m; i++){
            for(int k = 0; k < n; k++){
                if(atlantic[i][k] && pacific[i][k]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(k);
                    list.add(temp);
                }
            }
        }
        return list;
    }

    public void dfs(int[][]heights, boolean[][]visited, int height, int row, int col){
        int m = heights.length;
        int n = heights[0].length;
        if(row < 0 || col < 0 || row >= m || col >= n){
            return;
        }
        if(visited[row][col] || heights[row][col] < height){
            return;
        }
        visited[row][col] = true;
        for(int i = 0; i < 4; i++){
            dfs(heights, visited, heights[row][col], row + DIR[i], col + DIR[i + 1]);
        }
    }
}
