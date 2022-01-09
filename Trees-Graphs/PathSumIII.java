import java.util.*;
public class PathSumIII {
    Integer mySum;
    public int pathSum(TreeNode root, int targetSum) {

        if(root == null){return 0;}

        mySum = 0;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty())
        {
            TreeNode curr = s.pop();
            addsUp(curr, targetSum);
            if(curr.left !=null){s.push(curr.left);}
            if(curr.right !=null){s.push(curr.right);}
        }

        return mySum;
    }
    public void addsUp(TreeNode root, int targetsum)
    {
        if(root == null){return;}
        if(targetsum - root.val == 0){mySum++;}
        addsUp(root.left, targetsum - root.val);
        addsUp(root.right, targetsum - root.val);
    }
}
