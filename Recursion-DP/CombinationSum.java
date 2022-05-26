public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, candidates, new ArrayList<>(), 0, target, 0);
        return list;

    }
    public void backtrack(List<List<Integer>> list, int[]c, List<Integer> temp, int sum, int target, int index){
        if(sum > target){
            return;
        }
        else if (sum == target){
            list.add(new ArrayList<>(temp));
        }
        else{
            for(int i = index; i < c.length; i++){


                temp.add(c[i]);
                sum+=c[i];

                backtrack(list, c, temp, sum, target, i);

                temp.remove(temp.size() - 1);
                sum -= c[i];

            }
        }

    }
}
