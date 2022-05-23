public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int [][] total = new int[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++){
            for(int k = 0; k < grid[0].length; k++){
                if(i == 0 && k == 0){
                    total[i][k] = grid[i][k];
                }
                else{
                    int left = i == 0 ? Integer.MAX_VALUE : total[i - 1][k];
                    int top = k == 0 ? Integer.MAX_VALUE : total[i][k - 1];
                    total[i][k] = grid[i][k] + Integer.min(left, top);
                }
            }
        }

        return total[grid.length - 1][grid[0].length - 1];
    }
}
