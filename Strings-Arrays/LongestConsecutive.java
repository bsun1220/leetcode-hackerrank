public class LongestConsecutive{
    public int longestConsecutive(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        Arrays.sort(nums);
        int max = 1;
        int run = 1;
        for(int i = 1 ;i < nums.length; i++){
            if(nums[i] - nums[i - 1] == 0){
                continue;
            }
            else if (nums[i] - nums[i - 1] == 1){
                run++;
            }
            else{
                run = 1;
            }
            max = Math.max(run, max);
        }
        return max;
    }
}