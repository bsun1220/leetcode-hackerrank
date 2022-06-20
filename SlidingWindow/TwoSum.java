public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int slow = 0;
        int fast = numbers.length - 1;
        while(true){
            if(numbers[fast] + numbers[slow] > target){
                fast--;
            }
            else if (numbers[fast] + numbers[slow] < target){
                slow++;
            }
            else{
                return new int[] {slow + 1, fast + 1};
            }
        }
}
