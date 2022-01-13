import java.util.*;

public class PathSumII {
    List<List<Integer>> list;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        list = new ArrayList<>();
        target = targetSum;
        traverse(new ArrayList<>(), 0, root);
        return list;

    }
    public void traverse(List<Integer> path, int sum, TreeNode root){
        if(root == null){return;}

        sum+=root.val;
        path.add(root.val);

        if(root.left == null && root.right == null && sum == target){
            list.add(path);
        }
        traverse(new ArrayList<Integer>(path), sum, root.left);
        traverse(new ArrayList<Integer>(path), sum, root.right);

    }
}
