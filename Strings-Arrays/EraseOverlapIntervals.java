public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int total = 0;
        for(int i = 1; i < intervals.length; i++){
            int[] right = intervals[i];
            int[] left = intervals[i - 1];
            if (left[0] == right[0] || left[1] > right[0]){
                intervals[i] = left[1] <= right[1] ? left : right;
                total++;
            }
        }
        return total;
    }
}
