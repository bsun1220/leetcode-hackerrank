public class CombinationSumIII {
    List<List<Integer>> list;
    int numSeq, target;
    public List<List<Integer>> combinationSum3(int k, int n) {
        list = new ArrayList<>();
        numSeq = k;
        target = n;
        backtrack(new ArrayList<>(), 1, 0);
        return list;
    }

    public void backtrack(List<Integer> temp, int curr, int total){
        if(total == target && temp.size() == numSeq){
            list.add(new ArrayList<>(temp));
        }
        else if (temp.size() == numSeq ){
            return;
        }
        else{
            for(int i = curr; i <= 9; i++){
                temp.add(i);
                total+=i;
                backtrack(temp, i + 1, total);
                temp.remove(temp.size() - 1);
                total-= i;
            }
        }

    }
}
