public class SearchMatrix2D {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = 0;
        while(row < matrix.length - 1){
            if(matrix[row][col] <= target && target < matrix[row + 1][col]){
                break;
            }
            row++;
        }
        while(col < matrix[0].length){
            if(matrix[row][col] == target){
                return true;
            }
            if(col != 0 && target > matrix[row][col - 1] && target < matrix[row][col]){
                return false;
            }
            col++;
        }
        return false;
    }
}
