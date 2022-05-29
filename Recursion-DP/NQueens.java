public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();

        List<String> start = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String row = new String(new char[n]).replace("\0", ".");
            start.add(row);
        }
        backtrack(list, start, 0, 0);

        return list;

    }
    public void backtrack(List<List<String>> list, List<String>board, int index, int nQ){
        int n = board.size();

        if(nQ == n){
            list.add(new ArrayList<>(board));
        }

        for(int i = index; i < n * n; i++){
            int row = i/n;
            int col = i%n;

            if(!(check(board, row, col))){
                continue;
            }

            String s = board.get(row).substring(0, col) + 'Q' + board.get(row).substring(col + 1);
            board.set(row, s);
            backtrack(list, board, i + 1, nQ + 1);
            s = board.get(row).substring(0, col) + '.' + board.get(row).substring(col + 1);
            board.set(row, s);

        }

    }

    public boolean check(List<String> board, int row, int col){
        for(int i = 0; i < board.size(); i++){
            if(board.get(i).charAt(col) == 'Q' && i != row){
                return false;
            }
        }
        for(int i = 0; i < board.size(); i++){
            if(board.get(row).charAt(i) == 'Q' && i != col){
                return false;
            }
        }
        int new_row = row + 1;
        int new_col = col + 1;
        while(new_row < board.size() && new_col < board.size()){
            if(board.get(new_row).charAt(new_col) == 'Q'){
                return false;
            }
            new_row++;
            new_col++;
        }

        new_row = row - 1;
        new_col = col + 1;
        while(new_row >= 0 && new_col < board.size()){
            if(board.get(new_row).charAt(new_col) == 'Q'){
                return false;
            }
            new_row--;
            new_col++;
        }

        new_row = row - 1;
        new_col = col - 1;
        while(new_row >= 0 && new_col >= 0){
            if(board.get(new_row).charAt(new_col) == 'Q'){
                return false;
            }
            new_row--;
            new_col--;
        }

        new_row = row + 1;
        new_col = col - 1;
        while(new_row< board.size() && new_col >= 0){
            if(board.get(new_row).charAt(new_col) == 'Q'){
                return false;
            }
            new_row++;
            new_col--;
        }
        return true;

    }
}
