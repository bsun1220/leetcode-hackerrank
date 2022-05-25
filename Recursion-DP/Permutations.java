public class Permutations {
    List<List<Integer>> list;
    int [] n;
    public List<List<Integer>> permute(int[] nums) {
        list = new ArrayList<>();
        n = nums;
        backtrack(new ArrayList<>());
        return list;

    }
    public void backtrack(List<Integer> temp){
        if(temp.size() == n.length){
            list.add(new ArrayList<>(temp));
        }
        else{
            for(int i = 0; i < n.length; i++){
                if(temp.contains(n[i])) continue;
                temp.add(n[i]);
                backtrack(temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
