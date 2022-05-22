public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int [][] grid = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    grid[i][j] = 0;
                }
                else if(i == 0 && j == 0){
                    grid[i][j] = 1;
                }
                else{
                    int top = i == 0 ? 0 : grid[i - 1][j];
                    int left = j == 0 ? 0 : grid[i][j - 1];
                    grid[i][j] = top + left;
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
