public class InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int [] toAdd = newInterval;
        List<int[]> ans = new ArrayList<>();
        for(int i = 0; i< intervals.length; i++){
            if(intervals[i][0] > newInterval[1]){
                ans.add(toAdd);
                toAdd = intervals[i];
            }
            else if (intervals[i][1] >= toAdd[0]){
                toAdd = new int[]{Math.min(
                        intervals[i][0], toAdd[0]),
                        Math.max(intervals[i][1], toAdd[1])};
            }
            else{
                ans.add(intervals[i]);
            }
        }
        ans.add(toAdd);
        return ans.toArray(new int[ans.size()][2]);


    }
}
