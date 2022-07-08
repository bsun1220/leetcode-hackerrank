public class SpiralMatrix {
    List<Integer>list;
    public List<Integer> spiralOrder(int[][] matrix) {
        // firstRow lastColumn lastRow firstColumn
        int upLimit = 0, downLimit = matrix.length - 1;
        int leftLimit = 0, rightLimit = matrix[0].length - 1;
        list = new ArrayList<>();
        int length = matrix.length * matrix[0].length;

        while(list.size() < length){
            if(list.size() < length){
                goRight(leftLimit, rightLimit, upLimit, matrix);
                upLimit++;
            }

            if(list.size() < length){
                goDown(upLimit, downLimit, rightLimit, matrix);
                rightLimit--;
            }

            if(list.size() < length){
                goLeft(rightLimit, leftLimit, downLimit, matrix);
                downLimit--;
            }

            if(list.size() < length){
                goUp(downLimit, upLimit, leftLimit, matrix);
                leftLimit++;
            }
        }

        return list;


    }

    public void goRight(int startCol, int endCol, int row, int[][] matrix){
        for(int i = startCol; i <= endCol; i++){
            list.add(matrix[row][i]);
        }
    }

    public void goDown(int startRow, int endRow, int col, int[][] matrix){
        for(int i = startRow; i <= endRow; i++){
            list.add(matrix[i][col]);
        }
    }

    public void goLeft(int startCol, int endCol, int row, int[][] matrix){
        for(int i = startCol; i >= endCol; i--){
            list.add(matrix[row][i]);
        }
    }

    public void goUp(int startRow, int endRow, int col, int[][] matrix){
        for(int i = startRow; i >= endRow; i--){
            list.add(matrix[i][col]);
        }
    }
}
