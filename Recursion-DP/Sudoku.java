public class Sudoku {
    public void solveSudoku(char[][] board) {
        solve(board, 0,0);
    }
    public boolean solve(char[][] board, int row, int col){
        for(int i = row; i < 9; i++, col = 0){
            for(int j = col; j < 9; j++){
                if(board[i][j] != '.') continue;
                for(char a = '1'; a <= '9'; a++){
                    if(isValid(board, i, j, a)){
                        board[i][j] = a;
                        if(solve(board, row, col + 1)){
                            return true;
                        }
                    }
                    board[i][j] = '.';
                }
                return false;
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char num){
        int blkrow = (row/3) * 3, blkcol = (col/3)*3;
        for(int i = 0; i < 9; i++){
            if(board[row][i] == num || board[i][col] == num || board[blkrow + i/3][blkcol + i%3] == num){
                return false;
            }
        }
        return true;
    }
}
