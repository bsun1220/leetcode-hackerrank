public class MaxWidth {
    List<Long> mins;
    List<Long> maxes;
    public int widthOfBinaryTree(TreeNode root) {
        mins = new ArrayList<>();
        maxes = new ArrayList<>();
        traverse(root, new StringBuilder("0"));

        int maxWidth = 0;
        for(int i = 0; i < mins.size(); i++){
            int distance = (int)(maxes.get(i) - mins.get(i));
            maxWidth = Math.max(distance, maxWidth);
        }
        return maxWidth + 1;
    }

    public void traverse(TreeNode root, StringBuilder sb){
        if(root == null){
            return;
        }
        int level = sb.length() - 1;
        if(mins.size() == level){
            mins.add(Long.MAX_VALUE);
            maxes.add(Long.MIN_VALUE);
        }

        long value = Long.parseLong(sb.toString(), 2);
        long min = Math.min(value, mins.get(level));
        long max = Math.max(value, maxes.get(level));
        mins.set(level, min);
        maxes.set(level, max);

        traverse(root.left, new StringBuilder(sb.toString() + "0"));
        traverse(root.right, new StringBuilder(sb.toString() + "1"));

    }
}
