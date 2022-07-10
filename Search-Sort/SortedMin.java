public class SortedMin {
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        else if (nums.length == 2){
            return Math.min(nums[0], nums[1]);
        }

        int left = 0, right = nums.length - 1;
        while(true){
            int mid = (left + right)/2;

            int midRight = mid + 1 >= nums.length ? 0 : mid + 1;
            int midLeft = mid - 1 < 0 ? nums.length - 1 : mid - 1;

            if(nums[mid] < nums[midRight] && nums[mid] < nums[midLeft]){
                return nums[mid];
            }
            else if(nums[mid] > nums[right]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
    }
}
