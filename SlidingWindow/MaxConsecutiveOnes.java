public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int slow = 0;
        for(int fast = 0; fast < nums.length; fast++){
            if(nums[fast] == 0){
                max = Math.max(fast - slow, max);
                slow = fast + 1;
            }
        }
        if(nums[nums.length - 1] == 1){
            max = Math.max(nums.length - slow, max);
        }

        return max;
    }
}
