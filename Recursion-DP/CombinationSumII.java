public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, candidates, target, 0, 0, new ArrayList<>(), new boolean [candidates.length]);
        return list;
    }


    public void backtrack(List<List<Integer>> list, int [] c, int target, int sum, int index, List<Integer> temp, boolean [] used){
        if(sum > target){
            return;
        }
        else if (sum == target){
            list.add(new ArrayList<>(temp));
        }
        else{
            for(int i = index; i < c.length; i++){
                if(i != index && c[i] == c[i-1] && !used[i-1]){
                    continue;
                }

                temp.add(c[i]);
                sum+=c[i];
                used[i] = true;

                backtrack(list, c, target, sum, i + 1, temp, used);

                temp.remove(temp.size() - 1);
                sum -= c[i];
                used[i] = false;

            }
        }
    }
}
