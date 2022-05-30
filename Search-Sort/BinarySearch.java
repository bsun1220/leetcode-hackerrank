public class BinarySearch {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public int binarySearch(int [] nums, int target, int low, int high){
        if (low > high){
            return -1;
        }
        int mid = (low + high)/2;
        if(nums[mid] < target){
            return binarySearch(nums, target, mid + 1, high);
        }
        else if (nums[mid] > target){
            return binarySearch(nums, target, low, mid - 1);
        }
        else{
            return mid;
        }
    }
}
