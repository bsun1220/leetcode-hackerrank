public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        Queue<Integer> q = new LinkedList<>();
        int run = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                run++;
            }
            else{
                q.add(i);
                if(q.size() > k){
                    run = i - q.remove();
                }
                else{
                    run++;
                }
            }
            max = Math.max(max, run);
        }
        return max;
    }
}
