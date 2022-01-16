import java.util.*;
public class KthSmallBST {
    List<Integer> list = new ArrayList<>();
    int val = 0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return val;
    }
    public void traverse(TreeNode root, int k){
        if(root == null){return;}
        traverse(root.left, k);

        list.add(root.val);

        if(list.size() == k){
            val = list.get(list.size() - 1);
        }

        traverse(root.right, k);
    }
}
