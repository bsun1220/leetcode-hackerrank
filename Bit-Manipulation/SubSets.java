public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        int length = (int)(Math.pow(2, nums.length));
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < length; i++){
            list.add(new ArrayList<>());
            for(int k = 0; k < nums.length; k++){
                int index = (i >> k)&1;
                if(index == 1){
                    list.get(list.size() - 1).add(nums[k]);
                }
            }
        }
        return list;
    }
}
