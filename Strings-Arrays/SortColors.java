public class SortColors {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 0);
        map.put(2, 0);
        for(int i : nums){
            map.put(i, map.get(i) + 1);
        }
        int index = 0;
        for(int i = 0; i < 3; i++){
            for(int k = 0; k < map.get(i); k++){
                nums[index] = i;
                index++;
            }
        }
    }
}
