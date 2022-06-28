public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDist = Integer.MAX_VALUE;
        int minSum = 0;
        for(int i = 0; i < nums.length; i++){
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = (nums[left] + nums[right] + nums[i]);
                int dist = target - sum;
                if(Math.abs(dist) < minDist){
                    minSum = sum;
                    minDist = Math.abs(dist);
                }
                if(dist > 0){
                    left++;
                }
                else if (dist < 0){
                    right--;
                }
                else{
                    return sum;
                }
            }
        }
        return minSum;
}
