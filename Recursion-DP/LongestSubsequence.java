public class LongestSubsequence {
    public int lengthOfLIS(int[] nums) {
        int [] ret = new int[nums.length];
        int max = 1;
        Arrays.fill(ret, 1);
        for(int i = nums.length - 1; i >= 0; i--){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] < nums[j]){
                    ret[i] = Math.max(ret[i], 1 + ret[j]);
                }
            }
            max = Math.max(max, ret[i]);
        }
        return max;

    }
}
