public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums.length == 1){
            return;
        }

        int toReplace = Integer.MAX_VALUE;
        int toReplaceIndex = -1;
        int sortedIndex = -1;
        for(int i = 0; i < nums.length; i++){
            if(i != nums.length - 1 && nums[i] < nums[i + 1]){
                sortedIndex = i;
                toReplace = nums[i + 1];
                toReplaceIndex = i + 1;

            }
            else if(sortedIndex != -1 && nums[i] > nums[sortedIndex]){
                toReplace = Math.min(toReplace, nums[i]);
                toReplaceIndex = i;
            }
        }

        if(sortedIndex == -1){
            Arrays.sort(nums);
            return;
        }

        int temp = nums[sortedIndex];
        nums[sortedIndex] = nums[toReplaceIndex];
        nums[toReplaceIndex] = temp;

        List<Integer> list = new ArrayList<>();

        for(int i = sortedIndex + 1; i < nums.length; i++){
            list.add(nums[i]);
        }
        Collections.sort(list);
        for(int i = sortedIndex + 1; i < nums.length; i++){
            nums[i] = list.get(i - sortedIndex - 1);
        }

    }
}
