public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int [] arr1 = new int[nums.length - 1];
        int [] arr2 = new int[nums.length - 1];

        arr1[0] = nums[0];
        arr1[1] = Math.max(nums[0], nums[1]);
        arr2[0] = nums[1];
        arr2[1] = Math.max(nums[1], nums[2]);

        for(int i = 2; i < nums.length - 1; i++){
            arr1[i] = Math.max(arr1[i - 1], arr1[i - 2] + nums[i]);
            arr2[i] = Math.max(arr2[i - 1], arr2[i - 2] + nums[i + 1]);
        }
        return Math.max(arr1[arr1.length - 1],arr2[arr2.length - 1]);
    }
}
