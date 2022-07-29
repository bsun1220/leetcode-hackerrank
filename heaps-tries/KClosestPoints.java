public class KClosestPoints {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((num1, num2) -> Integer.compare(

                -(int)(Math.pow(num1[0], 2) + Math.pow(num1[1], 2)),
                -(int)(Math.pow(num2[0], 2) + Math.pow(num2[1], 2))));

        for(int i = 0; i < points.length; i++){
            pq.add(points[i]);
            if(pq.size() > k){
                pq.remove();
            }
        }

        int ret [][] = new int[k][2];
        int index = 0;
        while(!pq.isEmpty()){
            ret[index] = pq.remove();
            index++;
        }
        return ret;


    }
}
