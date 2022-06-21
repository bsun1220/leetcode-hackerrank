public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        if(nums.length < 3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        int index = 0;
        while(index < nums.length && nums[index] <= 0){
            int target = nums[index] * -1;
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = index + 1; i < nums.length; i++){
                int needed = target - nums[i];
                if(map.containsKey(needed) && map.get(needed) != i){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[index]);
                    temp.add(nums[map.get(needed)]);
                    temp.add(nums[i]);
                    set.add(temp);

                }
                map.put(nums[i], i);
            }
            index++;
        }
        List<List<Integer>> list = new ArrayList<>();
        for(List<Integer> s : set){
            list.add(s);
        }

        return list;
    }
}
