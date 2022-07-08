public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        for(int row = 0; row < 9; row++){
            if(!checkRow(board, row)){
                return false;
            }
        }
        for(int col = 0; col < 9; col++){
            if(!checkCol(board, col)){
                return false;
            }
        }
        for(int box = 0; box < 9; box++){
            if(!checkBox(board, box)){
                return false;
            }
        }


        return true;

    }

    public boolean checkRow(char[][] board, int row){
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < 9; i++){
            if(board[row][i] == '.') continue;
            if(set.contains(board[row][i])) return false;
            set.add(board[row][i]);
        }
        return true;
    }

    public boolean checkCol(char[][] board, int col){
        Set<Character>set = new HashSet<>();
        for(int i = 0; i < 9; i++){
            if(board[i][col] == '.') continue;
            if(set.contains(board[i][col])) return false;
            set.add(board[i][col]);
        }
        return true;
    }
    public boolean checkBox(char[][] board, int box){
        int startRow = (box / 3) * 3;
        int startCol = (box % 3) * 3;
        Set<Character>set = new HashSet<>();
        for(int i = 0; i < 3; i++){
            for(int k = 0; k < 3; k++){
                char val = board[i+startRow][k+startCol];
                if(val == '.') continue;
                if(set.contains(val)) return false;
                set.add(val);
            }
        }
        return true;
    }
}
