public class ConvertToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode head = recur(nums, 0, nums.length - 1);
        return head;
    }


    public TreeNode recur(int[] nums, int left, int right)
    {
        if(left > right){return null;}
        int mid = (left + right)/2;
        TreeNode head = new TreeNode(nums[mid]);
        head.left = recur(nums, left, mid - 1);
        head.right = recur(nums, mid + 1, right);
        return head;
    }
}
