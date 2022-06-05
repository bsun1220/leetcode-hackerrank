public class CountWays {
    public static int countWays(List<Integer> nums) {
        int total = 0;
        int numsTotal = getSum(nums, 0, nums.size() - 1);
        for(int i = 1; i < nums.size() - 1; i++){
            for(int j = i + 1; j < nums.size(); j++){
                int sum1 = getSum(nums, 0 , i);
                int sum2 = getSum(nums, i, j);
                int sum3 = getSum(nums, j, nums.size());
                if(sum2 <= sum1 + sum3){
                    total++;
                }
            }
        }
        return total % ((int)(Math.pow(10, 9)) + 7);

    }

    public static int getSum(List<Integer>list, int start, int end){
        int sum = 0 ;
        for(int i = start; i < end; i++){
            sum += list.get(i);
        }
        return sum;
    }
}
