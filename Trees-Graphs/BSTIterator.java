import java.util.*;
class BSTIterator {

    Queue<Integer> list;
    public BSTIterator(TreeNode root) {
        list = new LinkedList<>();
        traverse(root);

    }
    public void traverse(TreeNode root){
        if(root == null){return;}
        traverse(root.left);
        list.add(root.val);
        traverse(root.right);
    }

    public int next() {
        if(list.size() != 0){
            return list.remove();
        }
        return 0;
    }

    public boolean hasNext() {
        return list.size() > 0;
    }
}
