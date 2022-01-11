public class BinaryTilt {
    int sum;
    public int findTilt(TreeNode root) {
        if(root == null){return 0;}
        helper(root, 0);
        return sum;
    }
    public int helper(TreeNode root, int cum){
        if(root == null){return 0;}
        int left = helper(root.left, cum);
        int right = helper(root.right, cum);

        sum+= Math.abs(right - left);

        return cum + left + right + root.val;

    }
}
