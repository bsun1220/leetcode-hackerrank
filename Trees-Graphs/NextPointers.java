import java.util.*;

public class NextPointers {
    public TreeNode connect(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){return root;}

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int size = 1;
        Node prev = null;

        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            size--;
            if(prev != null){
                prev.next = curr;
            }
            if(curr.left != null){
                q.add(curr.left);
                q.add(curr.right);
            }
            if(size == 0){
                size = q.size();
                prev = null;
            }
            else{
                prev = curr;
            }

        }


        return root;
    }
}
