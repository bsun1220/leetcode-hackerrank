import java.util.*;
public class isValidBST {
    public boolean isValidBST(TreeNode root) {
        if(root == null){return true;}
        ArrayList<Integer> list = new ArrayList<>();
        list = helper(root, list);
        for(int i = 0; i < list.size() - 1; i++)
        {
            if(list.get(i) >= list.get(i + 1))
            {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> helper(TreeNode root, ArrayList<Integer> list)
    {
        if(root == null){return list;}
        list = helper(root.left, list);
        list.add(root.val);
        list = helper(root.right, list);
        return list;

    }
}
