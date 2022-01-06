import java.util.*;
public class zigzagLevelOrder {
    List<List<Integer>> ret;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ret = new ArrayList<>();
        helper(root, 0);

        return ret;
    }

    public void helper(TreeNode root, int level)
    {
        if (root == null){return;}
        if (ret.size() == level){ret.add(new ArrayList<>());}
        if(level %2 == 0)
        {
            ret.get(level).add(root.val);
        }
        else
        {
            ret.get(level).add(0, root.val);
        }
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}
