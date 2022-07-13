public class RottingOrange {
    Set<Integer> rottenSet;
    int[] DIR = new int[]{0, 1, 0, -1, 0};
    public int orangesRotting(int[][] grid) {
        int numOranges = 0;
        rottenSet = new HashSet<>();
        int day = 0;
        Queue<Integer>q = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int k = 0; k < grid[0].length; k++){
                if(grid[i][k] == 1){
                    numOranges++;
                }
                else if(grid[i][k] == 2){
                    int val = i * grid[0].length + k;
                    rottenSet.add(val);
                    q.add(val);
                }
            }
        }


        while(!q.isEmpty() && numOranges != 0){
            int size = q.size();
            Set<Integer> willAdd = new HashSet<>();
            for(int i = 0; i < size; i++){
                int currentVal = q.remove();
                int row = currentVal / grid[0].length;
                int col = currentVal % grid[0].length;
                for(int k = 0; k < 4; k++){
                    if(isEligible(grid, row + DIR[k], col + DIR[k + 1])){
                        int newVal = (row + DIR[k]) * grid[0].length + col + DIR[k + 1];
                        grid[row + DIR[k]][col + DIR[k + 1]] = 2;
                        willAdd.add(newVal);
                        numOranges --;
                    }
                }
            }

            for(int i : willAdd){
                q.add(i);
                int row = i / grid[0].length;
                int col = i % grid[0].length;
            }
            day++;
        }

        if(numOranges > 0){
            return -1;
        }
        return day;


    }

    public boolean isEligible(int[][] grid, int row, int col){
        int val = row * grid[0].length + col;
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
            return false;
        }
        else if (grid[row][col] != 1){
            return false;
        }
        return true;
    }
}
