public class PruneTree {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode left = pruneTree(root.left);
        TreeNode right = pruneTree(root.right);

        if(left == null && right == null && root.val == 0){
            return null;
        }
        return new TreeNode(root.val, left, right);
    }
}
