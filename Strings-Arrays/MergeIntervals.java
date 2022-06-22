public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1){
            return intervals;
        }
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        int index = 1;
        int [] temp = intervals[0];
        while(index < intervals.length){
            if(temp[1] >= intervals[index][0]){
                int first = temp[0];
                int second = Math.max(temp[1], intervals[index][1]);
                temp = new int []{first, second};
            }
            else{
                list.add(temp);
                temp = intervals[index];
            }
            index++;

        }
        int [] lastElement = intervals[intervals.length - 1];
        int first = Math.min(temp[0], lastElement[0]);
        int second = Math.max(temp[1], lastElement[1]);
        list.add(new int[]{first, second});

        int[][] ret = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            ret[i] = list.get(i);
        }
        return ret;

    }
}
