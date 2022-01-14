public class RootToLeave {
    int sum;
    public int sumNumbers(TreeNode root) {
        if(root == null){return 0;}
        sum = 0;
        helper(root, "");
        return sum;
    }
    public void helper(TreeNode root, String len){
        if(root == null){return;}
        len += root.val;
        if(root.left == null && root.right == null){
            sum += Integer.parseInt(len);
        }
        else{
            helper(root.left, len);
            helper(root.right, len);
        }
    }
}
