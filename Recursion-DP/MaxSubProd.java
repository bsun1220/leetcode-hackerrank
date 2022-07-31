public class MaxSubProd {
    public int maxProduct(int[] nums) {

        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            res = Math.max(res, nums[i]);
        }

        int curMin = 1, curMax = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                curMin = 1;
                curMax = 1;
                continue;
            }
            int temp = curMax * nums[i];

            curMax = Math.max(nums[i], Math.max(curMax * nums[i], curMin * nums[i]));
            curMin = Math.min(nums[i], Math.min(temp, curMin * nums[i]));

            res = Math.max(curMax, res);

        }

        return res;


    }
}
