public class KthLargest {
    List<Integer> list;
    int kVal;

    public KthLargest(int k, int[] nums) {
        Arrays.sort(nums);
        list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            list.add(nums[i]);
        }

        kVal = k;
    }

    public int add(int val) {
        list.add(val);
        Collections.sort(list);
        return list.get(list.size() - kVal);
    }
}
