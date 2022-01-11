public class RecoverBST {
    TreeNode prev;
    TreeNode vio1;
    TreeNode vio2;
    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = vio1.val;
        vio1.val = vio2.val;
        vio2.val = temp;
    }
    public void traverse(TreeNode root){
        if(root == null){return;}
        traverse(root.left);
        if(prev != null && prev.val > root.val){
            if(vio1 == null){
                vio1 = prev;
            }
            vio2 = root;
        }

        prev = root;
        traverse(root.right);

    }
}
