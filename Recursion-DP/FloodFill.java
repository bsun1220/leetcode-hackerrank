public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int rsize = image[0].length;
        int color = image[sr][sc];

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(sr * rsize + sc);
        visited.add(sr * rsize + sc);

        while(!q.isEmpty()){
            int cur = q.remove();
            int row = cur/rsize;
            int col = cur % rsize;

            image[row][col] = newColor;

            int upRow = (row - 1) * rsize + col;
            if(row != 0 && image[row - 1][col] == color && !visited.contains(upRow)){
                q.add(upRow);
                visited.add(upRow);
            }


            int leftCol = cur - 1;
            if(col != 0 && image[row][col - 1] == color && !visited.contains(leftCol)){
                q.add(leftCol);
                visited.add(leftCol);
            }


            int rightCol = cur + 1;
            if(col != rsize - 1 && image[row][col + 1] == color && !visited.contains(rightCol)){
                q.add(rightCol);
                visited.add(rightCol);
            }


            int downRow = (row + 1) * rsize + col;
            if(row != image.length - 1 && image[row + 1][col] == color && !visited.contains(downRow)){
                q.add(downRow);
                visited.add(downRow);
            }


        }


        return image;




    }
}
