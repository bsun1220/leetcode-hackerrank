public class SubsetsII {
    List<List<Integer>> list;
    int [] n;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        list = new ArrayList<>();
        Arrays.sort(nums);
        n = nums;
        backtrack(new ArrayList<>(), 0);
        return list;
    }

    public void backtrack(List<Integer> temp, int start){
        list.add(new ArrayList<>(temp));
        for(int i = start; i < n.length; i++){
            if(i > start && n[i] == n[i-1]){
                continue;
            }
            temp.add(n[i]);
            backtrack(temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
