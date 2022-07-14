public class WordSearch {
    int[] DIR = new int[]{0, 1, 0, -1, 0};
    boolean check;
    char[][] myBoard;
    String myWord;
    public boolean exist(char[][] board, String word) {
        check = false;
        myBoard = board;
        myWord = word;

        for(int i = 0; i < board.length; i++){
            for(int k = 0; k < board[0].length; k++){
                boolean[][] used = new boolean[board.length][board[0].length];
                backtrack(i, k, used, new StringBuilder());
            }
        }
        return check;
    }

    public void backtrack(int row, int col, boolean[][]used, StringBuilder sb){
        if(sb.toString().equals(myWord)){
            check = true;
            return;
        }
        else if(row < 0 || row >= myBoard.length || col < 0 || col >= myBoard[0].length){
            return;
        }
        else if(used[row][col]){
            return;
        }
        else if (myWord.startsWith(sb.toString())){
            for(int i = 0; i < 4; i++){
                sb.append(myBoard[row][col]);
                used[row][col] = true;
                int newRow = row + DIR[i];
                int newCol = col + DIR[i + 1];
                backtrack(newRow, newCol, used, sb);
                used[row][col] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }
}
