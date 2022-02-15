public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max + nums[i], nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}
