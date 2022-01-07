public class LeastCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){return null;}

        if(root.val == p.val || root.val == q.val){return root;}

        boolean leftCheck = isFound(root.left, p, q);
        boolean rightCheck = isFound(root.right, p, q);

        if(leftCheck && rightCheck){return root;}

        TreeNode iterator = leftCheck ? root.left : root.right;
        return lowestCommonAncestor(iterator, p, q);

    }

    public boolean isFound(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root == null){return false;}
        if(root.val == p.val || root.val == q.val){return true;}
        return isFound(root.left, p, q) || isFound(root.right, p, q);
    }
}
