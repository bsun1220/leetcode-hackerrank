public class MinKnightMoves {
    public int minKnightMoves(int x, int y) {
        int [][] DIR = {{1, 2}, {-1, 2}, {1, -2}, {-1, -2}, {2, 1}, {-2, 1}, {2, -1}, {-2,-1}};
        Set<String> visited = new HashSet<>();
        int steps = 0;
        x = Math.abs(x);
        y = Math.abs(y);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int [] curr = q.remove();

                int currX = curr[0], currY = curr[1];
                if(currX == x && currY == y){
                    return steps;
                }

                for(int[] direct : DIR){

                    int newX = currX + direct[0];
                    int newY = currY + direct[1];
                    String combo = "" + newX + "," + newY;
                    if(!visited.contains(combo) && newX <= x + 2 && newY <= y + 2 && newX >= -2 && newY >= -2){
                        q.add(new int[] {newX, newY});
                        visited.add(combo);
                    }
                }

            }

            steps += 1;
        }


        return steps;
    }
}
