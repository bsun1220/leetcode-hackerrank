public class JumpGame {
    public boolean canJump(int[] nums) {

        boolean [] dp = new boolean[nums.length];
        dp[0] = true;
        for(int i = 0; i < nums.length; i++){
            if(dp[i] == false) continue;
            if(i == nums.length - 1){
                return true;
            }

            for(int k = 1; k <= nums[i] && i + k < nums.length; k++){
                dp[i + k] = true;
            }

        }

        return false;

    }
}
